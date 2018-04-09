create table yoga_member(
id varchar2(50) primary key,
password varchar2(50) not null,
name varchar2(50) not null,
phone_number NUMBER not null,
address varchar2(100) not null,
email varchar2(100) not null,
password_question varchar2(100) not null,
password_answer varchar2(100) not null,
regDate date not null,
member_status varchar2(10) not null,
class_package varchar2(10) not null --3회 or 5회
)



select count(*) from yoga_program;
select programNo, programName
from(
	select  row_number() over(order by programNo asc) as rnum, programNo, programName 
	from yoga_program 
) where rnum between 1 and 10;
-- 요가 강사 테이블 생성
create table yoga_teacher(
teacherId NUMBER primary key,
teacherName varchar2(50) not null,
teacherNick varchar2(50) not null,
teacherProfile varchar2(600),
imgUrl varchar2(100)
)
delete YOGA_PROGRAMIMG where programImg=7;
delete YOGA_PROGRAM where programNo=7;
select * from YOGA_PROGRAMIMG;
delete YOGA_TEACHER where teacherid='9'
update yoga_programImg set imgUrl4='요가자세2.jpg' where programImg=5;
select * from yoga_teacher
-- 요가 프로그램 이미지 테이블 생성
create table yoga_programImg(
programImg number primary key,
hitCount varchar2(100),
imgUrl1 varchar2(100),
imgUrl2 varchar2(100),
imgUrl3 varchar2(100),
imgUrl4 varchar2(100),
constraint fk_programNo1 foreign key(programImg) references yoga_program(programNo)
)
drop table yoga_programImg
-- 요가 프로그램 이미지 시퀀스 생성
drop sequence programImg_seq;
create sequence programImg_seq;
-- 요가 프로그램 이지지 추가
insert into yoga_programImg(
programImg, 
hitCount, 
imgUrl1, 
imgUrl2, 
imgUrl3, 
imgUrl4) 
values(programImg_seq.nextval, '1', 'con01.png', 'con02.png', 'con03.png', 'con01.png');

select * from post;

select *
from yoga_programImg pi, yoga_program p 
where pi.programImg=p.programno and programno=1;

select p.programName, p.programDetail, pi.hitCount, pi.imgUrl1, pi.imgUrl2, pi.imgUrl3, pi.imgUrl4
from yoga_programImg pi, yoga_program p 
where pi.programImg=p.programno and programno=1;

delete yoga_teacher where teacherId>20
select * from yoga_teacher
-- teacherId 시퀀스 생성
create sequence tchNo_seq;
drop sequence tchNo_seq;

update yoga_member set member_status='0' where id='java'


-- 선생님 검색 
select teacherId, teacherName, teacherNick from yoga_teacher


-- 요가 프로그램 테이블 생성
create table yoga_program(
programNo NUMBER primary key,
programName varchar2(50) not null,
programDetail varchar2(600)
)

select * from YOGA_PROGRAM;
-- programNo 시퀀스 생성
create sequence prgNo_seq;

-- 요가 강좌 테이블 생성
create table yoga_class(
classNo NUMBER primary key,
programNo NUMBER not null,
teacherId NUMBER not null,
capacity NUMBER not null,
classTime NUMBER not null,
classDay varchar2(10) not null,
constraint fk_teacherId foreign key(teacherId) references YOGA_TEACHER,
constraint fk_programNo foreign key(programNo) references yoga_program
)
select * from YOGA_CLASS;
select * from YOGA_TEACHER;
select programNo from YOGA_PROGRAM where programName='?';
select teacherId from YOGA_TEACHER where teacherName='수호';
select classTime from YOGA_CLASS where classDay='mon' and programNo='42' and teacherId=?
-- classNo 시퀀스 생성
create sequence class_seq;

create table registerStatus(
classNo NUMBER not null,
id VARCHAR2(100) not null,
regDate date not null,
constraint fk_class foreign key(classNo) references yoga_class(classNo),
constraint fk_yoga_member foreign key(id) references yoga_member(id),
constraint pk_registerStatus primary key(classNo,id)
)

create sequence post_seq; //postNo 생성
create table POST(
postNo NUMBER primary key,
title varchar2(100) not null,
content clob not null,
id varchar2(50) not null,
regDate date not null,
constraint fk_post2 foreign key(id) references yoga_member(id)
)
drop table registerStatus
drop table yoga_member
drop table POST
drop table yoga_class;
drop table yoga_teacher;
drop table yoga_program;
drop table YOGA_PROGRAMIMG

drop sequence post_seq;
drop sequence class_seq;
drop sequence prgNo_seq;
drop sequence tch_seq;



