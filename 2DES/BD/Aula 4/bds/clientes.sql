drop database if exists clientes;

create database clientes charset=UTF8 collate utf8_general_ci;
use clientes;

create table clientes(
    id_cliente integer not null primary key auto_increment,
    nome varchar(30) not null,
    nascimento Date not null,
    sexo varchar(15) not null,
    peso decimal(10,2) not null
);
create table telefones(
    id_cliente integer not null,
    telefone varchar(15) not null,
    foreign key (id_cliente) references clientes(id_cliente)
);

describe clientes;
describe telefones;
show tables;
