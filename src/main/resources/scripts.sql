CREATE SCHEMA `product_schema` ;

CREATE TABLE `product_schema`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `made_in` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `product_schema`.`product` (`name`, `brand`, `made_in`, `price`) VALUES ('Galaxy S8+', 'Samsung', 'Korea', '800.00');

  