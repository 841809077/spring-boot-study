CREATE TABLE `novel_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `download` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `novelauthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `novelname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of novel_type
-- ----------------------------
INSERT INTO `novel_type` VALUES (1, '已下载', NULL, NULL, NULL, NULL);
INSERT INTO `novel_type` VALUES (2, '已下载', NULL, NULL, NULL, NULL);
INSERT INTO `novel_type` VALUES (3, NULL, NULL, NULL, NULL, NULL);