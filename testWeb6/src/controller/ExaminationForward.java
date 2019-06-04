package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Examination;
import DAO.ExaminationDAO;
import DAO.GrammarGuidelineDAO;
import DB.DBConnection;

/**
 * Servlet implementation class ExaminationForward
 */
@WebServlet("/ExaminationForward")
public class ExaminationForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExaminationForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.createConnection();

		int row = GrammarGuidelineDAO.getRow(request, conn);
		int count = 6;

		int pageid = Integer.parseInt(request.getParameter("pageid"));
		request.setAttribute("pageid", pageid);

		List<Examination> list = ExaminationDAO.getPageExamination(request, conn, pageid, count);

		request.setAttribute("listexam", list);

		if (row % count == 0)
			request.setAttribute("maxpage", row / count);
		else
			request.setAttribute("maxpage", row / count + 1);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/examination.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
