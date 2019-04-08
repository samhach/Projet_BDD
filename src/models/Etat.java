package models;

public class Etat {

	private String etat;
	public Etat(String etat) {
		this.etat = etat;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		return etat;
	}
	
	
}
