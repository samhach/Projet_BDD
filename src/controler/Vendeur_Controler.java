package controler;

import java.sql.Connection;
import java.sql.SQLException;

import application.ConnectSingleton;
import models.Produit;

public class Vendeur_Controler {
	private 
	Connection conn;
	Produit_Controler prod_c ;
	
	public Vendeur_Controler() {
		prod_c = new Produit_Controler(ConnectSingleton.getConnexion());
	}

	
	public void insertProduit(Produit p) {
			prod_c.insert(p);
	}
	
	
	
}
