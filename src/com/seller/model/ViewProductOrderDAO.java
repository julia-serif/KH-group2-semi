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

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

public class ViewProductOrderDAO {
	
	Connection con = null;             // DB 연결하는 객체.
	PreparedStatement pstmt = null;    // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;               // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                 // SQL문을 저장할 객체.
	
	
	// DAO 객체를 싱글톤 방식으로 생성
	private static ViewProductOrderDAO instance = null;
	
	private ViewProductOrderDAO() {   }
		
	public static ViewProductOrderDAO getInstance() {
		
		if(instance == null) {
			instance = new ViewProductOrderDAO();
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
	
	public List<ViewProductOrderDTO> getProductList(String seller_id) {
		
		List<ViewProductOrderDTO> list = new ArrayList<ViewProductOrderDTO>();
		
		try {
			openConn();
			
			sql = "select * from view_product_order_list where seller_id = ?"
					+ "order by order_no desc, product_order_no desc";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ViewProductOrderDTO dto = new ViewProductOrderDTO();
				
				dto.setSeller_id(rs.getString("seller_id"));
				dto.setOrder_no(rs.getString("order_no"));
				dto.setProduct_order_no(rs.getInt("product_order_no"));
				dto.setProduct_no(rs.getInt("product_no"));
				dto.setProduct_quantity(rs.getInt("product_quantity"));
				dto.setProduct_price(rs.getInt("product_price"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setAddress(rs.getString("address"));
				dto.setOrder_date(rs.getString("order_date"));
				dto.setOrder_status(rs.getString("order_status"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}
	
	
	public List<ViewProductOrderDTO> getNewOrderList(String seller_id) {
		
		List<ViewProductOrderDTO> list = new ArrayList<ViewProductOrderDTO>();
		
		try {
			openConn();
			
			sql = "select * from view_product_order_list where seller_id = ?"
					+ " and order_status = ?"
					+ " order by order_no desc, product_order_no desc";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			pstmt.setString(2, "발송준비");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ViewProductOrderDTO dto = new ViewProductOrderDTO();
				
				dto.setSeller_id(rs.getString("seller_id"));
				dto.setOrder_no(rs.getString("order_no"));
				dto.setProduct_order_no(rs.getInt("product_order_no"));
				dto.setProduct_no(rs.getInt("product_no"));
				dto.setProduct_quantity(rs.getInt("product_quantity"));
				dto.setProduct_price(rs.getInt("product_price"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setAddress(rs.getString("address"));
				dto.setOrder_date(rs.getString("order_date"));
				dto.setOrder_status(rs.getString("order_status"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}
	
	public static String getLineOfQs(int num) {
		  // Joiner and Iterables from the Guava library
		  return Joiner.on(", ").join(Iterables.limit(Iterables.cycle("?"), num));
		}	// https://code-examples.net/ko/q/788997

	public int updateDeliveryStatus(String seller_id, int[] checked_pons) {
		
		int check = 0;
		
		try {
			openConn();
			
			sql = "update ks_product_order"
					+ " set order_status = '배송시작'"
					+ " where seller_id = ? and"
					+ " product_order_no in (" +
						      getLineOfQs(checked_pons.length) + ")";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			for(int i=0; i<checked_pons.length; i++) {
				pstmt.setInt(i+2, checked_pons[i]);
			}
			check = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return check;
	}
	public List<ViewProductOrderDTO> getAllList() {
		
		List<ViewProductOrderDTO> list = new ArrayList<ViewProductOrderDTO>();
		
		try {
			openConn();
			
			sql = "select * from view_product_order_list order by order_status, order_no desc, product_order_no desc";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ViewProductOrderDTO dto = new ViewProductOrderDTO();
				
				dto.setSeller_id(rs.getString("seller_id"));
				dto.setOrder_no(rs.getString("order_no"));
				dto.setProduct_order_no(rs.getInt("product_order_no"));
				dto.setProduct_no(rs.getInt("product_no"));
				dto.setProduct_quantity(rs.getInt("product_quantity"));
				dto.setProduct_price(rs.getInt("product_price"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setAddress(rs.getString("address"));
				dto.setOrder_date(rs.getString("order_date"));
				dto.setOrder_status(rs.getString("order_status"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}
public List<ViewProductOrderDTO> getSelectMonth(String date) {
	
	List<ViewProductOrderDTO> list = new ArrayList<ViewProductOrderDTO>();
	
	try {
		openConn();
		
		sql = "select * from view_product_order_list where EXTRACT(MONTH FROM order_date)=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,date);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ViewProductOrderDTO dto = new ViewProductOrderDTO();
			
			dto.setSeller_id(rs.getString("seller_id"));
			dto.setOrder_no(rs.getString("order_no"));
			dto.setProduct_order_no(rs.getInt("product_order_no"));
			dto.setProduct_no(rs.getInt("product_no"));
			dto.setProduct_quantity(rs.getInt("product_quantity"));
			dto.setProduct_price(rs.getInt("product_price"));
			dto.setUser_id(rs.getString("user_id"));
			dto.setAddress(rs.getString("address"));
			dto.setOrder_date(rs.getString("order_date"));
			dto.setOrder_status(rs.getString("order_status"));
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
