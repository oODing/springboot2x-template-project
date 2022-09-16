-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
-- 创建一个表，指定了4个属性：id、年龄、身高、体重。最后指定了id是唯一不能重复的键值
CREATE TABLE IF NOT EXISTS `users` (`id` integer NOT NULL, `name` varchar(20),  `age` integer, PRIMARY  KEY(`id`));

-- 插入数据，分别是 姓名（id）、年龄
INSERT INTO `users` VALUES ('1', 'Mac', '123');
INSERT INTO `users` VALUES ('2', 'Jack', '432');


