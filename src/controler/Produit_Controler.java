package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Produit;

public class Produit_Controler {

	Connection conn;
	
	public Produit_Controler(Connection conn) {
		this.conn = conn;
	}
	
	
	public void insert(Produit p) {
		String query = "INSERT INTO PRODUIT (NOM, DESCRIPTION, PRIX, LONGUEUR, "
				+ "LARGEUR, PROFONDEUR, MARQUE, CATEGORIE, ETAT) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getDescription());
			ps.setFloat(3, p.getPrix());
			ps.setFloat(4, p.getLongueur());
			ps.setFloat(5, p.getLargeur());
			ps.setFloat(6, p.getProfondeur());
			ps.setString(7, p.getMarque());
			ps.setString(8, p.getCategorie().toString());
			ps.setString(9, p.getEtat().toString());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
