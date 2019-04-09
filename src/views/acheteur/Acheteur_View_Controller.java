package views.acheteur;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import application.ConnectSingleton;
import controler.Categorie_Controler;
import controler.Etat_Controler;
import controler.Produit_Controler;
import controler.Requetes_Contoler;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Produit;

class ListViewHandler implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        //this method will be overrided in next step
    }
 }

public class Acheteur_View_Controler implements Serializable {
	@FXML
	private TextField search_bar;
	
	@FXML 
	private ListView<Object> listView;	
	@FXML 
	private Button btn_search;	
	@FXML
	private TextField tf_Id;
	@FXML
	private TextField tf_Nom;
	@FXML
	private TextArea tf_Desc;
	@FXML
	private TextField tf_Cat;
	@FXML
	private TextField tf_Prix;
	@FXML
	private TextField tf_Dimension;
	@FXML
	private TextField tf_Marque;
	@FXML
	private TextField tf_Etat;
	
	private Connection conn;
	
	private Object selectedElement;
	
	Categorie_Controler cat_c;
	Etat_Controler etat_c ;
	Produit_Controler prod_c;
	Requetes_Contoler req_c;
	
	List<Produit> Produits;
	public Acheteur_View_Controler() {
		/*conn = ConnectSingleton.getConnexion();
		cat_c = new Categorie_Controler(conn);
		etat_c = new Etat_Controler(conn);
		prod_c = new Produit_Controler(conn);
		req_c = new Requetes_Contoler(conn);*/
	}
	
	public void buttonClickAction() {
		System.out.println(search_bar.getText());
		listView.getItems().clear();
		listView.getItems().addAll(getElementList(null));
		listView.setOnMouseClicked(new ListViewHandler() {
			@Override
			public void handle(MouseEvent event) {
				selectedElement = listView.getSelectionModel().getSelectedItem();
				tf_Id.setText("1");;
				tf_Nom.setText(((Produit)selectedElement).getNom()); 
				tf_Desc.setText(((Produit)selectedElement).getDescription()); 
				tf_Cat.setText(((Produit)selectedElement).getCategorie()); 
				tf_Prix.setText(((Produit)selectedElement).getPrix()+""); 
				tf_Dimension.setText(((Produit)selectedElement).getLongueur()+", "+((Produit)selectedElement).getLargeur()+", "+((Produit)selectedElement).getProfondeur()); 
				tf_Marque.setText(((Produit)selectedElement).getMarque()); 
				tf_Etat.setText(((Produit)selectedElement).getEtat());
				
				
			}
		});
		
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
		Produits.add((Produit)selectedElement);
	}
	public void closeAction() {
		Stage stage = (Stage) search_bar.getScene().getWindow();
		stage.close();
	}
	
}
