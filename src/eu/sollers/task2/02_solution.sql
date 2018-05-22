
/* solution */
SELECT  EXPORT_TABLE.country, COALESCE(EXPORT_TABLE.export, 0) AS export, COALESCE(IMPORT_TABLE.import, 0) AS import
FROM 
	(SELECT companies.country, sum(value) AS export 
	FROM companies 
	LEFT JOIN trades 
	ON companies.name = trades.seller 
	GROUP BY companies.country) EXPORT_TABLE

INNER JOIN
	(Select  companies.country, sum(value) AS import 
	FROM companies
	LEFT JOIN trades 
	ON companies.name = trades.buyer
	GROUP BY companies.country ) IMPORT_TABLE
    
WHERE EXPORT_TABLE.country = IMPORT_TABLE.country
ORDER BY EXPORT_TABLE.country ASC;





