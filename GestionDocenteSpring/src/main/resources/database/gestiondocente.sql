-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-02-2017 a las 13:01:52
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
	sELECT dni from alumno WHERE dni = pdni;
END$$

DROP PROCEDURE IF EXISTS `alumnogetAll`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnogetAll`()
    NO SQL
BEGIN
	SELECT a.codigo as codigo, a.nombre as nombre, a.apellidos as apellidos, a.dni as dni, a.email as email, a.telefono as telefono, a.fNacimiento as fNacimiento, a.direccion as direccion, a.codigoPostal as codigoPostal, a.poblacion as poblacion, a.nHermanos as nHermanos, a.activo as activo
    FROM alumno as a;

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
  `nHermanos` int(2) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`codigo`, `dni`, `nombre`, `apellidos`, `fNacimiento`, `email`, `direccion`, `poblacion`, `codigoPostal`, `telefono`, `nHermanos`, `activo`) VALUES
(1, '45678912H', 'Enrique Javier', 'Ruiz Jiménez', '1985-12-01', 'enriquej@algomail.com', NULL, NULL, NULL, 678945123, NULL, 1),
(3, '45677362Y', '66666666', 'QQQQ EEEE', '1998-11-12', 'ALGUIENPESAO@YYA.COM', 'A', '', 0, 444444444, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigoPostal` int(5) DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `identificador` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigo`, `nombre`, `direccion`, `codigoPostal`, `poblacion`, `identificador`, `telefono`, `email`, `activo`) VALUES
(1, 'Empresa de alguna clase', NULL, NULL, NULL, '45678912Z', 654987321, 'asfqawfafa@qafsfa.com', 1),
(3, 'ZZZ123456789ZZZ', '444555', 32165, 'DNZDSRFJNZTDJZDTZHZ', '11232123', 666222555, 'EUCALIPTUSLAND@GMAIL.COM', 1);

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
  `codigoPostal` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `nSS` bigint(12) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`codigo`, `dni`, `nombre`, `apellidos`, `fNacimiento`, `email`, `direccion`, `poblacion`, `codigoPostal`, `telefono`, `nSS`, `activo`) VALUES
(1, '45612378R', 'Enrique Javier', 'Ruiz Jiménez', NULL, 'alguienporhay@klesden.com', NULL, NULL, NULL, 654987123, 123456789123, 0),
(2, '45677362Y', 'ZZZZZZZZ', 'SSSSSSSS', '2017-01-20', 'JJJJJJ@AAAAAAA.COM', 'AAAAAAAAAAAAAA', 'AAAAAAAAAAAAAA', '12345', 564987321, 123456789123, 0),
(4, '45677362Y', 'AAAAAAAAAAAAAA', 'AAAAAAAAAAAAAA', '1999-01-02', 'AAAAAAA@AAAAAAA.COM', 'AAAAAAAAAAAAAA', 'AAAAAAAAAAAAAA', '12345', 654987321, 123456789123, 0),
(5, '45677362Y', 'AAA123456789', 'MONASTERIO HERRER', '2017-02-15', 'AA@AA.COM', '', '', '0', 666222555, 123456789123, 0),
(6, '45677362Y', 'AAA123456789', 'MONASTERIO HERRER', '2017-02-15', 'EUCALIPTUSLAND@GMAIL.COM', '444', 'DNZDSRFJNZTDJZDTZHZ', '0', 987654321, 4444, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
