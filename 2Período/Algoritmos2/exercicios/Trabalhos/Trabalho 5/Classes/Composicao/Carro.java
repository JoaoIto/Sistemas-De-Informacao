package Classes.Composicao;

// Temos aqui uma relação de Compsição;

/*
Assim se um objeto Carro for destruído, o objeto Motor
que ele compõe também será destruído. Se outro objeto Carro
de um objeto Motor, ele precisará criar um objeto Motor,
já que o objeto Motor que pertencia ao objeto Carro anterior
foi destruído com ele.

Tendo assim uma relação composta, já como o nome diz, de
composição

 */
public class Carro {
    private Motor motor;

    public Carro() {
        this.motor = new Motor();
    }

    public Motor getMotor() {
        return motor;
    }
}