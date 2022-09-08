DROP DATABASE IF EXISTS lojaJapa;
CREATE DATABASE lojaJapa charset=UTF8 collate utf8_general_ci;

USE lojaJapa;

CREATE TABLE lancamentos (
    n_lanca INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data date not null,
    descricao VARCHAR(50) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(10) NOT NULL
);

describe lancamentos;
show tables;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula07/docs/lancamentos.csv'
INTO TABLE lancamentos
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from lancamentos;