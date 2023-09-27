# ReverseString

Código para reverter string, basicamente usando for incrementando
para a separação dessas strings, e depois normalmente usando o mesmo
for somente decrementando para que pudesse reverter os seus índices 
de letras e assim continuar.

Detalhe que faço códigos diferentes, portando o código de reverse usa
recursividade quando chama o código de separar dentro dele.


## Code: 

````java
public static String separa(String str) {
        StringReverse strSeparada = new StringReverse();

        for (int i = 0; i < str.length(); i++) {
            strSeparada.append(str.charAt(i));
            if (i < str.length() - 1) {
                strSeparada.append(" ");
            }
        }
        return strSeparada.toString();
    }

    public static String reverte(String str){
        StringReverse strReversed = new StringReverse();

        // Separar a string com espaços (usando seu código)
        String separatedStr = separa(str);

        // Reverter a string separada
        for (int i = separatedStr.length() - 1; i >= 0; i--) {
            strReversed.append(separatedStr.charAt(i));
        }

        return strReversed.toString();
    }
````

---