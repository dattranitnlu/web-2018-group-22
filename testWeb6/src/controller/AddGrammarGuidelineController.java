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

import BEAN.GrammarGuideline;
import DAO.GrammarGuidelineDAO;
import DB.DBConnection;

@WebServlet("/AddGrammarGuidelineController")
public class AddGrammarGuidelineController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddGrammarGuidelineController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		String grammarguidelinename = request.getParameter("grammarname");
		String content = request.getParameter("comment");

		GrammarGuideline grammarGuideline = new GrammarGuideline();
		grammarGuideline.setGrammarname(grammarguidelinename);
		grammarGuideline.setContent(content);

		Connection conn = DBConnection.createConnection();

		boolean test = GrammarGuidelineDAO.addGrammarGuideline(request, conn, grammarGuideline);

		if (test) {
			int grammarGuidelineID = GrammarGuidelineDAO.retrieveGrammarGuideline(request, conn, grammarGuideline);
			request.setAttribute("grammarguidelineid", grammarGuidelineID);
			
			request.setAttribute("msgGrammarGuideline", "Add grammar guideline successfully");
		} else {
			
			request.setAttribute("msgGrammarGuideline", "Add grammar guideline failed");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListGrammarGuidelineForward");
		requestDispatcher.forward(request, response);
	}

}
