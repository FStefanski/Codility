-- MySQL5 script 

DROP SCHEMA IF EXISTS `codility_sollers`;
-- -----------------------------------------------------
-- Schema codility_sollers
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `codility_sollers` DEFAULT CHARACTER SET utf8 ;
USE `codility_sollers` ;

-- -----------------------------------------------------
-- Given tables in task
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `codility_sollers`.`companies` (
  
	name varchar(30) not null,
	country varchar(30) not null,
	unique(name)
);

insert into companies values("Alice s.p.", "Wonderland");
insert into companies values("Y-zap", "Wonderland");
insert into companies values("Absolute", "Marthlands");
insert into companies values("Arcus t.g.", "Marthlands");
insert into companies values("Lil Mermaid", "Underwater Kingdom");
insert into companies values("None at all", "Nothingland");

SELECT * FROM companies;

CREATE TABLE IF NOT EXISTS `codility_sollers`.`trades` (
	id integer not null,
	seller varchar(30) not null,
	buyer varchar(30)not null,
	value integer not null,
	unique(id)
);

insert into trades values("20121107", "Lil Mermaid", "Alice s.p.", "10");
insert into trades values("20121112", "Arcus t.g.", "Y-zap", "30");
insert into trades values("20121125", "Alice s.p.", "Arcus t.g.", "100");
insert into trades values("20121116", "Lil Mermaid", "Absolute", "30");
insert into trades values("20121117", "Lil Mermaid", "Absolute", "50");

SELECT * FROM trades;

-- -----------------------------------------------------
-- Given expected solution in task.
-- The task is to calculate the total import and export per 
-- country with respect to the fact that companies are 
-- selling abroad (export) or buying from abroad (import). 
-- No info. about posible inside country operations.
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `codility_sollers`.`expected_result` (
	country varchar(30) not null,
	export integer not null,
	import integer not null
);

insert into expected_result values("Marthlands", "30", "180");
insert into expected_result values("Nothingland", "0", "0");
insert into expected_result values("Lil Mermaid", "90", "0");
insert into expected_result values("Underwater Kingdom", "100", "40");

SELECT * FROM expected_result;