/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : multiplechoice

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-10-15 22:02:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for it_category_news
-- ----------------------------
DROP TABLE IF EXISTS `it_category_news`;
CREATE TABLE `it_category_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `sort_order` int(3) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL,
  `date_added` datetime NOT NULL,
  `date_modified` datetime NOT NULL,
  `meta_title` varchar(255) DEFAULT NULL,
  `meta_description` varchar(255) DEFAULT NULL,
  `meta_keyword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=MyISAM AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of it_category_news
-- ----------------------------

-- ----------------------------
-- Table structure for it_news
-- ----------------------------
DROP TABLE IF EXISTS `it_news`;
CREATE TABLE `it_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `tag` text,
  `date_available` date NOT NULL DEFAULT '0000-00-00',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `viewed` int(5) NOT NULL DEFAULT '0',
  `date_added` datetime NOT NULL,
  `date_modified` datetime NOT NULL,
  `meta_title` varchar(255) DEFAULT NULL,
  `meta_description` varchar(255) DEFAULT NULL,
  `meta_keyword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of it_news
-- ----------------------------

-- ----------------------------
-- Table structure for it_pages
-- ----------------------------
DROP TABLE IF EXISTS `it_pages`;
CREATE TABLE `it_pages` (
  `id` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `date_available` datetime NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `viewed` int(5) DEFAULT NULL,
  `date_added` datetime NOT NULL,
  `date_modified` datetime NOT NULL,
  `meta_title` varchar(255) DEFAULT NULL,
  `meta_description` varchar(255) DEFAULT NULL,
  `meta_keyword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of it_pages
-- ----------------------------

-- ----------------------------
-- Table structure for it_user
-- ----------------------------
DROP TABLE IF EXISTS `it_user`;
CREATE TABLE `it_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of it_user
-- ----------------------------
INSERT INTO `it_user` VALUES ('1', 'admin', '123456', 'tuyentvbg@gmail.com', '123456');
INSERT INTO `it_user` VALUES ('2', 'kenshin', '123456', 'tuyen@gmail.com', '1234567890');
