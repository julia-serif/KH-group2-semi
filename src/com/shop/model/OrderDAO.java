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

public class OrderDAO {
	
	Connection con = null;             // DB 연결하는 객체.
	PreparedStatement pstmt = null;    // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;               // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                 // SQL문을 저장할 객체.
	
	
	// DAO 객체를 싱글톤 방식으로 생성
	private static OrderDAO instance = null;
	
	
	private OrderDAO() {   }
		
	public static OrderDAO getInstance() {
		
		if(instance == null) {
			instance = new OrderDAO();
		}
		return instance;
		
	}
	
	
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
			e.printStackTrace();
		}
			
	}  // openConn() 메서드 end
	
	
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
				e.printStackTrace();
			}
		
	}  // closeConn() 메서드 end
	
//	public List<OrderDTO> getProductList(String seller_id) {
//		
//		List<OrderDTO> list = new ArrayList<OrderDTO>();
//		
//		try {
//			openConn();
//			
//			sql = "select * from ks_order where seller_id = ?"
//					+ "order by order_no desc";
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, seller_id);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				OrderDTO dto = new OrderDTO();
//				
//				dto.setOrder_no(rs.getInt("order_no"));
//				dto.setUser_id(rs.getString("user_id"));
//				dto.setOrder_date(rs.getString("order_date"));
//				dto.setPayment_date(rs.getString("payment_date"));
//				dto.setRecipient(rs.getString("recipient"));
//				dto.setRecipient_phone(rs.getString("recipient_phone"));
//				dto.setAddress1(rs.getString("address1"));
//				dto.setAddress2(rs.getString("address2"));
//				dto.setAddress3(rs.getString("address3"));
//				dto.setSeller_id(rs.getString("seller_id"));
//				
//				list.add(dto);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeConn(rs, pstmt, con);
//		}
//		
//		return list;
//	}
}
