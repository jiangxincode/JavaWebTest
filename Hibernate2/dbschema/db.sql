drop database if exists schoolproject;
create database schoolproject;
use schoolproject;
--
-- Table structure for table `certificate`
--
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate` (
  `id` varchar(100) NOT NULL default '',
  `describe` varchar(100) default '',
  `stu_id` varchar(32) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `certificate`
--


/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
LOCK TABLES `certificate` WRITE;
INSERT INTO `certificate` VALUES ('5abfa70605c5356f0105c53573360002','tomclus','5abfa70605c5356f0105c535730e0001');
INSERT INTO `certificate` VALUES ('5abfa70605c535a60105c535aa370002','tom','5abfa70605c535a60105c535aa040001');
UNLOCK TABLES;
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;

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
INSERT INTO `student` VALUES ('5abfa70605c5356f0105c535730e0001','tomclus','200212345',33);
INSERT INTO `student` VALUES ('5abfa70605c535a60105c535aa040001','tom','200254321',33);
UNLOCK TABLES;


