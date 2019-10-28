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
  `category_id` int(7) NOT NULL,
  `category_information` varchar(255) DEFAULT NULL,
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
  `closet_id` int(7) NOT NULL,
  `clothes_id` int(7) NOT NULL,
  `user_id` int(7) NOT NULL,
  PRIMARY KEY (`closet_id`,`clothes_id`,`user_id`),
  KEY `closet_clothes` (`clothes_id`),
  KEY `closet_user` (`user_id`),
  CONSTRAINT `closet_clothes` FOREIGN KEY (`clothes_id`) REFERENCES `clothes` (`clothes_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `closet_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `style_id` int(7) NOT NULL,
  `wear_frequency` int(5) DEFAULT NULL,
  `clothes_id` int(7) NOT NULL,
  `clothes_color` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `clothes_size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `season` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_id` int(7) NOT NULL,
  `image_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `likeability` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`clothes_id`),
  KEY `clothes_big_category` (`category_id`),
  CONSTRAINT `clothes_big_category` FOREIGN KEY (`category_id`) REFERENCES `big_category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `comment_id` int(7) NOT NULL,
  `comment_time` datetime NOT NULL,
  `user_id` int(8) NOT NULL,
  `outfit_id` int(5) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_user` (`user_id`),
  KEY `comment_outfit` (`outfit_id`),
  CONSTRAINT `comment_outfit` FOREIGN KEY (`outfit_id`) REFERENCES `outfit` (`outfit_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `figure_id` int(11) NOT NULL auto_increment,
  `user_haircut` int(2) NOT NULL,
  `user_skin_color` int(2) NOT NULL,
  `figure_image` varchar(255) NOT NULL,
  `chest_circumference` int(255) NOT NULL,
  `waistline` int(255) NOT NULL,
  `hipline` int(255) NOT NULL,
  `height` int(255) NOT NULL,
  `weight` int(255) NOT NULL,
  PRIMARY KEY (`figure_id`)
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
  `user_id` int(7) NOT NULL,
  `clothes_id` int(7) NOT NULL,
  `outfit_id` int(7) NOT NULL,
  `like_frequency` int(4) NOT NULL,
  PRIMARY KEY (`outfit_id`),
  KEY `outfit_user` (`user_id`),
  KEY `outfit_clothes` (`clothes_id`),
  CONSTRAINT `outfit_clothes` FOREIGN KEY (`clothes_id`) REFERENCES `clothes` (`clothes_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outfit_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `user_id` int(7) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_sex` tinyint(1) NOT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_phone` char(11) NOT NULL,
  `user_image` varchar(255) DEFAULT NULL,
  `user_figure_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_figure` (`user_figure_id`),
  CONSTRAINT `user_figure` FOREIGN KEY (`user_figure_id`) REFERENCES `figure` (`figure_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'rentianhe', '1', '1998-10-20', '18030302973', null, null);
INSERT INTO `user` VALUES ('2', 'wangzi', '1', '1999-01-01', '13344445555', null, null);
INSERT INTO `user` VALUES ('3', 'William', '2', '1999-10-22', '18160007000', null, null);
