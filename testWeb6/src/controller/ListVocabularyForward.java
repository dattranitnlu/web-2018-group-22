package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VocabularyDAO;

@WebServlet("/ListVocabularyForward")
public class ListVocabularyForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListVocabularyForward() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VocabularyDAO.getVocabularyTopic();
		request.setAttribute("vocabularies", VocabularyDAO.vocabularies);
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/listVocabulary.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
