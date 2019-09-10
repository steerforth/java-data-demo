/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-09-10 20:09:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_attr_info
-- ----------------------------
DROP TABLE IF EXISTS `app_attr_info`;
CREATE TABLE `app_attr_info` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `cost` float NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `sales` int(11) NOT NULL,
  `status` smallint(6) NOT NULL,
  `stock` int(11) NOT NULL,
  `suk` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_attr_info
-- ----------------------------
INSERT INTO `app_attr_info` VALUES ('1', null, null, '111', null, '50', '5', '0', '0', '1555', '绝美的好东西');

-- ----------------------------
-- Table structure for app_cart
-- ----------------------------
DROP TABLE IF EXISTS `app_cart`;
CREATE TABLE `app_cart` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `cart_num` int(11) DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `true_price` float DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_cart
-- ----------------------------
INSERT INTO `app_cart` VALUES ('111', null, null, '3', '0', '1', '70.5', '5');

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
INSERT INTO `app_coupon` VALUES ('1', null, null, '2019-09-05 17:02:52', '5', '2019-10-18 17:02:59', '0', '30', '1', '\0');

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
  `description` varchar(255) DEFAULT NULL,
  `give_integral` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_good
-- ----------------------------
INSERT INTO `app_good` VALUES ('1', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', '1000', '888', '0', '0', '88', '促销品1', '件', null, null, null, '', '\0', '\0', '\0', null, null);
INSERT INTO `app_good` VALUES ('2', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', '1000', '666', '0', '0', '66', '促销品2', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '', '\0', '\0', '\0', null, null);
INSERT INTO `app_good` VALUES ('3', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '666', null, '0', '100', '新商品1', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '', '\0', null, null);
INSERT INTO `app_good` VALUES ('4', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '777', null, '0', '100', '新商品2', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '', '\0', null, null);
INSERT INTO `app_good` VALUES ('5', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', '1111', '777', '500', '0', '100', '热门商品1', '件', '444', '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '\0', '', '<li>我是详细的产品描述信息</li><li>1.这个商品有很多的优点哦</li><img src=\"http://127.0.0.1:8000/demo/static/images/detail-1.jpeg\" /><img src=\"http://127.0.0.1:8000/demo/static/images/detail-2.jpeg\" />', '50');
INSERT INTO `app_good` VALUES ('6', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '565', null, '0', '100', '热门商品2', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '\0', '', null, null);
INSERT INTO `app_good` VALUES ('7', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '787', null, '0', '100', '热门商品3', '件', null, '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '\0', '\0', '', null, null);
INSERT INTO `app_good` VALUES ('8', 'http://127.0.0.1:8000/demo/static/images/bast-1.jpeg', null, '787', '1000', '0', '100', '精品商品1', '件', '555', '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '', '\0', '\0', null, null);
INSERT INTO `app_good` VALUES ('9', 'http://127.0.0.1:8000/demo/static/images/bast-2.jpeg', null, '787', '1000', '0', '100', '精品商品2', '件', '555', '2019-09-06 15:52:27', '2019-09-06 15:52:30', '\0', '', '\0', '\0', null, null);

-- ----------------------------
-- Table structure for app_good_detail
-- ----------------------------
DROP TABLE IF EXISTS `app_good_detail`;
CREATE TABLE `app_good_detail` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `good_id` varchar(255) DEFAULT NULL,
  `price_name` varchar(255) DEFAULT NULL,
  `reply_count` int(11) DEFAULT NULL,
  `reply_chance` smallint(6) DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_good_detail
-- ----------------------------
INSERT INTO `app_good_detail` VALUES ('1', null, null, '5', '30', '2', '98', '0');

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
INSERT INTO `app_menu` VALUES ('1', '菜单1', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', '0', null, '1', null, null);
INSERT INTO `app_menu` VALUES ('2', '菜单2', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', '0', null, '1', null, null);
INSERT INTO `app_menu` VALUES ('3', '菜单3', 'http://127.0.0.1:8000/demo/static/images/menu-1.jpeg', '0', '', '1', null, null);
INSERT INTO `app_menu` VALUES ('4', '菜单4', 'http://127.0.0.1:8000/demo/static/images/menu-2.jpeg', '0', '', '1', null, null);
INSERT INTO `app_menu` VALUES ('5', '菜单5', 'http://127.0.0.1:8000/demo/static/images/menu-2.jpeg', '0', '', '1', null, null);

-- ----------------------------
-- Table structure for app_reply
-- ----------------------------
DROP TABLE IF EXISTS `app_reply`;
CREATE TABLE `app_reply` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `good_detail_id` varchar(255) DEFAULT NULL,
  `merchant_reply_content` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `star` smallint(6) NOT NULL,
  `status` smallint(6) NOT NULL,
  `suk` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_reply
-- ----------------------------
INSERT INTO `app_reply` VALUES ('1', null, null, '2019-09-09 21:35:29', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqmxLANU2J4hzibNO0p2OFsd8wMyHqHNuAyY0BMb4qUiaO5RcyEXRuzuqTBQMtXjicicvdzCNMUia9HnBA/132', '很好不错', '1', '谢谢！', 'test1', '3', '0', 'ggg');
INSERT INTO `app_reply` VALUES ('2', null, null, '2019-09-17 21:35:29', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqmxLANU2J4hzibNO0p2OFsd8wMyHqHNuAyY0BMb4qUiaO5RcyEXRuzuqTBQMtXjicicvdzCNMUia9HnBA/132', '好评哦', '1', '谢谢！您的支持', 'test2', '5', '0', 'ffff');

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
  `is_promoter` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '2019-09-06 12:04:59', 'admin', '123456', '1', null, '0', '2019-09-06 12:05:07', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqmxLANU2J4hzibNO0p2OFsd8wMyHqHNuAyY0BMb4qUiaO5RcyEXRuzuqTBQMtXjicicvdzCNMUia9HnBA/132', null, null, '1', null, 'steer', null, null, 'oA7cI0aHhaVe9LVdFSOXDWlZtJIw', null, null, null, '');
