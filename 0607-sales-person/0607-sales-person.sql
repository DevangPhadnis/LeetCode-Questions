# Write your MySQL query statement below
SELECT name
FROM SalesPerson sales
WHERE NOT EXISTS (
    SELECT 1
    FROM Orders orders
    JOIN Company company ON orders.com_id = company.com_id
    WHERE orders.sales_id = sales.sales_id
      AND company.name = 'RED'
);