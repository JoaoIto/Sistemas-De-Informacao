create database sucos;
use sucos;

CREATE TABLE enderecoCliente(
	`idEndereco` int not null auto_increment,
	`rua` varchar(100),
    `numero` int,
    `setor` varchar(100),
    primary key(`idEndereco`)
);

create table compra (
	`idCompra` int not null auto_increment,
    `volumeCompra` float,
    `precoCompra` double,
    primary key(`idCompra`)
);

CREATE TABLE tbClientes(
    `cpf` varchar(11),
    `nome` varchar(100),
    `endereco` int,
    `compra` int,
    foreign key (`endereco`) references `enderecoCliente`(`idEndereco`),
    foreign key (`compra`) references `compra`(`idCompra`)
);

create table funcoes(
	`idFuncao` int not null auto_increment,
	`nome` varchar(100),
    `cargaHoraria` int,
    primary key(`idFuncao`)
);

create table tbVendedores(
	`matricula` int not null auto_increment,
    `nome` varchar(100),
	`PERCENTUAL_COMISSAO` float,
    `funcao` int not null,
    primary key(`matricula`),
    foreign key(`funcao`) references `funcoes`(idFuncao)
);

create table tbGerente(
	`funcionarios` int not null,
    `nome` varchar(100),
    `funcao` int not null,
    foreign key (`funcionarios`) references `tbVendedores`(`matricula`),
    foreign key(`funcao`) references `funcoes`(idFuncao)
);

