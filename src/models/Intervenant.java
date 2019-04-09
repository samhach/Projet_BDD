package models;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Intervenant {

	private IntegerProperty id =         new SimpleIntegerProperty();
	private StringProperty     nom = new SimpleStringProperty();
	private StringProperty prenom = new SimpleStringProperty();
	private StringProperty tel = new SimpleStringProperty();
	private IntegerProperty adresse_id =         new SimpleIntegerProperty();
	
	public Intervenant(IntegerProperty id, StringProperty nom, StringProperty prenom, StringProperty tel,
			IntegerProperty adresse_id) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse_id = adresse_id;
	}
	public Intervenant() {
		this.id.set(this.id.get() + 1);;
	}
	public int getId() {
		return id.get();
	}
	public void setId(IntegerProperty id) {
		this.id = id;
	}
	public String getNom() {
		return nom.get();
	}
	public void setNom(StringProperty nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom.get();
	}
	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel.get();
	}
	public void setTel(StringProperty tel) {
		this.tel = tel;
	}
	public int getAdresse_id() {
		return adresse_id.get();
	}
	public void setAdresse_id(IntegerProperty adresse_id) {
		this.adresse_id = adresse_id;
	}

	
	
	
}
