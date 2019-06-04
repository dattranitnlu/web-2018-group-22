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

import BEAN.VocabularyGuideline;
import DAO.GrammarGuidelineDAO;
import DAO.VocabularyGuidelineDAO;
import DB.DBConnection;

@WebServlet("/ListVocabularyForward1")
public class ListVocabularyForward1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListVocabularyForward1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.createConnection();

		int row = GrammarGuidelineDAO.getRow(request, conn);
		int count = 6;

		int pageid = Integer.parseInt(request.getParameter("pageid"));
		request.setAttribute("pageid", pageid);

		List<VocabularyGuideline> list = VocabularyGuidelineDAO.getPageVocabulary(request, conn, pageid, count);

		request.setAttribute("listvocabulary", list);

		if (row % count == 0)
			request.setAttribute("maxpage", row / count);
		else
			request.setAttribute("maxpage", row / count + 1);
		
		System.out.println(request.getAttribute("maxpage"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/listvocabulary.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
