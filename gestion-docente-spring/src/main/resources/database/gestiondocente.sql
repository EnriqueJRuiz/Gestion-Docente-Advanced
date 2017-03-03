-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-03-2017 a las 13:20:40
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gestiondocente`
--
DROP DATABASE `gestiondocente`;
CREATE DATABASE IF NOT EXISTS `gestiondocente` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `gestiondocente`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `alumnoCreate`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnoCreate`(IN `papellidos` VARCHAR(250), IN `pcodigoPostal` INT(5), IN `pnombre` VARCHAR(50), IN `pdireccion` VARCHAR(250), IN `pdni` VARCHAR(9), IN `pemail` VARCHAR(150), IN `pfNacimiento` DATE, IN `pnHermanos` INT(2), IN `ppoblacion` VARCHAR(150), IN `ptelefono` INT(9), OUT `pcodigo` INT)
    NO SQL
BEGIN

	INSERT INTO alumno (nombre, apellidos, dni, email, telefono, fNacimiento, direccion, codigoPostal, poblacion, nHermanos) VALUES (UPPER(pnombre), UPPER(papellidos), UPPER(pdni), UPPER(pemail), ptelefono, pfNacimiento, UPPER(pdireccion), pcodigoPostal, UPPER(ppoblacion), pnHermanos);
    
SET pcodigo = LAST_INSERT_ID();

END$$

DROP PROCEDURE IF EXISTS `alumnoCursoInforme`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnoCursoInforme`(in pcodigo INT)
BEGIN
    SELECT a.codigo, a.nombre, a.apellidos, a.fNacimiento, a.telefono, a.direccion, a.poblacion, a.codigoPostal, a.dni, a.activo, a.email,a.nHermanos,
      c.codigo as cursocodigo, c.nombre as cursonombre, c.identificador as cursoidentificador, c.fInicio, c.fFin,c.nhoras    
    
    FROM alumno as a
		LEFT JOIN asistente as asi on a.codigo = asi.alumno_codigo
        LEFT JOIN imparticion as i on asi.imparticion_codigo = i.codigo
        LEFT JOIN curso_detalle as cd on i.codigo_curso_detalle = cd.codigo
		LEFT JOIN curso as c on cd.curso_codigo = c.codigo
			WHERE a.codigo > 0 AND a.codigo = pcodigo;
		
		
END$$

DROP PROCEDURE IF EXISTS `alumnoDelete`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnoDelete`(IN `pcodigo` INT)
    NO SQL
BEGIN

	UPDATE alumno SET activo = FALSE WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `alumnoDeleteF`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnoDeleteF`(IN `pcodigo` INT)
    NO SQL
    COMMENT 'Borrado fisico'
BEGIN
	DELETE FROM alumno WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `alumnoDniUnico`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnoDniUnico`(IN `pdni` VARCHAR(9))
    NO SQL
BEGIN
	SELECT a.codigo as codigo, a.nombre as nombre, a.apellidos as apellidos, a.dni as dni, a.email as email, a.telefono as telefono, a.fNacimiento as fNacimiento, a.direccion as direccion, a.codigoPostal as codigoPostal, a.poblacion as poblacion, a.nHermanos as nHermanos, a.activo as activo
    FROM alumno as a WHERE dni = pdni;
END$$

DROP PROCEDURE IF EXISTS `alumnogetAll`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnogetAll`()
    NO SQL
BEGIN
	SELECT a.codigo as codigo, a.nombre as nombre, a.apellidos as apellidos, a.dni as dni, a.email as email, a.telefono as telefono, a.fNacimiento as fNacimiento, a.direccion as direccion, a.codigoPostal as codigoPostal, a.poblacion as poblacion, a.nHermanos as nHermanos, a.activo as activo
    FROM alumno as a;

END$$

DROP PROCEDURE IF EXISTS `alumnogetByCurso`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnogetByCurso`(in pcodigo INT)
BEGIN
    SELECT a.codigo, a.nombre, a.apellidos, a.fNacimiento, a.telefono, a.direccion, a.poblacion, a.codigoPostal, a.dni, a.activo, a.email,a.nHermanos
    
    FROM alumno as a 
		LEFT JOIN asistente as asi on a.codigo = asi.alumno_codigo
        LEFT JOIN imparticion as i on asi.imparticion_codigo = i.codigo
        LEFT JOIN curso_detalle as cd on i.codigo_curso_detalle = cd.codigo
		LEFT JOIN curso as c on cd.curso_codigo = c.codigo
			
			WHERE c.codigo = pcodigo
            GROUP BY codigo;
            
