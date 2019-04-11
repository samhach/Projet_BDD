package views.acheteur;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import application.ConnectSingleton;
import application.Utilitaires;

import controller.Requetes_Contoller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import models.Categorie;
import models.Displayed_Annonce;
import models.Produit;


public class Acheteur_View_Controller implements Serializable {
	@FXML
	private TextField search_bar;
	
	@FXML 
	private TableView tv_annonces;	
	@FXML 
	private Button btn_search;	
	@FXML 
	private Button btn_acheter;	
	@FXML 
	private Button btn_annuler;	
	@FXML
	private TextField tf_charcheNom;
	@FXML
	private TextField tf_Nom;
	@FXML
	private TextArea ta_Desc;
	@FXML
	private TextField tf_Categorie;
	@FXML
	private TextField tf_Prix;
	@FXML
	private TextField tf_Dimension;
	@FXML
	private TextField tf_Marque;
	@FXML
	private TextField tf_Etat;
	@FXML
	private TextField tf_prixAcheteur;
	@FXML
	private ComboBox<Categorie> cb_ChercherCategorie;
	@FXML
	private ComboBox<String> cb_Acheteur;
	
	@FXML
	private RadioButton rb_nom;
	@FXML
	private RadioButton rb_cat;
	@FXML
	private RadioButton rb_final;
	
	@FXML
	private Label lb_adresse;
	@FXML
	private Label lb_tel;
	
	private Connection conn;
	

	Requetes_Contoller req_c;
	
	List<Produit> Produits;

	
	public Acheteur_View_Controller() {
		this.conn = ConnectSingleton.getConnexion();
		this.req_c = new Requetes_Contoller(conn);
	}
	
	@FXML
	private void initialize() {
		cb_ChercherCategorie.setItems(FXCollections.observableArrayList(req_c.getCategories()));
		cb_Acheteur.setItems(FXCollections.observableArrayList(req_c.getIntervenantsName()));
		getListAnnonces(req_c.getAllAnnonces());
	}		

	public void closeAction() {
		Stage stage = (Stage) search_bar.getScene().getWindow();
		stage.close();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getListAnnonces(ObservableList<Displayed_Annonce> data) {
		tv_annonces.getColumns().clear();		

		tv_annonces.getColumns().addAll(Utilitaires.buildTableCol("ANNONCE_ID"), Utilitaires.buildTableCol("PRODUIT_NOM"),
					Utilitaires.buildTableCol("ANNONCE_DESCRIPTION"), Utilitaires.buildTableCol("PRIX"), 
					Utilitaires.buildTableCol("TAILLE"),Utilitaires.buildTableCol("LONGUEUR"), 
					Utilitaires.buildTableCol("LARGEUR"), Utilitaires.buildTableCol("PROFONDEUR"), 
					Utilitaires.buildTableCol("PRODUIT_CATEGORIE"),
					Utilitaires.buildTableCol("ETAT"),  Utilitaires.buildTableCol("DATE_PUB"),
					Utilitaires.buildTableCol("ADRESSE"), Utilitaires.buildTableCol("TEL"),
					Utilitaires.buildTableCol("FINALISEE")
					 
					);
			tv_annonces.setItems(data);
		
	}
	
	@SuppressWarnings("unchecked")
	public void mettreAJourTable() {
		tv_annonces.getColumns().clear();
		if(rb_cat.isSelected() && !cb_ChercherCategorie.getValue().toString().isEmpty())
			getListAnnonces(req_c.getAllProductsByCat(cb_ChercherCategorie.getValue().toString()));

		if(rb_nom.isSelected() && !tf_charcheNom.getText().isEmpty())
			getListAnnonces(req_c.getAllProductsByName(tf_charcheNom.getText().toString()));
		
		//if(rb_final.isSelected() && !tf_charcheNom.getText().isEmpty())
			//getListAnnonces(req_c.getAllProductsByName(tf_charcheNom.getText().toString()));
	}
	
	public void closeWindow() {
		
		Stage stage = (Stage) btn_annuler.getScene().getWindow();
		stage.close();
	}
	
	public void acheterProduit() {
		req_c.mettreAJourAnnonce(Float.parseFloat(tf_prixAcheteur.getText()), Integer.parseInt(cb_Acheteur.getValue().toString()), 1);
	}
}
