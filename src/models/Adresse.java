package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Adresse {
	private IntegerProperty no_street;
	private IntegerProperty no_app;
	private StringProperty name_street;
	private StringProperty name_city;
	private StringProperty name_province;
	private StringProperty postal_code;
	
	public Adresse(IntegerProperty no_street, IntegerProperty no_app, StringProperty name_street, 
			StringProperty name_city, StringProperty name_province, StringProperty postal_code) {
		this.no_street = no_street;
		this.no_app = no_app;
		this.name_street = name_street;
		this.name_city = name_city;
		this.name_province = name_province;
		this.postal_code = postal_code;
	}
	
	public int getNoStreet() {
		return no_street.get();
	}
	public IntegerProperty getNoStreetProperty() {
		return no_street;
	}
	
	public int getNoApp() {
		return no_app.get();
	}
	public IntegerProperty getNoAppProperty() {
		return no_app;
	}
	
	public String getNameStreet() {
		return name_street.get();
	}
	public StringProperty getNameStreetProperty() {
		return name_street;
	}
	
	public String getNameCity() {
		return name_city.get();
	}
	public StringProperty getNameCityProperty() {
		return name_city;
	}
	
	public String getNameProvince() {
		return name_province.get();
	}
	public StringProperty getNameProvinceProperty() {
		return name_province;
	}
	
	public String getPostalCode() {
		return postal_code.get();
	}
	public StringProperty getPostalCodeProperty() {
		return postal_code;
	}

}
