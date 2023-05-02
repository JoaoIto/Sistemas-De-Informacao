import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Array list: ");
        List list = new ArrayList<>();

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);

        System.out.println(list);
        list.set(0, 3);
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list.contains(2));
    }
}