select * from yoga_member;
select * from yoga_class;
select * from yoga_teacher;
select * from yoga_program;
select * from POST;
select * from registerStatus
--멤버추가
insert into yoga_member(
id,
password,
name,
phone_number,
address,
email,
password_question,
password_answer,
regDate,
member_status,
class_package
) values('java','1234','hwang',5152,'판교','naver.com','test','test',sysdate,'true','3');

insert into yoga_member(
id,password,name,phone_number,address,email,password_question,password_answer,regDate,member_status,class_package
) values('python','1234','hwang',2345,'수원','google.com','test','test',sysdate,'true','5');

--관리자
insert into yoga_member(
id,password,name,phone_number,address,email,password_question,password_answer,regDate,member_status,class_package
) values('sys','1234','2ZO_NOTNULL',3434,'판교','naver.com','test','test',sysdate,'3','3');
--기본 게시물 추가
insert into POST(
postNo,
title,
content,
id,
regDate
) values(post_seq.nextval, 'hello','shut up','java', sysdate);

--선생님 추가
insert into yoga_teacher(
teacherId,
teacherName,
teacherNick,
teacherProfile,
imgUrl
) values(tchNo_seq.nextval,'김민석','시우민','엑소입니다.','김민석.jpg');

--선생님 추가
insert into yoga_teacher(
teacherId,
teacherName,
teacherNick,
teacherProfile,
imgUrl
) values(tchNo_seq.nextval,'수호','수호','엑소입니다2','수호.jpg');

--프로그램 추가
insert into yoga_program(
programNo,
programName,
programDetail
) values(prgNo_seq.nextval,'Vinyasa','김민석과 함께하는 즐거운요가');

select * from yoga_program



--프로그램 추가
insert into yoga_program(
programNo,
programName,
programDetail
) values(prgNo_seq.nextval,'그냥요가','누군가와 함께하는 즐거운요가');

--클래스 추가
insert into yoga_class(
classNo,
programNo,
teacherId ,
capacity,
classTime,
classDay
) values(class_seq.nextval,1,1,10,1,'mon');

select * from yoga_class
--클래스 추가
insert into yoga_class(
classNo,
programNo,
teacherId ,
capacity,
classTime,
classDay
) values(class_seq.nextval,1,2,10,2,'fri');
select programNo,programName,programDetail from yoga_program where programNo='1';
차근차근 만들어보시고 insert까지 모두 해주세여~
select count(*) from yoga_program;
create table registerStatus(
rsNo NUMBER PRIMARY KEY,                      
classNo NUMBER not null,
id VARCHAR2(100) not null,
regDate date not null,
constraint fk_class foreign key(classNo) references yoga_class(classNo),
constraint fk_yoga_member foreign key(id) references yoga_member(id)
)
select p.programno, c.teacherid from yoga_class c, YOGA_PROGRAM p where c.programno=p.programno and teacherid=1;

select c.classno, p.programname, c.classday,c.capacity from yoga_class c, YOGA_PROGRAM p where c.programno=p.programno and teacherid=1;
create sequence rs_seq;    
select p.programno, c.teacherid, c.classDay, c.classTime from yoga_class c, YOGA_PROGRAM p where c.programno=p.programno
--멤버 업데이트
select * from yoga_member;
update yoga_member set password='1234', phone_number='1', address='1' ,email='1@2', password_answer='1', name='1'  where id='html';
update yoga_member set password=?, phone_number=?, address=? ,email=?, password_question=?, password_answer=?, name=? where id=? 

-- 요가 프로그램 이미지 테이블 생성
create table yoga_programImg(
programImg number primary key,
hitCount varchar2(100),
imgUrl1 varchar2(100),
imgUrl2 varchar2(100),
imgUrl3 varchar2(100),
imgUrl4 varchar2(100),
constraint fk_programNo1 foreign key(programImg) references yoga_program(programNo)
)
drop sequence programImg_seq;
drop table yoga_programImg
-- 요가 프로그램 이미지 시퀀스 생성
create sequence programImg_seq;
-- 요가 프로그램 이지지 추가
insert into yoga_programImg(
programImg, 
hitCount, 
imgUrl1, 
imgUrl2, 
imgUrl3, 
imgUrl4) 
values(programImg_seq.nextval, '1', 'con01.png', 'con02.png', 'con03.png', 'con01.png');

select * from yoga_programImg;

select *
from yoga_programImg pi, yoga_program p 
where pi.programImg=p.programno and programno=1;

select p.programName, p.programDetail, pi.hitCount, pi.imgUrl1, pi.imgUrl2, pi.imgUrl3, pi.imgUrl4
from yoga_programImg pi, yoga_program p 
where pi.programImg=p.programno and programno=1;
