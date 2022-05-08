--이전 테이블 삭제
drop table ks_product_order;
drop table ks_order;
drop table ks_user;
drop table ks_seller;


create table ks_order(
	order_no varchar2(100) primary key,					--주문 번호
	user_id varchar2(20) references shop_user(user_id),	--주문자(회원)
	order_date date,									--주문 날짜
	recipient varchar2(50) not null,					--수령인(이름)
	recipient_phone varchar2(20),						--수령인 전화번호
	address varchar2(30) not null						--배송 주소
);

create table ks_product_order(
	product_order_no number(10) primary key,				--상품 주문 번호(각각 상품마다)
	order_no varchar2(100) references ks_order(order_no),	--주문 번호
	product_no number(10) references ks_product(pno),		--상품 번호
	product_quantity number(10) not null,					--주문 수량
	product_price number(10) not null,						--주문 금액	
	expected_date date,										--수령 예상 날짜
	order_status varchar2(30) not null,						--배송 상태
	seller_id varchar2(20) references shop_user(user_id)	--판매자
);

