-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: myrestaurants_schema
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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;


CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(20) DEFAULT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `contrasenya` char(30) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `tipo` enum('gestor','cliente')NOT  NULL,
  PRIMARY KEY (`id_usuario`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES(1, 'jokin','jokin@gmail.com', '123Deusto', '685740319', 1), (2, 'sergioco', 'sergioco@gmail.com', '123Deusto', '695430015', 1),(3, 'sergiolo','sergiolo@gmail.com', '123Deusto', '685740319', 1), (4, 'xabi', 'xabi@gmail.com', '123Deusto', '675430015', 2), (5, 'nerea', 'nerea@gmail.com', '123Deusto', '674430015', 2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurante` (
 `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `horarioApertura` char(30) DEFAULT NULL,
  `horarioCierre` char(30) DEFAULT NULL,
   `direccion` varchar(40) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `tipoComida` enum('hamburgueseria', 'comidaCasera', 'pizzeria', 'sidreria','china', 'chuletas')NOT  NULL,
  PRIMARY KEY (`id_restaurante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
INSERT INTO `restaurante` VALUES('Como en Casa', '8.00', '23.00', 'Calle Agapito', '900000000', 1), ('Paco', '10.00', '22.00', 'Calle Mayor', '900000001', 2), ('MCarrones', '14.00', '23.00', 'Calle Colesterol', '900000040', 3), ('La morci', '8.00', '23.00', 'Calle San Juan', '900200000', 4), ('El bichci', '9.00', '24.00', 'Calle Mayor', '908000000', 5), ('Maxin', '7.00', '22.00', 'Calle azabache', '900007000', 6), ('Txpolu', '14.00', '01.00', 'Calle Mojama', '904500000', 1), ('Supoi', '8.00', '24.00', 'Calle Mayor', '900000101', 2), ('Berigud', '8.00', '24.00', 'Calle inglaterra', '900710040', 3), ('Ropocar', '9.00', '22.00', 'Calle mojama', '900263000', 4), ('Ribok ni naik', '10.00', '24.00', 'Calle Fray ', '908007000', 5), ('Pulpo pol', '9.00', '23.00', 'Calle carroza', '900047000', 6);
/*!40000 ALTER TABLE `restaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `precio` int(5) NOT NULL,
  
  PRIMARY KEY (`idproducto`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES(1,'Agua','Agua fresca',1), (7,'Helado Chocolate','Casero',2),  (3,'Vino rioja','Vino tinto',5), (4,'Zumo','Recién exprimido',2), (10,'Tarta Chocolate','Con mucho chocolate',4);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bebida`
--

DROP TABLE IF EXISTS `bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebida` (
  `idproducto` int(11) NOT NULL,
  `idbebida` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `precio` int(5) NOT NULL,
  `conAlcohol` tinyint(4) DEFAULT NULL,
  
  PRIMARY KEY (`idbebida`),
  CONSTRAINT `idbebida` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`)
)
 ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
INSERT INTO `bebida` VALUES(1,1,'Agua','Agua fresca',1,1), (2,2,'Coca-Cola','Refresco gaseoso',1,1), (3,3,'Vino rioja','Vino tinto',5,2), (4,4,'Zumo','Recién exprimido',2,1), (5,5,'Ron con coca cola','Mezcla de alcohol y refresco',7,2);
/*!40000 ALTER TABLE `bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postre`
--

DROP TABLE IF EXISTS `postre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postre` (
  `idproducto` int(11) NOT NULL,
  `idpostre` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `precio` int(5) NOT NULL,
  
  PRIMARY KEY (`idpostre`),
  CONSTRAINT `idpostre` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postre`
--

LOCK TABLES `postre` WRITE;
/*!40000 ALTER TABLE `postre` DISABLE KEYS */;
INSERT INTO `postre` VALUES(6,1,'Tarta de queso','Con mermelada',3), (7,2,'Helado Chocolate','Casero',2), (8,3,'Helado Vainilla','Casero',2), (9,4,'Helado Fresa','Caser',2), (10,5,'Tarta Chocolate','Con mucho chocolate',4);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;



/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;