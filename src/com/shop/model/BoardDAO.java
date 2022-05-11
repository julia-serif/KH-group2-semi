package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	Connection con = null;					// DB 연결하는 객체
	PreparedStatement pstmt = null;			// DB SQL문을 전송하는 객체 
	ResultSet rs = null;					// SQL문을 실행 후 결과 값을 가지고 있는 객체
	
	String sql = null;						// SQL 문을 저장할 객체
	
private static BoardDAO instance;    //instance는 참조변수
	
	private BoardDAO() { }
	
	public static BoardDAO getInstance() {
		
		if(instance == null) {
			instance = new BoardDAO();
		}
		
		return instance;    //BoardDAO 객체의 주소값 반환
		
	}
	
	//DB를 연동하는 작업을 진행하는 메소드 - DBCP방식으로 연결 진행
	public void openConn() {

		try {
			//1단계 : JNDI 서버 객체 생성
			//context.javax.naming 사용
			Context ctx = new InitialContext();

			//2단계 : lookup() 메소드를 이용하여 매칭되는 커넥션을 찾는다.
			//DataSource : javax.sql로 생성
			//ctx.lookup은 object타입이라 DataSource 변환해준다.
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");

			//3단계 : DataSource 객체를 이용하여 커넥션 객체를 하나 가져온다.
			con = ds.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}               //context.javax.naming 사용

	}// openConn end
	
	

	// DB에 연결되어 있는 자원을 종료하는 메서드
	public void closeConn(ResultSet rs,
		PreparedStatement pstmt, Connection con) {
		
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}	// closeConn() 메서드 end
		
	
	// qna_board 테이블의 전체 레코드를 조회하는 메서드
	public List<BoardDTO> getBbsList(int no) {
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			
			openConn();
			
			sql = "select * from qna_board where board_product = ?"
					+ " order by board_group desc, board_step";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_update(rs.getString("board_update"));
				dto.setBoard_group(rs.getInt("board_group"));
				dto.setBoard_step(rs.getInt("board_step"));
				dto.setBoard_indent(rs.getInt("board_indent"));
				dto.setBoard_product(rs.getInt("board_product"));
				
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
		
	}	// getBbsList() 메서드 end

		
		
	// qna_board 테이블에 게시글을 추가하는 메서드
	public int insertBoard(BoardDTO dto) {
		
		int result = 0, count = 0;
		
		try {

			openConn();
			
			sql = "select max(board_no) from qna_board";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			
			sql = "insert into qna_board "
					+ " values(?, ?, ?, ?, sysdate, '', ?, 0, 0, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_title());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setInt(5, count);
			pstmt.setInt(6, dto.getBoard_product());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;		
		
	}	// insertBoard() 메서드 end
	
	
	
	public BoardDTO getBbsContent(int no) {
		
		BoardDTO dto = new BoardDTO();
		
		try {
			openConn();
			
			sql = "select * from qna_board "
					+ " where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_update(rs.getString("board_update"));
				dto.setBoard_group(rs.getInt("board_group"));
				dto.setBoard_step(rs.getInt("board_step"));
				dto.setBoard_indent(rs.getInt("board_indent"));
				dto.setBoard_product(rs.getInt("board_product"));
				
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;		
		
	}	// getBbsContent() 메서드 end
	
	
	// qna_board 테이블에 글 번호에 해당하는 게시글을 수정하는 메서드.
	public int updateBbs(BoardDTO dto) {
		
		int result = 0;
		
		try {

			openConn();
			
			sql = "select * from qna_board "
					+ " where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBoard_no());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				sql = "update qna_board set "
						+ " board_title = ?, board_cont = ?, "
						+ " board_update = sysdate "
						+ " where board_no = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, dto.getBoard_title());
				pstmt.setString(2, dto.getBoard_cont());
				pstmt.setInt(3, dto.getBoard_no());
				
				result = pstmt.executeUpdate();
					
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
		
	}	// updateBbs() 메서드 end
	
	
	
	// qna_board 테이블에서 게시글을 삭제하는 메서드.
	public int deleteBbs(int no) {
		
		int result = 0;
		
		try {

			openConn();
			
			sql = "select * from qna_board "
					+ " where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
									
				sql = "delete from qna_board "
						+ " where board_no = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, no);
				
				result = pstmt.executeUpdate();
				
				sql = "update qna_board set "
						+ " board_no = board_no - 1, "
						+ " board_group = board_group - 1"
						+ " where board_no > ? ";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, no);
				
				pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
		
	}	// deleteBbs() 메서드 end
	
	
	// jsp_bbs 테이블에서 답변 글의 step을 하나 증가시키는 메서드
	public void replyUpdate(int group, int step) {
		
		
		try {
			
			openConn();
			
			sql = "update qna_board set "
					+ " board_step = board_step + 1 "
					+ " where board_group = ? and board_step > ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, group);
			pstmt.setInt(2, step);
			
			pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}

	}	// replyUpdate() 메서드 end
	
	
	// jsp_bbs 테이블의 게시글 원글에 답변글을 추가하는 메서드
	public int replyBbs(BoardDTO dto) {
		
		int result = 0, count = 0;
		
		try {
			
			openConn();
			
			sql = "select max(board_no) from qna_board";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			sql = "insert into qna_board "
					+ " values(?, ?, ?, ?, sysdate, '', ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_title());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setInt(5, dto.getBoard_group());
			pstmt.setInt(6, dto.getBoard_step() + 1);
			pstmt.setInt(7, dto.getBoard_indent() + 1);
			pstmt.setInt(8, dto.getBoard_product());
			
			result = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
		
	}	// replyBbs() 메서드 end
	
	
}
