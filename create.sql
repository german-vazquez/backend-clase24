drop table if exists domicilios;
create table domicilios (
id int auto_increment primary key,
calle varchar(100) not null,
numero int not null,
localidad varchar(100) not null,
provincia varchar(100) not null);

drop table if exists pacientes;
create table pacientes(
id int auto_increment primary key,
apellido varchar(100) not null,
nombre varchar(100) not null,
email varchar (100) not null,
dni int not null,
fecha date not null,
domicilio_id int not null);

drop table if exists odontologos;
create table odontologos (
id int auto_increment primary key,
apellido varchar(100) not null,
nombre varchar(100) not null,
matricula varchar(50) not null);

insert into odontologos (apellido, nombre, matricula)
values('muelas', 'juan', 'MP548');


insert into domicilios (calle, numero, localidad, provincia)
values ('calle1',484, 'saltacap', 'salta');

insert into pacientes (apellido, nombre, email, dni, fecha, domicilio_id)
values('vazquez', 'fulanito', 'gmail@gmail.com', 30120, '2022-08-25',1);