package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class ChangePassDAO {
	public static boolean changePass(HttpServletRequest request, Connection conn, Member member,String newmemberpass) {
		PreparedStatement ptmt = null;
		String sql = "UPDATE member SET memberpass = ? WHERE memberid = ? and membername = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			
			ptmt.setString(1, newmemberpass);
			ptmt.setInt(2, member.getMemberid());
			ptmt.setString(3, member.getMembername());

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgadmin", e.getMessage());
		}
		return false;
	}
}
