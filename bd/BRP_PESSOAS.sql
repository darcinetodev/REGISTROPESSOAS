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
-- Table structure for table `brp_pessoas`
--

DROP TABLE IF EXISTS `brp_pessoas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brp_pessoas` (
  `pes_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `pes_cpf` varchar(11) NOT NULL,
  `pes_nome` varchar(50) NOT NULL,
  `pes_senha` varchar(32) NOT NULL,
  `pes_data_nascimento` date NOT NULL,
  `brp_pes_end_codigo` int(11) DEFAULT NULL,
  `pes_email` varchar(50) NOT NULL,
  PRIMARY KEY (`pes_codigo`),
  UNIQUE KEY `pes_email_UNIQUE` (`pes_email`),
  UNIQUE KEY `pes_cpf_UNIQUE` (`pes_cpf`),
  KEY `fk_brp_pes_end_codigo_idx` (`brp_pes_end_codigo`),
  CONSTRAINT `fk_brp_pes_end_codigo` FOREIGN KEY (`brp_pes_end_codigo`) REFERENCES `brp_enderecos` (`end_pes_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brp_pessoas`
--

LOCK TABLES `brp_pessoas` WRITE;
/*!40000 ALTER TABLE `brp_pessoas` DISABLE KEYS */;
INSERT INTO `brp_pessoas` VALUES (9,'5318966179','NETO SCHNEIDERR','123','1995-12-01',9,'NETO@NETO.COM');
/*!40000 ALTER TABLE `brp_pessoas` ENABLE KEYS */;
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
