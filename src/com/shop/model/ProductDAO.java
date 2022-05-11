package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	Connection con = null;					// DB 연결하는 객체
	PreparedStatement pstmt = null;			// DB SQL문을 전송하는 객체 
	ResultSet rs = null;					// SQL문을 실행 후 결과 값을 가지고 있는 객체
	
	String sql = null;						// SQL 문을 저장할 객체
	
	// ProductDAO 객체를 싱글턴 방식으로 만들어 보자.
	// 1단계 : 싱글턴 방식으로 만들기 위해서는 우선적으로
	// 		   기본 생성자의 접근 제어자를 public에서 private으로 바꿔주어야 한다.
	
	// 2단계 : ProductDAO 객체를 정적 멤버로 선언해 주어야 한다. - static으로 선언해야 함.
	private static ProductDAO instance;
	
	private ProductDAO() {	}	// 기본 생성자
	
	
	// 3단계 : 기본 생성자 대신에 싱글턴 객체를 return 해주는 getInstance() 라는 메서드를
	// 		   만들어서 이 getInstance() 메서드에 외부에서 접근할 수 있게 해야 함.
	public static ProductDAO getInstance() {
		
		if(instance == null) {
			instance = new ProductDAO();
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
	
	
	// 전체 상품 목록 리스트르 조회하는 메서드
	public List<ProductDTO> getProductList() {
		
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		try {

			openConn();
			
			sql = "select * from ks_product "
					+ " order by Pno desc";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ProductDTO dto = new ProductDTO();
				
				dto.setPno(rs.getInt("pno"));
				dto.setPname(rs.getString("pname"));
				dto.setPcode(rs.getString("pcode"));
				dto.setPcompany(rs.getString("pcompany"));
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
			
	}	// getProductList() 메서드 end
	
	
	// ks_product 테이블에 상품을 등록(추가)하는 메서드.
	public int insertProduct(ProductDTO dto) {
		
		int result = 0, count = 0;
		
		try {

			openConn();
			
			sql = "select max(pno) from ks_product";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			sql = "insert into ks_product "
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getPname());
			pstmt.setString(3, dto.getPcode());
			pstmt.setString(4, dto.getPcompany());
			pstmt.setString(5, dto.getPimage());
			pstmt.setInt(6, dto.getPqty());
			pstmt.setInt(7, dto.getPrice());
			pstmt.setString(8, dto.getPspec());
			pstmt.setString(9, dto.getPcontents());
			pstmt.setInt(10, dto.getPoint());
			
			result = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;		
		
	}	// insertProduct() 메서드 end
	
	

	// 제품 번호에 해당하는 제품에 대한 상세 정보를 조회하는 메서드.
	public ProductDTO productContent(int no) {
		
		ProductDTO dto = new ProductDTO();
		
		try {
			
			openConn();
			
			sql = "select * from ks_product where pno = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setPno(rs.getInt("pno"));
				dto.setPname(rs.getString("pname"));
				dto.setPcode(rs.getString("pcode"));
				dto.setPcompany(rs.getString("pcompany"));
				dto.setPimage(rs.getString("pimage"));
				dto.setPqty(rs.getInt("pqty"));
				dto.setPrice(rs.getInt("price"));
				dto.setPspec(rs.getString("pspec"));
				dto.setPcontents(rs.getString("pcontents"));
				dto.setPoint(rs.getInt("point"));
				dto.setPinputdate(rs.getString("pinputdate"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;
		
	}	// productContent() 메서드 end


	public int getProductCount() {
		
		int count = 0;
		
		try {
			
			openConn();
			
			sql = "select count(*) from ks_product";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return count;

	}	// getProductCount() 메서드 end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
