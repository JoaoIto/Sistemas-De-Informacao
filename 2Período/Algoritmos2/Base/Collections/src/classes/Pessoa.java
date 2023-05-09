package src.classes;

public class Pessoa implements Comparable<Pessoa>{
    private String name;
    private String cpf;
    private int age;

    public Pessoa(String name, String cpf, int age) {
        super();
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.name.compareTo(o.getName());
        //return getName().compareTo(this.name);
    }
}
