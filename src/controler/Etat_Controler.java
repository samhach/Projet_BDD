package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import models.Categorie;
import models.Etat;

public class Etat_Controler {

	Connection conn;
	FXCollections fxCollections ;
	public Etat_Controler(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<Etat> getEtat() {
		ArrayList<Etat> list = new ArrayList<>();
		String query = "SELECT * FROM ETAT";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				list.add(new Etat(rs.getString("ETAT")));
			}
			ps.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
}
