package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.GrammarGuideline;
import DAO.GrammarGuidelineDAO;
import DB.DBConnection;

@WebServlet("/ListGrammarGuidelineForward")
public class ListGrammarGuidelineForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListGrammarGuidelineForward() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection conn = DBConnection.createConnection();
			List<GrammarGuideline> list = GrammarGuidelineDAO.getListGrammar(request, conn);
			request.setAttribute("listGrammarGuideline", list);
			conn.close();
		} catch (SQLException e) {
			request.setAttribute("msgListGrammarGuideline", e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/listGrammarGuideline.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
