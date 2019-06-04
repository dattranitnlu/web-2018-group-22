package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GrammarGuidelineDAO;
import DB.DBConnection;

@WebServlet("/AddImageController")
public class AddImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddImageController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int grammarGuidelineID = Integer.parseInt(request.getParameter("grammarguidelineid"));
		Connection conn = DBConnection.createConnection();
		GrammarGuidelineDAO.uploadSingleFile(conn, request, response, grammarGuidelineID);
	}
}