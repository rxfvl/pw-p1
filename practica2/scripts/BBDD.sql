drop table if exists reservas;
drop table if exists pistas;
drop table if exists materiales;
drop table if exists jugadores;
drop table if exists bonos;

create table jugadores 
(
  id int primary key auto_increment,
  nombre varchar(50) not null,
  apellidos varchar(50) not null,
  fecha_nacimiento date not null,
  fecha_inscripcion date not null,
  correo_electronico varchar(100) not null
);

create table pistas 
(
  id int primary key auto_increment,
  nombre varchar(50) not null,
  estado int not null,
  tipo int not null,
  tamanio int not null,
  jugadores_max int not null
);

create table materiales 
(
  id int primary key auto_increment,
  tipo int not null,
  uso_material int not null,
  estado int not null,
  id_pista int,
  foreign key (id_pista) references pistas(id)
  );

create table bonos
(
  id int primary key auto_increment,
  tamanio_pista int not null,
  id_jugador int  not null,
  sesiones int not null,
  fecha_cad date not null,
  foreign key (id_jugador) references jugadores (id)
);

create table reservas 
(
  id int primary key auto_increment,
  fecha date not null,
  duracion int not null,
  id_pista int  not null,
  precio float not null,
  descuento float,
  tipo_reserva int not null,
  num_ninios int,
  num_adultos int,
  id_bono int,
  id_jugador int not null,
  foreign key (id_pista) references pistas (id),
  foreign key (id_bono) references bonos (id),
  foreign key (id_jugador) references jugadores (id)
);
