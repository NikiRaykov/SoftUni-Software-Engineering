SELECT 
    starting_point AS `route_starting_poing`,
    end_point AS `route_ending_poing`,
    leader_id,
    CONCAT_WS(' ', first_name, last_name) AS `leader_name`
FROM
    `routes` AS r
        JOIN
    `campers` AS c ON r.`leader_id` = c.`id`;
