/*
 Navicat Premium Data Transfer

 Source Server         : 小袁博客服务器
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 43.138.223.178:3306
 Source Schema         : user-manager

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 10/05/2022 23:22:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'xiaobai', '小明', '123456', '13497946488', '0', '描述', '2022-05-06 11:17:36');
INSERT INTO `user` VALUES (2, '1', '1', '1', '1', '0', '1', '2022-05-06 15:49:51');
INSERT INTO `user` VALUES (3, '小红', '小红', '123456', '1978956126', '1', '我是女生', '2022-05-06 15:55:16');
INSERT INTO `user` VALUES (4, 'xiaoming', '小明', '123456', '12567979494', '1', '我是小明', '2022-05-06 15:56:37');
INSERT INTO `user` VALUES (5, '2', '1', '1', '1', '0', '1', '2022-05-10 07:59:36');
INSERT INTO `user` VALUES (6, 'xiaohai', '小海', '123456', '1545464687', '0', '我是勇敢的男孩', '2022-05-10 08:00:18');

SET FOREIGN_KEY_CHECKS = 1;
