-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2022 a las 03:43:38
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `archivos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pdf`
--

CREATE TABLE `pdf` (
  `Codigo` int(10) NOT NULL,
  `Cedula` int(20) NOT NULL,
  `Documento` varchar(50) DEFAULT NULL,
  `Archivo` mediumblob DEFAULT NULL,
  `Fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pdf`
--

INSERT INTO `pdf` (`Codigo`, `Cedula`, `Documento`, `Archivo`, `Fecha`) VALUES
(1, 123123456, 'Documento', NULL, '2022-10-07'),
(2, 12345, 'Prueba2', NULL, '2022-10-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_Rol` int(20) NOT NULL,
  `Nombre_Rol` varchar(20) NOT NULL,
  `Leer` tinyint(1) NOT NULL,
  `Escribir` tinyint(1) NOT NULL,
  `Eliminar` tinyint(1) NOT NULL,
  `Editar` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_Rol`, `Nombre_Rol`, `Leer`, `Escribir`, `Eliminar`, `Editar`) VALUES
(1, 'Admin', 1, 1, 1, 1),
(2, 'Consultor', 1, 1, 0, 1),
(3, 'Visitante', 1, 1, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Id` int(20) NOT NULL,
  `id_Rol` int(20) NOT NULL,
  `Cedula` int(15) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `FechaN` date NOT NULL,
  `Direccion` varchar(30) NOT NULL,
  `Telefono` varchar(30) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  `Contra` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Usuarios';

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id`, `id_Rol`, `Cedula`, `Nombre`, `Apellidos`, `FechaN`, `Direccion`, `Telefono`, `Correo`, `Contra`) VALUES
(1, 1, 12345678, 'Admin', 'Admin', '2022-10-01', 'Calle 55 - 88 - 88', '87988787', 'admin@pruebas.com', 'admin1'),
(2, 2, 987654321, 'Consultor', 'Consultor', '2022-10-01', 'Calle 55 - 88 - 88', '87988787', 'consultor@pruebas.com', 'consultor1'),
(4, 3, 987, 'Test', 'Test', '2022-10-12', 'Callr 2', '12345', 'testqa@testqa.com', 'test'),
(5, 3, 123456789, 'Ma', 'Ma', '2022-10-06', 'Calle 21', '78797', 'Ma_fe@ma_ge.com', 'mafe1'),
(6, 3, 123123, 'test', 'test', '2022-10-06', 'calle  2', '1234567', 'santi@correo.com', '123456');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pdf`
--
ALTER TABLE `pdf`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_Rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `id_Rol` (`id_Rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pdf`
--
ALTER TABLE `pdf`
  MODIFY `Codigo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_Rol` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_Rol`) REFERENCES `rol` (`id_Rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
