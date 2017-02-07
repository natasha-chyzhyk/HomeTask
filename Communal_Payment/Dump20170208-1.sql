-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: communals
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id_flat` int(11) NOT NULL,
  `id_supplyer` int(11) NOT NULL,
  PRIMARY KEY (`id_flat`,`id_supplyer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,9),(2,1),(2,2),(2,3),(2,4),(2,5),(2,8),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(4,1),(4,2),(4,3),(4,7),(5,1),(5,2),(5,3),(5,5),(5,6);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `id_building` int(11) NOT NULL,
  `id_credentials` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES (1,'GosBank',4,10),(2,'CountryBank',5,11),(3,'GCBank',6,12);
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_flat` int(11) NOT NULL,
  `id_service` int(11) NOT NULL,
  `created_at` date NOT NULL,
  `scaled_price_at_creation` float NOT NULL,
  `abonent_price_at_creation` float NOT NULL,
  `total_charge` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,1,1,'2016-01-01',0,120.25,120.25),(2,1,3,'2016-01-01',40,50,90),(3,1,4,'2016-01-01',90,0,90),(4,1,5,'2016-01-01',50,55,105),(5,1,6,'2016-01-01',110,0,110),(6,2,1,'2016-01-01',0,120.25,120.25),(7,2,3,'2016-01-01',40,50,90),(8,2,4,'2016-01-01',90,0,90),(9,2,5,'2016-01-01',50,55,105),(10,2,6,'2016-01-01',110,0,110),(11,2,7,'2016-01-01',240,0,240),(12,2,10,'2016-01-01',0,80,80),(13,3,1,'2016-01-01',0,120.25,120.25),(14,3,3,'2016-01-01',40,50,90),(15,3,4,'2016-01-01',90,0,90),(16,3,5,'2016-01-01',50,55,105),(17,3,6,'2016-01-01',110,0,110),(18,3,7,'2016-01-01',240,0,240),(19,3,8,'2016-01-01',50,0,50),(20,3,9,'2016-01-01',0,110,110),(21,3,10,'2016-01-01',0,80,80),(22,4,2,'2016-01-01',0,100,100),(23,4,3,'2016-01-01',40,50,90),(24,4,4,'2016-01-01',90,0,90),(25,4,9,'2016-01-01',0,55,55),(26,5,1,'2016-01-01',0,120.25,120.25),(27,5,3,'2016-01-01',40,50,90),(28,5,4,'2016-01-01',90,0,90),(29,5,6,'2016-01-01',110,0,110),(30,5,7,'2016-01-01',120,0,120),(31,5,8,'2016-01-01',50,0,50);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buildingaddress`
--

