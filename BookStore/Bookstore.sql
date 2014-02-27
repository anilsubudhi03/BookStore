DROP DATABASE IF EXISTS `BOOKSTORE`; 
	CREATE DATABASE IF NOT EXISTS `BOOKSTORE`; 
	USE BOOKSTORE;
	SET FOREIGN_KEY_CHECKS=0;
	
	
	DROP TABLE IF EXISTS `BOOKS`;
	
	CREATE TABLE `BOOKS` (
	  `BOOK_ID` INT(11) NOT NULL AUTO_INCREMENT,
	  `TITLE` VARCHAR(20) NOT NULL,
	  `CATEGORY_ID` INT(11) NOT NULL,
	  `AUTH_ID` INT(11) NOT NULL,
	  PRIMARY KEY (`BOOK_ID`),
      UNIQUE KEY `NAME` (`TITLE`),
	  CONSTRAINT `BOOKS_IBFK_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `CATEGORY` (`CATEGORY_ID`) ON DELETE CASCADE,
	  CONSTRAINT `BOOKS_IBFK_2` FOREIGN KEY (`AUTH_ID`) REFERENCES `AUTHOR` (`AUTH_ID`) ON DELETE CASCADE
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	
	
	
	DROP TABLE IF EXISTS `AUTHOR`;
	
	CREATE TABLE `AUTHOR` (
	  `AUTH_ID` INT(11) NOT NULL AUTO_INCREMENT,
	  `AUTH_NAME` VARCHAR(50) NOT NULL,
	  `AUTH_LASTNAME` VARCHAR(50) DEFAULT NULL,
	  `BIRTHDAY` DATE DEFAULT NULL,
	  PRIMARY KEY (`AUTH_ID`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	
	
	
	
	DROP TABLE IF EXISTS `CATEGORY`;
	
	CREATE TABLE `CATEGORY` (
	  `CATEGORY_ID` INT(11) NOT NULL AUTO_INCREMENT,
	  `CATEGORY_NAME` VARCHAR(20) NOT NULL,
	  PRIMARY KEY (`CATEGORY_ID`),
	  UNIQUE KEY `NAME` (`CATEGORY_NAME`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	
	SET FOREIGN_KEY_CHECKS=1;
	