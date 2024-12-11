### **Campos de Endereço no Quadro IEEE 802.11**

#### **1. Contextualização**
Em redes sem fio baseadas no padrão IEEE 802.11, a comunicação entre dispositivos é organizada e gerida através de quadros que contêm diferentes campos. Entre esses campos, os **campos de endereço** são fundamentais para garantir que os dados sejam entregues ao destino correto, seja ele um dispositivo ou um ponto de acesso (AP). O IEEE 802.11 usa endereços **MAC** (Media Access Control) únicos para identificar dispositivos na rede.

Os campos de endereço no quadro IEEE 802.11 garantem que os pacotes de dados cheguem ao seu destino correto, permitindo a comunicação entre múltiplos dispositivos e, em muitos casos, um ponto de acesso intermediário. Estes campos também são essenciais para o gerenciamento de redes, incluindo as conexões entre dispositivos e pontos de acesso.

---

#### **2. Definição**
Os **campos de endereço** no quadro IEEE 802.11 são responsáveis por especificar os dispositivos envolvidos na transmissão de dados. Esses campos são cruciais para direcionar os quadros de dados para os destinatários corretos e possibilitar a comunicação em redes locais sem fio. O número de campos de endereço varia conforme o tipo de quadro (dados, controle ou gerenciamento), mas pode incluir até **quatro endereços diferentes**.

---

#### **3. Tipos de Endereço**

O quadro IEEE 802.11 pode conter até **quatro campos de endereço**, dependendo do tipo de comunicação:

1. **Endereço de Destino (Address 1)**:
    - **Função**: Indica o dispositivo ou o ponto de acesso que deve receber o quadro.
    - **Exemplo**: Se o quadro for destinado a um dispositivo específico, esse dispositivo terá seu endereço MAC como o "Endereço de Destino".

2. **Endereço de Origem (Address 2)**:
    - **Função**: Indica o dispositivo ou ponto de acesso que está enviando o quadro.
    - **Exemplo**: Se um dispositivo H1 está enviando dados para o ponto de acesso (AP), o endereço de origem será o endereço MAC do H1.

3. **Endereço do Ponto de Acesso (Address 3)**:
    - **Função**: Quando o quadro passa por um ponto de acesso (AP), o endereço de origem ou destino do quadro pode ser o endereço do AP, ou seja, o endereço 3.
    - **Exemplo**: Se o quadro de dados for enviado de um dispositivo H1 para outro dispositivo H2 através de um AP, o endereço 3 poderia ser o endereço do AP.

4. **Endereço do Próximo Salto (Address 4)**:
    - **Função**: Em redes que utilizam múltiplos saltos (como redes ad hoc ou redes de malha), este campo pode ser utilizado para especificar o próximo dispositivo ou ponto de acesso para onde os dados devem ser enviados.
    - **Exemplo**: Em uma rede de múltiplos saltos, o endereço 4 poderia ser o próximo roteador ou dispositivo que deve encaminhar os dados.

---

#### **4. Funcionamento dos Campos de Endereço**

A forma como os campos de endereço são usados depende do tipo de quadro e do tipo de comunicação. Vamos ver os casos de uso para diferentes tipos de quadros:

1. **Quadro de Dados**:
    - **Endereço 1**: Destinatário (dispositivo ou ponto de acesso).
    - **Endereço 2**: Remetente (dispositivo que envia os dados).
    - **Endereço 3**: Se o quadro passar por um AP, o endereço do AP será utilizado.
    - **Endereço 4**: Não é utilizado, pois os quadros de dados normalmente não precisam de um próximo salto.

2. **Quadro de Controle (RTS/CTS)**:
    - **Endereço 1**: Destinatário do quadro de controle (normalmente o ponto de acesso ou o dispositivo que solicita ou autoriza a transmissão).
    - **Endereço 2**: Remetente do quadro de controle (quem está solicitando ou permitindo a transmissão).
    - **Endereço 3 e 4**: Não utilizados, a menos que a comunicação envolva múltiplos saltos, como em redes de malha.

3. **Quadro de Gerenciamento**:
    - **Endereço 1**: Destinatário do quadro de gerenciamento, como em quadros de autenticação ou associação.
    - **Endereço 2 e 3**: Dependem do tipo de quadro e das interações com o ponto de acesso.
    - **Endereço 4**: Usado em redes de múltiplos saltos ou em redes ad hoc.

---

#### **5. Exemplos Práticos**

##### **Exemplo 1: Comunicação Direta (Sem AP)**
- **Cenário**: Dois dispositivos, H1 e H2, estão em modo ad hoc e se comunicam diretamente, sem um ponto de acesso.
- **Campos de Endereço**:
    - **Endereço 1**: Endereço MAC de H2 (destinatário).
    - **Endereço 2**: Endereço MAC de H1 (remetente).
    - **Endereço 3 e 4**: Não são utilizados, pois não há um ponto de acesso ou múltiplos saltos.

##### **Exemplo 2: Comunicação com Ponto de Acesso**
- **Cenário**: O dispositivo H1 envia dados para o dispositivo H2, passando pelo ponto de acesso (AP).
- **Campos de Endereço**:
    - **Endereço 1**: Endereço MAC de H2 (destinatário).
    - **Endereço 2**: Endereço MAC de H1 (remetente).
    - **Endereço 3**: Endereço MAC do AP (se for utilizado para encaminhar os dados).
    - **Endereço 4**: Não é utilizado, pois a comunicação envolve apenas dois saltos (H1 -> AP -> H2).

##### **Exemplo 3: Rede de Malha**
- **Cenário**: Dispositivos H1, H2, e H3 estão em uma rede de malha, e H1 precisa enviar dados para H3, passando por H2.
- **Campos de Endereço**:
    - **Endereço 1**: Endereço MAC de H3 (destinatário final).
    - **Endereço 2**: Endereço MAC de H1 (remetente).
    - **Endereço 3**: Endereço MAC de H2 (o dispositivo intermediário).
    - **Endereço 4**: Endereço MAC de H3, indicando o próximo salto ou destino final.

---

#### **6. Resumo Didático**
Os **campos de endereço** são essenciais para garantir que os dados sejam enviados para os destinatários corretos em uma rede Wi-Fi. Com até **quatro endereços possíveis**, esses campos podem especificar tanto os dispositivos finais quanto os pontos de acesso ou roteadores intermediários, possibilitando a comunicação eficiente entre os dispositivos.

- **Endereço 1**: Destinatário.
- **Endereço 2**: Remetente.
- **Endereço 3**: Pode ser o AP ou um dispositivo intermediário.
- **Endereço 4**: Usado em redes de múltiplos saltos.

Esses campos são fundamentais para a operação de redes Wi-Fi, especialmente em ambientes com múltiplos dispositivos e APs.

---