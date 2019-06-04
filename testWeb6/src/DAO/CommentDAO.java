package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;

import BEAN.Comment;

public class CommentDAO {
	public static List<Comment> cmts;

	public static void insertComment(HttpServletRequest request, Connection conn, int userid, int id,
			String cmtcontent, String page) {
		PreparedStatement ptmt = null;
		String sql = "";
		if(page.equals("grammar"))
		sql= "INSERT INTO `group22project`.`cmtgrammar` (`cmtgrammarcontent`, `memberid`, `grammarguidelineid`) VALUES (?, ?, ?);";
		if(page.equals("vocabulary"))
			sql= "INSERT INTO `group22project`.`cmtvocabulary` (`cmtvocabularycontent`, `memberid`, `vocabularyguidelineid`) VALUES (?, ?, ?);";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			ptmt.setString(1, cmtcontent);
			ptmt.setInt(2, userid);
			ptmt.setInt(3, id);

			ptmt.executeUpdate();

			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgcomment", e.getMessage());
		}
	}

	public static List<Comment> getListComment(HttpServletRequest request, Connection conn, int id, String page) {
		cmts = new ArrayList<Comment>();
		PreparedStatement ptmt = null;
		String sql = "";
		if(page.equals("grammar"))
		sql = "select member.membername, member.memberimage, cmtgrammar.cmtgrammarcontent from member, cmtgrammar where member.memberid = cmtgrammar.memberid and cmtgrammar.grammarguidelineid = ?";
		if(page.equals("vocabulary"))
			sql = "select member.membername, member.memberimage, cmtvocabulary.cmtvocabularycontent from member, cmtvocabulary where member.memberid = cmtvocabulary.memberid and cmtvocabulary.vocabularyguidelineid = ?";
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String membername = rs.getString(1);
					String memberimage = rs.getString(2);
					String cmt = rs.getString(3);
					
					Comment comment = new Comment();
					comment.setCmtcontent(cmt);
					comment.setMemberimage(memberimage);
					comment.setMembername(membername);
					
					cmts.add(comment);
				}
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgListComment", e.getMessage());
		}

		return cmts;
	}
}
