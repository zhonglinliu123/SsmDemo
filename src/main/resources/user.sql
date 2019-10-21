-- ----------------------------
-- create table user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- add user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '测试一', '15', '男');
INSERT INTO `user` VALUES ('2', '测试二', '29', '男');
INSERT INTO `user` VALUES ('3', '测试三', '18', '男');
INSERT INTO `user` VALUES ('4', '测试四', '18', '男');
INSERT INTO `user` VALUES ('5', '测试五', '26', '女');
INSERT INTO `user` VALUES ('6', '测试六', '30', '男');
INSERT INTO `user` VALUES ('7', '测试七', '10', '男');
INSERT INTO `user` VALUES ('8', '测试八', '16', '女');
INSERT INTO `user` VALUES ('9', '测试九', '26', '女');
INSERT INTO `user` VALUES ('10', '测试十', '30', '男');