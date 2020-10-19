/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : emall

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 19/10/2020 19:57:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES (1, 'admin', '202cb962ac59075b964b07152d234b70');
INSERT INTO `admins` VALUES (5, '777', '202cb962ac59075b964b07152d234b70');

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
  `good_id` int(11) NOT NULL COMMENT '商品ID',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of carts
-- ----------------------------
INSERT INTO `carts` VALUES (6, 1, 6, 3);
INSERT INTO `carts` VALUES (12, 2, 1, 3);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `spec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '价格',
  `stock` int(11) NOT NULL DEFAULT 0 COMMENT '库存',
  `sales` int(11) NOT NULL DEFAULT 0 COMMENT '销量',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情',
  `type_id` int(11) NOT NULL DEFAULT 0 COMMENT '分类ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '../upload/1-1.jpg', '四川耙耙柑 酸甜甘香 柔嫩多汁', '皮薄易剥 肉质软嫩', '约500g', 13, 1, 15, '', 1);
INSERT INTO `goods` VALUES (2, '../upload/1-2.jpg', '红心火龙果', NULL, '750g-1kg/两个', 28, 10, 2, '', 1);
INSERT INTO `goods` VALUES (3, '../upload/1-3.jpg', '皇冠梨 松软多汁', '果肉甘甜 细腻无渣', '约500g', 9, 10, 3, '', 1);
INSERT INTO `goods` VALUES (4, '../upload/1-4.jpg', '西州蜜瓜', '果肉厚质 中心橘红', '约1kg-1.5kg 一个', 30, 9, 5, '', 1);
INSERT INTO `goods` VALUES (5, '../upload/1-5.jpg', '小台芒果 自然生长 生态种植', '皮薄核小 果肉丰厚', '约500g', 26, 8, 7, '', 1);
INSERT INTO `goods` VALUES (6, '../upload/1-6.jpg', '栖霞苹果 爽脆清甜', '肉质紧密 味道甘甜', '约550g/2个', 9, 2, 14, '', 1);
INSERT INTO `goods` VALUES (7, '../upload/1-7.jpg', '龙眼/桂圆 新鲜水果 汁多味甜', '增强记忆 消除疲劳', '约500g', 18, 10, 7, '', 1);
INSERT INTO `goods` VALUES (8, '../upload/1-8.jpg', '广西百香果 香气浓郁 甜酸可口', '果香浓郁 搭配蜂蜜更美味', '2颗/份', 5, 10, 8, '', 1);
INSERT INTO `goods` VALUES (9, '../upload/1-9.jpg', '美早樱桃 果大核小 饱满均匀', '堪比车厘子的美味', '约300g/盒', 36, 10, 9, '', 1);
INSERT INTO `goods` VALUES (10, '../upload/1-10.jpg', '智利红提 珍贵品种 品质上等', '紧实爆汁 果肉新鲜', '约500g', 18, 10, 10, '', 1);
INSERT INTO `goods` VALUES (11, '../upload/1-11.jpg', '尖椒 烧烤食材 新鲜蔬菜', '农家种植 健康饮食', '约300g', 5, 10, 0, '', 1);
INSERT INTO `goods` VALUES (12, '../upload/1-12.jpg', '荷兰瓜 生态种植 自然生长', '颜色翠绿，鲜嫩爽脆', '约300g', 5, 10, 0, '', 1);
INSERT INTO `goods` VALUES (13, '../upload/1-13.jpg', '小白菜 清脆鲜嫩 清甜回甘', '农家种植 找回儿时味道', '约500g', 10, 10, 0, '', 1);
INSERT INTO `goods` VALUES (14, '../upload/1-14.jpg', '菠菜 口感鲜嫩 入口清香', '不催熟 生长周期长', '约300g', 12, 10, 0, '', 1);
INSERT INTO `goods` VALUES (15, '../upload/2-1.jpg', '福成尚品前腱子', NULL, '1000g', 99, 10, 0, '', 2);
INSERT INTO `goods` VALUES (16, '../upload/2-2.jpg', '牦牛精肉2斤+ 牦牛肋排2斤', '自然生长', '2kg', 226, 10, 0, '', 2);
INSERT INTO `goods` VALUES (17, '../upload/2-3.jpg', '巴美草香猪后臀尖 原味原香', '精致美味，解锁味觉记忆', '约500g', 32, 10, 0, '', 2);
INSERT INTO `goods` VALUES (18, '../upload/2-4.jpg', '农畉猪肉-猪脊骨 肉厚骨细', '骨鲜髓足', '约500g', 13, 10, 0, '', 2);
INSERT INTO `goods` VALUES (19, '../upload/2-5.jpg', '一品江村黄鸡', '味道鲜美，口感软嫩弹滑', '约1kg', 46, 10, 0, '', 2);
INSERT INTO `goods` VALUES (20, '../upload/2-6.jpg', '正大单冻鸡翅根 精选种鸡', '富有弹性', '约1kg', 35, 10, 0, '', 2);
INSERT INTO `goods` VALUES (21, '../upload/3-1.jpg', '五梁红有机种植 大米', '五常市有机大米', '5kg', 68, 10, 0, '', 3);
INSERT INTO `goods` VALUES (22, '../upload/3-2.jpg', '五常大米珠光黄', NULL, '5kg', 60, 10, 0, '', 3);
INSERT INTO `goods` VALUES (23, '../upload/3-3.jpg', '五得利强筋雪花小麦粉', NULL, '2.5kg', 32, 10, 0, '', 3);
INSERT INTO `goods` VALUES (24, '../upload/3-4.jpg', '香满园美味富强小麦粉', NULL, '5kg', 21, 10, 0, '', 3);
INSERT INTO `goods` VALUES (25, '../upload/3-5.jpg', '老农帝国 黑豆 自然成熟', NULL, '2.5kg', 82, 10, 0, '', 3);
INSERT INTO `goods` VALUES (26, '../upload/3-6.jpg', '中畅佳禾 大麦 自然生长', NULL, '400g', 59, 10, 0, '', 3);
INSERT INTO `goods` VALUES (27, '../upload/4-1.jpg', '百威啤酒 经典灌装 小麦醇正拉罐', NULL, '500ml*3', 26, 9, 0, '', 4);
INSERT INTO `goods` VALUES (28, '../upload/4-2.jpg', 'Perrier巴黎水天然含气矿泉水 开启生活新方式', '天然气泡', '330ml', 9, 10, 0, '', 4);
INSERT INTO `goods` VALUES (29, '../upload/4-3.jpg', '吉吉黑糖', NULL, '玫瑰花味180g', 23, 9, 1, '', 4);
INSERT INTO `goods` VALUES (30, '../upload/4-4.jpg', '北冰洋汽水', '桔汁汽水330ml', NULL, 5, 10, 0, '', 4);
INSERT INTO `goods` VALUES (31, '../upload/4-5.jpg', '每日C葡萄柚汁', NULL, '300ml', 6, 10, 0, '', 4);
INSERT INTO `goods` VALUES (32, '../upload/4-6.jpg', '即品坚果 台湾甄选 颗颗饱满', '留存水果本真 有滋有味', '56g', 12, 8, 2, '', 4);
INSERT INTO `goods` VALUES (34, '../upload/9491a56b-7fa0-4708-85a8-c49d3314bea0.jpg', '嘻嘻', '嘻嘻', '嘻嘻', 999999, 1, 0, '嘻嘻', 5);
INSERT INTO `goods` VALUES (35, '../upload/87338d5f-1620-47a9-977d-9083086ecf8d.jpg', '测试', '测试', '测试', 9999999, 1, 0, '测试', 5);

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '购买时价格',
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '购买数量',
  `order_id` int(11) NOT NULL DEFAULT 0 COMMENT '订单ID',
  `good_id` int(11) NOT NULL DEFAULT 0 COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单项' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES (1, 26, 1, 1, 5);
INSERT INTO `items` VALUES (2, 30, 1, 1, 4);
INSERT INTO `items` VALUES (3, 13, 1, 1, 1);
INSERT INTO `items` VALUES (4, 23, 1, 2, 29);
INSERT INTO `items` VALUES (5, 12, 2, 3, 32);
INSERT INTO `items` VALUES (6, 9, 2, 4, 6);
INSERT INTO `items` VALUES (7, 26, 1, 4, 5);
INSERT INTO `items` VALUES (8, 9, 4, 5, 6);
INSERT INTO `items` VALUES (9, 26, 5, 16, 5);
INSERT INTO `items` VALUES (10, 18, 2, 16, 10);
INSERT INTO `items` VALUES (11, 9, 4, 16, 6);
INSERT INTO `items` VALUES (12, 10, 9, 16, 13);
INSERT INTO `items` VALUES (13, 13, 1, 16, 1);
INSERT INTO `items` VALUES (14, 226, 2, 16, 16);
INSERT INTO `items` VALUES (15, 32, 1, 16, 23);
INSERT INTO `items` VALUES (16, 32, 1, 16, 17);
INSERT INTO `items` VALUES (17, 28, 2, 16, 2);
INSERT INTO `items` VALUES (18, 9, 2, 16, 3);
INSERT INTO `items` VALUES (19, 30, 1, 16, 4);
INSERT INTO `items` VALUES (20, 46, 2, 16, 19);
INSERT INTO `items` VALUES (21, 26, 5, 17, 5);
INSERT INTO `items` VALUES (22, 18, 2, 17, 10);
INSERT INTO `items` VALUES (23, 9, 4, 17, 6);
INSERT INTO `items` VALUES (24, 10, 9, 17, 13);
INSERT INTO `items` VALUES (25, 13, 1, 17, 1);
INSERT INTO `items` VALUES (26, 226, 2, 17, 16);
INSERT INTO `items` VALUES (27, 32, 1, 17, 23);
INSERT INTO `items` VALUES (28, 32, 1, 17, 17);
INSERT INTO `items` VALUES (29, 28, 2, 17, 2);
INSERT INTO `items` VALUES (30, 9, 2, 17, 3);
INSERT INTO `items` VALUES (31, 30, 1, 17, 4);
INSERT INTO `items` VALUES (32, 46, 2, 17, 19);
INSERT INTO `items` VALUES (33, 26, 5, 18, 5);
INSERT INTO `items` VALUES (34, 18, 2, 18, 10);
INSERT INTO `items` VALUES (35, 9, 4, 18, 6);
INSERT INTO `items` VALUES (36, 10, 9, 18, 13);
INSERT INTO `items` VALUES (37, 13, 1, 18, 1);
INSERT INTO `items` VALUES (38, 226, 2, 18, 16);
INSERT INTO `items` VALUES (39, 32, 1, 18, 23);
INSERT INTO `items` VALUES (40, 32, 1, 18, 17);
INSERT INTO `items` VALUES (41, 28, 2, 18, 2);
INSERT INTO `items` VALUES (42, 9, 2, 18, 3);
INSERT INTO `items` VALUES (43, 30, 1, 18, 4);
INSERT INTO `items` VALUES (44, 46, 2, 18, 19);
INSERT INTO `items` VALUES (45, 26, 5, 19, 5);
INSERT INTO `items` VALUES (46, 18, 2, 19, 10);
INSERT INTO `items` VALUES (47, 9, 4, 19, 6);
INSERT INTO `items` VALUES (48, 10, 9, 19, 13);
INSERT INTO `items` VALUES (49, 13, 1, 19, 1);
INSERT INTO `items` VALUES (50, 226, 2, 19, 16);
INSERT INTO `items` VALUES (51, 32, 1, 19, 23);
INSERT INTO `items` VALUES (52, 32, 1, 19, 17);
INSERT INTO `items` VALUES (53, 28, 2, 19, 2);
INSERT INTO `items` VALUES (54, 9, 2, 19, 3);
INSERT INTO `items` VALUES (55, 30, 1, 19, 4);
INSERT INTO `items` VALUES (56, 46, 2, 19, 19);
INSERT INTO `items` VALUES (57, 26, 4, 20, 5);
INSERT INTO `items` VALUES (58, 10, 9, 20, 13);
INSERT INTO `items` VALUES (59, 30, 1, 20, 4);
INSERT INTO `items` VALUES (60, 28, 2, 20, 2);
INSERT INTO `items` VALUES (61, 26, 5, 21, 5);
INSERT INTO `items` VALUES (62, 18, 2, 21, 10);
INSERT INTO `items` VALUES (63, 9, 4, 21, 6);
INSERT INTO `items` VALUES (64, 10, 9, 21, 13);
INSERT INTO `items` VALUES (65, 13, 1, 21, 1);
INSERT INTO `items` VALUES (66, 226, 2, 21, 16);
INSERT INTO `items` VALUES (67, 32, 1, 21, 23);
INSERT INTO `items` VALUES (68, 32, 1, 21, 17);
INSERT INTO `items` VALUES (69, 28, 2, 21, 2);
INSERT INTO `items` VALUES (70, 9, 2, 21, 3);
INSERT INTO `items` VALUES (71, 30, 1, 21, 4);
INSERT INTO `items` VALUES (72, 46, 2, 21, 19);
INSERT INTO `items` VALUES (73, 28, 1, 22, 2);
INSERT INTO `items` VALUES (74, 9, 1, 23, 6);
INSERT INTO `items` VALUES (75, 28, 1, 24, 2);
INSERT INTO `items` VALUES (76, 9, 1, 24, 3);
INSERT INTO `items` VALUES (77, 28, 1, 25, 2);
INSERT INTO `items` VALUES (78, 28, 1, 26, 2);
INSERT INTO `items` VALUES (79, 18, 1, 27, 7);
INSERT INTO `items` VALUES (80, 5, 1, 28, 8);
INSERT INTO `items` VALUES (81, 28, 1, 29, 2);
INSERT INTO `items` VALUES (82, 46, 1, 30, 19);
INSERT INTO `items` VALUES (83, 12, 1, 31, 32);
INSERT INTO `items` VALUES (84, 9, 1, 32, 28);
INSERT INTO `items` VALUES (85, 5, 1, 33, 30);
INSERT INTO `items` VALUES (86, 30, 1, 34, 4);
INSERT INTO `items` VALUES (87, 26, 1, 35, 27);
INSERT INTO `items` VALUES (88, 6, 1, 36, 31);
INSERT INTO `items` VALUES (89, 26, 1, 37, 5);
INSERT INTO `items` VALUES (90, 28, 1, 38, 2);
INSERT INTO `items` VALUES (91, 9, 1, 38, 3);
INSERT INTO `items` VALUES (92, 30, 1, 38, 4);
INSERT INTO `items` VALUES (93, 32, 1, 38, 17);
INSERT INTO `items` VALUES (94, 13, 1, 38, 1);
INSERT INTO `items` VALUES (95, 26, 2, 38, 5);
INSERT INTO `items` VALUES (96, 9, 1, 39, 3);
INSERT INTO `items` VALUES (97, 30, 1, 39, 4);
INSERT INTO `items` VALUES (98, 13, 1, 40, 1);
INSERT INTO `items` VALUES (99, 13, 3, 41, 1);
INSERT INTO `items` VALUES (100, 9, 2, 42, 6);
INSERT INTO `items` VALUES (101, 13, 2, 43, 1);
INSERT INTO `items` VALUES (102, 13, 2, 44, 1);
INSERT INTO `items` VALUES (103, 13, 2, 45, 1);
INSERT INTO `items` VALUES (104, 13, 2, 46, 1);
INSERT INTO `items` VALUES (105, 13, 2, 47, 1);
INSERT INTO `items` VALUES (106, 26, 1, 48, 27);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `total` int(11) NOT NULL DEFAULT 0 COMMENT '订单金额',
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '商品总数',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态(1未付款/2已付款/3已发货/4已完成)',
  `paytype` tinyint(4) NOT NULL DEFAULT 0 COMMENT '支付方式 (1微信/2支付宝)',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `systime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '下单时间',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '下单用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 69, 3, 3, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-09-21 23:55:15', 1);
