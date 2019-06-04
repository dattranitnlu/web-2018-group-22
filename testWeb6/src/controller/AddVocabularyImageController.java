package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.VocabularyGuideline;
import DAO.VocabularyDAO;
import DB.DBConnection;

@WebServlet("/AddVocabularyImageController")
public class AddVocabularyImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddVocabularyImageController() {
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
		String vocabularyguidelineimage = request.getParameter("vocabularyguidelineimage");
		int vocabularyguidelineid = Integer.parseInt(request.getParameter("vocabularyguidelineid"));

		VocabularyGuideline vocabularyGuideline = new VocabularyGuideline();
		vocabularyGuideline.setVocabularyguidelineid(vocabularyguidelineid);
		vocabularyGuideline.setVocabularyguidelineimage(vocabularyguidelineimage);

		Connection conn = DBConnection.createConnection();

		VocabularyDAO.uploadSingleFile(conn, request, response, vocabularyguidelineid);
		
	}

}
