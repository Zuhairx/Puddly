-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2022 at 09:44 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pt_pudding`
--

-- --------------------------------------------------------

--
-- Table structure for table `datamenupudding`
--

CREATE TABLE `datamenupudding` (
  `KodeMenu` varchar(10) NOT NULL,
  `NamaMenu` varchar(50) NOT NULL,
  `HargaMenu` int(11) NOT NULL,
  `StokMenu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datamenupudding`
--

INSERT INTO `datamenupudding` (`KodeMenu`, `NamaMenu`, `HargaMenu`, `StokMenu`) VALUES
('PD-936', 'Pudding Cokelat', 10000, 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datamenupudding`
--
ALTER TABLE `datamenupudding`
  ADD PRIMARY KEY (`KodeMenu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
