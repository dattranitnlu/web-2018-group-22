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
import DAO.ChangePassDAO;
import DB.DBConnection;

@WebServlet("/ChangePassController")
public class ChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePassController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection conn = DBConnection.createConnection();

		Member member;
		if (session.getAttribute("sessionadmin") != null)
			member = (Member) session.getAttribute("sessionadmin");
		else
			member = (Member) session.getAttribute("sessionuser");

		String memberpass = request.getParameter("memberpass");
		String newmemberpass = request.getParameter("newmemberpass");
		String retypememberpass = request.getParameter("retypememberpass");
		if (memberpass.equals(newmemberpass)) {
			request.setAttribute("msgchangepass", "Old and new passwords must be different");
		} else {
			if (newmemberpass.length() < 6) {
				request.setAttribute("msgchangepass", "New password must be more than 6 characters");
			} else {
				if (!retypememberpass.equals(newmemberpass)) {
					request.setAttribute("msgchangepass", "Passwords do not match");
				} else {
					if (!member.getMemberpass().equals(memberpass)) {
						request.setAttribute("msgchangepass", "Wrong old password");
					} else {
						boolean test = ChangePassDAO.changePass(request, conn, member, newmemberpass);
						if (test) {
							request.setAttribute("msgchangepass", "Change password successful");
						} else
							request.setAttribute("msgchangepass", "Change password failed");
					}
				}
			}
		}
		member.setMemberpass(newmemberpass);
		if (session.getAttribute("sessionadmin") != null) {
			session.setAttribute("sessionadmin", member);
			RequestDispatcher rd = request.getRequestDispatcher("AdminForward");
			rd.forward(request, response);
		} else {
			session.setAttribute("sessionuser", member);
			RequestDispatcher rd = request.getRequestDispatcher("UserForward");
			rd.forward(request, response);
		}
	}

}
