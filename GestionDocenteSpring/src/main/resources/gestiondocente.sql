-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-02-2017 a las 13:34:28
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
DROP PROCEDURE IF EXISTS `alumnoDelete`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnoDelete`(IN `pcodigo` INT)
    NO SQL
BEGIN
	DELETE FROM alumno WHERE codigo = pcodigo;

END$$

DROP PROCEDURE IF EXISTS `alumnogetAll`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnogetAll`()
    NO SQL
BEGIN
	SELECT a.codigo as codigo, a.nombre as nombre, a.apellidos as apellidos, a.dni as dni, a.email as email, a.telefono as telefono, a.fNacimiento as fNacimiento, a.direccion as direccion, a.codigoPostal as codigoPostal, a.poblacion as poblacion, a.nHermanos as nHermanos
    FROM alumno as a;

END$$

DROP PROCEDURE IF EXISTS `alumnogetById`$$
CREATE DEFINER=`root`@`127.0.0.1` PROCEDURE `alumnogetById`(IN `pcodigo` INT)
    NO SQL
BEGIN
	SELECT a.codigo as codigo, a.nombre as nombre, a.apellidos as apellidos, a.dni as dni, a.email as email, a.telefono as telefono, a.fNacimiento as fNacimiento, a.direccion as direccion, a.codigoPostal as codigoPostal, a.poblacion as poblacion, a.nHermanos as nHermanos
    FROM alumno as a
    WHERE CODIGO=pcodigo;

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
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigoPostal` int(5) DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `nHermanos` int(2) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`codigo`, `dni`, `nombre`, `apellidos`, `fNacimiento`, `email`, `direccion`, `poblacion`, `codigoPostal`, `telefono`, `nHermanos`, `activo`) VALUES
(1, '45678912H', 'Enrique Javier', 'Ruiz Jiménez', '1985-12-01', 'enriquej@algomail.com', NULL, NULL, NULL, 678945123, NULL, 1);

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
  `identificador` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigo`, `nombre`, `direccion`, `codigoPostal`, `poblacion`, `identificador`, `telefono`, `email`) VALUES
(1, 'Empresa de alguna clase', NULL, NULL, NULL, '45678912Z', 654987321, 'asfqawfafa@qafsfa.com'),
(2, 'otra empresa', NULL, NULL, NULL, '78954862Q', 987654321, 'awfafw@agwga.com');

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
  `fNacimineto` date DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigoPostal` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `nSS` bigint(12) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`codigo`, `dni`, `nombre`, `apellidos`, `fNacimineto`, `email`, `direccion`, `poblacion`, `codigoPostal`, `telefono`, `nSS`) VALUES
(1, '45612378R', 'Enrique Javier', 'Ruiz Jiménez', NULL, 'alguienporhay@klesden.com', NULL, NULL, NULL, 654987123, 123456789123);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
