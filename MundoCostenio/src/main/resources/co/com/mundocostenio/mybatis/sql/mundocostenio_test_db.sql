-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.10-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para mundocostenio_db
CREATE DATABASE IF NOT EXISTS `mundocostenio_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mundocostenio_db`;

-- Volcando estructura para tabla mundocostenio_db.addresses
CREATE TABLE IF NOT EXISTS `addresses` (
  `ADDR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STREET` varchar(50) NOT NULL,
  `CITY` varchar(50) NOT NULL,
  `STATE` varchar(50) NOT NULL,
  `ZIP` varchar(10) DEFAULT NULL,
  `COUNTRY` varchar(50) NOT NULL,
  PRIMARY KEY (`ADDR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.barrio
CREATE TABLE IF NOT EXISTS `barrio` (
  `barrio_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_barrio` varchar(50) NOT NULL,
  PRIMARY KEY (`barrio_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.barrio_departamento
CREATE TABLE IF NOT EXISTS `barrio_departamento` (
  `barrio_departamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_barrio` int(11) NOT NULL DEFAULT 0,
  `id_departamento` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`barrio_departamento_id`) USING BTREE,
  KEY `FK_barrio_departamento_barrio` (`id_barrio`),
  KEY `FK_barrio_departamento_departamento` (`id_departamento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.calle
CREATE TABLE IF NOT EXISTS `calle` (
  `calle_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_calle` enum('CALLE','CARRERA','DIAGONAL','CIRCUNVALAR','AVENIDA','VIA','TRANSVERSAL','AVENIDA_CARRERA','AVENIDA_CALLE') DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`calle_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `COURSE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(512) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `TUTOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`COURSE_ID`),
  KEY `FK_COURSE_TUTOR` (`TUTOR_ID`),
  CONSTRAINT `FK_COURSE_TUTOR` FOREIGN KEY (`TUTOR_ID`) REFERENCES `tutors` (`TUTOR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.course_enrollment
CREATE TABLE IF NOT EXISTS `course_enrollment` (
  `COURSE_ID` int(11) NOT NULL,
  `STUD_ID` int(11) NOT NULL,
  PRIMARY KEY (`COURSE_ID`,`STUD_ID`),
  KEY `FK_ENROLLMENT_STUD` (`STUD_ID`),
  CONSTRAINT `FK_ENROLLMENT_COURSE` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`COURSE_ID`),
  CONSTRAINT `FK_ENROLLMENT_STUD` FOREIGN KEY (`STUD_ID`) REFERENCES `students` (`STUD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.departamento
CREATE TABLE IF NOT EXISTS `departamento` (
  `departamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_departamento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`departamento_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.direccion
CREATE TABLE IF NOT EXISTS `direccion` (
  `direccion_id` int(11) DEFAULT NULL,
  `departamento_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.direccion_personas
CREATE TABLE IF NOT EXISTS `direccion_personas` (
  `direccion_personas_id` int(11) DEFAULT NULL,
  `direccion_id` int(11) DEFAULT NULL,
  `persona_id` int(11) DEFAULT NULL,
  KEY `FK_direccion_personas_persona` (`persona_id`),
  KEY `FK_direccion_personas_direccion` (`direccion_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.fecha_vig_list_prec
CREATE TABLE IF NOT EXISTS `fecha_vig_list_prec` (
  `fecha_vigencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_ini` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`fecha_vigencia_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.lista_precios
CREATE TABLE IF NOT EXISTS `lista_precios` (
  `lista_precio_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_vig_id` int(11) NOT NULL,
  `descripcion_lista` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`lista_precio_id`) USING BTREE,
  KEY `FK_lista_precios_fecha_vig_list_prec` (`fecha_vig_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.list_prod_and_prec_prod
CREATE TABLE IF NOT EXISTS `list_prod_and_prec_prod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lis_prec_id` int(11) DEFAULT NULL,
  `prec_prod_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_list_prod_and_prec_prod_lista_precios` (`lis_prec_id`),
  KEY `FK_list_prod_and_prec_prod_precio_producto` (`prec_prod_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `persona_id` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `cedula` int(11) DEFAULT NULL,
  `rol` enum('ADMIN','USER','STAF','CLIENT') DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.precio_producto
CREATE TABLE IF NOT EXISTS `precio_producto` (
  `precio_prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_id` int(11) NOT NULL,
  `monto` int(11) DEFAULT NULL,
  PRIMARY KEY (`precio_prod_id`) USING BTREE,
  KEY `FK_precio_producto_producto` (`prod_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_prod_id` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`prod_id`) USING BTREE,
  KEY `FK_producto_tipo_producto` (`tipo_prod_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.roles_personas
CREATE TABLE IF NOT EXISTS `roles_personas` (
  `rol_persona_id` int(11) NOT NULL AUTO_INCREMENT,
  `rol_id` int(11) DEFAULT NULL,
  `persona_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rol_persona_id`) USING BTREE,
  UNIQUE KEY `rol_id_persona_id` (`rol_id`,`persona_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.students
CREATE TABLE IF NOT EXISTS `students` (
  `STUD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PHONE` varchar(15) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `BIO` longtext DEFAULT NULL,
  `PIC` blob DEFAULT NULL,
  `ADDR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`STUD_ID`),
  KEY `FK_STUDENTS_ADDR` (`ADDR_ID`),
  CONSTRAINT `FK_STUDENTS_ADDR` FOREIGN KEY (`ADDR_ID`) REFERENCES `addresses` (`ADDR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.tipo_producto
CREATE TABLE IF NOT EXISTS `tipo_producto` (
  `tip_prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tip_prod_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.tutors
CREATE TABLE IF NOT EXISTS `tutors` (
  `TUTOR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PHONE` varchar(15) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `BIO` longtext DEFAULT NULL,
  `PIC` blob DEFAULT NULL,
  `ADDR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`TUTOR_ID`),
  KEY `FK_TUTORS_ADDR` (`ADDR_ID`),
  CONSTRAINT `FK_TUTORS_ADDR` FOREIGN KEY (`ADDR_ID`) REFERENCES `addresses` (`ADDR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.ubicacion
CREATE TABLE IF NOT EXISTS `ubicacion` (
  `ubicacion_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_calle_1` int(11) DEFAULT NULL,
  `id_calle_2` int(11) DEFAULT NULL,
  `nro_puerta` int(11) DEFAULT NULL,
  `geo_localizacion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ubicacion_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.user_pics
CREATE TABLE IF NOT EXISTS `user_pics` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `PIC` blob DEFAULT NULL,
  `BIO` longtext DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
