package app;

import classes.matematica;
import classes.multiplicaCast;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Vamos testar as operações de matemática!");

        // Instanciando a classe matemática
        matematica mat = new matematica();

        // Testando os métodos de operações matemáticas
        double n1 = 10.5;
        double n2 = 5.2;
        double resultadoSoma = mat.soma(n1, n2);
        double resultadoSubtrai = mat.subrai(n1, n2);
        double resultadoMultiplica = mat.multiplica(n1, n2);
        double resultadoDivide = mat.divide(n1, n2);

        // Exibindo os resultados
        // Os resultados com duas casas decimais
        System.out.printf("Resultado da soma: %.2f\n", resultadoSoma);
        System.out.printf("Resultado da subtração: %.2f\n", resultadoSubtrai);
        System.out.printf("Resultado da multiplicação: %.2f\n", resultadoMultiplica);
        System.out.printf("Resultado da divisão: %.2f\n", resultadoDivide);

        matematica m = new matematica();
        multiplicaCast mc = new multiplicaCast(m);

        // Testando os métodos sobrecarregados com diferentes tipos de parâmetro;

        System.out.println(mc.multiplica(2, 3));  // int, int
        System.out.println(mc.multiplica((int) 2.5f, (int) 3.2f));  // float, float
        System.out.println(mc.multiplica((int) 2.5f, (int) 3.2));  // float, double
        System.out.println(mc.multiplica((int) 2.5, (int) 3.2f));  // double, float
        System.out.println(mc.multiplica(2L, 3));  // long, int
        System.out.println(mc.multiplica(2, 3L));  // int, long
        float f1 = Float.valueOf(2.5f);
        double d1 = Double.valueOf(3.14);
        System.out.println(mc.multiplica(2, f1));  // int, Float
        System.out.println(mc.multiplica((int) 2.5f, d1));  // float, Double

    }
}
