package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CategoryDAO {

<<<<<<< HEAD
	Connection con = null;             // DB 연결하는 객체.
	PreparedStatement pstmt = null;    // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;               // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                 // SQL문을 저장할 객체.
	
	
	// CategoryDAO 객체를 싱글톤 방식으로 만들어 보자.
	// 1단계 : 싱글톤 방식으로 객체를 만들기 위해서는 우선적으로
	//        기본 생성자의 접근 제어자를 private 으로 선언해야 함.
	// 2단계 : CategoryDAO 객체를 정적 멤버로 선언해야 함. - static으로 선언해야 함.
	private static CategoryDAO instance = null;
	
	
	private CategoryDAO() {   }  // 기본생성자.
		
	// 3단계 : 기본 생성자 대신에 싱글턴 객체를 return 해 주는 getInstance() 라는
	//        메서드를 만들어서 여기에 접근하게 해야 함.
=======
	Connection con = null;					// DB 연결하는 객체
	PreparedStatement pstmt = null;			// DB SQL문을 전송하는 객체 
	ResultSet rs = null;					// SQL문을 실행 후 결과 값을 가지고 있는 객체
	
	String sql = null;						// SQL 문을 저장할 객체
	
	private static CategoryDAO instance;    //instance는 참조변수
	
	private CategoryDAO() { }
	
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
	public static CategoryDAO getInstance() {
		
		if(instance == null) {
			instance = new CategoryDAO();
		}
<<<<<<< HEAD
		return instance;
		
	}  // getInstance() 메서드 end
	
	
	// DB를 연동하는 작업을 진행하는 메서드
	public void openConn() {
		
		try {
			// 1단계 : JNDI 서버 객체 생성
			Context ctx = new InitialContext();
			
			// 2단계 : lookup() 메서드를 이용하여 매칭되는 커넥션을 찾는다.
			DataSource ds =
					(DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
			
			// 3단계 : DataSource 객체를 이용하여 커넥션 객체를 하나 가져온다.
			con = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}  // openConn() 메서드 end
	
	
	// DB에 연결된 자원을 종료하는 메서드
	public void closeConn(ResultSet rs,
			PreparedStatement pstmt, Connection con) {
=======
		
		return instance;    //ProductDAO 객체의 주소값 반환
		
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
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
		
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
<<<<<<< HEAD
=======
				
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
<<<<<<< HEAD
	}  // closeConn() 메서드 end
	
	
	// 카테고리 테이블에 카테고리 코드를 추가하는 메서드.
	public int insertCategory(String code, String name) {
		
		int result = 0, count = 0;
		
		
		try {
			openConn();
			
			sql = "select max(category_no) from ks_category";
			
=======
	}	// closeConn() 메서드 end	
		
	// 카테고리 테이블에 카테고리 코드를 추가하는 메서드
	public int insertCategory(String code, String name) {
		
		int result = 0, count = 0;
				
		try {

			openConn();
			
			sql = "select max(category_no) "
					+ " from ks_category";

>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
<<<<<<< HEAD
			sql = "insert into ks_category values(?, ?, ?)";
=======
			sql = "insert into ks_category "
					+ " values(?, ?, ?)";
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
<<<<<<< HEAD
			
			pstmt.setString(2, code);
			
=======
			pstmt.setString(2, code);
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
			pstmt.setString(3, name);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
<<<<<<< HEAD
	}  // insertCategory() 메서드 end
=======
		
	}	// insertCategory() 메서드 end
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
	
	
	// 카테고리 테이블에 있는 전체 리스트를 조회하는 메서드.
	public List<CategoryDTO> getCategoryList() {
		
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		
<<<<<<< HEAD
		
		try {
			openConn();
			
			sql = "select * from shop_category "
					+ " order by category_no desc";
=======
		try {
			
			openConn();
			
			sql = "select * from ks_category order by category_no desc";
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				CategoryDTO dto = new CategoryDTO();
				
				dto.setCategory_no(rs.getInt("category_no"));
<<<<<<< HEAD
				
				dto.setCategory_code(rs.getString("category_code"));
				
=======
				dto.setCategory_code(rs.getString("category_code"));
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
				dto.setCategory_name(rs.getString("category_name"));
				
				list.add(dto);
				
			}
<<<<<<< HEAD
			
=======

>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
<<<<<<< HEAD
			
		}
		
		return list;
	}  // getCategoryList() 메서드 end
	
	
	// 카테고리 번호에 해당하는 카테고리를 DB에서 삭제하는 메서드.
	public int deleteCategory(int no) {
		
		int result = 0;
		
		
		try {
			openConn();
			
			sql = "delete from shop_category where category_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
			sql = "update shop_category set category_no = category_no - 1 "
					+ " where category_no > ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}  // deleteCategory() 메서드 end
=======
		}
		
		return list;
		
	}	// getCategoryList() 메서드 end
	
	
	
	
	
	
	
	
	
	
	
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
	
	
}
