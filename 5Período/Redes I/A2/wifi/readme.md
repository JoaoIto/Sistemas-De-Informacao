### **Wi-Fi (Redes Sem Fio IEEE 802.11)**

#### **1. Introdução**
- Wi-Fi é uma das tecnologias de rede de acesso mais utilizadas hoje, conectando dispositivos como laptops e smartphones em casa, no trabalho ou em locais públicos.
- Baseado no padrão IEEE 802.11, Wi-Fi evoluiu para oferecer maior velocidade e alcance ao longo do tempo.
- **Padrões principais**:
    - **802.11b**: Taxa de até 11 Mbps, frequência de 2,4 GHz.
    - **802.11a**: Taxa de até 54 Mbps, frequência de 5 GHz.
    - **802.11g**: Combina características dos padrões anteriores (54 Mbps, 2,4 GHz).
    - **802.11n**: Suporta MIMO (múltiplas antenas), atingindo centenas de Mbps.

---

#### **2. Arquitetura Wi-Fi**
1. **BSS (Basic Service Set)**:
    - Estrutura básica composta por estações sem fio e um **ponto de acesso (AP)**.
    - AP conecta o BSS à Internet ou rede maior.

2. **Modos de Operação**:
    - **Infraestrutura**:
        - Comunicação entre dispositivos ocorre via AP.
        - Ex.: Rede Wi-Fi em casa.
    - **Ad hoc**:
        - Dispositivos se conectam diretamente, sem AP.
        - Ex.: Troca de arquivos entre notebooks.

3. **Endereços MAC**:
    - Cada dispositivo tem um endereço MAC único (6 bytes) para identificação.
    - Usado para direcionar pacotes na rede.

---

#### **3. Canais e Associação**
1. **Canais Wi-Fi**:
    - Redes Wi-Fi 2,4 GHz têm até 11 canais que podem se sobrepor.
    - Canais 1, 6 e 11 são os mais usados, pois não interferem entre si.
    - Em frequências de 5 GHz, há mais canais disponíveis e menos interferência.

2. **Processo de Associação**:
    - Antes de usar o Wi-Fi, o dispositivo deve se conectar a um AP.
    - Passos:
        1. **Varredura**:
            - Passiva: APs enviam sinais (beacons), e o dispositivo detecta.
            - Ativa: Dispositivo envia um pedido de busca e espera resposta dos APs.
        2. **Autenticação**:
            - O AP pode exigir senha ou autenticação via endereço MAC.
        3. **Associação**:
            - O dispositivo escolhe o AP com melhor sinal ou menor carga e se conecta.

---

#### **4. Protocolo de Acesso ao Meio (MAC - CSMA/CA)**
1. **Problemas de Colisão**:
    - Em Wi-Fi, colisões não podem ser detectadas facilmente devido a interferências ou terminais ocultos.
    - Exemplo: Dois dispositivos fora do alcance um do outro tentam transmitir para o mesmo AP ao mesmo tempo.

2. **CSMA/CA (Carrier Sense Multiple Access with Collision Avoidance)**:
    - Detecta se o canal está livre antes de transmitir.
    - **Passos**:
        1. Dispositivo espera até o canal estar ocioso.
        2. Se ocupado, ele entra em "backoff aleatório" (espera um tempo aleatório antes de tentar de novo).
        3. Após transmitir, espera um reconhecimento (ACK) do receptor.

3. **RTS/CTS (Request to Send / Clear to Send)**:
    - Solução para terminais ocultos.
    - Antes de transmitir, o dispositivo envia um pedido (RTS) ao AP.
    - Se o canal estiver livre, o AP responde com CTS, autorizando a transmissão.

---

#### **5. Estrutura do Quadro IEEE 802.11**
1. **Campos principais**:
    - **Controle**: Define o tipo de quadro (dados, ACK, etc.).
    - **Endereços**:
        - Endereço 1: Destinatário (dispositivo ou AP).
        - Endereço 2: Origem.
        - Endereço 3: Interface de roteador para redes externas.
    - **Carga útil**: Dados transportados (ex.: pacote IP).
    - **CRC (Cyclic Redundancy Check)**: Detecta erros no quadro.

2. **Reconhecimento (ACK)**:
    - Após receber um quadro sem erros, o destinatário envia um ACK.
    - Se não for recebido, o remetente retransmite.

---

#### **6. Segurança em Redes Wi-Fi**
1. **Autenticação**:
    - Controle de acesso pode ser feito por senha (WPA, WPA2) ou endereço MAC.
2. **Criptografia**:
    - WPA2: Protocolo padrão para proteger dados transmitidos.

---

#### **Exemplo Prático: Rede Wi-Fi em Casa**
- **Cenário**:
    - Dispositivos: Notebook, smartphone, tablet.
    - AP: Roteador Wi-Fi conectado à Internet.
- **Funcionamento**:
    1. Notebook detecta o AP enviando beacons.
    2. Usuário seleciona a rede, insere a senha (autenticação).
    3. Notebook se associa ao AP e recebe um endereço IP (via DHCP).
    4. Dispositivos se comunicam com a Internet por meio do roteador.

---