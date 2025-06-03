CREATE DATABASE  IF NOT EXISTS `travel_planner` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `travel_planner`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: travel_planner
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `id` binary(16) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_outdoor` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `travel_package_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlj4c231yj1hcobvxlhiivsmbq` (`travel_package_id`),
  CONSTRAINT `FKlj4c231yj1hcobvxlhiivsmbq` FOREIGN KEY (`travel_package_id`) REFERENCES `travel_package` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (_binary 'p∫OÙ1H~Æ\Áb\Êª-∞\ƒ','Explore Amber Fort with a guided tour and optional elephant ride.',_binary '','Amber Fort Guided Tour',250,_binary '& SL¸B&àMV\œsA¿§'),(_binary 'ñhNBãë¸[0;\‰\‹z','Learn traditional Rajasthani block printing from local artisans.',_binary '\0','Jaipur Handicrafts Workshop',90,_binary '\·\‡ˆ≠\ÿn@C≥íB\ÿ|0è'),(_binary '\…t~fA“É-oe\ {d','Cultural dinner experience with live folk music and dance.',_binary '\0','Traditional Rajasthani Dinner',150,_binary '& SL¸B&àMV\œsA¿§'),(_binary '\ﬁ“é\Ó¯\ÂAﬂ≤≤E\Œ9F','Guided tour of the majestic Amber Fort with elephant ride.',_binary '','Amber Fort Exploration',200,_binary '\·\‡ˆ≠\ÿn@C≥íB\ÿ|0è');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_seq`
--

DROP TABLE IF EXISTS `activity_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_seq`
--

