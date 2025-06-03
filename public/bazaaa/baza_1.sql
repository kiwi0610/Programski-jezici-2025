-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for pj_projekat
CREATE DATABASE IF NOT EXISTS `pj_projekat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `pj_projekat`;

-- Dumping structure for table pj_projekat.paket
CREATE TABLE IF NOT EXISTS `paket` (
  `paket_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(32) NOT NULL,
  `cena` int(10) unsigned NOT NULL,
  PRIMARY KEY (`paket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table pj_projekat.paket: ~5 rows (approximately)
INSERT INTO `paket` (`paket_id`, `naziv`, `cena`) VALUES
	(1, 'Osnovni paket', 2500),
	(2, 'Pilates paket', 3000),
	(3, 'Bodybuilding paket', 4000),
	(4, 'Aerobik 2 meseca', 3500),
	(5, 'Krosfit full', 5000);

-- Dumping structure for table pj_projekat.paket_trener
CREATE TABLE IF NOT EXISTS `paket_trener` (
  `paket_trener_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `trener_id` int(10) unsigned NOT NULL,
  `paket_id` int(10) unsigned NOT NULL,
  `grupa` enum('da','ne') NOT NULL,
  `nova_cena` int(10) unsigned NOT NULL,
  PRIMARY KEY (`paket_trener_id`),
  KEY `trener_id_fk` (`trener_id`),
  KEY `paket_id_fk` (`paket_id`),
  CONSTRAINT `paket_id_fk` FOREIGN KEY (`paket_id`) REFERENCES `paket` (`paket_id`) ON UPDATE CASCADE,
  CONSTRAINT `trener_id_fk` FOREIGN KEY (`trener_id`) REFERENCES `trener` (`trener_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table pj_projekat.paket_trener: ~10 rows (approximately)
INSERT INTO `paket_trener` (`paket_trener_id`, `trener_id`, `paket_id`, `grupa`, `nova_cena`) VALUES
	(1, 1, 1, 'ne', 3500),
	(2, 1, 1, 'da', 2500),
	(3, 3, 2, 'ne', 4000),
	(4, 3, 2, 'da', 3000),
	(5, 2, 3, 'ne', 6000),
	(6, 2, 3, 'da', 4000),
	(7, 3, 4, 'ne', 4000),
	(8, 4, 4, 'da', 3500),
	(9, 5, 5, 'da', 5000),
	(10, 4, 5, 'ne', 6000);

-- Dumping structure for table pj_projekat.trener
CREATE TABLE IF NOT EXISTS `trener` (
  `trener_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime_prezime` varchar(64) NOT NULL,
  PRIMARY KEY (`trener_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table pj_projekat.trener: ~5 rows (approximately)
INSERT INTO `trener` (`trener_id`, `ime_prezime`) VALUES
	(1, 'Miloš Obradović'),
	(2, 'Milan Petrović'),
	(3, 'Andjela Popović'),
	(4, 'Milica Mihajlović'),
	(5, 'Mateja Stojković');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
