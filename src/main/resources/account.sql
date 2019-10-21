-- ----------------------------
-- create table account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
`id`  int(4) NOT NULL AUTO_INCREMENT ,
`name`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`balance`  decimal(11,0) NOT NULL DEFAULT 0 ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- add data
-- ----------------------------
INSERT INTO `account` (`id`, `name`, `balance`) VALUES ('1', 'zhangsan', '2000');
INSERT INTO `account` (`id`, `name`, `balance`) VALUES ('2', 'lisi', '2000');