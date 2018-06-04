CREATE TABLE `projetpoo`.`user` (
  `id` INT NOT NULL auto_increment,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `address` VARCHAR(1000) NULL,
  `role` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));

CREATE TABLE `projetpoo`.`fee` (
  `id` INT NOT NULL auto_increment,
  `amount` DOUBLE NOT NULL,
  `date` DATETIME NULL,
  `iduser` INT NOT NULL,
  `status` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `iduserfk_idx` (`iduser` ASC),
  CONSTRAINT `iduserfk`
    FOREIGN KEY (`iduser`)
    REFERENCES `projetpoo`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


INSERT INTO `user` VALUES (1,'admin','admin','admin@example.com','admin','rue des admins',1),(2,'comptable1','comptable1','comptable@gmail.com','comptable','233 rue des chiffres',2),(3,'empl','empl','empl@gmail.com','empl','2334 rue des esclaves',3),(6,'Acccountant2','Acccountant2','Acccountant2@gmail.com','accountant','5557 rue des comptables',2),(7,'blabla','Acccountant3','Acccountant3@gmail.com','test','2324 rue jean souvraz Lens',2),(8,'Adrien','Philippaux','adrien.philippaux@gmail.com','adrien','20 rue du petit prince',3),(9,'John ','Doe','johndoe@test.fr','john','John doe address',3);
