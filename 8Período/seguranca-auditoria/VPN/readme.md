# VPN

### Introdução: O que é uma VPN?

Uma **VPN** (Rede Privada Virtual) funciona como um "túnel" seguro construído dentro de uma rede pública, como a internet. O seu principal objetivo (motivação) é criar um ambiente protegido para a troca de informações.

Para que essa comunicação seja realmente segura e eficiente, a VPN se apoia em três conceitos técnicos fundamentais:

* **Tunelamento:** É a forma como os dados trafegam pela conexão. O pacote de informações é primeiro criptografado e, em seguida, encapsulado dentro de outro pacote antes de ser enviado.
* **Autenticação das extremidades:** É a barreira de verificação que tem o objetivo de garantir que somente usuários autorizados possam utilizar o serviço.
* **Transporte subjacente:** Trata-se da adição de novos cabeçalhos aos pacotes de dados, permitindo sua instalação e roteamento correto em qualquer ponto da rede.

---

### Topologias de Conexão: A Evolução da Arquitetura

A forma como os computadores estabelecem esse túnel evoluiu para atender a necessidades maiores de escalabilidade e organização corporativa.

### Arquiteturas e Topologias de VPN

A implementação de uma rede privada virtual pode assumir diferentes formas arquitetônicas dependendo da necessidade de comunicação da organização. Abaixo, detalhamos os modelos padrão utilizados no mercado, suas nomenclaturas técnicas e cenários práticos de aplicação para compor a sua documentação.

#### 1. Arquitetura Host-to-Gateway (Client-to-Site)

Também amplamente conhecida e documentada no mercado corporativo como **Client-to-Site** (Cliente para Site), esta topologia é desenhada para conectar usuários individuais e remotos de forma segura à rede interna de uma organização.

* **Como funciona:** Um software cliente de VPN é instalado e configurado no dispositivo do usuário final (o "Host" ou "Cliente"). Este software é responsável por estabelecer um túnel criptografado através da internet diretamente com o equipamento de borda da empresa (o "Gateway", que atua como concentrador, podendo ser um roteador ou firewall).
* **Características técnicas:** O túnel estabelecido é individual e sob demanda. Apenas o dispositivo autenticado passa a ter acesso lógico à rede corporativa. A conexão geralmente é iniciada manualmente pelo usuário quando há necessidade de acesso.
* **Exemplo prático (Trabalho Remoto):** Um desenvolvedor trabalhando de casa precisa acessar um servidor de banco de dados e um repositório de código interno que não estão expostos publicamente na internet. Ele ativa o cliente VPN em seu notebook, realiza a autenticação (usuário, senha e duplo fator) no Gateway da empresa e, a partir desse momento, seu computador recebe um endereço IP virtual da rede interna. Ele passa a acessar os recursos corporativos de forma segura, como se estivesse fisicamente conectado ao switch do escritório.

#### 2. Arquitetura Gateway-to-Gateway (Site-to-Site)

<img width="2048" height="1792" alt="image" src="https://github.com/user-attachments/assets/8de0f529-4bfb-4462-b6e2-1e07d4a15ce8" />

Frequentemente referida na engenharia de redes como **Site-to-Site** (Local para Local ou Matriz-Filial), esta arquitetura tem o objetivo de interligar redes locais (LANs) inteiras, situadas em localidades geográficas distintas, de forma permanente e transparente para os usuários.

* **Como funciona:** O túnel VPN é negociado e estabelecido exclusivamente entre os equipamentos de borda de cada localidade (os "Gateways"). Os computadores, impressoras e servidores que estão dentro das redes locais não requerem nenhum tipo de software cliente ou configuração adicional de VPN; eles sequer têm conhecimento da existência do túnel.
* **Características técnicas:** O encapsulamento e a criptografia ocorrem em nível de infraestrutura. O gateway intercepta o tráfego destinado à outra localidade, aplica a proteção e o envia pela internet. Este tipo de túnel costuma ser configurado como *always-on* (sempre ativo), operando de forma autônoma.
* **Exemplo prático (Interligação de Filiais):** Este é exatamente o modelo do nosso laboratório base. Uma empresa possui sua matriz no Rio de Janeiro (RJ) e abre uma filial em São Paulo (SP). Os funcionários da filial de SP precisam utilizar o sistema ERP hospedado nos servidores do RJ. Em vez de contratar um link físico dedicado de alto custo entre os estados, a equipe configura uma VPN Site-to-Site entre o roteador de SP e o do RJ. Quando um host em SP solicita acesso ao IP do servidor no RJ, o roteador captura o pacote, criptografa, envia pela nuvem pública e o roteador do RJ entrega o pacote intacto ao destino.

