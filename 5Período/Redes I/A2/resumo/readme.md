## Base de Guia de Estudo e Referência

### Sumário:
1. **Redes Sem Fio e Redes Móveis**  
2. **Wi-Fi (Redes Sem Fio IEEE 802.11)**  
3. **Erro de Bits, Taxa de Transmissão, SNR e CDMA**  
4. **Transferências (Handoffs) em GSM**  
5. **MANET e VANET: Conexões Móveis em Redes**

---

### **1. Redes Sem Fio e Redes Móveis**

#### **Contextualização**  
As redes sem fio possibilitam a comunicação entre dispositivos sem cabos, utilizando ondas de rádio para conectar dispositivos. As redes móveis, como as redes celulares, permitem a mobilidade dos dispositivos enquanto mantêm a conectividade.

#### **Diferença entre Sem Fio e Mobilidade**  
- **Sem Fio**: Comunicação sem cabos (ex.: Wi-Fi em casa).  
- **Mobilidade**: Capacidade do dispositivo de se mover enquanto mantém a conexão (ex.: smartphones em uso durante deslocamento).

---

#### **Componentes e Funções**  

| **Componentes**           | **Descrição**                                                                                      | **Função e Exemplo**                                                                                       |
|--------------------------|--------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Dispositivos Móveis**    | Dispositivos finais que acessam a rede celular, como smartphones, tablets, modems USB.             | Conectam-se à rede por torres celulares, acessando serviços como voz, mensagens e dados.                   | **Exemplo**: Usuário em um carro conectado à torre celular mais próxima para acessar a internet.     |
| **Estações Base (BS)**     | Torres de celular que permitem comunicação entre dispositivos móveis e a rede de celular.           | Fornecem cobertura em áreas específicas, conectando os dispositivos móveis à rede.                        | **Exemplo**: Um usuário em um carro se conecta a uma estação base próxima, que comunica com a rede.    |
| **Controlador de Estação Base (BSC)** | Gerencia múltiplas estações base, controlando tráfego e mobilidade entre células (handoff).           | Garante que o usuário móvel mantenha a conexão ao se mover entre diferentes torres celulares.               | **Exemplo**: O BSC permite que um usuário que se move entre diferentes torres continue conectado.        |
| **Centro de Comutação de Mobilidade (MSC)** | Gerencia a comutação de chamadas e dados na rede móvel.                                           | Roteia dados entre diferentes estações base e servidores, permitindo a conexão à internet.                  | **Exemplo**: Quando um usuário faz uma chamada, o MSC comuta a conexão para a torre adequada.           |
| **Gateway de Dados (GGSN)** | Conecta a rede de telefonia móvel à internet, roteando o tráfego de dados.                        | Permite que dispositivos móveis acessem a internet, como navegação em websites e transmissão de vídeo.    | **Exemplo**: O GGSN conecta o dispositivo móvel à internet para navegação ou streaming.                 |
| **Gateway de Controle (SGSN)** | Rastreia a localização do dispositivo móvel, gerencia autenticação e encaminha dados para o GGSN. | Cuida da autenticação e encaminhamento de dados, mantendo a conectividade.                               | **Exemplo**: O SGSN autentica o usuário e roteia dados para a internet, mesmo quando o dispositivo se move. |
| **Internet (IP)**           | Conecta a rede celular à internet através de servidores e infraestrutura de comutação.            | Permite a comunicação entre a rede de celular e servidores na internet, como websites e serviços online.   | **Exemplo**: O IP facilita a navegação e o acesso a recursos na internet através da rede celular.       |

---

### **2. Wi-Fi (Redes Sem Fio IEEE 802.11)**

#### **Contextualização**  
O Wi-Fi, baseado no padrão IEEE 802.11, é uma das tecnologias de acesso sem fio mais amplamente utilizadas, permitindo a conexão de dispositivos como laptops, smartphones e tablets em locais públicos, residenciais e comerciais.

#### **Padrões Principais**  
- **802.11b**: Taxa de até 11 Mbps, frequência de 2,4 GHz.  
- **802.11a**: Taxa de até 54 Mbps, frequência de 5 GHz.  
- **802.11g**: Combinação dos padrões anteriores, até 54 Mbps em 2,4 GHz.  
- **802.11n**: Suporte a MIMO, alcançando centenas de Mbps.

---

#### **Arquitetura Wi-Fi e Componentes**  

