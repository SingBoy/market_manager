/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.7.17-log : Database - market_manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`market_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `market_manager`;

/*Table structure for table `t_account` */

DROP TABLE IF EXISTS `t_account`;

CREATE TABLE `t_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `user_role` int(2) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `companyId` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_account` */

insert  into `t_account`(`id`,`accountname`,`password`,`nickname`,`user_role`,`email`,`phone`,`status`,`address`,`description`,`companyId`,`create_date`,`modify_date`) values (1,'yuxiangjie','96E79218965EB72C92A549DD5A330112','不认识的',NULL,'i_xiangj@163.com','1235466',NULL,NULL,'撒旦',NULL,'2017-07-22 15:14:22','2017-07-23 02:16:12'),(2,'sigal','96E79218965EB72C92A549DD5A330112',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'jinsda','ss',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'yuxiangjie11','E10ADC3949BA59ABBE56E057F20F883E','1sadas',NULL,'1545@123','1545',NULL,NULL,'撒旦撒旦撒',NULL,'2017-07-23 02:35:13','2017-07-23 02:35:13'),(5,'yids','E10ADC3949BA59ABBE56E057F20F883E','用户一',NULL,'','',NULL,NULL,'',NULL,'2017-07-25 23:09:46','2017-07-25 23:09:46');

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`name`,`parent_id`,`menu_url`,`description`,`create_date`,`modify_date`) values (1,'菜单一',0,'','','2017-07-25 23:14:13','2017-07-25 23:14:13'),(2,'菜单二',0,'','','2017-07-25 23:15:14','2017-07-25 23:15:14'),(3,'菜单三',0,'','','2017-07-25 23:15:22','2017-07-25 23:15:22'),(4,'菜单四',0,'','','2017-07-25 23:15:31','2017-07-25 23:15:31'),(5,'菜单五',0,'','','2017-07-25 23:15:39','2017-07-25 23:15:39'),(6,'二级菜单1',1,'','','2017-07-25 23:32:04','2017-07-25 23:32:04'),(7,'二级菜单2',2,'','','2017-07-25 23:32:31','2017-07-25 23:32:31');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `company_id` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
