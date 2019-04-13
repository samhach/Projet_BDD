package application;


import java.io.Serializable;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Optional;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import models.Annonce;
import models.Categorie;
import models.Etat;
import models.Produit;

@SuppressWarnings("serial")
public class Vendeur_View_Controller implements Serializable {

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
	private TextField tf_taille;
	@FXML
	private TextArea ta_description;
	
	private Connection conn;
	
	Requetes_Contoller req_c;

	public Vendeur_View_Controller() {
		this.conn = ConnectSingleton.getConnexion();
		this.req_c =new Requetes_Contoller(conn);
		
	}

	@FXML
	private void initialize() {
		cb_Categorie.setItems(FXCollections.observableArrayList(req_c.getCategories()));
		cb_Etat.setItems(FXCollections.observableArrayList(req_c.getEtat()));
		cb_nomVendeur.setItems(FXCollections.observableArrayList(req_c.getIntervenantsName()));
		cb_queries.setItems(FXCollections.observableArrayList(
				"Liste de tous les produits",
				"liste de toutes les annonces",
				"liste des pulications"));
		dp_dateAnnonce.setValue(LocalDate.now());
		clearFields();
		
	}
	public void validerAnnonce() {	
		if(!checkFields()) {
			Alert a = new Alert(AlertType.ERROR, "CHAMP(S) INVALIDE(s)", ButtonType.OK);
			a.show();
			return;
		}
		float prix = showExpertDialog();
		if(prix < 0) return;			
		tf_prixEstimatif.setText(String.valueOf(prix));
		btn_insert.setDisable(false);
	}
	public void insertProduit() {				
		try {
			
			Produit p = new Produit();
			Annonce a = new Annonce();
			p.setTaille(new SimpleFloatProperty(Float.parseFloat(tf_taille.getText())));
			p.setNom(new SimpleStringProperty(tf_NomProd.getText()));
			p.setDescription(new SimpleStringProperty(tf_Description.getText()));
			float prix =Float.parseFloat(tf_Longueur.getText());
			if(prix <0) return;
			p.setPrix(new SimpleFloatProperty(Float.parseFloat(tf_Prix.getText())));
			p.setMarque(new SimpleStringProperty(tf_Marque.getText()));
			p.setLongueur(new SimpleFloatProperty(Float.parseFloat(tf_Longueur.getText())));
			p.setLargeur(new SimpleFloatProperty(Float.parseFloat(tf_Largeur.getText())));			
			p.setProfondeur(new SimpleFloatProperty(Float.parseFloat(tf_Profondeur.getText())));
			p.setCategorie(new SimpleStringProperty(cb_Categorie.getValue().toString()));
			p.setEtat(new SimpleStringProperty(cb_Etat.getValue().toString()));
			
	
			a.setProd_id(new SimpleIntegerProperty(p.getId()));
			a.setVendeur_id(new SimpleIntegerProperty(Integer.parseInt((cb_nomVendeur.getValue().toString()).split("-")[0])));
			a.setTitre(new SimpleStringProperty(tf_titreAnnoce.getText()));
			a.setPrix(new SimpleFloatProperty(Float.parseFloat(tf_prixEstimatif.getText())));
			a.setDescription(new SimpleStringProperty(ta_description.getText()));
			a.setDate_p(new SimpleStringProperty(dp_dateAnnonce.getValue().toString()));
			req_c.insert(a, p);
			 
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
		tf_taille.setText("0");
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
			tf_Prix.getText().isEmpty() || cb_Categorie.getValue().toString().isEmpty() || 
			cb_Etat.getValue().toString().isEmpty() || cb_nomVendeur.getValue().toString().isEmpty())
			return false;
		return true;
	}
	@SuppressWarnings({ "unchecked" })
	public void getListProduits() {
		tv_queries.getColumns().clear();
		if(cb_queries.getSelectionModel().isSelected(0))
		{
			ObservableList<Produit> data = req_c.getAllProducts();

			tv_queries.getColumns().addAll(Utilitaires.buildTableCol("NOM"),Utilitaires.buildTableCol("DESCRIPTION"),
					Utilitaires.buildTableCol("PRIX"), Utilitaires.buildTableCol("MAEQUE"),
					Utilitaires.buildTableCol("LONGUEUR"), Utilitaires.buildTableCol("LARGEUR"),
					Utilitaires.buildTableCol("PROFONDEUR"), Utilitaires.buildTableCol("TAILLE"), 
					Utilitaires.buildTableCol("CATEGORIE"), Utilitaires.buildTableCol("ETAT"));
			tv_queries.setItems(data);
		}
		if(cb_queries.getSelectionModel().isSelected(1))
		{
			ObservableList<Produit> data = req_c.listeDesAnnonces();

			tv_queries.getColumns().addAll(Utilitaires.buildTableCol("ANNONCE_ID"), Utilitaires.buildTableCol("PRODUIT_NOM"),
					Utilitaires.buildTableCol("ANNONCE_DESCRIPTION"), Utilitaires.buildTableCol("PRIX"), 
					Utilitaires.buildTableCol("TAILLE"),Utilitaires.buildTableCol("LONGUEUR"), 
					Utilitaires.buildTableCol("LARGEUR"), Utilitaires.buildTableCol("PROFONDEUR"), 
					Utilitaires.buildTableCol("MARQUE"),Utilitaires.buildTableCol("PRODUIT_CATEGORIE"),
					Utilitaires.buildTableCol("ETAT"),  Utilitaires.buildTableCol("DATE_PUB"));
					
			tv_queries.setItems(data);
		}
		if(cb_queries.getSelectionModel().isSelected(2))
		{
			ObservableList<Produit> data = req_c.getAllAnnoncesFilter(0, null);

			tv_queries.getColumns().addAll(Utilitaires.buildTableCol("ANNONCE_ID"), Utilitaires.buildTableCol("PRODUIT_NOM"),
					Utilitaires.buildTableCol("ANNONCE_DESCRIPTION"), Utilitaires.buildTableCol("PRIX"), 
					Utilitaires.buildTableCol("TAILLE"),Utilitaires.buildTableCol("LONGUEUR"), 
					Utilitaires.buildTableCol("LARGEUR"), Utilitaires.buildTableCol("PROFONDEUR"), 
					Utilitaires.buildTableCol("MARQUE"),Utilitaires.buildTableCol("PRODUIT_CATEGORIE"),
					Utilitaires.buildTableCol("ETAT"),  Utilitaires.buildTableCol("DATE_PUB"),
					Utilitaires.buildTableCol("ADRESSE"), Utilitaires.buildTableCol("TEL"),
					Utilitaires.buildTableCol("FINALISEE"));
			tv_queries.setItems(data);

			
		}
		if(cb_queries.getSelectionModel().isSelected(3))
		{
			
		}
		if(cb_queries.getSelectionModel().isSelected(4))
		{
			
		}
		if(cb_queries.getSelectionModel().isSelected(5))
		{
			
		}
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
