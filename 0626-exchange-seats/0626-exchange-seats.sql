# Write your MySQL query statement below
with rowCount as (select count(*) as totalRows from Seat),
updatedSeat as (select id, student, row_number() over (order by id) as rowNumber from Seat)
select 
    case
        when (select totalRows from rowCount) % 2 = 0 then
            case
                when id % 2= 1 then id+1
                when id % 2 = 0 then id-1
                else id
            END
        when (select totalRows from rowCount) % 2 = 1 and rowNumber < (select totalRows from rowCount) then
            case
                when id % 2= 1 then id+1
                when id % 2 = 0 then id-1
                else id
            END
        else id
    END as id, student
from updatedSeat order by id;