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

import BEAN.GrammarGuideline;
import BEAN.VocabularyGuideline;
import DAO.SearchDAO;
import DB.DBConnection;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.createConnection();
		String type = request.getParameter("type");
		String search = request.getParameter("search");
		
		if(type.equals("grammar")) {

		List<GrammarGuideline> list = SearchDAO.DisplayGrammarResult(request, conn, search);
		request.setAttribute("listsearch", list);
		}else {
			List<VocabularyGuideline> list = SearchDAO.DisplayVocabularyResult(request, conn, search);
			request.setAttribute("listsearch", list);
		}
		request.setAttribute("type", type);	
		RequestDispatcher rd = request.getRequestDispatcher("View/result.jsp");
		rd.forward(request, response);
	}

}
