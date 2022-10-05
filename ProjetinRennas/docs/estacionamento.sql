DROP DATABASE IF EXISTS estacionamento;
CREATE DATABASE estacionamento charset=UTF8 collate utf8_general_ci;
USE estacionamento;

CREATE TABLE clientes(
    cpf varchar(14) primary key not null,
    nome varchar(50) not null,
    telefone varchar(15) not null
);

CREATE TABLE veiculos(
    placa varchar(7) primary key not null,
    tipo varchar(15) not null,
    modelo varchar(30) not null,
    cor varchar(15) not null,
    cpf varchar(14) not null,
    foreign key(cpf) references clientes(cpf) on delete cascade
);

CREATE TABLE vagas(
    id_vaga integer not null primary key auto_increment,
    status_vaga boolean,
    tipo varchar(20) not null,
    valor_hora float(10,2) not null
);

CREATE TABLE processa_vaga(
    id_vaga integer not null,
    placa varchar(7) not null,
    entrada DATETIME not null,
    saida DATETIME,
    foreign key (id_vaga) references vagas(placa),
    foreign key (placa) references veiculos(placa)
);

select * from clientes;
select * from veiculos;
select * from vagas;
select * from processa_vaga;