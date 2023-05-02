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