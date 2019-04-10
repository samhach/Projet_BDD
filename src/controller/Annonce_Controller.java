package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Annonce;
import models.Categorie;
import models.Produit;

public class Annonce_Controller {

Connection conn;
	
	public Annonce_Controller(Connection conn) {
		this.conn = conn;
	}
	
	
	public void insert(Annonce a, Produit p) {
		String query1 = "INSERT INTO PRODUIT (NOM, DESCRIPTION, PRIX, LONGUEUR, "
				+ "LARGEUR, PROFONDEUR, MARQUE, CATEGORIE, ETAT, ID) VALUES (?,?,?,?,?,?,?,?,?,?)";
		String query2 = "INSERT INTO ANNONCE (ID, PROD_ID, ACHETEUR_ID, VENDEUR_ID, TITRE, "
				+ "DESCRIPTION, PRIX_ESTIME, DATE_PUB, DATE_VENTE) VALUES (?,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getDescription());
			ps.setFloat(3, p.getPrix());
			ps.setFloat(4, p.getLongueur());
			ps.setFloat(5, p.getLargeur());
			ps.setFloat(6, p.getProfondeur());
			ps.setString(7, p.getMarque());
			ps.setString(8, p.getCategorie().toString());
			ps.setString(9, p.getEtat().toString());
			ps.setInt(10, p.getId());
			ps.executeUpdate();
			ps.close();
			
			ps = conn.prepareStatement(query2);
			ps.setInt(1, a.getId());
			ps.setInt(2, getLastIndex());
			ps.setInt(3, a.getId());
			ps.setInt(4, a.getId());
			ps.setString(5, a.getTitre());
			ps.setString(6, a.getDescription());
			ps.setFloat(7, a.getPrix());
			ps.setString(8, a.getDate_p());
			ps.setString(9, a.getDate_v());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
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
