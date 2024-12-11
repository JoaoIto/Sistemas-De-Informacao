# **README: Exercícios de Fixação e Questões de Revisão**

Este README contém as questões de revisão e exercícios de fixação baseados no conteúdo do Capítulo 6 de Redes de Computadores e a Internet, abordando diversos tópicos sobre redes sem fio e redes móveis. Cada questão é seguida de uma explicação detalhada da resposta.

## **Seção 6.1**

### **R1. O que significa para uma rede sem fio estar operando no “modo de infraestrutura”? Se a rede não estiver nesse modo, em qual modo ela está e qual é a diferença entre esse modo de operação e o de infraestrutura?**
**Resposta:**
Quando uma rede sem fio está operando no "modo de infraestrutura", significa que todos os dispositivos sem fio se conectam a um ponto de acesso (AP), que é responsável por gerenciar a comunicação entre os dispositivos e a rede maior (como a internet). Se a rede não estiver no modo de infraestrutura, ela estará no **modo ad hoc**, onde os dispositivos se comunicam diretamente entre si, sem a necessidade de um ponto de acesso intermediário.

### **R2. Quais são os quatro tipos de redes sem fio identificadas em nossa taxonomia na Seção 6.1? Quais desses tipos de rede sem fio você usou?**
**Resposta:**
Os quatro tipos de redes sem fio identificados são:
1. **Infraestrutura**: Dispositivos se conectam a um ponto de acesso.
2. **Ad hoc**: Comunicação direta entre dispositivos sem um ponto de acesso.
3. **Mesh**: Redes de múltiplos dispositivos que se conectam entre si e à rede.
4. **Personal Area Network (PAN)**: Rede de dispositivos em uma área muito pequena, como Bluetooth.

Eu uso redes **de infraestrutura** em minha casa e no trabalho (Wi-Fi).

## **Seção 6.2**

### **R3. Quais são as diferenças entre os seguintes tipos de falhas no canal sem fio: atenuação de percurso, propagação multivias, interferência de outras fontes?**
**Resposta:**
- **Atenuação de percurso**: O sinal enfraquece à medida que viaja através do espaço devido à distância e aos obstáculos, como paredes e edifícios.
- **Propagação multivias**: O sinal pode seguir diferentes trajetos, refletindo em superfícies como paredes e objetos. Isso pode causar interferência e distorção.
- **Interferência de outras fontes**: Refere-se ao ruído causado por dispositivos que operam na mesma frequência, como micro-ondas ou outros dispositivos sem fio.

### **R4. Um nó móvel se distancia cada vez mais de uma estação-base. Quais são as duas atitudes que uma estação-base poderia tomar para garantir que a probabilidade de perda de um quadro transmitido não aumente?**
**Resposta:**
1. **Aumentar a potência de transmissão**: A estação-base pode aumentar a potência do sinal para alcançar o nó móvel à medida que ele se afasta.
2. **Realizar handoff para outra estação-base**: O nó móvel pode ser transferido para uma estação-base mais próxima para manter a qualidade da comunicação.

## **Seções 6.3-6.4**

### **R5. Descreva o papel dos quadros de sinalização em 802.11.**
**Resposta:**
Os quadros de sinalização em 802.11, como RTS, CTS, e ACK, são usados para gerenciar o acesso ao meio de transmissão, evitando colisões e controlando a comunicação entre os dispositivos. Eles ajudam a garantir que os dados sejam transmitidos de maneira ordenada e sem interferências.

### **R6. Verdadeiro ou falso: antes de uma estação 802.11 transmitir um quadro de dados, ela deve primeiro enviar um quadro RTS e receber um quadro CTS correspondente.**
**Resposta:**
**Falso**. O quadro RTS/CTS é opcional e é usado para evitar colisões em transmissões de longa duração. Para transmissões curtas, a estação pode simplesmente enviar os dados sem passar por esse processo.

### **R7. Por que são usados reconhecimentos em 802.11, mas não em Ethernet cabeada?**
**Resposta:**
Em 802.11, o reconhecimento (ACK) é utilizado para garantir que os quadros foram recebidos corretamente, pois o canal sem fio é propenso a interferências e erros. Já em Ethernet cabeada, a comunicação é mais confiável, então não é necessário usar ACKs para confirmar a entrega dos dados.

### **R8. Verdadeiro ou falso: Ethernet e 802.11 usam a mesma estrutura de quadro.**
**Resposta:**
**Falso**. Embora ambos os padrões de rede usem uma estrutura de quadro para transmitir dados, o formato específico e os campos do quadro são diferentes entre Ethernet e 802.11.

### **R9. Descreva como funciona o patamar RTS.**
**Resposta:**
O **patamar RTS** define um limite de tamanho para os quadros. Se o quadro a ser transmitido for maior do que o valor do patamar, a estação usará RTS/CTS para garantir que o canal esteja livre antes da transmissão. Caso contrário, o quadro será enviado diretamente sem essa verificação.

### **R10. Suponha que os quadros RTS e CTS IEEE 802.11 fossem tão longos quanto os padronizados DATA e ACK. Haveria alguma vantagem em usar os quadros CTS e RTS? Por quê?**
**Resposta:**
Não haveria vantagem em usar RTS e CTS longos, pois esses quadros têm como objetivo reservar o canal e evitar colisões. Se forem do mesmo tamanho que os quadros de dados e ACK, a eficiência da rede seria reduzida, pois a quantidade de dados úteis transmitidos seria menor devido ao maior overhead de controle.

### **R11. A Seção 6.3.4 discute mobilidade 802.11, na qual uma estação sem fio passa de um BSS para outro dentro da mesma sub-rede. Quando os APs estão interconectados com um comutador, um AP pode precisar enviar um quadro com um endereço MAC fingido para fazer o comutador transmitir quadros adequadamente. Por quê?**
**Resposta:**
Quando uma estação se move de um BSS para outro, o novo AP pode precisar "fingir" o endereço MAC para garantir que os quadros sejam entregues corretamente ao comutador e, por conseguinte, à estação móvel. Isso é necessário para garantir que o tráfego seja direcionado corretamente dentro da sub-rede, já que o comutador pode precisar encaminhar os quadros para o novo AP sem ter um endereço MAC válido.

---

## **Seção 6.7**

### **R19. Quais são os objetivos do HLR e VLR nas redes GSM? Quais elementos de IP móvel são semelhantes ao HLR e ao VLR?**
**Resposta:**
- **HLR (Home Location Register)**: Armazena informações sobre os assinantes, como localização e serviços disponíveis.
- **VLR (Visitor Location Register)**: Mantém informações temporárias sobre os usuários que estão visitando uma área fora da sua localização original.

Em redes de **IP móvel**, o **HLR** é semelhante ao **Home Agent**, e o **VLR** se assemelha ao **Foreign Agent**, ambos ajudando a rotear os dados para os usuários móveis, com base em sua localização.

---

