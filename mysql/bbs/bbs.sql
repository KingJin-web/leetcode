create database bbs;
use bbs;

create table tbl_user(
	uid int primary key auto_increment,
	uname varchar(20),
	upass varchar(100),
	head varchar(100),
	regtime datetime,
	gender int
);
insert into tbl_user (uname,upass,head,regtime,gender) values('a','a','1.gif',now(),1);
insert into tbl_user (uname,upass,head,regtime,gender) values('b','b','2.gif',now(),1);
-- 版块
create table tbl_board(
	boardid int primary key auto_increment,
	boardname varchar(50),
	parentid int
);
insert into tbl_board(boardname,parentid) values('.net',0);
insert into tbl_board(boardname,parentid) values('java',0);
insert into tbl_board(boardname,parentid) values('db',0);
insert into tbl_board(boardname,parentid) values('project',0);

insert into tbl_board(boardname,parentid) values('ado.net',1);
insert into tbl_board(boardname,parentid) values('asp.net',1);
insert into tbl_board(boardname,parentid) values('vb.net',1);

insert into tbl_board(boardname,parentid) values('jsp',2);
insert into tbl_board(boardname,parentid) values('struts',2);
insert into tbl_board(boardname,parentid) values('hibernate',2);

insert into tbl_board(boardname,parentid) values('sql',3);
insert into tbl_board(boardname,parentid) values('oracle',3);
insert into tbl_board(boardname,parentid) values('mysql',3);

--主题帖
create table tbl_topic(
	topicid int primary key auto_increment,
	title varchar(50),
	content varchar(1000),
	publishtime datetime,
	modifytime datetime,
	uid int,
	boardid int
);

insert into tbl_topic(title,content,publishtime,modifytime,uid,boardid) values("jsp  good"," good,i agree",now(),now(),1,8);
insert into tbl_topic(title,content,publishtime,modifytime,uid,boardid) values("jsp is very good","very good,i agree",now(),now(),1,8);
insert into tbl_topic(title,content,publishtime,modifytime,uid,boardid) values("structs website","very good,i agree",now(),now(),2,9);
insert into tbl_topic(title,content,publishtime,modifytime,uid,boardid) values("structs projects","very good,i agree",now(),now(),1,9);

alter table tbl_topic
   add constraint FK_topic_uid
      foreign key(uid) references tbl_user(uid)
      
alter table tbl_topic
   add constraint FK_topic_boardid
     foreign key(boardid) references tbl_board(boardid)
     
create table tbl_reply(
	replyid int primary key auto_increment,
	title varchar(50),
	content varchar(1000),
	publishtime datetime,
	modifytime datetime,
	uid int,
	topicid int
);

alter table tbl_reply
   add constraint FK_reply_uid
      foreign key(uid) references tbl_user(uid);
      
alter table tbl_reply
	add constraint FK_reply_topicid
	   foreign key(topicid) references tbl_topic(topicid);

--案例需求: 请用一次查询得到界面中所有要求显示的数据
--步骤:1. 先查出每个版块最新贴子的发贴时间
select boardid,max(modifytime) as modifytime
from tbl_topic
group by boardid;

--步骤:2. 查出每个贴子的信息，关键是贴子的发贴人名.
select topicid,title,uname,modifytime,boardid
from tbl_topic
left join tbl_user
on tbl_user.uid = tbl_topic.uid;

--步骤:3. 将以上整合，得到每个版块最新的贴子信息
select topicid,title,a.modifytime,uname,a.boardid
from (
				 (select boardid,max(modifytime) as modifytime
          from tbl_topic
          group by boardid) b,
				 (select topicid,title,uname,modifytime,boardid
          from tbl_topic
          left join tbl_user
          on tbl_user.uid = tbl_topic.uid) a
		 )
where a.boardid = b.boardid and a.modifytime = b.modifytime;

--步骤:4. 统计每个版块下的贴子总数
select tbl_board.boardid,boardname,parentid,count(topicid) as total
from tbl_board
left join tbl_topic
on tbl_board.boardid = tbl_topic.boardid
group by tbl_board.boardid,boardname,parentid

--步骤:5. 最后使用左外联接，将版块信息与最新的贴子信息整合在一起. 
select a.boardid,boardname,parentid,total,topicid,title,modifytime,uname
from (select topicid,title,uname,modifytime,boardid
      from tbl_topic
      left join tbl_user
      on tbl_user.uid = tbl_topic.uid
		 ) a
left join (select topicid,title,uname,modifytime,boardid
           

--------------------------------------------------------
--需求二: 求出某个版块下按分页条件查询的贴子. 
-- 输出要求: 1. 分页    2. 统计每个贴子下有多少回复数  3. 某一个版块
-- 图片二的效果
--------------------------------------------------------
--基础数据
--插入回复
insert into tbl_reply(title,content,publishtime,modifytime,uid,topicid) values("jsp is very good reply","very good,i agree, reply",now(),now(),1,4);
insert into tbl_reply(title,content,publishtime,modifytime,uid,topicid) values("jsp is very good reply","very good,i agree, reply",now(),now(),1,4);
insert into tbl_reply(title,content,publishtime,modifytime,uid,topicid) values("jsp is very good reply","very good,i agree, reply",now(),now(),1,4);
insert into tbl_reply(title,content,publishtime,modifytime,uid,topicid) values("jsp is very good reply","very good,i agree, reply",now(),now(),1,4);
insert into tbl_reply(title,content,publishtime,modifytime,uid,topicid) values("jsp is very good reply","very good,i agree, reply",now(),now(),1,4);

--步骤一: 按贴子编号分组查出每个贴子下的回复数
select topicid, count(*) as total from tbl_reply
group by topicid;

--步骤二: 查出某个版块下 按分页条件查询这一页的所有的贴子信息 
select topicid,title,content,publishtime,modifytime,  tbl_user.uid,  uname,boardid
from tbl_topic
inner join tbl_user
on tbl_topic.uid=tbl_user.uid
where boardid=8
order by modifytime desc
limit 0,2

--步骤三: 以左外联接查询求出
select a.topicid,title,content,publishtime,modifytime,uid,uname,boardid, total
from
(select topicid,title,content,publishtime,modifytime,  tbl_user.uid,  uname,boardid
from tbl_topic
inner join tbl_user
on tbl_topic.uid=tbl_user.uid
where boardid=8
order by modifytime desc
limit 0,2) a
left join 
(select topicid, count(*) as total from tbl_reply
group by topicid) b
on a.topicid=b.topicid




