package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Produit;

public class Produit_Controller {

	Connection conn;
	
	public Produit_Controller(Connection conn) {
		this.conn = conn;
	}
	
	public int getLastIndex() {
		int index = 0;
		String query = "SELECT ID FROM PRODUIT ORDER BY ID DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();
			ResultSet rs = ps.getResultSet();
			if(rs.next())
			index = rs.getInt("ID");
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return index;
	}
}
