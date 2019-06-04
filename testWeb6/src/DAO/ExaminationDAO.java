package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BEAN.Examination;
import BEAN.ExaminationQuestion;

public class ExaminationDAO {
	
	public static List<Examination> examinations;
	public static List<ExaminationQuestion> examinationQuestions;
	
	
	public static List<Examination> getPageExamination(HttpServletRequest request, Connection conn,int pageid, int count) {
		examinations = new ArrayList<Examination>();
		PreparedStatement ptmt = null;
		int start = count * pageid -count;
		String sql = "select * from examination limit " + start + ", " + count;
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Examination examination = new Examination();

					int examinationid = rs.getInt(1);
					String examinationname = rs.getString(2);
					String examinationimage = rs.getString(3);

					examination.setExaminationid(examinationid);
					examination.setExaminationimage(examinationimage);
					examination.setExaminationname(examinationname);

					examinations.add(examination);
				}
			} else {
				request.setAttribute("msgExamination", "Not found data of grammar");
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgExamination", e.getMessage());
		}

		return examinations;
	}
	
	public static List<ExaminationQuestion> getListExaminationQuetion(HttpServletRequest request, Connection conn, int examinationid) {
		examinationQuestions = new ArrayList<ExaminationQuestion>();
		PreparedStatement ptmt = null;
		String sql = "select * from examinationquestion where examinationid = ?";
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, examinationid);
			rs = ptmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					ExaminationQuestion examinationQuestion = new ExaminationQuestion();
					
					examinationQuestion.setExaminationid(rs.getInt(1));
					examinationQuestion.setNum(rs.getInt(2));
					examinationQuestion.setImagequestion(rs.getString(3));
					examinationQuestion.setAudiomp3(rs.getString(5));
					examinationQuestion.setParagraph(rs.getString(6));
					examinationQuestion.setQuestion(rs.getString(7));
					examinationQuestion.setOption1(rs.getString(8));
					examinationQuestion.setOption2(rs.getString(9));
					examinationQuestion.setOption3(rs.getString(10));
					examinationQuestion.setOption4(rs.getString(11));
					examinationQuestion.setCorrectanswer(rs.getString(12));
					
					examinationQuestions.add(examinationQuestion);
				}
			} else {
				request.setAttribute("msgExaminationQuestion", "Not found data of grammar");
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgExaminationQuestion", e.getMessage());
		}

		return examinationQuestions;
	}
}
