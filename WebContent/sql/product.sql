CREATE TABLE ks_product(
 	pno number(10) PRIMARY KEY,           -- 상품 번호
 	pname varchar2(50) not null,          -- 상품명
 	pcode varchar2(10) not null,          -- 카테고리 코드
 	pcompany varchar2(100),               -- 상품 제조사
 	pimage varchar2(100),                 -- 상품 이미지
  	pqty number(5) default 0,             -- 상품 수량
  	price number(10) default 0,           -- 상품 가격
  	pspec varchar2(30),                   -- 상품 스펙
  	pcontents varchar2(1000),             -- 상품 설명
  	point number(6) default 0,            -- 상품 포인트
  	pinputdate date,                      -- 상품 입고일
   	pseller varchar2(20)                  -- 상품 판매자
);

create table ks_category(
 	category_no number(3) primary key,      -- 카테고리 번호
 	category_code varchar2(8) not null,      -- 카테고리 코드
 	category_name varchar2(100) not null     -- 카테고리 이름
);

CREATE TABLE ks_cart(
 	cart_no number(5) primary key,          -- 카트번호
 	cart_pnum number(5) not null,           -- 상품 제품 번호
 	cart_userId varchar2(30) not null,      -- 카트 사용자 아이디
 	cart_pname varchar2(100) not null,      -- 상품 이름
 	cart_pqty number(5) not null,           -- 상품 수량
 	cart_price number(8) not null,          -- 상품 가격
 	cart_pspec varchar2(20) not null,       -- 상품 스펙
 	cart_pimage varchar2(500)               -- 상품 이미지
);
