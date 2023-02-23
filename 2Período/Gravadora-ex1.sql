create database gravadora;

create table `gravadora` . `cancao`(
	`idcancao` int not null auto_increment, 
    `nome` varchar(100) not null, 
    `compositor` varchar(100) not null, 
    `data` date not null, 
    `estilo_musical` varchar(45) not null,
    primary key(`idcancao`)
);
 
create table `gravadora` . `compositor`(
`idcompositor` int not null auto_increment,
`nome` varchar(100) not null,
`cancoes_criadas` int not null,
`estilo_musical` varchar(45) not null,
primary key(`idcompositor`),

constraint `compositor` foreign key (`idcompositor`) references `gravadora` . `compositor`(`idcompositor`) 
on update cascade 
on delete no action
);

create table `gravadora` . `gravacao`(
    `idgravacao` int not null auto_increment
	`data` date not null,
    `duracao` time not null,
    `interprete` varchar(100) not null,
    `porcentagem` int not null,
    `estilo_musical` varchar(45) not null,
    primary key(`interprete`, `idgravacao`),
    
    constraint `cancao` foreign key (`idcancao`) references `gravadora` . `cancao`(`idcancao`) 
    on update cascade 
    on delete no action
);

create table `gravadora` . `interprete`(
	`idinterprete` date not null auto_increment,
    `nome` varchar(100) not null,
    `estilo_musical` varchar(45) not null,
    primary key(`idinterprete`)
);
