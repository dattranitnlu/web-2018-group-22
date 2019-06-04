package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.VocabularyContent;
import DAO.VocabularyContentDAO;
import DB.DBConnection;

@WebServlet("/EditVocabularyContentController")
public class EditVocabularyContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditVocabularyContentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		int vocabularycontentid = Integer.parseInt(request.getParameter("vocabularycontentid"));
		String vocabularycontentname = request.getParameter("vocabularycontentname");
		String transcribe = request.getParameter("transcribe");
		String mean = request.getParameter("mean");

		Connection conn = DBConnection.createConnection();

		VocabularyContent vocabularyContent = new VocabularyContent();
		vocabularyContent.setVocabularycontentid(vocabularycontentid);
		vocabularyContent.setVocabularycontentname(vocabularycontentname);
		vocabularyContent.setTranscribe(transcribe);
		vocabularyContent.setMean(mean);

		boolean test = VocabularyContentDAO.editVocabularyContent(request, conn, vocabularyContent);
		if (test) {
			request.setAttribute("msgVocabularyContent", "Update successful");

		} else {
			request.setAttribute("msgVocabularyContent", "Update failed");

		}

		RequestDispatcher rd = request.getRequestDispatcher("ListVocabularyContentForward");
		rd.forward(request, response);
	}

}
