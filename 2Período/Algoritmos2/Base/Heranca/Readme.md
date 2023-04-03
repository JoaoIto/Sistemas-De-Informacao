# Herança

***Herança* é o relacionamento entre classes, devido a uma classe
superior dentre a uma inferior, e citaremos como exemplo o elemento de classes de
um quadrado, que herda retângulo usando a sintaxe de `extends`**

## Polimorfismo

***Polimorfismo* é a maneira de programar que usar as *superclasses* entendendo a sua relação
entre mais genérica ou mais específica.**

Utilizamos isto no programa a partir do método de `imprimir()`, onde usamos a superclasse de 
retângulo para fazer alterações na subclasse de quadrado.

## `Cast()`:

O método é uma **transformação do Objeto que temos se baseando no método do próprio Java!**

```java
Quadrado quadrado = new Quadrado(5);
Retangulo retangulo = (Retangulo) quadrado;
retangulo.imprimir();
```

- Nesse exemplo, criamos um objeto do tipo Quadrado com um lado de 5 unidades e, em seguida, o convertemos em um objeto do tipo Retângulo usando o método Cast. Por fim, chamamos o método imprimir() do objeto do tipo Retângulo, que, como Retângulo é uma superclasse de Quadrado, pode ser chamado em um objeto do tipo Retângulo e também em um objeto do tipo Quadrado.


## @Override

Aplicação **não obrigatória** no Java, é aplicado quando um método de uam 
subclasse vai usar o método da superclasse, ou seja, herda o método, e assim 
ele precisa ser sobreescrito para ser usado na subclasse.

```java

@Override public void imprimir(){
        System.out.println("As medidas do quadrado são: ");
        super.imprimir();
    }
```

- No exemplo fornecido, a classe Quadrado estende a classe Retângulo e sobrescreve 
o método imprimir() da superclasse Retângulo. Para indicar que estamos a sobreescrever 
o método imprimir() da superclasse, usamos a anotação @Override.

- **O uso da anotação `@Override` é uma *boa prática* de programação em Java, 
pois ajuda a evitar erros de digitação e a garantir que a classe atual 
esteja realmente sobrescrevendo um método da superclasse ou interface.**

---