SELECT name FROM towns
WHERE LENGTH(name) = 5 OR LENGTH(name) = 6
ORDER BY name;