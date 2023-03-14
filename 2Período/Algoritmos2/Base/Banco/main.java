import Classes.Functionario;
import Classes.Gerente;

public class main {
    public static void main(String[] args){
      Gerente gerente = new Gerente();

      gerente.setNome("Joao");
      String nome = gerente.getNome();

      gerente.setCpf("2494934934");
      String cpf = gerente.getCpf();

      gerente.setSalario(2500);
      Double salario = gerente.getSalario();

      gerente.setSenha(1);

      System.out.println(gerente.getInformacoes());
    }
}
