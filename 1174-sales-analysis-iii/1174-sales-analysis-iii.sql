# Write your MySQL query statement below
select product.product_id, product.product_name from Product product where exists (
    select 1 from Sales sales where sales.product_id = product.product_id and sales.sale_date between '2019-01-01' and '2019-03-31'
) and not exists (
    select 1 from Sales sales_out where sales_out.product_id = product.product_id and (sales_out.sale_date < '2019-01-01' or sales_out.sale_date > '2019-03-31')
);