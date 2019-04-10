package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Annonce;
import models.Categorie;
import models.Etat;
import models.Intervenant;
import models.Produit;

public class Requetes_Contoller {

Connection conn;
	
	public Requetes_Contoller(Connection conn) {
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
	public ObservableList getAllAnnonces() {
		ArrayList<Produit> list = new ArrayList<>();
		 
		String query = "SELECT * FROM ANONCE";
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
		String query = "SET SEARCH_PATH TO ESSAI";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.execute();		
			ps.close();						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
