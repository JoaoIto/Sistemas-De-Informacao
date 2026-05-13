# ***Trabalho Avaliativo*** Relatório de Implementação: Arquitetura VPN Host-to-Gateway

## 1. Visão Geral da Arquitetura e Objetivos

Este documento detalha a implementação de uma Rede Privada Virtual (VPN) na topologia **Host-to-Gateway** (também conhecida como Client-to-Site ou Acesso Remoto).

O objetivo do projeto é estabelecer um canal de comunicação seguro, criptografado e autenticado entre um dispositivo cliente externo (roaming) e a rede corporativa interna, utilizando a infraestrutura pública (Internet) como meio de transporte.

**Componentes Tecnológicos:**

* **Concentrador VPN (Gateway):** pfSense Community Edition.
* *Base do SO:* FreeBSD.
* *Interface de Gestão:* WebGUI construída em PHP.
* *Serviço:* OpenVPN (solução open-source baseada em SSL/TLS).


* **Endpoints (Clientes):** Máquinas operando sistemas Windows 7 e distribuições Linux (Ubuntu/Debian).

---

## 2. O Desafio pfSense: Base FreeBSD e Interface PHP

Diferente de roteadores baseados estritamente em linha de comando (CLI) como o Cisco IOS, o pfSense é um *appliance* de firewall e roteamento que encapsula o robusto núcleo de redes do FreeBSD sob uma interface web em PHP.

Para este laboratório, o pfSense deve ser provisionado em máquina virtual (VM) com, no mínimo, duas interfaces de rede (NICs):

* **WAN (Pública):** Recebe IP da rede externa (ou rede do laboratório que simula a Internet). É a interface que receberá as conexões OpenVPN na porta UDP 1194.
* **LAN (Privada):** Interface interna da rede corporativa (ex: `192.168.1.1/24`).

*Nota Técnica:* Embora a configuração seja feita via WebGUI (PHP), no *backend*, o pfSense está gerando arquivos de configuração `.conf` do OpenVPN e manipulando o `pf` (Packet Filter), o firewall nativo do FreeBSD.

---

## 3. Configuração do Servidor (pfSense - OpenVPN)

A implementação do OpenVPN no modelo Client-to-Site exige a criação de uma Infraestrutura de Chaves Públicas (PKI). A configuração ocorre em três fases lógicas através da WebGUI do pfSense.

### Fase 1: Gestão de Certificados (PKI)

Para garantir a autenticação mútua e segura (SSL/TLS), configuramos as autoridades e certificados em `System > Cert. Manager`.

1. **Criação da CA (Certificate Authority):**
* Criada uma Autoridade Certificadora Interna chamada `VPN_CA`. Ela será responsável por assinar todos os certificados dos clientes.


2. **Criação do Certificado do Servidor:**
* Criado um certificado interno nomeado `pfSense-VPN-Server`, assinado pela `VPN_CA`, com o tipo (Certificate Type) definido como *Server Certificate*.



### Fase 2: Provisionamento do Túnel (OpenVPN Server)

Navegando até `VPN > OpenVPN > Servers`, a instância do servidor é instanciada com os seguintes parâmetros técnicos:

* **Server Mode:** Remote Access (SSL/TLS + User Auth) - *Exige certificado e usuário/senha.*
* **Protocol:** UDP na porta 1194 (Padrão de alta performance para VPNs).
* **Device Mode:** tun (Tunelamento de Camada 3 / Roteamento IP).
* **Cryptographic Settings:**
* Peer Certificate Authority: `VPN_CA`
* Server Certificate: `pfSense-VPN-Server`
* Data Encryption Algorithm: AES-256-GCM (Padrão moderno) ou AES-256-CBC.


* **Tunnel Settings:**
* *IPv4 Tunnel Network:* `10.0.8.0/24` (A rede virtual isolada que os clientes receberão).
* *IPv4 Local Network:* `192.168.1.0/24` (A rede corporativa que o cliente terá acesso).



### Fase 3: Regras de Firewall (Packet Filter)

Por padrão, o FreeBSD bloqueia todo tráfego entrante. Em `Firewall > Rules`, duas permissões vitais são criadas:

