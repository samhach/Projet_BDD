package views.vendeur;


import java.io.Serializable;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Optional;

import javafx.event.ActionEvent; 
import application.ConnectSingleton;
import controller.Annonce_Controller;
import controller.Categorie_Controller;
import controller.Etat_Controller;
import controller.Intervenant_controller;
import controller.Produit_Controller;
import controller.Requetes_Contoller;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Annonce;
import models.Categorie;
import models.Etat;
import models.Produit;

@SuppressWarnings("serial")
public class Vendeur_View_Controller implements Serializable {

	private TextInputDialog td;
	@FXML 
	private TextField tf_NomProd;
	@FXML 
	private TextField tf_Description;
	@FXML 
	private TextField tf_Prix ;
	@FXML 
	private TextField tf_Longueur;
	@FXML 
	private TextField tf_Largeur;
	@FXML 
	private TextField tf_Profondeur;
	@FXML 
	private TextField tf_Marque;
	@FXML 
	private ComboBox<Categorie> cb_Categorie ;
	@FXML 
	private ComboBox<Etat> cb_Etat;
	@FXML
	private Button btn_insert  ;
	@FXML
	private Button btn_annuler; 
	@FXML
	private Button btn_valider; 
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView tv_queries;
	
	@FXML
	private ComboBox<String> cb_queries ;
	
	@FXML
	private ComboBox<String> cb_nomVendeur;
	@FXML 
	private TextField tf_titreAnnoce;
	
	@FXML 
	private DatePicker dp_dateAnnonce ;
	@FXML 
	private TextField tf_prixEstimatif;
	@FXML 
	private TextField tf_Taille;
	@FXML
	private TextArea ta_description;
	
	private Connection conn;
	
	Categorie_Controller cat_c;
	Etat_Controller etat_c ;
	Produit_Controller prod_c;
	Annonce_Controller annon_c;
	Requetes_Contoller req_c;
	Intervenant_controller inter_c;
	public Vendeur_View_Controller() {
		conn = ConnectSingleton.getConnexion();
		cat_c = new Categorie_Controller(conn);
		etat_c = new Etat_Controller(conn);
		prod_c = new Produit_Controller(conn);		
		req_c = new Requetes_Contoller(conn);
		annon_c = new Annonce_Controller(conn);
		inter_c = new Intervenant_controller(conn);
		
	}

	@FXML
	private void initialize() {
		cb_Categorie.setItems(FXCollections.observableArrayList(cat_c.getCategories()));
		cb_Etat.setItems(FXCollections.observableArrayList(etat_c.getEtat()));
		cb_nomVendeur.setItems(FXCollections.observableArrayList(inter_c.getAllIntervenant()));
		cb_queries.setItems(FXCollections.observableArrayList(
				"Liste de tous les produits",
				"liste des produits vendus",
				"liste des produits non vendus"));
		dp_dateAnnonce.setValue(LocalDate.now());
		clearFields();
		
	}
	public void validerAnnonce() {		
		float prix = showExpertDialog();
		if(prix < 0) return;			
		tf_prixEstimatif.setText(String.valueOf(prix));
		btn_insert.setDisable(false);
	}
	public void insertProduit() {				
		try {
			if(!checkFields()) {
				Alert a = new Alert(AlertType.ERROR, "CHAMP(S) INVALIDE(s)", ButtonType.OK);
				a.show();
				return;
			}
			Produit p = new Produit();
			Annonce a = new Annonce();
			p.setId(new SimpleIntegerProperty(prod_c.getLastIndex() + 1));
			p.setNom(new SimpleStringProperty(tf_NomProd.getText()));
			p.setDescription(new SimpleStringProperty(tf_Description.getText()));
			float prix =Float.parseFloat(tf_Longueur.getText());
			if(prix <0) return;
			p.setPrix(new SimpleFloatProperty(Float.parseFloat(tf_Prix.getText())));
			p.setLongueur(new SimpleFloatProperty(prix));
			p.setLargeur(new SimpleFloatProperty(Float.parseFloat(tf_Largeur.getText())));			
			p.setProfondeur(new SimpleFloatProperty(Float.parseFloat(tf_Profondeur.getText())));
			p.setCategorie(new SimpleStringProperty(cb_Categorie.getValue().toString()));
			p.setEtat(new SimpleStringProperty(cb_Etat.getValue().toString()));
			
			a.setId(new SimpleIntegerProperty(annon_c.getLastIndex() + 1));	
			a.setProd_id(new SimpleIntegerProperty(p.getId()));
			a.setVendeur_nom(new SimpleStringProperty(cb_nomVendeur.getValue().toString()));
			a.setTitre(new SimpleStringProperty(tf_titreAnnoce.getText()));
			a.setPrix(new SimpleFloatProperty(Float.parseFloat(tf_prixEstimatif.getText())));
			a.setDescription(new SimpleStringProperty(ta_description.getText()));
			a.setDate_p(new SimpleStringProperty(dp_dateAnnonce.getValue().toString()));
			annon_c.insert(a, p);
			 
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR, "CHAMP(S) INVALIDE(s)", ButtonType.OK);
			a.show();
			return;
		}
		clearFields();
	}
	public void closeWindow() {
		
			Stage stage = (Stage) btn_annuler.getScene().getWindow();
			stage.close();
	}
	
	private void clearFields() {
		tf_NomProd.clear();
		tf_Description.clear();
		tf_Prix.setText("0");
		tf_Longueur.setText("0");
		tf_Largeur.setText("0");
		tf_Profondeur.setText("0");
		tf_Taille.setText("0");
		tf_Marque.clear();
		cb_nomVendeur.setValue("");
		tf_prixEstimatif.setText("0");
		ta_description.clear();
		tf_titreAnnoce.clear();
		cb_Categorie.setValue(new Categorie(""));
		cb_Etat.setValue(new Etat(""));
		btn_insert.setDisable(true);
	}
	private boolean checkFields() {
		if(tf_NomProd.getText().isEmpty() || tf_Description.getText().isEmpty() ||
			tf_Prix.getText().isEmpty() || cb_Categorie.getValue() == null || 
			cb_Etat.getValue() == null ||
			cb_nomVendeur.getValue() == null || tf_prixEstimatif.getText().isEmpty())
			return false;
		return true;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getListProduits() {
		tv_queries.getColumns().clear();
		if(cb_queries.getSelectionModel().isSelected(0))
		{
			ObservableList<Produit> data = req_c.getAllProducts();

			tv_queries.getColumns().addAll(buildTableCol("NOM"),buildTableCol("DESCRIPTION"),buildTableCol("PRIX"), 
					buildTableCol("LONGUEUR"), buildTableCol("LARGEUR"), buildTableCol("PROFONDEUR"), 
					buildTableCol("CATEGORIE"), buildTableCol("ETAT"));
			tv_queries.setItems(data);
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	private TableColumn buildTableCol(String nom) {
		
		TableColumn col = new TableColumn(nom.toUpperCase());
		col.setCellValueFactory(new PropertyValueFactory(nom.toLowerCase()));
		return col;
	}
	
	public Float showExpertDialog() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Enter de données");
		dialog.setHeaderText("Le prix estimé par l'expert");
		dialog.setContentText("Entrez le prix estimatif:");
		Optional<String> result = dialog.showAndWait();
		float prix = -1;
		try {			
			if (result.isPresent())
		    	prix = Float.parseFloat(result.get());
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR, "ENTRÉE INVALIDE", ButtonType.OK);
			a.show();
		}
		
		return prix;
	   }
	
}
