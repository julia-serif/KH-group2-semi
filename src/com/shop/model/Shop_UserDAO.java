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

public class Shop_UserDAO {

	Connection con = null;           // DB연결
	PreparedStatement pstmt = null;  // DB에 SQL문을 전송하는 객체
	ResultSet rs = null;             // SQL문을 실행 후 결과 값을 가지고 있는 객체
	
	String sql = null;               // SQL문을 저장할 객체
	
	// Ks_UserDAO 객체를 싱글턴 방식으로 만들어 보자
	// 1단계 : 싱클턴 방식으로 객체를 만들기 위해서는 우선적으로 
	//       기본 생성자의 접근제어자를 public에서 private으로 바꿔 주어야한다. 
	
	// 2단계 : Ks_UserDAO 객체를 정적 멤버로 선언해 주어야 한다.  -static 으로 선언해야함
	private static Shop_UserDAO instance;
	
	private Shop_UserDAO() {}        // 기본생성자 
	
	// 3단계 : 기본 생성자 대신에 싱글턴 객체를 return 해주는 getInstance() 라는 메서드를
	// 만들어서 getInstance() 메서드에 외부에서 접근할 수 있게 해야함.
	public static Shop_UserDAO getInstance() {
		
		if(instance == null) {
			instance = new Shop_UserDAO();
		}
		
		return instance;
	}  // getInstance() 메서드 end
	
	// DB를 연동하는 작업을 진행하는 메서드 - DBCP 방식으로 DB와 연결 진행 
	public void openConn() {

		try {
			// 1단계 : JNDI 서버 객체 생성
			Context ctx = new InitialContext();
			
			// 2단계 : lookup() 메서드를 이용하여 매칭되는 커넥션을 찾는다.
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
			
			// 3단계 : DataSource 객체를 이용하여 커넥션 객체를 하나 가져온다.
			con = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	} // openConn() 메서드 end
	
	
	// DB에 연결된 자원을 종료하는 메서드
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
	} // closeConn() 메서드 end

	// 회원 리스트를 가져오는 메서드
	public List<Shop_UserDTO> getUserList(){
		
		List<Shop_UserDTO> list = new ArrayList<Shop_UserDTO>();
		
		try {

			openConn();
			
			sql = "select * from shop_user order by user_no";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Shop_UserDTO dto = new Shop_UserDTO();
				
				dto.setUser_no(rs.getInt("user_no"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_age(rs.getInt("user_age"));
				dto.setUser_phone(rs.getString("user_phone"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_addr(rs.getString("user_addr"));
				dto.setUser_mileage(rs.getInt("user_mileage"));
				dto.setUser_grade(rs.getString("user_grade"));
				dto.setUser_level(rs.getInt("user_level"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
		
	} // getUserList() 메서드 end
	
     
	// 회원 비밀번호 체크하는 메서드
	public int getUserCheck(String id,String pwd) {
		
		int result = 0;
		
		try {

			openConn();
			
			sql = "select * from shop_user where user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("user_pwd"))) {
					result = 1;
				}else {
					result = -1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
				
	} // getUserPwdCheck() 메서드 end
	
	
	// 회원의 비밀번호를 가져오는 메서드
	public int getUserPwd(String pwd) {
		
		int result = 0;
		
		try {

			openConn();
			
			sql = "select * from shop_user where user_pwd = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("user_pwd"))) {
					result = 1;
				}else {
					result = -1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
		
	} // getUserPwd() 메서드 end
	
	// 회원의 아이디를 가져오는 메서드
	public Shop_UserDTO getUserId(String id) {
		
		Shop_UserDTO dto = new Shop_UserDTO();
		
		try {

			openConn();
			
			sql = "select * from shop_user where user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setUser_no(rs.getInt("user_no"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_age(rs.getInt("user_age"));
				dto.setUser_phone(rs.getString("user_phone"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_addr(rs.getString("user_addr"));
				dto.setUser_mileage(rs.getInt("user_mileage"));
				dto.setUser_grade(rs.getString("user_grade"));
				dto.setUser_level(rs.getInt("user_level"));
				dto.setRegdate(rs.getString("regdate"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;
	} // getUserId() 메서드 end
	
	// 회원 정보를 수정하는 메서드
	public int getUserData(Shop_UserDTO dto) {
		
		int result = 0;
		
		try {

			openConn();
			
			sql = "update shop_user set "
					+ "user_phone = ?, user_email = ?, user_addr = ? "
					+ "where user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUser_phone());
			pstmt.setString(2, dto.getUser_email());
			pstmt.setString(3, dto.getUser_addr());
			pstmt.setString(4, dto.getUser_id());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
		
	} // getUserData() 메서드 end
	
	
	
}
