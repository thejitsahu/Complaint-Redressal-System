/*
SQLyog Community v12.4.3 (32 bit)
MySQL - 5.5.59-log : Database - web_student_tracker
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`web_student_tracker` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `web_student_tracker`;

/*Table structure for table `complaint` */

DROP TABLE IF EXISTS `complaint`;

CREATE TABLE `complaint` (
  `cid` int(120) NOT NULL AUTO_INCREMENT,
  `uid` int(120) NOT NULL,
  `details` varchar(120) CHARACTER SET latin1 DEFAULT 'technical problem',
  `status` varchar(120) CHARACTER SET latin1 DEFAULT 'not seen',
  PRIMARY KEY (`cid`),
  KEY `utoc` (`uid`),
  CONSTRAINT `utoc` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `complaint` */

insert  into `complaint`(`cid`,`uid`,`details`,`status`) values 
(5,7,'select * hellmmm','in process'),
(6,7,'wrong','paid'),
(7,7,'Universe problem','not seen'),
(8,7,'select * from user','not seen'),
(10,1,'fridge','under process'),
(11,1,'heavy','not seen'),
(12,1,'hello','not seen'),
(13,1,'doctor','not seen'),
(14,1,'django','not seen'),
(15,1,'javscript','not seen'),
(16,1,'ReactJS','seen'),
(18,7,'guadrians','not seen'),
(19,7,'AngularJS','not seen');

/*Table structure for table `engineer` */

DROP TABLE IF EXISTS `engineer`;

CREATE TABLE `engineer` (
  `eid` int(120) NOT NULL AUTO_INCREMENT,
  `cid` int(120) DEFAULT NULL,
  `ename` varchar(120) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `ctoe` (`cid`),
  CONSTRAINT `ctoe` FOREIGN KEY (`cid`) REFERENCES `complaint` (`cid`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `engineer` */

insert  into `engineer`(`eid`,`cid`,`ename`) values 
(1,16,'Elon Musk'),
(2,10,'Vimal Pillai'),
(4,11,'Baja Fish Tacos'),
(5,NULL,'Baja Fish Tacos');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `serialid` int(120) NOT NULL,
  `cid` int(120) DEFAULT NULL,
  `name` varchar(120) CHARACTER SET latin1 DEFAULT NULL,
  `type` varchar(120) CHARACTER SET latin1 DEFAULT NULL,
  `company` varchar(120) CHARACTER SET latin1 DEFAULT NULL,
  `warantydate` varchar(120) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`serialid`),
  KEY `ctop` (`cid`),
  CONSTRAINT `ctop` FOREIGN KEY (`cid`) REFERENCES `complaint` (`cid`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`serialid`,`cid`,`name`,`type`,`company`,`warantydate`) values 
(1,NULL,'machyine','eclecgtric','gtodrej','21'),
(2,6,'Hello','electronics','Philips','21/09/1993'),
(3,NULL,'hello','dfsd','Philips','12/12/2019'),
(7,NULL,'Baja Fish Tacos','electronics','Philips','12/12/2019'),
(10,5,'Hello','electronics','Philips','21/09/1993'),
(14,NULL,'KFCvimal','electronics','Philips','21/09/1993'),
(22,15,'Hello','electronics','Godrej','23/6/1981'),
(23,10,'mcdonalds','electronics','Godrej','21/09/1993'),
(100,16,'Computer','electronics','Hewlett Packard','20/12/2020'),
(233,NULL,'Hello batman','electronics','dsfds','21/09/1993'),
(333,NULL,'i20','car','hyundai','23/6/1981'),
(1221,18,'Hello','electronics','Philips','21/09/1993'),
(6767,19,'Dell','electronics','Philips','21/09/1993');

/*Table structure for table `replacement` */

DROP TABLE IF EXISTS `replacement`;

CREATE TABLE `replacement` (
  `rid` int(120) NOT NULL AUTO_INCREMENT,
  `cid` int(120) DEFAULT NULL,
  `rname` varchar(120) CHARACTER SET latin1 DEFAULT NULL,
  `price` int(120) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `ctor` (`cid`),
  CONSTRAINT `ctor` FOREIGN KEY (`cid`) REFERENCES `complaint` (`cid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `replacement` */

insert  into `replacement`(`rid`,`cid`,`rname`,`price`) values 
(1,16,'sdf',334);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(120) NOT NULL AUTO_INCREMENT,
  `email` varchar(120) DEFAULT NULL,
  `username` varchar(120) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`username`,`password`) values 
(1,'thanos@gmail.com','thanos','as'),
(7,'venom@gmail.com','vimal','qw'),
(9,'venom@gmail.com','assassin','ass'),
(10,'vimal@gn.edu','Baja Fish Tacos','s');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