END$$

DROP PROCEDURE IF EXISTS `alumnogetById`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnogetById`(IN `pcodigo` INT)
    NO SQL
BEGIN
	SELECT a.codigo as codigo, a.nombre as nombre, a.apellidos as apellidos, a.dni as dni, a.email as email, a.telefono as telefono, a.fNacimiento as fNacimiento, a.direccion as direccion, a.codigoPostal as codigoPostal, a.poblacion as poblacion, a.nHermanos as nHermanos, a.activo as activo
    FROM alumno as a
    WHERE codigo=pcodigo;

END$$

DROP PROCEDURE IF EXISTS `alumnoUpdate`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnoUpdate`(IN `pcodigo` INT, IN `papellidos` VARCHAR(250), IN `pcodigoPostal` INT(5), IN `pdireccion` VARCHAR(250), IN `pdni` VARCHAR(9), IN `pemail` VARCHAR(150), IN `pfNacimiento` DATE, IN `pnombre` VARCHAR(50), IN `pnHermanos` INT(2), IN `ptelefono` INT(9), IN `ppoblacion` VARCHAR(150))
    NO SQL
BEGIN

	UPDATE alumno SET nombre = UPPER(pnombre), apellidos = UPPER(papellidos), codigoPostal = pcodigoPostal, direccion = uPPER(pdireccion), dni = UPPER(pdni), email = UPPER(pemail), fNacimiento = pfNacimiento, nHermanos = pnHermanos, telefono = ptelefono, poblacion = UPPER(ppoblacion)	WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `clienteCreate`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `clienteCreate`(IN `pnombre` VARCHAR(50), IN `pidentificador` VARCHAR(15), IN `pemail` VARCHAR(150), IN `ptelefono` INT(9), IN `pdireccion` VARCHAR(250), IN `pcodigoPostal` INT(5), IN `ppoblacion` VARCHAR(150), OUT `pcodigo` INT)
    NO SQL
BEGIN

INSERT INTO cliente (nombre, identificador, email, telefono, direccion, codigoPostal, poblacion) 
    VALUES 
    (UPPER(pnombre), UPPER(pidentificador), UPPER(pemail), ptelefono,  UPPER(pdireccion), pcodigoPostal, UPPER(ppoblacion));
    
SET pcodigo = LAST_INSERT_ID();

END$$

DROP PROCEDURE IF EXISTS `clienteDelete`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `clienteDelete`(IN `pcodigo` INT)
    NO SQL
BEGIN

	UPDATE cliente SET activo = FALSE WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `clienteDeleteF`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `clienteDeleteF`(IN `pcodigo` INT)
    NO SQL
BEGIN
	DELETE FROM cliente WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `clientegetAll`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `clientegetAll`()
    NO SQL
BEGIN
	SELECT c.codigo as codigo, c.nombre as nombre, 
    c.identificador as identificador, c.email as email, c.direccion as direccion, c.codigoPostal as codigoPostal, c.poblacion as poblacion, c.telefono as telefono, c.activo as activo
    FROM cliente as c;

END$$

DROP PROCEDURE IF EXISTS `clientegetById`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `clientegetById`(IN `pcodigo` INT)
    NO SQL
BEGIN
	SELECT c.codigo as codigo, c.nombre as nombre, 
    c.identificador as identificador, c.email as email, c.direccion as direccion, c.codigoPostal as codigoPostal, c.poblacion as poblacion, c.telefono as telefono, c.activo as activo
    FROM cliente as c
    Where codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `clienteIdentificadorUnico`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `clienteIdentificadorUnico`(IN `pidentificador` VARCHAR(12))
    NO SQL
BEGIN	

	SELECT c.codigo as codigo, c.nombre as nombre, 
    c.identificador as identificador, c.email as email, c.direccion as direccion, c.codigoPostal as codigoPostal, c.poblacion as poblacion, c.telefono as telefono, c.activo as activo
    FROM cliente as c
    Where identificador = pidentificador;

