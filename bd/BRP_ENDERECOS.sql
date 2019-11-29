-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_registra_pessoas
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brp_enderecos`
--

DROP TABLE IF EXISTS `brp_enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brp_enderecos` (
  `end_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `end_cep` int(11) NOT NULL,
  `end_logradouro` varchar(45) NOT NULL,
  `end_numero` int(11) NOT NULL,
  `end_bairro` varchar(45) NOT NULL,
  `end_cidade` varchar(45) NOT NULL,
  `end_estado` varchar(45) NOT NULL,
  `end_pais` varchar(45) NOT NULL,
  `end_pes_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`end_codigo`),
  KEY `fk_end_pes_codigo_idx` (`end_pes_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brp_enderecos`
--

LOCK TABLES `brp_enderecos` WRITE;
/*!40000 ALTER TABLE `brp_enderecos` DISABLE KEYS */;
INSERT INTO `brp_enderecos` VALUES (9,58030218,'ARGEMIRO',1711,'BESSA','JOÃO PESSOA','PB','BRASIL',9),(10,60258159,'RUA AMOR',154,'PAIXAO','JP','PB','BR',0),(11,5343464,'64',64,'646','464','646','46',0);
/*!40000 ALTER TABLE `brp_enderecos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-28 22:59:39
