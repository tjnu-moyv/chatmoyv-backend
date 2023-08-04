-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`                   bigint                                                        NOT NULL AUTO_INCREMENT,
    `username`             varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `password`             varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `nickname`             varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL     DEFAULT 'user',
    `gender`               tinyint                                                       NULL     DEFAULT 0,
    `email`                varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL     DEFAULT NULL,
    `phone_number`         varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL     DEFAULT NULL,
    `birthday`             datetime                                                      NULL     DEFAULT NULL,
    `address`              varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL     DEFAULT NULL,
    `education`            varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL     DEFAULT NULL,
    `occupation`           varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL     DEFAULT NULL,
    `interests`            varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL     DEFAULT NULL,
    `bio`                  varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL     DEFAULT NULL,
    `last_login_time`      datetime                                                      NULL     DEFAULT NULL,
    `password_change_time` datetime                                                      NULL     DEFAULT NULL,
    `create_time`          datetime                                                      NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `user_status`          tinyint                                                       NOT NULL DEFAULT 0 COMMENT '用户状态 0 - 正常',
    `role`                 tinyint                                                       NULL     DEFAULT 0 COMMENT '用户角色',
    `is_delete`            tinyint                                                       NOT NULL DEFAULT 0 COMMENT '是否删除',
    `update_time`          datetime                                                      NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `username` (`username` ASC) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_relations
-- ----------------------------
DROP TABLE IF EXISTS `user_relations`;
CREATE TABLE `user_relations`
(
    `id`          bigint   NOT NULL AUTO_INCREMENT,
    `user_id`     bigint   NOT NULL,
    `friend_id`   bigint   NOT NULL,
    `status`      tinyint  NULL     DEFAULT 0,
    `create_time` datetime NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_delete`   tinyint  NOT NULL DEFAULT 0 COMMENT '是否删除',
    `update_time` datetime NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`
(
    `id`          bigint                                                         NOT NULL AUTO_INCREMENT,
    `sender_id`   bigint                                                         NOT NULL,
    `receiver_id` bigint                                                         NOT NULL,
    `type`        bigint                                                         NOT NULL DEFAULT 0,
    `content`     varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `is_read`     tinyint                                                        NULL     DEFAULT 0,
    `create_time` datetime                                                       NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_delete`   tinyint                                                        NOT NULL DEFAULT 0 COMMENT '是否删除',
    `update_time` datetime                                                       NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for moment
-- ----------------------------
DROP TABLE IF EXISTS `moment`;
CREATE TABLE `moment`
(
    `id`            bigint                                                         NOT NULL AUTO_INCREMENT,
    `user_id`       bigint                                                         NOT NULL,
    `content`       varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `like_count`    int                                                            NOT NULL DEFAULT 0,
    `comment_count` int                                                            NULL     DEFAULT 0,
    `image_list`    varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL,
    `create_time`   datetime                                                       NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_delete`     tinyint                                                        NOT NULL DEFAULT 0 COMMENT '是否删除',
    `update_time`   datetime                                                       NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for moment_comment
-- ----------------------------
DROP TABLE IF EXISTS `moment_comment`;
CREATE TABLE `moment_comment`
(
    `id`          bigint                                                         NOT NULL AUTO_INCREMENT,
    `moment_id`   bigint                                                         NOT NULL,
    `user_id`     bigint                                                         NOT NULL,
    `content`     varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `create_time` datetime                                                       NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_delete`   tinyint                                                        NOT NULL DEFAULT 0 COMMENT '是否删除',
    `update_time` datetime                                                       NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for moment_like
-- ----------------------------
DROP TABLE IF EXISTS `moment_like`;
CREATE TABLE `moment_like`
(
    `id`          bigint   NOT NULL AUTO_INCREMENT,
    `moment_id`   bigint   NOT NULL,
    `user_id`     bigint   NOT NULL,
    `create_time` datetime NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_delete`   tinyint  NOT NULL DEFAULT 0 COMMENT '是否删除',
    `update_time` datetime NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite`
(
    `id`      bigint                                                         NOT NULL AUTO_INCREMENT,
    `user_id` bigint                                                         NOT NULL,
    `content` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;