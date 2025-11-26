create database dbds220252;
use dbds220252;

create table tperson
(
idPerson char(36) not null,
firstName varchar(70) not null,
surName varchar(40) not null,
dni char(8) not null,
gender boolean not null,
birthDate datetime not null,
createdAt datetime not null,
updatedAt date not null,
primary key(idPerson)
) engine = innodb;