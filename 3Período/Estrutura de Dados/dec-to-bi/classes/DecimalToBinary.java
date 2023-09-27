package classes;

public class DecimalToBinary {
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0"; // Caso base: O número 0 em decimal é 0 em binário
        } else if (decimal == 1) {
            return "1"; // Caso base: O número 1 em decimal é 1 em binário
        } else {
            int remainder = decimal % 2;
            int quotient = decimal / 2;
            String binaryPart = decimalToBinary(quotient);
            return binaryPart + Integer.toString(remainder);
        }
    }
}