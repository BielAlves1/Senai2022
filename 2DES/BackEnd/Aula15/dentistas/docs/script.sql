drop database if exists dentista;
create database dentista charset = UTF8 collate = utf8_general_ci;
use dentista;

create table profissionais(
    id_prof integer primary key auto_increment not null,
    nome varchar(35) not null,
    especialidade varchar(20) not null
);

create table consultas(
    id_consu integer primary key auto_increment not null,
    paciente varchar(35) not null,
    data DATE not null,
    horario time not null,
    id_prof integer not null,
    foreign key(id_prof) references profissionais(id_prof)
);

create table tratamentos(
    id_trata integer primary key auto_increment not null,
    id_consu integer not null,
    tratamento varchar(50) not null,
    valor decimal(10,2) not null,
    foreign key(id_consu) references consultas(id_consu)
);

show tables;

describe profissionais;
describe consultas;
describe tratamentos;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula15/dentistas/docs/profissionais.csv'
INTO TABLE profissionais
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from profissionais;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula15/dentistas/docs/consultas.csv'
INTO TABLE consultas
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from consultas;

LOAD DATA INFILE 'D:/Gabriel Alves/Senai2022/2DES/BackEnd/Aula15/dentistas/docs/tratamentos.csv'
INTO TABLE tratamentos
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from tratamentos;

create view vw_geral as
SELECT p.id_prof, p.nome, p.especialidade, c.id_consu, c.paciente, c.data, c.horario, t.id_trata, t.tratamento, t.valor From profissionais p
inner join consultas c
on p.id_prof = c.id_prof
join tratamentos t
on c.id_consu  = t.id_consu;

select * from vw_geral;