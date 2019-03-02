-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db-v1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db-v1` ;

-- -----------------------------------------------------
-- Schema db-v1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db-v1` DEFAULT CHARACTER SET utf8 ;
USE `db-v1` ;

-- -----------------------------------------------------
-- Table `db-v1`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-v1`.`users` (
  `user_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
`last_name` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
`email` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
`password` VARCHAR(100) CHARACTER SET 'utf8' NOT NULL,
`password_salt` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
`last_update` TIMESTAMP NULL DEFAULT NULL,
PRIMARY KEY (`user_id`),
UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
