package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class RegisterDAO {
	public static boolean insertAccount(HttpServletRequest request, Connection conn, Member member) {
		PreparedStatement ptmt = null;
		String sql = "insert into member(membername, memberpass, fullname, categorymemberid, memberimage) value(?,?,?,?,?)";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			String membername = member.getMembername();
			String memberpass = member.getMemberpass();
			String fullname = member.getFullname();
			int categorymemberid = 1;
			String memberimage = member.getMemberimage();

			ptmt.setString(1, membername);
			ptmt.setString(2, memberpass);
			ptmt.setString(3, fullname);
			ptmt.setInt(4, categorymemberid);
			ptmt.setString(5, memberimage);

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgregister", e.getMessage());
		}
		return false;
	}

	public static boolean checkMemberName(HttpServletRequest request, Connection conn, Member member) {
		PreparedStatement ptmt = null;
		String sql = "select * from member where membername = ?";
		ResultSet rs = null;

		try {
			ptmt = conn.prepareStatement(sql);

			ptmt.setString(1, member.getMembername());
			rs = ptmt.executeQuery();

			if (rs.next()) {
				ptmt.close();
				rs.close();
				return false;
			}
			ptmt.close();
			rs.close();
		} catch (SQLException e) {
			request.setAttribute("msgregister", e.getMessage());
		}
		return true;
	}
}
