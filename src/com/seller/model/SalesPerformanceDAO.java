package com.seller.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SalesPerformanceDAO {
	
	Connection con = null;             // DB 연결하는 객체.
	PreparedStatement pstmt = null;    // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;               // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                 // SQL문을 저장할 객체.
	
	
	// DAO 객체를 싱글톤 방식으로 생성
	private static SalesPerformanceDAO instance = null;
	
	private SalesPerformanceDAO() {   }
		
	public static SalesPerformanceDAO getInstance() {
		
		if(instance == null) {
			instance = new SalesPerformanceDAO();
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
	
	public List<SalesPerformanceDTO> getProductList(String seller_id) {
		
		List<SalesPerformanceDTO> list = new ArrayList<SalesPerformanceDTO>();
		
		try {
			openConn();
			
			sql = "select * from view_sales_performance where seller_id = ?"
					+ "order by order_no desc, product_order_no desc";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SalesPerformanceDTO dto = new SalesPerformanceDTO();
				
				dto.setSeller_id(rs.getString("seller_id"));
				dto.setOrder_no(rs.getString("order_no"));
				dto.setProduct_order_no(rs.getInt("product_order_no"));
				dto.setProduct_no(rs.getInt("product_no"));
				dto.setProduct_quantity(rs.getInt("product_quantity"));
				dto.setProduct_price(rs.getInt("product_price"));
				dto.setOrder_date(rs.getString("order_date"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}
}
