create table ks_order(
	order_no number(10) primary key,					--주문 번호
	user_id varchar2(30) references ks_user(user_id),	--주문자(회원)
	order_date date,									--주문 날짜
	payment_date date,									--결제 날짜
	recipient varchar2(50) not null,					--수령인(이름)
	recipient_phone varchar2(20),						--수령인 전화번호
	address1 varchar2(20) not null,						--배송 주소(우편번호)
	address2 varchar2(50) not null,						--배송 주소(주소)
	address3 varchar2(50) not null,						--배송 주소(상세주소)
	seller_id varchar2(30) references ks_seller(seller_id)	--판매자
);

create table ks_product_order(
	product_order_no number(10) primary key,				--상품 주문 번호(각각 상품마다)
	order_no number(10) references ks_order(order_no),		--주문 번호
	product_no number(10) references ks_product(pno),		--상품 번호
	product_quantity number(10) not null,					--주문 수량
	product_price number(10) not null,						--주문 금액	
	expected_date date,										--수령 예상 날짜
	order_status varchar2(30) not null						--배송 상태
);

insert into ks_seller values('seller1', '1234', '판매자1');	--테스트용 판매자 계정

insert into ks_user values('user1', '1234', '김모모', null, null, null, null);
insert into ks_user values('jimin12', '1234', '박지민', null, null, null, null);

insert into ks_order values(1, 'user1', sysdate, sysdate, '김모모', '010-0234-4521'
	, '12345', '서울시 모모구 경복궁대로 43', '104동 1002호', 'seller1');
insert into ks_order values(2, 'jimin12', sysdate, sysdate, '박지민', '010-2314-3452'
	, '03252', '경기도 수원시 지원구 심심로 23', '203동 505호', 'seller1');
