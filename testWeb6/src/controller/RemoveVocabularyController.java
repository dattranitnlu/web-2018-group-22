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

import DAO.VocabularyDAO;
import DB.DBConnection;

@WebServlet("/RemoveVocabularyController")
public class RemoveVocabularyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveVocabularyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int vocabularyguidelineid = Integer.parseInt(request.getParameter("vocabularyguidelineid"));
		Connection conn = DBConnection.createConnection();
		boolean test = VocabularyDAO.removeVocabularyTopic(request, conn, vocabularyguidelineid);
		if (test) {
			
			request.setAttribute("msgVocabulary", "Remove success");
		} else {
			request.setAttribute("msgVocabulary", "Remove failed");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListVocabularyTopicForward");
		requestDispatcher.forward(request, response);
	}

}
