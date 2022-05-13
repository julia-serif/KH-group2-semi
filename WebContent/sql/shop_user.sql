drop table shop_user;
drop sequence user_seq;


create sequence user_seq
INCREMENT by 1
start with 1
nocache;

create table shop_user(
    USER_NO NUMBER primary key, --사용자 번호
    USER_ID VARCHAR2(20 BYTE) unique, -- 사용자 아이디
    USER_PWD VARCHAR2(20 BYTE) not null, -- 사용자 비밀번호
    USER_NAME VARCHAR2(20 BYTE) not null, -- 사용자 이름
    USER_AGE NUMBER, -- 사용자 나이
    USER_PHONE VARCHAR2(20 BYTE) unique, -- 유저 폰번호
    USER_EMAIL VARCHAR2(30 BYTE) unique, -- 유저 이메일
    USER_ADDR VARCHAR2(30 BYTE),
    USER_MILEAGE number default 0,
    USER_GRADE VARCHAR2(20 BYTE) not null, --사용자 등급 (판매자 ,구매자, 관리자)
    USER_LEVEL number default 1, --로그인 권한 (판매자일 경우 0으로 시작 , 관리자가 변경 해줘야 접속 가능)
    REGDATE DATE
);


insert into shop_user values(user_seq.nextval,'admin','admin','관리자',27,'010-1234-5678'
,'admin@google.com','서울시 영등포구',0,'관리자',default,sysdate);

insert into shop_user values(user_seq.nextval,'hong','1234','홍길동',27,'010-2345-6789'
,'hong@naver.com','서울시 종로구',0,'판매자',0,sysdate);

insert into shop_user values(user_seq.nextval,'lee','1234','이순신',37,'010-3456-7890'
,'lee@daum.net','서울시 강남구',0,'구매자',default,sysdate);

select *from shop_user;

commit;
