### Resumo A2: Redes Sem Fio e Redes Móveis

A seguir está um resumo dos principais conceitos sobre redes sem fio e móveis para auxiliar no seu estudo.

---

### **1. Redes Sem Fio**
#### **Definição e Elementos**
- Redes sem fio conectam dispositivos (hospedeiros) a uma rede maior sem cabos.
- **Elementos principais**:
    - **Hospedeiros sem fio**: notebooks, smartphones, tablets.
    - **Estação-base (AP)**: conecta dispositivos sem fio à rede maior.
    - **Infraestrutura de rede**: conexão entre APs e a Internet.

#### **Tipos de Redes Sem Fio**
1. **Salto único, com infraestrutura**: Um AP conectado a uma rede maior (ex.: Wi-Fi em cafés).
2. **Salto único, sem infraestrutura**: Dispositivos se conectam diretamente (ex.: Bluetooth).
3. **Múltiplos saltos, com infraestrutura**: Mensagens passam por outros nós antes de alcançar o AP (ex.: redes em malha).
4. **Múltiplos saltos, sem infraestrutura**: Comunicação direta entre dispositivos móveis (ex.: MANETs).

#### **Desafios**
- **Atenuação**: Sinal enfraquece com distância e obstáculos (paredes, árvores).
- **Interferência**: Outros dispositivos na mesma frequência (ex.: micro-ondas).
- **Propagação multivias**: Reflexos criam múltiplos caminhos para o sinal, causando erros.

---

### **2. Wi-Fi (IEEE 802.11)**
#### **Padrões**
- **802.11b**: Até 11 Mbps, frequência de 2,4 GHz.
- **802.11a/g**: Até 54 Mbps, frequências de 2,4 GHz (g) e 5 GHz (a).
- **802.11n**: Usa várias antenas (MIMO), atingindo centenas de Mbps.

#### **Modos**
- **Infraestrutura**: APs conectados a roteadores.
- **Ad hoc**: Dispositivos se conectam diretamente.

#### **Protocolo de Acesso ao Meio (MAC)**
- **CSMA/CA**: Detecta se o canal está livre antes de transmitir.
    - **RTS/CTS**: Mensagens curtas para evitar colisões, especialmente em terminais ocultos.

---

### **3. Redes Móveis**
#### **Definição**
- Redes móveis combinam conectividade sem fio com mobilidade do usuário.

#### **Desafios Técnicos**
- **Localização do usuário**: Encontrar o dispositivo na rede.
- **Hand-off**: Transferir a conexão entre APs ou torres durante movimento.
- **Continuidade**: Manter conexões TCP e chamadas VoIP sem interrupção.

#### **Tecnologias Celulares**
1. **3G**: Oferece chamadas e Internet com taxas moderadas.
2. **4G (LTE)**: Alta velocidade, baixa latência.
3. **5G (emergente)**: Promete conexões ultrarrápidas e suporte a dispositivos IoT.

---

### **4. Exemplos Práticos**
#### **Cenários Cotidianos**
- **Rede Wi-Fi em um café**:
    - AP conectado à Internet.
    - Usuários se associam ao AP após a varredura de canais.
- **Bluetooth em dispositivos pessoais**:
    - Comunicação ponto a ponto em curto alcance (ex.: fones de ouvido).
- **Carros conectados (VANETs)**:
    - Comunicação entre veículos para segurança (ex.: alerta de colisão).

---

### **Dicas para Estudo**
1. **Foque nos elementos básicos** (hospedeiros, enlaces, APs).
2. **Entenda as diferenças entre Wi-Fi, redes móveis e tecnologias celulares.**
3. **Use exemplos do dia a dia** para fixar conceitos (ex.: redes em casa, no trabalho).
4. **Pratique os desafios técnicos** com perguntas como:
    - Como evitar colisões em redes sem fio?
    - O que acontece quando um dispositivo muda de AP?

---