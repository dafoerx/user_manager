<<<<<<< HEAD
/*
 Navicat Premium Data Transfer

 Source Server         : Yyds_3_15_Second_hand_book_platform
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : l_user

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/05/2022 16:15:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, 'Anna', '安娜', 'anna123456', '1794126795', '1', '我喜欢唱歌跳舞', '2022-05-10 07:59:36');
INSERT INTO `user` VALUES (5, 'xiaohai', '小海', '123456', '1545464687', '0', '我是勇敢的男孩', '2022-05-10 08:00:18');
INSERT INTO `user` VALUES (6, 'Tom', '汤姆', 'tom_123', '18778946794', '0', '我喜欢打篮球', '2022-05-10 15:42:17');
INSERT INTO `user` VALUES (7, 'Haier', '海尔', 'GGBoy', '12487948949', '0', '我性格开朗，希望和你交个朋友哦', '2022-05-10 15:44:03');
INSERT INTO `user` VALUES (8, 'NANA', '娜娜', 'nana555', '1564799748', '1', '我喜欢弹钢琴', '2022-05-13 13:28:22');
INSERT INTO `user` VALUES (9, 'xiaoyuan', '小袁', '12346', '18778459784', '0', '描述', '2022-05-05 13:33:25');
INSERT INTO `user` VALUES (11, 'xiaoming', '小明', '123465', '18778990168', '0', '我是小明', '2022-05-15 14:33:18');
INSERT INTO `user` VALUES (12, '测试', '测试', '12154', '123456', '0', '测试12', '2022-05-15 14:33:41');
INSERT INTO `user` VALUES (13, 'xiaogg', '小G', '12346', '148716164949', '0', '我是小G', '2022-05-15 14:52:21');
INSERT INTO `user` VALUES (15, '测试', '测试', '测试', '15649', '0', '测试', '2022-05-15 14:53:58');

SET FOREIGN_KEY_CHECKS = 1;
=======
/*
 Navicat Premium Data Transfer

 Source Server         : Yyds_3_15_Second_hand_book_platform
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : l_user

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/05/2022 16:15:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, 'Anna', '安娜', 'anna123456', '1794126795', '1', '我喜欢唱歌跳舞', '2022-05-10 07:59:36');
INSERT INTO `user` VALUES (5, 'xiaohai', '小海', '123456', '1545464687', '0', '我是勇敢的男孩', '2022-05-10 08:00:18');
INSERT INTO `user` VALUES (6, 'Tom', '汤姆', 'tom_123', '18778946794', '0', '我喜欢打篮球', '2022-05-10 15:42:17');
INSERT INTO `user` VALUES (7, 'Haier', '海尔', 'GGBoy', '12487948949', '0', '我性格开朗，希望和你交个朋友哦', '2022-05-10 15:44:03');
INSERT INTO `user` VALUES (8, 'NANA', '娜娜', 'nana555', '1564799748', '1', '我喜欢弹钢琴', '2022-05-13 13:28:22');
INSERT INTO `user` VALUES (9, 'xiaoyuan', '小袁', '12346', '18778459784', '0', '描述', '2022-05-05 13:33:25');
INSERT INTO `user` VALUES (11, 'xiaoming', '小明', '123465', '18778990168', '0', '我是小明', '2022-05-15 14:33:18');
INSERT INTO `user` VALUES (12, '测试', '测试', '12154', '123456', '0', '测试12', '2022-05-15 14:33:41');
INSERT INTO `user` VALUES (13, 'xiaogg', '小G', '12346', '148716164949', '0', '我是小G', '2022-05-15 14:52:21');
INSERT INTO `user` VALUES (15, '测试', '测试', '测试', '15649', '0', '测试', '2022-05-15 14:53:58');

SET FOREIGN_KEY_CHECKS = 1;
>>>>>>> fbc81354bc33d1fcde0573c03af09dc3e42f869e
