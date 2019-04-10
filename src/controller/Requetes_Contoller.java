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
import models.Categorie;
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
}
