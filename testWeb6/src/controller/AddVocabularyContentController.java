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

@WebServlet("/AddVocabularyContentController")
public class AddVocabularyContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddVocabularyContentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}

		String vocabularycontentname = request.getParameter("vocabularycontentname");
		String transcribe = request.getParameter("transcribe");
		String mean = request.getParameter("mean");
		int vocabularyguidelineid = Integer.parseInt(request.getParameter("vocabularyguidelineid"));
		
		Connection conn = DBConnection.createConnection();

		VocabularyContent vocabularyContent = new VocabularyContent();
		vocabularyContent.setVocabularycontentname(vocabularycontentname);
		vocabularyContent.setTranscribe(transcribe);
		vocabularyContent.setMean(mean);
		vocabularyContent.setVocabularyguidelineid(vocabularyguidelineid);

		boolean test = VocabularyContentDAO.addVocabularyContent(request, conn, vocabularyContent);
		if (test) {
			request.setAttribute("msgVocabularyContent", "Adding the topic successfully");
		} else {
			request.setAttribute("msgVocabularyContent", "Can't add the topic. Pleasse try again");
			
		}
		
		request.setAttribute("vocabularyguidelineid", vocabularyguidelineid);
		request.setAttribute("vocabularyContent", vocabularyContent);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListVocabularyContentForward");
		rd.forward(request, response);
	}

}
