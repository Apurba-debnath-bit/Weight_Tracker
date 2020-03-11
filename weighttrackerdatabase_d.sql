/*
MySQL Data Transfer
Source Host: localhost
Source Database: weighttrackerdatabase_d
Target Host: localhost
Target Database: weighttrackerdatabase_d
Date: 2/5/2018 11:55:08 AM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Course_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Course_Name` varchar(20) DEFAULT NULL,
  `Course_Start_Date` date DEFAULT NULL,
  `Course_End_Date` date DEFAULT NULL,
  `Course_Trainer_Name` varchar(20) DEFAULT NULL,
  `BMI_Index` double(20,0) DEFAULT NULL,
  `User_ID` int(20) DEFAULT NULL,
  PRIMARY KEY (`Course_ID`) USING BTREE,
  KEY `FK-11` (`User_ID`) USING BTREE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for daily_measurement
-- ----------------------------
DROP TABLE IF EXISTS `daily_measurement`;
CREATE TABLE `daily_measurement` (
  `Measurement_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Measurement_Date` date DEFAULT NULL,
  `Measurement_Shift` varchar(20) DEFAULT NULL,
  `Weight_Value` double(20,0) DEFAULT NULL,
  `Waist_Size` double(20,0) DEFAULT NULL,
  `DailyLog_ID` int(20) DEFAULT NULL,
  PRIMARY KEY (`Measurement_ID`) USING BTREE,
  KEY `FK_6` (`DailyLog_ID`) USING BTREE,
  CONSTRAINT `daily_measurement_ibfk_1` FOREIGN KEY (`DailyLog_ID`) REFERENCES `dailylog` (`DailyLog_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for dailylog
-- ----------------------------
DROP TABLE IF EXISTS `dailylog`;
CREATE TABLE `dailylog` (
  `DailyLog_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Log_Date` date DEFAULT NULL,
  `Activity_Level` varchar(20) DEFAULT NULL,
  `Course_ID` int(20) DEFAULT NULL,
  PRIMARY KEY (`DailyLog_ID`) USING BTREE,
  KEY `FK_10` (`Course_ID`) USING BTREE,
  CONSTRAINT `dailylog_ibfk_1` FOREIGN KEY (`Course_ID`) REFERENCES `course` (`Course_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for exercise
-- ----------------------------
DROP TABLE IF EXISTS `exercise`;
CREATE TABLE `exercise` (
  `Exercise_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Exercise_Type` varchar(20) DEFAULT NULL,
  `Exercise_Duration` int(20) DEFAULT NULL,
  `Calorie_Burnt` int(20) DEFAULT NULL,
  PRIMARY KEY (`Exercise_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for exercisedailylog
-- ----------------------------
DROP TABLE IF EXISTS `exercisedailylog`;
CREATE TABLE `exercisedailylog` (
  `ExerciseDailyLog_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Exercise_ID` int(20) DEFAULT NULL,
  `DailyLog_ID` int(20) DEFAULT NULL,
  `Total_Unit_Burnt` int(20) DEFAULT NULL,
  PRIMARY KEY (`ExerciseDailyLog_ID`) USING BTREE,
  KEY `FK_1` (`Exercise_ID`) USING BTREE,
  KEY `FK_2` (`DailyLog_ID`) USING BTREE,
  CONSTRAINT `exercisedailylog_ibfk_1` FOREIGN KEY (`Exercise_ID`) REFERENCES `exercise` (`Exercise_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `exercisedailylog_ibfk_2` FOREIGN KEY (`DailyLog_ID`) REFERENCES `dailylog` (`DailyLog_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for meal
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
  `Meal_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Meal_Name` varchar(20) DEFAULT NULL,
  `Calorie_Value` double(20,0) DEFAULT NULL,
  `Meal_Unit` float DEFAULT NULL,
  PRIMARY KEY (`Meal_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for mealdailylog
-- ----------------------------
DROP TABLE IF EXISTS `mealdailylog`;
CREATE TABLE `mealdailylog` (
  `MealDailyLog_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Meal_ID` int(20) DEFAULT NULL,
  `DailyLog_ID` int(20) DEFAULT NULL,
  `Total_Unit_Take` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`MealDailyLog_ID`) USING BTREE,
  KEY `FK_3` (`Meal_ID`) USING BTREE,
  KEY `FK_4` (`DailyLog_ID`) USING BTREE,
  CONSTRAINT `mealdailylog_ibfk_1` FOREIGN KEY (`Meal_ID`) REFERENCES `meal` (`Meal_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mealdailylog_ibfk_2` FOREIGN KEY (`DailyLog_ID`) REFERENCES `dailylog` (`DailyLog_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `User_ID` int(20) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(20) DEFAULT NULL,
  `User_Age` int(20) DEFAULT NULL,
  `User_Gender` varchar(20) DEFAULT NULL,
  `User_Height` double(20,0) DEFAULT NULL,
  `User_Weight` double(20,0) DEFAULT NULL,
  `BMI_Index` double(20,0) DEFAULT NULL,
  `User_WaistSize` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`User_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `course` VALUES ('4', 'ex', '2018-01-05', '2018-01-13', 'xx', '-13', '11');
INSERT INTO `course` VALUES ('5', 'testCourse', '2018-01-18', '2018-01-18', 'sdddddd', '-13', '11');
INSERT INTO `course` VALUES ('6', 'push up', '2018-01-10', '2018-01-18', 'sss', '-9', '12');
INSERT INTO `course` VALUES ('8', 'DDD', '2018-01-02', '2018-01-09', 'wer', '-16', '7');
INSERT INTO `course` VALUES ('9', 'Chain Up', '2018-01-02', '2018-01-31', 'Rana', null, '17');
INSERT INTO `course` VALUES ('10', 'Chain Up', null, null, 'Rana', '-26', '17');
INSERT INTO `course` VALUES ('11', '', null, null, '', null, '6');
INSERT INTO `course` VALUES ('12', 'gggg', '2018-01-15', '2018-01-22', 'jjjj', '-12', '6');
INSERT INTO `course` VALUES ('13', 'BellyCut', '2018-02-01', '2018-04-30', 'Apurba', '-26', '18');
INSERT INTO `course` VALUES ('14', 'BellyLoss', '2018-02-02', '2018-09-30', 'Apurba', '-264', '19');
INSERT INTO `course` VALUES ('15', 'RisingWeight', '2018-02-04', '2018-06-30', 'Rana', '-9', '20');
INSERT INTO `course` VALUES ('16', 'BellyCut', '2018-02-01', '2018-05-31', 'Apurba', '-12', '6');
INSERT INTO `course` VALUES ('17', 'WeightLooser', '2018-02-05', '2018-04-30', 'apurba', '-21', '21');
INSERT INTO `daily_measurement` VALUES ('1', '2018-02-01', 'Morning', '70', '32', '13');
INSERT INTO `daily_measurement` VALUES ('2', null, 'Evening', '69', '31', '13');
INSERT INTO `daily_measurement` VALUES ('3', null, '', null, null, '13');
INSERT INTO `daily_measurement` VALUES ('4', null, 'Morning', '70', '31', '14');
INSERT INTO `daily_measurement` VALUES ('5', '2018-02-02', 'Evening', '69', '45', '14');
INSERT INTO `daily_measurement` VALUES ('6', null, 'Morning', '45', '30', '15');
INSERT INTO `daily_measurement` VALUES ('7', '2018-02-02', '', '46', '32', '15');
INSERT INTO `daily_measurement` VALUES ('8', null, 'Morning', '45', '31', '16');
INSERT INTO `daily_measurement` VALUES ('9', null, '', '34', '30', '16');
INSERT INTO `daily_measurement` VALUES ('10', '2018-02-04', 'Morning', '65', '34', '17');
INSERT INTO `daily_measurement` VALUES ('11', '2018-02-04', 'Evening', '33', '28', '17');
INSERT INTO `daily_measurement` VALUES ('12', null, 'Morning', '55', '30', '18');
INSERT INTO `daily_measurement` VALUES ('13', null, 'Evening', '54', '30', '18');
INSERT INTO `daily_measurement` VALUES ('14', '2018-02-05', 'Morning', '56', '40', '19');
INSERT INTO `daily_measurement` VALUES ('15', null, 'Evening', '45', '31', '19');
INSERT INTO `daily_measurement` VALUES ('16', null, 'Morning', '45', '33', '20');
INSERT INTO `daily_measurement` VALUES ('17', null, 'Evening', '45', '33', '20');
INSERT INTO `daily_measurement` VALUES ('18', '2018-02-04', 'Morning', '34', '28', '21');
INSERT INTO `daily_measurement` VALUES ('19', '2018-02-04', 'Evening', '35', '30', '21');
INSERT INTO `daily_measurement` VALUES ('20', null, 'Morning', '45', '29', '22');
INSERT INTO `daily_measurement` VALUES ('21', null, 'Evening', '45', '28', '22');
INSERT INTO `daily_measurement` VALUES ('22', null, 'Morning', '55', '27', '23');
INSERT INTO `daily_measurement` VALUES ('23', null, 'Evening', '55', '28', '23');
INSERT INTO `daily_measurement` VALUES ('24', '2018-02-01', 'Morning', '45', '31', '24');
INSERT INTO `daily_measurement` VALUES ('25', '2018-02-01', 'Evening', '45', '30', '24');
INSERT INTO `daily_measurement` VALUES ('26', '2018-02-02', 'Morning', '55', '32', '25');
INSERT INTO `daily_measurement` VALUES ('27', '2018-02-02', 'Evening', '56', '30', '25');
INSERT INTO `daily_measurement` VALUES ('28', null, 'Morning', '57', '32', '26');
INSERT INTO `daily_measurement` VALUES ('29', '2018-02-03', 'Evening', '57', '34', '26');
INSERT INTO `daily_measurement` VALUES ('30', null, 'Morning', '55', '32', '27');
INSERT INTO `daily_measurement` VALUES ('31', null, 'Evening', '56', '44', '27');
INSERT INTO `daily_measurement` VALUES ('32', null, 'Morning', '56', '34', '28');
INSERT INTO `daily_measurement` VALUES ('33', '2018-02-05', 'Evening', '56', '34', '28');
INSERT INTO `daily_measurement` VALUES ('34', null, 'Morning', '55', '28', '30');
INSERT INTO `daily_measurement` VALUES ('35', '2018-02-06', 'Evening', '56', '28', '30');
INSERT INTO `dailylog` VALUES ('6', '2018-02-14', 'Moderately', '4');
INSERT INTO `dailylog` VALUES ('7', '2018-02-19', 'Moderately', '11');
INSERT INTO `dailylog` VALUES ('8', '2018-02-13', 'Moderately', '11');
INSERT INTO `dailylog` VALUES ('9', '2018-02-14', 'Moderately', '11');
INSERT INTO `dailylog` VALUES ('10', '2018-02-16', 'Moderately', '11');
INSERT INTO `dailylog` VALUES ('11', '2018-02-17', 'Moderately', '11');
INSERT INTO `dailylog` VALUES ('12', '2018-02-18', 'Moderately', '11');
INSERT INTO `dailylog` VALUES ('13', '2018-02-01', 'Active', '13');
INSERT INTO `dailylog` VALUES ('14', '2018-02-02', 'Active', '14');
INSERT INTO `dailylog` VALUES ('15', '2018-02-02', 'Moderately', '13');
INSERT INTO `dailylog` VALUES ('16', '2018-02-03', 'Moderately', '14');
INSERT INTO `dailylog` VALUES ('17', '2018-02-05', 'Active', '14');
INSERT INTO `dailylog` VALUES ('18', '2018-02-04', 'Active', '13');
INSERT INTO `dailylog` VALUES ('19', '2018-02-05', 'Active', '13');
INSERT INTO `dailylog` VALUES ('20', '2018-02-06', 'Active', '13');
INSERT INTO `dailylog` VALUES ('21', '2018-02-04', 'Active', '15');
INSERT INTO `dailylog` VALUES ('22', '2018-02-05', 'Active', '15');
INSERT INTO `dailylog` VALUES ('23', '2018-02-05', 'Active', '14');
INSERT INTO `dailylog` VALUES ('24', '2018-02-01', 'Active', '16');
INSERT INTO `dailylog` VALUES ('25', '2018-02-02', 'Active', '16');
INSERT INTO `dailylog` VALUES ('26', '2018-02-03', 'Active', '16');
INSERT INTO `dailylog` VALUES ('27', '2018-02-04', 'Active', '16');
INSERT INTO `dailylog` VALUES ('28', '2018-02-05', 'Active', '16');
INSERT INTO `dailylog` VALUES ('29', '2018-02-06', 'Active', '16');
INSERT INTO `dailylog` VALUES ('30', '2018-02-05', 'Active', '17');
INSERT INTO `exercise` VALUES ('1', 'wer', '25', '23');
INSERT INTO `exercise` VALUES ('2', 'rrr', '24', '23');
INSERT INTO `exercise` VALUES ('3', 'ChainUp', '20', '10');
INSERT INTO `exercisedailylog` VALUES ('2', '3', '6', '56');
INSERT INTO `exercisedailylog` VALUES ('3', '3', '13', '40');
INSERT INTO `exercisedailylog` VALUES ('4', '1', '13', '30');
INSERT INTO `exercisedailylog` VALUES ('5', '2', '13', '20');
INSERT INTO `exercisedailylog` VALUES ('6', '3', '14', '20');
INSERT INTO `exercisedailylog` VALUES ('7', '2', '14', '20');
INSERT INTO `exercisedailylog` VALUES ('8', '1', '14', '20');
INSERT INTO `exercisedailylog` VALUES ('9', '1', '15', '100');
INSERT INTO `exercisedailylog` VALUES ('10', '2', '15', '20');
INSERT INTO `exercisedailylog` VALUES ('11', '3', '15', '100');
INSERT INTO `exercisedailylog` VALUES ('12', '3', '16', '22');
INSERT INTO `exercisedailylog` VALUES ('13', '2', '16', '23');
INSERT INTO `exercisedailylog` VALUES ('14', '1', '16', '21');
INSERT INTO `exercisedailylog` VALUES ('15', '1', '17', '12');
INSERT INTO `exercisedailylog` VALUES ('16', '3', '17', '170');
INSERT INTO `exercisedailylog` VALUES ('17', '2', '17', '24');
INSERT INTO `exercisedailylog` VALUES ('18', '3', '18', '100');
INSERT INTO `exercisedailylog` VALUES ('19', '2', '18', '100');
INSERT INTO `exercisedailylog` VALUES ('20', '2', '18', '100');
INSERT INTO `exercisedailylog` VALUES ('21', '3', '19', '100');
INSERT INTO `exercisedailylog` VALUES ('22', '2', '19', '100');
INSERT INTO `exercisedailylog` VALUES ('23', '1', '19', '100');
INSERT INTO `exercisedailylog` VALUES ('24', '1', '20', '100');
INSERT INTO `exercisedailylog` VALUES ('25', '2', '20', '100');
INSERT INTO `exercisedailylog` VALUES ('26', '3', '20', '100');
INSERT INTO `exercisedailylog` VALUES ('27', '1', '21', '24');
INSERT INTO `exercisedailylog` VALUES ('28', '2', '21', '25');
INSERT INTO `exercisedailylog` VALUES ('29', '3', '21', '30');
INSERT INTO `exercisedailylog` VALUES ('30', '3', '22', '12');
INSERT INTO `exercisedailylog` VALUES ('31', '2', '22', '24');
INSERT INTO `exercisedailylog` VALUES ('32', '2', '23', '123');
INSERT INTO `exercisedailylog` VALUES ('33', '3', '23', '122');
INSERT INTO `exercisedailylog` VALUES ('34', '2', '23', '122');
INSERT INTO `exercisedailylog` VALUES ('35', '3', '24', '122');
INSERT INTO `exercisedailylog` VALUES ('36', '2', '24', '123');
INSERT INTO `exercisedailylog` VALUES ('37', '1', '24', '123');
INSERT INTO `exercisedailylog` VALUES ('38', '1', '25', '1222');
INSERT INTO `exercisedailylog` VALUES ('39', '3', '25', '122');
INSERT INTO `exercisedailylog` VALUES ('40', '2', '25', '100');
INSERT INTO `exercisedailylog` VALUES ('41', '3', '27', '100');
INSERT INTO `exercisedailylog` VALUES ('42', '2', '27', '100');
INSERT INTO `exercisedailylog` VALUES ('43', '1', '27', '100');
INSERT INTO `exercisedailylog` VALUES ('44', '3', '30', '123');
INSERT INTO `exercisedailylog` VALUES ('45', '2', '30', '122');
INSERT INTO `meal` VALUES ('3', 'butter', '50', '3');
INSERT INTO `meal` VALUES ('4', 'rice', '12', '25');
INSERT INTO `meal` VALUES ('7', 'chicken', '45', '25');
INSERT INTO `mealdailylog` VALUES ('1', '7', '13', '25');
INSERT INTO `mealdailylog` VALUES ('2', '4', '13', null);
INSERT INTO `mealdailylog` VALUES ('3', '3', '13', null);
INSERT INTO `mealdailylog` VALUES ('4', '3', '14', '40');
INSERT INTO `mealdailylog` VALUES ('5', '7', '14', '100');
INSERT INTO `mealdailylog` VALUES ('6', '4', '14', '200');
INSERT INTO `mealdailylog` VALUES ('7', '7', '15', '23');
INSERT INTO `mealdailylog` VALUES ('8', '4', '15', '100');
INSERT INTO `mealdailylog` VALUES ('9', '3', '15', '25');
INSERT INTO `mealdailylog` VALUES ('10', '4', '16', '34');
INSERT INTO `mealdailylog` VALUES ('11', '3', '16', '20');
INSERT INTO `mealdailylog` VALUES ('12', '7', '16', '29');
INSERT INTO `mealdailylog` VALUES ('13', '3', '17', '23');
INSERT INTO `mealdailylog` VALUES ('14', '4', '17', '23');
INSERT INTO `mealdailylog` VALUES ('15', '7', '17', '23');
INSERT INTO `mealdailylog` VALUES ('16', '3', '18', '34');
INSERT INTO `mealdailylog` VALUES ('17', '4', '18', '33');
INSERT INTO `mealdailylog` VALUES ('18', '7', '18', '12');
INSERT INTO `mealdailylog` VALUES ('19', '3', '19', '100');
INSERT INTO `mealdailylog` VALUES ('20', '4', '19', '100');
INSERT INTO `mealdailylog` VALUES ('21', '7', '19', '200');
INSERT INTO `mealdailylog` VALUES ('22', '3', '20', '100');
INSERT INTO `mealdailylog` VALUES ('23', '4', '20', '100');
INSERT INTO `mealdailylog` VALUES ('24', '7', '20', '100');
INSERT INTO `mealdailylog` VALUES ('25', '7', '21', '100');
INSERT INTO `mealdailylog` VALUES ('26', '4', '21', '200');
INSERT INTO `mealdailylog` VALUES ('27', '3', '21', '100');
INSERT INTO `mealdailylog` VALUES ('28', '3', '22', '23');
INSERT INTO `mealdailylog` VALUES ('29', '4', '22', '24');
INSERT INTO `mealdailylog` VALUES ('30', '7', '22', '34');
INSERT INTO `mealdailylog` VALUES ('31', '3', '23', '100');
INSERT INTO `mealdailylog` VALUES ('32', '4', '23', '100');
INSERT INTO `mealdailylog` VALUES ('33', '7', '23', '120');
INSERT INTO `mealdailylog` VALUES ('34', '4', '24', '23');
INSERT INTO `mealdailylog` VALUES ('35', '7', '24', '44');
INSERT INTO `mealdailylog` VALUES ('36', '4', '24', '100');
INSERT INTO `mealdailylog` VALUES ('37', '4', '25', '100');
INSERT INTO `mealdailylog` VALUES ('38', '7', '25', '100');
INSERT INTO `mealdailylog` VALUES ('39', '3', '25', '122');
INSERT INTO `mealdailylog` VALUES ('40', '4', '26', '100');
INSERT INTO `mealdailylog` VALUES ('41', '7', '26', '100');
INSERT INTO `mealdailylog` VALUES ('42', '3', '26', '100');
INSERT INTO `mealdailylog` VALUES ('43', '4', '27', '100');
INSERT INTO `mealdailylog` VALUES ('44', '7', '27', '122');
INSERT INTO `mealdailylog` VALUES ('45', '7', '28', '100');
INSERT INTO `mealdailylog` VALUES ('46', '4', '28', '122');
INSERT INTO `mealdailylog` VALUES ('47', '3', '28', '122');
INSERT INTO `mealdailylog` VALUES ('48', '4', '28', '100');
INSERT INTO `mealdailylog` VALUES ('49', '3', '30', '234');
INSERT INTO `mealdailylog` VALUES ('50', '7', '30', '234');
INSERT INTO `user` VALUES ('6', 'Apu', '15', 'Male', '23', '22', '6', '23');
INSERT INTO `user` VALUES ('7', 'Shuvra', '25', 'Female', '1', '60', '40', '35');
INSERT INTO `user` VALUES ('8', 'Rotho', '23', 'Female', '2', '45', '23', '40');
INSERT INTO `user` VALUES ('11', 'partho', '25', 'Female', '1', '53', '37', '34');
INSERT INTO `user` VALUES ('12', 'Shuvra', '23', 'Female', '1', '47', '33', '32');
INSERT INTO `user` VALUES ('13', 'Apurba', '24', 'Male', '1', '59', '59', '34');
INSERT INTO `user` VALUES ('14', 'wer', '24', 'Female', '1', '100', '100', '46');
INSERT INTO `user` VALUES ('15', 'bbb', '34', 'Male', '1', '24', '24', '2');
INSERT INTO `user` VALUES ('16', 'Jhulon', '25', 'Male', '1', '56', '56', '32');
INSERT INTO `user` VALUES ('17', 'Rubby', '25', 'Male', '1', '50', '50', '32');
INSERT INTO `user` VALUES ('18', 'Krishna', '34', 'Male', '1', '72', '72', '33');
INSERT INTO `user` VALUES ('19', 'Rob', '45', 'Male', '0', '72', '288', '34');
INSERT INTO `user` VALUES ('20', 'Pagla', '23', 'Male', '2', '35', '9', '28');
INSERT INTO `user` VALUES ('21', 'roff', '23', 'Male', '1', '45', '45', '46');
INSERT INTO `user` VALUES ('22', 'Krishna', '34', 'Male', '1', '72', '72', '34');
