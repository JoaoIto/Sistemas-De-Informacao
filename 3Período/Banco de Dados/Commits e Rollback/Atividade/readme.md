# Comandos SQL para Gerenciamento de Mesas de Restaurante
Este repositório contém comandos SQL para gerenciar mesas de um restaurante em um banco de dados MySQL.

Comandos SQL:
CREATE DATABASE restaurante; - Cria um novo banco de dados chamado "restaurante" para armazenar informações sobre as mesas.

USE restaurante; - Define o banco de dados atual como "restaurante" para executar comandos subsequentes nele.

CREATE TABLE mesas (...); - Cria a tabela "mesas" com colunas para ID, horário, capacidade e status das mesas.

INSERT INTO mesas (...) VALUES (...); - Insere dados na tabela "mesas" para representar a disponibilidade e o status das mesas.

BEGIN; - Inicia uma transação que pode ser revertida com COMMIT ou ROLLBACK.

UPDATE mesas SET status = 'reservada' WHERE id = 1 AND horario = '19:00'; - Atualiza o status da mesa com ID 1 para 'reservada' no horário das 19:00.

COMMIT; - Confirma a transação, tornando as alterações permanentes no banco de dados.

BEGIN; - Inicia uma nova transação.

SELECT * FROM mesas WHERE status = 'disponível'; - Consulta as mesas disponíveis no banco de dados.

COMMIT; - Confirma a transação.

BEGIN; - Inicia outra transação.

LOCK TABLES mesas WRITE; - Bloqueia a tabela "mesas" para impedir que outros usuários acessem ou atualizem informações.

UPDATE mesas SET status = 'reservada' WHERE id = 2 AND horario = '18:00'; - Atualiza o status da mesa com ID 2 para 'reservada' no horário das 18:00.

UNLOCK TABLES; - Libera o bloqueio da tabela "mesas" após a reserva ter sido feita.

COMMIT; - Confirma a transação.

---