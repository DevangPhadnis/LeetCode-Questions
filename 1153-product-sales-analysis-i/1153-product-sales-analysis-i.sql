# Write your MySQL query statement below
select product.product_name, sales.year, sales.price from Sales sales left join Product product on sales.product_id = product.product_id;