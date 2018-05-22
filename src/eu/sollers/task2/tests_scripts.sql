create table companies (
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

create table trades (
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

create table solution (
	country varchar(30) not null,
	export integer not null,
	import integer not null,
	unique(country)
);

insert into trades values("Marthlands", "30", "180");
insert into trades values("Nothingland", "0", "0");
insert into trades values("Lil Mermaid", "90", "0");
insert into trades values("Underwater Kingdom", "100", "40");


/* run as sqllite> codility.db < create.sql 
sqlite> .mode column
sqlite> .headers on
*/

/* solution */
/* test */
Select country, seller, buyer, value from companies left join trades on companies.name = trades.seller or companies.name = trades.buyer;

/* test */
Select country, seller, value from companies left join trades on companies.name = trades.seller;

Select country, buyer, value from companies left join trades on companies.name = trades.buyer;

/* test */
Select country, seller, value as export from companies left join trades on companies.name = trades.seller group by country;

Select country, buyer, value as import from companies left join trades on companies.name = trades.buyer group by country;

/* test */
Select country, sum(value) as export from companies left join trades on companies.name = trades.seller group by country;

Select country, sum(value) as import from companies left join trades on companies.name = trades.buyer group by country;

/* solution */
SELECT  T1.country, COALESCE(T1.export, 0) AS export, COALESCE(T2.import, 0) AS import
FROM 
	(SELECT companies.country, sum(value) AS export 
	FROM companies 
	LEFT JOIN trades 
	ON companies.name = trades.seller 
	GROUP BY companies.country) T1

INNER JOIN
	(Select  companies.country, sum(value) AS import 
	FROM companies
	LEFT JOIN trades 
	ON companies.name = trades.buyer
	GROUP BY companies.country ) T2
WHERE T1.country = T2.country
ORDER BY T1.country ASC;





