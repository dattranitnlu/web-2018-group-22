package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class RemoveUserDAO {
	public static boolean removeUser(HttpServletRequest request, Connection conn, int memberid) {
		PreparedStatement ptmt = null;
		String sql = "delete from member where memberid = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setInt(1, memberid);
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
