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