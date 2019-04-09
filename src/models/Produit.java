package models;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produit {
	private IntegerProperty id =         new SimpleIntegerProperty();
	private StringProperty     nom = new SimpleStringProperty();
	private StringProperty description = new SimpleStringProperty();
	private StringProperty categorie = new SimpleStringProperty();
	private FloatProperty prix = new SimpleFloatProperty();
	private FloatProperty longueur = new SimpleFloatProperty();
	private FloatProperty largeur = new SimpleFloatProperty();
	private FloatProperty profondeur = new SimpleFloatProperty();
	private StringProperty marque = new SimpleStringProperty();
	private StringProperty etat = new SimpleStringProperty();
	
	public Produit(StringProperty nom, StringProperty description, FloatProperty prix, FloatProperty longueur, FloatProperty largeur,
			FloatProperty profondeur, StringProperty marque, StringProperty categorie, StringProperty etat) {
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.prix = prix;
		this.longueur = longueur;
		this.largeur = largeur;
		this.profondeur = profondeur;
		this.marque = marque;
		this.etat = etat;
	}
	public Produit() {

	}
	public String getNom() {
		return nom.get();
	}
	public void setNom(StringProperty nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(StringProperty description) {
		this.description = description;
	}
	public String getCategorie() {
		return categorie.get();
	}
	public void setCategorie(StringProperty categorie) {
		this.categorie = categorie;
	}
	public float getPrix() {
		return prix.floatValue();
	}
	public void setPrix(FloatProperty prix) {
		this.prix = prix;
	}
	public float getLongueur() {
		return longueur.floatValue();
	}
	public void setLongueur(FloatProperty longueur) {
		this.longueur = longueur;
	}
	public float getLargeur() {
		return largeur.floatValue();
	}
	public void setLargeur(FloatProperty largeur) {
		this.largeur = largeur;
	}
	public float getProfondeur() {
		return profondeur.floatValue();
	}
	public void setProfondeur(FloatProperty profondeur) {
		this.profondeur = profondeur;
	}
	public String getMarque() {
		return marque.get();
	}
	public void setMarque(StringProperty marque) {
		this.marque = marque;
	}
	public String getEtat() {
		return etat.get();
	}
	public void setEtat(StringProperty etat) {
		this.etat = etat;
	}
	public int getId() {
		return id.get();
	}
	public void setId(IntegerProperty id) {
		this.id = id;
	}
	
	

}
