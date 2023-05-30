import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe a data de nascimento:\n Ex: dd mm yyyy");
        Integer dia = scan.nextInt();
        Integer mes = scan.nextInt();
        Integer ano = scan.nextInt();

        String data = (dia + " / " + mes + " / " + ano);

        scan.nextLine();

        System.out.println("Informe a sua idade:");
        Integer idade = Integer.parseInt(scan.nextLine());

        System.out.println("Informe seu nome completo:");
        String nome = scan.nextLine();

        System.out.println("Informe o CPF: ");
        String cpf = scan.next();

        System.out.println("Dados: \n");

        System.out.println("Idade: " + idade);
        System.out.println("Nome completo: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de nascimento: " + data);
    }
}
