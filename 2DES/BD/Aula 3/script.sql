-- Exclui o banco se existir
drop database if exists pedidos;

-- DDL Criação da estrutura do Banco de dados
create database pedidos charset=UTF8 collate utf8_general_ci;
use pedidos;
create table clientes(
    id_cliente integer not null primary key auto_increment,
    nome varchar(15) not null,
    sobrenome varchar(20) not null,
    endereco varchar(100) not null
);

create table telefones(
    id_cliente integer not null,
    telefone varchar(15) not null,
    foreign key (id_cliente) references clientes(id_cliente)
);

create table pedidos(
    numero_pedido integer not null primary key auto_increment,
    idC integer not null,
    data timestamp not null,
    valor_pedido decimal(8,2) not null,
    descricao varchar(100) not null,
    quantidade integer not null,
    foreign key (idC) references clientes(id_cliente)
);

describe clientes;
describe telefones;
describe pedidos;
show tables;

insert into clientes values
(null,"Jorge","Silva","Rua José Serra"),
(null,"Vanessa","Silva","Rua Jõao Serra"),
(null,"Guilherme","Melro","Rua Pedro Lanches II"),
(null,"Victória","Fiatinha","É sem teto");

insert into telefones values
(1, "(19)91997-5814"),
(2, "(19)97113-8936"),
(2, "(19)92548-6697"),
(1, "(19)93021-4902"),
(3, "(19)94220-0099");

insert into pedidos values
(null, 1, null, 5, "Pastel de Flango", 2),
(null, 1, null, 12, "cocquinha geladinha huuuuum", 1),
(null, 2, null, 3, "skolzada", 5),
(null, 3, null, 5, "Salgado de presunto e queijo", 2);


select * from clientes;
select * from telefones;
select * from pedidos;