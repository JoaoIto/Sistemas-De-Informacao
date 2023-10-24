CREATE DATABASE  IF NOT EXISTS `lavanderia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lavanderia`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: lavanderia
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `ClienteID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `NumeroDeTelefone` varchar(20) DEFAULT NULL,
  `PontosAcumulados` int(11) DEFAULT NULL,
  PRIMARY KEY (`ClienteID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'João Silva','Rua A, 123','(11) 1234-5678',15),(2,'Maria Santos','Avenida B, 456','(11) 2345-6789',8),(3,'Pedro Oliveira','Rua C, 789','(11) 3456-7890',23),(4,'Ana Rodrigues','Avenida D, 321','(11) 4567-8901',30),(5,'Lucas Pereira','Rua E, 654','(11) 5678-9012',12),(6,'Laura Souza','Avenida F, 987','(11) 6789-0123',18),(7,'Mariana Costa','Rua G, 567','(11) 7890-1234',5),(8,'Carlos Ferreira','Avenida H, 432','(11) 8901-2345',28),(9,'Julia Lima','Rua I, 876','(11) 9012-3456',9),(10,'Paulo Vieira','Avenida J, 765','(11) 0123-4567',14);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracoesdosistema`
--

DROP TABLE IF EXISTS `configuracoesdosistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `configuracoesdosistema` (
  `ConfiguracaoID` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(255) DEFAULT NULL,
  `ValorEntrega` decimal(10,2) DEFAULT NULL,
  `ValorPorKgRoupa` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ConfiguracaoID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracoesdosistema`
--

LOCK TABLES `configuracoesdosistema` WRITE;
/*!40000 ALTER TABLE `configuracoesdosistema` DISABLE KEYS */;
INSERT INTO `configuracoesdosistema` VALUES (1,'Configuração Padrão',10.00,3.00),(2,'Configuração Premium',15.00,3.50),(3,'Configuração Econômica',8.00,2.50);
/*!40000 ALTER TABLE `configuracoesdosistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregadores`
--

DROP TABLE IF EXISTS `entregadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entregadores` (
  `EntregadorID` int(11) NOT NULL AUTO_INCREMENT,
  `NomeDoEntregador` varchar(255) DEFAULT NULL,
  `InformacoesContato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EntregadorID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregadores`
--

LOCK TABLES `entregadores` WRITE;
/*!40000 ALTER TABLE `entregadores` DISABLE KEYS */;
INSERT INTO `entregadores` VALUES (1,'Carlos Oliveira','Contato: Carlos Oliveira, Telefone: (11) 1111-1111'),(2,'Mariana Santos','Contato: Mariana Santos, Telefone: (11) 2222-2222'),(3,'Pedro Silva','Contato: Pedro Silva, Telefone: (11) 3333-3333'),(4,'Lucia Pereira','Contato: Lucia Pereira, Telefone: (11) 4444-4444'),(5,'Ana Rodrigues','Contato: Ana Rodrigues, Telefone: (11) 5555-5555'),(6,'Paulo Lima','Contato: Paulo Lima, Telefone: (11) 6666-6666'),(7,'Fernanda Ferreira','Contato: Fernanda Ferreira, Telefone: (11) 7777-7777'),(8,'Miguel Costa','Contato: Miguel Costa, Telefone: (11) 8888-8888'),(9,'Luisa Vieira','Contato: Luisa Vieira, Telefone: (11) 9999-9999'),(10,'Maria Oliveira','Contato: Maria Oliveira, Telefone: (11) 0000-0000');
/*!40000 ALTER TABLE `entregadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregas`
--

DROP TABLE IF EXISTS `entregas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entregas` (
  `EntregaID` int(11) NOT NULL AUTO_INCREMENT,
  `EntregadorID` int(11) DEFAULT NULL,
  `PedidoID` int(11) DEFAULT NULL,
  `DataDaEntrega` date DEFAULT NULL,
  `ValorDaEntrega` decimal(10,2) DEFAULT NULL,
  `entregadorpago` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`EntregaID`),
  KEY `EntregadorID` (`EntregadorID`),
  KEY `PedidoID` (`PedidoID`),
  CONSTRAINT `entregas_ibfk_1` FOREIGN KEY (`EntregadorID`) REFERENCES `entregadores` (`EntregadorID`),
  CONSTRAINT `entregas_ibfk_2` FOREIGN KEY (`PedidoID`) REFERENCES `pedidos` (`PedidoID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregas`
--

LOCK TABLES `entregas` WRITE;
/*!40000 ALTER TABLE `entregas` DISABLE KEYS */;
INSERT INTO `entregas` VALUES (1,1,1,'2023-08-05',8.00,0),(2,2,2,'2023-08-06',6.50,0),(3,3,3,'2023-08-07',9.00,0),(4,4,4,'2023-08-08',7.50,0),(5,5,5,'2023-08-09',10.00,0),(6,6,6,'2023-08-10',8.50,0),(7,7,7,'2023-08-11',9.50,0),(8,8,8,'2023-08-12',7.00,0),(9,9,9,'2023-08-13',10.50,0),(10,10,10,'2023-08-14',8.75,0);
/*!40000 ALTER TABLE `entregas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedores` (
  `FornecedorID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) DEFAULT NULL,
  `InformacoesContato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FornecedorID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
INSERT INTO `fornecedores` VALUES (1,'LimpaTudo Ltda','Contato: João da Silva, Telefone: (11) 1234-5678'),(2,'BrilhoPerfeito S.A.','Contato: Maria Santos, Telefone: (11) 2345-6789'),(3,'UltraClean Produtos','Contato: Pedro Oliveira, Telefone: (11) 3456-7890'),(4,'Limpolimpo Indústria','Contato: Ana Rodrigues, Telefone: (11) 4567-8901'),(5,'SuperBom Limpadores','Contato: Lucas Pereira, Telefone: (11) 5678-9012'),(6,'EcoLimpeza Corp','Contato: Laura Souza, Telefone: (11) 6789-0123'),(7,'LavaTudo Comércio','Contato: Mariana Costa, Telefone: (11) 7890-1234'),(8,'ProdutosBrilhantes Ltda','Contato: Carlos Ferreira, Telefone: (11) 8901-2345'),(9,'CleanMaster Distribuidora','Contato: Julia Lima, Telefone: (11) 9012-3456'),(10,'LimpaFácil Indústria','Contato: Paulo Vieira, Telefone: (11) 0123-4567');
/*!40000 ALTER TABLE `fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `PedidoID` int(11) NOT NULL AUTO_INCREMENT,
  `ClienteID` int(11) DEFAULT NULL,
  `DataDoPedido` date DEFAULT NULL,
  `PesoTotalDasRoupas` decimal(10,2) DEFAULT NULL,
  `ValorDoPedido` decimal(10,2) DEFAULT NULL,
  `ConfiguracaoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PedidoID`),
  KEY `ClienteID` (`ClienteID`),
  KEY `ConfiguracaoID` (`ConfiguracaoID`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`),
  CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`ConfiguracaoID`) REFERENCES `configuracoesdosistema` (`ConfiguracaoID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,1,'2023-08-01',10.50,75.00,1),(2,2,'2023-08-02',8.00,60.00,2),(3,3,'2023-08-03',12.20,90.00,1),(4,4,'2023-08-04',7.50,55.00,2),(5,5,'2023-08-05',15.00,110.00,1),(6,6,'2023-08-06',9.80,70.00,2),(7,7,'2023-08-07',11.00,80.00,1),(8,8,'2023-08-08',6.30,45.00,2),(9,9,'2023-08-09',13.50,100.00,1),(10,10,'2023-08-10',8.90,65.00,2),(11,1,'2023-08-11',12.00,88.00,1),(12,2,'2023-08-12',7.20,52.00,2),(13,3,'2023-08-13',14.30,105.00,1),(14,4,'2023-08-14',6.80,49.00,2),(15,5,'2023-08-15',9.50,69.00,1);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtosdepremio`
--

DROP TABLE IF EXISTS `produtosdepremio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtosdepremio` (
  `ProdutoID` int(11) NOT NULL AUTO_INCREMENT,
  `FornecedorID` int(11) DEFAULT NULL,
  `NomeDoProduto` varchar(255) DEFAULT NULL,
  `PontosNecessarios` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProdutoID`),
  KEY `FornecedorID` (`FornecedorID`),
  CONSTRAINT `produtosdepremio_ibfk_1` FOREIGN KEY (`FornecedorID`) REFERENCES `fornecedores` (`FornecedorID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtosdepremio`
--

LOCK TABLES `produtosdepremio` WRITE;
/*!40000 ALTER TABLE `produtosdepremio` DISABLE KEYS */;
INSERT INTO `produtosdepremio` VALUES (1,1,'Kit de Limpeza Premium',50),(2,2,'Aspirador de Pó Portátil',40),(3,3,'Jogo de Toalhas de Banho',30),(4,4,'Cesta de Produtos de Limpeza',60),(5,5,'Liquidificador de Alta Potência',70),(6,1,'Vale-Compras de R$ 50,00',20),(7,3,'Caixa de Sabonetes Perfumados',35),(8,2,'Ferro de Passar a Vapor',45),(9,4,'Kit de Panelas Antiaderentes',65),(10,5,'Cafeteira Elétrica',55);
/*!40000 ALTER TABLE `produtosdepremio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sorteiodepremios`
--

DROP TABLE IF EXISTS `sorteiodepremios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sorteiodepremios` (
  `SorteioID` int(11) NOT NULL AUTO_INCREMENT,
  `ClienteID` int(11) DEFAULT NULL,
  `ProdutoID` int(11) DEFAULT NULL,
  `DataDoSorteio` date DEFAULT NULL,
  PRIMARY KEY (`SorteioID`),
  KEY `ClienteID` (`ClienteID`),
  KEY `ProdutoID` (`ProdutoID`),
  CONSTRAINT `sorteiodepremios_ibfk_1` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`),
  CONSTRAINT `sorteiodepremios_ibfk_2` FOREIGN KEY (`ProdutoID`) REFERENCES `produtosdepremio` (`ProdutoID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sorteiodepremios`
--

LOCK TABLES `sorteiodepremios` WRITE;
/*!40000 ALTER TABLE `sorteiodepremios` DISABLE KEYS */;
INSERT INTO `sorteiodepremios` VALUES (1,1,1,'2023-08-20'),(2,2,3,'2023-08-20'),(3,3,2,'2023-08-20'),(4,4,4,'2023-08-20'),(5,5,5,'2023-08-20');
/*!40000 ALTER TABLE `sorteiodepremios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-03  8:12:59

-- INTEGRANTES DO GRUPO:
-- Lucas Daniel, João Victor Póvoa, Nicole Muniz.
-- PROVA BD II - 03.10.2023 

/* 1. Crie uma view que fornece um resumo dos pedidos feitos por cada cliente, incluindo o 
nome do cliente, o número de pedidos, a data do último pedido e o valor total gasto. 
Isso pode ajudar a equipe de atendimento ao cliente a entender o histórico e o valor de 
cada cliente;
*/

CREATE OR REPLACE VIEW `lavanderia`.`resumo` AS
    SELECT 
        `lavanderia`.`clientes`.`Nome` AS `nome`,
        COUNT(`lavanderia`.`pedidos`.`ClienteID`) AS `count(pedidos.ClienteID)`,
        MAX(`lavanderia`.`pedidos`.`DataDoPedido`) AS `max(pedidos.DataDoPedido)`,
        SUM(`lavanderia`.`pedidos`.`ValorDoPedido`) AS `sum(pedidos.ValorDoPedido)`
    FROM
        (`lavanderia`.`clientes`
        JOIN `lavanderia`.`pedidos`)
    WHERE
        (`lavanderia`.`clientes`.`ClienteID` = `lavanderia`.`pedidos`.`ClienteID`)
    GROUP BY `lavanderia`.`pedidos`.`ClienteID`;

/*
2. Uma view que classifica os clientes com base na quantidade de pontos acumulados no 
programa de relacionamento. Isso pode ser útil para identificar os clientes mais fiéis e 
oferecer promoções direcionadas.
*/

CREATE OR REPLACE VIEW `lavanderia`.`pontos` AS
    select `clientes`.`PontosAcumulados`, `clientes`.`Nome` from `lavanderia`.`clientes` order by `clientes`.`PontosAcumulados`;

/*

3) Uma view que lista todos os prêmios disponíveis que ainda não foram sorteados, 
incluindo o nome do produto, a quantidade de pontos necessários e o nome do 
fornecedor. Isso pode ajudar a equipe a gerenciar os prêmios disponíveis e a 
disponibilizar informações sobre os prêmios aos clientes.
*/

USE `lavanderia`;
CREATE OR REPLACE VIEW `produtosDisponiveis` AS (SELECT produtosdepremio.NomeDoProduto, produtosdepremio.PontosNecessarios, fornecedores.Nome FROM produtosdepremio, fornecedores WHERE fornecedores.FornecedorID = produtosdepremio.FornecedorID AND fornecedores.FornecedorID);

/*
04) Uma trigger que é acionada após a inserção de um novo pedido. Ela verifica o valor do 
pedido e atualiza os pontos acumulados pelo cliente com base no valor gasto. Por 
exemplo, a cada R$ 25,00 gastos, o cliente ganha 1 ponto. A trigger atualiza os pontos 
do cliente automaticamente.
*/

DROP TRIGGER IF EXISTS `lavanderia`.`pedidos_AFTER_INSERT`;
DELIMITER $$
USE `lavanderia`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `pedidos_AFTER_INSERT` AFTER INSERT ON `pedidos` FOR EACH ROW BEGIN
UPDATE clientes SET clientes.PontosAcumulados = clientes.PontosAcumulados + (new.ValorDoPedido/5);
END$$
DELIMITER ;

/*
5. Uma trigger que é acionada após a inserção de uma nova entrega. Ela verifica o valor da 
entrega e atualiza o valor acumulado pelo entregador para pagamento no final do mês.
uantidade de pontos do cliente de acordo com as regras 
de negócio especificadas.
*/

DROP TRIGGER IF EXISTS `lavanderia`.`entregas_AFTER_INSERT`;
DELIMITER $$
USE `lavanderia`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `entregas_AFTER_INSERT` AFTER INSERT ON `entregas` FOR EACH ROW BEGIN
	UPDATE `lavanderia`.`entregadores` SET `valorReceber` = `valorReceber` + `lavanderia`.`entregas`.`ValorDaEntrega`;
END$$
DELIMITER ;

/*
6) Uma stored procedure que realiza o sorteio de prêmios para os clientes qualificados com 
base nos pontos acumulados. A procedure recebe um cliente como parâmetro e 
seleciona aleatoriamente um prêmio disponível e registra o sorteio na tabela 
SorteioDePremios e atualiza a quantidade de pontos do cliente de acordo com as regras 
de negócio especificadas.
*/

USE `lavanderia`;
DROP procedure IF EXISTS `SORTEADOR_PROCEDURE`;
DELIMITER $$
USE `lavanderia`$$
CREATE PROCEDURE `SORTEADOR_PROCEDURE` (in cliente int)
BEGIN
	-- 6) Uma stored procedure que realiza o sorteio de prêmios para os clientes qualificados com 
	-- base nos pontos acumulados. A procedure recebe um cliente como parâmetro e 
	-- seleciona aleatoriamente um prêmio disponível e registra o sorteio na tabela 
	-- SorteioDePremios e atualiza a quantidade de pontos do cliente de acordo com as regras 
	-- de negócio especificadas.
    
	DECLARE pontos int;
    DECLARE necessario int;
    DECLARE produtoSorteado int;
    SET pontos = (SELECT clientes.PontosAcumulados FROM clientes WHERE clientes.ClienteID = cliente);
    SET necessario = (SELECT min(produtosdepremio.PontosNecessarios) FROM produtosdepremio);
	
    if(pontos  < necessario) then 
		SELECT ('Esse cliente não pode retirar um prêmio, devido a sua pontuação no programa de fidelidade!') as ERRO;
	else 
        SET produtoSorteado = (SELECT produtosdepremio.ProdutoID from produtosdepremio LIMIT 1);
        if(pontos >= (SELECT produtosdepremio.PontosNecessarios from produtosdepremio WHERE produtosdepremio.ProdutoID = produtoSorteado)) then
			UPDATE clientes SET clientes.PontosAcumulados = 0 WHERE clientes.ClienteID = cliente;
		else
			UPDATE clientes SET clientes.PontosAcumulados = clientes.PontosAcumulados - (SELECT produtosdepremio.PontosNecessarios from produtosdepremio WHERE produtosdepremio.ProdutoID = produtoSorteado) WHERE clientes.ClienteID = cliente;
		end if;
    end if;