#### 3. Arquitetura Host-to-Host (Legada)

Para fins de registro e completude da documentação, vale mencionar este modelo clássico onde o túnel era fechado diretamente entre dois computadores finais específicos através da internet.

* **Status atual:** Encontra-se em desuso para redes corporativas tradicionais devido à falta de escalabilidade. Estabelecer, configurar e manter chaves de criptografia e túneis individuais entre dezenas ou centenas de máquinas gera um esforço de administração inviável. As abordagens Client-to-Site e Site-to-Site centralizam esse processamento nos Gateways, resolvendo o problema de escala de forma eficiente.

---

## Protocolos de Tunelamento e Segurança

Para que as arquiteturas Client-to-Site ou Site-to-Site funcionem, é necessário utilizar protocolos específicos que definem as regras de como os dados serão encapsulados e protegidos durante o trajeto na rede pública. Abaixo, detalhamos a evolução técnica e o funcionamento dos principais protocolos.

### 1. Protocolo PPTP (Point-to-Point Tunneling Protocol)

O PPTP é um dos protocolos de VPN mais antigos, desenvolvido em grande parte pela Microsoft.

* **Funcionamento (Análise de Fluxo):** Como ilustrado na arquitetura Client-to-Site, o cliente remoto estabelece inicialmente uma conexão PPP (Point-to-Point Protocol) padrão. O protocolo PPTP entra em ação capturando esse tráfego PPP e criando um "Canal de conexão PPTP" através da Internet. Esse canal encapsula os pacotes originais dentro de novos Datagramas IP para que possam ser roteados publicamente até o Gateway da rede local.
* **Aplicações e Limitações:** Historicamente, foi muito popular por ser nativo no Windows e exigir pouca configuração. No entanto, seus algoritmos de criptografia são considerados obsoletos e altamente vulneráveis a ataques modernos. Hoje, seu uso é desencorajado em ambientes corporativos.

### 2. Protocolo L2TP (Layer 2 Tunneling Protocol)

O L2TP surgiu como uma evolução, combinando características do PPTP da Microsoft e do L2F da Cisco.

* **Funcionamento (Análise de Fluxo):** O diagrama L2TP demonstra uma arquitetura mais robusta, envolvendo componentes específicos de acesso. O cliente remoto inicia uma sessão PPP que atinge o concentrador do provedor de acesso, chamado de **ISP NAS** (Network Access Server). É a partir deste ponto (ou diretamente do cliente, dependendo da configuração) que o Túnel L2TP é estabelecido pela Internet até o equipamento de borda da corporação, designado como **LNS NAS** (L2TP Network Server).
* **Aplicações e Segurança:** Uma característica fundamental do L2TP é que ele é apenas um protocolo de tunelamento; ele **não provê criptografia nativa**. Por esse motivo, para garantir a confidencialidade e integridade dos dados, o L2TP é quase universalmente implementado em conjunto com o IPsec (formando o padrão L2TP/IPsec).

### 3. Protocolo IPSec (IP Security)

O IPsec não é apenas um protocolo, mas uma suíte (um conjunto) de protocolos de segurança. Ele se consolidou como a alternativa definitiva e segura para a nova geração de redes IP, sendo o padrão absoluto para implementações de VPN Site-to-Site corporativas (como o nosso laboratório no GNS3).

A principal característica do IPsec é sua capacidade de proteger os dados diretamente na camada de rede (Camada 3 do modelo OSI). Ele trabalha essencialmente com dois modos de operação distintos, dependendo da necessidade de roteamento e proteção da identidade dos pacotes:

* **Modo Transporte (Transport Mode):**
Neste modo, apenas o "payload" (a carga útil ou os dados originais) do pacote IP é criptografado e protegido. O Cabeçalho IP original é mantido intacto e visível.
* *Estrutura do Pacote:* O cabeçalho IPsec é inserido exatamente entre o Cabeçalho IP original e os dados.
* *Uso Prático:* É mais utilizado em comunicações Host-to-Host (ponta a ponta em redes internas), onde não há necessidade de ocultar os IPs de origem e destino, apenas proteger o conteúdo da mensagem.


