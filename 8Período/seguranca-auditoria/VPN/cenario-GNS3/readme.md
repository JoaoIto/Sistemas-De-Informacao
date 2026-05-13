# Análise da Arquitetura e Cenário (GNS3)

<img width="1196" height="977" alt="image" src="https://github.com/user-attachments/assets/f48dcc29-54eb-451a-bcc5-5d9ddc2802f4" />

<img width="265" height="215" alt="image" src="https://github.com/user-attachments/assets/ee5d9584-03ee-4382-8061-76e8035951da" />


O laboratório simula a interligação de duas filiais corporativas (São Paulo - SP e Rio de Janeiro - RJ) através da Internet. Utilizaremos roteadores Cisco (Cisco IOS) e VPCS (Virtual PC Simulator) no ambiente GNS3.

### Fase 1: Inicialização e Validação do Ambiente GNS3

Com a topologia em execução e todos os nós ativos (indicadores verdes) no GNS3, o primeiro passo da documentação técnica é estabelecer a conectividade base. O painel de resumo da topologia confirma que os consoles de acesso aos equipamentos já estão mapeados via Telnet em portas locais, como a porta 5002 para o roteador SP e 5010 para o roteador RJ.

Nesta fase, o objetivo é garantir que a infraestrutura de rede subjacente esteja funcional antes de aplicarmos a camada de tunelamento e criptografia.

#### 1. Configuração do Endereçamento Físico (Roteadores de Borda)

O acesso aos consoles dos roteadores SP e RJ permitirá a configuração de suas interfaces físicas.

* **Roteador SP (São Paulo):**
* **Interface WAN (Externa):** Deve receber o endereço IP público `200.31.27.2` com máscara de sub-rede `/30` (255.255.255.252).
* **Interface LAN (Interna):** Deve ser configurada com o endereço `192.168.10.254` e máscara `/24` (255.255.255.0), atuando como o gateway da rede local 1.


* **Roteador RJ (Rio de Janeiro):**
* **Interface WAN (Externa):** Deve receber o endereço IP público `200.87.13.2` com máscara de sub-rede `/30` (255.255.255.252).
* **Interface LAN (Interna):** Deve ser configurada com o endereço `192.168.20.254` e máscara `/24` (255.255.255.0), atuando como o gateway da rede local 2.



#### 2. Configuração do Nó "Internet" (Roteamento de Trânsito)

Para que a simulação reflita o mundo real, o nó denominado `Internet` (acessível via Telnet na porta 5008) deve ser configurado como um roteador de trânsito.

* **Interfaces do Provedor:** O nó `Internet` precisa ter interfaces conectadas nos mesmos barramentos `/30` dos roteadores SP e RJ, recebendo, por exemplo, os IPs finais `.1` das respectivas redes `200.31.27.0/30` e `200.87.13.0/30`.
* **Roteamento:** É estritamente necessário garantir que exista rota estática ou dinâmica neste nó central para que o IP `200.31.27.2` consiga alcançar o IP `200.87.13.2` e vice-versa. Este nó *não* deve ter rotas para as redes privadas 192.168.x.x.

#### 3. Configuração dos Endpoints (Hosts)

Os dispositivos finais também estão operacionais e acessíveis via Telnet (portas 5004 e 5006).

* **Host SP (`192.168.10.100`):** Requer a atribuição do endereço IP estático e a definição estrita do seu gateway apontando para `192.168.10.254`.
* **Host RJ (`192.168.20.100`):** Requer a atribuição do endereço IP estático e gateway apontando para `192.168.20.254`. Os switches `SW1` e `SW2` operam puramente em camada 2 e não exigem acesso via console nesta topologia.

#### 4. Checklist de Validação Técnica (Pré-Túnel)

Antes de iniciar a configuração da rede virtual `172.16.100.0/30`, os seguintes testes de ICMP (ping) devem ser executados para validar a base arquitetural:

1. O Roteador SP consegue "pingar" o Roteador RJ utilizando seus endereços de interface WAN.
2. O Host SP consegue "pingar" seu próprio Gateway (`192.168.10.254`).
3. O Host RJ consegue "pingar" seu próprio Gateway (`192.168.20.254`).
4. O Host SP **falha** ao tentar "pingar" o Host RJ (comportamento esperado, pois a VPN ainda não existe).

---

### Tabela de Endereçamento Lógico

**1. Domínio LAN (Redes Privadas Locais)**

* **Site SP:**
* Rede: `192.168.10.0 /24`
* Gateway (Roteador SP): `192.168.10.254`
* Host SP: `192.168.10.100`


* **Site RJ:**
* Rede: `192.168.20.0 /24`
* Gateway (Roteador RJ): `192.168.20.254`
* Host RJ: `192.168.20.100`



**2. Domínio WAN (Redes Públicas / Internet)**

* **Link SP - Internet:** `200.31.27.0 /30` (IP do Roteador SP: `200.31.27.2`)
* **Link RJ - Internet:** `200.87.13.0 /30` (IP do Roteador RJ: `200.87.13.2`)

