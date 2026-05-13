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
