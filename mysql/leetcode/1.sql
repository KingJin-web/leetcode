Employee ���������Ա�������ǵľ���Ҳ����Ա����ÿ��Ա������һ�� Id�����⻹��һ�ж�ӦԱ���ľ���� Id��

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
���� Employee ����дһ�� SQL ��ѯ���ò�ѯ���Ի�ȡ���볬�����Ǿ����Ա����������������ı���У�Joe ��Ψһһ�����볬�����ľ����Ա����


+----+-------+--------+-----------+
+----------+
| Employee |
+----------+
|   Joe    |
+----------+

-- ִ����ʱ�� 883 ms , ������ MySQL �ύ�л����� 6.00% ���û�
-- �ڴ����ģ� 0 B , ������ MySQL �ύ�л����� 100.00% ���û�
select Name 'Employee'
from employee e1
where salary > (select Salary from employee e2 where e1.ManagerId = e2.Id);

# Write your MySQL query statement below
select e1.Name as 'Employee'
from Employee e1,
     Employee e2
where (e1.ManagerId = e2.Id and e1.Salary > e2.Salary);