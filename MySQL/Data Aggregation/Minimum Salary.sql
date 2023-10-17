SELECT 
    `department_id`, ROUND(MIN(`salary`), 2) AS 'Min Salary'
FROM
    `employees`
WHERE
    `salary` > 800
GROUP BY `department_id`
ORDER BY `department_id`
LIMIT 1;