END$$

DROP PROCEDURE IF EXISTS `clienteInforme`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `clienteInforme`(in pcodigo INT)
BEGIN
    SELECT c.codigo, c.nombre, c.telefono, c.direccion, c.poblacion, c.codigoPostal, c.identificador, c.activo, c.email,
		   cu.codigo as cursocodigo, cu.nombre as cursonombre, cu.identificador as cursoidentificador, cu.fInicio, cu.fFin,cu.nhoras
           /*, SUM(cd.precio) as preciocurso*/
    
    FROM cliente as c
		LEFT JOIN curso as cu ON cu.cliente_codigo = c.codigo
    WHERE c.codigo = pcodigo AND c.codigo >0;
    
END$$

DROP PROCEDURE IF EXISTS `clienteUpdate`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `clienteUpdate`(IN `pcodigo` INT, IN `pnombre` VARCHAR(50), IN `pcodigoPostal` INT(5), IN `pdireccion` VARCHAR(250), IN `pidentificador` VARCHAR(15), IN `pemail` VARCHAR(150), IN `ppoblacion` VARCHAR(150), IN `ptelefono` INT(9))
    NO SQL
BEGIN

	UPDATE cliente SET nombre = UPPER(pnombre), codigoPostal = pcodigoPostal, direccion = uPPER(pdireccion), identificador = UPPER(pidentificador), email = UPPER(pemail), telefono = ptelefono, poblacion = UPPER(ppoblacion)	WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `profesorCreate`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `profesorCreate`(IN `papellidos` VARCHAR(250), IN `pcodigoPostal` INT(5), IN `pnombre` VARCHAR(50), IN `pdireccion` VARCHAR(250), IN `pdni` VARCHAR(9), IN `pemail` VARCHAR(150), IN `pfNacimiento` DATE, IN `pnSS` BIGINT(12), IN `ppoblacion` VARCHAR(150), IN `ptelefono` INT(9), OUT `pcodigo` INT)
    NO SQL
BEGIN

	INSERT INTO profesor (nombre, apellidos, dni, email, telefono, fNacimiento, direccion, codigoPostal, poblacion, nSS) VALUES (UPPER(pnombre), UPPER(papellidos), UPPER(pdni), UPPER(pemail), ptelefono, pfNacimiento, UPPER(pdireccion), pcodigoPostal, UPPER(ppoblacion), pnSS);
    
SET pcodigo = LAST_INSERT_ID();

END$$

DROP PROCEDURE IF EXISTS `profesorDelete`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `profesorDelete`(IN `pcodigo` INT)
    NO SQL
BEGIN

	UPDATE profesor SET activo = FALSE WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `profesorDeleteF`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `profesorDeleteF`(IN `pcodigo` INT)
    NO SQL
BEGIN

	DELETE FROM profesor WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `profesorgetAll`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `profesorgetAll`()
    NO SQL
BEGIN
	SELECT p.codigo as codigo, p.nombre as nombre, p.apellidos as apellidos, p.dni as dni, p.email as email, p.telefono as telefono, p.fNacimiento as fNacimiento, p.direccion as direccion, p.codigoPostal as codigoPostal, p.poblacion as poblacion, p.nSS as nSS, p.activo as activo
    FROM profesor as p;

END$$

DROP PROCEDURE IF EXISTS `profesorgetById`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `profesorgetById`(IN `pcodigo` INT)
    NO SQL
BEGIN
	SELECT p.codigo as codigo, p.nombre as nombre, p.apellidos as apellidos, p.dni as dni, p.email as email, p.telefono as telefono, p.fNacimiento as fNacimiento, p.direccion as direccion, p.codigoPostal as codigoPostal, p.poblacion as poblacion, p.nSS as nSS, p.activo as activo
    FROM profesor as p
    WHERE codigo=pcodigo;

END$$

DROP PROCEDURE IF EXISTS `profesorUpdate`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `profesorUpdate`(IN `pcodigo` INT, IN `papellidos` VARCHAR(250), IN `pcodigoPostal` INT(5), IN `pdireccion` VARCHAR(250), IN `pdni` VARCHAR(9), IN `pemail` VARCHAR(150), IN `pfNacimiento` DATE, IN `pnombre` VARCHAR(50), IN `pnSS` BIGINT(12), IN `ptelefono` INT(9), IN `ppoblacion` VARCHAR(150))
    NO SQL