1. **Aba WAN:** Permite tráfego UDP entrante na porta 1194, permitindo que a negociação criptográfica (Handshake TLS) inicie.
2. **Aba OpenVPN:** Permite tráfego genérico (IPv4 * * * *) dentro do túnel estabelecido, liberando o acesso dos clientes aos recursos da LAN.

---

## 4. Configuração e Conexão dos Clientes

Para exportar as configurações, instala-se o pacote `openvpn-client-export` via gerenciador de pacotes do pfSense (`System > Package Manager`). Isso gera o arquivo consolidado `.ovpn` (que contém as chaves públicas, certificados e o IP do Gateway).

### Cenário A: Cliente Linux (Ubuntu/Debian)

A conexão no Linux foca na eficiência via terminal, dispensando interfaces gráficas pesadas.

**Comandos de Instalação e Execução:**

```bash
# 1. Atualizar repositórios e instalar o cliente OpenVPN
sudo apt update && sudo apt install openvpn -y

# 2. Transferir o arquivo client.ovpn para a máquina Linux (via scp ou download seguro)

# 3. Iniciar o túnel em foreground para visualização dos logs em tempo real
sudo openvpn --config client.ovpn

```

**Resposta Esperada (Logs de Sucesso no Terminal):**

```text
[client] Peer Connection Initiated with [AF_INET]XXX.XXX.XXX.XXX:1194
TUN/TAP device tun0 opened
/sbin/ip link set dev tun0 up mtu 1500
/sbin/ip addr add dev tun0 10.0.8.2/24 broadcast 10.0.8.255
Initialization Sequence Completed

```

### Cenário B: Cliente Windows 7 (Ambiente Legado/Corporativo)

1. Faz-se o download do instalador executável gerado pelo pfSense (que já embute o OpenVPN GUI e o arquivo `.ovpn`).
2. Instala-se o software com privilégios de Administrador (necessário para que o OpenVPN possa criar o adaptador de rede virtual TAP-Windows).
3. Abre-se o OpenVPN GUI na bandeja do sistema, clica-se com o botão direito e seleciona-se "Conectar", inserindo as credenciais. A tela ficará verde confirmando o IP `10.0.8.x`.

---

## 5. Roteiro de Demonstração em Sala (Validação Prática)

Para a defesa do trabalho, a seguinte sequência de ações atesta o sucesso da engenharia implementada:

**Passo 1: Verificação de Estado Base (Sem VPN)**

* No cliente Linux/Windows, executar um `ping 192.168.1.x` (IP de um servidor interno da LAN atrás do pfSense).
* *Resultado esperado:* Timeout/Destino Inalcançável, comprovando que a rede interna está segura e isolada da WAN.

**Passo 2: Estabelecimento do Túnel e Análise de IP**

* Conectar o cliente OpenVPN.
* No terminal do Linux, executar `ip a` (ou `ipconfig` no Win7).
* *Demonstrar à banca:* A criação de uma nova interface de rede virtual (`tun0`), que recebeu o IP da Tunnel Network configurada no pfSense (ex: `10.0.8.2`).

**Passo 3: Validação de Conectividade e Roteamento**

* Refazer o `ping 192.168.1.x`.
* *Resultado esperado:* Resposta bem-sucedida (Echo Reply).
* Executar um teste de rastreio de rota (`traceroute 192.168.1.x` no Linux ou `tracert` no Windows).
* *Demonstrar à banca:* O primeiro salto do pacote será obrigatoriamente o IP virtual do pfSense (ex: `10.0.8.1`), provando que o tráfego está sendo escoado por dentro do túnel lógico criptografado, e não pela infraestrutura de rede local padrão do cliente.

**Passo 4: Monitoramento no Concentrador**

* Acessar a WebGUI do pfSense.
* Navegar até `Status > OpenVPN`.
* *Demonstrar à banca:* O *dashboard* listando o cliente conectado, exibindo seu IP real (Público), o IP virtual atribuído no túnel, e a métrica técnica de bytes transferidos e criptografados em tempo real.
