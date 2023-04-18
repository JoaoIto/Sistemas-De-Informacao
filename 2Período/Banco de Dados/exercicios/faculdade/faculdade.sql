/* Trabalho de João Victor Póvoa França */

CREATE DATABASE faculdade;
USE faculdade;

CREATE TABLE alunos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  idade INT,
  email VARCHAR(255)
);

CREATE TABLE cursos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  carga_horaria INT NOT NULL,
  semestres INT NOT NULL,
  area VARCHAR(255) NOT NULL
);

CREATE TABLE disciplinas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  carga_horaria INT NOT NULL,
  valor_aula DECIMAL(10, 2) NOT NULL,
  curso_id INT,
  FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

CREATE TABLE professores (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  idade INT NOT NULL,
  formacao VARCHAR(255) NOT NULL,
  carga_horaria INT NOT NULL,
  valor_aula DECIMAL(10, 2) NOT NULL,
  disciplina_id INT,
  FOREIGN KEY (disciplina_id) REFERENCES disciplinas(id)
);

CREATE TABLE alunos_cursos (
  aluno_id INT,
  curso_id INT,
  PRIMARY KEY (aluno_id, curso_id),
  FOREIGN KEY (aluno_id) REFERENCES alunos(id),
  FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

CREATE TABLE professores_disciplinas (
  professor_id INT,
  disciplina_id INT,
  PRIMARY KEY (professor_id, disciplina_id),
  FOREIGN KEY (professor_id) REFERENCES professores(id),
  FOREIGN KEY (disciplina_id) REFERENCES disciplinas(id)
);

INSERT INTO alunos (nome, cpf, idade, email) VALUES 
('Ana Silva', '11122233344', 25, 'ana.silva@exemplo.com'),
('Bruno Oliveira', '55566677788', 22, 'bruno.oliveira@exemplo.com'),
('Carla Santos', '99988877766', 19, 'carla.santos@exemplo.com'),
('Diego Souza', '33322211100', 29, 'diego.souza@exemplo.com'),
('Eduarda Lima', '77766655533', 18, 'eduarda.lima@exemplo.com'),
('Fabio Costa', '00099988877', 35, 'fabio.costa@exemplo.com'),
('Gabriela Rodrigues', '44433322211', 26, 'gabriela.rodrigues@exemplo.com'),
('Hugo Oliveira', '88877766655', 32, 'hugo.oliveira@exemplo.com'),
('Iara Santos', '22211100099', NULL, 'iara.santos@exemplo.com'),
('Joaquim Barbosa', '66655544433', 17, 'joaquim.barbosa@exemplo.com');

INSERT INTO cursos (nome, carga_horaria, semestres, area) VALUES
('Engenharia de Software', 3000, 10, 'Tecnologia'),
('Arquitetura e Urbanismo', 3600, 12, 'Artes'),
('Administração', 2400, 8, 'Negócios'),
('Direito', 3600, 12, 'Ciências Sociais'),
('Medicina', 8000, 12, 'Saúde');

INSERT INTO disciplinas (nome, carga_horaria, valor_aula) VALUES
('Programação Orientada a Objetos', 60, 25.00),
('Desenvolvimento Web', 80, 30.00),
('Projeto de Arquitetura', 60, 35.00),
('Gestão de Recursos Humanos', 40, 20.00),
('Direito Penal', 80, 40.00),
('Anatomia Humana', 60, 45.00),
('Cálculo I', 60, 35.00),
('Cálculo II', 60, 40.00),
('Redação Jurídica', 40, 30.00);

INSERT INTO professores (nome, idade, formacao, carga_horaria, valor_aula) VALUES
('João Silva', 35, 'Doutorado em Engenharia Elétrica', 40, 80.50),
('Maria Santos', 28, 'Mestrado em Computação', 30, 75.00),
('Pedro Costa', 45, 'Especialização em Administração', 20, 70.00),
('Ana Oliveira', 50, 'Doutorado em Matemática', 35, 90.00),
('Luiz Fernandes', 32, 'Graduação em Química', 25, 60.00),
('Carla Sousa', 42, 'Mestrado em Biologia', 30, 70.00);






/* 01 - Todos os dados dos alunos cujo nome começa com a letra 'A': */
SELECT * FROM alunos WHERE nome LIKE 'A%';

/* 02 - O nome e a idade de todos os alunos: */
SELECT nome, idade FROM alunos;

/* 03 - O nome e o cpf todos os alunos menores de idade: */
SELECT nome, cpf FROM alunos WHERE idade < 18;

/* 04 - O nome, a idade e o e-mail de todos os alunos com idade entre 21 e 35 anos: */
SELECT nome, idade, email FROM alunos WHERE idade BETWEEN 21 AND 35;

/* 05 - Todos os dados dos alunos que não tiveram a idade inserida em seu cadastro: */
SELECT * FROM alunos WHERE idade IS NULL;

/* 06 - O nome e a carga horária de todos os cursos: */
SELECT nome, carga_horaria FROM cursos;

/* 07 - O nome, a carga horária e a carga horária média por semestre de cada curso: */
SELECT nome, carga_horaria, carga_horaria/semestres from cursos;

/* 08 - Todos do curso da area de engenharia */


/* 09 - O nome, a carga horária e a quantidade de semestres dos cursos com carga horária entre 2500 e 3500 horas: */
SELECT nome, carga_horaria, carga_horaria/20 AS qtd_semestres FROM cursos WHERE carga_horaria BETWEEN 2500 AND 3500;

/* 10 - Todos os dados dos cursos com mais de 8 semestres: */
SELECT * FROM cursos WHERE carga_horaria/20 > 8;

/* 11 - Considerando que o valor de uma disciplina é o que se paga por dia, e que em cada dia de aula tem 4 horas de aula, escreva uma consulta que retorne o nome de cada disciplina e o valor a ser pago por hora de aula: */
SELECT nome, valor_aula from disciplinas;

/* 12 - O nome e o id e a carga horária de todas as disciplinas: */
SELECT nome, id, carga_horaria FROM disciplinas;

/*13 - O nome e a idade de todos os professores que são mestres ou tem mestrado:*/
SELECT nome, idade FROM professores WHERE formacao LIKE '%Mestrado%';

/* 14 - Considerando que o salário do professor é a sua carga horária multiplicada pelo valor da hora aula, liste todos os dados dos professores cujo salário está com o valor errado: */
SELECT * FROM professores WHERE salario <> carga_horaria * valor_hora_aula;
 
 /* 15 - Listar o nome, a idade e a formação dos professores com mais de 30 anos: */
SELECT nome, idade, formacao FROM professores WHERE idade > 30;


