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
`first_name` VARCHAR(45) NULL DEFAULT NULL,
`last_name` VARCHAR(45) NULL DEFAULT NULL,
`email` VARCHAR(60) NOT NULL,
`password` VARCHAR(100) NOT NULL,
`password_salt` VARCHAR(45) NOT NULL,
`last_update` TIMESTAMP NULL DEFAULT NULL,
PRIMARY KEY (`user_id`),
UNIQUE INDEX `email_UNIQUE` (`email` ASC));


