package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.GrammarGuideline;

public class GrammarGuidelineDAO {

	public static List<GrammarGuideline> grammarGuidelines;

	public static List<GrammarGuideline> getListGrammar(HttpServletRequest request, Connection conn) {
		grammarGuidelines = new ArrayList<GrammarGuideline>();
		PreparedStatement ptmt = null;
		String sql = "select * from grammarguideline";
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					GrammarGuideline grammarGuideline = new GrammarGuideline();

					int grammarGuidelineId = rs.getInt(1);
					String grammarGuidelineName = rs.getString(2);
					String grammarImage = rs.getString(3);
					String content = rs.getString(4);

					grammarGuideline.setGrammarguidelineid(grammarGuidelineId);
					grammarGuideline.setGrammarname(grammarGuidelineName);
					grammarGuideline.setGrammarimage(grammarImage);
					grammarGuideline.setContent(content);

					grammarGuidelines.add(grammarGuideline);
				}
			} else {
				request.setAttribute("msgListGrammarGuideline", "Not found data of grammar");
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgListGrammarGuideline", e.getMessage());
		}

		return grammarGuidelines;
	}

	public static boolean addGrammarGuideline(HttpServletRequest request, Connection conn,
			GrammarGuideline grammarGuideline) {
		PreparedStatement ptmt = null;
		String sql = "insert into grammarguideline(grammarname,content) value(?,?) where not exists (select grammarname from grammarguideline where grammarname = ?) LIMIT 1";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			String grammarname = grammarGuideline.getGrammarname();
			String content = grammarGuideline.getContent();

			ptmt.setString(1, grammarname);
			ptmt.setString(2, content);
			ptmt.setString(3, grammarname);

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgGrammarGuideline", e.getMessage());
		}
		return false;
	}

	public static boolean removeGrammarGuideline(HttpServletRequest request, Connection conn, int grammarguidelineid) {
		PreparedStatement ptmt = null;
		String sql = "delete from grammarguideline where grammarguidelineid = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setInt(1, grammarguidelineid);
			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgGrammarGuideline", e.getMessage());
		}
		return false;
	}

	// them ten file image vao CSDL
	public static boolean addGrammarImage(HttpServletRequest request, Connection conn, String imageName,
			int grammarguidelineID) {
		PreparedStatement ptmt = null;
		String sql = "UPDATE grammarguideline SET grammarimage = ? WHERE grammarguidelineid = " + grammarguidelineID;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setString(1, imageName);

			// ptmt.setString(3, grammarGuideline.getGrammarname());

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgListGrammarGuideline", e.getMessage());
		}
		return false;

	}

	// Them hinh anh vao folder
	public static void uploadSingleFile(Connection conn, HttpServletRequest request, HttpServletResponse response,
			int grammarGuidelineId) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		final String address = context.getRealPath("/Images/Grammar");
		final int maxMemmorySize = 1024 * 1024 * 3;
		final int maxRequestSize = 1024 * 1024 * 50;

		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

		if (!isMultiPart) {
			request.setAttribute("msgGrammarGuidelineImage", "Khong co multipart/form-data");

		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(maxMemmorySize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// Set factory constraints
		factory.setSizeThreshold(maxRequestSize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraints
		upload.setSizeMax(maxRequestSize);

		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);

			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();

			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (!item.isFormField()) {
					String fileName = item.getName();

					// pathFile : vi tri ma chung muon upload file vao server
					String pathFile = address + File.separator + fileName;

					File uploadedFile = new File(pathFile);
					boolean test = uploadedFile.exists();

					try {
						if (test) {
							request.setAttribute("msgGrammarGuidelineImage", "File exist. Input again, please");
						} else {
							item.write(uploadedFile);
							fileName = "Images/Grammar/" + fileName;
							GrammarGuidelineDAO.addGrammarImage(request, conn, fileName, grammarGuidelineId);
							request.setAttribute("msgListGrammarGuideline", "Upload successfully");

							RequestDispatcher requestDispatcher = request
									.getRequestDispatcher("ListGrammarGuidelineForward");
							requestDispatcher.forward(request, response);
//								response.sendRedirect("ListGrammarGuidelineForward");
						}
					} catch (Exception e) {
						request.setAttribute("msgGrammarGuidelineImage", e.getMessage());
					}
				} else {
					request.setAttribute("msgGrammarGuidelineImage", "upload failed");
				}
			}
		} catch (FileUploadException e) {
			request.setAttribute("msgGrammarGuidelineImage", e.getMessage());
		}

		request.setAttribute("grammarguidelineid", grammarGuidelineId);
		RequestDispatcher rd = request.getRequestDispatcher("ListGrammarGuidelineForward");
		rd.forward(request, response);
	}

	// Xuat id cua bai huong dan ngu phap

	public static int retrieveGrammarGuideline(HttpServletRequest request, Connection conn,
			GrammarGuideline grammarGuideline) {
		int grammarGuidelineID = 0;

		PreparedStatement ptmt = null;
		String sql = "select grammarguidelineid from grammarguideline where grammarname='"
				+ grammarGuideline.getGrammarname() + "' and grammarguidelineid='"
				+ grammarGuideline.getGrammarguidelineid() + "'";

		try {
			ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				grammarGuidelineID = rs.getInt("grammarguidelineid");

			}

			ptmt.close();
			rs.close();

		} catch (SQLException e) {
			request.setAttribute("msgGrammarGuidelineImage", e.getMessage());

		}

		return grammarGuidelineID;
	}

	public static int getRow(HttpServletRequest request, Connection conn) {
		PreparedStatement ptmt = null;
		String sql = "select count(*) from grammarguideline";
		ResultSet rs = null;
		int res = 0;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {

					res = rs.getInt(1);
				}
			} else {
				request.setAttribute("msgListGrammarGuideline", "Not found data of grammar");
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgListGrammarGuideline", e.getMessage());
		}

		return res;
	}

	public static List<GrammarGuideline> getPageGrammar(HttpServletRequest request, Connection conn, int pageid,
			int count) {
		grammarGuidelines = new ArrayList<GrammarGuideline>();
		PreparedStatement ptmt = null;
		int start = count * pageid - count;
		String sql = "select * from grammarguideline limit " + start + ", " + count;
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					GrammarGuideline grammarGuideline = new GrammarGuideline();

					int grammarGuidelineId = rs.getInt(1);
					String grammarGuidelineName = rs.getString(2);
					String grammarImage = rs.getString(3);
					String content = rs.getString(4);

					grammarGuideline.setGrammarguidelineid(grammarGuidelineId);
					grammarGuideline.setGrammarname(grammarGuidelineName);
					grammarGuideline.setGrammarimage(grammarImage);
					grammarGuideline.setContent(content);

					grammarGuidelines.add(grammarGuideline);
				}
			} else {
				request.setAttribute("msgListGrammarGuideline", "Not found data of grammar");
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgListGrammarGuideline", e.getMessage());
		}

		return grammarGuidelines;
	}

}
