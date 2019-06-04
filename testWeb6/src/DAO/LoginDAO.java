package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class LoginDAO {
	public static boolean checkLogin(HttpServletRequest request, Connection conn, Member member) {
		PreparedStatement ptmt = null;
		String sql = "select * from member where membername = ? and memberpass = ?";
		ResultSet rs = null;

		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setString(1, member.getMembername());
			ptmt.setString(2, member.getMemberpass());

			rs = ptmt.executeQuery();

			if (rs.next()) {
				member.setMemberid(rs.getInt(1));
				member.setFullname(rs.getString(4));
				member.setCategorymemberid(rs.getInt(5));
				member.setMemberimage(rs.getString(6));

				ptmt.close();
				rs.close();
				return true;
			}
			ptmt.close();
			rs.close();
		} catch (SQLException e) {
			request.setAttribute("msglogin", e.getMessage());
		}
		return false;
	}
}
