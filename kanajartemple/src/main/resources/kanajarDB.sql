-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-0ubuntu0.16.04.1 - (Ubuntu)
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


-- Dumping structure for table Brahmalingeshwara.admincms
CREATE TABLE IF NOT EXISTS `admincms` (
  `Pid` int(11) NOT NULL,
  `PageName` varchar(100) NOT NULL,
  `Content` longtext NOT NULL,
  `language` varchar(2) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`Pid`,`language`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


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
  PRIMARY KEY (`RecNo`,`Did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.allexpendituredata
CREATE TABLE IF NOT EXISTS `allexpendituredata` (
  `RecNo` int(11) NOT NULL,
  `Eid` int(11) NOT NULL,
  `Title` varchar(2000) NOT NULL,
  `Description` varchar(10000) NOT NULL,
  `Amount` double NOT NULL,
  `EDate` date NOT NULL,
  `BDate` datetime NOT NULL,
  PRIMARY KEY (`RecNo`,`Eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.allincomedata
CREATE TABLE IF NOT EXISTS `allincomedata` (
  `RecNo` int(11) NOT NULL,
  `Iid` int(11) NOT NULL,
  `title` varchar(2000) NOT NULL,
  `Amount` double NOT NULL,
  `Edate` date NOT NULL,
  `Bdate` datetime NOT NULL,
  PRIMARY KEY (`RecNo`,`Iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.allpoojedata
CREATE TABLE IF NOT EXISTS `allpoojedata` (
  `RecNo` int(11) NOT NULL,
  `Quantity` int(2) NOT NULL,
  `Name` varchar(2000) NOT NULL,
  `Pid` int(11) NOT NULL,
  `PDate` date NOT NULL,
  `BDate` datetime NOT NULL,
  PRIMARY KEY (`RecNo`,`Pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.bankaccount
CREATE TABLE IF NOT EXISTS `bankaccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bankname` varchar(50) NOT NULL DEFAULT '0',
  `accountno` varchar(50) NOT NULL DEFAULT '0',
  `ifsccode` varchar(50) NOT NULL DEFAULT '0',
  `address` varchar(1000) NOT NULL DEFAULT '0',
  `status` varchar(10) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.bankaccountentry
CREATE TABLE IF NOT EXISTS `bankaccountentry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bankaccount_id` int(11) DEFAULT '0',
  `bankaccountentry_id` int(11) DEFAULT '0',
  `amount` double DEFAULT '0',
  `type` varchar(50) DEFAULT '0',
  `description` varchar(2000) DEFAULT NULL,
  `transaction` varchar(50) DEFAULT '0',
  `transaction_date` date NOT NULL,
  `chequeorrefno` varchar(50) NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `bankaccountentry_id` (`bankaccountentry_id`),
  KEY `bankaccount_id` (`bankaccount_id`),
  CONSTRAINT `FK_bankaccountentry_bankaccount` FOREIGN KEY (`bankaccount_id`) REFERENCES `bankaccount` (`id`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.donation
CREATE TABLE IF NOT EXISTS `donation` (
  `Did` int(11) NOT NULL AUTO_INCREMENT,
  `DonationName` varchar(2000) NOT NULL,
  `Status` varchar(10) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`Did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.expenditure
CREATE TABLE IF NOT EXISTS `expenditure` (
  `Eid` int(11) NOT NULL AUTO_INCREMENT,
  `ExpenditureName` varchar(2000) NOT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`Eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.income
CREATE TABLE IF NOT EXISTS `income` (
  `Iid` int(11) NOT NULL AUTO_INCREMENT,
  `IncomeName` varchar(2000) NOT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`Iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.pooje
CREATE TABLE IF NOT EXISTS `pooje` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `PoojeName` varchar(2000) NOT NULL,
  `Amount` double NOT NULL,
  `Status` varchar(10) CHARACTER SET latin1 NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.register
CREATE TABLE IF NOT EXISTS `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FullName` varchar(2000) NOT NULL,
  `Password` varchar(2000) CHARACTER SET latin1 NOT NULL,
  `EmailId` varchar(200) CHARACTER SET latin1 NOT NULL,
  `PhoneNumber` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `role` varchar(50) CHARACTER SET latin1 NOT NULL DEFAULT 'ROLE_ADMIN',
  `Status` varchar(50) CHARACTER SET latin1 NOT NULL DEFAULT 'Inactive',
  PRIMARY KEY (`id`,`EmailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.sashwathapooje
CREATE TABLE IF NOT EXISTS `sashwathapooje` (
  `RecNo` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(2000) NOT NULL,
  `Address` varchar(10000) NOT NULL,
  `PDate` varchar(10) CHARACTER SET latin1 NOT NULL,
  `BDate` datetime NOT NULL,
  `MobileNo` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `Email` varchar(40) CHARACTER SET latin1 DEFAULT NULL,
  `Pid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`RecNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.sevabooking
CREATE TABLE IF NOT EXISTS `sevabooking` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(2000) DEFAULT NULL,
  `MobileNo` bigint(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Address` longtext,
  `Seva` varchar(50) DEFAULT NULL,
  `PoojeDate` date DEFAULT NULL,
  `Occation` varchar(50) DEFAULT NULL,
  `PaymentDate` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table Brahmalingeshwara.usersashwathapooje
CREATE TABLE IF NOT EXISTS `usersashwathapooje` (
  `RecNo` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(2000) NOT NULL,
  `Address` varchar(10000) NOT NULL,
  `PDate` varchar(10) CHARACTER SET latin1 NOT NULL,
  `BDate` datetime NOT NULL,
  `MobileNo` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `Email` varchar(40) CHARACTER SET latin1 DEFAULT NULL,
  `Pid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
