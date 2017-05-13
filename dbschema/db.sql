drop database if exists schoolproject;
create database schoolproject;
use schoolproject;

drop table if exists certificate;
CREATE TABLE certificate (
  id varchar(100) NOT NULL default '',
  `describe` varchar(100) default '',
  
  PRIMARY KEY  (id)
) ENGINE = InnoDB
CHARACTER SET utf8 COLLATE utf8_general_ci;


--
-- Dumping data for table 'certificate'
--

INSERT INTO certificate VALUES ('ff80808105416d3b0105416d3eca0001','tomclus');
INSERT INTO certificate VALUES ('ff808081054175b501054175b9190001','tom');

--
-- Table structure for table 'student'
--
drop table if exists student;
CREATE TABLE student (
  id varchar(100) NOT NULL default '',
  name varchar(20) default '',
  `cardId` varchar(20) NOT NULL default '',
  age int(11) default '0',
  PRIMARY KEY  (id)
) ENGINE = InnoDB
CHARACTER SET utf8 COLLATE utf8_general_ci;

--
-- Dumping data for table 'student'
--

INSERT INTO student VALUES ('ff80808105416d3b0105416d3eca0001','tomclus','200512345',33);
INSERT INTO student VALUES ('ff808081054175b501054175b9190001','tom','11111111',33);

