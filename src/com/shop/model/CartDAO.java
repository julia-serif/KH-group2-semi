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

public class CartDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
	//DAO 객체를 싱글턴 방식으로 생성
	private static CartDAO instance;    //instance는 참조변수
	
	private CartDAO() { }
	
	public static CartDAO getInstance() {
		
		if(instance == null) {
			instance = new CartDAO();
		}		
		return instance;    //CartDAO 객체의 주소값 반환
		
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
	
	//카트에 추가
	public int insertCart(CartDTO dto) {
		
		int result=0, count=0;
		
		try {
			openConn();
			
			sql = "select max(cart_num) from ks_cart";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			//카트에 추가할 제품이 카트에 들어있는지 확인 
			sql = "select * from ks_cart where cart_userId = ? and cart_pnum = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCart_userId());
			pstmt.setInt(2, dto.getCart_pnum());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				
				result = -1;
				
			}else {
			
			sql = "insert into ks_cart values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setInt(2, dto.getCart_pnum());
			pstmt.setString(3, dto.getCart_userId());
			pstmt.setString(4, dto.getCart_pname());
			pstmt.setInt(5, dto.getCart_pqty());
			pstmt.setInt(6, dto.getCart_price());
			pstmt.setString(7, dto.getCart_pspec());
			pstmt.setString(8, dto.getCart_pimage());
			pstmt.setNString(9, dto.getCart_seller());
			
			result = pstmt.executeUpdate();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		
		return result;
	}//insertCart() end
	
	
	// 카트에 담긴 전체 목록을 가져오는 메서드
	public List<CartDTO> getCartList(String id) {
		
		List<CartDTO> list = new ArrayList<CartDTO>();
		
		try {
			openConn();
			
			sql = "select * from ks_cart where cart_userid = ?"
					+ "	order by cart_num desc";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				CartDTO dto = new CartDTO();
				
				dto.setCart_num(rs.getInt("cart_num"));
				dto.setCart_pnum(rs.getInt("cart_pnum"));
				dto.setCart_userId(rs.getString("cart_userId"));
				dto.setCart_pname(rs.getString("cart_pname"));
				dto.setCart_pqty(rs.getInt("cart_pqty"));
				dto.setCart_price(rs.getInt("cart_price"));
				dto.setCart_pspec(rs.getString("cart_pspec"));
				dto.setCart_pimage(rs.getString("cart_pimage"));
				dto.setCart_seller(rs.getString("cart_seller"));
				
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
			
		}
		return list;
	}
				
	
	//addCartUpdate 카트에 중복상품 있으면 수량 늘림
	public int addCartUpdate(int pnum, String id, int pqty ) {
		
		int result = 0;
		
		try {
			
			openConn();
			
			sql="update ks_cart set cart_pqty = cart_pqty + ? where cart_userId = ? "
					+ " and cart_pnum = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pqty);
			pstmt.setString(2, id);
			pstmt.setInt(3, pnum);
			
			result= pstmt.executeUpdate();
				
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
	
		
		
		return result;
	}
	
	public int deleteCart(int no) {
		
		int result = 0;
		
		try {
			openConn();
			
			sql="delete from ks_cart where cart_num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
			sql = "update ks_cart set cart_num = cart_num - 1 where cart_no > ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
		
		
	}
	
	public int checkedBoxDelete(int[] arr) {
		
		int res = 0;
		
		try {
			
			openConn();
			
			for(int i=0; i<arr.length; i++) {
				
				sql = "delete from ks_cart where cart_num = ?";
			
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, arr[i]);
				
				res = pstmt.executeUpdate();
				
				sql = "update ks_cart set cart_num = cart_num - 1 where cart_no > ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, arr[i]);
				
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
	
		
		
		return res;
	}//checkedBoxDelete() end
	
	//ajax로 넘어온 장바구니 제품 수량을 변경하는 메소드
	public int changeCartQty(int qty, int cartNum, String id) {
		
		int result = 0;
		
		try {
			openConn();
			
			//주문 수량과 재고를 비교하기 위한 sql문
			sql = "select p.pqty, c.cart_pqty "
					+ " from ks_cart c join ks_product p on c.cart_pnum = p.pno "
					+ " where c.cart_userId = ? and c.cart_num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, cartNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int pqty = rs.getInt("pqty");	//현재 상품 재고 수량
				
				if(qty <= 0){  //새로 담은 수량이 0이하라면
					
					result = 0;
				
				}else if(qty <= pqty) { //새로 담은 수량보다 재고수량보다 크거나 같으면 (판매가능)
					
					sql = "update ks_cart set cart_pqty = ? where cart_num = ? and cart_userId = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, qty);
					pstmt.setInt(2, cartNum);
					pstmt.setString(3, id);
					
					result = pstmt.executeUpdate();
					
					
				}else {
					//재고가 부족할경우 -1 반환
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
	}//changeCartQty() end
	
	//장바구니에서 결제하기 위해 넘어온 카트 넘버를 이용해 리스트 정보 반환
	public List<CartDTO> orderInfo(int[] num){
		
		List<CartDTO> list = new ArrayList<CartDTO>();
		
		openConn();
		
		try {
			
			for(int i=0; i<num.length; i++) {
				
				sql="select * from ks_cart where cart_num = ?"
						+ " order by cart_num desc";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num[i]);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					CartDTO dto = new CartDTO();
					
					dto.setCart_num(rs.getInt("cart_num"));
					dto.setCart_pnum(rs.getInt("cart_pnum"));
					dto.setCart_userId(rs.getString("cart_userId"));
					dto.setCart_pname(rs.getString("cart_pname"));
					dto.setCart_pqty(rs.getInt("cart_pqty"));
					dto.setCart_price(rs.getInt("cart_price"));
					dto.setCart_pspec(rs.getString("cart_pspec"));
					dto.setCart_pimage(rs.getString("cart_pimage"));
					dto.setCart_seller(rs.getNString("cart_seller"));
					
					list.add(dto);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}
	
	
	// 회원이 산 물건을 저장하는 메서드
	public int getInsertCart(CartDTO dto) {
		
		int result = 0, count = 0;
		
		try {

			openConn();
			
			sql = "select max(cart_num) from ks_cart";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			sql = "insert into set ks_cart values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setInt(2, dto.getCart_pnum());
			pstmt.setString(3, dto.getCart_userId());
			pstmt.setString(4, dto.getCart_pname());
			pstmt.setInt(5, dto.getCart_pqty());
			pstmt.setInt(6, dto.getCart_price());
			pstmt.setString(7, dto.getCart_pspec());
			pstmt.setString(8, dto.getCart_pimage());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
		
	} // getInsertCart() 메서드 end
	
	
	// 아이디와 번호에 맞는 정보를 보여주는 메서드
	public List<CartDTO> getCartPayList(String id, int no){
		
		List<CartDTO> list = new ArrayList<CartDTO>();
		
		try {

			openConn();
			
			sql = "select * from ks_cart where cart_userid = ? and cart_pnum = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				
				dto.setCart_num(rs.getInt("cart_num"));
				dto.setCart_pnum(rs.getInt("cart_pnum"));
				dto.setCart_userId(rs.getString("cart_userId"));
				dto.setCart_pname(rs.getString("cart_pname"));
				dto.setCart_pqty(rs.getInt("cart_pqty"));
				dto.setCart_price(rs.getInt("cart_price"));
				dto.setCart_pspec(rs.getString("cart_pspec"));
				dto.setCart_pimage(rs.getString("cart_pimage"));
				dto.setCart_seller(rs.getString("cart_seller"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
		
	} // getCartPayList() 메서드 end
	
}
