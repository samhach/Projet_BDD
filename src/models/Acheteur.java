package models;

public class Acheteur {

	private int acheter_Id;
	private String nom;
	private String prenom;
	private String tel;
	private Adresse adresse;
	
	
	public Acheteur() {
		super();
	}
	public Acheteur(int acheter_Id, String nom, String prenom, String tel, Adresse adresse) {
		super();
		this.acheter_Id = acheter_Id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
	}
	public int getAcheter_Id() {
		return acheter_Id;
	}
	public void setAcheter_Id(int acheter_Id) {
		this.acheter_Id = acheter_Id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
