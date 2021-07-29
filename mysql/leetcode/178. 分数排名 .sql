-- https://leetcode-cn.com/problems/rank-scores/
��дһ�� SQL ��ѯ��ʵ�ַ���������

�������������ͬ������������������Rank����ͬ����ע�⣬ƽ�ֺ����һ������Ӧ������һ������������ֵ�����仰˵������֮�䲻Ӧ���С��������

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
���磬�������������� Scores ����Ĳ�ѯӦ�÷��أ��������Ӹߵ������У���

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
��Ҫ��ʾ������ MySQL ������������Ҫת�����������ı����֣������ڹؼ���֮ǰ��֮��ʹ��Ʋ�š����� `Rank`

drop table scores;
create table scores
(
    id    int primary key,
    score double(8, 2)
);
insert into scores value
    (1, 3.50),
    (2, 3.65),
    (3, 4.00),
    (4, 3.85),
    (5, 4.00),
    (6, 3.65);

set @c = 0;
SELECT Score,
       CONVERT((CASE
                    WHEN @prev = Score THEN @cur
                    WHEN @prev := Score THEN @cur := @cur + 1
                    WHEN Score <= 0 THEN @cur := @cur + 1
           END), UNSIGNED INTEGER) AS 'Rank'
FROM scores,
     (SELECT @cur := 0, @prev := null) r
ORDER BY Score
        DESC;

select score as 'Score', dense_rank() over (order by score desc ) as 'Rank'
from scores;


select score as 'Score', CONVERT((@c := @c + 1), UNSIGNED INTEGER) as 'Rank'
from scores,
     (select @c := 0) as c2
order by score desc;

