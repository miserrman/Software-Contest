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
  PRIMARY KEY (`closetid`),
  PRIMARY KEY (`clothesid`, `userid`),
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
  `styleid` int(7),
  `wearfrequency` int(5) DEFAULT NULL,
  `clothesid` int(7) NOT NULL auto_increment,
  `clothescolor` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `clothessize` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `season` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `categoryid` int(7),
  `imageURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `likeability` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userid` int(7) NOT NULL,
  PRIMARY KEY (`clothesid`),
  KEY `clothes_big_category` (`categoryid`),
  CONSTRAINT `user_cloth` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
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
  `userhaircut` int(2),
  `userskincolor` int(2),
  `figureimage` varchar(255),
  `chestcircumference` int(255),
  `waistline` int(255),
  `hipline` int(255),
  `height` int(255),
  `weight` int(255),
  PRIMARY KEY (`figureid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for outfit
-- ----------------------------
DROP TABLE IF EXISTS `outfit`;
CREATE TABLE `outfit` (
  `userid` int(7) NOT NULL,
  `outfitid` int(7) NOT NULL auto_increment,
  `likefrequency` int(4) NOT NULL,
  PRIMARY KEY (`outfitid`),
  KEY `outfituser` (`userid`),
  CONSTRAINT `outfituser` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(7) NOT NULL auto_increment,
  `username` varchar(20),
  `usersex` tinyint(1),
  `userbirthday` date DEFAULT NULL,
  `userphone` char(11),
  `userimage` varchar(255) DEFAULT NULL,
  `userfigureid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `userfigure` (`userfigureid`),
  CONSTRAINT `userfigure` FOREIGN KEY (`userfigureid`) REFERENCES `figure` (`figureid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `intooutfit` (
  `clothesid` int(7) NOT NULL,
  `outfitid` int(7) NOT NULL,
  PRIMARY KEY (`clothesid`,`outfitid`),
  KEY `outfitid` (`outfitid`),
  CONSTRAINT `clothesid` FOREIGN KEY (`clothesid`) REFERENCES `clothes` (`clothesid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outfitid` FOREIGN KEY (`outfitid`) REFERENCES `outfit` (`outfitid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `collect` (
  `collectid` int(7) NOT NULL auto_increment,
  `userid` int(7) NOT NULL,
  `outfitid` int(7) NOT NULL,
  PRIMARY KEY (`collectid`),
  KEY `userid` (`userid`),
  KEY `Outfitid2` (`outfitid`),
  CONSTRAINT `Outfitid2` FOREIGN KEY (`outfitid`) REFERENCES `outfit` (`outfitid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



