-- MySQL Script generated by MySQL Workbench
-- Tue Dec 10 22:49:36 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MyRestaurants
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MyRestaurants
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MyRestaurants` DEFAULT CHARACTER SET utf8 ;
USE `MyRestaurants` ;

-- -----------------------------------------------------
-- Table `MyRestaurants`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyRestaurants`.`Usuario` (
  `Cod_U` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  `NombreUsuario` VARCHAR(45) NOT NULL,
  `Contraseña` VARCHAR(45) NOT NULL,
  `Telefono` INT NULL,
  `Dirección` VARCHAR(45) NULL,
  `TipoUsuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Cod_U`),
  UNIQUE INDEX `NombreUsuario_UNIQUE` (`NombreUsuario` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyRestaurants`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyRestaurants`.`Producto` (
  `Cod_Pr` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NULL,
  `Precio` INT NOT NULL,
  PRIMARY KEY (`Cod_Pr`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyRestaurants`.`Menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyRestaurants`.`Menu` (
  `Cod_M` INT NOT NULL,
  `numeroMenu` INT NULL,
  `Productos` VARCHAR(45) NULL,
  `Producto_Cod_Pr` INT NOT NULL,
  PRIMARY KEY (`Cod_M`, `Producto_Cod_Pr`),
  INDEX `fk_Menu_Producto1_idx` (`Producto_Cod_Pr` ASC) VISIBLE,
  CONSTRAINT `fk_Menu_Producto1`
    FOREIGN KEY (`Producto_Cod_Pr`)
    REFERENCES `MyRestaurants`.`Producto` (`Cod_Pr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyRestaurants`.`Restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyRestaurants`.`Restaurante` (
  `Cod_R` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Horario` VARCHAR(45) NULL,
  `Dirección` VARCHAR(45) NULL,
  `Telefono` INT NULL,
  `Menus` VARCHAR(45) NOT NULL,
  `Menu_Cod_M` INT NOT NULL,
  PRIMARY KEY (`Cod_R`, `Menu_Cod_M`),
  INDEX `fk_Restaurante_Menu1_idx` (`Menu_Cod_M` ASC) VISIBLE,
  CONSTRAINT `fk_Restaurante_Menu1`
    FOREIGN KEY (`Menu_Cod_M`)
    REFERENCES `MyRestaurants`.`Menu` (`Cod_M`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyRestaurants`.`Postre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyRestaurants`.`Postre` (
  `Cod_p` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` VARCHAR(45) NOT NULL,
  `esFrio` VARCHAR(45) NULL,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`Cod_p`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyRestaurants`.`Bebida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyRestaurants`.`Bebida` (
  `Cod_Bebida` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` INT NOT NULL,
  `Bebidacol` VARCHAR(45) BINARY NULL,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`Cod_Bebida`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyRestaurants`.`Usuario_has_Restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyRestaurants`.`Usuario_has_Restaurante` (
  `Usuario_Cod_U` INT NOT NULL,
  `Restaurante_Cod_R` INT NOT NULL,
  `Restaurante_Producto_Nombre` INT NOT NULL,
  `Restaurante_Producto_Bebida_Cod_Bebida` INT NOT NULL,
  PRIMARY KEY (`Usuario_Cod_U`, `Restaurante_Cod_R`, `Restaurante_Producto_Nombre`, `Restaurante_Producto_Bebida_Cod_Bebida`),
  INDEX `fk_Usuario_has_Restaurante_Restaurante1_idx` (`Restaurante_Cod_R` ASC, `Restaurante_Producto_Nombre` ASC, `Restaurante_Producto_Bebida_Cod_Bebida` ASC) VISIBLE,
  INDEX `fk_Usuario_has_Restaurante_Usuario1_idx` (`Usuario_Cod_U` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_has_Restaurante_Usuario1`
    FOREIGN KEY (`Usuario_Cod_U`)
    REFERENCES `MyRestaurants`.`Usuario` (`Cod_U`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Restaurante_Restaurante1`
    FOREIGN KEY (`Restaurante_Cod_R`)
    REFERENCES `MyRestaurants`.`Restaurante` (`Cod_R`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyRestaurants`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyRestaurants`.`Pedido` (
  `Cod_Pe` INT NOT NULL,
  `Contador` INT NULL,
  `Menus` VARCHAR(45) NULL,
  `Menu_Cod_M` INT NOT NULL,
  `Menu_Producto_Cod_Pr` INT NOT NULL,
  PRIMARY KEY (`Cod_Pe`, `Menu_Cod_M`, `Menu_Producto_Cod_Pr`),
  INDEX `fk_Pedido_Menu1_idx` (`Menu_Cod_M` ASC, `Menu_Producto_Cod_Pr` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Menu1`
    FOREIGN KEY (`Menu_Cod_M` , `Menu_Producto_Cod_Pr`)
    REFERENCES `MyRestaurants`.`Menu` (`Cod_M` , `Producto_Cod_Pr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;