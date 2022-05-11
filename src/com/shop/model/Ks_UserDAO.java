package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Ks_UserDAO {

	Connection con = null;           // DB연결
	PreparedStatement pstmt = null;  // DB에 SQL문을 전송하는 객체
	ResultSet rs = null;             // SQL문을 실행 후 결과 값을 가지고 있는 객체
	
	String sql = null;               // SQL문을 저장할 객체
	
	// Ks_UserDAO 객체를 싱글턴 방식으로 만들어 보자
	// 1단계 : 싱클턴 방식으로 객체를 만들기 위해서는 우선적으로 
	//       기본 생성자의 접근제어자를 public에서 private으로 바꿔 주어야한다. 
	
	// 2단계 : Ks_UserDAO 객체를 정적 멤버로 선언해 주어야 한다.  -static 으로 선언해야함
	private static Ks_UserDAO instance;
	
	private Ks_UserDAO() {}        // 기본생성자 
	
	// 3단계 : 기본 생성자 대신에 싱글턴 객체를 return 해주는 getInstance() 라는 메서드를
	// 만들어서 getInstance() 메서드에 외부에서 접근할 수 있게 해야함.
	public static Ks_UserDAO getInstance() {
		
		if(instance == null) {
			instance = new Ks_UserDAO();
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
	
	
	// 회원인지 확인하는 메서드
	public int getUserCheck(String id, String pwd) {
		
		int result = 0;
		
		try {

			openConn();
			
			sql = "select * from ks_user where user_id = ?";
			
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
		
	} // getUserCheck() 메서드 end
	
	// id에 해당하는 회원의 정보를 조회하는 메서드
	public Ks_UserDTO getKs_User(String id) {
		
		Ks_UserDTO dto = new Ks_UserDTO();
		
		try {

			openConn();
			
			sql = "select * from ks_user where user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_addr(rs.getString("user_addr"));
				dto.setUser_phone(rs.getString("user_phone"));
				dto.setUser_point(rs.getInt("user_point"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;
	} // getKs_User() 메서드 end
	
	
	// 회원정보를 수정하는 메서드
	public int UserUpdata(Ks_UserDTO dto) {
		
		int result = 0;
		
		try {

			openConn();
			
			sql = "update ks_user set "
					+ "user_email = ?, user_addr = ?,user_phone = ? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUser_email());
			pstmt.setString(2, dto.getUser_addr());
			pstmt.setString(3, dto.getUser_phone());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	} // UserUpdata() 메서드 end
	
}
