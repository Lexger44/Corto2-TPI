-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.23-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema biblioteca
--

create database biblioteca;
use biblioteca; 
 
create table bibliotecario (
   id bigint not null auto_increment,
   email varchar(255),
   login varchar(255) unique,
   nif varchar(255),
   password varchar(255),
   primary key (id)
) ENGINE=InnoDB;
 
create table ejemplar (
   id bigint not null auto_increment,
   fechaAdquisicion date,
   fechaDevolucion date,
   fechaPrestamo date,
   idEjemplar varchar(255),
   localizacion enum('SALA','CASA','DEPARTAMENTO') not null,
   observaciones varchar(255),
   libro_id bigint not null,
   usuario_id bigint,
   primary key (id)
) Engine=InnoDB;
 
create table historico (
   id bigint not null auto_increment,
   fechaDevolucion date,
   fechaDevolucionReal date,
   fechaPrestamo date,
   ejemplar_id bigint not null,
   usuario_id bigint not null,
   primary key (id)
) engine=InnoDB;
 
create table libro (
   id bigint not null auto_increment,
   autor varchar(255),
   fechaAlta date,
   isbn varchar(255) unique,
   numDisponibles integer,
   numPaginas integer,
   titulo varchar(255),
   primary key (id)
) engine=InnoDB;
 
create table multa (
   id bigint not null auto_increment,
   estado enum('ACTIVA','HISTORICA') not null,
   fechaFin date,
   fechaInicio date,
   usuario_id bigint not null,
   primary key (id)
) engine=InnoDB;
 
create table reserva (
   id bigint not null auto_increment,
   estado enum('ACTIVA','HISTORICA') not null,
   fecha date,
   fechaFin date,
   tipoFinal enum('CANCELADO','FINALIZADO'),
   libro_id bigint not null,
   usuario_id bigint not null,
   primary key (id)
) engine=InnoDB;
 
create table usuario (
   tipo varchar(31) not null,
   id bigint not null auto_increment,
   apellido1 varchar(255),
   apellido2 varchar(255),
   calle varchar(255),
   ciudad varchar(255),
   codigoPostal varchar(255),
   numero integer,
   piso varchar(255),
   email varchar(255) unique,
   estado enum('ACTIVO', 'MOROSO', 'MULTADO') not null,
   login varchar(255) unique,
   nombre varchar(255),
   password varchar(255),
   tutor varchar(255),
   departamento varchar(255),
   primary key (id)
) engine=InnoDB;
 
alter table ejemplar 
   add index FK95B940BAA013FCAC (usuario_id), 
   add constraint FK95B940BAA013FCAC 
   foreign key (usuario_id) 
   references usuario (id);
 
alter table ejemplar 
   add index FK95B940BA930E18AC (libro_id), 
   add constraint FK95B940BA930E18AC 
   foreign key (libro_id) 
   references libro (id);
 
alter table historico 
   add index FK66D8DFF0A013FCAC (usuario_id), 
   add constraint FK66D8DFF0A013FCAC 
   foreign key (usuario_id) 
   references usuario (id);
 
alter table historico 
   add index FK66D8DFF0F97DB50 (ejemplar_id), 
   add constraint FK66D8DFF0F97DB50 
   foreign key (ejemplar_id) 
   references ejemplar (id);
 
alter table multa 
   add index FK636D531A013FCAC (usuario_id), 
   add constraint FK636D531A013FCAC 
   foreign key (usuario_id) 
   references usuario (id);
 
alter table reserva 
   add index FK41640CB8A013FCAC (usuario_id), 
   add constraint FK41640CB8A013FCAC 
   foreign key (usuario_id) 
   references usuario (id);
 
alter table reserva 
   add index FK41640CB8930E18AC (libro_id), 
   add constraint FK41640CB8930E18AC 
   foreign key (libro_id) 
   references libro (id);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;