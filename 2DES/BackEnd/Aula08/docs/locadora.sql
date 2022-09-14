DROP DATABASE IF EXISTS locadora;
CREATE DATABASE locadora charset=UTF8 collate utf8_general_ci;
USE locadora;

CREATE TABLE clientes (
    cod_cli INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) not null,
    endereco VARCHAR(50) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE filmes(
    cod_filme INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome_filme VARCHAR(30) NOT NULL,
    genero VARCHAR(15) NOT NULL
);

CREATE TABLE locacoes (
   id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
   cod_cli INTEGER NOT NULL,
   cod_filme INTEGER NOT NULL,
   data_locacao DATE NOT NULL,
   data_devolucao DATE,
   foreign key (cod_cli) references clientes(cod_cli),
   foreign key (cod_filme) references filmes(cod_filme)
);

describe clientes;
describe filmes;
describe locacoes;

show tables;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula08/docs/dados/clientes.csv'
INTO TABLE clientes
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from clientes;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula08/docs/dados/filmes.csv'
INTO TABLE filmes
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from filmes;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula08/docs/dados/locacoes.csv'
INTO TABLE locacoes
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from locacoes;