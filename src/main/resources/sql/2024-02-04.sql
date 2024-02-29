/*
 Navicat Premium Data Transfer

 Source Server         : xfyl
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : xfyl

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 04/02/2024 13:13:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`
(
    `id`          int                                                                   NOT NULL AUTO_INCREMENT COMMENT '字典表主键',
    `title`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '主题',
    `content`     varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '内容',
    `picture`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '图片',
    `tyoe`        int                                                                   NULL DEFAULT NULL COMMENT '类型',
    `create_time` datetime                                                              NULL DEFAULT NULL COMMENT '创建时间',
    `creator`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time` datetime                                                              NULL DEFAULT NULL COMMENT '修改时间',
    `update_name` datetime                                                              NULL DEFAULT NULL COMMENT '修改人',
    `is_delete`   int                                                                   NULL DEFAULT NULL COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`
(
    `id`               bigint                                                                NOT NULL AUTO_INCREMENT COMMENT '医生主键',
    `doctor_name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生名称',
    `doctor_type`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生类型',
    `doctor_introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生介绍',
    `doctor_photo`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '图',
    `doctor_services`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生服务',
    `create_time`      datetime                                                              NULL DEFAULT NULL COMMENT '创建时间',
    `creator`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time`      datetime                                                              NULL DEFAULT NULL COMMENT '修改时间',
    `updator`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '修改人',
    `is_delete`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `id`               int                                                                   NOT NULL COMMENT '订单主键',
    `order_number`     int                                                                   NULL DEFAULT NULL COMMENT '订单号',
    `ord_type`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '订单类型',
    `order_price`      decimal(10, 2)                                                        NULL DEFAULT NULL COMMENT '订单金额',
    `business`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '所属业态',
    `appointment_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '预约类型',
    `order_type`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '订单状态',
    `association_id`   bigint                                                                NULL DEFAULT NULL COMMENT '关联外键',
    `create_time`      datetime                                                              NULL DEFAULT NULL COMMENT '创建时间',
    `creator`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time`      datetime                                                              NULL DEFAULT NULL COMMENT '修改时间',
    `updator`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '修改人',
    `is_delete`        int                                                                   NULL DEFAULT NULL COMMENT '是否删除',
    `doctor_id`        int                                                                   NULL DEFAULT NULL COMMENT '医生主键',
    `task_id`          int                                                                   NULL DEFAULT NULL COMMENT '患者主键',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for surgery
-- ----------------------------
DROP TABLE IF EXISTS `surgery`;
CREATE TABLE `surgery`
(
    `surgery_id`            bigint                                                                NOT NULL AUTO_INCREMENT COMMENT '手术ID',
    `tracking_personnel_id` bigint                                                                NULL DEFAULT NULL COMMENT '患者ID，外键关联 track_personnel表',
    `surgery_type`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs  NULL DEFAULT NULL COMMENT '手术类型',
    `surgery_name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '手术名称',
    `operating_physician`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '主刀医生',
    `wound_photo_upload`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口照片上传',
    `surgery_time`          datetime                                                              NULL DEFAULT NULL COMMENT '手术时间',
    `photo_upload_time`     datetime                                                              NULL DEFAULT NULL COMMENT '照片上传时间',
    `creat_time`            datetime                                                              NULL DEFAULT NULL COMMENT '创建时间',
    `creator`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    PRIMARY KEY (`surgery_id`) USING BTREE,
    INDEX `tracking_personnel_id` (`tracking_personnel_id` ASC) USING BTREE,
    CONSTRAINT `surgery_ibfk_1` FOREIGN KEY (`tracking_personnel_id`) REFERENCES `tracking_personnel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs COMMENT = '存储手术信息的表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for surgical_name
-- ----------------------------
DROP TABLE IF EXISTS `surgical_name`;
CREATE TABLE `surgical_name`
(
    `id`          bigint                                                                NOT NULL AUTO_INCREMENT COMMENT '字典的主键',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '手术名称或者类型名称',
    `create_time` datetime                                                              NULL DEFAULT NULL COMMENT '创建时间',
    `is_delete`   int                                                                   NULL DEFAULT NULL COMMENT '是否删除',
    `level`       int                                                                   NULL DEFAULT NULL COMMENT '级别',
    `creator`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time` datetime                                                              NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 27
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tracking_personnel
-- ----------------------------
DROP TABLE IF EXISTS `tracking_personnel`;
CREATE TABLE `tracking_personnel`
(
    `id`                    bigint                                                                NOT NULL AUTO_INCREMENT COMMENT '跟踪人员档案主键',
    `name`                  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NOT NULL COMMENT '跟踪人员名称',
    `barcode_photo`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '病例条码照片',
    `medical_number`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '病案号',
    `phone`                 varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '联系电话',
    `operation_name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '手术名称',
    `operation_date`        datetime                                                              NULL DEFAULT NULL COMMENT '手术时间',
    `surgeon_name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '主刀医生名称',
    `attending_doctor_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '主治医生名称',
    `creat_time`            datetime                                                              NULL DEFAULT NULL COMMENT '创建时间',
    `creat_name`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `surgeon_id`            bigint                                                                NULL DEFAULT NULL COMMENT '主刀医生主键',
    `attending_doctor`      bigint                                                                NULL DEFAULT NULL COMMENT '主治医生主键',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 25
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for trust_file
-- ----------------------------
DROP TABLE IF EXISTS `trust_file`;
CREATE TABLE `trust_file`
(
    `file_id`          int                                                           NOT NULL AUTO_INCREMENT COMMENT '文件id',
    `file_name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名称',
    `file_origin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件真实名称',
    `file_url`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件url',
    `is_delete`        int                                                           NULL DEFAULT NULL COMMENT '是否删除',
    `create_time`      datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `creator`          varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 42
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for trust_relation_file
-- ----------------------------
DROP TABLE IF EXISTS `trust_relation_file`;
CREATE TABLE `trust_relation_file`
(
    `busi_type`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务类型',
    `busi_id`    varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '业务id',
    `file_id`    varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '文件id',
    `photo_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片类型：用来确定手术前后的照片类型字段'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for wound_follow
-- ----------------------------
DROP TABLE IF EXISTS `wound_follow`;
CREATE TABLE `wound_follow`
(
    `id`                    bigint                                                                NOT NULL AUTO_INCREMENT COMMENT '伤口随访主键',
    `tracking_personnel_id` bigint                                                                NULL DEFAULT NULL COMMENT '患者id',
    `medical_number`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '病案号',
    `doctor_id`             int                                                                   NULL DEFAULT NULL COMMENT '医生主键',
    `doctor_name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生名称',
    `postoperative_stage`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '术后阶段',
    `wound_shooting_date`   datetime                                                              NULL DEFAULT NULL COMMENT '伤口拍摄日期',
    `taking_lens`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '拍摄镜头选择',
    `wound_photo`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口照片',
    `wound_condition`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口状况',
    `create_time`           datetime                                                              NULL DEFAULT NULL COMMENT '创建时间',
    `creator`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime                                                              NULL DEFAULT NULL COMMENT '修改时间',
    `update_name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '修改人',
    `is_delete`             int                                                                   NULL DEFAULT NULL COMMENT '是否删除',
    `is_confirm`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '是否同意',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
