package Classes;
public class Gerente extends Functionario{
    private int senha;

    public boolean autentica(int senha){
        if(this.senha == senha){
            return true;
        }else{
            return false;
        }
    }
}
