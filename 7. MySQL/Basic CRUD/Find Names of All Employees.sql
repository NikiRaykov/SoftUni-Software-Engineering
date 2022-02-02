SELECT 
    CONCAT_WS(' ', first_name, middle_name, last_name) AS 'Full Name'
FROM
    employees
WHERE
    salary IN (25000.0 , 14000.0, 12500.0, 23600.0);