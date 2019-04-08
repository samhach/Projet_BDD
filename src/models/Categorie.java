package models;

public class Categorie {

	private String categorie;
	public Categorie(String categorie) {
		this.categorie = categorie;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return categorie;
	}
	
	
}
