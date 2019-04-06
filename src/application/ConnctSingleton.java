package application;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Un classe de connexion, dont on peut avoir qu'une instance, m�me 
 * avec plusieurs appels
 * @author 
 *
 */
public class ConnctSingleton {

	//Il faut juste mettre les coordonn�es pour la connexion (nom table, user et mpasse)
	private static final String url = "jdbc:postgresql://postgres.iro.umontreal.ca::5432/ift2935";
    private static final String user = "user";
    private static final String password = "password";
    private static Connection conn = null;
	   
	static{
		
		try{
			//� activer une fois les coordonn�es ins�r�es
			 //conn = DriverManager.getConnection(url, user, password);
	         System.out.println("Connected to the PostgreSQL server successfully.");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	public static Connection getConnexion(){
		return conn;
	}
}
