drop database if exists escolaDanca;
create database escolaDanca charset=UTF8 collate utf8_general_ci;
use escolaDanca;

create table professores(
    id_prof integer primary key auto_increment,
    nome_prof varchar(20) not null,
    formacao varchar(30) not null
);

create table telefones(
    id_prof integer not null,
    telefone varchar(15) not null,
    foreign key(id_prof) references professores(id_prof)
);

create table turmas(
    id_turma integer primary key auto_increment,
    id_prof integer not null,
    horario varchar(30) not null,
    tipo varchar(30) not null,
    foreign key(id_prof) references professores(id_prof)
);

create table disciplinas(
    id_disc integer primary key auto_increment,
    id_turma integer not null,
    nome_disc varchar(20) not null,
    foreign key(id_turma) references turmas(id_turma)
);

create table horarios(
    id_horario integer primary key auto_increment,
    id_disc integer not null,
    inicio time not null,
    fim time not null,
    foreign key(id_disc) references disciplinas(id_disc)
);

create table alunos(
    ra integer primary key not null,
    id_turma integer not null,
    nome varchar(30) not null,
    sexo varchar(15) not null,
    data_nascimento DATE not null,
    foreign key(id_turma) references turmas(id_turma)
);

describe professores;
describe telefonea;
describe turmas;
describe disciplinas;
describe horarios;
describe alunos;

show tables;

insert into professores values
(default, 'Paulo Cunha', 'Antropologia'),
(default, 'Manuela', 'Sociologia');

insert into telefones values
(1,"19993452345"),
(1,"19984212444"),
(2,"19932342344"),
(2,"19942342355");

insert into turmas values
(default, 1, 'Manhã', 'Fundamental'),
(default, 2, 'Tarde', 'Fundamental'),
(default, 1, 'Noite', 'Médio');

insert into disciplinas values
(default, 1, 'História'),
(default, 1, 'Sociologia'),
(default, 2, 'Matemática'),
(default, 2, 'Literatura'),
(default, 3, 'Química'),
(default, 3, 'Biologia');

insert into horarios values
(default, 1, '07:30:00', '08:20:00'),
(default, 1, '08:20:00', '09:10:00'),
(default, 2, '13:30:00', '14:20:00'),
(default, 3, '14:20:00', '15:10:00'),
(default, 4, '15:10:00', '16:00:00'),
(default, 5, '16:00:00', '16:50:00');

insert into alunos values
('0000001', 1, 'João Silva', 'Masculino', '2008/11/21'),
('0000022', 1, 'Guilherme Alves', 'Masculino', '2008/05/07'),
('0000033', 1, 'Maria Fernanda Sousa', 'Feminino', '2007/10/10'),
('0000044', 2, 'Júlia Maha', 'Feminino', '2005/01/05'),
('0600055', 2, 'Fernando Melro', 'Masculino', '2004/12/20'),
('0000666', 2, 'Eduardo Azevedo', 'Masculino', '2004/12/30'),
('0000677', 3, 'Geovana Pinheiro', 'Feminino', '2005/07/20'),
('0000688', 3, 'Ana Beatriz', 'Feminino', '2004/06/15'),
('0000999', 3, 'Matheus Belli', 'Masculino', '2004/04/28');

select * from professores;
select * from telefones;
select * from turmas;
select * from disciplinas;
select * from horarios;
select * from alunos;

create VIEW vw_professores as
select p.id_prof, p.nome_prof, p.formacao, t.telefone from professores p
inner join telefones t 
on p.id_prof = t.id_prof;

select * from vw_professores;

create view vw_prof_turma as
select p.nome_prof, t.tipo from Professores p 
inner join Turmas t
ON p.id_prof = t.id_prof;

select * from vw_prof_turma;

create view vw_turmas_disc as
select t.tipo, d.nome_disc from turmas t 
inner join disciplinas d
ON t.id_turma = d.id_turma;

select * from vw_turmas_disc;

create view vw_turmas_alunos as
select t.tipo, a.ra, a.nome, a.sexo, (SELECT YEAR(CURDATE())-YEAR(a.data_nascimento)-IF(MONTH(CURDATE())*32+DAY(CURDATE())<MONTH(a.data_nascimento)*32+DAY(a.data_nascimento),1,0) as idade) from turmas t
inner join alunos a
on t.id_turma = a.id_turma;

select * from vw_turmas_alunos;

create view vw_disc_horarios as
select d.nome_disc, h.inicio, h.fim from disciplinas d
inner join horarios h
on d.id_disc = h.id_disc;

select * from vw_disc_horarios;