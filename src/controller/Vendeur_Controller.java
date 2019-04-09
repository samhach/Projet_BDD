package controller;

import java.sql.Connection;
import java.sql.SQLException;

import application.ConnectSingleton;
import models.Produit;

public class Vendeur_Controller {
	private 
	Connection conn;
	Produit_Controller prod_c ;
	
	public Vendeur_Controller() {
		prod_c = new Produit_Controller(ConnectSingleton.getConnexion());
	}

	
	public void insertProduit(Produit p) {
			prod_c.insert(p);
	}
	
	
	
}
