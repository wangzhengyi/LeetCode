``sql
select e1.Name from Employee as e1 inner join Employee as e2 on e1.ManagerId = e2.Id and e1.Salary > e2.Salary;
```
