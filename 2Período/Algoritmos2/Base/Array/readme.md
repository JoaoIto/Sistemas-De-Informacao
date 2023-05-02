# Array 

## Array List

Uma forma de um framework integrado do java de funcionalidade
é o ***Array List***. Na qual ele consegue entender que o próprio
array possui seus próprios métodos...

````java
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Array list: ");
        List list = new ArrayList<>();

        list.add(0, 1);
        System.out.println(list);
    }
}
````

````
[1]
````

---

### Methods base for ArrayList

A seguir listei os principais métodos fornecidos por uma classe ArrayList:

- Método add – Adiciona um elemento no final do ArrayList.


- Método clear – Remove todos os elementos da estrutura.


- Método contains – Verifica se o ArrayList contém um elemento especificado, e retorna true em caso positivo, ou false caso contrário.


- Método get – Retorna o item em uma posição de índice especificada.


- Método indexOf – Retorna a posição de índice da primeira ocorrência de um elemento especificado.


- Método remove – Remove a primeira ocorrência de um valor especificado ou de um elemento em um índice.


- Método size – Informa o número de elementos que estão armazenados na estrutura.


- Método trimToSize – Ajusta a capacidade do ArrayList de acordo com o número de elementos armazenados no momento.

---