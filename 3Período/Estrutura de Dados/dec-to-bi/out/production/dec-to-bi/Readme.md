# Dec to Binary

- Crie um programa recursivo que convertar um número decimal para numero binário.

---

## Code

A classe ***DecimalToBinary*** contém um método chamado decimalToBinary, que é uma função recursiva para converter números decimais em binários. 

Ela segue um padrão de recursão, dividindo o número decimal em duas partes: a parte inteira (quotient) e o dígito menos significativo (remainder). 

Ela então chama a si mesma recursivamente com a parte inteira até atingir os casos base (0 e 1), e em seguida, concatena os resultados para construir a representação binária completa.

````java
public class DecimalToBinary {
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0"; 
        } else if (decimal == 1) {
            return "1"; 
        } else {
            int remainder = decimal % 2;
            int quotient = decimal / 2;
            String binaryPart = decimalToBinary(quotient);
            return binaryPart + Integer.toString(remainder);
        }
    }
}

````


---