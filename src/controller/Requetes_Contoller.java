package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Annonce;
import models.Categorie;
import models.Displayed_Annonce;
import models.Etat;
import models.Intervenant;
import models.Produit;

public class Requetes_Contoller {

Connection conn;
	
	public Requetes_Contoller(Connection conn) {
		this.conn = conn;
	}
	
	
	

	/**
	 * Selectionner tous les produis
	 * @return
	 */
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
			}
			ps.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ObservableList data = FXCollections.observableList(list);
		return data;
	}
	/**
	 * Selectionner toutes les annonces
	 * @return
	 */
//	public ObservableList getAllAnnonces() {
//		ArrayList<Produit> list = new ArrayList<>();
//		 
//		String query = "SELECT * FROM ANONCE";
//		try {
//			PreparedStatement ps = conn.prepareStatement(query);			
//			ps.execute();
//			ResultSet rs = ps.getResultSet();
//			while(rs.next()) {
//				Produit p = new Produit();
//				p.setNom(new SimpleStringProperty(rs.getString("NOM")));
//				p.setDescription(new SimpleStringProperty(rs.getString("description")));
//				p.setPrix(new SimpleFloatProperty(rs.getFloat("prix")));
//				p.setLongueur(new SimpleFloatProperty(rs.getFloat("longueur")));
//				p.setLargeur(new SimpleFloatProperty(rs.getFloat("largeur")));
//				p.setProfondeur(new SimpleFloatProperty(rs.getFloat("profondeur")));
//				p.setCategorie(new SimpleStringProperty(rs.getString("categorie")));
//				p.setEtat(new SimpleStringProperty(rs.getString("etat")));				
//				list.add(p);	
//			}
//			ps.close();
//						
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}	
//		ObservableList data = FXCollections.observableList(list);
//		return data;
//	}
//	
	/**
	 * Selectionner toutes les categories
	 * @return
	 */
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
	/**
	 * Selectionner les nom est les ids des intervensnts
	 * @return
	 */
	public ArrayList<String> getIntervenantsName() {
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
			}
			ps.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	;
		return list;
	}
	
	/**
	 * Selectionner tous les etats
	 * @return
	 */
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
	
	public ObservableList getAllAnnonces(){
		ArrayList<Displayed_Annonce> list = new ArrayList<>();
		 
		String query = "WITH RQ1 AS (SELECT INTERVENANT.ID AS INTERV_ID, VILLE, PROVINCE, PAYS, NUM_TEL FROM "
				+ "INTERVENANT JOIN ADRESSE ON (ADRESSE.ID = INTERVENANT.ADRESSE_ID ))," 
				+ "RQ2 AS(SELECT ANNONCE.ID AS ANNONCE_ID, VENDEUR_ID, PRODUIT.ID, NOM, "
				+ "PRODUIT.DESCRIPTION AS DESCRIP, PRIX, PRIX_ESTIME, TAILLE, LONGUEUR, LARGEUR, PROFONDEUR, CATEGORIE, ETAT," 
				+ "DATE_PUB, TITRE, FINALISEE FROM ANNONCE JOIN PRODUIT ON (PROD_ID = PRODUIT.ID))" 
				+ "SELECT ANNONCE_ID, NOM, DESCRIP, PRIX, PRIX_ESTIME,TAILLE, LONGUEUR, LARGEUR, PROFONDEUR, CATEGORIE, ETAT,"  
				+ "DATE_PUB, TITRE, VILLE, PROVINCE, PAYS, NUM_TEL, FINALISEE FROM RQ1 JOIN RQ2 ON (VENDEUR_ID = INTERV_ID)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Displayed_Annonce da = new Displayed_Annonce();
				da.setAnnonce_id(new SimpleIntegerProperty(rs.getInt("ANNONCE_ID")));
				da.setProduit_nom(new SimpleStringProperty(rs.getString("NOM")));
				da.setAnnonce_description(new SimpleStringProperty(rs.getString("DESCRIP")));
				da.setPrix(new SimpleFloatProperty(rs.getFloat("PRIX")));
				da.setTaille(new SimpleFloatProperty(rs.getFloat("TAILLE")));
				da.setLongueur(new SimpleFloatProperty(rs.getFloat("LONGUEUR")));
				da.setLargeur(new SimpleFloatProperty(rs.getFloat("LARGEUR")));
				da.setProfondeur(new SimpleFloatProperty(rs.getFloat("PROFONDEUR")));
				da.setProduit_categorie(new SimpleStringProperty(rs.getString("CATEGORIE")));
				da.setEtat(new SimpleStringProperty(rs.getString("ETAT").trim()));	
				da.setAdresse(new SimpleStringProperty(rs.getString("VILLE").trim() +", "  + rs.getString("PROVINCE").trim() +", " + rs.getString("PAYS").trim()));
				da.setTitre(new SimpleStringProperty(rs.getString("TITRE")));
				da.setDate_pub(new SimpleStringProperty(rs.getString("DATE_PUB")));
				da.setDate_pub(new SimpleStringProperty(rs.getString("NUM_TEL")));
				da.setFinalisee(new SimpleBooleanProperty(rs.getBoolean("FINALISEE")));
				list.add(da);	
			}
			ps.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ObservableList data = FXCollections.observableList(list);
		return data;
	}
	
	
	/**
	 * Chercher produit par categorie
	 * @return
	 */
	public ObservableList getAllProductsByCat(String cat) {
		ArrayList<Produit> list = new ArrayList<>();
		 
		String query = "SELECT * FROM PRODUIT WHERE CATEGORIE LIKE '%" + cat + "%'";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Produit p = new Produit();
				p.setNom(new SimpleStringProperty(rs.getString("nom")));
				p.setDescription(new SimpleStringProperty(rs.getString("description")));
				p.setPrix(new SimpleFloatProperty(rs.getFloat("prix")));
				p.setLongueur(new SimpleFloatProperty(rs.getFloat("longueur")));
				p.setLargeur(new SimpleFloatProperty(rs.getFloat("largeur")));
				p.setProfondeur(new SimpleFloatProperty(rs.getFloat("profondeur")));
				p.setCategorie(new SimpleStringProperty(rs.getString("categorie")));
				p.setEtat(new SimpleStringProperty(rs.getString("etat")));				
				list.add(p);	
			}
			ps.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ObservableList data = FXCollections.observableList(list);
		return data;
	}
	
	/**
	 * Chercher produit par nom
	 * @return
	 */
	public ObservableList getAllProductsByName(String nom) {
		ArrayList<Produit> list = new ArrayList<>();
		 
		String query = "SELECT * FROM PRODUIT WHERE NOM LIKE '%" + nom + "%'";
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
			}
			ps.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ObservableList data = FXCollections.observableList(list);
		return data;
	}
	
	public void mettreAJourAnnonce(float prix, int acheteur_id, int annonce_id){
		
		String query = "UPDATE ANNONCE SET ACHETEUR_ID = "+ acheteur_id +", PRIX_ACHETEUR = " 
		+ prix + ", CONCLUE = TRUE" + " WHERE ID =" + annonce_id;
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute(); 			
			ps.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void setSearchPath(Connection conn) {
		String query = "SET SEARCH_PATH TO PROJECT";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();		
			ps.close();						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insert(Annonce a, Produit p) {
		String query1 = "INSERT INTO PRODUIT (NOM, DESCRIPTION, PRIX,LONGUEUR, "
				+ "LARGEUR, PROFONDEUR, MARQUE, CATEGORIE, ETAT, TAILLE) VALUES (?,?,?,?,?,?,?,?,?,?)";
		String query2 = "INSERT INTO ANNONCE (PROD_ID, VENDEUR_ID, TITRE, "
				+ "DESCRIPTION, PRIX_ESTIME, DATE_PUB) VALUES (?,?,?,?,?,?)";

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
			ps.setFloat(10, p.getTaille());
			
			ps.executeUpdate();
			ps.close();
			ps = conn.prepareStatement(query2);
			ps.setInt(1, getLastIndex());
			ps.setInt(2, a.getVendeur_id());
			ps.setString(3, a.getTitre());
			ps.setString(4, a.getDescription());
			ps.setFloat(5, a.getPrix());
			ps.setString(6, a.getDate_p());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
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
