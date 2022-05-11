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

public class UserDAO {

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

	public List<UserDTO> getUserList() {
		List<UserDTO> list = new ArrayList<UserDTO>();

		try {
			openConn();
			sql = "select * from shop_user";
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

	public int signup(UserDTO dto) {
		int result = 0, count = 0;
		try {
			openConn();
			sql = "select max(user_no) from shop_user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1) + 1;
			}
			sql = "insert into shop_user " + " values(?, ?, ?, ?, ?, ?, ?, ?,default,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getUser_id());
			pstmt.setString(3, dto.getUser_pwd());
			pstmt.setString(4, dto.getUser_name());
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

		} catch (SQLException e) {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return result;
	}
	public String Overlap(String id) {
		String result="사용 가능합니다.";
		try {
			openConn();
			sql="select*from shop_user where id =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {// true인 경우 중복인 경우
				result="중복입니다.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
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

	public List<UserDTO> getSellerList() {
		List<UserDTO> list = new ArrayList<UserDTO>();

		try {
			openConn();
			sql = "select * from shop_user where user_grade='판매자' and user_level=1 ";
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

	public List<UserDTO> getConsumerList() {
		List<UserDTO> list = new ArrayList<UserDTO>();

		try {
			openConn();
			sql = "select * from shop_user where user_grade='구매자'";
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

	public List<UserDTO> getApproveList() {
		List<UserDTO> list = new ArrayList<UserDTO>();

		try {
			openConn();
			sql = "select * from shop_user where user_grade='판매자' and user_level=0 ";
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

	public int approve(int num) {
		int result = 0;
		try {
			openConn();
			sql = "update shop_user set user_level=1 where user_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			System.out.println("@@@@@@1");
			result = pstmt.executeUpdate();
			System.out.println("@@@@@@2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return result;
	}

	public int deleteuser(int num) {
		int result = 0;

		try {
			openConn();

			sql = "delete from shop_user where user_no = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);

			result = pstmt.executeUpdate();

			sql = "update shop_user set user_no = user_no - 1 where user_no > ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return result;
	}
}
