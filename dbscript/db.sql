create database ds220252;
use ds220252;

create table tperson
(
idPerson char(36) not null,
firstName varchar(70) not null,
surName varchar(40) not null,
dni char(8) not null,
gender boolean not null,
birthDate date not null,
createdAt date not null,
updatedAt date not null,
primary key(idPerson)
) engine = innodb;

select * from tperson;