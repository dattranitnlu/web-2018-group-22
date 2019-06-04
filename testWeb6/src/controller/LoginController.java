package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import DAO.LoginDAO;
import DB.DBConnection;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		
		Connection conn = (Connection) DBConnection.createConnection();
		String membername = request.getParameter("membername");
		String memberpass = request.getParameter("memberpass");
		
		Member member = new Member();
		member.setMembername(membername);
		member.setMemberpass(memberpass);
		
		boolean test = LoginDAO.checkLogin(request, conn, member);
		if(!test) {
			request.setAttribute("msglogin", "Account or password is incorrect");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginForward");
			requestDispatcher.forward(request, response);
		}else {
			int categorymemberid = member.getCategorymemberid();
			HttpSession session = request.getSession();
			if(categorymemberid == 1) {
				session.setAttribute("sessionuser", member);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomeForward");
				requestDispatcher.forward(request, response);
			}else {
				session.setAttribute("sessionadmin", member);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminForward");
				requestDispatcher.forward(request, response);
			}
		}
	}

}
