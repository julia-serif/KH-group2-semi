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

public class Customer_AskDAO {

	Connection con = null;           // DB연결
	PreparedStatement pstmt = null;  // DB에 SQL문을 전송하는 객체
	ResultSet rs = null;             // SQL문을 실행 후 결과 값을 가지고 있는 객체
	
	String sql = null;               // SQL문을 저장할 객체
	
	// Customer_AskDAO 객체를 싱글턴 방식으로 만들어 보자
	// 1단계 : 싱클턴 방식으로 객체를 만들기 위해서는 우선적으로 
	//       기본 생성자의 접근제어자를 public에서 private으로 바꿔 주어야한다. 
	
	// 2단계 : Customer_AskDAO 객체를 정적 멤버로 선언해 주어야 한다.  -static 으로 선언해야함
	private static Customer_AskDAO instance;
	
	private Customer_AskDAO() {}        // 기본생성자 
	
	// 3단계 : 기본 생성자 대신에 싱글턴 객체를 return 해주는 getInstance() 라는 메서드를
	// 만들어서 getInstance() 메서드에 외부에서 접근할 수 있게 해야함.
	public static Customer_AskDAO getInstance() {
		
		if(instance == null) {
			instance = new Customer_AskDAO();
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
	
	// DB에 저장 된 모든 정보를 가져오는 메서드
	public List<Customer_AskDTO> getAskList(){
		
		List<Customer_AskDTO> list = new ArrayList<Customer_AskDTO>();
		
		try {

			openConn();
			
			sql = "select * from customer_ask";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer_AskDTO dto = new Customer_AskDTO();
				
				dto.setCs_no(rs.getInt("cs_no"));
				dto.setCs_writer(rs.getString("cs_writer"));
				dto.setCs_title(rs.getString("cs_title"));
				dto.setCs_cont(rs.getString("cs_cont"));
				dto.setCs_image(rs.getString("cs_image"));
				dto.setCs_date(rs.getString("cs_date"));
				dto.setCs_update(rs.getString("cs_update"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
		
	} // getAskList() 메서드 end
	
	
	
}
