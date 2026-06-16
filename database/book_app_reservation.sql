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
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `reservation_id` int unsigned NOT NULL AUTO_INCREMENT,
  `bookstore_id` int unsigned NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `book_name` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `customer_name` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `status` enum('PENDING','CONFIRMED','CANCELED') COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `fq_reservation_bookstore_idx` (`bookstore_id`),
  CONSTRAINT `fq_reservation_bookstore` FOREIGN KEY (`bookstore_id`) REFERENCES `bookstore` (`bookstore_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,1,'2026-06-03 20:51:10','Kingdom of Ash','Marko Nikolic','CONFIRMED',NULL,'2026-06-04 14:19:22'),(2,2,'2026-06-03 20:51:10','The Whistler','Nikola Jovanovic','CONFIRMED',NULL,NULL),(3,3,'2026-06-03 20:51:10','Strange the Dreamer','Marta Stevanovic','CONFIRMED',NULL,'2026-06-04 14:19:30'),(4,4,'2026-06-03 21:37:05','Fourth wing','Petar Petrovic','PENDING','2026-06-03 21:37:13',NULL),(5,1,'2026-06-03 21:37:34','Fourth Wing','Petar Petrovic','PENDING',NULL,'2026-06-04 14:06:33'),(6,3,'2026-06-04 14:29:53','The Atlas Six','Marija Popovic','CONFIRMED',NULL,NULL),(7,3,'2026-06-04 14:33:06','Onyx storm','Jovana Jovanovic','CONFIRMED',NULL,'2026-06-04 14:35:06');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
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
