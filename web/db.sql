CREATE TABLE `projetpoo`.`user` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `address` VARCHAR(1000) NULL,
  `role` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));

CREATE TABLE `projetpoo`.`fee` (
  `id` INT NOT NULL,
  `amount` DOUBLE NOT NULL,
  `date` DATETIME NULL,
  `iduser` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `iduserfk_idx` (`iduser` ASC),
  CONSTRAINT `iduserfk`
    FOREIGN KEY (`iduser`)
    REFERENCES `projetpoo`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
