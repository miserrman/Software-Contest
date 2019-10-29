/*
Navicat MySQL Data Transfer

Source Server         : inter_DB
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : inter

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2019-10-28 23:26:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for big_category
-- ----------------------------
DROP TABLE IF EXISTS `bigcategory`;
CREATE TABLE `bigcategory` (
  `categoryid` int(7) NOT NULL auto_increment,
  `categoryinformation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for closet
-- ----------------------------
DROP TABLE IF EXISTS `closet`;
CREATE TABLE `closet` (
  `closetid` int(7) NOT NULL auto_increment,
  `clothesid` int(7) NOT NULL,
  `userid` int(7) NOT NULL,
  PRIMARY KEY (`closetid`,`clothesid`,`userid`),
  KEY `closetclothes` (`clothesid`),
  KEY `closetuser` (`userid`),
  CONSTRAINT `closetclothes` FOREIGN KEY (`clothesid`) REFERENCES `clothes` (`clothesid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `closetuser` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `styleid` int(7) NOT NULL ,
  `wearfrequency` int(5) DEFAULT NULL,
  `clothesid` int(7) NOT NULL auto_increment,
  `clothescolor` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `clothessize` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `season` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `categoryid` int(7) NOT NULL,
  `imageURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `likeability` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`clothesid`),
  KEY `clothes_big_category` (`categoryid`),
  CONSTRAINT `clothes_big_category` FOREIGN KEY (`categoryid`) REFERENCES `bigcategory` (`categoryid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int(7) NOT NULL auto_increment,
  `commenttime` datetime NOT NULL,
  `userid` int(8) NOT NULL,
  `outfitid` int(5) NOT NULL,
  PRIMARY KEY (`commentid`),
  KEY `commentuser` (`userid`),
  KEY `commentoutfit` (`outfitid`),
  CONSTRAINT `commentoutfit` FOREIGN KEY (`outfitid`) REFERENCES `outfit` (`outfitid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commentuser` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for figure
-- ----------------------------
DROP TABLE IF EXISTS `figure`;
CREATE TABLE `figure` (
  `figureid` int(11) NOT NULL auto_increment,
  `userhaircut` int(2) NOT NULL,
  `userskin_color` int(2) NOT NULL,
  `figureimage` varchar(255) NOT NULL,
  `chestcircumference` int(255) NOT NULL,
  `waistline` int(255) NOT NULL,
  `hipline` int(255) NOT NULL,
  `height` int(255) NOT NULL,
  `weight` int(255) NOT NULL,
  PRIMARY KEY (`figureid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for outfit
-- ----------------------------
DROP TABLE IF EXISTS `outfit`;
CREATE TABLE `outfit` (
  `userid` int(7) NOT NULL,
  `clothesid` int(7) NOT NULL,
  `outfitid` int(7) NOT NULL auto_increment,
  `likefrequency` int(4) NOT NULL,
  PRIMARY KEY (`outfitid`),
  KEY `outfituser` (`userid`),
  KEY `outfitclothes` (`clothesid`),
  CONSTRAINT `outfitclothes` FOREIGN KEY (`clothesid`) REFERENCES `clothes` (`clothesid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outfituser` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(7) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL,
  `usersex` tinyint(1) NOT NULL,
  `userbirthday` date DEFAULT NULL,
  `userphone` char(11) NOT NULL,
  `userimage` varchar(255) DEFAULT NULL,
  `userfigureid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `userfigure` (`userfigureid`),
  CONSTRAINT `userfigure` FOREIGN KEY (`userfigureid`) REFERENCES `figure` (`figureid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

