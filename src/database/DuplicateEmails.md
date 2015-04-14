```sql
select Email from Person group by Email having count(id) > 1
```
