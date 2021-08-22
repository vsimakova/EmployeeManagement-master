-- MySQL
--
-- Host: 127.0.0.1    Database: employeemanagementsystem
-- ------------------------------------------------------
--
-- Table structure for table `department`
--
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`
(
   `DEPARTMENT_ID` int (11) NOT NULL AUTO_INCREMENT,
   `SHORT_NAME` varchar (10) DEFAULT NULL,
   `DEPARTMENT_NAME` varchar (100) DEFAULT NULL,
   PRIMARY KEY (`DEPARTMENT_ID`)
);
--
INSERT INTO `department` VALUES
(
   1,
   'HR',
   'Human Resources Management'
),

(
   2,
   'IT',
   'Information Technology'
),

(
   3,
   'ENGG',
   'Engineering'
),

(
   4,
   'R&D',
   'Research and Development'
),

(
   5,
   'MK',
   'Marketing'
),

(
   6,
   'ACNT',
   'Accounting'
);
--
DROP TABLE IF EXISTS `employee`;
--
CREATE TABLE `employee`
(
   `EMPLOYEE_ID` int (11) NOT NULL AUTO_INCREMENT,
   `FIRST_NAME` varchar (50) DEFAULT NULL,
   `LAST_NAME` varchar (50) DEFAULT NULL,
   `department_id` int (11) NOT NULL,
   PRIMARY KEY (`EMPLOYEE_ID`),
   KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`),
   CONSTRAINT `FKbejtwvg9bxus2mffsm3swj3u9` FOREIGN KEY (`department_id`) REFERENCES `department` (`DEPARTMENT_ID`)
);
INSERT INTO `employee` VALUES
(
   1,
   'Apoorva',
   'Joshi',
   4
),

(
   2,
   'Tim',
   'Cook',
   3
);