# Write your MySQL query statement below
select email as EMAIL from Person GROUP BY email HAVING COUNT(email) > 1;