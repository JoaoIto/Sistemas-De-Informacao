import java.util.Scanner;

public class listaBase {

    public class Telefone {
        public String codigoArea;
        public String numero;
    }
    
    public class Aluno {
        public Telefone telefone;
        public String nome;
        public Integer idade;
        public String cpf;
    }
    public class Professor {
        public Telefone telefone;
        public String nome;
        public String cpf;
        public Integer idade;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Aluno aluno = new Aluno();
        aluno.telefone = new Telefone();

        System.out.println("Informe o nome do aluno: ");
        aluno.nome = scan.next();

        System.out.println("Informe o cpf do aluno: ");
        aluno.cpf = scan.next();

        System.out.println("Informe a idade do aluno: ");
        aluno.idade = scan.nextInt();

        System.out.println("Informe o código de área do telefone do aluno: ");
        aluno.telefone.codigoArea = scan.next();

        System.out.println(aluno.nome);
        System.out.println(aluno.telefone.numero);
    }
}