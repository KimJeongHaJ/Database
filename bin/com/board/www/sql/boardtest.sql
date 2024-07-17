drop table board

create table board(-- board라는 새 테이블을 생성
	bno number(5) primary key, --bno라는 칼럼 생성 ->데이터 : 최대 5자리 숫자 저장 (기본키)
	btitle nvarchar2(30) not null, --btitle라는 칼럼 생성 ->데이터 : 최대 30자리 유니코드 문자열 저장 (값이 있음 = not null) 
	bcontent nvarchar2(1000) not null, --bcontent라는 칼럼 생성 
	bwriter nvarchar2(10) not null, --bwriter라는 칼럼 생성
	bdate date not null --badate라는 칼럼 생성
	);

drop sequence board_seq; --기본 자동생성번호 삭제
create sequence board_seq increment by 1 start with 1 nocycle nocache ;
--      새로운 시퀀스 생성          1씩 증가      시작 값 1    처음으로x   시퀀스 메모리 할당x
insert into BOARD (bno, btitle, bcontent, bwriter, bdate);

values (board_seq.nextval, '비오내요~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '안녕하세요~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '감사합니다.~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '수고하셨내요~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '화이팅하세요~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '방갑습니다.~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);

select * from board ;

--member 테이블 용

create table member (
mno number(5) primary key,
mid nvarchar2(10) not null,
mpw nvarchar2(10) not null,
mdate date not null
);

--더미데이터
insert into member (mno, mid, mpw, mdate)
values (board_seq.nextval, '김정하','1234', sysdate);
insert into member (mno, mid, mpw, mdate)
values (board_seq.nextval, '이현우','1234', sysdate);
insert into member (mno, mid, mpw, mdate)
values (board_seq.nextval, '김우혁','1234', sysdate);
insert into member (mno, mid, mpw, mdate)
values (board_seq.nextval, '김태희','1234', sysdate);

select * from member;
