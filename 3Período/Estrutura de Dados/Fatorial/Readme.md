# Fatorial

O princípio de fatorial é declarar um número 
de depois multiplicar esse número por todos 
os seus antecessores, e assim o seu mais 
próximo antecessor se tornará esse número, 
até o número ser zero...

---

## Code

Usando recursividade, consegui fazer, somente chamando a 
própria função com o mesmo número menos 1.

````java
public static int fatorar(int numero){
        if(numero == 0){
            return 1;
        }else{
            System.out.println(numero + " * " + (numero - 1));
            return numero * fatorar(numero - 1);
        }
    }
````

---