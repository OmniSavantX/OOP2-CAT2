-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 11, 2020 at 03:31 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javafxrmi`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `id` varchar(18) NOT NULL,
  `make` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`id`, `make`, `model`, `year`) VALUES
('1B3ES56C55D137449', 'Dodge', 'Neon', 2005),
('1B3HB48B67D562726', 'Dodge', 'Caliber', 2007),
('1B4HS28N9YF105991', 'Dodge', 'Durango', 2000),
('1FTEF17W4VNC92444', 'Ford', 'F 150', 1997),
('1G1ZD5E09CF251160', 'Chevrolet', 'Malibu', 2012),
('1J4RR5GT2BC512008', 'Jeep', 'Grand Cherokee', 2011),
('1N4AB41D7VC757660', 'Nissan', 'Sentra', 1997),
('1XPWDBTX48D766660', ' Peterbilt', '388', 2006),
('1ZVBP8AM0D5265429', 'Ford', 'Mustang', 2013),
('2CNBJ13C3Y6924710', 'Chevrolet', 'Tracker', 2000),
('2FDKF38G3KCA42390', 'Ford', 'F 350', 1990),
('2G1WL52M2T1187676', 'Chevrolet', 'Lumina', 1996),
('2T1BR18E5WC056406', 'Toyota', 'Corolla', 1998),
('3B7HC13Z7TG112627', 'Dodge', 'Ram Pickup 1500', 1996),
('3D7KU28C04G254161', 'Dodge', 'Ram Pickup 2500', 2004),
('3N1BC11E79L484011', 'Nissan', 'Versa', 2009),
('4JGBB8GB4BA662410', 'Mercedes Benz', 'ML', 2011),
('4S3BK4355T6319316', 'Subaru', 'Legacy', 1996),
('5N1AL0MM4DC301508', 'Infiniti', 'JX35', 2013),
('JF1GH6B60BG810286', 'Subaru', 'Impreza', 2011),
('JF1GR7E64DG203230', 'Subaru', 'Impreza', 2013),
('JH4DA3340KS005705', 'Acura', 'Integra', 1989),
('JH4DA9470NS002903', 'Acura', 'Integra', 1992),
('JH4DB1570PS000858', 'Acura', 'Integra', 1993),
('JH4DB7540RS001911', 'Acura', 'Integra', 1994),
('JH4DB7640SS009074', 'Acura', 'Integra', 1995),
('JH4KA3260LC000123', 'Acura', 'Legend', 1990),
('JTHBB1BA2A2013500', 'Lexus', 'Various', 2010),
('JYAVP24E39A007465', 'Yamaha', 'Xvs 1300', 2009),
('KM8JU3AC6DU588418', 'Hyundai', 'Tuscon', 2013),
('KMHDU4ADXAU832403', 'Hyundai', 'Elantra', 2010),
('SAJWA1C78D8V38055', 'Jaguar', 'XJ', 2013),
('SCBBR53W36C034889', 'Bentley', 'Continental Flying Spur', 2006),
('WAULFAFR3DA006959', 'Audi', 'A5', 2013),
('WBANF73576CG65408', 'BMW', '5 Series', 2006),
('WDBRF52H76F783280', 'Mercedes Benz', 'C Class', 2006),
('WMWRC33474TC49530', 'Mini', 'Cooper', 2004),
('WVWSB61J71W607153', 'Volkswagen', 'Jetta', 2001),
('YS3ED48E5Y3070016', 'Saab', ' 95', 2000),
('YV1672MK9D2304784', 'Volvo', 'C30', 2013),
('ZC2FP1107KB204113', 'Crysler', 'TC', 1989);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
