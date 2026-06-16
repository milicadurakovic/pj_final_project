-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: book_app
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `bookstore`
--

DROP TABLE IF EXISTS `bookstore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookstore` (
  `bookstore_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` text COLLATE utf8mb3_unicode_ci NOT NULL,
  `adress` text COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `delated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`bookstore_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookstore`
--

LOCK TABLES `bookstore` WRITE;
/*!40000 ALTER TABLE `bookstore` DISABLE KEYS */;
INSERT INTO `bookstore` VALUES (1,'Vulkan - TC Galerija','Bulevar Vudroa Vilsona 12, Beograd','2026-06-01 18:06:41',NULL,NULL),(2,'Delfi - TC Ada mall','Radnicka 9, Beograd','2026-06-01 18:06:41',NULL,NULL),(3,'Laguna - TC Delta City','Jurija Gagarina 16, Beograd','2026-06-01 18:06:41','2026-06-03 11:28:41',NULL),(4,'Urban books','Njegoseva 53, Beograd','2026-06-01 18:06:41',NULL,NULL),(5,'Laguna','Duska Radovica','2026-06-03 11:36:20',NULL,'2026-06-03 19:55:50'),(6,'Laguna','Duska Radovica','2026-06-03 20:11:16',NULL,'2026-06-16 14:40:02');
/*!40000 ALTER TABLE `bookstore` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-16 14:58:30
