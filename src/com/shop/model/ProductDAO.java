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

import com.shop.model.ProductDTO;
import com.sun.org.apache.bcel.internal.generic.DLOAD;


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

	}	// openconn() end

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

			 
			sql="select max(pno) from ks_product";
			 

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
	
	
	// 현재 페이지에 해당하는 게시물을 조회하는 메서드
	public List<ProductDTO> getProductList(int page, int rowsize) {
		
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		// 해당 페이지에서 시작 번호
		int startNo = (page * rowsize) - (rowsize - 1);
		
		// 해당 페이지에서 끝 번호
		int endNo = (page * rowsize);
		
		try {
			openConn();
	         
			sql = "select * from "
					+ " (select row_number() "
					+ " over(order by pno desc) rnum, "
					+ " p.* from ks_product p) "
					+ " where rnum >= ? and rnum <= ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);

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
	            dto.setPseller(rs.getString("pseller"));
	            
	            list.add(dto);
	            
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	} //getProductList() end
	
	
	public List<ProductDTO> getProductList1() {
		
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
	            dto.setPseller(rs.getString("pseller"));
	            
	            list.add(dto);
	            
	         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
	
	
	
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
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return count;

	}	// getProductCount() 메서드 end
	
	
	// 전체 리스트를 불러오는 메서드
	public List<ProductDTO> getKsProductList(){
		
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
		
	} // getKsProductList() 메서드 end
	
	
	// 코드번호에 해당하는 리스트를 보여주는 메서드 
    public List<ProductDTO> getProductCode(String code){
    	
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		try {

			openConn();
			
			sql = "select * from ks_product where pcode = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, code);
			
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
		
	} // getProductCode() 메서드 end
    
    
    // 검색 관련 조회하는 메서드
    public List<ProductDTO> getSearchProduct(String field, String name){
    	
    	List<ProductDTO> list = new ArrayList<ProductDTO>();
    	
    	if(field.equals("name")) {   // 이름으로 검색
    	 try {

        	openConn();
        	
        	sql = "select * from ks_product where pname like ? order by pno desc";
        	
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "%"+name+"%");
			
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
		}}else if(field.equals("all")) {
			try {

	        	openConn();
	        	
	        	sql = "select * from ks_product "
	        			+ "where pname like ? or pcompany like ? or pcontents like ?";				
				
	        	pstmt = con.prepareStatement(sql);	  
	        	
	        	pstmt.setString(1, "%"+name+"%");
	        	pstmt.setString(2, "%"+name+"%");
	        	pstmt.setString(3, "%"+name+"%");
				
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
				}} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
              	}
		}
    	return list;
    } // getSearchProduct() 메서드 end
    
   
    // 이름에 해당하는 제품을 검색하는 메서드
    public List<ProductDTO> getCategoryName(String name){
    	
    	List<ProductDTO> catelist =  new ArrayList<ProductDTO>();
    	
    	try {

        	openConn();
        	
        	sql = "select * from ks_product "
        			+ "where pname like ? order by pno desc";
        	
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
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
				
				catelist.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
    	
    	return catelist;
    	
    } // getCategoryName() 메서드 end
    
    
    // 해당 번호에 해당하는 상품 리스트를 불러오는 메서드
    public ProductDTO getOrderOk(int no) {
    	
    	ProductDTO dto = new ProductDTO();
    	
    	try {

        	openConn();
        	
        	sql = "select * from ks_product where pno = ? ";
        	
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
		}finally {
			closeConn(rs, pstmt, con);
		}
    	
    	return dto;
    	
    } // getOrderOk() 메서드 end
    
    
    
    
    //////
 // 전체 상품 목록 리스트를 조회하는 메서드.
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
 				
 				dto.setPcode(rs.getString("pcode"));
 				
 				dto.setPname(rs.getString("pname"));
 				
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
 	}  // getProductList() 메서드 end
 	
 	
 	
	// 제품번호에 해당하는 제품의 정보를 수정하는 메서드.
	public int updateProduct(ProductDTO dto) {
		
		int result = 0;
		
		
		try {
			openConn();
			
			sql = "update ks_product set pimage = ?, "
					+ " pqty = ?, price = ?, pspec = ?, "
					+ " pcontents = ?, point = ? "
					+ " where pno = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPimage());
			
			pstmt.setInt(2, dto.getPqty());
			
			pstmt.setInt(3, dto.getPrice());
			
			pstmt.setString(4, dto.getPspec());
			
			pstmt.setString(5, dto.getPcontents());
			
			pstmt.setInt(6, dto.getPoint());
			
			pstmt.setInt(7, dto.getPno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
			
		}
		
		return result;
	}  // updateProduct() 메서드 end
	
	// 제품번호에 해당하는 제품을 DB에서 삭제하는 메서드.
	public int deleteProduct(int num) {
		
		int result = 0;
		
		
		try {
			openConn();
			
			sql = "delete from ks_product "
					+ " where pno = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
			sql = "update ks_product set "
					+ " pno = pno - 1 "
					+ " where pno > ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}  // deleteProduct() 메서드 end
	
    
    
    
    
    
}




