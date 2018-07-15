package com.telusko.RestCallsProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	Connection con = null;

	public AlienRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "root");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<>();
		String sql = "select*from alien";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				aliens.add(a);
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return aliens;

	}

	public Alien getAlien(int id) {

		
		String sql = "select*from alien where id=" + id;
		Alien a = new Alien();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return a;

	}

	public void createAlien(Alien a1) {

		String sql = "insert into alien values(?,?,?)";
	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			

			st.setInt(1,a1.getId());
			st.setString(2,a1.getName());
			st.setInt(3,a1.getPoints());
			st.executeUpdate();

			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
