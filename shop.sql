/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 02/07/2021 09:59:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (2, 1, 6);
INSERT INTO `car` VALUES (7, 2, 3);
INSERT INTO `car` VALUES (8, 2, 4);
INSERT INTO `car` VALUES (12, 2, 11);
INSERT INTO `car` VALUES (13, 2, 12);
INSERT INTO `car` VALUES (15, 6, 5);
INSERT INTO `car` VALUES (16, 5, 13);
INSERT INTO `car` VALUES (17, 1, 13);
INSERT INTO `car` VALUES (21, 7, 11);
INSERT INTO `car` VALUES (22, 6, 6);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (2, '家具');
INSERT INTO `category` VALUES (3, '日常用品');
INSERT INTO `category` VALUES (4, '男装');
INSERT INTO `category` VALUES (5, '女装');
INSERT INTO `category` VALUES (6, '化妆品');
INSERT INTO `category` VALUES (7, '首饰');
INSERT INTO `category` VALUES (8, '箱包');
INSERT INTO `category` VALUES (9, '数码');
INSERT INTO `category` VALUES (10, '家电');
INSERT INTO `category` VALUES (11, '运动');
INSERT INTO `category` VALUES (12, '宠物');

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(11) NOT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (3, 1, 2, '可折叠加厚双面使用榻榻米床垫', '可以折叠的榻榻米床垫，收纳不占空间，正反两面都可以使用，同时纯棉材质舒适亲肤，透气性好，保持贴身换将干爽 不粘腻。', 180, '/upload/2021-06-25/15/1582443919266.jpg', 1);
INSERT INTO `good` VALUES (4, 1, 7, '人鱼的眼泪 祖母绿琉璃吊坠', '简约的祖母绿水晶吊坠，光泽迷人，尽显十足的典雅宫廷风。', 278, '/upload/2021-06-25/15/1582444313438.jpg', 0);
INSERT INTO `good` VALUES (5, 2, 7, '手工琉璃淡紫项链', '“淡雅的紫色调十分迷人，小小的性感韵味却不会显得人老气横秋。”', 278, '/upload/2021-06-25/16/1582445742199.jpg', 0);
INSERT INTO `good` VALUES (6, 2, 7, '人鱼的眼泪薰衣草海外原创设计手工琉璃吊坠项链', '“人鱼的眼泪薰衣草海外原创设计手工琉璃吊坠项链。手工成形，纯银抛光，热熔镶嵌，来自世界时尚之都日本东京的手工首饰，纯银与琉璃的完美结合，带你探寻源于心灵的浪漫与精致。”', 298, '/upload/2021-06-25/16/1582445885698.jpg', 0);
INSERT INTO `good` VALUES (8, 2, 7, '航民 实心光面足金手镯', '“耀眼的足金无需过多修饰，便能凸显出它的独特气质。实心的光圈创意，犹如知性的少女，无需张扬讨好亦有人爱。更有可调节的开扣，独特的设计，展现女性温柔如水的内涵。”', 6053, '/upload/2021-06-25/16/1582446346946.jpg', 1);
INSERT INTO `good` VALUES (9, 2, 7, '周大福 简约足金黄金手链', '“足金打造，佩戴起来凸显华丽质感，别致迷人的镂空徽章造型做工精湛，可调节链带脱戴更显方便，整体简约自然，更显亮白肤色。”', 8465, '/upload/2021-06-25/16/1582446462373.jpg', 1);
INSERT INTO `good` VALUES (10, 1, 4, 'Kiko联名Asics斗篷夹克', 'Kiko Kostadinov X Asics Poncho 联名推出的一款可拆卸外套，是一款运动风格的连帽冲锋衣，通过立体剪裁工艺，设计出的这样时尚别致的运动服。深色鸭蛋蓝，喉部有引人注目的黑色镶板，呈现出简单而醒目的轮廓。', 1799, '/upload/2021-06-27/17/1584437283172.jpg', 1);
INSERT INTO `good` VALUES (11, 1, 4, '白糖玫瑰 日系复古宽松潮流夹克', '夹克版型，上身帅气有型，复古风格，彰显时尚潮流，短款外套，拉长身材比例。宽松版型，舒适百搭。”', 168, '/upload/2021-06-27/17/1584437346060.jpg', 0);
INSERT INTO `good` VALUES (12, 1, 4, '男士羊羔绒连帽夹克', '此款工装夹克选用羊羔毛作内胆，水洗棉作面料，加厚保暖，柔软舒适，经典的连帽设计增添休闲感，胸前的拉链独特个性，兼具一定的实用性，两侧的贴布口袋容量大，实用性强，衣身五金做旧有质感，彰显不俗品质。', 242, '/upload/2021-06-27/17/1584437423156.jpg', 0);
INSERT INTO `good` VALUES (13, 2, 4, 'TIANC BRAND撞色翻领夹克', '大面积撞色显得别具一格，突出浓郁的复古街头风设计特点。结合垃圾食品的印花主题，能够渲染有趣的年轻氛围，从而散发青春流行风气息。立体拼接大口袋，诠释工装的硬朗魅力。', 529, '/upload/2021-06-27/17/1584437784107.jpg', 0);
INSERT INTO `good` VALUES (14, 2, 4, 'TIANC BRAND撞色夹克外套', '此款夹克充分的借鉴经典冲锋衣外套的设计精髓，通过断层分割以及半拉链门襟，体现潮酷机能性。大胆的撞色元素，有着强烈的视觉冲击力，解析出复古街头风格。', 349, '/upload/2021-06-27/17/1584437873477.jpg', 0);
INSERT INTO `good` VALUES (15, 2, 4, 'FYP国潮嘻哈印花套头工装夹克', '半拉链的套头款夹克外套，缔造冲锋衣那种机能性设计感，潮酷风采十足。偏宽松的版型，有着不拘一格的随性气息。干净明朗的底色，渗透欧美风的简约基调。', 399, '/upload/2021-06-27/17/1584437960047.jpg', 1);
INSERT INTO `good` VALUES (16, 6, 2, '优木家具纯实木沙发', '简单也是一种美/ 纯净的颜色，搭配任一款家具，尽显浪漫生活气息，满走您对居家生活的无止境追求。', 1000, '/upload/2021-06-28/17/1624873872247.jpg', 1);
INSERT INTO `good` VALUES (19, 6, 5, '霉霉同款裙子', '霉霉同款裙子，仙气飘飘！', 200, '/upload/2021-07-02/08/1625185041862.png', 1);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, 2, '哦哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈呱呱呱呱呱呱呱呱呱呱呱呱呱呱呱古古怪怪反反复复烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦');
INSERT INTO `message` VALUES (2, 1, 2, '德国大使馆豆腐干反对和团体恢复记忆酷游i哦啊完全尼克劳斯电话计费欧通反馈给发何炅【如同平均 角度考虑飞机可联合国i哦【 的复活节开户费hi哦人h\r\n的回复快点\r\n广东省高级领导攻击力');
INSERT INTO `message` VALUES (3, 1, 1, '非官方');
INSERT INTO `message` VALUES (4, 1, 4, '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈');
INSERT INTO `message` VALUES (5, 1, 5, '好好好好好好好好好好好好好');
INSERT INTO `message` VALUES (6, 6, 5, '(๑•̀ㅂ•́)و✧');
INSERT INTO `message` VALUES (7, 6, 5, '');
INSERT INTO `message` VALUES (8, 7, 11, '7777');
INSERT INTO `message` VALUES (9, 6, 9, '真金白银');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `take_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `take_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `take_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT 1,
  `express_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `express_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (7, 2, 4, '王五', '湖南省长沙市湖南网络工程职业学院', '12345678910', 4, '顺丰', '20200224163800');
INSERT INTO `order` VALUES (16, 7, 11, '张庭', '湖南文理学院', '19936851192', 2, NULL, NULL);
INSERT INTO `order` VALUES (17, 6, 5, '李四', '湖南文理学院', '19936851192', 2, NULL, NULL);
INSERT INTO `order` VALUES (18, 6, 14, '李四', '湖南文理学院', '19936851192', 2, NULL, NULL);
INSERT INTO `order` VALUES (19, 6, 6, '李四', '湖南文理学院', '19936851192', 2, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/lib/img/head.jpg',
  `is_admin` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin@qq.com', 'admin', '张三', '男', '/upload/2021-06-24/20/1584188961065.png', 0);
INSERT INTO `user` VALUES (2, 'abc@qq.com', 'abc', '李四', '女', '/upload/img/head.jpg', 0);
INSERT INTO `user` VALUES (3, 'root@qq.com', 'root', '王五', '男', '/upload/img/head.jpg', 1);
INSERT INTO `user` VALUES (5, '123@qq.com', '123', '哈哈', '女', '/upload/img/head.jpg', 0);
INSERT INTO `user` VALUES (6, 'sen@qq.com', 'sen', 'sen', '男', '/upload/2021-07-01/21/1625146396530.png2021-07-01/21/1625146636146.png', 1);
INSERT INTO `user` VALUES (7, 'zt@qq.com', '123zt', '张庭', '女', '/upload/img/head.jpg', 0);

SET FOREIGN_KEY_CHECKS = 1;
