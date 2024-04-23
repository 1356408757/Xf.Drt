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

 Date: 14/03/2024 15:37:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`
(
    `id`          int(0)                                                                NOT NULL AUTO_INCREMENT COMMENT '字典表主键',
    `title`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '主题',
    `content`     varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '内容',
    `picture`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '图片',
    `tyoe`        int(0)                                                                NULL DEFAULT NULL COMMENT '类型',
    `create_time` datetime(0)                                                           NULL DEFAULT NULL COMMENT '创建时间',
    `creator`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time` datetime(0)                                                           NULL DEFAULT NULL COMMENT '修改时间',
    `update_name` datetime(0)                                                           NULL DEFAULT NULL COMMENT '修改人',
    `is_delete`   int(0)                                                                NULL DEFAULT NULL COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`
(
    `id`               bigint(0)                                                             NOT NULL AUTO_INCREMENT COMMENT '医生主键',
    `doctor_name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生名称',
    `doctor_type`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生类型',
    `doctor_introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生介绍',
    `doctor_photo`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '图',
    `doctor_services`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生服务',
    `create_time`      datetime(0)                                                           NULL DEFAULT NULL COMMENT '创建时间',
    `creator`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time`      datetime(0)                                                           NULL DEFAULT NULL COMMENT '修改时间',
    `updator`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '修改人',
    `is_delete`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for surgery