END$$
DELIMITER ;

/*

7. Uma stored procedure que realize o pagamento de um entregador de acordo com as 
regras de negócio especificadas.
*/
USE `lavanderia`;
DROP procedure IF EXISTS `pagamento`;
DELIMITER $$
CREATE PROCEDURE `pagamento` (in EntregadorID int)
BEGIN

	DECLARE quantEntregas int;
    
    set quantEntregas = (select count(`lavanderia`.`entregas`.`EntregaID`) 
	from `lavanderia`.`entregas` 
	where `lavanderia`.`entregas`.`EntregadorID` = EntregadorID);
    
    if(quantEntregas < 5)then
	select ('Não é possível!');

else
	update `entregas` set `entregas`.`entregadorpago` = 1;
	update `entregadores` set `entregadores`.`valorReceber` = 0;
    end if;
END
$$
DELIMITER ;


/* 8) Uma function que verifique se um determinado pedido está com o valor correto 
considerando a configuração que foi usada por ele. Caso não esteja correto deve 
atualizar o valor para que fique correto. Além disso, deve retornar o quanto foi 
adicionado ou retirado para que tenha ficado correto. 
*/

USE `lavanderia`;
DROP function IF EXISTS `VERIFICA_PEDIDO_VALOR`;
USE `lavanderia`;
DROP function IF EXISTS `lavanderia`.`VERIFICA_PEDIDO_VALOR`;
;
DELIMITER $$
USE `lavanderia`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `VERIFICA_PEDIDO_VALOR`(pedido int) RETURNS decimal
    DETERMINISTIC
