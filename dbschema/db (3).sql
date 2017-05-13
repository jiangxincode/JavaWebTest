drop database if exists schoolproject;
create database schoolproject;
use schoolproject;
--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` varchar(32) NOT NULL default '',
  `name` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `course`
--


/*!40000 ALTER TABLE `course` DISABLE KEYS */;
LOCK TABLES `course` WRITE;
INSERT INTO `course` VALUES ('5abfe4c705ca8ee00105ca8ee45d0002','history');
INSERT INTO `course` VALUES ('5abfe4c705ca8f5e0105ca8f62400002','computer');
INSERT INTO `course` VALUES ('5abfe4c705ca8faf0105ca8fb3750002','music');
INSERT INTO `course` VALUES ('5abfe4c705ca901f0105ca9024290002','ecnomic');
INSERT INTO `course` VALUES ('5abfe4c705ca98420105ca98475a0001','politics');
UNLOCK TABLES;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(100) NOT NULL default '',
  `name` varchar(20) default '',
  `cardId` varchar(20) NOT NULL default '',
  `age` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--


/*!40000 ALTER TABLE `student` DISABLE KEYS */;
LOCK TABLES `student` WRITE;
INSERT INTO `student` VALUES ('5abfe4c705ca8ee00105ca8ee42b0001','tomclus','1',25);
INSERT INTO `student` VALUES('5abfe4c705ca8f5e0105ca8f620d0001','tom','2',25);
INSERT INTO `student` VALUES('5abfe4c705ca8faf0105ca8fb3390001','spark','3',25);
INSERT INTO `student` VALUES('5abfe4c705ca901f0105ca9023f70001','jerry','4',25);
UNLOCK TABLES;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `stu_id` varchar(32) NOT NULL default '',
  `course_id` varchar(32) NOT NULL default '',
  PRIMARY KEY  (`stu_id`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student_course`
--


/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
LOCK TABLES `student_course` WRITE;
INSERT INTO `student_course` VALUES ('5abfe4c705ca8ee00105ca8ee42b0001','5abfe4c705ca8ee00105ca8ee45d0002');
INSERT INTO `student_course` VALUES ('5abfe4c705ca8ee00105ca8ee42b0001','5abfe4c705ca8f5e0105ca8f62400002');
INSERT INTO `student_course` VALUES ('5abfe4c705ca8ee00105ca8ee42b0001','5abfe4c705ca8faf0105ca8fb3750002');
INSERT INTO `student_course` VALUES ('5abfe4c705ca8f5e0105ca8f620d0001','5abfe4c705ca8f5e0105ca8f62400002');
INSERT INTO `student_course` VALUES ('5abfe4c705ca8f5e0105ca8f620d0001','5abfe4c705ca901f0105ca9024290002');
INSERT INTO `student_course` VALUES ('5abfe4c705ca8faf0105ca8fb3390001','5abfe4c705ca8f5e0105ca8f62400002');
INSERT INTO `student_course` VALUES ('5abfe4c705ca8faf0105ca8fb3390001','5abfe4c705ca8faf0105ca8fb3750002');
UNLOCK TABLES;


