package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginForward")
public class LoginForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginForward() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();
		if (session.getAttribute("sessionadmin") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminForward");
			rd.forward(request, response);
		} else {
			if (session.getAttribute("sessionuser") != null) {
				RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("View/login.jsp");
				rd.forward(request, response);
				
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
