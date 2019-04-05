package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Parent;

public class Main extends Application {
	
	@FXML
	private Button btn_Fermer;
	@FXML
	private Button btn_Acheter;
	@FXML
	private Button btn_Vendre;
	
	private Stage window =new Stage();
	private Scene scene;
	private Parent root;
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			
			root =  FXMLLoader.load(getClass().getResource("Accueil_View.fxml"));
			window.setTitle("Kijiji");	
			scene = new Scene(root);
			window.setScene(scene);
			window.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//fx:controller="views.acheteur.Acheteur_View_Controler"
	public static void main(String[] args) {
		launch(args);
	}
	

	public void fermer_Application() {
		System.exit(0);
	}
	
	public void acheter() throws IOException {
		root =  FXMLLoader.load(getClass().getResource("../Views/acheteur/Acheteur_View.fxml"));
		scene = new Scene(root);
		window.setTitle("Acheteur");
		window.setScene(scene);
		window.show();
	}
	
	public void vendre() throws IOException {
		root =  FXMLLoader.load(getClass().getResource("../Views/vendeur/Vendeur_View.fxml"));	
		window.setTitle("Vendeur");
		scene = new Scene(root);
		window.setScene(scene);
		window.show();
	}
}
