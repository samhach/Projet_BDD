package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Intervenant;

public class Intervenant_controller implements Serializable {
	
Connection conn;
	
	public Intervenant_controller(Connection conn) {
		this.conn = conn;
	}
	
	
	public ArrayList<String> getAllIntervenant() {
		ArrayList<String> list = new ArrayList<>();
		 
		String query = "SELECT ID, NOM FROM INTERVENANT";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Intervenant i = new Intervenant();
				i.setNom(new SimpleStringProperty(rs.getString("NOM")));
				
				list.add( rs.getInt("ID") + "-" + rs.getString("NOM"));	
				System.out.println(rs.getString("NOM"));
			}
			ps.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	;
		return list;
	}
	
}
