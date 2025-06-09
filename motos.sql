-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2025 a las 07:50:57
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `motos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `curp` varchar(18) NOT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `ApellidoPaterno` varchar(100) DEFAULT NULL,
  `ApellidoMaterno` varchar(100) DEFAULT NULL,
  `Calle` varchar(150) DEFAULT NULL,
  `colonia` varchar(100) DEFAULT NULL,
  `CP` varchar(10) DEFAULT NULL,
  `ProductoAdquirido` varchar(50) DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`curp`, `Cliente`, `ApellidoPaterno`, `ApellidoMaterno`, `Calle`, `colonia`, `CP`, `ProductoAdquirido`, `Precio`) VALUES
('ADMT7976', 'Adelina', 'Martinez', 'Nieto', 'Calle Rufino Juarez 56', 'Girasoles', '8987', 'Harley-Davidson Sportster - M006', 450000.00),
('CASM911008MDFERT12', 'Martha', 'Castro', 'Aguilar', 'Calle Matamoros 963', 'Centro Historico', '68000', 'KTM Duke 125 - M038', 85000.00),
('DELC860821HDFBNM15', 'Carlos', 'Delgado', 'Sanchez', 'Av. Eduardo Vasconcelos 468', 'Vasconcelos', '68140', 'Kawasaki Ninja 400 - M042', 155000.00),
('FLOI930317MDFUIO14', 'Irma', 'Flores', 'Perez', 'Calle Aldama 357', 'Niños Heroes', '68090', 'Royal Enfield Classic 500 - M041', 125000.00),
('GARJ870930HDFKLM05', 'Jorge Luis', 'Garcia', 'Fernandez', 'Av. Universidad 654', 'Universitaria', '68120', 'Honda Shadow 750 - M022', 195000.00),
('GATL98987', 'Luis Jared', 'García', 'García', 'Calle Prueba1', 'La prueba', '26592', 'Bajaj pulsar ns160 - M005', 45000.00),
('GOMJ850312HDFNZR01', 'Juan Carlos', 'Gomez', 'Martinez', 'Calle Morelos 123', 'Centro', '68000', 'Yamaha MT-07 - M015', 185000.00),
('HERR910815MDFGHJ04', 'Rosa Maria', 'Hernandez', 'Gutierrez', 'Calle Hidalgo 321', 'Santa Rosa', '68070', 'Yamaha YBR 125 - M023', 35000.00),
('LOPK920705MDFRTG02', 'Karla Patricia', 'Lopez', 'Ramirez', 'Av. Independencia 456', 'Reforma', '68050', 'Honda CRF250L - M016', 98000.00),
('MEDL840603MDFZXC08', 'Lucia', 'Mendez', 'Vargas', 'Av. Oaxaca 258', 'Colonia Mexico', '68040', 'Bajaj NS200 - M028', 52000.00),
('MORR890726MDFASD10', 'Rocio', 'Morales', 'Cruz', 'Av. Ferrocarril 741', 'Ferrocarril', '68130', 'Yamaha MT-03 - M033', 125000.00),
('PAZD950202HDFZXV11', 'David', 'Paz', 'Romero', 'Calle Reforma 852', 'Reforma', '68050', 'Honda CB500X - M037', 145000.00),
('RIVP870522HDFGHY13', 'Pedro', 'Rivera', 'Mendoza', 'Av. Símbolos Patrios 159', 'Símbolos Patrios', '68060', 'Suzuki GN125 - M040', 32000.00),
('RUMF891127HDFCVB07', 'Fernando', 'Ruiz', 'Silva', 'Calle Allende 147', 'Jalatlaco', '68090', 'Triumph Tiger 800 - M027', 265000.00),
('SANM880220HDFRTY03', 'Miguel Angel', 'Sanchez', 'Morales', 'Calle Juarez 789', 'Xochimilco', '68100', 'KTM Duke 390 - M021', 165000.00),
('TORV930418MDFNBV06', 'Veronica', 'Torres', 'Castillo', 'Calle Zaragoza 987', 'El Llano', '68080', 'Italika CS150 - M026', 28000.00),
('VASJ920114HDFQWE09', 'Javier', 'Vasquez', 'Jimenez', 'Calle Porfirio Diaz 369', 'Exhacienda Candiani', '68110', 'Honda Wave 110 - M031', 25000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `marca_modelo` varchar(100) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `ruta_imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `descripcion`, `marca_modelo`, `precio`, `stock`, `ruta_imagen`) VALUES
('M001', 'Moto deportiva 600cc color azul', 'Yamaha YZF-R6', 280000.00, 8, 'src/proyecto/Imagenes/M001.jpeg'),
('M003', 'Moto touring 1250cc color gris', 'BMW R1250GS', 390000.00, 4, 'src/proyecto/Imagenes/M003.jpg'),
('M004', 'Moto scooter 125cc color blanco', 'Honda PCX125', 65000.00, 4, 'src/proyecto/Imagenes/M004.jpeg'),
('M005', 'motocicleta 160 cc callejera deportiva color negro azulado', 'Bajaj pulsar ns160', 45000.00, 10, 'src/proyecto/Imagenes/M005.jpg'),
('M006', 'Moto cruiser 1200cc color negro', 'Harley-Davidson Sportster', 450000.00, 2, 'src/proyecto/Imagenes/M006.jpg'),
('M007', 'Moto urbana 150cc color negro mate', 'Suzuki Gixxer 150', 41000.00, 4, NULL),
('M009', 'Moto eléctrica urbana color blanco perla', 'Super Soco TC', 72000.00, 5, NULL),
('M010', 'Moto de pista 1000cc color rojo', 'Ducati Panigale V4', 610000.00, 9, NULL),
('M011', 'motocicleta 160 cc callejera deportiva color negro azulado', 'Bajaj pulsar ns160', 45000.00, 11, NULL),
('M012', 'moto de terrenos 150 cc rojo perla', 'vento trimer 150 cc', 27895.00, 4, NULL),
('M013', 'Moto deportiva 1000cc color verde', 'Kawasaki Ninja ZX-10R', 320000.00, 2, NULL),
('M014', 'Moto custom 883cc color negro brillante', 'Harley Iron 883', 380000.00, 3, NULL),
('M015', 'Moto naked 650cc color azul metalico', 'Yamaha MT-07', 185000.00, 7, NULL),
('M016', 'Moto enduro 250cc color rojo y blanco', 'Honda CRF250L', 98000.00, 15, NULL),
('M017', 'Moto touring 1200cc color gris perla', 'BMW K1600GT', 420000.00, 1, NULL),
('M018', 'Moto scooter 300cc color negro mate', 'Yamaha XMAX 300', 89000.00, 8, NULL),
('M019', 'Moto deportiva 600cc color amarillo', 'Suzuki GSX-R600', 245000.00, 5, NULL),
('M020', 'Moto adventure 1200cc color blanco', 'Honda Africa Twin', 295000.00, 4, NULL),
('M021', 'Moto naked 400cc color rojo', 'KTM Duke 390', 165000.00, 9, NULL),
('M022', 'Moto cruiser 750cc color azul oscuro', 'Honda Shadow 750', 195000.00, 6, NULL),
('M023', 'Moto urbana 125cc color blanco perla', 'Yamaha YBR 125', 35000.00, 20, NULL),
('M024', 'Moto deportiva 1000cc color negro', 'Aprilia RSV4', 380000.00, 2, NULL),
('M025', 'Moto enduro 450cc color naranja', 'KTM EXC 450', 198000.00, 7, NULL),
('M026', 'Moto scooter 150cc color rojo', 'Italika CS150', 28000.00, 25, NULL),
('M027', 'Moto touring 800cc color gris', 'Triumph Tiger 800', 265000.00, 3, NULL),
('M028', 'Moto naked 200cc color negro mate', 'Bajaj NS200', 52000.00, 12, NULL),
('M029', 'Moto deportiva 750cc color azul y blanco', 'Suzuki GSX-R750', 285000.00, 4, NULL),
('M030', 'Moto adventure 650cc color verde', 'Kawasaki Versys 650', 215000.00, 8, NULL),
('M031', 'Moto urbana 110cc color rojo', 'Honda Wave 110', 25000.00, 30, NULL),
('M032', 'Moto custom 1200cc color negro y plata', 'Harley Street Glide', 520000.00, 1, NULL),
('M033', 'Moto naked 300cc color blanco', 'Yamaha MT-03', 125000.00, 10, NULL),
('M034', 'Moto enduro 350cc color azul', 'Husqvarna FE 350', 175000.00, 6, NULL),
('M035', 'Moto scooter 200cc color negro', 'Honda Forza 300', 95000.00, 7, NULL),
('M036', 'Moto deportiva 850cc color rojo', 'Ducati SuperSport 950', 345000.00, 3, NULL),
('M037', 'Moto adventure 500cc color gris', 'Honda CB500X', 145000.00, 11, NULL),
('M038', 'Moto naked 125cc color amarillo', 'KTM Duke 125', 85000.00, 15, NULL),
('M039', 'Moto touring 1000cc color negro', 'Kawasaki Ninja 1000SX', 315000.00, 2, NULL),
('M040', 'Moto urbana 150cc color blanco', 'Suzuki GN125', 32000.00, 18, NULL),
('M041', 'Moto custom 500cc color azul', 'Royal Enfield Classic 500', 125000.00, 9, NULL),
('M042', 'Moto deportiva 400cc color verde', 'Kawasaki Ninja 400', 155000.00, 8, NULL),
('M043', 'Moto enduro 250cc color rojo', 'Yamaha WR250R', 115000.00, 12, NULL),
('M044', 'Moto scooter 125cc color gris', 'Suzuki Address 125', 42000.00, 14, NULL),
('M045', 'Moto naked 500cc color negro', 'Honda CB500F', 135000.00, 6, NULL),
('M046', 'Moto adventure 300cc color naranja', 'KTM Adventure 390', 185000.00, 5, NULL),
('M047', 'Moto touring 600cc color plateado', 'Suzuki V-Strom 650', 225000.00, 4, NULL),
('M048', 'Moto urbana 200cc color rojo', 'Bajaj Rouser 200', 48000.00, 16, NULL),
('M049', 'Moto deportiva 650cc color blanco y azul', 'Yamaha R6', 275000.00, 3, NULL),
('M050', 'Moto custom 750cc color negro mate', 'Indian Scout Bobber', 395000.00, 2, NULL),
('M051', 'Moto naked 250cc color verde lima', 'Kawasaki Z250', 95000.00, 10, NULL),
('M052', 'Moto enduro 500cc color blanco', 'Husqvarna 501', 205000.00, 5, NULL),
('M053', 'Moto scooter 250cc color azul', 'Kymco Downtown 300', 78000.00, 9, NULL),
('M054', 'Moto adventure 750cc color gris oscuro', 'Yamaha Tenere 700', 235000.00, 6, NULL),
('M055', 'Moto urbana 180cc color negro', 'Hero Xtreme 180', 38000.00, 22, NULL),
('M056', 'Moto deportiva 900cc color rojo y negro', 'Triumph Daytona 675', 298000.00, 3, NULL),
('M057', 'Moto naked 750cc color plateado', 'Honda CB750', 165000.00, 7, NULL),
('M058', 'Moto touring 1100cc color azul marino', 'BMW R1250RT', 445000.00, 1, NULL),
('M059', 'Moto enduro 200cc color amarillo', 'Suzuki DR200', 65000.00, 13, NULL),
('M060', 'Moto scooter 400cc color blanco perla', 'BMW C400X', 165000.00, 4, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `nombre_rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre_rol`) VALUES
(1, 'Administrador'),
(2, 'Vendedor'),
(3, 'Administrador de productos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `genero` varchar(10) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `correo`, `nombre`, `apellido_paterno`, `apellido_materno`, `fecha_nacimiento`, `genero`, `contrasena`, `fecha_registro`, `id_rol`) VALUES
(1, 'jareddd@gmail.com', 'jaredoo', 'garciaaa', 'garciaaa', '2025-05-10', 'Hombre', 'jaredddd', '2025-05-17 03:50:39', 3),
(2, 'zuriel@gmail.com', 'zuriel', 'Bautista', 'Ramirez', '2004-04-02', 'Hombre', 'Zurielll', '2025-05-17 04:22:29', 2),
(7, 'MariaMagdalena@gmail.com', 'Maria Magdalena', 'Lopez', 'Bautista', '2001-05-22', 'Mujer', 'MariaMagdalena', '2025-05-17 06:15:39', 2),
(13, '2004carlossantiagoduarte@gmail.com', 'Carlos', 'Santiago', 'Duarte', '1999-05-09', 'Hombre', 'Duarteee', '2025-05-19 15:40:05', 3),
(19, 'vargasvicenteivoneemontserrat@gmail.com', 'ivonee ', 'vargas', 'vicente', '2025-05-07', 'Mujer', '12345678a', '2025-05-23 15:27:22', 2),
(36, 'zurielbautistaramirez@gmail.com', 'Zuriel', 'Bautista', 'Ramirez', '2004-04-02', 'Hombre', 'Zuriel123', '2025-06-03 05:03:29', 2),
(37, 'jaredgarciagarcia0404@gmail.com', 'Luis Jared', 'Garcia', 'Garcia', '2004-06-02', 'Hombre', 'Hola4220', '2025-06-03 06:28:15', 2),
(38, 'adn.nto@gmail.com', 'Adelina', 'Martinez', 'Nieto', '2025-06-06', 'Mujer', 'Ade123456', '2025-06-06 15:22:09', 2),
(46, 'jaredelchidochidoxd@gmail.com', 'Obito', 'Tobi', 'Uchiha', '2004-06-04', 'Hombre', 'Hola12345', '2025-06-09 05:32:20', 3);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `usuarios_seguravista`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `usuarios_seguravista` (
`id` int(11)
,`correo` varchar(100)
,`nombre` varchar(50)
,`apellido_paterno` varchar(50)
,`apellido_materno` varchar(50)
,`fecha_nacimiento` date
,`genero` varchar(10)
,`contrasena` varchar(4)
,`fecha_registro` timestamp
,`id_rol` int(11)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `nombre_cliente` varchar(100) DEFAULT NULL,
  `producto` varchar(100) DEFAULT NULL,
  `num_serie` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `curp_cliente` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `nombre_cliente`, `producto`, `num_serie`, `precio`, `fecha`, `curp_cliente`) VALUES
(9, 'Adelina', 'Harley-Davidson Sportster - M006', 'HD001', 450000.00, '2024-01-15 06:00:00', 'ADMT7976'),
(10, 'Martha', 'KTM Duke 125 - M038', 'KTM002', 85000.00, '2024-01-16 06:00:00', 'CASM911008MDFERT12'),
(11, 'Carlos', 'Kawasaki Ninja 400 - M042', 'KAW003', 155000.00, '2024-01-17 06:00:00', 'DELC860821HDFBNM15'),
(12, 'Irma', 'Royal Enfield Classic 500 - M041', 'RE004', 125000.00, '2024-01-18 06:00:00', 'FLOI930317MDFUIO14'),
(13, 'Jorge Luis', 'Honda Shadow 750 - M022', 'HON005', 195000.00, '2024-01-19 06:00:00', 'GARJ870930HDFKLM05'),
(14, 'Juan Carlos', 'Yamaha MT-07 - M015', 'YAM006', 185000.00, '2024-01-20 06:00:00', 'GOMJ850312HDFNZR01'),
(15, 'Rosa Maria', 'Yamaha YBR 125 - M023', 'YAM007', 35000.00, '2024-01-21 06:00:00', 'HERR910815MDFGHJ04'),
(16, 'Karla Patricia', 'Honda CRF250L - M016', 'HON008', 98000.00, '2024-01-22 06:00:00', 'LOPK920705MDFRTG02'),
(17, 'Lucia', 'Bajaj NS200 - M028', 'BAJ009', 52000.00, '2024-01-23 06:00:00', 'MEDL840603MDFZXC08'),
(18, 'Rocio', 'Yamaha MT-03 - M033', 'YAM010', 125000.00, '2024-01-24 06:00:00', 'MORR890726MDFASD10'),
(19, 'David', 'Honda CB500X - M037', 'HON011', 145000.00, '2024-01-25 06:00:00', 'PAZD950202HDFZXY11'),
(20, 'Pedro', 'Suzuki GN125 - M040', 'SUZ012', 32000.00, '2024-01-26 06:00:00', 'RIVP870522HDFGHY13'),
(21, 'Fernando', 'Triumph Tiger 800 - M027', 'TRI013', 265000.00, '2024-01-27 06:00:00', 'RUMF891127HDFCVB07'),
(22, 'Miguel Angel', 'KTM Duke 390 - M021', 'KTM014', 165000.00, '2024-01-28 06:00:00', 'SANM880220HDFRTY03'),
(23, 'Veronica', 'Italika CS150 - M026', 'ITA015', 28000.00, '2024-01-29 06:00:00', 'TORV930418MDFNBV06'),
(24, 'Javier', 'Honda Wave 110 - M031', 'HON016', 25000.00, '2024-01-30 06:00:00', 'VASJ920114HDFQWE09'),
(25, 'Luis Jared', 'Bajaj pulsar ns160 - M005', '67909JK', 45000.00, '2025-06-09 05:40:34', 'GATL98987');

-- --------------------------------------------------------

--
-- Estructura para la vista `usuarios_seguravista`
--
DROP TABLE IF EXISTS `usuarios_seguravista`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `usuarios_seguravista`  AS SELECT `usuarios`.`id` AS `id`, `usuarios`.`correo` AS `correo`, `usuarios`.`nombre` AS `nombre`, `usuarios`.`apellido_paterno` AS `apellido_paterno`, `usuarios`.`apellido_materno` AS `apellido_materno`, `usuarios`.`fecha_nacimiento` AS `fecha_nacimiento`, `usuarios`.`genero` AS `genero`, '****' AS `contrasena`, `usuarios`.`fecha_registro` AS `fecha_registro`, `usuarios`.`id_rol` AS `id_rol` FROM `usuarios` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`curp`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`),
  ADD KEY `fk_rol` (`id_rol`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
