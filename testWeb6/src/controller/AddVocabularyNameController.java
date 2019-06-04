package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.VocabularyGuideline;
import DAO.VocabularyDAO;
import DB.DBConnection;



@WebServlet("/AddVocabularyNameController")
public class AddVocabularyNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddVocabularyNameController() {
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

		String vocabularyguidelinename = request.getParameter("vocabularyguidelinename");

		Connection conn = DBConnection.createConnection();

		VocabularyGuideline vocabularyguideline = new VocabularyGuideline();
		vocabularyguideline.setVocabularyguidelinename(vocabularyguidelinename);

		boolean test = VocabularyDAO.addVocabularyName(request, conn, vocabularyguideline);
		if (!test) {
			request.setAttribute("msgVocabulary", "Can't add the topic. Pleasse try again");
		} else {
			
			request.setAttribute("msgVocabulary", "Adding the topic successfully");
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ListVocabularyTopicForward");
		rd.forward(request, response);
	}
}
