# Relacionamento entre classes:

**Esta pasta mostra exercícios de criação de objetos em relacionamento difente entre classes e como eles podem se comportar entr si!**

E assim, criamos cada objeto dependendo ou não uma da outra.

## Associação:

Entendo que esta é a classe principal, de aluno já que
herda elementos de outra classe, que por ela mesma
já a herdar elemento de outra classe. E assim temos:

- Um objeto da classe Aluno tem uma referência para um
ou mais objetos da classe Disciplina, indicando que
o aluno está matriculado nessas disciplinas;

- Um objeto da classe Disciplina tem uma referência para um
objeto da classe Professor, indicando que o professor é responsável
por ministrar aquela disciplina.

## Agregação:

A referência para a classe é herdada, é feita
a partir de um próprio objeto é colocado como atributo
na classe;



- Esta classe possui um endereçamento de
1 - n Endereços, já que pode ter vários endereços
relacionadas, pois ele é criado como um atributo da própria pessoa
com essa referência de objeto.

- Na sua instância, se entende que, o objeto Pessoa, pode ser criado
independentemente da classe de endereços, não necessariamente
associando-lhe, porém, entende-se que esse relacionamento parte que,
não é bom que endereço possa ser criado sem uma pessoa relacionada a ele
e assim, temos uma agregação!

## Composição:

- sim se um objeto Carro for destruído, o objeto Motor
que ele compõe também será destruído. Se outro objeto Carro
de um objeto Motor, ele precisará criar um objeto Motor,
já que o objeto Motor que pertencia ao objeto Carro anterior
foi destruído com ele.

Tendo assim uma relação composta, já como o nome diz, de
composição.
