package classes;

import java.util.List;

public class StringReverse {
    private String str;
    private char letra;
    private String reverseString;

    public StringReverse() {
    }

    public void append(char c) {
        str += c;
    }

    public void append(String s) {
        str += s;
    }

    public String toString() {
        return str;
    }

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
}
