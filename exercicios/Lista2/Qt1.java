import java.util.Scanner;

public class Qt1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        int countIn, countFn;
        
        System.out.print("Insira o número inicial:");
        countIn = leitor.nextInt();
        
        System.out.print("Insira o número final:");
        countFn = leitor.nextInt();
        
        for(int i = countIn; i < countFn; i++){
            System.out.print(i + "\n");
        }
        System.out.print(countFn);
      }
}
