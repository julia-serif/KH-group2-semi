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

public class UserDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
	//UserDAO 객체를 싱글턴 방식으로 만들어 보자.
		// 1단계 : 싱글톤 방식으로 객체를 만들기 위해서는 우선적으로 
		//       기본생성자의 접근 제어자를 public에서  private로 바꿔 주어야한다.
		//       외부에서 접근하지 못하도록 하기 위함.(외부에서 접근하면 객체가 무수히 생성되어 메모리에 불리)
		
	// 2단계 : UserDAO 객체를 정적 멤버로 선언해 주어야 한다. - static으로 선언해야함
	private static UserDAO instance;    //instance는 참조변수
	
	private UserDAO() { }
	
	// 3단계 : 기본 생성자 대신 싱글톤 객체를 return 해주는 getInstance() 라는 메소드를 만들어
	//       getInstance() 메소드에 외부에서 접근할 수 있게 해줘야 함.
	public static UserDAO getInstance() {
		
		if(instance == null) {
			instance = new UserDAO();
		}
		
		return instance;    //UserDAO 객체의 주소값 반환
		
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
	
	//DB에 연결된 자원을 종료시키는 메소드
	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con) {
		
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
	} //closeConn() end
	
	//회원인지 확인
	public int userCheck(String id, String pwd) {
		
		int result = 0;
		try {
			
			openConn();
			
			sql = "select * from shop_user where user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("user_pwd"))) {
					//회원인 경우
					result = 1;
				}else {
					//비밀번호가 틀린경우, 아이디는 있음
					result = -1;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return result;
	}//userCheck() end

	//id에 해당하는 회원의 정보를 조회하는 메소드
	public UserDTO getMember(String id) {
		
		UserDTO dto = new UserDTO();
		
		
		try {
			openConn();
			
			sql = "select * from shop_user where user_id = ?";
			
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
				dto.setUser_mileage(rs.getInt("user_mileage"));
				dto.setUser_age(rs.getInt("user_age"));
				dto.setUser_grade(rs.getString("user_grade"));
				dto.setUser_no(rs.getInt("user_no"));
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
		
	}//getMember() end

}
