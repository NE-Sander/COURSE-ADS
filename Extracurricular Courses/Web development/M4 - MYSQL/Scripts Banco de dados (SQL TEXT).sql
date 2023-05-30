-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema M4-ProjetoBD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema M4-ProjetoBD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `M4-ProjetoBD` DEFAULT CHARACTER SET utf8 ;
USE `M4-ProjetoBD` ;

-- -----------------------------------------------------
-- Table `M4-ProjetoBD`.`Dados Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `M4-ProjetoBD`.`Dados Cliente` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Endereço` VARCHAR(80) NOT NULL,
  `Cep` TINYINT(8) NOT NULL,
  `Tel Residencial` INT(10) NULL,
  `Tel Celular` INT(11) NOT NULL,
  `E-mail` VARCHAR(45) NOT NULL,
  `Sexo` CHAR(1) NULL,
  `Observações` TINYTEXT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `E-mail_UNIQUE` (`E-mail` ASC) VISIBLE,
  UNIQUE INDEX `Tel Celular_UNIQUE` (`Tel Celular` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
