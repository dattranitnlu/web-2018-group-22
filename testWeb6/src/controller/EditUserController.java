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
import DAO.EditUserDAO;
import DB.DBConnection;

@WebServlet("/EditUserController")
public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditUserController() {
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
		HttpSession session = request.getSession();
		String memberid = request.getParameter("memberid");
		String fullname = request.getParameter("fullname");
		String categorymemberid;
		if (session.getAttribute("sessionuser") != null)
			categorymemberid = 1 + "";
		else
			categorymemberid = request.getParameter("categorymemberid");

		Connection conn = DBConnection.createConnection();

		Member member = new Member();
		member.setCategorymemberid(Integer.parseInt(categorymemberid));
		member.setFullname(fullname);
		member.setMemberid(Integer.parseInt(memberid));

		Boolean test = EditUserDAO.editUser(request, conn, member);
		if (test) {
			request.setAttribute("msgtable", "Update successful");

		} else {
			request.setAttribute("msgtable", "Update failed");

		}
		if (session.getAttribute("sessionadmin") != null
				&& memberid.equals(((Member) session.getAttribute("sessionadmin")).getMemberid() + "")) {
			
			member = (Member) session.getAttribute("sessionadmin");
			member.setFullname(fullname);
			session.setAttribute("sessionadmin", member);
			RequestDispatcher rd = request.getRequestDispatcher("AdminForward");
			rd.forward(request, response);
		} else {
			if (session.getAttribute("sessionuser") != null) {
				member = (Member) session.getAttribute("sessionuser");
				member.setFullname(fullname);
				session.setAttribute("sessionuser", member);
				RequestDispatcher rd = request.getRequestDispatcher("UserForward");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("TableForward");
				rd.forward(request, response);

			}

		}
	}

}
