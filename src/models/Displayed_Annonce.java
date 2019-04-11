package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Displayed_Annonce {

	private IntegerProperty annonce_id =  new SimpleIntegerProperty();
	private StringProperty  produit_nom = new SimpleStringProperty();
	private StringProperty annonce_description = new SimpleStringProperty();
	private StringProperty produit_categorie = new SimpleStringProperty();
	private FloatProperty prix = new SimpleFloatProperty();
	private FloatProperty taille = new SimpleFloatProperty();
	private FloatProperty longueur = new SimpleFloatProperty();
	private FloatProperty largeur = new SimpleFloatProperty();
	private FloatProperty profondeur = new SimpleFloatProperty();
	private StringProperty marque = new SimpleStringProperty();
	private StringProperty etat = new SimpleStringProperty();
	private StringProperty adresse = new SimpleStringProperty();
	private FloatProperty prix_estim = new SimpleFloatProperty();
	private BooleanProperty finalisee = new SimpleBooleanProperty();
	private StringProperty tel = new SimpleStringProperty();
	private StringProperty titre = new SimpleStringProperty();
	private StringProperty date_pub = new SimpleStringProperty();


	public Displayed_Annonce() {
		super();
		
	}

	public int getAnnonce_id() {
		return annonce_id.get();
	}

	public void setAnnonce_id(IntegerProperty annonce_id) {
		this.annonce_id = annonce_id;
	}

	public String getProduit_nom() {
		return produit_nom.get();
	}

	public void setProduit_nom(StringProperty produit_nom) {
		this.produit_nom = produit_nom;
	}

	public String getAnnonce_description() {
		return annonce_description.get();
	}

	public void setAnnonce_description(StringProperty annonce_description) {
		this.annonce_description = annonce_description;
	}

	public String getProduit_categorie() {
		return produit_categorie.get();
	}

	public void setProduit_categorie(StringProperty produit_categorie) {
		this.produit_categorie = produit_categorie;
	}

	public float getPrix() {
		return prix.get();
	}

	public void setPrix(FloatProperty prix) {
		this.prix = prix;
	}

	public float getTaille() {
		return taille.get();
	}

	public void setTaille(FloatProperty taille) {
		this.taille = taille;
	}

	public float getLongueur() {
		return longueur.get();
	}

	public void setLongueur(FloatProperty longueur) {
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur.get();
	}

	public void setLargeur(FloatProperty largeur) {
		this.largeur = largeur;
	}

	public float getProfondeur() {
		return profondeur.get();
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

	public String getAdresse() {
		return adresse.get();
	}

	public void setAdresse(StringProperty adresse) {
		this.adresse = adresse;
	}

	public float getPrix_estim() {
		return prix_estim.get();
	}

	public void setPrix_estim(FloatProperty prix_estim) {
		this.prix_estim = prix_estim;
	}

	public boolean getFinalisee() {
		return finalisee.get();
	}

	public void setFinalisee(BooleanProperty finalisee) {
		this.finalisee = finalisee;
	}
	public String getTel() {
		return tel.get();
	}

	public void setTel(StringProperty tel) {
		this.tel = tel;
	}
	
	public String getTitre() {
		return titre.get();
	}

	public void setTitre(StringProperty titre) {
		this.titre = titre;
	}

	public String getDate_pub() {
		return date_pub.get();
	}

	public void setDate_pub(StringProperty datePub) {
		this.date_pub = datePub;
	}
}
