package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BEAN.Vocabulary;
import BEAN.VocabularyGuideline;

public class VocabularyGuidelineDAO {
	public static List<VocabularyGuideline> vocabularyGuidelines;
	public static List<Vocabulary> vocabularys;

	public static List<Vocabulary> getVocabulary(HttpServletRequest request, Connection conn, int pageid,
			int count, int vocabularyguidelineid) {
		vocabularys = new ArrayList<Vocabulary>();
		PreparedStatement ptmt = null;
		int start = count * pageid - count;
		String sql = "select * from vocabularycontent where vocabularyguidelineid = "+ vocabularyguidelineid + " limit " + start + ", " + count;
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Vocabulary vocabulary = new Vocabulary();

					int vocabularycontentid = rs.getInt(1);
					String vocabularycontentname = rs.getString(2);
					String transcribe = rs.getString(3);
					String audiomp3 = rs.getString(4);
					String mean = rs.getString(5);
					String vocabularyimage = rs.getString(7);

					vocabulary.setVocabularycontentid(vocabularycontentid);
					vocabulary.setVocabularycontentname(vocabularycontentname);
					vocabulary.setTranscribe(transcribe);
					vocabulary.setAudiomp3(audiomp3);
					vocabulary.setMean(mean);
					vocabulary.setVocabularyimage(vocabularyimage);

					vocabularys.add(vocabulary);
				}
			} else {
				request.setAttribute("msgVocabulary", "Not found data of vocabulary");
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabulary", e.getMessage());
		}

		return vocabularys;
	}
	
	public static List<VocabularyGuideline> getPageVocabulary(HttpServletRequest request, Connection conn, int pageid,
			int count) {
		vocabularyGuidelines = new ArrayList<VocabularyGuideline>();
		PreparedStatement ptmt = null;
		int start = count * pageid - count;
		String sql = "select * from vocabularyguideline limit " + start + ", " + count;
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					VocabularyGuideline vocabularyGuideline = new VocabularyGuideline();

					int vocabularyguidelineid = rs.getInt(1);
					String vocabularyguidelinename = rs.getString(2);
					String vocabularyguidelineimage = rs.getString(3);

					vocabularyGuideline.setVocabularyguidelineid(vocabularyguidelineid);
					vocabularyGuideline.setVocabularyguidelinename(vocabularyguidelinename);
					vocabularyGuideline.setVocabularyguidelineimage(vocabularyguidelineimage);

					vocabularyGuidelines.add(vocabularyGuideline);
				}
			} else {
				request.setAttribute("msgListVocabulary", "Not found data of grammar");
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgVocabulary", e.getMessage());
		}

		return vocabularyGuidelines;
	}
	
}
