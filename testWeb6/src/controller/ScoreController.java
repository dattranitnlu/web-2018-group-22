package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.ExaminationQuestion;
import DAO.ExaminationDAO;

/**
 * Servlet implementation class ScoreController
 */
@WebServlet("/ScoreController")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("View/listoption.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option").trim();
		int pageid = Integer.parseInt(request.getParameter("pageid"));
		
		ExaminationQuestion examinationQuestion = ExaminationDAO.examinationQuestions.get(pageid);
		String option1 = examinationQuestion.getOption1().trim();
		String option2 = examinationQuestion.getOption2().trim();
		String option3 = examinationQuestion.getOption3().trim();
		String option4 = examinationQuestion.getOption4().trim();
		String correctanswer = examinationQuestion.getCorrectanswer().trim();
		
		if(examinationQuestion.getImagequestion() == null && examinationQuestion.getParagraph() == null) {
			request.setAttribute("not4", "true");
		}
		
		request.setAttribute("examinationquestion", examinationQuestion);
		request.setAttribute("option1", option1);
		request.setAttribute("option2",option2);
		request.setAttribute("option3", option3);
		request.setAttribute("option4", option4);
		
		if(option.equals(correctanswer)) {
			if(option.equals(option1))
				request.setAttribute("correct1", "option1");
			if(option.equals(option2))
				request.setAttribute("correct2", "option2");
			if(option.equals(option3))
				request.setAttribute("correct3", "option3");
			if(option.equals(option4))
				request.setAttribute("correct4", "option4");
			
		}else {
			if(option.equals(option1))
				request.setAttribute("wrong1", "option1");
			if(option.equals(option2))
				request.setAttribute("wrong2", "option2");
			if(option.equals(option3))
				request.setAttribute("wrong3", "option3");
			if(option.equals(option4))
				request.setAttribute("wrong4", "option4");
			if(correctanswer.equals(option1))
				request.setAttribute("answer1", "option1");
			if(correctanswer.equals(option2))
				request.setAttribute("answer2", "option2");
			if(correctanswer.equals(option3))
				request.setAttribute("answer3", "option3");
			if(correctanswer.equals(option4))
				request.setAttribute("answer4", "option4");
		}
		RequestDispatcher rd = request.getRequestDispatcher("View/score.jsp");
		rd.forward(request, response);
	}

}
