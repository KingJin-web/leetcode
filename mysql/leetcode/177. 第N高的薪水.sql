��дһ�� SQL ��ѯ����ȡ Employee ���е� n �ߵ�нˮ��Salary����

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
�������� Employee ��n = 2 ʱ��Ӧ���صڶ��ߵ�нˮ 200����������ڵ� n �ߵ�нˮ����ô��ѯӦ���� null��

+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+

SET GLOBAL log_bin_trust_function_creators = 1;
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set n = n - 1;
    RETURN (
        select Salary
        from employee
        group by Salary
        order by Salary desc
        limit n,1
    );
END;

drop function getNthHighestSalary;
select getNthHighestSalary(5);
