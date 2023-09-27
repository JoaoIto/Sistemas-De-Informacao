import classes.DecimalToBinary;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main, hello world!");

        int decimalNumber = 25; // Altere este número para o decimal que deseja converter
        String binaryResult = DecimalToBinary.decimalToBinary(decimalNumber);
        System.out.println("O número binário de " + decimalNumber + " é: " + binaryResult);
    }
}
