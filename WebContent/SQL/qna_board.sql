-- qna_board 테이블 생성

create table qna_board (

	board_no number(5) primary key,				-- 게시판 글번호
	board_writer varchar2(30) not null,			-- 게시판 글 작성자
	board_title varchar2(100) not null,			-- 게시판 글 제목
	board_cont varchar2(1000) not null,			-- 게시판 글 내용
	board_date date,							-- 게시판 글 작성일자
	board_update date,							-- 게시판 글 수정일자
	board_group number(5),						-- 게시판 글 그룹
	board_step number(5),						-- 게시판 글 답변 단계
	board_indent number(5)						-- 게시판 답변글 들여쓰기
);

insert into qna_board 
	values(1, '홍길동', '상품 문의', '상품 문의 관련 글입니다.', sysdate, '', 1, 0, 0);

insert into qna_board 
	values(2, '유관순', '사이즈 문의', '사이즈 문의 관련 글입니다.', sysdate, '', 2, 0, 0);
	
insert into qna_board 
	values(3, '김유신', '입고 문의', '입고 문의 관련 글입니다.', sysdate, '', 3, 0, 0);
	
insert into qna_board 
	values(4, '이순신', '가격 문의', '가격 문의 관련 글입니다.', sysdate, '', 4, 0, 0);

