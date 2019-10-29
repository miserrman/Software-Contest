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
DROP TABLE IF EXISTS `big_category`;
CREATE TABLE `big_category` (
  `categoryid` int(7) NOT NULL,
  `categoryinformation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of big_category
-- ----------------------------
INSERT INTO `big_category` VALUES ('1', 'I like it very much');
INSERT INTO `big_category` VALUES ('2', 'I hate it');
INSERT INTO `big_category` VALUES ('3', 'I have no ideas about it');

-- ----------------------------
-- Table structure for closet
-- ----------------------------
DROP TABLE IF EXISTS `closet`;
CREATE TABLE `closet` (
  `closetid` int(7) NOT NULL,
  `clothesid` int(7) NOT NULL,
  `userid` int(7) NOT NULL,
  PRIMARY KEY (`closetid`,`clothesid`,`userid`),
  KEY `closetclothes` (`clothesid`),
  KEY `closetuser` (`userid`),
  CONSTRAINT `closetclothes` FOREIGN KEY (`clothesid`) REFERENCES `clothes` (`clothesid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `closetuser` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of closet
-- ----------------------------
INSERT INTO `closet` VALUES ('1', '1', '2');
INSERT INTO `closet` VALUES ('1', '2', '2');
INSERT INTO `closet` VALUES ('1', '3', '2');

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `styleid` int(7) NOT NULL,
  `wearfrequency` int(5) DEFAULT NULL,
  `clothesid` int(7) NOT NULL,
  `clothescolor` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `clothessize` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `season` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `categoryid` int(7) NOT NULL,
  `imageURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `likeability` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`clothes_id`),
  KEY `clothes_big_category` (`categoryid`),
  CONSTRAINT `clothes_big_category` FOREIGN KEY (`categoryid`) REFERENCES `big_category` (`categoryid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES ('1', '2', '1', 'blue', 'XXXL', 'spring', '1', null, '22');
INSERT INTO `clothes` VALUES ('2', '10', '2', 'red', 'XXL', 'autumn', '2', null, '13');
INSERT INTO `clothes` VALUES ('3', '5', '3', 'green', 'M', 'winter', '3', null, '35');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int(7) NOT NULL,
  `commenttime` datetime NOT NULL,
  `userid` int(8) NOT NULL,
  `outfitid` int(5) NOT NULL,
  PRIMARY KEY (`commentid`),
  KEY `comment_user` (`userid`),
  KEY `comment_outfit` (`outfitid`),
  CONSTRAINT `comment_outfit` FOREIGN KEY (`outfitid`) REFERENCES `outfit` (`outfitid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '2019-10-28 23:22:50', '1', '1');
INSERT INTO `comment` VALUES ('2', '2019-10-28 23:23:12', '2', '2');

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
-- Records of figure
-- ----------------------------
INSERT INTO `figure` VALUES ('1', '2', '2', 'xxxxx.URL', '80', '80', '80', '180', '160');
INSERT INTO `figure` VALUES ('2', '1', '1', 'blabla.URL', '90', '90', '90', '195', '190');

-- ----------------------------
-- Table structure for outfit
-- ----------------------------
DROP TABLE IF EXISTS `outfit`;
CREATE TABLE `outfit` (
  `userid` int(7) NOT NULL,
  `clothesid` int(7) NOT NULL,
  `outfitid` int(7) NOT NULL,
  `likefrequency` int(4) NOT NULL,
  PRIMARY KEY (`outfitid`),
  KEY `outfit_user` (`userid`),
  KEY `outfit_clothes` (`clothesid`),
  CONSTRAINT `outfit_clothes` FOREIGN KEY (`clothesid`) REFERENCES `clothes` (`clothesid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outfit_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outfit
-- ----------------------------
INSERT INTO `outfit` VALUES ('1', '1', '1', '1');
INSERT INTO `outfit` VALUES ('2', '3', '2', '13');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(7) NOT NULL,
  `username` varchar(20) NOT NULL,
  `usersex` tinyint(1) NOT NULL,
  `userbirthday` date DEFAULT NULL,
  `userphone` char(11) NOT NULL,
  `userimage` varchar(255) DEFAULT NULL,
  `userfigureid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `user_figure` (`userfigureid`),
  CONSTRAINT `user_figure` FOREIGN KEY (`userfigureid`) REFERENCES `figure` (`figureid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'rentianhe', '1', '1998-10-20', '18030302973', null, null);
INSERT INTO `user` VALUES ('2', 'wangzi', '1', '1999-01-01', '13344445555', null, null);
INSERT INTO `user` VALUES ('3', 'William', '2', '1999-10-22', '18160007000', null, null);
