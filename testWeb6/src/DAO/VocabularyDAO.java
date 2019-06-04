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
import BEAN.VocabularyGuideline;
import DB.DBConnection;

public class VocabularyDAO {
	public static List<VocabularyGuideline> vocabularyGuidelines;
	public static List<VocabularyGuideline> vocabularies;
	
	public static void getVocabularyTopic() {
		Connection conn = DBConnection.createConnection();
		vocabularies = new ArrayList<VocabularyGuideline>();

		PreparedStatement ptmt = null;
		String sql = "select * from vocabularyguideline";
		ResultSet rs = null;

		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			while (rs.next()) {
				VocabularyGuideline vocabulary = new VocabularyGuideline();

				vocabulary.setVocabularyguidelineid(rs.getInt(1));
				vocabulary.setVocabularyguidelinename(rs.getString(2));
				vocabulary.setVocabularyguidelineimage(rs.getString(3));

				vocabularies.add(vocabulary);
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức xóa Vocabulary topic
	public static boolean removeVocabularyTopic(HttpServletRequest request, Connection conn,
			int vocabularyguidelineid) {
		PreparedStatement ptmt = null;
		String sql = "delete from vocabularyguideline where vocabularyguidelineid = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setInt(1, vocabularyguidelineid);
			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabulary", e.getMessage());
		}
		return false;
	}
	
	// Phương thức sửa Vocabulary topic
	public static boolean editVocabularyTopic(HttpServletRequest request, Connection conn,
			VocabularyGuideline vocabularyguideline) {
		PreparedStatement ptmt = null;
		String sql = "UPDATE vocabularyguideline SET vocabularyguidelinename = ? WHERE vocabularyguidelineid = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setString(1, vocabularyguideline.getVocabularyguidelinename());
			ptmt.setInt(2, vocabularyguideline.getVocabularyguidelineid());

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabulary", e.getMessage());
		}
		return false;
	}

	// Phương thức thêm Vocabulary topic name
	public static boolean addVocabularyName(HttpServletRequest request, Connection conn,
			VocabularyGuideline vocabularyguideline) {
		PreparedStatement ptmt = null;
		String sql = "insert into vocabularyguideline(vocabularyguidelinename, vocabularyguidelineid) value(?,?) ";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			String vocabularyguidelinename = vocabularyguideline.getVocabularyguidelinename();
			int vocabularyguidelineid = vocabularyguideline.getVocabularyguidelineid();

			ptmt.setString(1, vocabularyguidelinename);
			ptmt.setInt(2, vocabularyguidelineid);

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabulary", e.getMessage());
		}
		return false;
	}

	// Phương thức thêm Vocabulary topic content
	public static boolean addVocabularyContent(HttpServletRequest request, Connection conn,
			VocabularyContent vocabularyContent) {
		PreparedStatement ptmt = null;
		String sql = "insert into vocabularycontent(vocabularycontentname, transcribe, audiomp3, mean, vocabularyguidelineid, vocabularyimage) value(?,?,?,?,?,?)";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			String vocabularyguidelinename = vocabularyContent.getVocabularycontentname();
			String transcribe = vocabularyContent.getTranscribe();
			String audiomp3 = vocabularyContent.getAudiomp3();
			String mean = vocabularyContent.getMean();
			int vocabularyguidelineid = vocabularyContent.getVocabularyguidelineid();

			ptmt.setString(1, vocabularyguidelinename);
			ptmt.setString(2, transcribe);
			ptmt.setString(3, audiomp3);
			ptmt.setString(4, mean);
			ptmt.setInt(5, vocabularyguidelineid);
			ptmt.setString(6, "Images/default.png");

			int test = ptmt.executeUpdate();

			if (test != 0) {
				ptmt.close();
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabulary", e.getMessage());
		}
		return false;
	}

	// Phương thức thêm Vocabulary topic content
	// them ten file image vao CSDL
		public static boolean addVocabularyImage(HttpServletRequest request, Connection conn, String imageName,
				int vocabularyGuidelineID) {
			PreparedStatement ptmt = null;
			String sql = "UPDATE vocabularyguideline SET vocabularyguidelineimage = ? WHERE vocabularyguidelineid = " + vocabularyGuidelineID;
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
				request.setAttribute("msgVocabulary", e.getMessage());
			}
			return false;

		}
	
	
//Xuất id cua Vocabulary Guideline
	public static int retrieveVocabularyGuideline(HttpServletRequest request, Connection conn,
			VocabularyGuideline vocabularyGuideline) {
		int vocabularyGuidelineID = 0;

		PreparedStatement ptmt = null;
		String sql = "select vocabularyguidelineid from vocabularyguideline where vocabularyguidelinename='"
				+ vocabularyGuideline.getVocabularyguidelinename() + "' and vocabularyguidelineid='"
				+ vocabularyGuideline.getVocabularyguidelineid() + "'";

		try {
			ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				vocabularyGuidelineID = rs.getInt("vocabularyguidelineid");

			}

			ptmt.close();
			rs.close();

		} catch (SQLException e) {
			request.setAttribute("msgVocabulary", e.getMessage());

		}

		return vocabularyGuidelineID;
	}
	
	// Them hinh anh Vocabulary vao folder
		public static void uploadSingleFile(Connection conn, HttpServletRequest request, HttpServletResponse response,
				int vocabularyGuidelineID) throws ServletException, IOException {
			ServletContext context = request.getServletContext();
			final String address = context.getRealPath("/Images/Vocabulary");
			final int maxMemmorySize = 1024 * 1024 * 3;
			final int maxRequestSize = 1024 * 1024 * 50;

			boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

			if (!isMultiPart) {
				request.setAttribute("msgVocabulary", "Khong co multipart/form-data");

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
								request.setAttribute("msgVocabulary", "File exist. Input again, please");
							} else {
								item.write(uploadedFile);
								fileName = "Images/Vocabulary/" + fileName;
								VocabularyDAO.addVocabularyImage(request, conn, fileName, vocabularyGuidelineID);
								request.setAttribute("msgVocabulary", "Upload successfully");

							}
						} catch (Exception e) {
							request.setAttribute("msgVocabulary", e.getMessage());
						}
					} else {
						request.setAttribute("msgVocabulary", "upload failed");
					}
				}
			} catch (FileUploadException e) {
				request.setAttribute("msgVocabulary", e.getMessage());
			}

			request.setAttribute("vocabularyGuidelineID", vocabularyGuidelineID);
			RequestDispatcher rd = request.getRequestDispatcher("ListVocabularyTopicForward");
			rd.forward(request, response);
		}

}
