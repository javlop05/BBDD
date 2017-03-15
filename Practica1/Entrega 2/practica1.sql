-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-02-2016 a las 18:37:00
-- Versión del servidor: 5.5.40
-- Versión de PHP: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `practica1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aficiones`
--

CREATE TABLE IF NOT EXISTS `aficiones` (
  `CorreoUsu` varchar(30) NOT NULL,
  `Aficion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigos`
--

CREATE TABLE IF NOT EXISTS `amigos` (
  `Correo1` varchar(30) NOT NULL,
  `Correo2` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generointeres`
--

CREATE TABLE IF NOT EXISTS `generointeres` (
  `CorreoUsu` varchar(30) NOT NULL,
  `GenInteres` enum('Masculino','Femenino') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invitacionapregunta`
--

CREATE TABLE IF NOT EXISTS `invitacionapregunta` (
`IdInv` int(11) NOT NULL,
  `IdPreg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE IF NOT EXISTS `mensaje` (
`Id` int(11) NOT NULL,
  `CorreoEmisor` varchar(30) NOT NULL,
  `CorreoReceptor` varchar(30) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Leido` tinyint(1) DEFAULT NULL,
  `Tipo` enum('Pregunta','Solicitud','Texto') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opciones`
--

CREATE TABLE IF NOT EXISTS `opciones` (
`Id` int(11) NOT NULL,
  `NumeroOrden` int(11) NOT NULL,
  `Texto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE IF NOT EXISTS `pregunta` (
`Id` int(11) NOT NULL,
  `Enunciado` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responde`
--

CREATE TABLE IF NOT EXISTS `responde` (
  `CorreoUsu` varchar(30) NOT NULL,
  `IdPreg` int(11) NOT NULL,
  `NumeroOpcion` int(11) NOT NULL,
  `Relevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerenciaamistad`
--

CREATE TABLE IF NOT EXISTS `sugerenciaamistad` (
`IdSug` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `texto`
--

CREATE TABLE IF NOT EXISTS `texto` (
`IdTexto` int(11) NOT NULL,
  `Contenido` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `Correo` varchar(30) NOT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Genero` enum('Masculino','Femenino') NOT NULL,
  `Latitud` double NOT NULL,
  `Longitud` double NOT NULL,
  `Imagen` blob,
  `FechaNac` date DEFAULT NULL,
  `Descripcion` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aficiones`
--
ALTER TABLE `aficiones`
 ADD PRIMARY KEY (`CorreoUsu`);

--
-- Indices de la tabla `amigos`
--
ALTER TABLE `amigos`
 ADD PRIMARY KEY (`Correo1`,`Correo2`), ADD KEY `Correo2` (`Correo2`);

--
-- Indices de la tabla `generointeres`
--
ALTER TABLE `generointeres`
 ADD PRIMARY KEY (`CorreoUsu`);

--
-- Indices de la tabla `invitacionapregunta`
--
ALTER TABLE `invitacionapregunta`
 ADD PRIMARY KEY (`IdInv`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
 ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `opciones`
--
ALTER TABLE `opciones`
 ADD PRIMARY KEY (`Id`,`NumeroOrden`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
 ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `responde`
--
ALTER TABLE `responde`
 ADD PRIMARY KEY (`CorreoUsu`,`IdPreg`,`NumeroOpcion`), ADD KEY `IdPreg` (`IdPreg`);

--
-- Indices de la tabla `sugerenciaamistad`
--
ALTER TABLE `sugerenciaamistad`
 ADD PRIMARY KEY (`IdSug`);

--
-- Indices de la tabla `texto`
--
ALTER TABLE `texto`
 ADD PRIMARY KEY (`IdTexto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`Correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `invitacionapregunta`
--
ALTER TABLE `invitacionapregunta`
MODIFY `IdInv` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `opciones`
--
ALTER TABLE `opciones`
MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sugerenciaamistad`
--
ALTER TABLE `sugerenciaamistad`
MODIFY `IdSug` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `texto`
--
ALTER TABLE `texto`
MODIFY `IdTexto` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aficiones`
--
ALTER TABLE `aficiones`
ADD CONSTRAINT `aficiones_ibfk_1` FOREIGN KEY (`CorreoUsu`) REFERENCES `usuario` (`Correo`) ON DELETE CASCADE;

--
-- Filtros para la tabla `amigos`
--
ALTER TABLE `amigos`
ADD CONSTRAINT `amigos_ibfk_1` FOREIGN KEY (`Correo1`) REFERENCES `usuario` (`Correo`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `amigos_ibfk_2` FOREIGN KEY (`Correo2`) REFERENCES `usuario` (`Correo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `generointeres`
--
ALTER TABLE `generointeres`
ADD CONSTRAINT `generointeres_ibfk_1` FOREIGN KEY (`CorreoUsu`) REFERENCES `usuario` (`Correo`) ON DELETE CASCADE;

--
-- Filtros para la tabla `invitacionapregunta`
--
ALTER TABLE `invitacionapregunta`
ADD CONSTRAINT `invitacionapregunta_ibfk_1` FOREIGN KEY (`IdInv`) REFERENCES `mensaje` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `opciones`
--
ALTER TABLE `opciones`
ADD CONSTRAINT `opciones_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `pregunta` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `responde`
--
ALTER TABLE `responde`
ADD CONSTRAINT `responde_ibfk_1` FOREIGN KEY (`CorreoUsu`) REFERENCES `usuario` (`Correo`) ON DELETE CASCADE,
ADD CONSTRAINT `responde_ibfk_2` FOREIGN KEY (`IdPreg`) REFERENCES `opciones` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sugerenciaamistad`
--
ALTER TABLE `sugerenciaamistad`
ADD CONSTRAINT `sugerenciaamistad_ibfk_1` FOREIGN KEY (`IdSug`) REFERENCES `mensaje` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `texto`
--
ALTER TABLE `texto`
ADD CONSTRAINT `texto_ibfk_1` FOREIGN KEY (`IdTexto`) REFERENCES `mensaje` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