BEGIN

	UPDATE profesor SET nombre = UPPER(pnombre), apellidos = UPPER(papellidos), codigoPostal = pcodigoPostal, direccion = uPPER(pdireccion), dni = UPPER(pdni), email = UPPER(pemail), fNacimiento = pfNacimiento, nSS = pnSS, telefono = ptelefono, poblacion = UPPER(ppoblacion)	WHERE codigo = pcodigo;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE IF NOT EXISTS `alumno` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigoPostal` int(5) DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `nHermanos` int(2) DEFAULT '0',
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`codigo`, `dni`, `nombre`, `apellidos`, `fNacimiento`, `email`, `direccion`, `poblacion`, `codigoPostal`, `telefono`, `nHermanos`, `activo`) VALUES
(1, '45677362Y', 'ENRIQUE JAVIER', 'RUIZ JIMÉNEZ', '1985-12-01', 'ENRIQUEJ@ALGOMAIL.COM', '', '', 0, 666555444, 0, 1),
(3, '44444444A', 'xabier', 'QQQQ EEEE', '1998-11-12', 'ALGUIENPESAO@YYA.COM', 'A', '', 0, 444444444, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistente`
--

DROP TABLE IF EXISTS `asistente`;
CREATE TABLE IF NOT EXISTS `asistente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `alumno_codigo` int(11) NOT NULL,
  `imparticion_codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_asistente_alumno_codigo_idx` (`alumno_codigo`),
  KEY `fk_asistente_imparticion_codigo_idx` (`imparticion_codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `asistente`
--

INSERT INTO `asistente` (`codigo`, `alumno_codigo`, `imparticion_codigo`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 3, 1),
(4, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigoPostal` int(5) unsigned zerofill DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `identificador` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigo`, `nombre`, `direccion`, `codigoPostal`, `poblacion`, `identificador`, `telefono`, `email`, `activo`) VALUES
(0, 'cliente sin asignar', NULL, NULL, NULL, '12345678A', 0, 'cliente@sinasignar.es', 1),
(1, 'EMPRESA DE ALGUNA CLASE', '', 05000, '', '45678912Z', 654987321, 'ASFQAWFAFA@QAFSFA.COM', 1),
(3, 'ZZZ123456789ZZZ', '444555', 32165, 'DNZDSRFJNZTDJZDTZHZ', '11232123', 666222555, 'EUCALIPTUSLAND@GMAIL.COM', 1),
(4, 'AAA123456789', '', 00000, '', '11232122', 666222555, 'EUCALIPTUSLAND@GMAIL.COM', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `identificador` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `nHoras` int(11) NOT NULL,
  `fInicio` date DEFAULT NULL,
  `fFin` date DEFAULT NULL,
  `temario` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cliente_codigo` int(11) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  `precio` double(8,2) unsigned zerofill DEFAULT '00000.00',
  PRIMARY KEY (`codigo`),
  KEY `fk_curso_cliente_codigo_idx` (`cliente_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`codigo`, `nombre`, `identificador`, `nHoras`, `fInicio`, `fFin`, `temario`, `cliente_codigo`, `activo`, `precio`) VALUES
