package models;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Annonce {
	private IntegerProperty id =         new SimpleIntegerProperty();
	private IntegerProperty prod_id =    new SimpleIntegerProperty();
	private StringProperty vendeur_nom =    new SimpleStringProperty();
	private StringProperty acheteur_nom =    new SimpleStringProperty();
	private StringProperty     titre = new SimpleStringProperty();
	private StringProperty description = new SimpleStringProperty();
	private FloatProperty prix = new SimpleFloatProperty();
	private StringProperty date_p = new SimpleStringProperty();
	private StringProperty date_v = new SimpleStringProperty();
	public Annonce(IntegerProperty prod_id, StringProperty vendeur_nom, SimpleStringProperty acheteur_nom,
			StringProperty titre, StringProperty description, FloatProperty prix, StringProperty date_p,
			StringProperty date_v) {
		this.prod_id = prod_id;
		this.vendeur_nom = vendeur_nom;
		this.acheteur_nom = acheteur_nom;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.date_p = date_p;
		this.date_v = date_v;
	}
	public Annonce() {

	}
	public int getProd_id() {
		return prod_id.get();
	}
	public void setProd_id(IntegerProperty prod_id) {
		this.prod_id = prod_id;
	}
	
	public String getVendeur_nom() {
		return vendeur_nom.get();
	}
	public void setVendeur_nom(StringProperty vendeur_nom) {
		this.vendeur_nom = vendeur_nom;
	}
	public void setId(IntegerProperty id) {
		this.id = id;
	}
	public void setAcheteur_nom(StringProperty acheteur_nom) {
		this.acheteur_nom = acheteur_nom;
	}
	public String getAcheteur_nom() {
		return acheteur_nom.get();
	}
	public void setAcheteur_id(SimpleStringProperty acheteur_nom) {
		this.acheteur_nom = acheteur_nom;
	}
	public String getTitre() {
		return titre.get();
	}
	public void setTitre(StringProperty titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(StringProperty description) {
		this.description = description;
	}
	public float getPrix() {
		return prix.get();
	}
	public void setPrix(FloatProperty prix) {
		this.prix = prix;
	}
	public String getDate_p() {
		return date_p.get();
	}
	public void setDate_p(StringProperty date_p) {
		this.date_p = date_p;
	}
	public String getDate_v() {
		return date_v.get();
	}
	public void setDate_v(StringProperty date_v) {
		this.date_v = date_v;
	}
	public int getId() {
		return id.get();
	}

	
}
