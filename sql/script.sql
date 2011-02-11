--
-- Execute this script before before run the app 
-- Database: MySQL
-- 
-- Author: Loiane Groner
-- http://loianegroner.com (English)
-- http://loiane.com (Portuguese)
--

-- -----------------------------------------------------
-- Table `blog_ibatis`.`CATEGORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`CATEGORY` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`CATEGORY` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`STATUS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`STATUS` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`STATUS` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`Month`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Month` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Month` (
  `idMonth` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idMonth`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`ARTICLE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`ARTICLE` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`ARTICLE` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(45) NOT NULL ,
  `author` VARCHAR(45) NOT NULL ,
  `id_category` INT NOT NULL ,
  `id_status` INT NOT NULL ,
  `id_month` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_ARTICLE_CATEGORY` (`id_category` ASC) ,
  INDEX `fk_ARTICLE_STATUS1` (`id_status` ASC) ,
  INDEX `fk_ARTICLE_Month1` (`id_month` ASC) ,
  CONSTRAINT `fk_ARTICLE_CATEGORY`
    FOREIGN KEY (`id_category` )
    REFERENCES `blog_ibatis`.`CATEGORY` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ARTICLE_STATUS1`
    FOREIGN KEY (`id_status` )
    REFERENCES `blog_ibatis`.`STATUS` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ARTICLE_Month1`
    FOREIGN KEY (`id_month` )
    REFERENCES `blog_ibatis`.`Month` (`idMonth` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Dummy Data
-- -----------------------------------------------------
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (1, 'January');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (2, 'February');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (3, 'March');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (4, 'April');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (5, 'May');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (6, 'June');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (7, 'July');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (8, 'August');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (9, 'September');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (10, 'October');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (11, 'November');
INSERT INTO `blog_ibatis`.`month` (`idMonth`, `name`) VALUES (12, 'December');

INSERT INTO `blog_ibatis`.`status` (`id`, `description`) VALUES (1, 'Active');
INSERT INTO `blog_ibatis`.`status` (`id`, `description`) VALUES (2, 'Inactive');

INSERT INTO `blog_ibatis`.`category` (`id`, `description`) VALUES (1, 'iBatis');
INSERT INTO `blog_ibatis`.`category` (`id`, `description`) VALUES (2, 'Spring');
INSERT INTO `blog_ibatis`.`category` (`id`, `description`) VALUES (3, 'Ext JS');
INSERT INTO `blog_ibatis`.`category` (`id`, `description`) VALUES (4, 'Hibernate');
INSERT INTO `blog_ibatis`.`category` (`id`, `description`) VALUES (5, 'Book Review');

INSERT INTO `blog_ibatis`.`article` (`id`, `title`, `author`, `id_category`, `id_status`, `id_month`) VALUES (1, 'Getting Started with ibatis', 'Loiane Groner', 1, 1, 2);
INSERT INTO `blog_ibatis`.`article` (`id`, `title`, `author`, `id_category`, `id_status`, `id_month`) VALUES (2, 'Getting Started with Ext JS', 'Loiane Groner', 3, 1, 1);
INSERT INTO `blog_ibatis`.`article` (`id`, `title`, `author`, `id_category`, `id_status`, `id_month`) VALUES (3, 'Book Review: Ext JS in Action', 'John', 5, 1, 3);