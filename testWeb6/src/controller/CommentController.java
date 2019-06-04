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
import DAO.CommentDAO;
import DB.DBConnection;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentController() {
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
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn = DBConnection.createConnection();
		String page = request.getParameter("page");
		int userid = Integer.parseInt(request.getParameter("userid"));
		int id = Integer.parseInt(request.getParameter("id"));
		String cmtcontent = request.getParameter("cmtcontent");
		CommentDAO.insertComment(request, conn, userid, id, cmtcontent,page);
		
		List<Comment> cmts = CommentDAO.getListComment(request, conn, id, page);
		request.setAttribute("listcomment", cmts);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/listcomment.jsp");
		rd.forward(request, response);
	}

}
