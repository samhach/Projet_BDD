package application;

import java.sql.Connection;
import java.sql.DriverManager;

import controller.Requetes_Contoller;

/**
 * Un classe de connexion, dont on peut avoir qu'une instance, même 
 * avec plusieurs appels
 * @author 
 *
 */
public class ConnectSingleton {

	//Il faut juste mettre les coordonnées pour la connexion (nom table, user et mpasse)
	//private static final String url = "jdbc:postgresql://postgres.iro.umontreal.ca:5432/wangyiji";
    
	
	//serveur postgres local avec le nom de la base:projet_bdd et user:sam et password :""
	private static final String url = "jdbc:postgresql://127.0.0.1/projet_bdd";	
    private static final String user ="sam";
    private static final String password = "";
//	private static final String user ="wangyiji_app";
//    private static final String password = "230789aA";
    private static Connection conn = null ;
	   
	static{
		
		try{
			//À activer une fois les coordonnées insérées
			 conn = DriverManager.getConnection(url, user, password);
			 Requetes_Contoller rq = new Requetes_Contoller(conn);
			 //rq.setSearchPath(conn);
	         System.out.println("Connected to the PostgreSQL server successfully.");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	public static Connection getConnexion(){
		return conn;
	}
}
/*
 * postgres://ebufzwnk:Qw-mWf4YsCOpQRcLyvoaoSmx6oDk0fS7@isilo.db.elephantsql.com:5432/ebufzwnk*/
