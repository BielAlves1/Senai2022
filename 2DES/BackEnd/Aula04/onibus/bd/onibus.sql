drop database if exists onibus;
create database onibus charset=UTF8 collate utf8_general_ci;
use onibus;

create table motoristas(
    cpf varchar(11) not null primary key,
    nome varchar(50) not null
);
create table telefones(
    cpf varchar(11) not null,
    numero varchar(15) not null,
    foreign key (cpf) references motoristas(cpf)
);
create table linhas(
    id_linha varchar(10) not null primary key,
    descricao varchar(50) not null
);
create table horarios(
    id_linha varchar(10) not null,
    horario time not null,
    foreign key (id_linha) references linhas(id_linha)
);
create table mot_linhas(
    cpf varchar(11) not null,
    id_linha varchar(10) not null,
    data date not null,
    foreign key (cpf) references motoristas(cpf),
    foreign key (id_linha) references linhas(id_linha)
);

describe motoristas;
describe telefones;
describe linhas;
describe horarios;
describe mot_linhas;

show tables;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula04/onibus/bd/motoristas.CSV'
INTO TABLE motoristas
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from motoristas;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula04/onibus/bd/telefones.CSV'
INTO TABLE telefones
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from telefones;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula04/onibus/bd/linhas.CSV'
INTO TABLE linhas
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from linhas;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula04/onibus/bd/horarios.CSV'
INTO TABLE horarios
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from horarios;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula04/onibus/bd/mot_linha.CSV'
INTO TABLE mot_linhas
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from mot_linhas;

create view vw_motoristas  as
select m.cpf, m.nome, t.numero from motoristas m
inner join telefones t
on m.cpf = t.cpf;

select * from vw_motoristas;