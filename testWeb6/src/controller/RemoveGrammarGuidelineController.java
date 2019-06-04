package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GrammarGuidelineDAO;
import DB.DBConnection;

@WebServlet("/RemoveGrammarGuidelineController")
public class RemoveGrammarGuidelineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveGrammarGuidelineController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int grammarguidelineid = Integer.parseInt(request.getParameter("grammarguidelineid"));
		Connection conn = DBConnection.createConnection();
		boolean test = GrammarGuidelineDAO.removeGrammarGuideline(request, conn, grammarguidelineid);
		if(test) {
			request.setAttribute("msgGrammarGuideline", "Delete successfully");
		}else {
			request.setAttribute("msgGrammarGuideline", "Delete failed");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListGrammarGuidelineForward");
		requestDispatcher.forward(request, response);
	}

}
