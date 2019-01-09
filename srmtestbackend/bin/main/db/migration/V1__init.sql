CREATE TABLE cliente (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(256) NOT NULL,
	`limite_credito` DECIMAL(14,2) NOT NULL,
	`taxa_juros` DECIMAL(8,4),
	`creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
);

commit;