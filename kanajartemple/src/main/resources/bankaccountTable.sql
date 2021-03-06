-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.23-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for brahmalingeshwara
CREATE DATABASE IF NOT EXISTS `brahmalingeshwara` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `brahmalingeshwara`;

-- Dumping structure for table brahmalingeshwara.bankaccount
CREATE TABLE IF NOT EXISTS `bankaccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bankname` varchar(50) NOT NULL DEFAULT '0',
  `accountno` varchar(50) NOT NULL DEFAULT '0',
  `ifsccode` varchar(50) NOT NULL DEFAULT '0',
  `address` varchar(1000) NOT NULL DEFAULT '0',
  `openingbalance` double NOT NULL DEFAULT '0',
  `status` varchar(10) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table brahmalingeshwara.bankaccount: ~2 rows (approximately)
/*!40000 ALTER TABLE `bankaccount` DISABLE KEYS */;
INSERT INTO `bankaccount` (`id`, `bankname`, `accountno`, `ifsccode`, `address`, `openingbalance`, `status`) VALUES
	(1, 'wqedqewqewq', '12324554565', 'fretr2343er', 'Dugganbail house kanajar', 100, 'Active'),
	(2, 'ewwewqerwq', '123287454554565', '34rfre34543', 'Dugganbail house kanajar', 3000, 'Active');
/*!40000 ALTER TABLE `bankaccount` ENABLE KEYS */;

-- Dumping structure for table brahmalingeshwara.bankaccountentry
CREATE TABLE IF NOT EXISTS `bankaccountentry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bankaccount_id` int(11) DEFAULT '0',
  `bankaccountentry_id` int(11) DEFAULT '0',
  `amount` double DEFAULT '0',
  `balance` double NOT NULL DEFAULT '0',
  `description` varchar(2000) DEFAULT NULL,
  `transaction` varchar(50) DEFAULT '0',
  `transaction_date` date NOT NULL,
  `chequeorrefno` varchar(50) NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `bankaccountentry_id` (`bankaccountentry_id`),
  KEY `bankaccount_id` (`bankaccount_id`),
  CONSTRAINT `FK_bankaccountentry_bankaccount` FOREIGN KEY (`bankaccount_id`) REFERENCES `bankaccount` (`id`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table brahmalingeshwara.bankaccountentry: ~3 rows (approximately)
/*!40000 ALTER TABLE `bankaccountentry` DISABLE KEYS */;
INSERT INTO `bankaccountentry` (`id`, `bankaccount_id`, `bankaccountentry_id`, `amount`, `balance`, `description`, `transaction`, `transaction_date`, `chequeorrefno`, `creation_date`) VALUES
	(2, 1, 1, 10, 110, 'kjokj', 'DEPOSIT', '2017-12-29', '', '2017-12-29 16:52:52'),
	(3, 1, 2, 20, 90, 'dsds', 'WITHDRAW', '2017-12-29', '', '2017-12-29 16:53:32'),
	(4, 1, 3, 1000, 1090, 'chedjdew', 'DEPOSIT', '2017-12-29', '2131443', '2017-12-29 16:54:09'),
	(5, 2, 1, 501, 2499, 'ewrwr', 'WITHDRAW', '2017-12-29', '', '2017-12-29 16:58:48');
/*!40000 ALTER TABLE `bankaccountentry` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