LOCK TABLES `activity_seq` WRITE;
/*!40000 ALTER TABLE `activity_seq` DISABLE KEYS */;
INSERT INTO `activity_seq` VALUES (1);
/*!40000 ALTER TABLE `activity_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_authority`
--

DROP TABLE IF EXISTS `auth_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_authority` (
  `id` binary(16) NOT NULL,
  `role_code` varchar(255) NOT NULL,
  `role_description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_authority`
--

LOCK TABLES `auth_authority` WRITE;
/*!40000 ALTER TABLE `auth_authority` DISABLE KEYS */;
INSERT INTO `auth_authority` VALUES (_binary 'mF\ÿI0vN.öL;\‡á','Admin','It is Admin Role'),(_binary '±â\Î†\ÿ(A¬°á≥0!∏0l','User','It is User Role');
/*!40000 ALTER TABLE `auth_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `states_id` binary(16) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqqp42pwn0tt6ma6j7e58bxvbf` (`states_id`),
  CONSTRAINT `FKqqp42pwn0tt6ma6j7e58bxvbf` FOREIGN KEY (`states_id`) REFERENCES `states` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (_binary '\‡ç\∆\nEîä2%\\ØU˝=','Lonavala',_binary 'Hv;ÄB\ÀL˝Æ<Oç˝º‘´','Lonavala is famous for its breathtaking natural beauty, including misty hills, cascading waterfalls, and lush greenery, especially during the monsoon season. ','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Lonavala/Lonavala.jpg'),(_binary '#ıπ8\Ô\ŒCÉ£\⁄\‹l¡ôˆ≥','Konkan',_binary 'Hv;ÄB\ÀL˝Æ<Oç˝º‘´','The Konkan region, located along the western coastline of India. Konkan is known Known for its serene beaches, lush greenery, and picturesque landscapes, Konkan is a paradise for travellers ','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Kokan/kokan.webp'),(_binary '||P\›(OKÅ{AD&\Á\0','Khandala',_binary 'Hv;ÄB\ÀL˝Æ<Oç˝º‘´','Khandala is known for its natural beauty, specifically its stunning views of the Western Ghats, lush greenery, and gushing waterfalls.It\'s also famous for  Lohagad Fort, Bhaja and Karla Caves, and Duke\'s Nose attracting visitors. ','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Khandala/khandala.jpg'),(_binary '°t^PD∞é\ \ÕB• ù','Jaipur',_binary '\"gÙ%\ÀYFêπNÒ≥Æm','Jaipur is the capital of India‚Äôs Rajasthan state. It evokes the royal family that once ruled the region and that, in 1727, founded what is now called the Old City, or ‚ÄúPink City‚Äù for its trademark building color.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaipur/JaipurCity.jpg'),(_binary '±\‹Ùé\"0B\nπ\«+ê˙U∂\«','Jodhpur',_binary '\"gÙ%\ÀYFêπNÒ≥Æm','Jodhpur is famous for its distinctive Blue City appearance, with many buildings in the old city painted a vibrant blue. It\'s also known for the Mehrangarh Fort, a massive, historically significant structure','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jodhpur/JodhpurCity.jpg'),(_binary ' ë7LM“ìK[π{ó“Ä','Matheran',_binary 'Hv;ÄB\ÀL˝Æ<Oç˝º‘´','Matheran is a hill station, near Mumbai, in the west Indian state of Maharashtra. It‚Äôs known for its mild climate and well-preserved colonial architecture.','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Matheran/Matheran.jpg'),(_binary '\–\"u§bOHf§9Ù\Ï','Udaipur',_binary '\"gÙ%\ÀYFêπNÒ≥Æm','Udaipur is famous for its lakes, palaces, and rich Rajputana history, earning it the nicknames City of Lakes and Venice of the East. It\'s known for its romantic atmosphere, stunning architecture, and vibrant culture.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Udaipur/Udaipur+city.jpg'),(_binary '\Â•√µº\ZM\'É\ZÜ∏sI|','Jaisalmer',_binary '\"gÙ%\ÀYFêπNÒ≥Æm','The city of Jaisalmer also acts as the guard to western Rajasthan frontier. Also Known as the \'Golden City\'. It\'s distinguished by its yellow sandstone architecture','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaisalmer/Jaisalmer+city.jpg');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` binary(16) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `city_id` binary(16) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `travel_package_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf1iabdv6bi2yohh9h48wce42x` (`city_id`),
  KEY `FK8k7uwb49ps8q3k9gy02ltckia` (`travel_package_id`),
  CONSTRAINT `FK8k7uwb49ps8q3k9gy02ltckia` FOREIGN KEY (`travel_package_id`) REFERENCES `travel_package` (`id`),
  CONSTRAINT `FKf1iabdv6bi2yohh9h48wce42x` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (_binary '®\Í\⁄<àC&è˜ÒÄ™\‘Rú','The Chelon Haveli, No. 185, Tulsi Marg, Gangori Bazaar, Gangori Bazar, Pink City, Jaipur, Rajasthan 302002','Bloom Boutique | Chelon Haveli is a two-hundred-ninety-year-old, charming boutique hotel that celebrates the essence of Havelis and ageless architecture. With the original facade still intact this gorgeous boutique hotel.','Bloom Boutique - Chelon Haveli',4.8,_binary '°t^PD∞é\ \ÕB• ù','https://r1imghtlak.mmtcdn.com/621d8000256311ee85d30a58a9feac02.jpg',NULL),(_binary '\'˚Yµ@¥†iq\‘\\ì','417, Sethi Bhawan, Hanuman Ji Ka Rasta, Tripolia Bazar, Badi Chaupar, Jaipur, Rajasthan 302003','Sheel Mahal, also known as Sheel Mahal - Near Hawa Mahal, is a heritage hotel in Jaipur, Rajasthan, located within the historic walled city. It\'s situated in a prime location, just a short walk from the iconic Hawa Mahal.','Sheel Mahal',4.5,_binary '°t^PD∞é\ \ÕB• ù','https://r2imghtlak.mmtcdn.com/r2-mmt-htl-image/htl-imgs/202404121252289607-f473698d-3488-49ec-ae04-24e8f6333f7c.jpg',NULL),(_binary '(#qüBêù–ål\ÂÓÉ¶','104, near City Palace Road, Bhatiyani Chohatta, Silawatwari, Udaipur, Rajasthan 313001','Manuscript Jhilwara Haveli is a 4-star heritage hotel in Udaipur, Rajasthan, known for its blend of modern comfort and historical charm.','Manuscript Jhilwara Haveli',4,_binary '\–\"u§bOHf§9Ù\Ï','https://r1imghtlak.mmtcdn.com/06826952b6bf11ee9e120a58a9feac02.jpeg?&output-quality=75&downsize=520:350&crop=520:350;0,20&output-format=jpg&downsize=480:336&crop=480:336',NULL),(_binary '+8mêO≠§\Í¶L˝Mâ∞','The City Palace Complex, Lake, City Palace Rd, near Zenana Mahal, Old City, Pichola, Udaipur, Rajasthan 313001','It is a luxury heritage hotel and former residence of Maharana Fateh Singh, offering breathtaking views of Lake Pichola','Taj Fateh Prakash Palace',4,_binary '\–\"u§bOHf§9Ù\Ï','https://r1imghtlak.mmtcdn.com/e9f2b0f2a2ae11eb82190242ac110004.jpg',NULL),(_binary '3˛ıF˙\ƒF!ñ\⁄\”\Ín˘B]','Nai Sarak, Soajti Gate, Jodhpur, Rajasthan 342001','The Hosteller Jodhpur is a hostel offering a variety of accommodation options, including dormitories and private rooms, in a vibrant and cozy setting within the heart of Jodhpur.','The Hosteller',4.5,_binary '±\‹Ùé\"0B\nπ\«+ê˙U∂\«','https://www.thehosteller.com/_next/image/?url=https%3A%2F%2Fstatic.thehosteller.com%2Fhostel%2Fimages%2Fimage.jpg%2Fimage-1747197522751.jpg&w=1920&q=75',NULL),(_binary 'i1<\ÀTåL\rônL§f∫\∆','Fort Parking, Shiv Rd, Dhibba Para, Manak Chowk, Amar Sagar Pol, Jaisalmer, Rajasthan 345001','Hotel Garh Villa welcomes you in Golden city.The leading and the dedicated Jaisalmer Tour Operator agency serving for decades offers best travel trips to Jaisalmer at very nominal prices. There is no better way to explore the Jaisalmer.','Hotel Garh Villa ',4.5,_binary '\Â•√µº\ZM\'É\ZÜ∏sI|','https://lh3.googleusercontent.com/p/AF1QipMXFBsdpattYrCLjDw_fFR7vaue8s4M5YZsvFkw=s1360-w1360-h1020-rw',NULL),(_binary 'Ån†É\Î.LûòëJ\‚\„\‚','Near Amber Fort, Jaipur, Rajasthan',NULL,'The Royal Palace Hotel',4.7,NULL,NULL,_binary '& SL¸B&àMV\œsA¿§'),(_binary 'àv5ù\'B@®\¬$\ƒuÙ4Ù','B-12, Amer Road, Near Jal Mahal, Jaipur, Rajasthan 302002','Experience luxury and heritage in the heart of Jaipur. Located near major attractions like Hawa Mahal and City Palace, our hotel offers elegant rooms, fine dining, and exceptional service.','The Royal Palace Hotel',4.5,_binary '°t^PD∞é\ \ÕB• ù','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/59/f0/7e/jaipur-darbar-hotel.jpg?w=900&h=500&s=1',NULL),(_binary 'ïE€ø[@íÅTà`\‘xi','sand dunes, Lakhmana Road, Jaisalmer - Sam - Dhanana Rd, Sam, Jaisalmer, Rajasthan 345001','The Shama Desert Camp in Jaisalmer is here to provide you with some of the most incredible Jaisalmer experiences you\'ve probably never had before.','Shama Desert Camp',4.5,_binary '\Â•√µº\ZM\'É\ZÜ∏sI|','https://imgak.mmtcdn.com/pwa_v3/pwa_hotel_assets/bgdefault_bg.jpg',NULL),(_binary 'ù\—zè\Œ*@h§\ﬁ&Æ\n˛±Ω','Nai Sarak, Soajti Gate, Jodhpur, Rajasthan 342001','Priya Hotel in Jodhpur is a well-regarded, budget-friendly hotel known for its convenient location near popular landmarks like Ghanta Ghar and Jain Mahavira Temple','Priya Hotel',4.8,_binary '±\‹Ùé\"0B\nπ\«+ê˙U∂\«','https://r1imghtlak.mmtcdn.com/3c2c1af42fb211ebba190242ac110002.jpg',NULL),(_binary '\Œ¯rÙKıπ5T#)\È‘™','Fort Rd, inside Clock Tower Road, Killi Khana, Sodagaran Mohalla, Jodhpur, Rajasthan 342001','Hostel Vostel in Jodhpur offers a 4-star hotel experience with air-conditioned rooms featuring private bathrooms, tiled floors, and seating areas.','Hostel Vostel',4.5,_binary '±\‹Ùé\"0B\nπ\«+ê˙U∂\«','https://r2imghtlak.mmtcdn.com/r2-mmt-htl-image/flyfish/raw/NH75005321271848/QS1042/QS1042-Q1/1714396008941.jpeg',NULL),(_binary '\◊˝ùâÆEã¥u¡%\"~¶','Amber Road, Jaipur, Rajasthan',NULL,'The Royal Palace Hotel',4.6,NULL,NULL,_binary '\·\‡ˆ≠\ÿn@C≥íB\ÿ|0è'),(_binary 'Û\–\ƒRæ\‘@åès\"l∞b?','Sam, Jaisalmer, Rajasthan 345001','Royal Adventure Camp Sam in Jaisalmer is here to provide  All rooms are provided with a flat-screen LED TV.24-hour hot & cold water in all rooms ensure a comfortable stay','Royal Adventure Camp Sam',4,_binary '\Â•√µº\ZM\'É\ZÜ∏sI|','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2d/0f/f0/41/caption.jpg?w=1400&h=800&s=1',NULL),(_binary '¸\Ã˛`âB4±7-ŒÅg\Ó','Jada Ganesh Ji Chowk, Salera Bagh, near Chandpole, Ambamata, Udaipur, Rajasthan 313001','The Experience Resort in Udaipur is a charming, boutique-style property known for its serene atmosphere and beautiful lake views.','The Experience Resort',4.5,_binary '\–\"u§bOHf§9Ù\Ï','https://r2imghtlak.mmtcdn.com/r2-mmt-htl-image/htl-imgs/202309132116069704-51635f2e7f8011ee89090a58a9feac02.jpg?&output-quality=75&downsize=520:350&crop=520:350;2,0&output-format=jpg&downsize=480:336&crop=480:336',NULL);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_booking`
--

DROP TABLE IF EXISTS `package_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package_booking` (
  `id` binary(16) NOT NULL,
  `booking_type` enum('GROUP','SOLO') DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `package_name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `total_guests` int DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `users_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKage7u68txniatpoa2s0n04k16` (`users_id`),
  CONSTRAINT `FKage7u68txniatpoa2s0n04k16` FOREIGN KEY (`users_id`) REFERENCES `user_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_booking`
--

LOCK TABLES `package_booking` WRITE;
/*!40000 ALTER TABLE `package_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_item`
--

DROP TABLE IF EXISTS `package_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package_item` (
  `id` binary(16) NOT NULL,
  `cost` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `type` enum('ACTIVITY','HOTEL','TRANSPORT') DEFAULT NULL,
  `package_booking_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkpwn1o701v7v3l0n4i3w04we4` (`package_booking_id`),
  CONSTRAINT `FKkpwn1o701v7v3l0n4i3w04we4` FOREIGN KEY (`package_booking_id`) REFERENCES `package_booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_item`
--

LOCK TABLES `package_item` WRITE;
/*!40000 ALTER TABLE `package_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participant` (
  `id` binary(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `package_booking_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhutpropty2rylpwy26cr4vvv` (`package_booking_id`),
  CONSTRAINT `FKhutpropty2rylpwy26cr4vvv` FOREIGN KEY (`package_booking_id`) REFERENCES `package_booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `places` (
  `id` binary(16) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `hotel_id` binary(16) DEFAULT NULL,
  `city_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2i9o0gafx4j5sy2egkeuc4fm9` (`hotel_id`),
  KEY `FKef7bu07gk1fuq6s40eic3xhp4` (`city_id`),
  CONSTRAINT `FK2i9o0gafx4j5sy2egkeuc4fm9` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FKef7bu07gk1fuq6s40eic3xhp4` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `places`
--

LOCK TABLES `places` WRITE;
/*!40000 ALTER TABLE `places` DISABLE KEYS */;
INSERT INTO `places` VALUES (_binary '\0\Áï\ ˆ\'N‚≠åù¶t%µπ',NULL,'A royal residence with stunning architecture and museums.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaipur/City-Palace1.jpg','City Palace',NULL,_binary '°t^PD∞é\ \ÕB• ù'),(_binary '	\€+N[ØJf∞É%\0ß±i',NULL,'A picturesque lake offering boat rides with views of palaces.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Udaipur/Lake-pichola.jpg','Lake Pichola',NULL,_binary '\–\"u§bOHf§9Ù\Ï'),(_binary 'v|\‹WN∫∂\·a æÛF',NULL,'Sindhudurg known for its stunning beaches, rich cultural heritage, and historical forts','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Kokan/sindudurg.jpeg','Sindhudurg',NULL,_binary '#ıπ8\Ô\ŒCÉ£\⁄\‹l¡ôˆ≥'),(_binary '\Z\√M^TlCÇö<v\‡M\÷O',NULL,'A grand palace complex with stunning views of Lake Pichola.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Udaipur/City-Palace-Udaipur.jpg','City Palace Udaipur',NULL,_binary '\–\"u§bOHf§9Ù\Ï'),(_binary 'Ò%\…8uDŒªï˜˛\÷a£D',NULL,'The iconic clock tower in the heart of Jodhpur‚Äôs bustling market.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jodhpur/Ghanta-ghar.jpg','Ghanta Ghar',NULL,_binary '±\‹Ùé\"0B\nπ\«+ê˙U∂\«'),(_binary '3õ\\K1¥\…G¡ø<=',NULL,'Ganpatipule is primarily known for the Ancient Swayambhu Ganpati Temple, a pilgrimage site dedicated to Lord Ganesha, located on the beach.','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Kokan/Ganpatipule-location.jpg','Ganpatipule',NULL,_binary '#ıπ8\Ô\ŒCÉ£\⁄\‹l¡ôˆ≥'),(_binary ';M∫\Ï˘^E`ºf.o-ﬂ™',NULL,'This beachside town is popular for its ancient forts, enchanting beaches, and exciting water sports.','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Kokan/alibag.jpg','Alibag',NULL,_binary '#ıπ8\Ô\ŒCÉ£\⁄\‹l¡ôˆ≥'),(_binary 'O\ŸTeß§N∏Öı¡C\Ÿ\ÁM',NULL,'The Kune Falls is a waterfall at Lonavla in Pune district in the Indian state of Maharashtra. It is the 14th highest waterfall in India.','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Lonavala/kune+waterfalls.jfif','Kune Water Falls',NULL,_binary '\‡ç\∆\nEîä2%\\ØU˝='),(_binary 'Påß\⁄Iæ•£\–\ŸÕª',NULL,'Ratnagiri is primarily known for its beautiful beaches, historical forts, and the world-famous Alphonso mangoes. ','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Kokan/ratnagiri.jpg','Ratnagiri',NULL,_binary '#ıπ8\Ô\ŒCÉ£\⁄\‹l¡ôˆ≥'),(_binary 'Q\‚\ÊNpBs°A∫J^\»&',NULL,'A historic fort offering panoramic views of Jaipur.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaipur/Nahargarh-fort.jpg','Nahargarh Fort',NULL,_binary '°t^PD∞é\ \ÕB• ù'),(_binary 'QWˆYRGÀ°yRo…É\Ô',NULL,'Family-friendly museum featuring lifelike wax replicas of Indian & international celebrities.','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Lonavala/Sunil\'s+Wax+Museum.jfif','Sunil Wax Museum',NULL,_binary '\‡ç\∆\nEîä2%\\ØU˝='),(_binary 'rµ¨\rûñN∞†C%L≤\ÈC',NULL,'A picturesque lake offering boat rides with views of palaces.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaisalmer/Desert-culture.jpg','Desert Central Culture',NULL,_binary '\Â•√µº\ZM\'É\ZÜ∏sI|'),(_binary '~ÚY1 \⁄Nòßñ\Èyé\≈[Ø',NULL,'A majestic fort known for its artistic Hindu-style elements.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaipur/ambur-fort.jpg','Amber Fort',NULL,_binary '°t^PD∞é\ \ÕB• ù'),(_binary 'ó∞d∆Å∏MÆØ=$AΩ\Ì≥',NULL,'A massive fort overlooking Jodhpur, known for its architecture and history.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jodhpur/Mehrangarh-fort.jpg','Mehrangarh Fort',NULL,_binary '±\‹Ùé\"0B\nπ\«+ê˙U∂\«'),(_binary 'òm\ \Í˝ÚHTí6Ö\n¿x\·?',NULL,'Bhaja Caves are a group of 22 rock-cut caves.The caves are 400 feet above the village of Bhaja.','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Lonavala/karla+and+bhaja+caves.jfif','Bhaja Caves',NULL,_binary '\‡ç\∆\nEîä2%\\ØU˝='),(_binary '®ì\·\Ê1Ccù`§n”ª®',NULL,'A beautifully carved Hindu temple dedicated to Lord Vishnu.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Udaipur/Jagdish-temple.jpg','Jagdish Temple',NULL,_binary '\–\"u§bOHf§9Ù\Ï'),(_binary '™zór•ÆHº£˙\∆K\ÍU¢',NULL,'A serene palace on an island in Lake Pichola, known for its architecture.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Udaipur/Jagmandir-island-palace.jpg','Jagmandir Island Palace',NULL,_binary '\–\"u§bOHf§9Ù\Ï'),(_binary 'æØ\÷\ﬂÒB™Ä∞u\√\‰îIX',NULL,'A unique desert ecosystem with diverse wildlife.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaisalmer/National-park.jpg','Desert National Park',NULL,_binary '\Â•√µº\ZM\'É\ZÜ∏sI|'),(_binary '\ \ÏU\"∑ïLrîêÖúE˚\—˛',NULL,'The Palace of Winds, famous for its intricate latticework and pink facade.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaipur/Hawa+Mahal.jpg','Hawa Mahal',NULL,_binary '°t^PD∞é\ \ÕB• ù'),(_binary 'œ∏kµ∆æ@^µı.K£¥ÆX',NULL,'A museum dedicated to the military history of the region.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaisalmer/Jaisalmer-war-museum.jpg','Jaisalmer War Museum',NULL,_binary '\Â•√µº\ZM\'É\ZÜ∏sI|'),(_binary '◊üÅƒê°Hœë\„îO;º}@',NULL,'Large adventure & activity park known for its archery, dirt-bike riding, paintball & rappelling..','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/Lonavala/Della+Adventure+Park.jfif','Della Adventure Park',NULL,_binary '\‡ç\∆\nEîä2%\\ØU˝='),(_binary '\◊≈∑ ≤\‹C‘•´üC ei\…',NULL,'A beautifully designed tower with intricate architecture.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jaisalmer/Tazia-tower.png','Tazia Tower',NULL,_binary '\Â•√µº\ZM\'É\ZÜ∏sI|'),(_binary '\ÍR\»\ËHtó;Ä\ÿ>v(',NULL,'A white marble memorial with intricate carvings and serene surroundings.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jodhpur/Jaswant-thada.jpg','Jaswant Thada',NULL,_binary '±\‹Ùé\"0B\nπ\«+ê˙U∂\«'),(_binary '˜ø\ﬂ.øW@îñ\◊\’\ \Ôº',NULL,'A Majestic palace, part of which is a luxury hotel and museum.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/Jodhpur/Umaid-Bhawan-Palace.png','Umaid Bhawan Palace',NULL,_binary '±\‹Ùé\"0B\nπ\«+ê˙U∂\«');
/*!40000 ALTER TABLE `places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` binary(16) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `hotel_id` binary(16) DEFAULT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `users_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi0ly7ivbh8ijdgoi7cwtuoavt` (`hotel_id`),
  KEY `FK6wa8bk03pfwin0wlt9xnvc62e` (`user_id`),
  KEY `FK7495xclt8s8sxaa2ry2bj2mxx` (`users_id`),
  CONSTRAINT `FK6wa8bk03pfwin0wlt9xnvc62e` FOREIGN KEY (`user_id`) REFERENCES `user_details` (`id`),
  CONSTRAINT `FK7495xclt8s8sxaa2ry2bj2mxx` FOREIGN KEY (`users_id`) REFERENCES `user_details` (`id`),
  CONSTRAINT `FKi0ly7ivbh8ijdgoi7cwtuoavt` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_seq`
--

DROP TABLE IF EXISTS `review_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_seq`
--

LOCK TABLES `review_seq` WRITE;
/*!40000 ALTER TABLE `review_seq` DISABLE KEYS */;
INSERT INTO `review_seq` VALUES (1);
/*!40000 ALTER TABLE `review_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` binary(16) NOT NULL,
  `capacity` int DEFAULT NULL,
  `price_per_night` double DEFAULT NULL,
  `room_type` varchar(255) DEFAULT NULL,
  `hotel_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdosq3ww4h9m2osim6o0lugng8` (`hotel_id`),
  CONSTRAINT `FKdosq3ww4h9m2osim6o0lugng8` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (_binary 'cõR“êNHáª¸ôRx7\Ó',3,300,'Deluxe Suite',_binary 'Ån†É\Î.LûòëJ\‚\„\‚'),(_binary 'jæ˚ÄE\rM<°;\Õ\⁄ONl',2,4500,'Deluxe King Room',_binary 'àv5ù\'B@®\¬$\ƒuÙ4Ù'),(_binary 'æ^ìl\0Cú¨æπ\…Dôı',2,220,'Heritage Room',_binary 'Ån†É\Î.LûòëJ\‚\„\‚');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `states` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (_binary '¿\ÀÚs\\G«±\Ï!ø\'Ù≤´','Uttar Pradesh','Uttar Pradesh is renowned for its rich history, religious significance, and diverse culture. It\'s home to significant Hindu and Buddhist sites, including the birthplace of Lord Rama (Ayodhya) and Lord Krishna (Mathura), as well as Varanasi.','https://s3.eu-north-1.amazonaws.com/travel.planner/UttarPradesh/upp3.jpg'),(_binary '\"gÙ%\ÀYFêπNÒ≥Æm','Rajasthan','Rajasthan is famously known for its rich royal heritage, including majestic forts and palaces like the Amber Fort and Hawa Mahal. It\'s also celebrated for its vibrant culture, traditional arts and crafts, and delicious cuisine.','https://s3.eu-north-1.amazonaws.com/travel.planner/Rajasthan/camels.jpeg'),(_binary 'Hv;ÄB\ÀL˝Æ<Oç˝º‘´','Maharashtra','Maharashtra is known for its vibrant culture, historical significance, and economic importance. It\'s a major center for the Indian Film Industry (Bollywood), a key Agricultural producer, and home to numerous historical and cultural landmarks.','https://s3.eu-north-1.amazonaws.com/travel.planner/Maharashtra/mum.jpg'),(_binary 'jl^ÛóH\0êüj∫Ω\÷\’','Kerala','Kerala is famously known for its natural beauty, cultural heritage, and rich diversity. The state is often called \'God\'s Own Country\' due to its stunning landscapes, backwaters, beaches, and lush green hills.','https://s3.eu-north-1.amazonaws.com/travel.planner/Kerala/img4.jpeg'),(_binary '}\◊&\€%eB2±éú,C¶','Ladakh','Ladakh is most famous for breathtaking landscapes, the crystal clear skies, the highest mountain passes, thrilling adventure activities, Buddhist Monasteries and festivals','https://s3.eu-north-1.amazonaws.com/travel.planner/Ladakh/ladakh.jpg'),(_binary '©\rÇ\·¥LØfl\Ó?\≈S','Tamil Nadu','Tamil Nadu is renowned for its rich cultural heritage, particularly its ancient temples, vibrant festivals, and diverse culinary traditions. The state is also famous for its classical dance forms like Bharatanatyam and its thriving movie industry','https://s3.eu-north-1.amazonaws.com/travel.planner/TamilNadu/tamilnadu.jpg');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_package`
--

DROP TABLE IF EXISTS `travel_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_package` (
  `id` binary(16) NOT NULL,
  `duration_in_days` int NOT NULL,
  `is_group_package` bit(1) NOT NULL,
  `package_name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `city_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3l5blbwsytx1yqguxnce2h0rv` (`city_id`),
  CONSTRAINT `FK3l5blbwsytx1yqguxnce2h0rv` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_package`
--

LOCK TABLES `travel_package` WRITE;
/*!40000 ALTER TABLE `travel_package` DISABLE KEYS */;
INSERT INTO `travel_package` VALUES (_binary '& SL¸B&àMV\œsA¿§',4,_binary '','Jaipur Royal Retreat Package',1800,_binary '°t^PD∞é\ \ÕB• ù'),(_binary '\·\‡ˆ≠\ÿn@C≥íB\ÿ|0è',5,_binary '','Royal Heritage Tour of Jaipur',1350,_binary '°t^PD∞é\ \ÕB• ù');
/*!40000 ALTER TABLE `travel_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_details` (
  `id` binary(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  `authority_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4d9rdl7d52k8x3etihxlaujvh` (`email`),
  UNIQUE KEY `UKf4pdcamta635qqbhgcyqvrg7f` (`user_id`),
  UNIQUE KEY `UK7lkkq1jttkmctyg90i7d3m7pj` (`authority_id`),
  CONSTRAINT `FK6e24fsly8efk6b67jncpndylr` FOREIGN KEY (`authority_id`) REFERENCES `auth_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (_binary 'ó4Û…ùF÷éÑ«∏–ì$£','shubhammusale111@gamil.com',_binary '','Shubham','Musale','{bcrypt}$2a$10$JCWqljyPZOZnRACCpmv0UOx.6mICg6cVtad1mhlQ9.mbirRA8tT9a','8766453107','Admin11111',_binary 'mF\ÿI0vN.öL;\‡á'),(_binary '\ÿZXjîHVó >*bV','shubhammusale111@gmail.com',_binary '','Shubham','Musale','{bcrypt}$2a$10$/mMKmaDxLrRmsgl4FQifxuPhZvTrulUduN1PVHxYFnP/rlRO4VeW.','8766453107','User11111',_binary '±â\Î†\ÿ(A¬°á≥0!∏0l');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-02 16:49:26
