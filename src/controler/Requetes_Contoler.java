package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Produit;

public class Requetes_Contoler {

Connection conn;
	
	public Requetes_Contoler(Connection conn) {
		this.conn = conn;
	}
	
	
	public ObservableList getAllProducts() {
		ArrayList<Produit> list = new ArrayList<>();
		 
		String query = "SELECT * FROM PRODUIT";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Produit p = new Produit();
				p.setNom(new SimpleStringProperty(rs.getString("NOM")));
				p.setDescription(new SimpleStringProperty(rs.getString("description")));
				p.setPrix(new SimpleFloatProperty(rs.getFloat("prix")));
				p.setLongueur(new SimpleFloatProperty(rs.getFloat("longueur")));
				p.setLargeur(new SimpleFloatProperty(rs.getFloat("largeur")));
				p.setProfondeur(new SimpleFloatProperty(rs.getFloat("profondeur")));
				p.setCategorie(new SimpleStringProperty(rs.getString("categorie")));
				p.setEtat(new SimpleStringProperty(rs.getString("etat")));				
				list.add(p);	
				System.out.println(rs.getString("NOM"));
			}
			ps.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ObservableList data = FXCollections.observableList(list);
		return data;
	}
	
}
