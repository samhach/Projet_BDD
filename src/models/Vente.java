package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vente {
	private StringProperty date = new SimpleStringProperty();
	private IntegerProperty prod_Id = new SimpleIntegerProperty();
	private IntegerProperty seller_Id = new SimpleIntegerProperty();
	private IntegerProperty contract_Id = new SimpleIntegerProperty();
	private Etat prod_Stat;
	
	public Vente(StringProperty date, IntegerProperty prod_Id, IntegerProperty seller_Id, 
			IntegerProperty contract_Id, Etat prod_Stat) {
		this.date = date;
		this.prod_Id = prod_Id;
		this.seller_Id = seller_Id;
		this.contract_Id = contract_Id;
		this.prod_Stat = prod_Stat;
	}
	
	public Vente() {
		
	}
	
	public String getDate() {
		return date.get();
	}
	public StringProperty getDateProperty() {
		return date;
	}
	public void setDate(String newDate) {
		date.set(newDate);
	}
	
	public int getProdId() {
		return prod_Id.get();
	}
	public IntegerProperty getProdIdProperty() {
		return prod_Id;
	}
	public void setProdId(int newId) {
		prod_Id.set(newId);
	}
	
	public int getSellerId() {
		return seller_Id.get();
	}
	public IntegerProperty getSellerIdProperty() {
		return seller_Id;
	}
	public void setSellerId(int newId) {
		seller_Id.set(newId);
	}
	
	public int getContractId() {
		return contract_Id.get();
	}
	public IntegerProperty getContractIdProperty() {
		return contract_Id;
	}
	public void setContractId(int newId) {
		contract_Id.set(newId);
	}
	
	public Etat getState() {
		return prod_Stat;
	}
	public void setState(Etat newState) {
		prod_Stat = newState;
	}

}
