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
    foreign key(cpf) references clientes(cpf) on delete cascade on update cascade
);

CREATE TABLE vagas(
    id_vaga integer not null primary key auto_increment,
    status_vaga BIT not null,
    descricao varchar(30) not null,
    valor_hora float(10,2) not null
);

CREATE TABLE processa_vagas(
    id_vaga integer not null,
    entrada DATETIME not null,
    saida DATETIME,
    placa varchar(7) not null,
    foreign key (id_vaga) references vagas(id_vaga),
    foreign key (placa) references veiculos(placa) on delete cascade on update cascade
);

show tables;

select * from clientes;
select * from veiculos;
select * from vagas;
select * from processa_vagas;

create view vw_geral as
SELECT c.cpf, c.nome, c.telefone, v.placa, v.tipo, v.modelo, v.cor, pv.id_vaga, pv.entrada, pv.saida From clientes c
inner join veiculos v
on c.cpf = v.cpf
join processa_vagas pv
on v.placa  = pv.placa;

select * from vw_geral;
