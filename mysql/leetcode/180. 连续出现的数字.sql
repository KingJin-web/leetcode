180. �������ֵ�����
SQL�ܹ�
��Logs

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id ��������������


��дһ�� SQL ��ѯ�������������������������ε����֡�

���صĽ�����е����ݿ��԰� ����˳�� ���С�



��ѯ�����ʽ�������������ʾ��



Logs ��
+----+-----+
| Id | Num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+

Result ��
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
1 ��Ψһ���������������ε����֡�
drop table logs;
create table Logs
(
    id  int,
    num varchar(20)
);

insert into logs value
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 2),
    (5, 1),
    (6, 2),
    (7, 2);

��дһ�� SQL ��ѯ�������������������������ε����֡�
select distinct Num as ConsecutiveNums
from (
         select Num,
                case
                    when @prev = Num then @count := @count + 1
                    when (@prev := Num) is not null then @count := 1
                    end as CNT
         from Logs,
              (select @prev := null, @count := null) as t
     ) as temp
where temp.CNT >= 3;

select distinct a.Num as ConsecutiveNums
from Logs as a,
     Logs as b,
     Logs as c
where a.Num = b.Num
  and b.Num = c.Num
  and a.id = b.id - 1
  and b.id = c.id - 1;



select a.num as 'ConsecutiveNums', c, Logs.num
from logs
         right join (select num, count(*) as c from logs group by num) as a on a.num = Logs.num
where c > 3
order by c desc
limit 1;

select a.num as 'ConsecutiveNums'
from logs
         right join (select num, count(*) as c from logs group by num) as a on a.num = Logs.num
where c > 3
order by c desc
limit 1;
