import java.util.*;

public class Ex_daniel {
    static class matriculado {
        String nome, tipoTreino;
        double peso, altura, imc;
        int idade, tempo, dia; 
        int statusCadastro;
    } 

    public static void main(String[] args){

        matriculado[] alunos;
        alunos = new matriculado[100];

        matriculado[] alunosCadastro;
        alunosCadastro = new matriculado[100];

        for(int i=0; i<100; i++){
            alunos[i] = new matriculado();
            alunosCadastro[i] = new matriculado();
        }

        for(int i=0; i<100; i++){
            alunos[i].statusCadastro = 0; // cadastro ainda está vazio
            alunosCadastro[i].statusCadastro = 0; // cadastro ainda vazio
        }

        int diames, choose, opcao, execucao=1;

        Scanner leia = new Scanner(System.in);

        System.out.print("Bem-vindo ao programa da Academia TOPLINE!");
        System.out.print("\nInforme o dia do mês que estamos hoje: ");
        diames = leia.nextInt();

        while(execucao == 1){
            System.out.print("\nDigite a opção 1 para CONSULTAR UM ALUNO.\nDigite a opção 2 para CADASTRAR UM ALUNO.\n");
            opcao = leia.nextInt();

            if(opcao == 1){
                System.out.print("\tCONSULTA DE CADASTROS\nDigite algum número de 0 a 100 para consultar o cadastro: ");
                choose = leia.nextInt();
                ConsultarAluno(alunosCadastro, choose);

            }else if(opcao == 2)
                alunosCadastro = CadastrarAluno(alunos, diames);

            alunos = alunosCadastro;

            System.out.print("Deseja cadastrar ou consultar outro aluno?\nSe sim, digite 1. Se não, digite 2.\n");
            execucao = leia.nextInt();
        }
    }

    public static void ConsultarAluno(matriculado[] lista, int escolha)
    {
        Scanner read = new Scanner(System.in);
        while(escolha != 100) {

            char escolher; 
            int verificador = -1; 
            System.out.print("Verificando se o aluno " + escolha + " está cadastrado.\n");

            for (int i = escolha; i < 100; i++){ 
                if (lista[i].statusCadastro == 0) {
                    System.out.print("Não existe aluno cadastrado na posição " + i + "!");
                    System.out.print("\nDeseja consultar outro aluno? Digite s para sim e n para não: ");

                    escolher = read.next().charAt(0);
                    if (escolher == 'n') {
                        verificador = 0;
                        i = 100;
                    } else if (escolher == 's') {
                        System.out.print("\nEscolha outro aluno para consultar os dados.");
                        escolha = read.nextInt();
                    }

                } else { // se não, significa que o aluno foi cadastrado com sucesso.
                    System.out.print("Aluno encontrado! Vamos fazer o display de todos os dados.");
                    verificador = 1;
                    i = 100;
                }
            }

            while(verificador == 1) { //faz o display de dados quando encontra um cadastro.
                for (int i = escolha; i < 100; i++) {
                    System.out.print("\nNome do aluno " + i + ": " + lista[i].nome + ".");
                    System.out.print("\nIdade do aluno " + i + ": " + lista[i].idade + " anos.");
                    System.out.print("\nPeso do aluno " + i + ": " + lista[i].peso + "kg.");
                    System.out.print("\nAltura do aluno " + i + ": " + lista[i].altura + "m.");
                    System.out.print("\nIMC do aluno " + i + ": " + lista[i].imc + "m.");
                    System.out.print("\nTempo de treino do aluno " + i + ": " + lista[i].tempo + ".");
                    System.out.print("\nTipo de treino do aluno " + i + ": " + lista[i].tipoTreino + ".");

                    System.out.print("\nDeseja consultar outro aluno? Digite s para sim e n para não: ");
                    escolher = read.next().charAt(0);
                    if (escolher == 'n') {
                        verificador = 0;
                        i = 100;
                        escolha = 100; // linhas 139 e 140 - não vai escolher nenhum aluno
                    } else if (escolher == 's') {
                        System.out.print("\nEscolha outro aluno para consultar os dados.");
                        escolha = read.nextInt();
                    }

                    //linhas 135 a 144 - verifica se o usuário quer fazer outra leitura de código.
                }
            }
        }
    }

    public static matriculado[] CadastrarAluno(matriculado[] list, int day){
        Scanner leitor = new Scanner(System.in);
        int escolha = 1;

        while (escolha == 1) {

            System.out.print("Verificando cadastros.\n");
            for (int i=0; i<100; i++) {
                if (list[i].statusCadastro == 0){
                    System.out.print("Posição " + i + " vaga! Vamos cadastrar seu aluno nessa posição.\n");
                    escolha = i;
                    i = 100;
                }
            }

            for(int i=escolha; i<100; i++){
                System.out.print("Olá, você está cadastrando o aluno " + i + "!\n");
                System.out.print("Escreva e aperte enter para os seguintes dados do aluno: \nNome; \nIdade;\nPeso (kg);\nAltura (m);\nDia do cadastro (apenas dia);\nTempo que treina (meses);\n");

                list[i].nome = leitor.nextLine();
                list[i].idade = leitor.nextInt();
                list[i].peso = leitor.nextDouble();
                list[i].altura = leitor.nextDouble();
                list[i].dia = leitor.nextInt();
                list[i].tempo = leitor.nextInt(); 
                list[i].tempo = calcularTempo(list[i].dia, day, list[i].tempo);
                list[i].imc = calculoImc(list[i].peso, list[i].altura);
                list[i].tipoTreino = tiparTreino(list[i].tempo);

                list[i].statusCadastro = 1; // cadastrado com sucessso!

                System.out.print("Deseja cadastrar mais alunos?\n1 para SIM\n2 para NÃO.\n");
                escolha = leitor.nextInt();

                if (escolha == 2)
                    i = 100;
                else
                    System.out.print("\nCadastrando o próximo aluno.");

                // linhas 193 a 199 - verifica se o usuário deseja cadastrar mais alunos (ou não).
            }
        }
        return list;
        //envia a lista atualizada para o main (e para ser usada em outras verificações/cadastros).
    }

    public static int calcularTempo(int diaCadastro, int diaMes, int mes){
        if(diaMes >= diaCadastro)
            mes = mes+1;

        return mes;
    } 

    public static double calculoImc(double kg, double alt){
        double imc;
        imc = kg/(alt*alt);
        return imc;
    } 

    public static String tiparTreino(int time){
        String tipTrain;
        if(time<=3)
            tipTrain = "Iniciante";
        else if(time<=6)
            tipTrain = "Intermediario";
        else if(time<=12)
            tipTrain = "Marombeiro junior";
        else if(time <= 24)
            tipTrain = "Marombeiro senior";
        else
            tipTrain = "Arnold Schwaznegger";
        return tipTrain;
    } // método usado para definir o treino, conforme enunciado da questão:
    // até 3 meses: iniciante,
    // 4 e 6 meses: intermediário,
    // entre 7 meses e 1 ano: matriculado junior,
    // entre 1 e 2 anos: matriculado sênior,
    // acima de 2 anos: Arnold Schwarzenegger.
}
