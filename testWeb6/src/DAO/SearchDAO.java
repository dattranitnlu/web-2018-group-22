package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BEAN.GrammarGuideline;
import BEAN.VocabularyGuideline;

public class SearchDAO {
	
	public static List<GrammarGuideline> DisplayGrammarResult(HttpServletRequest request, Connection conn, String name) {
		List<GrammarGuideline> list = new ArrayList<GrammarGuideline>();
		PreparedStatement ptmt = null;
		String sql = "select * from grammarguideline where grammarname like '%" + name + "%'";
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

					list.add(grammarGuideline);
				}
				GrammarGuidelineDAO.grammarGuidelines = list;
			} else {
				request.setAttribute("result", "result not find out");

			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("result", e.getMessage());
		}
		return list;
	}
	
	public static List<VocabularyGuideline> DisplayVocabularyResult(HttpServletRequest request, Connection conn, String name) {
		List<VocabularyGuideline> list = new ArrayList<VocabularyGuideline>();
		PreparedStatement ptmt = null;
		String sql = "select * from vocabularyguideline where vocabularyguidelinename like '%" + name + "%'";
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

					list.add(vocabularyGuideline);
				}
				VocabularyDAO.vocabularyGuidelines = list;
			} else {
				request.setAttribute("result", "result not find out");

			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("result", e.getMessage());
		}
		return list;
	}
}
