/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.17 : Database - xbom-op
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xbom-op` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `xbom-op`;

/*Table structure for table `digikey_category` */

DROP TABLE IF EXISTS `digikey_category`;

CREATE TABLE `digikey_category` (
  `AutoId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `CategoryId` int(10) unsigned NOT NULL,
  `ENGName` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CHSName` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ProductCount` int(10) unsigned NOT NULL DEFAULT '0',
  `ParentCategoryId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`AutoId`),
  UNIQUE KEY `CategoryId` (`CategoryId`),
  KEY `ParentCategoryId` (`ParentCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_changing` */

DROP TABLE IF EXISTS `digikey_changing`;

CREATE TABLE `digikey_changing` (
  `autoId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tableName` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `changingType` tinyint(4) DEFAULT '0' COMMENT '0-信息修改；5-新记录；10-数据库中存在冗余数据',
  `changing` text COLLATE utf8mb4_general_ci,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`autoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_manufacturer` */

DROP TABLE IF EXISTS `digikey_manufacturer`;

CREATE TABLE `digikey_manufacturer` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_market_place_status` */

DROP TABLE IF EXISTS `digikey_market_place_status`;

CREATE TABLE `digikey_market_place_status` (
  `id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_packaging` */

DROP TABLE IF EXISTS `digikey_packaging`;

CREATE TABLE `digikey_packaging` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_parameter_name` */

DROP TABLE IF EXISTS `digikey_parameter_name`;

CREATE TABLE `digikey_parameter_name` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_pricing_availability` */

DROP TABLE IF EXISTS `digikey_pricing_availability`;

CREATE TABLE `digikey_pricing_availability` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `availableQuantity` int(11) DEFAULT NULL,
  `minimumQuantity` int(11) DEFAULT NULL,
  `unitPrice` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4701 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_product` */

DROP TABLE IF EXISTS `digikey_product`;

CREATE TABLE `digikey_product` (
  `id` bigint(20) unsigned NOT NULL,
  `dkNumber` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mfgNumber` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `manufacturerId` bigint(20) unsigned DEFAULT NULL,
  `packagingId` bigint(20) DEFAULT NULL,
  `marketplaceStatusId` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extendedDescription` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `categoryId` bigint(20) unsigned DEFAULT NULL,
  `mediaId` bigint(20) unsigned DEFAULT NULL,
  `fee` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_product_media_datasheet` */

DROP TABLE IF EXISTS `digikey_product_media_datasheet`;

CREATE TABLE `digikey_product_media_datasheet` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) NOT NULL,
  `typeId` bigint(20) unsigned NOT NULL,
  `typeName` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `url` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5655 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_product_media_other` */

DROP TABLE IF EXISTS `digikey_product_media_other`;

CREATE TABLE `digikey_product_media_other` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) NOT NULL,
  `typeId` bigint(20) DEFAULT NULL,
  `typeName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `url` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8683 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_product_media_videos` */

DROP TABLE IF EXISTS `digikey_product_media_videos`;

CREATE TABLE `digikey_product_media_videos` (
  `productId` bigint(20) DEFAULT NULL,
  `typeId` bigint(20) DEFAULT NULL,
  `typeName` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `url` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `posterUrl` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_product_parameter` */

DROP TABLE IF EXISTS `digikey_product_parameter`;

CREATE TABLE `digikey_product_parameter` (
  `productId` bigint(20) unsigned NOT NULL,
  `parameterNameId` bigint(20) NOT NULL,
  `valueId` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `valueName` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `valueActive` tinyint(3) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_product_photo` */

DROP TABLE IF EXISTS `digikey_product_photo`;

CREATE TABLE `digikey_product_photo` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) NOT NULL,
  `name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `thumbnail` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fullSize` varbinary(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4701 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `digikey_propertie` */

DROP TABLE IF EXISTS `digikey_propertie`;

CREATE TABLE `digikey_propertie` (
  `autoId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `productId` bigint(20) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `value` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `valueName` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`autoId`),
  KEY `id` (`id`,`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=28381 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
