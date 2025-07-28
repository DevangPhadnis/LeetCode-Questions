# Write your MySQL query statement below
select person.firstName, person.lastName, address.city, address.state from Person person left join Address address on person.personId = address.personId;