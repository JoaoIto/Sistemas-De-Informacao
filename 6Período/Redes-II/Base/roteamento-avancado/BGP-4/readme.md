### **BGP4 - Border Gateway Protocol para IPv4 e IPv6**  

O **BGP (Border Gateway Protocol)** é um **protocolo de roteamento externo** utilizado para a comunicação entre sistemas autônomos (AS - Autonomous Systems) na Internet. Ele é fundamental para a operação da rede global, permitindo que provedores de internet e grandes redes troquem informações de roteamento de maneira eficiente e escalável.  

Atualmente, o **BGP versão 4 (BGP-4)** é a versão mais utilizada, suportando tanto **IPv4** quanto **IPv6**. O BGP utiliza um modelo de **vetor de caminho (Path Vector)** para determinar as melhores rotas, diferente de protocolos internos como OSPF, que utilizam algoritmos de estado de enlace.  

O BGP é um protocolo **baseado em TCP (porta 179)**, garantindo a confiabilidade na troca de informações de roteamento. Ele **não converte automaticamente IPv4 para IPv6** e, portanto, é necessário configurar sessões separadas para cada protocolo.

---

## **Pequeno Texto Aplicando BGP**  

Uma empresa de telecomunicações precisa conectar sua rede a dois provedores de internet diferentes. Para garantir redundância e melhor controle sobre o tráfego, os engenheiros de rede configuram sessões **eBGP** com ambos os ISPs. Para otimizar o tráfego de saída, ajustam o atributo **Local Preference** para preferir um dos provedores. Já para otimizar o tráfego de entrada, utilizam o atributo **MED** para influenciar como os provedores encaminham pacotes para sua rede. Com essa configuração, a empresa garante alta disponibilidade e otimização do tráfego.  

---

## **Características do BGP-4**  

1. **Protocolo de roteamento entre sistemas autônomos (Exterior Gateway Protocol - EGP)**  
   - Ao contrário do OSPF e RIP, que são usados dentro de um AS, o BGP gerencia roteamento entre diferentes AS.  

2. **Baseado em vetor de caminho (Path Vector)**  
   - Mantém um banco de dados de caminhos completos para evitar loops e garantir a melhor rota.  

3. **Utiliza o protocolo TCP (porta 179)**  
   - Diferente de outros protocolos de roteamento, o BGP não usa pacotes UDP diretos.  

4. **Alta escalabilidade**  
   - Suporta grandes tabelas de roteamento, sendo essencial para redes da Internet.  

5. **Suporte para IPv4 e IPv6**  
   - As implementações modernas permitem IPv6, mas as sessões precisam ser configuradas separadamente.  

6. **Controle total sobre políticas de roteamento**  
   - Os administradores podem definir regras para manipular o tráfego com **atributos BGP**.  

7. **Detecção rápida de mudanças na rede**  
   - Utiliza keepalives e mensagens de atualização para monitorar o estado dos vizinhos.  

---

## **Funcionamento do BGP**  

O funcionamento do BGP é baseado na troca de mensagens entre roteadores vizinhos (**peers** ou **neighbors**). Ele segue quatro estágios principais:  

1. **Estabelecimento de sessão**  
   - Os roteadores vizinhos formam uma sessão TCP na porta 179 e trocam mensagens de **Open**.  

2. **Troca de informações de roteamento**  
   - Após a sessão ser estabelecida, os roteadores trocam suas tabelas BGP iniciais.  

3. **Seleção da melhor rota**  
   - O BGP aplica políticas baseadas em atributos para determinar a melhor rota para cada destino.  

4. **Manutenção da sessão**  
   - Os roteadores enviam mensagens de keepalive para manter a sessão ativa e detectar falhas.  

---

## **Tipos de BGP**  

O BGP pode operar de duas formas:  

1. **eBGP (External BGP)**  
   - Utilizado para conectar **diferentes sistemas autônomos (AS diferentes)**.  
   - Normalmente, os roteadores eBGP estão conectados diretamente.  
   - O TTL padrão para pacotes eBGP é 1.  

2. **iBGP (Internal BGP)**  
   - Utilizado **dentro de um mesmo AS** para disseminar rotas aprendidas por eBGP.  
   - Exige que todos os roteadores internos estejam completamente conectados (full-mesh) ou utilizem um **route reflector** para otimização.  
   - O TTL padrão para pacotes iBGP é 255, permitindo conexões indiretas.  

---

## **Mensagens BGP**  

O BGP utiliza quatro tipos principais de mensagens para comunicação:  

1. **Open** - Estabelece uma sessão BGP entre roteadores.  
2. **Update** - Propaga informações de roteamento e mudanças.  
3. **Keepalive** - Mantém a sessão ativa (enviado a cada 60 segundos por padrão).  
4. **Notification** - Enviada em caso de erro para encerrar a sessão BGP.  

---

## **Atributos BGP (Importantes para Seleção de Rotas)**  

O BGP decide a melhor rota para um destino baseado em atributos. Os principais são:  

1. **Weight (Cisco Proprietary)**  
   - Quanto maior, maior a prioridade da rota.  

2. **Local Preference**  
   - Definido dentro de um AS, quanto maior o valor, mais preferida é a rota.  

3. **AS Path**  
   - Prefere caminhos mais curtos (com menos ASs na lista).  

4. **Origin**  
   - Define se a rota foi aprendida via IGP, EGP ou Incomplete.  

5. **MED (Multi-Exit Discriminator)**  
   - Indica preferência para entrada em um AS quando existem múltiplas conexões.  

---

## **Configuração BGP para IPv4 e IPv6 em Roteadores Cisco**  

### **Configuração Básica de BGP para IPv4**  

```bash
router bgp 65001
 neighbor 192.168.1.2 remote-as 65002
 network 10.0.0.0 mask 255.255.255.0
```

Explicação:  
- **router bgp 65001** → Define o AS local.  
- **neighbor 192.168.1.2 remote-as 65002** → Configura um vizinho externo (eBGP).  
- **network 10.0.0.0 mask 255.255.255.0** → Anuncia a rede 10.0.0.0/24.  

---

### **Configuração BGP para IPv6**  

```bash
router bgp 65001
 neighbor 2001:db8::2 remote-as 65002
 address-family ipv6
 network 2001:db8:1000::/48
```

Explicação:  
- **address-family ipv6** → Habilita suporte ao IPv6.  
- **network 2001:db8:1000::/48** → Anuncia a rede IPv6.  

---

## **Analogia para Entender o BGP**  

Imagine que o BGP funciona como **companhias aéreas conectando aeroportos pelo mundo**:  

1. Cada **AS é um aeroporto**.  
2. Os **voos são as rotas BGP**.  
3. Quando um passageiro quer viajar (pacotes de dados), ele pode escolher diferentes rotas (companhias aéreas).  
4. Algumas rotas podem ser diretas (AS Path curto), enquanto outras podem ter escalas.  
5. O BGP escolhe a **melhor companhia aérea** (rota mais eficiente) para levar os pacotes até o destino.  

---

