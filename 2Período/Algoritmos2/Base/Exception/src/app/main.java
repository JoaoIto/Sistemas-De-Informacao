package src.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Integer age;

        boolean tentativa = true;

        while (tentativa) {
            System.out.println("Informe a sua idade: ");
            try {
                age = scan.nextInt();
                System.out.println("A idade é de: " + age);
                tentativa = false;
            } catch (InputMismatchException error) {
                System.out.println("Deu a exceção de erro: " + error + "\nInforme um valor numérico!");
                    scan.nextLine();
            } catch (Exception error){
                System.out.println("Null pointer exption" + error);
            }finally {
                System.out.println("Executando!");
            }
        }
    }
}