-- ----------------------------
DROP TABLE IF EXISTS `surgery`;
CREATE TABLE `surgery`
(
    `surgery_id`            bigint(0)                                                             NOT NULL AUTO_INCREMENT COMMENT '手术ID',
    `tracking_personnel_id` bigint(0)                                                             NULL DEFAULT NULL COMMENT '患者ID，外键关联 track_personnel表',
    `surgery_type`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs  NULL DEFAULT NULL COMMENT '手术类型',
    `surgery_name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '手术名称',
    `operating_physician`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '主刀医生',
    `wound_photo_upload`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口照片上传',
    `surgery_time`          datetime(0)                                                           NULL DEFAULT NULL COMMENT '手术时间',
    `photo_upload_time`     datetime(0)                                                           NULL DEFAULT NULL COMMENT '照片上传时间',
    `creat_time`            datetime(0)                                                           NULL DEFAULT NULL COMMENT '创建时间',
    `creator`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    PRIMARY KEY (`surgery_id`) USING BTREE,
    INDEX `tracking_personnel_id` (`tracking_personnel_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs COMMENT = '存储手术信息的表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for surgical_name
-- ----------------------------
DROP TABLE IF EXISTS `surgical_name`;
CREATE TABLE `surgical_name`
(
    `id`          bigint(0)                                                             NOT NULL AUTO_INCREMENT COMMENT '字典的主键',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '手术名称或者类型名称',
    `create_time` datetime(0)                                                           NULL DEFAULT NULL COMMENT '创建时间',
    `is_delete`   int(0)                                                                NULL DEFAULT NULL COMMENT '是否删除',
    `level`       int(0)                                                                NULL DEFAULT NULL COMMENT '级别',
    `creator`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time` datetime(0)                                                           NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 26
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tracking_personnel
-- ----------------------------
DROP TABLE IF EXISTS `tracking_personnel`;
CREATE TABLE `tracking_personnel`
(
    `id`                    bigint(0)                                                             NOT NULL AUTO_INCREMENT COMMENT '跟踪人员档案主键',
    `name`                  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NOT NULL COMMENT '跟踪人员名称',
    `barcode_photo`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '病例条码照片',
    `medical_number`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '病案号',
    `phone`                 varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '联系电话',
    `operation_name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '手术名称',
    `operation_date`        datetime(0)                                                           NULL DEFAULT NULL COMMENT '手术时间',
    `surgeon_name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '主刀医生名称',
    `attending_doctor_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '主治医生名称',
    `creat_time`            datetime(0)                                                           NULL DEFAULT NULL COMMENT '创建时间',
    `creat_name`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `surgeon_id`            bigint(0)                                                             NULL DEFAULT NULL COMMENT '主刀医生主键',
    `attending_doctor`      bigint(0)                                                             NULL DEFAULT NULL COMMENT '主治医生主键',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for trust_file
-- ----------------------------
DROP TABLE IF EXISTS `trust_file`;
CREATE TABLE `trust_file`
(
    `file_id`          int(0)                                                         NOT NULL AUTO_INCREMENT COMMENT '文件id',
    `file_name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '文件名称',
    `file_origin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '文件真实名称',
    `file_url`         varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件url',
    `is_delete`        int(0)                                                         NULL DEFAULT NULL COMMENT '是否删除',
    `create_time`      datetime(0)                                                    NULL DEFAULT NULL COMMENT '创建时间',
    `creator`          varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   NULL DEFAULT NULL COMMENT '创建人',
    PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1202
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

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
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wound_follow
-- ----------------------------
DROP TABLE IF EXISTS `wound_follow`;
CREATE TABLE `wound_follow`
(
    `id`                    bigint(0)                                                             NOT NULL AUTO_INCREMENT COMMENT '伤口随访主键',
    `tracking_personnel_id` bigint(0)                                                             NULL DEFAULT NULL COMMENT '患者id',
    `medical_number`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '病案号',
    `doctor_id`             int(0)                                                                NULL DEFAULT NULL COMMENT '医生主键',
    `doctor_name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '医生名称',
    `postoperative_stage`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '术后阶段',
    `wound_shooting_date`   datetime(0)                                                           NULL DEFAULT NULL COMMENT '伤口拍摄日期',
    `taking_lens`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '拍摄镜头选择',
    `wound_photo`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口照片',
    `wound_condition`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口状况',
    `create_time`           datetime(0)                                                           NULL DEFAULT NULL COMMENT '创建时间',
    `creator`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime(0)                                                           NULL DEFAULT NULL COMMENT '修改时间',
    `update_name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '修改人',
    `is_delete`             int(0)                                                                NULL DEFAULT NULL COMMENT '是否删除',
    `is_confirm`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '是否同意',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wound_orders
-- ----------------------------
DROP TABLE IF EXISTS `wound_orders`;
CREATE TABLE `wound_orders`
(
    `id`                     bigint(0)                                                             NOT NULL AUTO_INCREMENT COMMENT '订单主键',
    `order_number`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '订单号',
    `task_id`                bigint(0)                                                             NULL DEFAULT NULL COMMENT '患者主键',
    `doctor_id`              bigint(0)                                                             NULL DEFAULT NULL COMMENT '医生主键',
    `ord_type`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '订单类型',
    `order_price`            decimal(10, 2)                                                        NULL DEFAULT NULL COMMENT '订单金额',
    `business`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '所属业态',
    `medical_number`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '病案号',
    `appointment_type`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '预约类型',
    `order_type`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '订单状态',
    `surgery_name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '手术名称',
    `perioperative_surgery`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '围期手术',
    `surgery_time`           datetime(0)                                                           NULL DEFAULT NULL COMMENT '手术时间',
    `wound_photo_ids`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口照片id',
    `wound_photography_time` datetime(0)                                                           NULL DEFAULT NULL COMMENT '伤口照片拍摄时间',
    `taking_lens`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口拍摄镜头选择',
    `wound_condition`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '伤口自感状况',
    `is_confirm`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '是否同意隐私协议',
    `is_reservation`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '是否取消预约',
    `create_time`            datetime(0)                                                           NULL DEFAULT NULL COMMENT '创建时间',
    `creator`                varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '创建人',
    `update_time`            datetime(0)                                                           NULL DEFAULT NULL COMMENT '修改时间',
    `updator`                varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_es_trad_0900_as_cs NULL DEFAULT NULL COMMENT '修改人',
    `is_delete`              int(0)                                                                NULL DEFAULT NULL COMMENT '是否删除',
    `association_id`         bigint(0)                                                             NULL DEFAULT NULL COMMENT '关联外键',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_es_trad_0900_as_cs
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE Users
(
    -- 用户ID，主键，自动递增
    user_id              INT PRIMARY KEY AUTO_INCREMENT,
    -- 微信授权登录后返回的openid，唯一标识用户
    wechat_openid        VARCHAR(100) NOT NULL UNIQUE,
    -- 用户昵称，来源于微信
    nickname             VARCHAR(255),
    -- 用户头像URL
    avatar_url           VARCHAR(2083),
    -- 注册/首次登录时间，默认当前时间戳
    register_time        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    -- 最近登录时间
    last_login_time      TIMESTAMP,
    -- 首次登录赠送的免费次数，默认值可以设定为50
    initial_credit_count INT       DEFAULT 50,
    -- 当前剩余可用次数
    current_credit_count INT,
    -- 用户联系方式，用于退款时联系
    contact_info         VARCHAR(255)
);
CREATE TABLE CreditPackages
(
    -- 套餐ID，主键，自动递增
    package_id          INT PRIMARY KEY AUTO_INCREMENT,
    -- 套餐名称
    package_name        VARCHAR(255),
    -- 套餐价格，每单位次数的售价
    price               DECIMAL(10, 2),
    -- 每个套餐包含的总次数
    credits_per_package INT
);
CREATE TABLE UserPurchases
(
    -- 购买记录ID，主键，自动递增
    purchase_id            INT PRIMARY KEY AUTO_INCREMENT,
    -- 用户ID，外键，关联Users表的user_id
    user_id                INT,
    FOREIGN KEY (user_id) REFERENCES Users (user_id),
    -- 套餐ID，外键，关联CreditPackages表的package_id
    package_id             INT,
    FOREIGN KEY (package_id) REFERENCES CreditPackages (package_id),
    -- 购买时间，默认当前时间戳
    purchase_time          TIMESTAMP                           DEFAULT CURRENT_TIMESTAMP,
    -- 购买的次数总数
    credit_count_purchased INT,
    -- 交易订单号
    transaction_id         VARCHAR(100),
    -- 支付状态（已支付、待支付、已退款等）
    payment_status         ENUM ('PAID', 'UNPAID', 'REFUNDED') DEFAULT 'UNPAID'
);
CREATE TABLE UserConsumptions
(
    -- 消费记录ID，主键，自动递增
    consumption_id     INT PRIMARY KEY AUTO_INCREMENT,
    -- 用户ID，外键，关联Users表的user_id
    user_id            INT,
    FOREIGN KEY (user_id) REFERENCES Users (user_id),
    -- 消费时间，默认当前时间戳
    consumption_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    -- 发送消息消耗的次数
    message_sent_count INT,
    -- 购买记录ID，如果消耗的是购买的次数，则引用购买记录ID，外键
    purchase_id        INT,
    FOREIGN KEY (purchase_id) REFERENCES UserPurchases (purchase_id)
);
CREATE TABLE RefundRecords
(
    -- 退款记录ID，主键，自动递增
    refund_id            INT PRIMARY KEY AUTO_INCREMENT,
    -- 用户ID，外键，关联Users表的user_id
    user_id              INT,
    FOREIGN KEY (user_id) REFERENCES Users (user_id),
    -- 要退款的购买记录ID，外键，关联UserPurchases表的purchase_id
    purchase_id          INT,
    FOREIGN KEY (purchase_id) REFERENCES UserPurchases (purchase_id),
    -- 退款原因
    refund_reason        TEXT,
    -- 退款状态（申请中、已同意、已拒绝、已完成退款）
    refund_status        ENUM ('APPLIED', 'APPROVED', 'REJECTED', 'COMPLETED') DEFAULT 'APPLIED',
    -- 申请退款时间，默认当前时间戳
    refund_request_time  TIMESTAMP                                             DEFAULT CURRENT_TIMESTAMP,
    -- 退款审批时间（如已批准）
    refund_approval_time TIMESTAMP,
    -- 退款金额
    refunded_amount      DECIMAL(10, 2),
    -- 标记是否已通知管理员处理退款
    admin_contacted      BOOLEAN                                               DEFAULT FALSE
);