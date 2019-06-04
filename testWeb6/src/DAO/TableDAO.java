package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BEAN.Member;
import DB.DBConnection;

public class TableDAO {
	public static ArrayList<Member> members;
	static {
		Connection conn = DBConnection.createConnection();
		members = new ArrayList<Member>();
		PreparedStatement ptmt = null;
		String sql = "select * from member";
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			while(rs.next()) {
				Member member = new Member();
				member.setMemberid(rs.getInt(1));
				member.setMembername(rs.getString(2));
				member.setFullname(rs.getString(4));
				member.setCategorymemberid(rs.getInt(5));
				member.setMemberimage(rs.getString(6));
				
				members.add(member);
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getListMember(Connection conn){
		members = new ArrayList<Member>();
		PreparedStatement ptmt = null;
		String sql = "select * from member";
		ResultSet rs = null;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			while(rs.next()) {
				Member member = new Member();
				member.setMemberid(rs.getInt(1));
				member.setMembername(rs.getString(2));
				member.setFullname(rs.getString(4));
				member.setCategorymemberid(rs.getInt(5));
				member.setMemberimage(rs.getString(6));
				
				members.add(member);
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean removeUser(int memberid) {
		for(Member m : members) {
			if(m.getMemberid() == memberid) {
				members.remove(m);
				return true;
			}
		}
		return false;
	}
}
