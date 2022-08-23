drop database if exists academia;

create database academia charset=UTF8 collate utf8_general_ci;
use academia;

create table alunos(
    id_aluno integer not null primary key auto_increment,
    nome varchar(30) not null,
    nascimento Date not null,
    sexo varchar(15) not null,
    peso decimal(10,2) not null
);

create table telefones(
    id_aluno integer not null,
    telefone varchar(15) not null,
    foreign key (id_aluno) references alunos(id_aluno)
);

create table aparelhos(
    id_aparelho integer not null primary key auto_increment,
    nome_aparelho varchar(30) not null
);

create table exercicios(
    id_exercicio integer not null primary key auto_increment,
    id_aparelho integer not null,
    grupo_muscular varchar(15) not null,
    descricao varchar(100) not null,
    foreign key (id_aparelho) references aparelhos(id_aparelho)
);

create table ficha_exercicios(
    id_aluno integer not null,
    id_exercicio integer not null,
    dia_semana varchar(20) not null,
    serie varchar(50) not null,
    foreign key (id_aluno) references alunos(id_aluno)
    foreign key (id_exercicio) references exercicios(id_exercicio)
);

describe alunos;
describe telefones;
describe aparelhos;
describe exercicios;
describe ficha_exercicio;
show tables;