* **Modo Túnel (Tunnel Mode):**
Este é o modo utilizado nas VPNs Gateway-to-Gateway (Site-to-Site). Nele, o pacote IP original inteiro (tanto o cabeçalho original quanto os dados) é criptografado e ocultado.
* *Estrutura do Pacote:* O equipamento de borda pega o pacote completo, aplica a criptografia e adiciona um **Novo Cabeçalho IP** público, seguido do Cabeçalho IPsec e, então, do pacote antigo protegido.
* *Uso Prático:* Garante segurança máxima, pois além do conteúdo dos dados, oculta a arquitetura de endereçamento IP interno da empresa (os IPs da LAN). Os roteadores na Internet só enxergam os novos cabeçalhos IP públicos trafegando entre os Gateways.

### 3.1. O IPSec no Contexto do IPv4 vs. IPv6

Antes de compreendermos os mecanismos internos de segurança, é fundamental estabelecer uma premissa sobre o cenário do nosso laboratório prático:

* **No IPv4 (Nosso Cenário):** O protocolo IPv4 foi desenhado em uma época onde a segurança não era uma prioridade nativa da arquitetura da internet. Por isso, **o IPSec não é nativo no IPv4**. Ele funciona como um "módulo de extensão" (add-on). Para que o túnel funcione, precisaremos configurar explicitamente as políticas de criptografia, chaves e transformações no roteador para que ele saiba como tratar esse tráfego adicional.
* **No IPv6:** A suíte de protocolos IPSec é um requisito obrigatório e totalmente nativo na arquitetura do IPv6. Dispositivos que implementam IPv6 já possuem o suporte ao IPSec embutido em sua camada de rede por padrão, simplificando significativamente a adoção de comunicações seguras de ponta a ponta.

### 3.2. Arquitetura Interna do IPSec: Associações e Bancos de Dados

Quando habilitamos o IPSec em um roteador de borda (Gateway), ele não criptografa cegamente tudo o que passa por ele. Ele utiliza um sistema rigoroso de regras e associações para tomar decisões lógicas, composto por três elementos centrais:

* **SA (Security Association - Associação de Segurança):** É o acordo fundamental entre os dois roteadores (SP e RJ, por exemplo). A SA define "como" a proteção ocorrerá: qual algoritmo de criptografia será usado (ex: AES), qual algoritmo de integridade (ex: SHA) e qual é a chave compartilhada. A SA é unidirecional; portanto, para uma comunicação bidirecional completa, são necessárias pelo menos duas SAs.
* **SPD (Security Policy Database - Banco de Dados de Política de Segurança):** É o cérebro do processo de decisão. É uma lista de regras (semelhante a uma Access Control List - ACL) que inspeciona o tráfego que chega ao roteador. Para cada pacote de dados, o SPD define uma de três ações:
1. **Discard (Descartar):** O pacote é bloqueado e destruído.
2. **Bypass (Ignorar/Passar Direto):** O pacote tem permissão para transitar sem proteção (exemplo: tráfego comum de navegação na internet).
3. **Protect (Proteger):** O pacote engatilha a necessidade de criptografia. Se esta ação for acionada, o roteador é instruído a consultar o SAD.


* **SAD (Security Association Database - Banco de Dados de Associação de Segurança):** Se o SPD disse que o pacote deve ser "Protegido", o roteador consulta o SAD. O SAD é o repositório que armazena todas as SAs ativas no momento. Ele entrega os parâmetros técnicos e as chaves exatas que o roteador deve usar para criptografar e encapsular aquele pacote específico antes de enviá-lo pelo túnel.

---

### Ilustração Interativa: Fluxo de Processamento IPSec

Para consolidar o entendimento de como o pacote viaja por esses componentes dentro do roteador (Gateway), utilize a ilustração interativa abaixo. Nela, você pode simular o envio de um tráfego corporativo (que deve passar pela VPN) e um tráfego de internet comum, observando o comportamento do SPD e do SAD em tempo real.

<img width="683" height="614" alt="{A7BA05D6-8ECB-47EE-A745-62FC7D73CF2E}" src="https://github.com/user-attachments/assets/5d2f24a4-7ae8-4505-8ff2-1352346e5768" />

<img width="666" height="560" alt="{01C9A3DF-2FDC-4FBE-933A-1A8E8ED6B8DD}" src="https://github.com/user-attachments/assets/169af17b-a8d6-46ab-b4f8-cbe3d78157d9" />

---

### 3.3. Gerenciamento de Chaves no IPSec: O Protocolo IKE

