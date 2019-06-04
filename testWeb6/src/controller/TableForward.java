package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TableDAO;
import DB.DBConnection;

@WebServlet("/TableForward")
public class TableForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TableForward() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("sessionadmin") != null) {
		Connection conn = DBConnection.createConnection();
		TableDAO.getListMember(conn);
		request.setAttribute("members", TableDAO.members);
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/listMember.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("LoginForward");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