**3. Domínio VPN (Túnel Ponto a Ponto)**

* **Rede Virtual do Túnel:** `172.16.100.0 /30`
* **IP Virtual SP:** `172.16.100.1`
* **IP Virtual RJ:** `172.16.100.2`

---

## Parte 3: Guia de Configuração (CLI)

As configurações abaixo devem ser aplicadas nos consoles abertos no GNS3.

### 3.1. Configuração dos Dispositivos Finais (VPCS)

No console dos computadores, configuraremos o IP, máscara e o Gateway Padrão.

**Console: Host SP (192.168.10.100)**

```text
ip 192.168.10.100 255.255.255.0 192.168.10.254
save

```

**Console: Host RJ (192.168.20.100)**

```text
ip 192.168.20.100 255.255.255.0 192.168.20.254
save

```

### 3.2. Configuração da Nuvem (Roteador "Internet")

Este roteador simula a operadora. Ele só precisa conhecer as redes públicas e permitir o roteamento entre as interfaces de borda de SP e RJ. (Assumindo interface g0/0 para SP e g0/1 para RJ).

**Console: Internet**

```bash
enable
configure terminal
hostname Internet

! Interface conectada ao site SP
interface GigabitEthernet0/0
 ip address 200.31.27.1 255.255.255.252
 no shutdown
 exit

! Interface conectada ao site RJ
interface GigabitEthernet0/1
 ip address 200.87.13.1 255.255.255.252
 no shutdown
 exit

```

### 3.3. Configuração do Roteador SP (Borda Local)

Nesta etapa, configuramos as interfaces físicas, a rota padrão para a Internet e a Interface Virtual do Túnel (Tunnel 0).

**Console: SP**

```bash
enable
configure terminal
hostname Roteador-SP

! Configuração da LAN
interface GigabitEthernet0/1
 description CONEXAO-LAN-SP
 ip address 192.168.10.254 255.255.255.0
 no shutdown
 exit

! Configuração da WAN (Pública)
interface GigabitEthernet0/0
 description CONEXAO-INTERNET
 ip address 200.31.27.2 255.255.255.252
 no shutdown
 exit

! Rota Padrão para a Internet alcançar o RJ
ip route 0.0.0.0 0.0.0.0 200.31.27.1

! Configuração da Interface de Túnel (VPN)
interface Tunnel 0
 description TUNEL-VPN-PARA-RJ
 ip address 172.16.100.1 255.255.255.252
 tunnel source GigabitEthernet0/0
 tunnel destination 200.87.13.2
 exit

! Roteamento Estático enviando o tráfego da LAN do RJ para dentro do Túnel
ip route 192.168.20.0 255.255.255.0 172.16.100.2

```

### 3.4. Configuração do Roteador RJ (Borda Remota)

A configuração é o espelho lógico do roteador de São Paulo.

**Console: RJ**

```bash
enable
configure terminal
hostname Roteador-RJ

! Configuração da LAN
interface GigabitEthernet0/1
 description CONEXAO-LAN-RJ
 ip address 192.168.20.254 255.255.255.0
 no shutdown
 exit

! Configuração da WAN (Pública)
interface GigabitEthernet0/0
 description CONEXAO-INTERNET
 ip address 200.87.13.2 255.255.255.252
 no shutdown
 exit

! Rota Padrão para a Internet alcançar o SP
ip route 0.0.0.0 0.0.0.0 200.87.13.1

! Configuração da Interface de Túnel (VPN)
interface Tunnel 0
 description TUNEL-VPN-PARA-SP
 ip address 172.16.100.2 255.255.255.252
 tunnel source GigabitEthernet0/0
 tunnel destination 200.31.27.2
 exit

! Roteamento Estático enviando o tráfego da LAN do SP para dentro do Túnel
ip route 192.168.10.0 255.255.255.0 172.16.100.1

```

---

## Parte 4: Homologação e Testes (Troubleshooting Base)

Após inserir os comandos, os seguintes testes validam o sucesso da infraestrutura:

1. **Verificação do Túnel:** Nos roteadores SP e RJ, o comando `show ip interface brief` deve mostrar a interface `Tunnel0` com o status `up / up`.
2. **Ping pela Nuvem Pública:** No Roteador SP, execute `ping 200.87.13.2`. Deve obter 100% de sucesso.
3. **Ping Fim a Fim (Por dentro da VPN):** No console do **Host SP (192.168.10.100)**, execute `ping 192.168.20.100`.
* O pacote chegará no Roteador SP.
* O Roteador SP encapsulará no IP 200.31.27.2 e enviará à Internet.
* O Roteador RJ receberá, desencapsulará e entregará ao Host RJ.



Neste estágio documental, a VPN estabelecida utiliza o protocolo GRE (Generic Routing Encapsulation) puro, que cria o túnel funcionalmente, mas os dados ainda trafegam sem criptografia forte. A etapa subsequente seria a aplicação dos protocolos de segurança (Suite IPSec / ISAKMP) sobre a interface do túnel para encriptar o payload da comunicação.
