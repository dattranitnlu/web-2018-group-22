package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import DAO.ChangeAvatarDAO;
import DB.DBConnection;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ChangeAvatarController
 */
@WebServlet("/ChangeAvatarController")
public class ChangeAvatarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeAvatarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadFolder = getServletContext().getRealPath("/Images");
		HttpSession session = request.getSession();
		Member member;
		if (session.getAttribute("sessionadmin") != null)
			member = (Member) session.getAttribute("sessionadmin");
		else
			member = (Member) session.getAttribute("sessionuser");
		String newmemberimage = "";
		Connection conn = DBConnection.createConnection();

		boolean uploadCompleted = false;
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				if (multiparts.size() == 1) {
					label: for (FileItem fileItem : multiparts) {
						if (!fileItem.isFormField()) {
							newmemberimage = new File(fileItem.getName()).getName();
							for (int i = newmemberimage.length() - 1; i > -1; i--) {
								if (newmemberimage.charAt(i) == '.') {
									String s = newmemberimage.substring(i);
									if (s.equals(".png") || s.equals(".PNG") || s.equals(".JPG") || s.equals(".jpg")) {
										newmemberimage = member.getMembername() + newmemberimage.substring(i);
									} else {
										request.setAttribute("msgchangeavater", "Wrong image format");
										break label;
									}
									break;
								}
							}
							File a = new File(uploadFolder);
							if (!a.exists())
								a.mkdir();
							if (!member.getMemberimage().equals("Images/default.png")) {
								File f = new File(getServletContext().getRealPath("/" + member.getMemberimage()));
								System.out.println(f.getAbsolutePath());
								f.delete();
							}
							fileItem.write(new File(uploadFolder + "/" + newmemberimage));
							newmemberimage = "Images/" + newmemberimage;
							uploadCompleted = true;

						}
					}
				}
			} catch (Exception e) {
				request.setAttribute("msgchangeavater", "Change your avatar failed" + e);
			}
		} else {
			request.setAttribute("msgchangeavater", "Change of your avatar is not complete");
		}
		if (uploadCompleted) {
			member.setMemberimage(newmemberimage);
			boolean test = ChangeAvatarDAO.changeAvatar(request, conn, member);
			if (test) {
				request.setAttribute("msgchangeavater", "Change your avatar successful ");
			} else
				request.setAttribute("msgchangeavater", "change your avatar failed");
		}
		if (session.getAttribute("sessionadmin") != null) {
			request.setAttribute("sessionadmin", member);
			RequestDispatcher rd = request.getRequestDispatcher("AdminForward");
			rd.forward(request, response);
		} else {
			request.setAttribute("sessionuser", member);
			System.out.println(request.getAttribute("msgchangeavatar"));
			RequestDispatcher rd = request.getRequestDispatcher("UserForward");
			rd.forward(request, response);

		}
	}
}