BEGIN
	declare configuracao int;
    declare valor decimal;
    declare valorCerto decimal;
    set configuracao = (SELECT pedidos.ConfiguracaoID FROM pedidos WHERE pedidos.PedidoID = pedido);
    set valor = (SELECT pedidos.ValorDoPedido FROM pedidos WHERE pedidos.PedidoID = pedido);
    set valorCerto = (SELECT (pedidos.PesoTotalDasRoupas * configuracoesdosistema.ValorPorKgRoupa)+entregas.ValorDaEntrega FROM pedidos, configuracoesdosistema, entregas WHERE pedidos.ConfiguracaoID = configuracoesdosistema.ConfiguracaoID AND pedidos.PedidoID = pedido AND entregas.PedidoID = pedidos.PedidoID);
	
    if(valorCerto = valor) then
		return 0;
	else 
		UPDATE pedidos SET pedidos.ValorDoPedido = valorCerto WHERE pedido = pedidos.PedidoID;
		return (valorCerto - valor);
	end if;
END$$

DELIMITER ;

/*
09) Uma function que retorne a porcentagem que o valor da entrega representa para um 
determinado pedido.
*/

USE `lavanderia`;
DROP function IF EXISTS `ENTREGA_VALOR`;
USE `lavanderia`;
DROP function IF EXISTS `lavanderia`.`ENTREGA_VALOR`;
;
DELIMITER $$
USE `lavanderia`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `ENTREGA_VALOR`(pedido int) RETURNS decimal(10,0)
    DETERMINISTIC
BEGIN
	declare valorPedido decimal;
    declare valorEntrega decimal;
    set valorPedido = (SELECT pedidos.ValorDoPedido FROM pedidos WHERE pedidos.PedidoID = pedido);
	set valorEntrega = (SELECT entregas.ValorDaEntrega FROM pedidos, entregas WHERE entregas.PedidoID = pedidos.PedidoID AND pedidos.PedidoID = pedido);

RETURN (valorEntrega/valorPedido)*100;
END$$
DELIMITER ;
;

