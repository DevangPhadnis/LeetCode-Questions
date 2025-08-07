# Write your MySQL query statement below
with rowCount as (select count(*) as totalRows from Seat),
updatedSeat as (select id, student, row_number() over (order by id) as rowNumber from Seat)
select 
    CASE
        WHEN (SELECT totalRows FROM rowCount) % 2 = 0 then
            CASE
                WHEN id % 2= 1 THEN id+1
                WHEN id % 2 = 0 THEN id-1
                ELSE id
            END
        WHEN (SELECT totalRows FROM rowCount) % 2 = 1 and rowNumber < (select totalRows from rowCount) then
            CASE
                WHEN id % 2= 1 THEN id+1
                WHEN id % 2 = 0 THEN id-1
                ELSE id
            END
        ELSE id
    END AS id, student
FROM updatedSeat order by id;