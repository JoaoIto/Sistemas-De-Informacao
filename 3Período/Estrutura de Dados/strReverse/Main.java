import classes.StringReverse;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String palavra = "nardini";
        String palavraSeparada = StringReverse.separa(palavra);
        System.out.println("A palavra "+ palavra + " separa é: " + palavraSeparada);

        String palavraReverse = StringReverse.reverte(palavra);
        System.out.println("E a palavra em reverse é: " + palavraReverse);
    }
}
