## Criando a tabela do banco de dados

```sql
create database sucos;

create table tbcliente(
 CPF varchar(45),
 NOME varchar(100),
 ENDERECO1 varchar(150),
 ENDERECO2 varchar(150),
 BAIRRO varchar(70),
 CIDADE varchar(70),
 ESTADO varchar(70),
 CEP varchar(8),
 IDADE smallint,
 SEXO varchar(1),
 LIMITE_CREDITO float,
 VOLUME_COMPRA float,
 PRIMEIRA_COMPRA bit(1)
);
```

**Estamos aqui com um código de SQL, que faz o papel de criar a tabela dentro do banco de dados sucos que criamos. Primeira coisa, o comando de `create database <nome>` , este é o comando base de criação de banco de dados, na qual vimos logo na tela a esquerda da interface quando atualizada.**

**Logo depois, usamos o comando create novamente, só que agora diretamente com a criação da tabela, em si, com seu nome especificado, e assim seus campos. Comando base `create table <nome> (<camposCriados>)` . O comando aqui deve ser especificados os campos a serem criados, e assim o comando para a colocação de vários campos é de: `<nome> <tipo- <tamanhoDoTipo>>,`, sempre assim separados por vírgula cada campo, fazendo esta separação.**

---

## Inserindo dados na tabela

Dentro do SQL, mesmo podendo fazer isso ao mesmo RUN de código, é comum que depois que criamos a tabela, assim queremos inserir os dados a serem colocados dentro desta tabela. E para isso também usamos comando, assim com seus parâmetros também a serem criados. Vamos lá:

```sql
use Sucos; // Interface seleciona nativamente, porém é de boa prática utilizar

INSERT INTO tbcliente(
 CPF,
 NOME
) VALUES (
  '111222333444', 'Joao Victor Póvoa França'
  ); // informações que obedecem a ordem dos parâmetros
```

**O comando a ser colocado para inserimentos na tabela, como o próprio nome diz, `insert into <nomeTabela> ( <campos> ) values ( <dados> );` , esperando que, todos os campos devem ser citados respeitando seus valores de criação, ou seja, tipo de valores, e assim logo depois de ser especificado, os campos a serem inseridos, devemos assim testar os valores diretamente.**

**No exemplo de código, citamos o tipo mais comum a ser utilizado, que é um  `varchar()`, uma *string* de valor delimitado. E assim usamos a sintaxe de aspas simples envolvendo o valor, e assim seu dados, sempre separados por vírgula,**

---
