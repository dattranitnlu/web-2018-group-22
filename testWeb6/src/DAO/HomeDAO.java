package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BEAN.Sliderbanner;

public class HomeDAO {
	public static List<Sliderbanner> displaySliderbanner(Connection conn) {

		List<Sliderbanner> list = new ArrayList<Sliderbanner>();
		String sql = "select * from slidebanner";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				Sliderbanner slide = new Sliderbanner();

				String slidename = rs.getString("slidename");
				String slidecontent = rs.getString("slidecontent");
				String slideimage = rs.getString("slideimage");

				slide.setSlidename(slidename);
				slide.setSlidecontent(slidecontent);
				slide.setSlideimage(slideimage);

				list.add(slide);
			}

		} catch (Exception ex) {

		}

		return list;

	}

}
