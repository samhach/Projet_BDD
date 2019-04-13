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
	private IntegerProperty vendeur_id =    new SimpleIntegerProperty();
	private StringProperty     titre = new SimpleStringProperty();
	private StringProperty description = new SimpleStringProperty();
	private FloatProperty prix = new SimpleFloatProperty();
	private StringProperty date_p = new SimpleStringProperty();
	private StringProperty date_v = new SimpleStringProperty();
	public Annonce(IntegerProperty prod_id, SimpleIntegerProperty vendeur_id, SimpleIntegerProperty acheteur_id,
			StringProperty titre, StringProperty description, FloatProperty prix, StringProperty date_p,
			StringProperty date_v) {
		this.prod_id = prod_id;
		this.vendeur_id = vendeur_id;
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
	
	public int getVendeur_id() {
		return vendeur_id.get();
	}
	public void setVendeur_id(IntegerProperty vendeur_id) {
		this.vendeur_id = vendeur_id;
	}
	public void setId(IntegerProperty id) {
		this.id = id;
	}
	public void setAcheteur_nom(IntegerProperty acheteur_id) {
	}
		public void setAcheteur_id(IntegerProperty acheteur_id) {
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
