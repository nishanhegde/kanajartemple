-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.22-0ubuntu0.16.04.1 - (Ubuntu)
-- Server OS:                    Linux
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for Brahmalingeshwara
CREATE DATABASE IF NOT EXISTS `Brahmalingeshwara` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Brahmalingeshwara`;


-- Dumping structure for table Brahmalingeshwara.alldonationdata
CREATE TABLE IF NOT EXISTS `alldonationdata` (
  `RecNo` int(11) NOT NULL,
  `Name` varchar(2000) NOT NULL,
  `Address` varchar(10000) NOT NULL,
  `Amount` double NOT NULL,
  `mobile` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `BDate` datetime NOT NULL,
  `Did` int(11) NOT NULL,
  `bankentryid` int(11) DEFAULT NULL,
  PRIMARY KEY (`RecNo`,`Did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
