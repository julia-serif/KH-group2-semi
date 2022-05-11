package com.shop.model;

import java.sql.Connection;
<<<<<<< HEAD

=======
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
<<<<<<< HEAD

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	private static UserDAO instance = null;

	private UserDAO() {
	}

	public static UserDAO getInstance() {

		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;

	} // getInstance() 메서드 end

	public void openConn() {

		try {
			// 1단계 : JNDI 서버 객체 생성
			Context ctx = new InitialContext();

			// 2단계 : lookup() 메서드를 이용하여 매칭되는 커넥션을 찾는다.
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle");

			// 3단계 : DataSource 객체를 이용하여 커넥션 객체를 하나 가져온다.
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // openConn() 메서드 end

	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con) {

		try {
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // closeConn() 메서드 end

	public int signup(UserDTO dto) { //회원가입 메소드
		int result = 0, count = 0;
		try {
			openConn();
			sql = "select max(user_no) from shop_user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1) + 1;
			}
			sql="select user_id,user_phone, user_email from shop_user";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String id=rs.getString(1);
				String phone=rs.getString(2);
				String email=rs.getString(3);
				//회원가입 데이터중에 테이블의 유티크 컬럼에 중복이 발생하는 경우
				if(id.equals(dto.getUser_id())) {//아이디가 중복이면 -1;
					result=-1;
					break;
				}else if (phone.equals(dto.getUser_phone())) {//폰번호가 중복이면 -2;
					result=-2;
					break;
				}else if(email.equals(dto.getUser_email())) {//이메일이 중복이면 -3;
					result=-3;
					break;
				}	
			}
			if(dto.getUser_id().equals("")||
				dto.getUser_pwd().equals("")||
				dto.getUser_name().equals("")||
				dto.getUser_email().equals("")||
				dto.getUser_addr().equals("")||
				dto.getUser_age()==-100
				){
				result=-4;//회원가입 폼에 빈칸이 존재하는 경우 -4;
			}
					
			if(result==0) {// 정상 가입
			sql = "insert into shop_user " + " values(?, ?, ?, ?, ?, ?, ?, ?,default,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getUser_id());
			pstmt.setString(3, dto.getUser_pwd());
			pstmt.setString(4, dto.getUser_name());
			System.out.println(dto.getUser_age());
			pstmt.setInt(5, dto.getUser_age());
			pstmt.setString(6, dto.getUser_phone());
			pstmt.setString(7, dto.getUser_email());
			pstmt.setString(8, dto.getUser_addr());
			pstmt.setString(9, dto.getUser_grade());
			if (dto.getUser_grade().equals("판매자")) {
				pstmt.setInt(10, 0);
			} else {
				pstmt.setInt(10, 1);
			}
			result = pstmt.executeUpdate();
			}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return result;
	}

	// 입력한 데이터의 아이디와 비밀번호가 DB 상에 존재 하는지 검사 로그인 
	public int userCheck(String id, String pwd) {
		int result = 0;
		try {
			openConn();
			System.out.println("@@@@@@@@@@@@" + id + "" + pwd);
			sql = "select * from shop_user where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (pwd.equals(rs.getString("user_pwd"))) {
					// 회원인 경우
					result = 1;
				} else {
					// 비밀번호가 틀린 경우
					result = -1;
				}
			}
=======
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
	//UserDAO 객체를 싱글턴 방식으로 만들어 보자.
		// 1단계 : 싱글톤 방식으로 객체를 만들기 위해서는 우선적으로 
		//       기본생성자의 접근 제어자를 public에서  private로 바꿔 주어야한다.
		//       외부에서 접근하지 못하도록 하기 위함.(외부에서 접근하면 객체가 무수히 생성되어 메모리에 불리)
		
	// 2단계 : UserDAO 객체를 정적 멤버로 선언해 주어야 한다. - static으로 선언해야함
	private static UserDAO instance;    //instance는 참조변수
	
	private UserDAO() { }
	
	// 3단계 : 기본 생성자 대신 싱글톤 객체를 return 해주는 getInstance() 라는 메소드를 만들어
	//       getInstance() 메소드에 외부에서 접근할 수 있게 해줘야 함.
	public static UserDAO getInstance() {
		
		if(instance == null) {
			instance = new UserDAO();
		}
		
		return instance;    //UserDAO 객체의 주소값 반환
		
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
	
	//회원인지 확인
	public int userCheck(String id, String pwd) {
		
		int result = 0;
		try {
			
			openConn();
			
			sql = "select * from shop_user where user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("user_pwd"))) {
					//회원인 경우
					result = 1;
				}else {
					//비밀번호가 틀린경우, 아이디는 있음
					result = -1;
				}
			}
			
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return result;
<<<<<<< HEAD
	}
	
	public String Overlap(String id) {//회원가입 창에서 아이디가 DB의 데이터와 중복되는지 검사하는 메소드
		String result="사용 가능합니다.";
		try {
			openConn();
			sql="select*from shop_user where user_id =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {// true인 경우 중복인 경우
				result="해당 아이디는 중복된 아이디입니다.";
=======
	}//userCheck() end

	//id에 해당하는 회원의 정보를 조회하는 메소드
	public UserDTO getMember(String id) {
		
		UserDTO dto = new UserDTO();
		
		
		try {
			openConn();
			
			sql = "select * from shop_user where user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_addr(rs.getString("user_addr"));
				dto.setUser_phone(rs.getString("user_phone"));
				dto.setUser_mileage(rs.getInt("user_mileage"));
				dto.setUser_age(rs.getInt("user_age"));
				dto.setUser_grade(rs.getString("user_grade"));
				dto.setUser_no(rs.getInt("user_no"));
				dto.setUser_level(rs.getInt("user_level"));
				dto.setRegdate(rs.getString("regdate"));
				
>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
<<<<<<< HEAD
		if(id=="") {
			result="아이디를 입력해주세요";
			}
		return result;
	}
	
	public UserDTO getuser(String id) {
		UserDTO dto = new UserDTO();
		try {
			openConn();
			sql = "select * from shop_user where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setUser_no(rs.getInt("user_no"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_age(rs.getInt("user_age"));
				dto.setUser_phone(rs.getString("user_phone"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_addr(rs.getString("user_addr"));
				dto.setUser_mileage(rs.getInt("user_mileage"));
				dto.setUser_grade(rs.getString("user_grade"));
				dto.setUser_level(rs.getInt("user_level"));
				dto.setUser_date(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return dto;
	}
	public List<UserDTO> getUserList() {
		List<UserDTO> list = new ArrayList<UserDTO>();

		try {
			openConn();
			sql = "select * from shop_user order by user_no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setUser_no(rs.getInt("user_no"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_age(rs.getInt("user_age"));
				dto.setUser_phone(rs.getString("user_phone"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_addr(rs.getString("user_addr"));
				dto.setUser_mileage(rs.getInt("user_mileage"));
				dto.setUser_grade(rs.getString("user_grade"));
				dto.setUser_level(rs.getInt("user_level"));
				dto.setUser_date(rs.getString("regdate"));
				list.add(dto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
}
=======
		return dto;
		
	}//getMember() end

}

>>>>>>> 1b549eeb6af7162fe16915cfdaf85c32a38f1eaf