(1, 'desarrollo', '123456789', 80, NULL, NULL, NULL, 1, 1, 00000.00),
(2, 'administracion', '321654987', 120, NULL, NULL, NULL, 1, 1, 00000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_detalle`
--

DROP TABLE IF EXISTS `curso_detalle`;
CREATE TABLE IF NOT EXISTS `curso_detalle` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `curso_codigo` int(11) NOT NULL,
  `modulo_codigo` int(11) NOT NULL,
  `fFin` date DEFAULT NULL,
  `fInicio` date DEFAULT NULL,
  `precio` double(7,2) DEFAULT '0.00',
  PRIMARY KEY (`codigo`),
  KEY `fk_curso_detalle_modulo_codigo_idx` (`modulo_codigo`),
  KEY `fk_curso_detalle_curso_codigo_idx` (`curso_codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `curso_detalle`
--

INSERT INTO `curso_detalle` (`codigo`, `curso_codigo`, `modulo_codigo`, `fFin`, `fInicio`, `precio`) VALUES
(1, 1, 1, NULL, NULL, 0.00),
(2, 1, 2, NULL, NULL, 0.00),
(3, 2, 1, NULL, NULL, 0.00),
(4, 2, 2, NULL, NULL, 0.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion`
--

DROP TABLE IF EXISTS `evaluacion`;
CREATE TABLE IF NOT EXISTS `evaluacion` (
  `codigo` int(11) NOT NULL,
  `imparticion_codigo` int(11) NOT NULL,
  `alumno_codigo` int(11) NOT NULL,
  `fexamen` date NOT NULL,
  `nota` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `uq_modulo_codigo_alumno_codigo` (`imparticion_codigo`,`alumno_codigo`),
  KEY `pk_evaluacion_alumno_codigo_idx` (`alumno_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imparticion`
--

DROP TABLE IF EXISTS `imparticion`;
CREATE TABLE IF NOT EXISTS `imparticion` (
  `codigo` int(11) NOT NULL,
  `codigo_profesor` int(11) NOT NULL,
  `codigo_curso_detalle` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_imparticion_profesor_codigo_idx` (`codigo_profesor`),
  KEY `fk_imparticion_curso_detalle_codigo_idx` (`codigo_curso_detalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `imparticion`
--

INSERT INTO `imparticion` (`codigo`, `codigo_profesor`, `codigo_curso_detalle`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

DROP TABLE IF EXISTS `modulo`;
CREATE TABLE IF NOT EXISTS `modulo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nHoras` int(3) NOT NULL,
  `descripcion` text COLLATE utf8_unicode_ci,
  `precio` double(7,2) DEFAULT '0.00',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `modulo`
--

INSERT INTO `modulo` (`codigo`, `nombre`, `nHoras`, `descripcion`, `precio`) VALUES
(0, 'sin asignar', 0, NULL, 0.00),
(1, 'java', 0, NULL, 0.00),
(2, 'spring', 0, NULL, 0.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigoPostal` int(5) unsigned zerofill DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `nSS` bigint(12) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`codigo`, `dni`, `nombre`, `apellidos`, `fNacimiento`, `email`, `direccion`, `poblacion`, `codigoPostal`, `telefono`, `nSS`, `activo`) VALUES
(0, '12345678A', 'PROFESOR', 'NO ASIGNADO', '1998-11-12', 'ALUMNO@SINASIGNAR.ES', '', '', 00000, 666777666, 0, 1),
(1, '481234567', 'Urko', 'Villanueva Alvarez', '1976-11-24', '30693142x', 'Av. Mazustegi 9', 'Bilbao', 48009, 944110293, 0, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistente`
--
ALTER TABLE `asistente`
  ADD CONSTRAINT `fk_asistente_alumno_codigo` FOREIGN KEY (`alumno_codigo`) REFERENCES `alumno` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asistente_imparticion_codigo` FOREIGN KEY (`imparticion_codigo`) REFERENCES `imparticion` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `fk_curso_cliente_codigo` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `curso_detalle`
--
ALTER TABLE `curso_detalle`
  ADD CONSTRAINT `fk_curso_detalle_curso_codigo` FOREIGN KEY (`curso_codigo`) REFERENCES `curso` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_curso_detalle_modulo_codigo` FOREIGN KEY (`modulo_codigo`) REFERENCES `modulo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `evaluacion`
--
ALTER TABLE `evaluacion`
  ADD CONSTRAINT `pk_evaluacion_alumno_codigo` FOREIGN KEY (`alumno_codigo`) REFERENCES `alumno` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `pk_evaluacion_imparticion_codigo` FOREIGN KEY (`codigo`) REFERENCES `imparticion` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `imparticion`
--
ALTER TABLE `imparticion`
  ADD CONSTRAINT `fk_imparticion_curso_detalle_codigo` FOREIGN KEY (`codigo_curso_detalle`) REFERENCES `curso_detalle` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_imparticion_profesor_codigo` FOREIGN KEY (`codigo_profesor`) REFERENCES `profesor` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
