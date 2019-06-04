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
import BEAN.GrammarGuideline;
import DAO.CommentDAO;
import DAO.GrammarGuidelineDAO;
import DB.DBConnection;

/**
 * Servlet implementation class GrammarForward
 */
@WebServlet("/GrammarForward")
public class GrammarForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrammarForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.createConnection();
		int index = Integer.parseInt(request.getParameter("index"));
		GrammarGuideline grammar = GrammarGuidelineDAO.grammarGuidelines.get(index);
		String grammarname = grammar.getGrammarname();
		String grammarcontent = grammar.getContent();
		
		int grammarid = grammar.getGrammarguidelineid();
		request.setAttribute("grammarid", grammarid);
		
		request.setAttribute("title", grammarname);
		request.setAttribute("content", grammarcontent);
		request.setAttribute("xuonghangdb", "\n");
		request.setAttribute("xuonghanghtml", "<br>");
		request.setAttribute("ketthucindamdb", "**\n");
		request.setAttribute("ketthucindamdb1", "**\r");
		request.setAttribute("ketthucindamhtml", "</b>\n");
		request.setAttribute("batdauindamdb", "**");
		request.setAttribute("batdauindamhtml", "<b>");
		
		List<Comment> cmts = CommentDAO.getListComment(request, conn, grammarid, "grammar");
		request.setAttribute("listcomment", cmts);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/grammar.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
