SELECT `town_id`, `name` FROM towns
WHERE LEFT(`name`, 1) IN ('B', 'M', 'K', 'E')
ORDER BY name;