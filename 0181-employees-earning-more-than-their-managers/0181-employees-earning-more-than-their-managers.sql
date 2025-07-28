# Write your MySQL query statement below
select employee.name as Employee from Employee employee join Employee manager where employee.managerId = manager.id and employee.salary > manager.salary;