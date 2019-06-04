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

import BEAN.Examination;
import BEAN.ExaminationQuestion;
import DAO.ExaminationDAO;
import DB.DBConnection;

/**
 * Servlet implementation class ExaminationQuestionForward
 */
@WebServlet("/ExaminationQuestionForward")
public class ExaminationQuestionForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExaminationQuestionForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.createConnection();
		int index = Integer.parseInt(request.getParameter("index"));
		request.setAttribute("index", index);
		
		int pageid = Integer.parseInt(request.getParameter("pageid"));
		request.setAttribute("pageid", pageid);
		
		Examination examination = ExaminationDAO.examinations.get(index);
		String examinationname = examination.getExaminationname();
		int examinationid = examination.getExaminationid();
		
		List<ExaminationQuestion> list;
		if(pageid==0) {
		list = ExaminationDAO.getListExaminationQuetion(request, conn, examinationid);
		}else{
			list = ExaminationDAO.examinationQuestions;
		}
		request.setAttribute("title", examinationname);
		request.setAttribute("listexaminationquestion", list);
		
		int maxpage= list.size() -1;
		request.setAttribute("maxpage", maxpage);

		request.setAttribute("examinationquestion", list.get(pageid));
		
		RequestDispatcher rd = request.getRequestDispatcher("View/examinationquestion.jsp");
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
