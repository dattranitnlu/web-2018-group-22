package DB;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnection {
	public static Connection createConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://den1.mysql3.gear.host:3306/group22project?useUnicode=true&amp;characterEncoding=utf-8";
		String username = "group22project";
		String pass = "@Khang2608";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, username, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		Connection conn = createConnection();
		if (conn == null) {
			System.out.println("connection fail");
		} else {
			System.out.println("connection success");
		}
	}
}
