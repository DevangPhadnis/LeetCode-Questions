# Write your MySQL query statement below
select employee.name, bonus.bonus from Employee employee left join Bonus bonus on employee.empId = bonus.empId where bonus.bonus < 1000 or bonus.bonus is null;