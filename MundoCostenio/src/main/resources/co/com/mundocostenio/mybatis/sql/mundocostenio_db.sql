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

-- Volcando estructura para tabla mundocostenio_db.barrio
CREATE TABLE IF NOT EXISTS `barrio` (
  `barrio_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_barrio` varchar(50) NOT NULL,
  `departamento_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`barrio_id`) USING BTREE,
  KEY `FK_barrio_departamento` (`departamento_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.calle
CREATE TABLE IF NOT EXISTS `calle` (
  `calle_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_calle` enum('C','K','DG','CI','AV','V','TR','AK','AC') DEFAULT NULL,
  `nombre_calle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`calle_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.departamento
CREATE TABLE IF NOT EXISTS `departamento` (
  `departamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_departamento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`departamento_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.direccion
CREATE TABLE IF NOT EXISTS `direccion` (
  `direccion_id` int(11) NOT NULL AUTO_INCREMENT,
  `nro_puerta` int(11) DEFAULT NULL,
  `geo_localizacion` varchar(50) DEFAULT NULL,
  `barrio_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`direccion_id`),
  KEY `FK_direccion_barrio` (`barrio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.direccion_calles
CREATE TABLE IF NOT EXISTS `direccion_calles` (
  `dir_calles_id` int(11) NOT NULL AUTO_INCREMENT,
  `direccion_id` int(11) DEFAULT NULL,
  `calle_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dir_calles_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.fecha_vig_list_prec
CREATE TABLE IF NOT EXISTS `fecha_vig_list_prec` (
  `fecha_vigencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_ini` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`fecha_vigencia_id`) USING BTREE,
  UNIQUE KEY `fecha_ini_fecha_fin` (`fecha_ini`,`fecha_fin`),
  UNIQUE KEY `fecha_ini` (`fecha_ini`),
  UNIQUE KEY `fecha_fin` (`fecha_fin`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.lista_precios
CREATE TABLE IF NOT EXISTS `lista_precios` (
  `lista_precio_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_vig_id` int(11) NOT NULL,
  `descripcion_lista` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`lista_precio_id`) USING BTREE,
  KEY `FK_lista_precios_fecha_vig_list_prec` (`fecha_vig_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.list_prod_and_prec_prod
CREATE TABLE IF NOT EXISTS `list_prod_and_prec_prod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lis_prec_id` int(11) DEFAULT NULL,
  `prec_prod_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_list_prod_and_prec_prod_lista_precios` (`lis_prec_id`),
  KEY `FK_list_prod_and_prec_prod_precio_producto` (`prec_prod_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `persona_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `cedula` int(11) DEFAULT NULL,
  `rol` enum('ADMIN','USER','STAF','CLIENT') DEFAULT NULL,
  PRIMARY KEY (`persona_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.persona_direcciones
CREATE TABLE IF NOT EXISTS `persona_direcciones` (
  `direccion_personas_id` int(11) DEFAULT NULL,
  `direccion_id` int(11) DEFAULT NULL,
  `persona_id` int(11) DEFAULT NULL,
  KEY `FK_direccion_personas_persona` (`persona_id`),
  KEY `FK_direccion_personas_direccion` (`direccion_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla mundocostenio_db.precio_producto
CREATE TABLE IF NOT EXISTS `precio_producto` (
  `precio_prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_id` int(11) NOT NULL,
  `monto` int(11) DEFAULT NULL,
  PRIMARY KEY (`precio_prod_id`) USING BTREE,
  KEY `FK_precio_producto_producto` (`prod_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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

-- Volcando estructura para tabla mundocostenio_db.tipo_producto
CREATE TABLE IF NOT EXISTS `tipo_producto` (
  `tip_prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `desc_tipo_producto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tip_prod_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
