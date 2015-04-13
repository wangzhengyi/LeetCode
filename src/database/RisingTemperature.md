```sql
select w1.Id from Weather as w1 inner join Weather as w2 on TO_DAYS(w1.Date) = TO_DAYS(w2.Date) + 1 and w1.Temperature > w2.Temperature;
```