INSERT INTO `orders` VALUES (2, 23, 1, 4, 2, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-25 15:54:33', 1);
INSERT INTO `orders` VALUES (3, 24, 1, 2, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-25 16:22:39', 1);
INSERT INTO `orders` VALUES (4, 44, 2, 2, 1, '张三', '13311112222', 'aaa', '2020-05-29 10:38:19', 5);
INSERT INTO `orders` VALUES (5, 36, 1, 4, 2, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-29 14:13:39', 1);
INSERT INTO `orders` VALUES (35, 26, 1, 3, 2, '嘻嘻', '123987', '深圳市福田区', '2020-09-24 11:25:20', 1);
INSERT INTO `orders` VALUES (36, 6, 1, 3, 1, '嘻嘻', '123987', '深圳市福田区', '2020-09-24 11:26:00', 1);
INSERT INTO `orders` VALUES (37, 26, 1, 3, 1, '嘻嘻', '123987', '深圳市福田区', '2020-10-19 18:48:23', 1);
INSERT INTO `orders` VALUES (38, 164, 7, 3, 2, '嘻嘻', '123987', '深圳市福田区', '2020-10-11 17:34:52', 1);
INSERT INTO `orders` VALUES (39, 39, 2, 3, 1, '小宝宝', '12315', '黑龙江漠河', '2020-10-11 17:40:21', 2);
INSERT INTO `orders` VALUES (41, 39, 3, 3, 1, '嘻嘻', '123987', '深圳市福田区', '2020-10-11 18:19:26', 1);
INSERT INTO `orders` VALUES (42, 18, 2, 3, 1, '嘻嘻', '123987', '深圳市福田区', '2020-10-11 18:50:30', 1);
INSERT INTO `orders` VALUES (44, 26, 2, 3, 1, '嘻嘻', '123987', '深圳市福田区', '2020-10-19 18:48:27', 1);
INSERT INTO `orders` VALUES (45, 26, 2, 4, 1, '嘻嘻', '123987', '深圳市福田区', '2020-10-19 18:48:29', 1);
INSERT INTO `orders` VALUES (48, 26, 1, 3, 1, '嘻嘻', '123987', '深圳市福田区', '2020-10-14 14:55:33', 1);

-- ----------------------------
-- Table structure for tops
-- ----------------------------
DROP TABLE IF EXISTS `tops`;
CREATE TABLE `tops`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '推荐类型(1今日推荐)',
  `good_id` int(11) NOT NULL DEFAULT 0 COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '推荐商品' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tops
-- ----------------------------
INSERT INTO `tops` VALUES (2, 1, 2);
INSERT INTO `tops` VALUES (3, 1, 3);
INSERT INTO `tops` VALUES (4, 1, 4);
INSERT INTO `tops` VALUES (5, 1, 5);
INSERT INTO `tops` VALUES (6, 1, 6);
INSERT INTO `tops` VALUES (7, 1, 7);
INSERT INTO `tops` VALUES (8, 1, 8);
INSERT INTO `tops` VALUES (9, 1, 9);
INSERT INTO `tops` VALUES (10, 1, 10);
INSERT INTO `tops` VALUES (11, 1, 11);
INSERT INTO `tops` VALUES (12, 1, 34);
INSERT INTO `tops` VALUES (13, 1, 27);

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `num` int(11) NULL DEFAULT 0 COMMENT '排序号 (从小到大)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES (1, '生态果蔬', 1);
INSERT INTO `types` VALUES (2, '肉禽蛋奶', 2);
INSERT INTO `types` VALUES (3, '米面粮油', 3);
INSERT INTO `types` VALUES (4, '休闲零食', 4);
INSERT INTO `types` VALUES (5, '特色风味', 5);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'user', '202cb962ac59075b964b07152d234b70', '嘻嘻', '123987', '深圳市福田区');
INSERT INTO `users` VALUES (2, '77', '202cb962ac59075b964b07152d234b70', '小宝宝', '12315', '黑龙江漠河');
INSERT INTO `users` VALUES (3, '88', 'tuShOfiBrA8+br7ENrMS8A==', '大宝贝', '10010', '海南西沙群岛');
INSERT INTO `users` VALUES (4, '99', 'cMdK4vKHu03eruGlpzU4VQ==', '哈哈哈', '10086', '新疆阿拉善');
INSERT INTO `users` VALUES (5, 'zhangsan', 'HAMVRZRssPCADKqGjGWJtQ==', '张三', '13311112222', 'aaa');
INSERT INTO `users` VALUES (6, '测试', '202cb962ac59075b964b07152d234b70', 'test', '123', '123');

SET FOREIGN_KEY_CHECKS = 1;
