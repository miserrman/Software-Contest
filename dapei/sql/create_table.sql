/*
Navicat MySQL Data Transfer

Source Server         : inter_DB
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : inter

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2019-10-28 16:41:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for big_category
-- ----------------------------
DROP TABLE IF EXISTS `big_category`;
CREATE TABLE `big_category` (
  `category_id` int(7) NOT NULL auto_increment,
  `category_information` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of big_category
-- ----------------------------

-- ----------------------------
-- Table structure for closet
-- ----------------------------
DROP TABLE IF EXISTS `closet`;
CREATE TABLE `closet` (
  `closet_id` int(7) NOT NULL auto_increment,
  `clothes_id` int(7) NOT NULL ,
  `user_id` int(7) NOT NULL ,
  PRIMARY KEY (`closet_id`),
  KEY `closet_clothes` (`clothes_id`),
  KEY `closet_user` (`user_id`),
  CONSTRAINT `closet_clothes` FOREIGN KEY (`clothes_id`) REFERENCES `clothes` (`clothes_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `closet_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of closet
-- ----------------------------

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `style_id` int(7) NOT NULL ,
  `wear_frequency` int(5) DEFAULT NULL,
  `clothes_id` int(7) NOT NULL auto_increment,
  `clothes_color` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `clothes_size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `season` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_id` int(7) NOT NULL auto_increment,
  `image_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `likeability` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`clothes_id`),
  KEY `clothes_big_category` (`category_id`),
  CONSTRAINT `clothes_big_category` FOREIGN KEY (`category_id`) REFERENCES `big_category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(7) NOT NULL auto_increment,
  `comment_time` datetime NOT NULL,
  `user_id` int(8) NOT NULL,
  `outfit_id` int(5) NOT NULL ,
  PRIMARY KEY (`comment_id`),
  KEY `comment_user` (`user_id`),
  KEY `comment_outfit` (`outfit_id`),
  CONSTRAINT `comment_outfit` FOREIGN KEY (`outfit_id`) REFERENCES `outfit` (`outfit_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for outfit
-- ----------------------------
DROP TABLE IF EXISTS `outfit`;
CREATE TABLE `outfit` (
  `user_id` int(7) NOT NULL ,
  `clothes_id` int(7) NOT NULL ,
  `outfit_id` int(7) NOT NULL auto_increment,
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

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(7) NOT NULL auto_increment,
  `user_name` varchar(20) NOT NULL,
  `user_sex` tinyint(1) NOT NULL,
  `user_birthday` date NOT NULL,
  `user_phone` char(11) NOT NULL,
  `user_image` varchar(255) DEFAULT NULL,
  `user_haircut` int(2) DEFAULT NULL,
  `user_skin_color` int(2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