Vimos que o IPSec utiliza Associações de Segurança (SAs) armazenadas no SAD para saber qual chave usar ao criptografar um pacote. No entanto, configurar chaves de forma manual (estática) em todos os roteadores de uma rede corporativa é um processo lento, suscetível a erros humanos e altamente inseguro (pois as chaves nunca mudariam).

Para resolver isso, o IPSec utiliza um protocolo vital chamado **IKE (Internet Key Exchange)**.

A principal característica do IKE é realizar a **gerência automática e dinâmica de chaves**. Ele estabelece um canal de comunicação seguro entre os roteadores (antes mesmo do túnel de dados principal ser formado) para que eles possam negociar parâmetros de segurança de forma autônoma.

O IKE não é um protocolo monolítico; ele atua combinando duas engrenagens principais:

* **ISAKMP (Internet Security Association and Key Management Protocol):**
* **Função:** Responsável pela arquitetura de negociação e distribuição. Ele define os procedimentos e os formatos dos pacotes para estabelecer, modificar e deletar as Associações de Segurança (SAs). É o ISAKMP que define "como" os roteadores vão conversar para chegar a um acordo sobre as regras de segurança.


* **OAKLEY (Protocolo de Determinação de Chave):**
* **Função:** Responsável pela matemática da **geração das chaves** em si. Utilizando o algoritmo de troca de chaves Diffie-Hellman, o Oakley permite que os dois roteadores (como os gateways de SP e RJ) gerem uma chave secreta compartilhada idêntica através da internet pública, sem que essa chave precise ser enviada pela rede em nenhum momento.



**Resumo prático no cenário Site-to-Site:**
Quando o roteador de São Paulo recebe a instrução (via SPD) de que deve proteger um pacote para o Rio de Janeiro, mas percebe que ainda não tem as chaves no SAD, ele aciona o protocolo **IKE**. O IKE usa o **ISAKMP** para criar um canal de negociação com o RJ e o **OAKLEY** para gerar as chaves matemáticas seguras. Uma vez que as chaves são geradas e as regras acordadas, a SA é finalmente instalada no SAD, e o tráfego de dados pode começar a fluir de forma criptografada.

---

### 3.4. Protocolos SSL/TLS (Secure Sockets Layer / Transport Layer Security)

Desenvolvido originalmente pela Netscape e posteriormente padronizado pela IETF (Internet Engineering Task Force), o SSL e seu sucessor moderno, o TLS, representam uma abordagem diferente para a construção de Redes Privadas Virtuais. Em vez de proteger todo o tráfego IP de um roteador a outro, ele foca em proteger a comunicação de aplicações específicas.

**Posicionamento na Arquitetura de Redes**

Uma das características arquitetônicas mais marcantes do SSL/TLS é o seu local de atuação no modelo de rede.

* **Atuação Intermediária:** O protocolo atua exatamente entre a camada de Aplicação e a camada de Transporte (sobre o protocolo TCP).
* **Subcamadas Internas:** Como ilustrado na arquitetura TCP/IP adaptada, o SSL é subdividido funcionalmente:
* *SSL Handshake:* Fica na parte superior, mais próximo à aplicação, sendo responsável por negociar as chaves, os algoritmos e realizar a autenticação antes do envio dos dados.
* *SSL Record:* Fica logo abaixo, encapsulando os dados recebidos da aplicação, aplicando a criptografia definida no Handshake e repassando-os para o TCP na camada de Transporte.



**Objetivos e Prioridades do Protocolo**

A implementação de túneis via SSL/TLS foi projetada para atender a requisitos técnicos rigorosos, classificados por ordem de prioridade:

1. **Sigilo e segurança dos dados:** Garantir que o payload da aplicação seja ilegível para interceptadores na nuvem pública.
2. **Garantir interoperabilidade:** Permitir que aplicações e sistemas operacionais de diferentes fabricantes consigam estabelecer o túnel e trocar parâmetros criptográficos sem falhas de comunicação.
3. **Estrutura de expansão criptográfica:** O protocolo possui uma arquitetura modular que permite a incorporação de novos métodos e algoritmos de criptografia (como a transição de RSA para Curvas Elípticas) conforme a tecnologia avança, sem precisar reescrever a base do protocolo.
4. **Eficiência e Desempenho:** Realiza o armazenamento temporário de dados na sessão. Isso evita que o roteador/servidor precise refazer todo o processamento matemático pesado do *Handshake* a cada nova requisição, melhorando significativamente o desempenho do protocolo.

---
