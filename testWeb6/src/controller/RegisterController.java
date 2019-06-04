package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import BEAN.Member;
import DAO.RegisterDAO;
import DB.DBConnection;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}

		String fullname = request.getParameter("fullname");
		String membername = request.getParameter("membername");
		String memberpass = request.getParameter("memberpass");
		String retypememberpass = request.getParameter("retypememberpass");
		String memberimage = "Images/default.png";

		Connection conn = DBConnection.createConnection();

		if (memberpass.length() < 6) {
			request.setAttribute("msgregister", "Password must be more than 6 characters");
		} else {
			if (!memberpass.equals(retypememberpass)) {
				request.setAttribute("msgregister", "Passwords do not match");
			} else {

				Member member = new Member();
				member.setMembername(membername);
				member.setMemberpass(memberpass);
				member.setFullname(fullname);
				member.setMemberimage(memberimage);
				member.setMemberid(1);
				boolean test = RegisterDAO.checkMemberName(request, conn, member);

				if (!test) {
					request.setAttribute("msgregister", "Account name is taken");
				} else {
					test = RegisterDAO.insertAccount(request, conn, member);
					if (test) {
						request.setAttribute("msgregister", "Register successful");
					} else {
						request.setAttribute("msgregister", "Register failed");

					}
				}
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegisterForward");
		requestDispatcher.forward(request, response);

	}

}
