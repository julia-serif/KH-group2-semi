create table qna_board (
	board_no number(5) primary key,				-- 게시판 글번호
	board_writer varchar2(30) not null,			-- 게시판 글 작성자
	board_title varchar2(100) not null,			-- 게시판 글 제목
	board_cont varchar2(1000) not null,			-- 게시판 글 내용
	board_date date,							-- 게시판 글 작성일자
	board_update date,							-- 게시판 글 수정일자
	board_group number(5),						-- 게시판 글 그룹
	board_step number(5),						-- 게시판 글 답변 단계
	board_indent number(5),						-- 게시판 답변글 들여쓰기
	board_product number(10),
	constraints fk_bp foreign key(board_product)
	references ks_product(pno)
);

