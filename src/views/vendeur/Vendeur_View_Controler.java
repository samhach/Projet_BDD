package views.vendeur;

import java.io.Serializable;
import java.sql.Connection;

import application.ConnectSingleton;
import controler.Categorie_Controler;
import controler.Etat_Controler;
import controler.Produit_Controler;
import controler.Requetes_Contoler;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Categorie;
import models.Etat;
import models.Produit;

@SuppressWarnings("serial")
public class Vendeur_View_Controler implements Serializable {

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
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView tv_queries;
	@FXML
	private ComboBox<String> cb_queries ;
	
	private Connection conn;
	
	Categorie_Controler cat_c;
	Etat_Controler etat_c ;
	Produit_Controler prod_c;
	Requetes_Contoler req_c;
	
	public Vendeur_View_Controler() {
		conn = ConnectSingleton.getConnexion();
		cat_c = new Categorie_Controler(conn);
		etat_c = new Etat_Controler(conn);
		prod_c = new Produit_Controler(conn);
		req_c = new Requetes_Contoler(conn);
		
	}

	@FXML
	private void initialize() {
		cb_Categorie.setItems(FXCollections.observableArrayList(cat_c.getCategories()));
		cb_Etat.setItems(FXCollections.observableArrayList(etat_c.getEtat()));
		
		cb_queries.setItems(FXCollections.observableArrayList(
				"Liste de tous les produits",
				"liste des produits vendus",
				"liste des produits non vendus"));
		
	}
	
	public void insertProduit() {
		try {
			Produit p = new Produit();		
			p.setNom(new SimpleStringProperty(tf_NomProd.getText()));
			p.setDescription(new SimpleStringProperty(tf_Description.getText()));
			p.setPrix(new SimpleFloatProperty(Float.parseFloat(tf_Prix.getText())));
			p.setLongueur(new SimpleFloatProperty(Float.parseFloat(tf_Longueur.getText())));
			p.setLargeur(new SimpleFloatProperty(Float.parseFloat(tf_Largeur.getText())));			
			p.setProfondeur(new SimpleFloatProperty(Float.parseFloat(tf_Profondeur.getText())));
			p.setCategorie(new SimpleStringProperty(cb_Categorie.getValue().toString()));
			p.setEtat(new SimpleStringProperty(cb_Etat.getValue().toString()));
			prod_c.insert(p); 
		} catch (Exception e) {
			System.out.println("Champ invalide");
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
		tf_Prix.clear();
		tf_Longueur.clear();
		tf_Largeur.clear();
		tf_Profondeur.clear();
		tf_Marque.clear();
		cb_Categorie.setValue(new Categorie(""));
		cb_Etat.setValue(new Etat(""));
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getListProduits() {
		tv_queries.getColumns().clear();
		if(cb_queries.getSelectionModel().isSelected(0))
		{
			ObservableList<Produit> data = req_c.getAllProducts();

			TableColumn nom_Column = new TableColumn("NOM");
			nom_Column.setCellValueFactory(new PropertyValueFactory("nom"));
			TableColumn desc_Column = new TableColumn("DESCRIPTION");
			desc_Column.setCellValueFactory(new PropertyValueFactory("description"));

			TableColumn prix_Column = new TableColumn("PRIX");
			prix_Column.setCellValueFactory(new PropertyValueFactory("prix"));
			TableColumn long_Column = new TableColumn("LONGUEUR");
			long_Column.setCellValueFactory(new PropertyValueFactory("longueur"));
			
			TableColumn lar_Column = new TableColumn("LARGEUR");
			lar_Column.setCellValueFactory(new PropertyValueFactory("nom"));
			TableColumn prof_Column = new TableColumn("PROFONDEUR");
			prof_Column.setCellValueFactory(new PropertyValueFactory("description"));

			TableColumn cat_Column = new TableColumn("CATEGORIE");
			cat_Column.setCellValueFactory(new PropertyValueFactory("prix"));
			TableColumn etat_Column = new TableColumn("ETAT");
			etat_Column.setCellValueFactory(new PropertyValueFactory("longueur"));

			tv_queries.getColumns().addAll(nom_Column, desc_Column,prix_Column, long_Column,lar_Column, prof_Column, cat_Column, etat_Column );
			tv_queries.setItems(data);
		}
		
	}
}
