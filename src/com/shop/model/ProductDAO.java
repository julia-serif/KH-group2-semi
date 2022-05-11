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

public class ProductDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
	
	private static ProductDAO instance;    //instance는 참조변수
	
	private ProductDAO() { }
	
	public static ProductDAO getInstance() {
		
		if(instance == null) {
			instance = new ProductDAO();
		}
		
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
		} //context.javax.naming 사용

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
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";

			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getPname());
			pstmt.setString(3, dto.getPcode());
			pstmt.setString(4, dto.getPcompany());
			pstmt.setString(5, dto.getPimage());
			pstmt.setInt(6, dto.getPqty());
			pstmt.setInt(7, dto.getPrice());
			pstmt.setString(8, dto.getPspec());
			pstmt.setNString(9, dto.getPcontents());
			pstmt.setInt(10, dto.getPoint());
			pstmt.setString(11, dto.getPseller());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		 
		 return result;
		 
	 } //insertProduct() end
	
	
	public List<ProductDTO> getProductList() {
		
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		
		try {
			openConn();
	         
	         sql = "select * from ks_product order by pno desc";
	         
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
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	} //getProductList() end
	
	public ProductDTO productContent(int num) {
		
		ProductDTO dto = new ProductDTO();
		
		try {
			openConn();
			
			sql = "select * from ks_product where pno = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
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
				dto.setPseller(rs.getString("pseller"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;
		
	
	}//productContent() end

	//결제된 상품 재고 차감
	public void productQty(int[] pnum, int[] qty) {
		
		try {
			
			
			openConn();
			
			for(int i=0; i<pnum.length; i++) {
				
				sql="update ks_product set pqty = pqty - ? where pno = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, qty[i]);
				pstmt.setInt(2, pnum[i]);
				
				rs = pstmt.executeQuery();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	// productQty() 메서드 end


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