DROP TABLE IF EXISTS `buildingaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buildingaddress` (
  `id` int(11) NOT NULL,
  `city` varchar(45) NOT NULL,
  `street` varchar(128) NOT NULL,
  `building_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buildingaddress`
--

LOCK TABLES `buildingaddress` WRITE;
/*!40000 ALTER TABLE `buildingaddress` DISABLE KEYS */;
INSERT INTO `buildingaddress` VALUES (1,'Kharkiv','Ivanova',7),(2,'Kharkiv','May',21),(3,'Kharkiv','Sumska',30),(4,'Kiev','Svoboda',12),(5,'Kiev','Boga',15),(6,'Kharkiv','Len',25);
/*!40000 ALTER TABLE `buildingaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credentials`
--

DROP TABLE IF EXISTS `credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credentials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credentials`
--

LOCK TABLES `credentials` WRITE;
/*!40000 ALTER TABLE `credentials` DISABLE KEYS */;
INSERT INTO `credentials` VALUES (1,'IvanP','IvanPet7'),(2,'PetM','PM0508'),(3,'Dus20','PK7809'),(4,'Fhn21','PO4502'),(5,'FD54','KJ4526'),(6,'VB202','PJ52146'),(7,'GHJ89630','PL534896'),(8,'HJ4152','565kj'),(9,'53456u','hbm87'),(10,'5dvdv','sdvx45'),(11,'sdfc52','dcx41'),(12,'sdc12','dscxz1'),(13,'hbnm1','kjnml23'),(14,'hjbn120','54bhj'),(15,'12mn','15mkhg'),(16,'hjb11','xgchj0'),(17,'gh1254','54chvj');
/*!40000 ALTER TABLE `credentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flat`
--

DROP TABLE IF EXISTS `flat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flat_number` int(11) NOT NULL,
  `square` float NOT NULL,
  `id_owner` int(11) NOT NULL,
  `id_building` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flat`
--

LOCK TABLES `flat` WRITE;
/*!40000 ALTER TABLE `flat` DISABLE KEYS */;
INSERT INTO `flat` VALUES (1,15,55,1,1),(2,18,33,3,2),(3,20,30,5,2),(4,25,35,7,3),(5,35,45,9,3);
/*!40000 ALTER TABLE `flat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flat_service`
--

DROP TABLE IF EXISTS `flat_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flat_service` (
  `id_flat` int(11) NOT NULL,
  `id_service` int(11) NOT NULL,
  PRIMARY KEY (`id_flat`,`id_service`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flat_service`
--

LOCK TABLES `flat_service` WRITE;
/*!40000 ALTER TABLE `flat_service` DISABLE KEYS */;
INSERT INTO `flat_service` VALUES (1,1),(1,3),(1,4),(1,5),(1,6),(2,1),(2,3),(2,4),(2,5),(2,6),(2,7),(2,10),(3,1),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9),(3,10),(4,2),(4,3),(4,4),(4,9),(5,1),(5,3),(5,4),(5,6),(5,7),(5,8);
/*!40000 ALTER TABLE `flat_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flatowner`
--

DROP TABLE IF EXISTS `flatowner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flatowner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `id_flat` int(11) DEFAULT NULL,
  `id_own_flat` int(11) DEFAULT NULL,
  `id_credentials` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flatowner`
--

LOCK TABLES `flatowner` WRITE;
/*!40000 ALTER TABLE `flatowner` DISABLE KEYS */;
INSERT INTO `flatowner` VALUES (1,'Ivan','Ivanov','Petrovich',1,1,13),(2,'Eva','Loy','Anatolievich',2,3,14),(3,'Elena','Lakya','Ivanovna',3,5,15),(4,'Yana','Sklyap','Alexandrovich',4,7,16),(5,'Yaroslav','Roman','Petrovich',5,9,17);
/*!40000 ALTER TABLE `flatowner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `human`
--

DROP TABLE IF EXISTS `human`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `human` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `id_flat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `human`
--

LOCK TABLES `human` WRITE;
/*!40000 ALTER TABLE `human` DISABLE KEYS */;
INSERT INTO `human` VALUES (1,'Ivan','Ivanov','Petrovich',1),(2,'Petya','Markov','Vladimirovich',1),(3,'Eva','Loy','Anatolievich',2),(4,'Maria','Gura','Petrovna',2),(5,'Elena','Lakya','Ivanovna',3),(6,'Mark','Sidorov','Vladimirovich',3),(7,'Yana','Sklyap','Alexandrovich',4),(8,'Matvey','Perzenko','Yaroslavich',4),(9,'Yaroslav','Roman','Petrovich',5),(10,'Artur','Sedrak','Ivanov',5);
/*!40000 ALTER TABLE `human` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymnet`
--

DROP TABLE IF EXISTS `paymnet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymnet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_flat` int(11) NOT NULL,
  `id_supplyer` int(11) NOT NULL,
  `date` date NOT NULL,
  `summa` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymnet`
--

LOCK TABLES `paymnet` WRITE;
/*!40000 ALTER TABLE `paymnet` DISABLE KEYS */;
INSERT INTO `paymnet` VALUES (1,1,1,'2016-01-05',100),(2,1,2,'2016-01-05',20),(3,1,3,'2016-01-05',50),(4,1,4,'2016-01-05',60),(5,1,5,'2016-01-05',80),(6,1,9,'2016-01-05',120),(7,2,1,'2016-01-10',130),(8,2,2,'2016-01-10',150),(9,2,3,'2016-01-10',40),(10,2,4,'2016-01-10',30),(11,2,5,'2016-01-10',120),(12,2,8,'2016-01-10',110),(13,3,1,'2016-01-30',100),(14,3,2,'2016-01-30',95),(15,3,3,'2016-01-30',90),(16,3,4,'2016-01-30',80),(17,3,5,'2016-01-30',75),(18,3,6,'2016-01-30',63),(19,3,7,'2016-01-30',150),(20,3,8,'2016-01-30',160),(21,4,1,'2016-01-28',170),(22,4,2,'2016-01-28',20),(23,4,3,'2016-01-28',25),(24,4,7,'2016-01-28',60),(25,5,1,'2016-01-15',90),(26,5,2,'2016-01-15',95),(27,5,3,'2016-01-15',84),(28,5,5,'2016-01-15',64),(29,5,6,'2016-01-15',120);
/*!40000 ALTER TABLE `paymnet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_supplier` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `sub_type` varchar(45) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `scaled_price` float NOT NULL,
  `abonent_price` float NOT NULL,
  `calculation_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,3,'INTERNET','InternetUnlimited','INTERNET',0,120.25,'LICENSE_FEE'),(2,3,'INTERNET','InternetLim100','INTERNET100',0,100,'LICENSE_FEE'),(3,1,'ElectricPower','ElectricPower','ElectricPower',20,50,'COMBINATION'),(4,2,'OblWaterCold','OblWaterCold','OblWaterCold',45,0,'CALCULATION'),(5,4,'OblGas','OblGas','OblGas',25,55,'COMBINATION'),(6,5,'OblHeating','WaterHot','WaterHot',55,0,'CALCULATION'),(7,5,'Heating','Heating','Heating',120,0,'CALCULATION'),(8,6,'ExportGarbage','ExportGarbage','ExportGarbage',25,0,'CALCULATION'),(9,7,'Rent','Rent','Rent',0,55,'LICENSE_FEE'),(10,8,'CountryInternet','CountryInternet','CountryInternet',0,80,'LICENSE_FEE'),(11,9,'IpInternet','IpInternet','IpInternet',0,95.5,'LICENSE_FEE');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplyer`
--

DROP TABLE IF EXISTS `supplyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplyer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `id_building` int(11) NOT NULL,
  `id_credentials` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplyer`
--

LOCK TABLES `supplyer` WRITE;
/*!40000 ALTER TABLE `supplyer` DISABLE KEYS */;
INSERT INTO `supplyer` VALUES (1,'OblEnergo',1,1),(2,'OblWaterCold',1,2),(3,'OblInternet',1,3),(4,'OblGas',2,4),(5,'OblHeating',2,5),(6,'ExportGarbage',2,6),(7,'Rent',3,7),(8,'CountryInternet',3,8),(9,'IpInternet',3,9);
/*!40000 ALTER TABLE `supplyer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-08  0:53:35
