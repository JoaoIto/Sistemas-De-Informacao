### **Erro de Bits, Taxa de Transmissão, SNR e CDMA**

#### **Base**
As redes sem fio apresentam desafios únicos devido à natureza de seu meio de transmissão: o ar. Diferentemente de redes cabeadas, onde o sinal viaja por um meio físico controlado, nas redes sem fio o sinal pode ser enfraquecido, interferido ou dispersado antes de chegar ao destino. Isso gera fenômenos como erro de bits e demanda técnicas avançadas para gerenciar a comunicação, como o CDMA.

Erro de bits, taxa de transmissão e SNR (Signal-to-Noise Ratio) são conceitos inter-relacionados que determinam a qualidade da transmissão. A taxa de transmissão define a velocidade dos dados no canal, a SNR mede a relação entre o sinal útil e o ruído, enquanto o erro de bits avalia a confiabilidade da transmissão. O CDMA, por sua vez, é uma técnica utilizada para permitir que vários dispositivos compartilhem o mesmo canal simultaneamente sem interferir uns nos outros, desempenhando um papel crucial em redes móveis e sem fio.

---

### **1. Erro de Bits, Taxa de Transmissão e SNR**

#### **Definições**
1. **Taxa de Erro de Bits (BER - Bit Error Rate)**:
    - A BER mede a probabilidade de que um bit transmitido seja recebido incorretamente.
    - É influenciada por fatores como interferências, atenuação do sinal e relação sinal-ruído (SNR).
    - Quanto menor a BER, mais confiável é o canal.

2. **Taxa de Transmissão**:
    - Representa a quantidade de bits transmitidos por segundo (bps).
    - Depende da largura de banda disponível e do esquema de modulação utilizado.
    - Taxas mais altas podem aumentar a probabilidade de erros, especialmente em condições de SNR baixa.

3. **SNR (Signal-to-Noise Ratio)**:
    - Mede a potência do sinal útil em relação ao ruído no canal.
    - Expressa em decibéis (dB) pela fórmula:
      \[
      SNR(dB) = 10 \cdot \log_{10}\left(\frac{P_{\text{sinal}}}{P_{\text{ruído}}}\right)
      \]
    - Um SNR alto significa um canal mais limpo e confiável.

---

#### **Exemplo Numérico**
1. Suponha um canal com \(P_{\text{sinal}} = 100\) mW e \(P_{\text{ruído}} = 10\) mW:
   \[
   SNR = 10 \cdot \log_{10}(10) = 10 \, \text{dB}.
   \]
2. Com modulação BPSK (1 Mbps), a BER para um SNR de 10 dB é \(10^{-7}\).
3. Em contraste, com QAM16 (4 Mbps), a BER para o mesmo SNR pode ser \(10^{-1}\), tornando o canal inutilizável para dados confiáveis.

#### **Impacto Prático**
- Um canal com BER de \(10^{-5}\) transmitindo 1 GB (\(8 \times 10^9\) bits) teria \(80.000\) bits com erro, exigindo correções ou retransmissões.

---

### **2. CDMA (Code Division Multiple Access)**

#### **Definição**
CDMA é uma técnica que permite que múltiplos dispositivos compartilhem o mesmo canal de comunicação simultaneamente. Cada dispositivo utiliza um código único para transmitir e receber dados, separando as comunicações mesmo no mesmo espectro de frequência.

#### **Funcionamento**
1. **Codificação**:
    - Cada bit de dados é multiplicado por um código exclusivo, chamado "chip".
    - O código muda em uma frequência maior do que a dos dados transmitidos.

2. **Decodificação**:
    - O receptor aplica o mesmo código para recuperar os dados do sinal recebido.

#### **Cálculo e Exemplo Prático**
1. **Codificação**:
    - Dado \(d_1 = 1\) (representado por \(+1\)) e o código \(C = [+1, +1, -1, +1]\):  
      \[
      Z = d_1 \cdot C = [+1, +1, -1, +1].
      \]

2. **Decodificação**:
    - O receptor multiplica o sinal recebido pelo código e soma os resultados:
      \[
      d_1 = \frac{1}{M} \sum_{i=1}^M (Z_i \cdot C_i).
      \]
    - Para \(M = 4\):  
      \[
      d_1 = \frac{1}{4} \cdot [(+1 \cdot +1) + (+1 \cdot +1) + (-1 \cdot -1) + (+1 \cdot +1)] = +1.
      \]

#### **Vantagens**
- Alta eficiência em canais compartilhados.
- Resistente a interferências e ruídos.

#### **Desafios**
- Seleção cuidadosa de códigos para evitar interferências entre usuários.
- Depende da uniformidade na potência dos sinais transmitidos.

---

### **Resumo Final**
- **Erro de bits** reflete a confiabilidade do canal, influenciada pela **taxa de transmissão** e **SNR**.
- **CDMA** resolve problemas de compartilhamento de canal em redes móveis, utilizando códigos únicos para comunicação simultânea.
- Conceitos como BER, SNR e CDMA são fundamentais para entender como dados são transmitidos de forma eficiente e confiável em redes modernas.

---