# Write your MySQL query statement below
-- select employee.name from Employee where id in(select employee1.managerId from Employee employee1 join Employee employee2 on employee1.id = employee2.id group by employee2.managerId having count(employee2.managerId) >= 5);

select name from Employee where id in (select managerId from Employee where managerId is not null group by managerId having count(managerId) >= 5);