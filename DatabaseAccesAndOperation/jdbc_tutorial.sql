/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80200
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80200
 File Encoding         : 65001

 Date: 14/03/2024 11:16:59
*/

create database jdbc_tutorial;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pwd` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '小明', '123456');
INSERT INTO `user` VALUES (2, '张三', 'abcdef');
INSERT INTO `user` VALUES (3, '李四', '987654');

SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE department (
    dep_id int not null primary key comment '部门编号',
    department_name varchar(60) comment '部门名称'
);
Insert into department values (1001,'综合部');
Insert into department values (1002,'物资部');
Insert into department values (1003,'经营部');
Insert into department values (1004,'信息部');



CREATE TABLE employee (
    emp_id int not null auto_increment primary key comment '员工编号',
    last_name varchar(60) comment '员工名',
    gendor varchar(10) comment '性别',
    age int comment '年龄',
    email varchar(60) comment '邮编',
    dep_id int not null comment '部门编号',
    foreign key (dep_id) references department (dep_id)
);
insert into employee (last_name, gendor, age, email, dep_id) values ('lisun','male', 21, 'lisun@qq.com',1001);
insert into employee (last_name, gendor, age, email, dep_id) values ('Jacky','male', 37, 'Jacky@qq.com',1002);
insert into employee (last_name, gendor, age, email, dep_id) values ('Yunan','female', 29, 'Yunan@qq.com',1003);
insert into employee (last_name, gendor, age, email, dep_id) values ('Susan','female', 32, 'Susan@qq.com',1001);




