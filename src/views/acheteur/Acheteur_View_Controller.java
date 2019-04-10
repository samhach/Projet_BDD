package views.acheteur;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import application.ConnectSingleton;
import application.Utilitaires;

import controller.Requetes_Contoller;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Categorie;
import models.Intervenant;
import models.Produit;

class ListViewHandler implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        //this method will be overrided in next step
    }
 }

public class Acheteur_View_Controller implements Serializable {
	@FXML
	private TextField search_bar;
	
	@FXML 
	private TableView tv_produit;	
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
		getListProduits(req_c.getAllProducts());
	}
	
	public void buttonClickAction() {
//		System.out.println(search_bar.getText());
//		listView.getItems().clear();
//		listView.getItems().addAll(getElementList(null));
//		listView.setOnMouseClicked(new ListViewHandler() {
//			@Override
//			public void handle(MouseEvent event) {
//				selectedElement = listView.getSelectionModel().getSelectedItem();
//				tf_Id.setText("1");;
//				tf_Nom.setText(((Produit)selectedElement).getNom()); 
//				tf_Desc.setText(((Produit)selectedElement).getDescription()); 
//				tf_Cat.setText(((Produit)selectedElement).getCategorie()); 
//				tf_Prix.setText(((Produit)selectedElement).getPrix()+""); 
//				tf_Dimension.setText(((Produit)selectedElement).getLongueur()+", "+((Produit)selectedElement).getLargeur()+", "+((Produit)selectedElement).getProfondeur()); 
//				tf_Marque.setText(((Produit)selectedElement).getMarque()); 
//				tf_Etat.setText(((Produit)selectedElement).getEtat());
//				
//				
//			}
//		});
		
	}
	
	public Object[] getElementList(String query) {
		
		StringProperty x1 = new SimpleStringProperty(this, "aaa", "aaa");
		FloatProperty x2 = new SimpleFloatProperty(12);
		IntegerProperty x3 = new SimpleIntegerProperty(5);
		
		Produit p1 = new Produit(x1, x1, x2, x2, x2, x2, x1, x1, x1);
		Produit p2 = new Produit(x1, x1, x2, x2, x2, x2, x1, x1, x1);
		Produit p3 = new Produit(x1, x1, x2, x2, x2, x2, x1, x1, x1);
		List<Object> allBuyers = new ArrayList<Object>() {{
			add(p1);
			add(p2);
			add(p3);
		}};	
		Object[] arrayAllBuyers = allBuyers.toArray(new Object[0]);
		return arrayAllBuyers;
	}
	
	public void buyAction() {
		closeAction();
	}
	public void panelAction() {
		//Produits.add((Produit)selectedElement);
	}
	public void closeAction() {
		Stage stage = (Stage) search_bar.getScene().getWindow();
		stage.close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getListProduits(ObservableList<Produit> data) {
		tv_produit.getColumns().clear();		
			//ObservableList<Produit> data = req_c.getAllProducts();

			tv_produit.getColumns().addAll(Utilitaires.buildTableCol("NOM"),Utilitaires.buildTableCol("DESCRIPTION"),Utilitaires.buildTableCol("PRIX"), 
					Utilitaires.buildTableCol("LONGUEUR"), Utilitaires.buildTableCol("LARGEUR"), Utilitaires.buildTableCol("PROFONDEUR"), Utilitaires.buildTableCol("TAILLE"), 
					Utilitaires.buildTableCol("CATEGORIE"), Utilitaires.buildTableCol("ETAT"));
			tv_produit.setItems(data);
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void mettreAJourTable() {
		tv_produit.getColumns().clear();
		if(rb_cat.isSelected() && !cb_ChercherCategorie.getValue().toString().isEmpty())
			 getListProduits(req_c.getAllProductsByCat(cb_ChercherCategorie.getValue().toString()));

		if(rb_nom.isSelected() && !tf_charcheNom.getText().isEmpty())
			 getListProduits(req_c.getAllProductsByName(tf_charcheNom.getText().toString()));
	}
}
