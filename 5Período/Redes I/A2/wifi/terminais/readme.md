### **Problema dos Terminais Ocultos e o Protocolo RTS/CTS**

#### **1. Contextualização**
O problema dos terminais ocultos é um desafio comum em redes Wi-Fi devido à natureza do meio sem fio. Em redes cabeadas, os dispositivos podem detectar se outro já está transmitindo, evitando colisões. No entanto, em redes sem fio, a comunicação pode ser limitada pelo alcance do sinal e pelo desvanecimento (redução da força do sinal). Isso cria situações onde dois dispositivos não conseguem perceber a existência um do outro, mas competem pelo mesmo canal, resultando em colisões no ponto de acesso (AP).

Para lidar com isso, o protocolo IEEE 802.11 inclui uma solução opcional chamada **RTS/CTS** (Request to Send / Clear to Send), que ajuda a coordenar o acesso ao canal e reduzir colisões, especialmente em cenários com terminais ocultos.

---

| **Conceito**            | **Descrição**                                                                                      | **Função e Impacto**                                                                          |
|-------------------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| **Problema dos Terminais Ocultos** | Dispositivos que não detectam a transmissão de outros devido à distância ou obstáculos físicos.   | Interferem no canal de comunicação sem saber que o canal já está ocupado, resultando em colisões. |
| **RTS/CTS (Request to Send / Clear to Send)** | Protocolo que usa quadros RTS e CTS para reservar o canal antes da transmissão.                    | Evita colisões ao alertar os dispositivos próximos para aguardarem a transmissão em andamento.   |
| **Envio do RTS**         | O dispositivo remetente envia um quadro RTS ao AP informando o tempo necessário para a transmissão. | O AP responde com um CTS, autorizando a transmissão e alertando os terminais ocultos para não transmitirem. |
| **Resposta com CTS**     | O AP envia um CTS para todos os dispositivos no alcance, indicando que o canal está reservado.    | Terminais ocultos recebem o CTS e evitam a transmissão, evitando colisões.                     |
| **Transmissão de Dados** | O remetente transmite os dados após o RTS/CTS bem-sucedidos, com o AP confirmando com ACK.       | Evita colisões e melhora a eficiência da transmissão em redes Wi-Fi.                          |

---

#### **2. Definição**
1. **Terminal Oculto**:
    - Um dispositivo que não consegue detectar a transmissão de outro dispositivo devido à distância ou obstáculos físicos, mas ainda assim pode interferir na mesma comunicação ao acessar o AP.

2. **RTS/CTS (Request to Send / Clear to Send)**:
    - É um esquema de controle que utiliza dois quadros curtos, RTS e CTS, para reservar o canal antes da transmissão de dados. Ele previne colisões ao garantir que todos os dispositivos próximos fiquem cientes da comunicação em andamento.

---

#### **3. Funcionamento do RTS/CTS**
1. **Envio do RTS**:
    - Antes de transmitir dados, o dispositivo remetente (ex.: H1) envia um quadro curto RTS ao AP. Este quadro informa o tempo necessário para transmitir os dados e receber a confirmação (ACK).

2. **Resposta com CTS**:
    - O AP recebe o RTS e responde com um quadro CTS, que é transmitido para todos os dispositivos no alcance do AP. O CTS autoriza o remetente (H1) a transmitir e avisa outros dispositivos (ex.: H2) para aguardarem até o final da transmissão.

3. **Transmissão de Dados**:
    - O remetente transmite o quadro de dados para o AP, que responde com um quadro de reconhecimento (ACK) após recebê-lo corretamente.

4. **Impacto**:
    - Os terminais ocultos (ex.: H2) ouvem o CTS e evitam transmissões durante o período especificado, prevenindo colisões.

---

#### **4. Exemplo Prático**
- **Cenário**:
    - Dois dispositivos, H1 e H2, estão conectados ao mesmo AP, mas fora do alcance um do outro. Ambos querem transmitir dados.
- **Sem RTS/CTS**:
    - H1 começa a transmitir para o AP.
    - H2, sem saber que o canal está ocupado, também tenta transmitir, causando uma colisão no AP.
- **Com RTS/CTS**:
    - H1 envia um RTS ao AP antes de transmitir dados.
    - O AP responde com CTS, informando H2 (e outros dispositivos no alcance) para aguardar.
    - H1 transmite os dados sem interrupção, e o AP confirma o recebimento com um ACK.

---

#### **5. Benefícios e Limitações**
1. **Benefícios**:
    - **Redução de colisões**: Especialmente em cenários com terminais ocultos.
    - **Eficácia para quadros longos**: Reservar o canal evita desperdício de tempo em retransmissões.

2. **Limitações**:
    - **Atrasos adicionais**: RTS e CTS introduzem overhead no canal.
    - **Uso restrito**: Geralmente aplicado apenas para quadros longos devido ao custo adicional.

---

#### **6. Resumo Didático**
- **Terminal Oculto**: Dispositivos que interferem um com o outro indiretamente por não detectarem suas transmissões.
- **RTS/CTS**: Um protocolo que coordena a transmissão de dados em redes Wi-Fi, reservando o canal para evitar colisões.
- **Exemplo**:
    - RTS e CTS atuam como um "pedido de permissão" e "autorização", garantindo que outros dispositivos saibam quando não devem transmitir.

---
