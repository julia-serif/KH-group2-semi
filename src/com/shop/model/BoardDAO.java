package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	Connection con = null;					// DB 연결하는 객체
	PreparedStatement pstmt = null;			// DB SQL문을 전송하는 객체 
	ResultSet rs = null;					// SQL문을 실행 후 결과 값을 가지고 있는 객체
	
	String sql = null;						// SQL 문을 저장할 객체
	
	// ProductDAO 객체를 싱글턴 방식으로 만들어 보자.
	// 1단계 : 싱글턴 방식으로 만들기 위해서는 우선적으로
	// 		   기본 생성자의 접근 제어자를 public에서 private으로 바꿔주어야 한다.
	
	// 2단계 : ProductDAO 객체를 정적 멤버로 선언해 주어야 한다. - static으로 선언해야 함.
	private static BoardDAO instance;
	
	private BoardDAO() {	}	// 기본 생성자
	
	
	// 3단계 : 기본 생성자 대신에 싱글턴 객체를 return 해주는 getInstance() 라는 메서드를
	// 		   만들어서 이 getInstance() 메서드에 외부에서 접근할 수 있게 해야 함.
	public static BoardDAO getInstance() {
		
		if(instance == null) {
			instance = new BoardDAO();
		}
		
		return instance;
		
	}	// getInstance() 메서드 end
		
		
	// DB를 연동하는 작업을 진행하는 메서드
	public void openConn() {
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "semi";
			String password = "1234";
			
			// 1단계 : 오라클 드라이버 로딩.
			try {
				// 1단계 : 오라클 드라이버 로딩.
				Class.forName(driver);
				
				// 2단계 : 오라클 데이터베이스와 연결 진행.
				con = DriverManager.getConnection(url, user, password);
			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
	}	// openConn() 메서드 end
	
	

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
	
	public int getBoardCount() {
		
		int count = 0;
		
		try {

			openConn();
			
			sql = "select count(*) from qna_board";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);				
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}	// getBoardCount() 메서드 end
	
	
	// board 테이블에서 현재 페이지에 해당하는 게시물을 조회하는 메서드.
		public List<BoardDTO> getBoardList(int page, int rowsize) {
			
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			
			// 해당 페이지에서 시작 번호
			int startNo = (page * rowsize) - (rowsize - 1);
			
			// 해당 페이지에서 끝 번호
			int endNo = (page * rowsize);
			
			try {

				openConn();
				
				sql = "select * from "
						+ " (select row_number() "
						+ " over(order by board_no desc) rnum, "
						+ " b.* from qna_board b) "
						+ " where rnum >= ? and rnum <= ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, startNo);
				pstmt.setInt(2, endNo);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardDTO dto = new BoardDTO();
					
					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_writer(rs.getString("board_writer"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_cont(rs.getString("board_cont"));
					dto.setBoard_date(rs.getString("board_date"));
					dto.setBoard_update(rs.getString("board_update"));
					
					list.add(dto);
				}
			
			} catch (SQLException e) {			
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
			
			return list;
			
		}	// getBoardList() 메서드 end
	
		
		
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
					+ " values(?, ?, ?, ?, default, sysdate, '', ?, 0, 0)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_title());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setInt(5, count);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;		
		
	}	// insertBoard() 메서드 end
	
	
	
	
	
	
	
}
