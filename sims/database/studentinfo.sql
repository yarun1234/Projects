-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 03, 2019 at 05:16 PM
-- Server version: 5.7.24
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentinfo`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `adminid` bigint(4) NOT NULL AUTO_INCREMENT,
  `password` varchar(50) NOT NULL,
  `adminname` varchar(80) NOT NULL,
  `address` text NOT NULL,
  `contactno` varchar(25) NOT NULL,
  PRIMARY KEY (`adminid`),
  UNIQUE KEY `adminname` (`adminname`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`adminid`, `password`, `adminname`, `address`, `contactno`) VALUES
(126, '308a3820e4cccbe043cb5228de5e71e3', 'mayank', 'itarsi', '9144494331'),
(127, '2d235ace000a3ad85f590e321c89bb99', 'rohit', 'indore', '9144494331');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `contactid` bigint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `emailid` varchar(30) NOT NULL,
  `contactno` varchar(20) NOT NULL,
  `subject` varchar(20) NOT NULL,
  `message` text NOT NULL,
  PRIMARY KEY (`contactid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`contactid`, `name`, `emailid`, `contactno`, `subject`, `message`) VALUES
(1, 'Rajat', 'ayushwagdre05@gmail.com', '8962342099', 'XYZ', 'Test Email'),
(2, 'kissan', 'kissan@gmail.com', '983284973', 'hello', 'hello');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `courseid` bigint(4) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(40) NOT NULL,
  `comment` text NOT NULL,
  `coursekey` varchar(15) NOT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`courseid`, `coursename`, `comment`, `coursekey`) VALUES
(3, 'Bachelor of Bussiness Management', 'This course is related to Bussiness field.', 'BBM'),
(4, 'Bachelor of Science', 'This field is related to science field.', 'BSc'),
(5, 'BBA', 'The course related to business field', 'CDA102'),
(6, 'MCA', 'field realted to Master of Computer Applications', 'MCA101');

-- --------------------------------------------------------

--
-- Table structure for table `examination`
--

DROP TABLE IF EXISTS `examination`;
CREATE TABLE IF NOT EXISTS `examination` (
  `examid` bigint(4) NOT NULL AUTO_INCREMENT,
  `studid` varchar(20) NOT NULL,
  `subid` bigint(4) NOT NULL,
  `courseid` bigint(4) NOT NULL,
  `semester` int(50) NOT NULL,
  `internaltype` varchar(20) NOT NULL,
  `maxmarks` int(2) NOT NULL,
  `scored` int(2) NOT NULL,
  PRIMARY KEY (`examid`),
  KEY `subid` (`subid`),
  KEY `studid` (`studid`),
  KEY `courseid` (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `examination`
--

INSERT INTO `examination` (`examid`, `studid`, `subid`, `courseid`, `semester`, `internaltype`, `maxmarks`, `scored`) VALUES
(3, '7', 3, 4, 1, 'Maths', 100, 90),
(6, '7', 3, 4, 1, 'Theory', 100, 90),
(8, '8', 3, 4, 1, 'Theory', 100, 90),
(9, '8', 3, 4, 1, 'Practical', 50, 40);

-- --------------------------------------------------------

--
-- Table structure for table `studentdetails`
--

DROP TABLE IF EXISTS `studentdetails`;
CREATE TABLE IF NOT EXISTS `studentdetails` (
  `studid` bigint(25) NOT NULL AUTO_INCREMENT,
  `studfname` varchar(20) NOT NULL,
  `studlname` varchar(20) NOT NULL,
  `fathername` varchar(25) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contactno` varchar(20) NOT NULL,
  `courseid` bigint(4) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `dob` date NOT NULL,
  `pass` varchar(50) NOT NULL,
  PRIMARY KEY (`studid`),
  UNIQUE KEY `contactno` (`contactno`),
  KEY `courseid` (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentdetails`
--

INSERT INTO `studentdetails` (`studid`, `studfname`, `studlname`, `fathername`, `gender`, `address`, `contactno`, `courseid`, `semester`, `dob`, `pass`) VALUES
(10, 'Mayank', 'Mandal', 'Vishwanath', 'male', 'Itarsi', '7364726472', 4, '3', '1997-08-22', '308a3820e4cccbe043cb5228de5e71e3'),
(11, 'Vinod', 'Sharma', 'Sushil Sharma', 'male', 'satna', '9988998834', 4, '1', '1994-01-12', 'd2c51c9cde1f15b718296c99ae362fb1'),
(12, 'vaibhav ', 'sahu', 'M L', 'male', 'SARNI\r\n', '6265395755', 4, '2', '1996-07-13', '310a87565a48526e9d096f917007dbfe'),
(13, 'Arun ', 'Yadav', 'radhheshyam yadav', 'male', 'nitk', '8962674241', 4, '2', '1999-01-07', 'fad1baf6464b5da8f87896439ca2de03'),
(14, 'hitesh ', 'bhawsar', 'girish bhawsar', 'male', 'ward 6 bhawsaer mohlla zirapur distt rajgarh m.p. india pin 465691', '6264839465', 4, '2', '1997-10-24', '97381c74d65f710b64e24526461631b1'),
(15, 'AYUSH ', 'WAGDRE', 'SHYAM RAO', 'male', 'A/L-794 PITHAMPUR.INDORE', '8962342099', 3, '1', '1995-11-05', '66049c07d9e8546699fe0872fd32d8f6'),
(16, 'Rajat', 'Talnikar', 'Dilip', 'male', '28,Sanchar Nagar Extention,Indore', '7566672514', 3, '3', '1997-01-01', 'd2ff3b88d34705e01d150c21fa7bde07'),
(17, 'Amit', 'Mehra', 'Anil Mehra', 'male', 'lig 210 itarsi', '678797899', 6, '4', '1994-05-07', '0cb1eb413b8f7cee17701a37a1d74dc3'),
(18, 'rohit', 'yadav', 'javed yadav', 'male', 'sarni', '8866768768', 6, '3', '1999-02-03', '2d235ace000a3ad85f590e321c89bb99');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `subid` bigint(4) NOT NULL AUTO_INCREMENT,
  `subname` varchar(20) NOT NULL,
  `courseid` bigint(4) NOT NULL,
  `subtype` varchar(25) NOT NULL,
  `semester` varchar(25) NOT NULL,
  `comment` text NOT NULL,
  PRIMARY KEY (`subid`),
  KEY `courseid` (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subid`, `subname`, `courseid`, `subtype`, `semester`, `comment`) VALUES
(3, 'Accounting', 4, 'Theory', '6', 'The course related to Accounts'),
(5, 'C', 5, 'Lab', '6', 'C programming');

-- --------------------------------------------------------

--
-- Table structure for table `tmp`
--

DROP TABLE IF EXISTS `tmp`;
CREATE TABLE IF NOT EXISTS `tmp` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
