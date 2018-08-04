-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema openbanking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema openbanking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `openbanking` DEFAULT;
USE `openbanking` ;

-- -----------------------------------------------------
-- Table `openbanking`.`partner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `openbanking`.`partner` ;

CREATE TABLE IF NOT EXISTS `openbanking`.`partner` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(45) NULL DEFAULT NULL,
  `nickname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12;


-- -----------------------------------------------------
-- Table `openbanking`.`plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `openbanking`.`plan` ;

CREATE TABLE IF NOT EXISTS `openbanking`.`plan` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `partnerId` INT(11) NOT NULL,
  `type` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id` (`id` ASC),
  CONSTRAINT `partnerId`
    FOREIGN KEY (`id`)
    REFERENCES `openbanking`.`partner` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
