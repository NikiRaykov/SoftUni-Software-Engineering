SELECT `first_name`, `last_name` FROM employees
WHERE NOT INSTR(`job_title`, 'engineer');