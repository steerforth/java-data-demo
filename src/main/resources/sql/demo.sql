/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 127.0.0.1:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 08/09/2019 23:35:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_cart
-- ----------------------------
DROP TABLE IF EXISTS `app_cart`;
CREATE TABLE `app_cart` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `cart_num` int(11) DEFAULT NULL,
  `good_id` bigint(20) DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `true_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_cart
-- ----------------------------
BEGIN;
INSERT INTO `app_cart` VALUES (111, NULL, NULL, 3, 5, 0, 1, 70.5);
COMMIT;

-- ----------------------------
-- Table structure for app_coupon
-- ----------------------------
DROP TABLE IF EXISTS `app_coupon`;
CREATE TABLE `app_coupon` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `coupon_price` float DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `use_min_price` float DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `is_use` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_coupon
-- ----------------------------
BEGIN;
INSERT INTO `app_coupon` VALUES (1, NULL, NULL, '2019-09-05 17:02:52', 5, '2019-10-18 17:02:59', 0, 30, 1, b'0');
COMMIT;

-- ----------------------------
-- Table structure for app_good
-- ----------------------------
DROP TABLE IF EXISTS `app_good`;
CREATE TABLE `app_good` (
  `id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `ot_price` float DEFAULT NULL,
  `price` float NOT NULL,
  `sales` bigint(20) DEFAULT NULL,
  `status` smallint(6) NOT NULL,
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
BEGIN;
INSERT INTO `app_good` VALUES (1, 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', 1000, 888, 0, 0, 88, '促销品1', '件', NULL, NULL, NULL, b'1', b'0', b'0', b'0');
INSERT INTO `app_good` VALUES (2, 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', 1000, 666, 0, 0, 66, '促销品2', '件', NULL, '2019-09-06 15:52:27', '2019-09-06 15:52:30', b'1', b'0', b'0', b'0');
INSERT INTO `app_good` VALUES (3, 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', NULL, 666, NULL, 0, 100, '新商品1', '件', NULL, '2019-09-06 15:52:27', '2019-09-06 15:52:30', b'0', b'0', b'1', b'0');
INSERT INTO `app_good` VALUES (4, 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', NULL, 777, NULL, 0, 100, '新商品2', '件', NULL, '2019-09-06 15:52:27', '2019-09-06 15:52:30', b'0', b'0', b'1', b'0');
INSERT INTO `app_good` VALUES (5, 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', NULL, 777, NULL, 0, 100, '热门商品1', '件', NULL, '2019-09-06 15:52:27', '2019-09-06 15:52:30', b'0', b'0', b'0', b'1');
INSERT INTO `app_good` VALUES (6, 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', NULL, 565, NULL, 0, 100, '热门商品2', '件', NULL, '2019-09-06 15:52:27', '2019-09-06 15:52:30', b'0', b'0', b'0', b'1');
INSERT INTO `app_good` VALUES (7, 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', NULL, 787, NULL, 0, 100, '热门商品3', '件', NULL, '2019-09-06 15:52:27', '2019-09-06 15:52:30', b'0', b'0', b'0', b'1');
INSERT INTO `app_good` VALUES (8, 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', NULL, 787, 1000, 0, 100, '精品商品1', '件', 555, '2019-09-06 15:52:27', '2019-09-06 15:52:30', b'0', b'1', b'0', b'0');
INSERT INTO `app_good` VALUES (9, 'http://127.0.0.1:8000/demo/static/images/bast-2.jpeg', NULL, 787, 1000, 0, 100, '精品商品2', '件', 555, '2019-09-06 15:52:27', '2019-09-06 15:52:30', b'0', b'1', b'0', b'0');
COMMIT;

-- ----------------------------
-- Table structure for app_menu
-- ----------------------------
DROP TABLE IF EXISTS `app_menu`;
CREATE TABLE `app_menu` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_show` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_menu
-- ----------------------------
BEGIN;
INSERT INTO `app_menu` VALUES (1, '菜单1', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', 0, NULL, '1', NULL, NULL);
INSERT INTO `app_menu` VALUES (2, '菜单2', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', 0, NULL, '1', NULL, NULL);
INSERT INTO `app_menu` VALUES (3, '菜单3', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', 0, '', '1', NULL, NULL);
INSERT INTO `app_menu` VALUES (4, '菜单4', 'http://127.0.0.1:8000/demo/static/images/menu-2.jpeg', 0, '', '1', NULL, NULL);
INSERT INTO `app_menu` VALUES (5, '菜单5', 'http://127.0.0.1:8000/demo/static/images/menu-2.jpeg', 0, '', '1', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `gender` smallint(6) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `spread_code` bigint(20) DEFAULT NULL,
  `spread_spid` bigint(20) DEFAULT NULL,
  `unionid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', '2019-09-06 12:04:59', 'admin', '123456', '1', NULL, 0, '2019-09-06 12:05:07', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqmxLANU2J4hzibNO0p2OFsd8wMyHqHNuAyY0BMb4qUiaO5RcyEXRuzuqTBQMtXjicicvdzCNMUia9HnBA/132', NULL, NULL, 1, NULL, 'steer', NULL, NULL, 'oA7cI0aHhaVe9LVdFSOXDWlZtJIw', NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