| **Componentes**           | **Descrição**                                                                                      | **Função e Exemplo**                                                                                       |
|--------------------------|--------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Basic Service Set (BSS)**| Estrutura básica de rede Wi-Fi com dispositivos e APs.                                                | Conecta dispositivos à rede Wi-Fi, como roteadores e dispositivos móveis.                              | **Exemplo**: Usuário em casa conectado a um roteador Wi-Fi.  |
| **Access Point (AP)**      | Dispositivo que conecta dispositivos sem fio à rede.                                                | Conecta dispositivos à internet via ondas de rádio.                                                   | **Exemplo**: Roteador Wi-Fi que conecta smartphones e laptops. |
| **MAC (Media Access Control)** | Endereço único usado para roteamento e identificação dos dispositivos.                            | Identifica e direciona pacotes na rede Wi-Fi.                                                          | **Exemplo**: Endereços MAC em smartphones e laptops conectados. |

---

#### **Protocolo de Acesso ao Meio (CSMA/CA)**  
- **CSMA/CA**: O protocolo usado para evitar colisões no canal de transmissão.  
- **RTS/CTS**: Usado para resolver problemas de terminais ocultos, permitindo que o canal seja reservado antes da transmissão.

---

#### **Segurança em Wi-Fi**  
- **WPA2**: Protocolo de segurança que criptografa os dados transmitidos.  
- **Autenticação**: Controle de acesso via senha ou autenticação baseada em MAC.

---

### **3. Erro de Bits, Taxa de Transmissão, SNR e CDMA**  

#### **Contextualização**  
Em redes sem fio, qualidade de transmissão, taxa de erro e relação sinal-ruído (SNR) são fatores cruciais para garantir eficiência e confiabilidade.

#### **Definições e Relações**  

| **Conceito**             | **Descrição**                                                                                      | **Função e Exemplo**                                                                                       |
|--------------------------|--------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Taxa de Erro de Bits (BER)** | Mede a probabilidade de que um bit seja recebido incorretamente.                                   | Quanto menor o BER, mais confiável o canal.                                                             | **Exemplo**: Dispositivo em área rural com BER alto devido a sinal fraco.                            |
| **Taxa de Transmissão**    | Velocidade com que os dados são transmitidos (bps).                                              | Altas taxas podem aumentar o BER em canais com baixa SNR.                                               | **Exemplo**: Conexão Wi-Fi em locais urbanos com alta taxa de transmissão e SNR favorável.           |
| **SNR (Relação Sinal-Ruído)** | Mede a qualidade do sinal em relação ao ruído.                                                   | Um SNR alto melhora a qualidade do canal e reduz o BER.                                                | **Exemplo**: Conexão celular com SNR elevado em áreas urbanas.                                      |
| **CDMA (Code Division Multiple Access)** | Técnica que permite múltiplas transmissões simultâneas em um mesmo canal.                           | Usa códigos únicos para separar as transmissões, minimizando interferências.                            | **Exemplo**: Rede celular 3G ou 4G onde CDMA é usada para dividir o espectro de forma eficiente.      |

---

### **4. Transferências (Handoffs) em GSM**  

#### **Contextualização**  
Em redes móveis GSM, handoffs são essenciais para garantir a continuidade das chamadas e sessões de dados enquanto o usuário se desloca entre células diferentes.

#### **Definição e Tipos de Handoff**  

| **Handoff Tipo**            | **Descrição**                                                                                      | **Função e Exemplo**                                                                                       |
|----------------------------|--------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Intra-célula (Soft Handoff)** | Transferência entre estações base de uma mesma célula.                                               | Menos comum, mas pode ocorrer em células pequenas ou setores.                                        | **Exemplo**: Usuário se move dentro de uma mesma cidade, e o BSC coordena a transição sem desconexão.  |
| **Inter-célula (Hard Handoff)**| Transferência entre estações base de células diferentes.                                          | Ocorre frequentemente em GSM, onde o usuário se move entre diferentes áreas de cobertura.               | **Exemplo**: Usuário viajando entre estados no Brasil, e o BSC coordena a transição de torres.         |

---

#### **Exemplo Prático de Handoff em GSM**  
Um usuário está em uma chamada de voz e se desloca de uma célula para outra enquanto viaja de carro. O BSC gerencia a transição sem interrupções, garantindo a continuidade da conexão.

---

### **5. MANET e VANET: Conexões Móveis em Redes**

#### **MANET (Mobile Ad Hoc Network)**  
- **Definição**: Rede de dispositivos móveis que se comunicam sem infraestrutura fixa.  
- **Aplicações**: Utilizadas em áreas remotas e situações de emergência.  
- **Exemplo**: Drones em expedições em áreas isoladas.

#### **VANET (Vehicular Ad Hoc Network)**  
- **Definição**: Rede formada por veículos que se comunicam entre si e com a infraestrutura viária.  
- **Aplicações**: Sistemas de transporte inteligentes, como navegação e controle de tráfego.  
- **Exemplo**: Sistema de alerta de colisão e controle de tráfego em rodovias.

---
