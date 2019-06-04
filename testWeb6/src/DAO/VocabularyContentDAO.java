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

import BEAN.VocabularyContent;
import DB.DBConnection;

public class VocabularyContentDAO {
	public static List<VocabularyContent> vocabularyContentList;

	public static void getVocabularyContent(VocabularyContent vocabularyContent) {
		Connection conn = DBConnection.createConnection();
		vocabularyContentList = new ArrayList<VocabularyContent>();

		PreparedStatement ptmt = null;
		String sql = "select * from vocabularycontent where vocabularyguidelineid=? order by vocabularycontentname ASC";
		ResultSet rs = null;

		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, vocabularyContent.getVocabularyguidelineid());
			rs = ptmt.executeQuery();

			while (rs.next()) {
				VocabularyContent content = new VocabularyContent();

				content.setVocabularycontentid(rs.getInt(1));
				content.setVocabularycontentname(rs.getString(2));
				content.setTranscribe(rs.getString(3));
				content.setAudiomp3(rs.getString(4));
				content.setMean(rs.getString(5));
				content.setVocabularyguidelineid(rs.getInt(6));
				content.setVocabularyimage(rs.getString(7));

				vocabularyContentList.add(content);
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Thêm từ mới cho một chủ đề nào đó
	public static boolean addVocabularyContent(HttpServletRequest request, Connection conn,
			VocabularyContent vocabularyContent) {
		PreparedStatement ptmt = null;
		String sql = "insert into vocabularycontent(vocabularycontentname,transcribe,mean,vocabularyguidelineid) value(?,?,?,?)";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			String vocabularycontentname = vocabularyContent.getVocabularycontentname();
			String transcribe = vocabularyContent.getTranscribe();
			String mean = vocabularyContent.getMean();
			int vocabularyguidelineid = vocabularyContent.getVocabularyguidelineid();

			ptmt.setString(1, vocabularycontentname);
			ptmt.setString(2, transcribe);
			ptmt.setString(3, mean);
			ptmt.setInt(4, vocabularyguidelineid);

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabularyContent", e.getMessage());
		}
		return false;
	}

	// Phương thức xóa Vocabulary content
	public static boolean removeVocabularyContent(HttpServletRequest request, Connection conn,
			int vocabularycontentid) {
		PreparedStatement ptmt = null;
		String sql = "delete from vocabularycontent where vocabularycontentid = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setInt(1, vocabularycontentid);
			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabularyContent", e.getMessage());
		}
		return false;
	}

	// Sửa một từ vừng nào đó trong chủ đề
	public static boolean editVocabularyContent(HttpServletRequest request, Connection conn,
			VocabularyContent vocabularyContent) {
		PreparedStatement ptmt = null;
		String sql = "UPDATE vocabularycontent SET vocabularycontentname = ?,transcribe = ?, mean = ? WHERE vocabularycontentid = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setString(1, vocabularyContent.getVocabularycontentname());
			ptmt.setString(2, vocabularyContent.getTranscribe());
			ptmt.setString(3, vocabularyContent.getMean());
			ptmt.setInt(4, vocabularyContent.getVocabularycontentid());

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabularyContent", e.getMessage());
		}
		return false;
	}

	public static boolean addVocabularyImage(HttpServletRequest request, Connection conn, String imageName,
			int vocabularyContentID) {
		PreparedStatement ptmt = null;
		String sql = "UPDATE vocabularycontent SET vocabularyimage = ? WHERE vocabularycontentid = "
				+ vocabularyContentID;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setString(1, imageName);

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabularyContent", e.getMessage());
		}
		return false;

	}

	// Thêm hình ảnh vào folder
	public static void uploadSingleFile(Connection conn, HttpServletRequest request, HttpServletResponse response,
			VocabularyContent vocabularyContent) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		final String address = context.getRealPath("/Images/VocabularyContent");
		final int maxMemmorySize = 1024 * 1024 * 3;
		final int maxRequestSize = 1024 * 1024 * 50;

		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

		if (!isMultiPart) {
			request.setAttribute("msgVocabularyContent", "Khong co multipart/form-data");

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
							request.setAttribute("msgVocabularyContent", "File exist. Input again, please");
						} else {
							item.write(uploadedFile);
							fileName = "Images/VocabularyContent/" + fileName;
							VocabularyContentDAO.addVocabularyImage(request, conn, fileName,
									vocabularyContent.getVocabularycontentid());
							request.setAttribute("msgVocabularyContent", "Upload successfully");

						}
					} catch (Exception e) {
						request.setAttribute("msgVocabularyContent", e.getMessage());
					}
				} else {
					request.setAttribute("msgVocabularyContent", "upload failed");
				}
			}
		} catch (FileUploadException e) {
			request.setAttribute("msgVocabularyContent", e.getMessage());
		}

		request.setAttribute("vocabularyguidelineid", vocabularyContent.getVocabularyguidelineid());

		RequestDispatcher rd = request.getRequestDispatcher("ListVocabularyContentForward");
		rd.forward(request, response);

	}

	// Thêm audio cho từng từ vựng vào folder
	public static void uploadSingleAudio(Connection conn, HttpServletRequest request, HttpServletResponse response,
			VocabularyContent vocabularyContent) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		final String address = context.getRealPath("/Audio");
		final int maxMemmorySize = 1024 * 1024 * 3;
		final int maxRequestSize = 1024 * 1024 * 50;

		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

		if (!isMultiPart) {
			request.setAttribute("msgVocabularyContent", "Khong co multipart/form-data");

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
							request.setAttribute("msgVocabularyContent", "File exist. Input again, please");
						} else {
							item.write(uploadedFile);
							fileName = "Audio/" + fileName;
							VocabularyContentDAO.addVocabularyImage(request, conn, fileName,
									vocabularyContent.getVocabularycontentid());
							request.setAttribute("msgVocabularyContent", "Upload successfully");

						}
					} catch (Exception e) {
						request.setAttribute("msgVocabularyContent", e.getMessage());
					}
				} else {
					request.setAttribute("msgVocabularyContent", "upload failed");
				}
			}
		} catch (FileUploadException e) {
			request.setAttribute("msgVocabularyContent", e.getMessage());
		}

		request.setAttribute("vocabularyguidelineid", vocabularyContent.getVocabularyguidelineid());

		RequestDispatcher rd = request.getRequestDispatcher("ListVocabularyContentForward");
		rd.forward(request, response);

	}
}
