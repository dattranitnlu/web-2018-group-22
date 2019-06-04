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

import DAO.VocabularyContentDAO;
import DB.DBConnection;

@WebServlet("/RemoveVocabularyContentController")
public class RemoveVocabularyContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveVocabularyContentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int vocabularyguidelineid = Integer.parseInt(request.getParameter("vocabularyguidelineid"));
		int vocabularycontentid = Integer.parseInt(request.getParameter("vocabularycontentid"));
		Connection conn = DBConnection.createConnection();
		boolean test = VocabularyContentDAO.removeVocabularyContent(request, conn, vocabularycontentid);
		if (test) {

			request.setAttribute("msgVocabularyContent", "Remove success");
		} else {
			request.setAttribute("msgVocabularyContent", "Remove failed");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("vocabularyguidelineid", vocabularyguidelineid);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListVocabularyContentForward");
		requestDispatcher.forward(request, response);
	}

}
