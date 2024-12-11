### **Quadro IEEE 802.11: Estrutura e Campos**

#### **1. Contextualização**
A comunicação em redes Wi-Fi baseadas no padrão IEEE 802.11 é organizada em quadros que transportam dados e informações de controle. Esses quadros são fundamentais para a troca de informações entre dispositivos e incluem campos específicos para gerenciar a transmissão, corrigir erros e garantir a entrega eficiente dos dados.

A estrutura do quadro IEEE 802.11 é composta por várias seções que desempenham funções diferentes. Compreender esses campos é essencial para entender como a comunicação Wi-Fi é organizada e gerenciada.

---

#### **2. Definição e Estrutura do Quadro IEEE 802.11**
1. **Campos do Quadro**:
    - **Controle do Quadro**:
        - Define o tipo e o propósito do quadro (ex.: dados, ACK, RTS/CTS).
    - **Número de Sequência**:
        - Identifica os quadros de forma única para reordenação e detecção de duplicatas.
    - **Duração**:
        - Informa o tempo necessário para a transmissão do quadro atual e da resposta.
    - **Campos de Endereço**:
        - Contêm informações sobre o remetente, destinatário e o roteador intermediário.
    - **Carga Útil**:
        - Transporta os dados do usuário ou pacotes de camadas superiores.
    - **CRC (Cyclic Redundancy Check)**:
        - Detecta erros nos dados transmitidos.

---

#### **3. Campos em Detalhe**

##### **3.1 Controle do Quadro**
- **Função**:
    - Define o tipo de quadro e suas propriedades.
    - Exemplos de tipos:
        - **Dados**: Transportam informações entre dispositivos.
        - **Controle**: RTS, CTS e ACK para gerenciar acesso ao canal.
        - **Gerenciamento**: Para associação, autenticação e desautenticação.

- **Subcampos**:
    - Versão do protocolo.
    - Tipo e subtipo do quadro.
    - Bits de controle, como mais fragmentos ou proteção de sequência.

##### **3.2 Número de Sequência**
- **Função**:
    - Identifica quadros individuais enviados pelo dispositivo.
    - Ajuda a:
        - Reordenar pacotes no destino.
        - Detectar retransmissões em caso de perda de pacotes.

- **Exemplo**:
    - Um quadro fragmentado em três partes (seqüências 1, 2 e 3) pode ser reconstruído no receptor com base no número de sequência.

##### **3.3 Duração**
- **Função**:
    - Especifica o tempo (em microssegundos) que será necessário para completar a transmissão do quadro atual e da resposta associada (como ACK).

- **Uso em RTS/CTS**:
    - O campo de duração reserva o canal para toda a troca de dados, incluindo ACK, garantindo que outros dispositivos aguardem.

##### **3.4 Campos de Endereço**
- **Função**:
    - Contêm até quatro endereços MAC:
        1. **Endereço de Destino**: Para onde os dados são enviados.
        2. **Endereço de Origem**: Quem enviou os dados.
        3. **Endereço do AP**: Quando aplicável, identifica o ponto de acesso intermediário.
        4. **Endereço do Próximo Salto**: Em redes multi-hop.

- **Exemplo Prático**:
    - Um notebook (origem) envia dados para um servidor (destino) via um AP. Os endereços indicam cada ponto envolvido na transmissão.

##### **3.5 Carga Útil**
- **Função**:
    - Transporta os dados úteis, como pacotes de aplicação (ex.: HTTP ou vídeo).
    - É a maior parte do quadro e pode ter seu tamanho ajustado para otimizar o desempenho.

- **Exemplo**:
    - O quadro pode carregar dados de uma página da web requisitada ou uma mensagem de e-mail.

##### **3.6 CRC (Cyclic Redundancy Check)**
- **Função**:
    - Detecta erros no quadro durante a transmissão.
    - Um valor de CRC é calculado no remetente com base nos dados e incluído no quadro.
    - O receptor recalcula o CRC e verifica se corresponde ao valor recebido. Se não coincidir, o quadro é descartado.

- **Exemplo Numérico**:
    - Se os dados transmitidos são "10110011" e o CRC calculado é "1101", o receptor verificará "101100111101". Um erro em qualquer bit resultará em uma falha na verificação.

---

#### **4. Exemplos Práticos**

##### **Exemplo 1: Controle de Quadros**
- Um AP envia um quadro de controle CTS para um dispositivo, reservando o canal para a transmissão de um quadro de dados longo. Outros dispositivos recebem o CTS e evitam transmissões durante o período especificado.

##### **Exemplo 2: Uso de Número de Sequência**
- Um dispositivo fragmenta um arquivo grande em três quadros. Cada quadro recebe um número de sequência único (1, 2, 3). O receptor usa esses números para reorganizar o arquivo.

##### **Exemplo 3: Verificação com CRC**
- Um quadro com dados é enviado do dispositivo A para o AP.
- O AP recalcula o CRC e percebe que os valores não coincidem devido a um erro na transmissão. O AP descarta o quadro e não envia o ACK, forçando o dispositivo A a retransmitir.

---

#### **5. Resumo Didático**
O quadro IEEE 802.11 é o coração da comunicação em redes Wi-Fi, organizando todos os dados e informações de controle necessários para gerenciar a transmissão. Campos como número de sequência, duração, endereços, carga útil e CRC desempenham papéis essenciais para garantir uma comunicação confiável, eficiente e organizada.

---