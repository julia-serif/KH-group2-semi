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

public class productDAO {


	Connection con = null;             // DB 연결하는 객체.
	PreparedStatement pstmt = null;    // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;               // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                 // SQL문을 저장할 객체.
	
	
	// productDAO 객체를 싱글톤 방식으로 만들기
	private static productDAO instance = null;
	
	
	private productDAO() {   }  // 기본생성자.
		
	public static productDAO getInstance() {
		
		if(instance == null) {
			instance = new productDAO();
		}
		return instance;
		
	}  // getInstance() 메서드 end
	
	
	// DB를 연동하는 메서드
	public void openConn() {
		
		try {
			
			Context ctx = new InitialContext();
			
			
			DataSource ds =
					(DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
			
	
			con = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}  // closeConn() 메서드 end
	
	
	
	// product 테이블에 있는 전체 리스트를 조회하는 메서드.
	public List<productDTO> getProductList() {
		
		List<productDTO> list = new ArrayList<productDTO>();
		
		
		try {
			openConn();
			
			sql = "select * from ks_product order by pno desc";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				productDTO dto = new productDTO();
				
				dto.setPno(rs.getInt("pno"));
				
				dto.setPname(rs.getString("pname"));
				
				dto.setPcode(rs.getString("pcode"));
				
				dto.setPcompany(rs.getString("pcomany"));
				
				dto.setPimage(rs.getString("pimage"));
				
				dto.setPqty(rs.getInt("pqty"));
				
				dto.setPrice(rs.getInt("price"));
				
				dto.setPspec(rs.getString("pspec"));
				
				dto.setPcontents(rs.getString("pcontents"));
				
				dto.setPoint(rs.getInt("point"));
				
				dto.setPinputdate(rs.getString("pinputdate"));
				
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
			
		}
		
		return list;
	}  //productList() 메서드 end
}
