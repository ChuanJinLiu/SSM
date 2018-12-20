/*
Navicat MySQL Data Transfer

Source Server         : Online
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-11-13 10:14:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mainPeople_id` int(4) DEFAULT NULL,
  `trade_num` int(4) DEFAULT NULL,
  `money` int(4) DEFAULT NULL,
  `offer_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `trade_description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL COMMENT '是否付款',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1', '金手指', '1', '5', '1532', 'Afaccd', '一个开挂的东西', '1', '2018-11-07 21:17:51');
INSERT INTO `bill` VALUES ('2', 'DELL笔记本', '2', '1', '5700', 'DELL', '笔记本电脑', '1', '2018-11-07 21:17:52');
INSERT INTO `bill` VALUES ('3', 'Typec接口USB', '3', '100', '230', 'Shandi', 'USB数据线', '1', '2018-11-07 21:17:54');
INSERT INTO `bill` VALUES ('4', '删除测试', '4', '2', '222', 'ss', '123132', '1', '2018-11-07 21:18:48');
INSERT INTO `bill` VALUES ('5', '招收人员', '5', '23', '1513', 'zz', '招收人员啊啊啊', '1', '2018-11-13 21:18:49');
INSERT INTO `bill` VALUES ('6', '6号人员测试物品', '6', '123', '5553', 'sad', '啊哈上海市', '1', '2018-11-12 21:19:32');
INSERT INTO `bill` VALUES ('7', '7号人员测试物品', '7', '266', '89383', 'safgh', '阿达发顺丰', '1', '2018-11-07 21:20:35');
INSERT INTO `bill` VALUES ('8', '8号人员测试物品', '8', '832', '48422', 'hfgh', '电饭锅水电费等', '1', '2018-11-07 21:20:45');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `addr` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `paifang` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zuowei` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `oil` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `lunzi` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `qudon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '大众', '贵州', '4', '4', '97柴油', '4个', '双驱');
INSERT INTO `car` VALUES ('2', '奔驰', '西安', '4', '7', '97柴油', '4个', '前驱');
INSERT INTO `car` VALUES ('3', '劳斯莱斯', '美国', '4', '7', '97柴油', '4个', '前驱');
INSERT INTO `car` VALUES ('4', '法拉利', '德国', '4', '7', '97柴油', '4个', '前驱');
INSERT INTO `car` VALUES ('5', '北京现代', '北京', '4', '7', '97柴油', '4个', '前驱');
INSERT INTO `car` VALUES ('6', '雪佛兰', '湖南', '4', '5', '97柴油', '4个', '前驱');
INSERT INTO `car` VALUES ('7', '兰博基尼', '法国', '4', '7', '97柴油', '4个', '前驱');
INSERT INTO `car` VALUES ('8', '红旗', '中国', '4', '7', '97柴油', '4个', '前驱');
INSERT INTO `car` VALUES ('9', '凯迪拉克', '河北', '4', '4', '97柴油', '4个', '前驱');
INSERT INTO `car` VALUES ('10', '保时捷', '贵州', '4', '4', '97柴油', '4个', '前驱');

-- ----------------------------
-- Table structure for carfortype
-- ----------------------------
DROP TABLE IF EXISTS `carfortype`;
CREATE TABLE `carfortype` (
  `id` int(4) NOT NULL,
  `car_id` int(4) DEFAULT NULL,
  `type_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of carfortype
-- ----------------------------
INSERT INTO `carfortype` VALUES ('1', '1', '5');
INSERT INTO `carfortype` VALUES ('2', '1', '3');
INSERT INTO `carfortype` VALUES ('3', '1', '2');
INSERT INTO `carfortype` VALUES ('4', '1', '1');
INSERT INTO `carfortype` VALUES ('5', '2', '8');
INSERT INTO `carfortype` VALUES ('6', '2', '3');
INSERT INTO `carfortype` VALUES ('7', '2', '4');
INSERT INTO `carfortype` VALUES ('8', '2', '6');
INSERT INTO `carfortype` VALUES ('9', '3', '9');
INSERT INTO `carfortype` VALUES ('10', '3', '6');
INSERT INTO `carfortype` VALUES ('11', '3', '7');
INSERT INTO `carfortype` VALUES ('12', '4', '7');
INSERT INTO `carfortype` VALUES ('13', '5', '5');
INSERT INTO `carfortype` VALUES ('14', '5', '3');
INSERT INTO `carfortype` VALUES ('15', '5', '4');
INSERT INTO `carfortype` VALUES ('16', '6', '2');
INSERT INTO `carfortype` VALUES ('17', '6', '8');
INSERT INTO `carfortype` VALUES ('18', '6', '9');
INSERT INTO `carfortype` VALUES ('19', '7', '4');
INSERT INTO `carfortype` VALUES ('20', '7', '10');
INSERT INTO `carfortype` VALUES ('21', '7', '4');
INSERT INTO `carfortype` VALUES ('22', '8', '5');
INSERT INTO `carfortype` VALUES ('23', '8', '7');
INSERT INTO `carfortype` VALUES ('24', '9', '1');
INSERT INTO `carfortype` VALUES ('25', '9', '7');
INSERT INTO `carfortype` VALUES ('26', '9', '4');
INSERT INTO `carfortype` VALUES ('27', '10', '10');
INSERT INTO `carfortype` VALUES ('28', '10', '2');
INSERT INTO `carfortype` VALUES ('29', '10', '6');
INSERT INTO `carfortype` VALUES ('30', '10', '7');

-- ----------------------------
-- Table structure for car_type
-- ----------------------------
DROP TABLE IF EXISTS `car_type`;
CREATE TABLE `car_type` (
  `id` int(4) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of car_type
-- ----------------------------
INSERT INTO `car_type` VALUES ('1', 'SUV');
INSERT INTO `car_type` VALUES ('2', '轿车');
INSERT INTO `car_type` VALUES ('3', '跑车');
INSERT INTO `car_type` VALUES ('4', '货车');
INSERT INTO `car_type` VALUES ('5', '面包车');
INSERT INTO `car_type` VALUES ('6', '摩托车');
INSERT INTO `car_type` VALUES ('7', '商务车');
INSERT INTO `car_type` VALUES ('8', '房车');
INSERT INTO `car_type` VALUES ('9', '电动车');
INSERT INTO `car_type` VALUES ('10', '自行车');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `num` int(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gongsi` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '技术部', '负责项目的开发', '3', '2018-11-07 22:02:26', '做好一个好的技术开发', '雄起集团', '暂无');
INSERT INTO `dept` VALUES ('2', '运营部', '负责项目的后期运维', '3', '2018-11-07 22:02:26', '不容许出一点bug', '雄起集团', '暂无');
INSERT INTO `dept` VALUES ('3', '销售部', '负责产品的销售', '2', '2018-11-07 22:02:26', '卖出去！！！', '雄起集团', '暂无');
INSERT INTO `dept` VALUES ('4', '人力资源部', '负责人才的引进的招聘', '2', '2018-11-07 22:02:27', '大家快来啊，资源好，福利多！', '雄起集团', '暂无');

-- ----------------------------
-- Table structure for dept_work
-- ----------------------------
DROP TABLE IF EXISTS `dept_work`;
CREATE TABLE `dept_work` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dept_id` int(4) DEFAULT NULL,
  `work_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dept_work
-- ----------------------------
INSERT INTO `dept_work` VALUES ('1', '临时组合1', '1', '1');
INSERT INTO `dept_work` VALUES ('2', '临时组合2', '1', '2');
INSERT INTO `dept_work` VALUES ('3', '临时组合3', '1', '3');
INSERT INTO `dept_work` VALUES ('4', '临时组合4', '2', '2');
INSERT INTO `dept_work` VALUES ('5', '临时组合5', '3', '2');
INSERT INTO `dept_work` VALUES ('6', '临时组合6', '3', '4');
INSERT INTO `dept_work` VALUES ('7', '临时组合7', '3', '1');
INSERT INTO `dept_work` VALUES ('8', '临时组合8', '2', '5');
INSERT INTO `dept_work` VALUES ('9', '临时组合9', '2', '8');
INSERT INTO `dept_work` VALUES ('10', '临时组合10', '1', '7');
INSERT INTO `dept_work` VALUES ('11', '临时组合11', '4', '5');
INSERT INTO `dept_work` VALUES ('12', '临时组合12', '4', '6');
INSERT INTO `dept_work` VALUES ('13', '临时组合13', '4', '3');

-- ----------------------------
-- Table structure for man
-- ----------------------------
DROP TABLE IF EXISTS `man`;
CREATE TABLE `man` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `high` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `height` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hobby` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `wife_id` int(4) DEFAULT NULL,
  `offer` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `money` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of man
-- ----------------------------
INSERT INTO `man` VALUES ('1', '张三', '男', '22', '173', '56', '打篮球', '1', '搬砖', '5238402');
INSERT INTO `man` VALUES ('2', '李四', '男', '23', '172', '55', '游泳', '2', '运动员', '2000000');
INSERT INTO `man` VALUES ('3', '王二麻子', '男', '32', '165', '50', '无', '3', '无业游民', '1024');

-- ----------------------------
-- Table structure for woman
-- ----------------------------
DROP TABLE IF EXISTS `woman`;
CREATE TABLE `woman` (
  `w_id` int(4) NOT NULL AUTO_INCREMENT,
  `w_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `w_sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `w_age` int(4) DEFAULT NULL,
  `w_high` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `w_height` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `w_hobby` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `w_offer` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `w_money` int(6) DEFAULT NULL,
  PRIMARY KEY (`w_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of woman
-- ----------------------------
INSERT INTO `woman` VALUES ('1', '翠花', '女', '22', '163', '45', '打篮球', '种地', '55552');
INSERT INTO `woman` VALUES ('2', '丫蛋', '女', '23', '162', '44', '游泳', '运动员', '13332');
INSERT INTO `woman` VALUES ('3', '瓜皮', '女', '28', '160', '40', '无', '无业游民', '1024');

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `id1` int(4) NOT NULL AUTO_INCREMENT,
  `name1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `dept_id` int(4) DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `high` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hobby` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `addr` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id1`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('1', '刘传锦', '男', '20', '1', '15286546506', '1157464268@qq.com', '178cm', '编写代码', '大学城');
INSERT INTO `worker` VALUES ('2', '谢印', '男', '19', '1', '12345678954', '56898223@qq.com', '173cm', '编写代码', '大学城');
INSERT INTO `worker` VALUES ('3', '张三', '男', '25', '2', '548941818', '135114@qq.com', '170cm', '游泳', '花果园');
INSERT INTO `worker` VALUES ('4', '李四', '男', '30', '2', '48238484546', '248756454@', '172cm', '看书', '花溪');
INSERT INTO `worker` VALUES ('5', '王二麻子', '男', '32', '3', '4145411515', '1281548545634@qq. com', '163cm', '打游戏', '天堂');
INSERT INTO `worker` VALUES ('6', '上官翠花', '女', '22', '3', '4511841124', '151144545@qq.com', '163cm', '逛街', '南海');
INSERT INTO `worker` VALUES ('7', '皇甫铁牛', '男', '25', '2', '178823481', '1861548@qq.com', '175cm', '拳击', '大力馒头村');
INSERT INTO `worker` VALUES ('8', '小红', '女', '21', '4', '861515825', '15111848@qq.com', '160cm', '化妆', '北海道');
INSERT INTO `worker` VALUES ('9', '二狗慌得一批', '男', '22', '1', '1861186486', '151861186@qq.com', '170cm', '编写代码', '狗窝');
INSERT INTO `worker` VALUES ('10', '隔壁老王', '男', '45', '4', '1861616', '5416851651@qq.com', '169cm', '看隔壁的小张', '隔壁');
