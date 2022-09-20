drop database if exists emprestimos;
create database emprestimos charset=UTF8 collate utf8_general_ci;
use emprestimos;

create table clientes(
	cpf varchar(14) primary key not null,
	nome varchar(20) not null,
    sobrenome varchar(20) not null,
	cep varchar(9) not null,
	complemento varchar(30)
);

create table telefones(
	cpf varchar(14) not null,
    tipo varchar(15) not null,
	numero varchar(15) not null,
	foreign key (cpf) references clientes(cpf) on delete cascade
);

create table emprestimos(
    id_emprestimos integer primary key AUTO_INCREMENT not null,
    cpf varchar(14) not null,
    data DATE not null,
    capital decimal(10,2) not null,
    n_parcelas integer not null,
    taxa_juros decimal(3,2) not null,
    impostos decimal(10,2) not null
);

create table parcelas(
    id_parcelas integer primary key AUTO_INCREMENT not null,
    cpf varchar(14) not null,
    id_emprestimos integer not null,
    vencimento date not null,
    pagamento date not null,
    valor decimal(10,2) not null,
    val_recebido decimal(10,2) not null
);

describe clientes;
describe telefones;
describe emprestimos;
describe parcelas;

show tables;

CREATE TRIGGER Trg_parcelas BEFORE INSERT
on emprestimos
FOR EACH ROW



LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BD/Aula 06/emprestimos/docs/clientes.csv'
INTO TABLE clientes
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from clientes;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BD/Aula 06/emprestimos/docs/telefones.csv'
INTO TABLE telefones
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from telefones;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BD/Aula 06/emprestimos/docs/emprestimos.csv'
INTO TABLE emprestimos
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from emprestimos;

