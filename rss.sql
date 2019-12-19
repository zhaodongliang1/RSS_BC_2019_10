/*
 Navicat Premium Data Transfer

 Source Server         : Spring
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : rss

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 12/10/2019 11:04:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for computers
-- ----------------------------
DROP TABLE IF EXISTS `computers`;
CREATE TABLE `computers`  (
  `Com_Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Com_Name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电脑编号',
  `Com_Ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电脑Ip地址',
  `RR_Com_ReadRoomId` int(11) NOT NULL COMMENT '阅览室Id',
  `Com_Remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Com_Ext1` int(11) NULL DEFAULT NULL COMMENT '预留字段',
  `Com_Ext2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`Com_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电脑' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of computers
-- ----------------------------
INSERT INTO `computers` VALUES (1, '电脑1号', '223.104.106.131', 1, '无', 0, '无');
INSERT INTO `computers` VALUES (2, '电脑2号', '223.104.106.999', 1, '无', 0, '无');
INSERT INTO `computers` VALUES (3, '电脑3号', '223.104.166.333', 2, '无', 0, '无');
INSERT INTO `computers` VALUES (4, '电脑4号', '223.104.506.444', 3, '无', 0, '无');

-- ----------------------------
-- Table structure for consumelogs
-- ----------------------------
DROP TABLE IF EXISTS `consumelogs`;
CREATE TABLE `consumelogs`  (
  `Con_Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Con_CardNO` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卡号',
  `RR_Con_ReadRoomId` int(11) NOT NULL COMMENT '资源Id',
  `Con_InTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '进入时间',
  `Con_OutTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '离开时间',
  `Con_Status` int(11) NOT NULL DEFAULT 0 COMMENT '用于统计而不用于判定0:不在1:在',
  `Con_Ext1` int(11) NULL DEFAULT NULL COMMENT '预留字段',
  `Con_Ext2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`Con_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '进出统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumelogs
-- ----------------------------
INSERT INTO `consumelogs` VALUES (1, 'kh20170001', 1, '2019-09-29 10:19:06', '2019-09-29 10:19:42', 0, 0, '无');
INSERT INTO `consumelogs` VALUES (2, 'kh20170002', 2, '2019-10-11 11:32:09', '2019-10-11 11:32:09', 0, 0, '无');
INSERT INTO `consumelogs` VALUES (3, 'kh20170003', 1, '2019-10-11 11:33:53', '2019-10-11 11:33:53', 0, 0, NULL);
INSERT INTO `consumelogs` VALUES (4, 'kh20170004', 1, '2019-10-11 13:30:57', '2019-10-11 15:19:55', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (5, 'kh20170005', 1, '2019-10-11 13:57:21', '2019-10-11 14:55:18', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (6, 'kh20170006', 1, '2019-10-11 14:57:59', '2019-10-11 14:57:59', 1, NULL, NULL);
INSERT INTO `consumelogs` VALUES (7, 'kh20170004', 1, '2019-10-11 15:06:20', '2019-10-11 15:19:55', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (8, 'kh20170004', 0, '2019-10-11 15:06:23', '2019-10-11 15:19:55', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (9, 'kh20170004', 0, '2019-10-11 15:06:31', '2019-10-11 15:19:55', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (10, 'kh20170004', 0, '2019-10-11 15:10:03', '2019-10-11 15:19:55', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (11, 'kh20170004', 0, '2019-10-11 15:19:55', '2019-10-12 09:54:20', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (12, 'kh20170007', 1, '2019-10-11 15:21:08', '2019-10-11 15:25:29', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (13, 'kh20170007', 1, '2019-10-11 15:21:34', '2019-10-11 15:25:29', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (14, 'kh20170007', 0, '2019-10-11 15:21:47', '2019-10-11 15:25:29', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (15, 'kh20170007', 0, '2019-10-11 15:23:29', '2019-10-11 15:25:29', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (16, 'kh20170007', 0, '2019-10-11 15:25:29', '2019-10-11 15:30:15', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (17, 'kh20170007', 1, '2019-10-11 15:30:18', '2019-10-11 15:30:21', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (18, 'kh20170001', 1, '2019-10-12 09:51:29', '2019-10-12 09:51:31', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (19, 'kh20170001', 1, '2019-10-12 09:51:33', '2019-10-12 09:51:34', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (20, 'kh20170004', 1, '2019-10-12 09:54:23', '2019-10-12 09:54:26', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (21, 'kh20170004', 1, '2019-10-12 09:55:50', '2019-10-12 09:55:50', 1, NULL, NULL);
INSERT INTO `consumelogs` VALUES (22, 'kh20170005', 1, '2019-10-12 10:04:43', '2019-10-12 10:05:52', 0, NULL, NULL);
INSERT INTO `consumelogs` VALUES (23, 'kh20170005', 3, '2019-10-12 10:05:56', '2019-10-12 10:05:56', 1, NULL, NULL);
INSERT INTO `consumelogs` VALUES (24, 'kh20170003', 1, '2019-10-12 10:48:59', '2019-10-12 10:49:47', 0, NULL, NULL);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for memberships
-- ----------------------------
DROP TABLE IF EXISTS `memberships`;
CREATE TABLE `memberships`  (
  `mem_id` int(11) NOT NULL AUTO_INCREMENT,
  `mem_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '系',
  `mem_specialty` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '专业',
  `mem_degree` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学历',
  PRIMARY KEY (`mem_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of memberships
-- ----------------------------
INSERT INTO `memberships` VALUES (1, '电子系', '云时代', '中专');
INSERT INTO `memberships` VALUES (2, '电子系', '电商运营', '大专');
INSERT INTO `memberships` VALUES (3, '营销系', '市场营销', '大专');

-- ----------------------------
-- Table structure for readrooms
-- ----------------------------
DROP TABLE IF EXISTS `readrooms`;
CREATE TABLE `readrooms`  (
  `RR_Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源编号',
  `RR_Name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '阅览室名称',
  `RR_Remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  `RR_Ext1` int(11) NOT NULL COMMENT '预留字段',
  `RR_Ext2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预留字段',
  PRIMARY KEY (`RR_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '阅览室' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of readrooms
-- ----------------------------
INSERT INTO `readrooms` VALUES (1, '图书馆', '无', 0, '无');
INSERT INTO `readrooms` VALUES (2, '体育馆', '无', 0, '无');
INSERT INTO `readrooms` VALUES (3, '篮球场', '无', 0, '无');

-- ----------------------------
-- Table structure for sections
-- ----------------------------
DROP TABLE IF EXISTS `sections`;
CREATE TABLE `sections`  (
  `sec_id` int(11) NOT NULL AUTO_INCREMENT,
  `sec_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '科室名称',
  `sec_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`sec_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sections
-- ----------------------------
INSERT INTO `sections` VALUES (1, '教务处', '无');
INSERT INTO `sections` VALUES (2, '体育器材室', '无');

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics`  (
  `Sta_Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `RR_Sta_ReadRoomId` int(11) NOT NULL COMMENT '资源Id',
  `Sta_PerpleNums` int(11) NOT NULL COMMENT '使用人次',
  `Sta_Data` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '日期',
  `Sta_Ext1` int(11) NULL DEFAULT NULL COMMENT '预留字段',
  `Sta_Ext2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`Sta_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of statistics
-- ----------------------------
INSERT INTO `statistics` VALUES (1, 1, 19, '2019-09-18 10:07:52', 0, '无');
INSERT INTO `statistics` VALUES (2, 2, 6, '2019-09-17 10:09:49', 0, '无');
INSERT INTO `statistics` VALUES (3, 3, 6, '2019-10-11 13:08:10', 0, '无');
INSERT INTO `statistics` VALUES (4, 3, 10, '2019-10-12 10:10:30', NULL, NULL);
INSERT INTO `statistics` VALUES (5, 1, 21, '2019-10-11 10:11:43', NULL, NULL);

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_cardno` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '\r\n卡号',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `stu_sex` char(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '性别',
  `stu_status` int(11) NOT NULL DEFAULT 0 COMMENT '0:正常，>0所在阅览室编号',
  `stu_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  `stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学号',
  `stu_mem_id` int(11) NOT NULL COMMENT '身份编号',
  PRIMARY KEY (`stu_id`) USING BTREE,
  INDEX `FKmyuav8jse7m3us490khm5xsn4`(`stu_mem_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, 'kh20170001', '赵栋梁', '男', 0, '无', 'xh20170001', 1);
INSERT INTO `students` VALUES (2, 'kh20170002', '李丽', '女', 2, '无', 'xh20170002', 1);
INSERT INTO `students` VALUES (3, 'kh20170003', '李欣', '女', 0, '无', 'xh20170003', 2);
INSERT INTO `students` VALUES (4, 'kh20170004', '王三', '男', 1, '无', 'xh20170004', 2);
INSERT INTO `students` VALUES (5, 'kh20170005', '张伟', '男', 3, '无', 'xh20170005', 3);
INSERT INTO `students` VALUES (6, 'kh20170006', '张龙', '男', 1, '无', 'xh20170006', 1);
INSERT INTO `students` VALUES (7, 'kh20170007', '里斯', '男', 0, '无', 'xh20170007', 1);
INSERT INTO `students` VALUES (8, 'kh20170008', '无畏', '男', 1, '无', 'xh20170007', 1);
INSERT INTO `students` VALUES (9, 'kh20170009', '王胜', '女', 0, '无', 'xh20170007', 2);
INSERT INTO `students` VALUES (10, 'kh20170010', '修改', '女', 1, '22222', 'kh2017001', 1);
INSERT INTO `students` VALUES (13, 'kh20170011', '添加', '男', 0, '22222', 'kh2017001', 1);

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers`  (
  `tea_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_cardno` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '卡号',
  `tea_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `tea_sex` char(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '性别',
  `tea_sec_id` int(11) NOT NULL COMMENT '科室编号',
  `tea_status` int(11) NOT NULL DEFAULT 0 COMMENT '0:正常，>0所在阅览室编号',
  `tea_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`tea_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES (1, '20171111', '张三', '男', 1, 0, '无');
INSERT INTO `teachers` VALUES (2, '20171112', '李四', '男', 2, 1, '无');
INSERT INTO `teachers` VALUES (3, '20171113', '王二麻子', '男', 1, 2, '无');
INSERT INTO `teachers` VALUES (4, '20171114', '张一', '女', 1, 0, '无');
INSERT INTO `teachers` VALUES (5, '20171115', '张二', '女', 2, 3, '无');
INSERT INTO `teachers` VALUES (6, '20171116', '装三', '女', 1, 1, '无');
INSERT INTO `teachers` VALUES (7, '20171117', '张五', '男', 2, 0, '无');
INSERT INTO `teachers` VALUES (8, '20171118', '张六', '男', 2, 0, '无');
INSERT INTO `teachers` VALUES (9, '20171119', '张琪', '女', 1, 0, '无');
INSERT INTO `teachers` VALUES (10, '20171120', '张吧', '男', 2, 1, '无');

SET FOREIGN_KEY_CHECKS = 1;
