create database dbclinica;
use dbclinica;

create table usuario(
	id bigint primary key auto_increment,
    nome varchar(50) not null,
    email varchar(50) not null,
    senha varchar(50) not null,
    ativo bool default true
);


create table endereco(
	id bigint primary key auto_increment,
    cep varchar(8) not null,
    rua varchar(50) not null,
    bairro varchar(50) not null,
    cidade varchar(50) not null,
    estado varchar(2) not null
);
create table paciente(
	id bigint primary key auto_increment,
    cpf char(11) unique not null,
    id_usuario bigint not null,
    id_endereco bigint not null,
    telefone varchar(20) not null,
    foreign key (id_endereco) references endereco(id),
    foreign key (id_usuario) references usuario(id)
);


create table agendamento(
	id bigint primary key auto_increment,
	horario timestamp not null,
    id_paciente bigint not null,
    profissional varchar(20) not null,
    identificador_profissional varchar(20) not null,
    check (profissional in ('Médico','Fisioterapeuta','Nutricionista'))
);

create table medico(
	id bigint primary key auto_increment,
    crm varchar(20) not null,
    id_usuario bigint not null,
    foreign key (id_usuario) references usuario(id)
);

create table fisioterapeuta(
	id bigint primary key auto_increment,
    crefito varchar(20) not null,
    id_usuario bigint not null,
    foreign key (id_usuario) references usuario(id)
);

create table nutricionista(
	id bigint primary key auto_increment,
    crn varchar(20) not null,
    id_usuario bigint not null,
    foreign key (id_usuario) references usuario(id)
);

create table especialidades_medico(
	id bigint primary key auto_increment,
    titulo varchar(50) not null
);

insert into especialidades_medico(titulo) values
	('Cardiologia'), ('Ortopedia'), ('Otorrinolaringologista');

create table especialidades_fisioterapeuta(
	id bigint primary key auto_increment,
    titulo varchar(50) not null
);

insert into especialidades_fisioterapeuta(titulo) values
	('Geral');
    
create table especialidades_nutricionista(
	id bigint primary key auto_increment,
    titulo varchar(50) not null
);

insert into especialidades_nutricionista(titulo) values
	('Geral');
    
create table medico_tem_especialidades(
	id_medico bigint not null,
    id_especialidade bigint not null,
    primary key (id_medico,id_especialidade),
    foreign key (id_medico) references medico(id),
    foreign key (id_especialidade) references especialidades_medico(id)
);

create table fisioterapeuta_tem_especialidades(
	id_fisioterapeuta bigint not null,
    id_especialidade bigint not null,
    primary key (id_fisioterapeuta,id_especialidade),
    foreign key (id_fisioterapeuta) references fisioterapeuta(id),
    foreign key (id_especialidade) references especialidades_fisioterapeuta(id)
);

create table nutricionista_tem_especialidades(
	id_nutricionista bigint not null,
    id_especialidade bigint not null,
    primary key (id_nutricionista,id_especialidade),
    foreign key (id_nutricionista) references nutricionista(id),
    foreign key (id_especialidade) references especialidades_nutricionista(id)
);

create table perfil(
	id bigint not null primary key,
	descricao varchar(20) not null unique
);

insert into perfil(descricao) values('ADMIN'),('MEDICO'),('FISIOTERAPEUTA'),('NUTRICIONISTA'),('PACIENTE');
create table usuario_tem_perfis(
	id_perfil bigint not null,
    id_usuario bigint not null,
    primary key(id_perfil, id_usuario),
    foreign key (id_perfil) references perfil(id),
    foreign key (id_usuario) references usuario(id)
);

use dbclinica;
select * from usuario;
select * from endereco;
select * from paciente;
select * from agendamento;
select * from medico;
select * from fisioterpeuta;
select * from nutricionista;
select * from especialidades_medico;
select * from especialidades_fisioterapeuta;
select * from especialidades_nutricionista;
select * from medico_tem_especialidades;
select * from fisioterapeuta_tem_especialidades;
select * from nutricionista_tem_especialidades;
