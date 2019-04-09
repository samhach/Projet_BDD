package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Categorie;

public class Categorie_Controller {

	Connection conn;
	public Categorie_Controller(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<Categorie> getCategories() {
		ArrayList<Categorie> list = new ArrayList<>();
		String query = "SELECT * FROM CATEGORIE";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				list.add(new Categorie(rs.getString("CATEGORIE")));
			}
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
}
