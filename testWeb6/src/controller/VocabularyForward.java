package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import BEAN.Comment;
import BEAN.Vocabulary;
import BEAN.VocabularyGuideline;
import DAO.CommentDAO;
import DAO.GrammarGuidelineDAO;
import DAO.VocabularyGuidelineDAO;
import DB.DBConnection;

@WebServlet("/VocabularyForward")
public class VocabularyForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VocabularyForward() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.createConnection();
		int index = Integer.parseInt(request.getParameter("index"));
		request.setAttribute("index", index);
		
		int row = GrammarGuidelineDAO.getRow(request, conn);
		int count = 2;
		
		int pageid = Integer.parseInt(request.getParameter("pageid"));
		request.setAttribute("pageid", pageid);
		
		VocabularyGuideline vocabularyGuideline = VocabularyGuidelineDAO.vocabularyGuidelines.get(index);
		
		String vocabularyguidelinename = vocabularyGuideline.getVocabularyguidelinename();
		int vocabularyguidelineid = vocabularyGuideline.getVocabularyguidelineid();
		request.setAttribute("vocabularyid", vocabularyguidelineid);
		
		List<Vocabulary> list = VocabularyGuidelineDAO.getVocabulary(request, conn, pageid, count, vocabularyguidelineid);
		
		request.setAttribute("title", vocabularyguidelinename);
		request.setAttribute("listvocabulary", list);
		
		
		if (row % count == 0)
			request.setAttribute("maxpage", row / count);
		else
			request.setAttribute("maxpage", row / count + 1);
		
		List<Comment> cmts = CommentDAO.getListComment(request, conn, vocabularyguidelineid, "vocabulary");
		request.setAttribute("listcomment", cmts);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("View/vocabulary.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
