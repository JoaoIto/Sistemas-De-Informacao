-- Criação do Banco de Dados
CREATE DATABASE IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `biblioteca`;

-- Tabela de Autores
CREATE TABLE `autores` (
                           `autor_id` INT AUTO_INCREMENT PRIMARY KEY,
                           `nome` VARCHAR(255) NOT NULL,
                           `nacionalidade` VARCHAR(255)
);

-- Inserção de Dados na Tabela de Autores
INSERT INTO `autores` (`nome`, `nacionalidade`) VALUES
                                                    ('Stephen King', 'EUA'),
                                                    ('J.K. Rowling', 'Reino Unido'),
                                                    ('George Orwell', 'Reino Unido');

-- Tabela de Livros
CREATE TABLE `livros` (
                          `livro_id` INT AUTO_INCREMENT PRIMARY KEY,
                          `titulo` VARCHAR(255) NOT NULL,
                          `ano_publicacao` INT,
                          `autor_id` INT,
                          FOREIGN KEY (`autor_id`) REFERENCES `autores` (`autor_id`)
);

-- Inserção de Dados na Tabela de Livros
INSERT INTO `livros` (`titulo`, `ano_publicacao`, `autor_id`) VALUES
    ('Biblioteca da Meia noite', 2019, 1);

-- Tabela de Empréstimos
CREATE TABLE `emprestimos` (
                               `emprestimo_id` INT AUTO_INCREMENT PRIMARY KEY,
                               `livro_id` INT,
                               `data_emprestimo` DATE,
                               `data_devolucao` DATE,
                               FOREIGN KEY (`livro_id`) REFERENCES `livros` (`livro_id`)
);

-- Inserção de Dados na Tabela de Empréstimos
INSERT INTO emprestimos (livro_id, data_emprestimo, data_devolucao) VALUES (1, '2023-09-21', '2023-09-28');
ALTER TABLE livros ADD COLUMN num_emprestimos INT DEFAULT 0;


-- Tabela de Leitores
CREATE TABLE `leitores` (
                            `leitor_id` INT AUTO_INCREMENT PRIMARY KEY,
                            `nome` VARCHAR(255) NOT NULL,
                            `idade` INT,
                            `endereco` VARCHAR(255)
);

-- Inserção de Dados na Tabela de Leitores
INSERT INTO `leitores` (`nome`, `idade`, `endereco`) VALUES
                                                         ('João', 25, 'Rua A, 123'),
                                                         ('Maria', 30, 'Avenida B, 456');

-- Questão 1: Crie uma view chamada livros_populares que exiba os títulos e anos de publicação dos livros publicados após o ano de 2000. Use a tabela livros para criar esta view.


CREATE VIEW livros_anos2000 AS
SELECT titulo, ano_publicacao
FROM livros
WHERE ano_publicacao > 2000;

select * from livros_anos2000;

-- Questão 2: Crie uma view chamada emprestimos_ativos que exiba os detalhes dos empréstimos em andamento. Esta view deve incluir o título do livro, a data de empréstimo e a data de devolução. Use as tabelas emprestimos e livros para criar esta view.

create view emprestimos_ativos as select titulo, data_emprestimo, data_devolucao from livros, emprestimos;

select * from emprestimos_ativos;

-- Questão 3: Crie um índice não clusterizado na coluna nome da tabela autores para melhorar o desempenho das consultas que envolvem ordenação pelo nome dos autores.

create index autores_index_nome  on autores (nome);

explain select * from autores;

-- Questão 4: Crie um índice clusterizado na coluna data_emprestimo da tabela emprestimos para melhorar o desempenho das consultas que envolvem pesquisa por data de empréstimo.

create index emprestimo_data on emprestimos(data_emprestimo);

explain select * from emprestimos;

-- Questão 5: Crie um trigger que automaticamente atualiza a coluna valoremaberto na tabela tratamento sempre que um novo empréstimo é registrado na tabela emprestimos. O valor em valoremaberto deve ser incrementado pelo valor do livro emprestado. Use as tabelas tratamento, emprestimos, e livros para criar este trigger.

DELIMITER //
CREATE TRIGGER atualiza_num_emprestimos
    AFTER INSERT ON emprestimos
    FOR EACH ROW
BEGIN
    UPDATE livros
    SET num_emprestimos = num_emprestimos + 1
    WHERE livro_id = NEW.livro_id;
END;
//
DELIMITER ;


