/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-09-06 17:07:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_coupon
-- ----------------------------
DROP TABLE IF EXISTS `app_coupon`;
CREATE TABLE `app_coupon` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `coupon_price` float DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `use_min_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_coupon
-- ----------------------------
INSERT INTO `app_coupon` VALUES ('1', null, null, '2019-09-05 17:02:52', '5', '2019-10-18 17:02:59', '0', '30');

-- ----------------------------
-- Table structure for app_good
-- ----------------------------
DROP TABLE IF EXISTS `app_good`;
CREATE TABLE `app_good` (
  `id` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `ot_price` float DEFAULT NULL,
  `price` float NOT NULL,
  `sales` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `stock` bigint(20) NOT NULL,
  `store_name` varchar(255) DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL,
  `vip_price` float DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `benefit` bit(1) NOT NULL,
  `bast` bit(1) NOT NULL,
  `first` bit(1) NOT NULL,
  `hot` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_good
-- ----------------------------
INSERT INTO `app_good` VALUES ('1', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', '1000', '888', '0', '0', '88', '促销品1', '件', null, null, null, '', '\0', '\0', '\0');
INSERT INTO `app_good` VALUES ('2', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', '1000', '666', '0', '0', '66', '促销品2', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '', '\0', '\0', '\0');
INSERT INTO `app_good` VALUES ('3', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '666', null, '0', '100', '新商品1', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '', '\0');
INSERT INTO `app_good` VALUES ('4', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '777', null, '0', '100', '新商品2', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '', '\0');
INSERT INTO `app_good` VALUES ('5', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '777', null, '0', '100', '热门商品1', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '\0', '');
INSERT INTO `app_good` VALUES ('6', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '565', null, '0', '100', '热门商品2', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '\0', '');
INSERT INTO `app_good` VALUES ('7', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '787', null, '0', '100', '热门商品3', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '\0', '');
INSERT INTO `app_good` VALUES ('8', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '787', '1000', '0', '100', '精品商品1', '件', '555', '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '', '\0', '\0');
INSERT INTO `app_good` VALUES ('9', 'http://127.0.0.1:8000/demo/static/images/bast-2.jpeg', null, '787', '1000', '0', '100', '精品商品2', '件', '555', '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '', '\0', '\0');

-- ----------------------------
-- Table structure for app_menu
-- ----------------------------
DROP TABLE IF EXISTS `app_menu`;
CREATE TABLE `app_menu` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_show` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_menu
-- ----------------------------
INSERT INTO `app_menu` VALUES ('1', '菜单1', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', '0', null, '1', null, null);
INSERT INTO `app_menu` VALUES ('2', '菜单2', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', '0', null, '1', null, null);
INSERT INTO `app_menu` VALUES ('3', '菜单3', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', '0', '', '1', null, null);
INSERT INTO `app_menu` VALUES ('4', '菜单4', 'http://127.0.0.1:8000/demo/static/images/menu-2.jpeg', '0', '', '1', null, null);
INSERT INTO `app_menu` VALUES ('5', '菜单5', 'http://127.0.0.1:8000/demo/static/images/menu-2.jpeg', '0', '', '1', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(255) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '2019-09-06 12:04:59', 'admin', '123456', '1', null, '0', '2019-09-06 12:05:07');