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

* **Topologia Host-Host (Em Desuso)**
* **O que é:** Neste formato mais antigo, a conexão VPN é feita diretamente de ponta a ponta entre dois computadores individuais (Host para Host) através da internet.
* **Por que caiu em desuso?** Esse modelo é ineficiente para grandes cenários. Configurar, manter e gerenciar túneis individuais e diretos entre cada par de máquinas em uma empresa gera um nível de complexidade inviável.


* **Topologia Host-Gateway (A Solução Moderna)**
* **O que é:** Para resolver o problema de escala, utilizamos a topologia Host-Gateway. Nela, o computador do usuário (Host) não se conecta a uma máquina específica, mas sim via internet a um equipamento central de borda, chamado de Gateway-VPN.
* **Como funciona na prática:** O Gateway-VPN recebe a tentativa de conexão e realiza a autenticação do usuário. Uma vez validado, ele serve como uma "porta de entrada", permitindo que esse Host acesse de forma segura múltiplas máquinas que estão dentro da Rede Local. É exatamente este modelo que viabiliza o trabalho remoto seguro nos dias de hoje.

---
