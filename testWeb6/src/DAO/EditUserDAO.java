package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class EditUserDAO {
	public static boolean editUser(HttpServletRequest request, Connection conn, Member member) {
		PreparedStatement ptmt = null;
		String sql = "UPDATE member SET fullname = ?,categorymemberid = ? WHERE memberid = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setString(1, member.getFullname());
			ptmt.setInt(2, member.getCategorymemberid());
			ptmt.setInt(3, member.getMemberid());

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgtable", e.getMessage());
		}
		return false;
	}
}
