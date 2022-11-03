drop database ventasVideojuegos;
CREATE DATABASE  IF NOT EXISTS  ventasVideojuegos;
use ventasVideojuegos;


create table loginTienda (
login varchar(10),
password varchar(10),
id_tienda int,
primary key (login)
);

create table departamento(
id int,
nombre varchar(20),
alias varchar(5),
primary key (id)
);

create table usuario (
login varchar(10),
password varchar(10),
id_departamento int,
primary key (login)
);


alter table usuario add FOREIGN KEY (id_departamento) references departamento(id);


create table vendedor(
idVendedor int not null AUTO_INCREMENT,
nombreVendedor varchar(20) not null,
primary key (idVendedor)
);


create table boleta
(
nroBoleta int not null AUTO_INCREMENT,
rutCliente varchar(9)not null,
mayor18Anios bit (1) not null,
fechaCompra date not null,
metodoDePago char (1) not null,
cantidadAPagar float not null, 

id_vendedor int not null,
primary key (nroBoleta)
);

alter table boleta add FOREIGN KEY (id_vendedor) references vendedor(idVendedor);


insert into vendedor (nombreVendedor)  values ('Josefina');
insert into vendedor (nombreVendedor)  values ('Pedro');
insert into vendedor (nombreVendedor)  values ('Pablo');
insert into vendedor (nombreVendedor)  values ('carlos');

INSERT INTO boleta (rutCliente, mayor18Anios, fechaCompra, metodoDePago, cantidadAPagar,  id_vendedor) VALUES ( '144053451',0, '2022-06-05', 'C', 60.89, 1);
INSERT INTO boleta (rutCliente, mayor18Anios, fechaCompra, metodoDePago, cantidadAPagar,  id_vendedor) VALUES ( '21220773k',1, '2022-07-05', 'E', 66.8, 1);
INSERT INTO boleta (rutCliente, mayor18Anios, fechaCompra, metodoDePago, cantidadAPagar,  id_vendedor) VALUES ( '203445315',1, '2022-09-15', 'E', 60.58, 2);
INSERT INTO boleta (rutCliente, mayor18Anios, fechaCompra, metodoDePago, cantidadAPagar,  id_vendedor) VALUES ( '212783854',0, '2022-05-25', 'D', 50.38, 3);
INSERT INTO boleta (rutCliente, mayor18Anios, fechaCompra, metodoDePago, cantidadAPagar,  id_vendedor) VALUES ( '211946768',1, '2022-10-05', 'D', 20.9, 2);

insert into  departamento values (1, 'Gerencia', 'Ger');
insert into  departamento values (2, 'Personal', 'Per');
insert into  departamento values (3, 'Marketing', 'Mkt');

insert into  usuario values ('pablo', 'p', 3);
insert into  usuario values ('carlos', 'c', 2);
insert into  usuario values ('yerko', 'y', 1);