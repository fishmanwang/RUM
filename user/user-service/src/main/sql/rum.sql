/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.12-log : Database - rum
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rum` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rum`;

/*Table structure for table `rum_account` */

DROP TABLE IF EXISTS `rum_account`;
CREATE TABLE `rum_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '所属用户',
  `nickname` varchar(32) NOT NULL DEFAULT '' COMMENT '昵称',
  `phone` varchar(16) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  `grade` tinyint(4) NOT NULL DEFAULT '0' COMMENT '等级',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='账户表'
;

/*Table structure for table `rum_permission` */

DROP TABLE IF EXISTS `rum_permission`;
CREATE TABLE `rum_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='权限表';

/*Table structure for table `rum_user` */

DROP TABLE IF EXISTS `rum_user`;
CREATE TABLE `rum_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` char(64) NOT NULL,
  `salt` char(6) NOT NULL,
  `frozen` int(11) NOT NULL DEFAULT '0' COMMENT '冻结时间，单位秒。0:不冻结, -1：永远冻结。',
  `last_login_ip` varchar(16) NOT NULL DEFAULT '' COMMENT '上次登录IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Table structure for table `rum_user_permission` */

DROP TABLE IF EXISTS `rum_user_permission`;
CREATE TABLE `rum_user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户权限';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
