package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.VocabularyContent;
import DAO.VocabularyContentDAO;
import DB.DBConnection;

@WebServlet("/EditVocabularyContentImageController")
public class EditVocabularyContentImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditVocabularyContentImageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("vocabularycontentid"));
		int vocabularycontentid = (Integer) session.getAttribute("vocabularycontentid");
		String vocabularyimage = request.getParameter("vocabularyimage");
		int vocabularyguidelineid = (Integer) session.getAttribute("vocabularyguidelineid");

		VocabularyContent vocabularyContent = new VocabularyContent();
		vocabularyContent.setVocabularycontentid(vocabularycontentid);
		vocabularyContent.setVocabularyimage(vocabularyimage);
		vocabularyContent.setVocabularyguidelineid(vocabularyguidelineid);

		Connection conn = DBConnection.createConnection();
		
		VocabularyContentDAO.uploadSingleFile(conn, request, response, vocabularyContent);
	}

}
