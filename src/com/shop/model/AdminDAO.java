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

public class AdminDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	private static AdminDAO instance = null;

	private AdminDAO() {
	}

	public static AdminDAO getInstance() {

		if (instance == null) {
			instance = new AdminDAO();
		}
		return instance;
	}

	public void openConn() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

	}

	public List<UserDTO> getUserList() { // 전체 사용자를 리스트로 출력하는 메소드
		List<UserDTO> list = new ArrayList<UserDTO>();
		try {
			openConn();
			sql = "select * from shop_user order by user_level desc,user_no";
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

	public List<UserDTO> getConsumerList() {// 전체 소비자를 리스트로 출력하는 메소드
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

	public List<UserDTO> getSellerList() {// 전체 판매자를 리스트로 출력하는 메소드
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

	public List<UserDTO> getApproveList() {// 가입승인을 기다리는 판매자를 리스트로 출력하는 메소드
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

	public UserDTO getUserContent(int no) { // 클릭한 소비자의 정보를 출력하기 위한 메소드
		UserDTO dto = new UserDTO();

		try {
			openConn();
			sql = "select *from shop_user where user_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
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

	public int updateUser(UserDTO dto) {// 사용자의 마일리지를 변경하는 메서드
		int result = 0;

		try {
			openConn();
			sql = "select*from shop_user where user_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getUser_no());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sql = "update shop_user set user_mileage=? where user_no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dto.getUser_mileage());
				pstmt.setInt(2, dto.getUser_no());
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return result;
	}

	public int deleteuser(int num) {// 리스트에서 사용자를 지우는 메서드
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

	public int approve(int num) { // 보류중인 판매자를 가입 승인하는 메서드
		int result = 0;
		try {
			openConn();
			sql = "update shop_user set user_level=1 where user_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return result;
	}

}
