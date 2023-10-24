CREATE DATABASE restaurante;

USE restaurante;

-- Criação da tabela
CREATE TABLE mesas (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       horario TIME,
                       capacidade INT,
                       status ENUM('disponível', 'reservada', 'ocupada')
);

-- Inserção de dados
INSERT INTO mesas (horario, capacidade, status) VALUES ('18:00', 4, 'disponível');
INSERT INTO mesas (horario, capacidade, status) VALUES ('18:00', 6, 'disponível');
INSERT INTO mesas (horario, capacidade, status) VALUES ('19:00', 2, 'reservada');
INSERT INTO mesas (horario, capacidade, status) VALUES ('19:00', 4, 'reservada');
INSERT INTO mesas (horario, capacidade, status) VALUES ('20:00', 6, 'disponível');
INSERT INTO mesas (horario, capacidade, status) VALUES ('20:00', 4, 'ocupada');

-- Bloqueio Exclusivo
BEGIN;
-- Realiza o bloqueio exclusivo da mesa para uma reserva
UPDATE mesas SET status = 'reservada' WHERE id = 1 AND horario = '19:00';

-- Verifica se ocorreu um erro na atualização
IF ROW_COUNT() = 0 THEN
    ROLLBACK;
ELSE
    COMMIT;
END IF;

-- Bloqueio compartilhado
BEGIN;
-- Realiza o bloqueio compartilhado para visualizar mesas disponíveis
SELECT * FROM mesas WHERE status = 'disponível';

-- Verifica se ocorreu um erro na consulta
IF FOUND_ROWS() = 0 THEN
    ROLLBACK;
ELSE
    COMMIT;
END IF;

-- Comandos Lock e Unlock
BEGIN;
-- Garçom bloqueia a mesa manualmente para atender a um cliente
LOCK TABLES mesas WRITE;

-- Atualização da mesa
UPDATE mesas SET status = 'reservada' WHERE id = 2 AND horario = '18:00';

-- Verifica se ocorreu um erro na atualização
IF ROW_COUNT() = 0 THEN
    ROLLBACK;
ELSE
    UNLOCK TABLES; -- Garçom desbloqueia a mesa após a reserva ter sido feita
COMMIT;
END IF;
