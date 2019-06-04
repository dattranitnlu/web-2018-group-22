package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Member;
import DAO.RegisterDAO;
import DAO.TableDAO;
import DB.DBConnection;

@WebServlet("/AddUserController")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
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
		int categorymemberid = Integer.parseInt(request.getParameter("categorymemberid"));

		Connection conn = DBConnection.createConnection();

		if (memberpass.length() < 6) {
			request.setAttribute("msgtable", "Password must be more than 6 characters");
		} else {
			if (!memberpass.equals(retypememberpass)) {
				request.setAttribute("msgtable", "Passwords do not match");
			} else {

				Member member = new Member();
				member.setMembername(membername);
				member.setMemberpass(memberpass);
				member.setFullname(fullname);
				member.setMemberimage(memberimage);
				member.setMemberid(categorymemberid);
				boolean test = RegisterDAO.checkMemberName(request, conn, member);

				if (!test) {
					request.setAttribute("msgtable", "Account name is taken");
				} else {
					test = RegisterDAO.insertAccount(request, conn, member);
					if (test) {
						TableDAO.getListMember(conn);
						request.setAttribute("msgtable", "Register successful");
					} else {
						request.setAttribute("msgtable", "Register failed");

					}
				}
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("TableForward");
		requestDispatcher.forward(request, response);

	}

}
