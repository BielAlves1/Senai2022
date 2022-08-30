drop database if exists lojinha;
create database lojinha charset=UTF8 collate utf8_general_ci;
use lojinha;

create table produtos (
    id integer not null auto_increment primary key,
    cod varchar(10) not null,
    nome varchar(50) not null,
    qntd integer not null,
    preco float(5, 2) not null
);

insert into produtos values (default, "CJ1234", "Camiseta Confortável", 10, 90.00);
insert into produtos values (default, "MO5432", "Moletom Foda", 5, 120.00);