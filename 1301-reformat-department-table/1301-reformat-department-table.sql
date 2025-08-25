# Write your MySQL query statement below
select 
  id,
  sum(case when month = 'Jan' then revenue END) as Jan_Revenue,
  sum(case when month = 'Feb' then revenue END) as Feb_Revenue,
  sum(case when month = 'Mar' then revenue END) as Mar_Revenue,
  sum(case when month = 'Apr' then revenue END) as Apr_Revenue,
  sum(case when month = 'May' then revenue END) as May_Revenue,
  sum(case when month = 'Jun' then revenue END) as Jun_Revenue,
  sum(case when month = 'Jul' then revenue END) as Jul_Revenue,
  sum(case when month = 'Aug' then revenue END) as Aug_Revenue,
  sum(case when month = 'Sep' then revenue END) as Sep_Revenue,
  sum(case when month = 'Oct' then revenue END) as Oct_Revenue,
  sum(case when month = 'Nov' then revenue END) as Nov_Revenue,
  sum(case when month = 'Dec' then revenue END) as Dec_Revenue
from Department
group by id;