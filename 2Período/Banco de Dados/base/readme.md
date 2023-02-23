# Comandos base 

SGBD
Interface para SGBD
Restrições de integridade
=> de entidade (toda tabela tem que ter uma chave primária)
=> referencial (relativa à consistência das chaves estrangeiras)

=>Tratamentos das restrições de integridade referencial
==> Cancelamento (no action)
==> Cascateamento (cascade)

Comandos SQL 
DDL - Create database
    - Create table
    - Alter table

DML - Insert, update, delete, select;

-- create database banco12023;
use banco12023;

-- DDL - Data Definition Language (estrutura)
-- entre crases = identificador
/*
create table <nome da tabela> (
 <nome dda coluna> <tipo> <opções>
); */

create TABLE `aluno` (
  `idaluno` INT NOT NULL,
  `nome` VARCHAR(100) NULL,
  `idade` INT NULL,
  `media` FLOAT NULL,
  PRIMARY KEY (`idaluno`)
  );
  
  create TABLE `professor` (
  `idprofessor` INT NOT NULL auto_increment,
  `nome` VARCHAR(100) NULL,
  `especialidade` VARCHAR(100) NULL,
  `grau` VARCHAR(100) NULL,
  PRIMARY KEY (`idprofessor`)
  );
  
  CREATE TABLE `banco12023`.`atividade` (
  `idatividade` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(150) NOT NULL,
  `valor` FLOAT NULL,
  `professor` INT NULL,
  PRIMARY KEY (`idatividade`),
  INDEX `atv_prof_idx` (`professor` ASC) VISIBLE,
  CONSTRAINT `atv_prof`
    FOREIGN KEY (`professor`)
    REFERENCES `banco12023`.`professor` (`idprofessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

/*
CONSTRAINT `nome da restriçao`
    FOREIGN KEY (`tabela referenciada`)
    REFERENCES `coluna que referencia` (`coluna referenciada`) */


-- DML - Data Manipulation Language
/*
insert into <nome da tabela> (lista das colunas) 
                      values (lista de valores para as colunas); */
insert into aluno (idaluno, nome, idade, media)
           values (1, 'Scot Summers', 30, 8.8);

-- select * from <nome da tabela>
select * from aluno;

select * from professor;

-- insert into professor (nome, especialidade, grau) values ('Charles Xavier', 'Telepata', 'Omega');

-- comando DML 

-- delete from professor where idprofessor = 1;

update professor set idprofessor = 2 where idprofessor = 1;


select * from atividade;

insert into atividade (descricao, valor, professor)
               values ('Capinar um lote no mês de agosto, meio dia, em Palmas', 8.5, 1);

