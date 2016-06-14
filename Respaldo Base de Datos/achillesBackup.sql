# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.19)
# Database: achilles
# Generation Time: 2014-06-26 19:53:27 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ARTICLES
# ------------------------------------------------------------

LOCK TABLES `ARTICLES` WRITE;
/*!40000 ALTER TABLE `ARTICLES` DISABLE KEYS */;

INSERT INTO `ARTICLES` (`ID`, `ACTIVE`, `DESCRIPTION`, `NAME`, `PRICE`, `STOCK`, `UNIT`)
VALUES
	(1,1,'Toshiba','Notebook',500,99,'USD'),
	(2,1,'Logitech','Mouse',20,248,'UYU'),
	(3,1,'Dell','Monitor',300,98,'USD'),
	(4,1,'Genius','Teclado',50,198,'UYU'),
	(5,1,'Bose','Parlantes',60,150,'USD'),
	(6,1,'Intel','Procesador',110,300,'USD'),
	(7,1,'Panasonic','Televisor',400,333,'USD'),
	(8,1,'Sony','Playstation',500,90,'USD'),
	(9,1,'CaseLogic','Carcaza',160,77,'UYU'),
	(10,1,'Atom','Servidor',800,70,'USD');

/*!40000 ALTER TABLE `ARTICLES` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ARTICLES_SHIPPING_OPTION
# ------------------------------------------------------------

LOCK TABLES `ARTICLES_SHIPPING_OPTION` WRITE;
/*!40000 ALTER TABLE `ARTICLES_SHIPPING_OPTION` DISABLE KEYS */;

INSERT INTO `ARTICLES_SHIPPING_OPTION` (`Article_ID`, `shippingOptions_ID`)
VALUES
	(1,1),
	(2,1),
	(3,1),
	(4,1),
	(5,1),
	(6,1),
	(7,1),
	(1,2),
	(2,2),
	(3,2),
	(4,2),
	(5,2),
	(6,2),
	(7,2),
	(1,3),
	(2,3),
	(3,3),
	(4,3),
	(5,3),
	(6,3),
	(1,4),
	(2,4),
	(3,4),
	(4,4),
	(5,4),
	(6,4),
	(1,5),
	(2,5),
	(3,5),
	(4,5),
	(5,5),
	(6,5),
	(1,6),
	(2,6),
	(3,6),
	(4,6);

/*!40000 ALTER TABLE `ARTICLES_SHIPPING_OPTION` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table HISTORICAL
# ------------------------------------------------------------

LOCK TABLES `HISTORICAL` WRITE;
/*!40000 ALTER TABLE `HISTORICAL` DISABLE KEYS */;

INSERT INTO `HISTORICAL` (`ID`, `DATE_TIME`, `ENTERPRISE`, `NOTE`, `PLACE`, `USER_NAME`, `PURCHASE_ID`, `STATUS_ID`)
VALUES
	(1,'2014-06-26','Chronos','UnaNota','Montevideo','Agustin',1,2),
	(2,'2014-06-27','Chronos','OtraNota','Pando','Maria',2,3),
	(3,'2014-06-28','Hermes','MuyBien','Rivera','Camila',3,4);

/*!40000 ALTER TABLE `HISTORICAL` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table PURCHASE
# ------------------------------------------------------------

LOCK TABLES `PURCHASE` WRITE;
/*!40000 ALTER TABLE `PURCHASE` DISABLE KEYS */;

INSERT INTO `PURCHASE` (`ID`, `PURCHASE_DATE`, `ESTIMATED_TIME_LEFT`, `PURCHASE_STATE`, `CLIENT_ID`, `ARTICLE_ID`, `SHIPPING_OPTION_ID`)
VALUES
	(1,'2014-06-26','2014-07-02',NULL,1,2,2),
	(2,'2014-06-26','2014-07-01',NULL,1,3,3),
	(3,'2014-06-26','2014-07-01',NULL,1,4,3),
	(4,'2014-06-26','2014-07-01',NULL,2,1,3),
	(5,'2014-06-26','2014-07-01',NULL,2,2,3),
	(6,'2014-06-26','2014-07-01',NULL,2,3,3),
	(7,'2014-06-26','2014-07-01',NULL,2,4,3);

/*!40000 ALTER TABLE `PURCHASE` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table SEQUENCE
# ------------------------------------------------------------

LOCK TABLES `SEQUENCE` WRITE;
/*!40000 ALTER TABLE `SEQUENCE` DISABLE KEYS */;

INSERT INTO `SEQUENCE` (`SEQ_NAME`, `SEQ_COUNT`)
VALUES
	('SEQ_GEN',50);

/*!40000 ALTER TABLE `SEQUENCE` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table SHIPPING_OPTION
# ------------------------------------------------------------

LOCK TABLES `SHIPPING_OPTION` WRITE;
/*!40000 ALTER TABLE `SHIPPING_OPTION` DISABLE KEYS */;

INSERT INTO `SHIPPING_OPTION` (`ID`, `MAXIMUM_TIME`, `MNIMUM_TIME`, `PERCENTAGE`, `PRICE`)
VALUES
	(1,7,5,4,10),
	(2,6,3,7,15),
	(3,5,4,9,20),
	(4,4,3,9,25),
	(5,3,2,10,40),
	(6,2,1,15,45);

/*!40000 ALTER TABLE `SHIPPING_OPTION` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table SHIPPING_STATUS
# ------------------------------------------------------------

LOCK TABLES `SHIPPING_STATUS` WRITE;
/*!40000 ALTER TABLE `SHIPPING_STATUS` DISABLE KEYS */;

INSERT INTO `SHIPPING_STATUS` (`ID`, `AUTHORIZED_CARRIER`, `AUTHORIZED_CLIENT`, `NAME`, `NEXT_STATUS`)
VALUES
	(1,1,1,'Estado1',NULL),
	(2,1,1,'Estado2',NULL),
	(3,1,1,'Estado3',NULL),
	(4,1,1,'Estado4',NULL),
	(5,1,1,'Estado5',NULL);

/*!40000 ALTER TABLE `SHIPPING_STATUS` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table USERS
# ------------------------------------------------------------

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;

INSERT INTO `USERS` (`ID`, `ENTERPRISE`, `NAME`, `TYPE`)
VALUES
	(1,NULL,'Juan','Client'),
	(2,NULL,'Pedro','Client'),
	(3,'Hermes','Camila','Carrier'),
	(4,'Hermes','Ignacio','Carrier'),
	(5,'Chronos','Agustin','Carrier'),
	(6,'Chronos','Maria','Carrier');

/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
