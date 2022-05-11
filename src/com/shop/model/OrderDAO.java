package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
	//OrderDAO 객체를 싱글턴 방식으로 만들어 보자.
		// 1단계 : 싱글톤 방식으로 객체를 만들기 위해서는 우선적으로 
		//       기본생성자의 접근 제어자를 public에서  private로 바꿔 주어야한다.
		//       외부에서 접근하지 못하도록 하기 위함.(외부에서 접근하면 객체가 무수히 생성되어 메모리에 불리)
		
	// 2단계 : OrderDAO 객체를 정적 멤버로 선언해 주어야 한다. - static으로 선언해야함
	private static OrderDAO instance;    //instance는 참조변수
	
	private OrderDAO() { }
	
	// 3단계 : 기본 생성자 대신 싱글톤 객체를 return 해주는 getInstance() 라는 메소드를 만들어
	//       getInstance() 메소드에 외부에서 접근할 수 있게 해줘야 함.
	public static OrderDAO getInstance() {
		
		if(instance == null) {
			instance = new OrderDAO();
		}
		
		return instance;    //OrderDAO 객체의 주소값 반환
		
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
	
	public int saveOrderData(String email,String name,String userAddr,String phone,String id, 
							String nameAddr,String phoneAddr,String addr,int usePoint,
							int savePoint,int allTotalPrice ,
							int[] pnum,int[] pqty,int[] pPrice,String[] seller, String merchant_uid) {
			
		int result = 0, count = 0;
		
		try {
			openConn();
			
			sql="insert into ks_order values(?, ?, sysdate, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, merchant_uid);
			pstmt.setString(2, id);
			pstmt.setString(3, nameAddr);
			pstmt.setString(4, phoneAddr);
			pstmt.setString(5, addr);
			
			result = pstmt.executeUpdate();
			
			for(int i=0; i<pnum.length; i++) {
				
				
				sql = "select max(product_order_no) from ks_product_order";
				
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1) + 1;
				}
				
				sql ="insert into ks_product_order values(?, ?, ?, ?, ?, '', ?, ?)";
				System.out.println(count+"///"+merchant_uid+"///"+pnum[i]+"///"+pqty[i]+"///"+pPrice[i]+"///"+seller[i]);
				pstmt = con.prepareStatement(sql);
				
				
				pstmt.setInt(1, count);
				pstmt.setString(2, merchant_uid);
				pstmt.setInt(3, pnum[i]);
				pstmt.setInt(4, pqty[i]);
				pstmt.setInt(5, pPrice[i]);
				pstmt.setString(6, "주문완료");
				pstmt.setString(7, seller[i]);
				
				result = pstmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}
	
}
