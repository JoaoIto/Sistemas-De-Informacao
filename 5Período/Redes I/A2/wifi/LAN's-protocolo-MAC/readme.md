### **Wi-Fi LANs: Arquitetura e Protocolo MAC**

#### **1. Introdução às LANs Wi-Fi**
Wi-Fi (Wireless Fidelity) é uma das tecnologias de redes sem fio mais utilizadas, baseada nos padrões IEEE 802.11. Suas LANs (Local Area Networks) conectam dispositivos como smartphones, notebooks e tablets sem a necessidade de cabos, usando ondas de rádio.

Wi-Fi é amplamente utilizado em residências, escritórios e locais públicos devido à sua flexibilidade e facilidade de uso. Os padrões IEEE 802.11 incluem variantes como 802.11b, 802.11g, 802.11n e 802.11ac, cada uma com diferentes características de velocidade e alcance.

---

### **2. Arquitetura das LANs Wi-Fi**

#### **2.1 Componentes Principais**
1. **Ponto de Acesso (Access Point - AP)**:
    - Atua como estação-base, conectando dispositivos sem fio à rede maior (geralmente a Internet).
    - Controla a comunicação entre dispositivos no Basic Service Set (BSS).

2. **Dispositivos Clientes**:
    - Incluem smartphones, notebooks e outros dispositivos sem fio conectados ao AP.

3. **Infraestrutura Cabeada**:
    - APs normalmente estão conectados a switches ou roteadores que fazem a conexão com a Internet.

---

#### **2.2 Modos de Operação**
1. **Modo de Infraestrutura**:
    - O AP serve como intermediário para comunicação entre dispositivos e a rede externa.
    - Exemplo: Rede Wi-Fi residencial com um roteador conectado à Internet.

2. **Modo Ad Hoc**:
    - Dispositivos se conectam diretamente uns aos outros sem a necessidade de um AP.
    - Exemplo: Troca de arquivos entre notebooks em uma reunião.

---

#### **2.3 Processos de Associação**
1. **Descoberta do AP**:
    - Dispositivos escaneiam canais em busca de sinais de APs próximos.
    - Pode ser feito de forma:
        - **Passiva**: Dispositivos escutam beacons enviados pelos APs.
        - **Ativa**: Dispositivos enviam solicitações de investigação para APs.

2. **Autenticação**:
    - O AP pode exigir credenciais (senha, certificado ou endereço MAC autorizado).

3. **Associação**:
    - Dispositivos selecionam o AP com melhor sinal ou menos congestionado para conexão.

---

### **3. Protocolo MAC (CSMA/CA)**

#### **3.1 Problemas na Comunicação Wi-Fi**
1. **Colisões**:
    - Vários dispositivos podem tentar transmitir ao mesmo tempo.
    - Problemas específicos incluem:
        - **Terminal Oculto**: Dispositivos que não conseguem detectar a transmissão um do outro.
        - **Desvanecimento**: Redução da potência do sinal, dificultando a detecção de transmissões.

2. **Altas Taxas de Erro de Bits (BER)**:
    - O canal sem fio é mais suscetível a interferências e erros do que redes cabeadas.

---

#### **3.2 Funcionamento do CSMA/CA**
O Wi-Fi utiliza o protocolo CSMA/CA (Carrier Sense Multiple Access with Collision Avoidance) para evitar colisões e gerenciar o acesso ao meio compartilhado.

1. **Passos do CSMA/CA**:
    - **Escuta do Canal**:
        - Antes de transmitir, o dispositivo verifica se o canal está ocioso.
    - **Backoff Aleatório**:
        - Se o canal estiver ocupado, o dispositivo espera um tempo aleatório antes de tentar novamente.
    - **Transmissão**:
        - Após esperar, o dispositivo transmite o quadro completo.
    - **Reconhecimento (ACK)**:
        - O receptor envia um ACK para confirmar o recebimento sem erros.

2. **RTS/CTS (Request to Send / Clear to Send)**:
    - Usado para resolver problemas de terminais ocultos.
    - O dispositivo envia um quadro RTS para reservar o canal, e o AP responde com um CTS autorizando a transmissão.

---

#### **3.3 Estrutura do Quadro IEEE 802.11**
1. **Campos Importantes**:
    - **Controle do Quadro**:
        - Indica o tipo de quadro (dados, ACK, RTS, CTS).
    - **Endereços**:
        - Endereço 1: Destinatário (ex.: dispositivo ou AP).
        - Endereço 2: Origem (ex.: dispositivo transmissor).
        - Endereço 3: Interface do roteador na rede maior.
    - **Carga Útil**:
        - Dados transmitidos, como pacotes IP.
    - **CRC (Cyclic Redundancy Check)**:
        - Detecta erros no quadro.

2. **Reconhecimento de Quadro**:
    - Após receber um quadro sem erros, o receptor envia um ACK.
    - Caso contrário, o transmissor retransmite o quadro.

---

### **4. Exemplos Práticos**

#### **Exemplo 1: Rede Wi-Fi Residencial**
1. **Cenário**:
    - Roteador Wi-Fi conectado à Internet.
    - Dispositivos: Smartphone, notebook.
2. **Processo**:
    - O smartphone detecta beacons do roteador.
    - O usuário seleciona a rede Wi-Fi, insere a senha (autenticação).
    - Após a associação, o smartphone recebe um endereço IP e acessa a Internet.

#### **Exemplo 2: Resolução de Terminais Ocultos**
1. **Cenário**:
    - Dois dispositivos (A e B) estão conectados ao mesmo AP, mas fora do alcance um do outro.
2. **Solução**:
    - Dispositivo A envia RTS ao AP.
    - O AP responde com CTS para reservar o canal.
    - Dispositivo B recebe o CTS e aguarda antes de transmitir.

---
