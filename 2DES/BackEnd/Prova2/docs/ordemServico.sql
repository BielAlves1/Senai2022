drop database if exists ordemServico;
create database ordemServico charset=UTF8 collate utf8_general_ci;
use ordemServico;

create table funcionarios(
    id_func integer primary key auto_increment,
    nome varchar(30) not null,
    especialidade varchar(30) not null
);

create table os(
    id_Os integer primary key auto_increment,
    id_func integer not null,
    descricao varchar(100) not null,
    custo decimal(10,2) not null,
    foreign key(id_func) references funcionarios(id_func)
);
 
describe funcionarios;
describe os;

show tables;

insert into funcionarios values
(default, 'Ana', 'Encanador/(a)'),
(default, 'Juliana', 'Pedreiro/(a)'),
(default, 'Fabiana', 'Pintor/(a)'),
(default, 'Ivana', 'Eletricista/(a)');

insert into os values
(default, 1, 'Concertar Chuveiro', 50),
(default, 1, 'Torneira Pingando', 50),
(default, 1, 'Vazamento no Banheiro', 300),
(default, 2, 'Trocar porta da cozinha', 150),
(default, 2, 'Colocar piso no banheiro', 600),
(default, 3, 'Pintar um quarto', 200),
(default, 4, 'Trocar resistência do chuveiro', 50);

select * from funcionarios;
select * from os;

