# Write your MySQL query statement below
select customer.name as Customers from Customers customer left join Orders orders on customer.id = orders.customerId where orders.customerId is null;