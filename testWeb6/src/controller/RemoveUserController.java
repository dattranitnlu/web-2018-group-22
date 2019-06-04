package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RemoveUserDAO;
import DAO.TableDAO;
import DB.DBConnection;

@WebServlet("/RemoveUserController")
public class RemoveUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int memberid = Integer.parseInt(request.getParameter("memberid"));
		Connection conn = DBConnection.createConnection();
		boolean test = RemoveUserDAO.removeUser(request, conn, memberid);
		if(test) {
			TableDAO.removeUser(memberid);
			request.setAttribute("msgtable", "Xóa thành công");
		}else {
			request.setAttribute("msgtable", "Xóa thất bại");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("TableForward");
		requestDispatcher.forward(request, response);
	}

}
