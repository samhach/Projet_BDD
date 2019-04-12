package views.acheteur;

import java.io.Serializable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import application.ConnectSingleton;
import application.Utilitaires;

import javafx.event.EventHandler;
import javafx.scene.input.DataFormat;
import javafx.scene.input.MouseEvent;
import controller.Requetes_Contoller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.Annonce;
import models.Categorie;
import models.Displayed_Annonce;
import models.Produit;


class TabViewHandler implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        //this method will be overrided in next step
    }
 }

public class Acheteur_View_Controller implements Serializable {
	@FXML
	private TextField search_bar;
	
	@FXML 
	private TableView<Displayed_Annonce> tv_annonces;	
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
	private Label lb_final;
	@FXML
	private Label lb_adresse;
	@FXML
	private Label lb_tel;
	@FXML
	private Label lb_titre;
	
	private Connection conn;
	
	private ObservableList<Displayed_Annonce> data;
	private int index;
	
	private Object selectedItem;
	
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
		getListAnnonces(req_c.getAllAnnoncesFilter(0, null));
	}		

	public void closeAction() {
		Stage stage = (Stage) search_bar.getScene().getWindow();
		stage.close();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getListAnnonces(ObservableList<Displayed_Annonce> data) {
		tv_annonces.getColumns().clear();		
		this.data = data;
		 
		tv_annonces.getColumns().addAll(Utilitaires.buildTableCol("ANNONCE_ID"), Utilitaires.buildTableCol("PRODUIT_NOM"),
					Utilitaires.buildTableCol("ANNONCE_DESCRIPTION"), Utilitaires.buildTableCol("PRIX"), 
					Utilitaires.buildTableCol("TAILLE"),Utilitaires.buildTableCol("LONGUEUR"), 
					Utilitaires.buildTableCol("LARGEUR"), Utilitaires.buildTableCol("PROFONDEUR"), 
					Utilitaires.buildTableCol("MARQUE"),Utilitaires.buildTableCol("PRODUIT_CATEGORIE"),
					Utilitaires.buildTableCol("ETAT"),  Utilitaires.buildTableCol("DATE_PUB"),
					Utilitaires.buildTableCol("ADRESSE"), Utilitaires.buildTableCol("TEL"),
					Utilitaires.buildTableCol("FINALISEE")
					 
					);
			tv_annonces.setItems(data);
			tv_annonces.getSelectionModel().selectFirst();
			setAnnonceDetails();
	}
	
	@SuppressWarnings("unchecked")
	public void mettreAJourTable() {
		tv_annonces.getColumns().clear();
		if(rb_cat.isSelected() && !cb_ChercherCategorie.getValue().toString().isEmpty())
			getListAnnonces(req_c.getAllAnnoncesFilter(3, cb_ChercherCategorie.getValue().toString()));

		if(rb_nom.isSelected() && !tf_charcheNom.getText().isEmpty())
			getListAnnonces(req_c.getAllAnnoncesFilter(2, tf_charcheNom.getText().toString()));
		
		if(rb_final.isSelected())
			getListAnnonces(req_c.getAllAnnoncesFilter(1, null));
		
	}
	
	public void setAnnonceDetails() {
		selectedItem = tv_annonces.getSelectionModel().getSelectedItem();
		if(selectedItem == null) return;
		index = tv_annonces.getSelectionModel().getSelectedIndex();
		Displayed_Annonce p = (Displayed_Annonce)selectedItem;
		tf_Nom.setText(p.getProduit_nom()); 
		ta_Desc.setText(p.getAnnonce_description()); 
		tf_Categorie.setText(p.getProduit_categorie()); 
		tf_Prix.setText(p.getPrix()+""); 
		tf_Dimension.setText(p.getLongueur()+", "+p.getLargeur()+", "+p.getProfondeur()); 
		tf_Marque.setText(p.getMarque()); 
		tf_Etat.setText(p.getEtat());
		lb_adresse.setText("Localité: " +p.getAdresse());
		lb_tel.setText("Tel: " + p.getTel());
		lb_titre.setText(p.getTitre().trim());
		String v = (p.getFinalisee())? "VENDU" : "";
		lb_final.setText(v);
		cb_Acheteur.setValue("");
		tf_prixAcheteur.setEditable(!p.getFinalisee());
		tf_prixAcheteur.clear();
	}
	public void closeWindow() {
		
		Stage stage = (Stage) btn_annuler.getScene().getWindow();
		stage.close();
	}
	
	public void acheterProduit() {
		
			try {
				if(cb_Acheteur.getValue().toString().isEmpty() ) 
				{
					Alert a = new Alert(AlertType.ERROR, "NOM CLIENT INVALIDE", ButtonType.OK);
					a.show();
				}
				if(!tf_prixAcheteur.getText().isEmpty() || Float.parseFloat(tf_Prix.getText()) >= 0) 
				{
					if(data.get(index).getPrix_estim() > Float.parseFloat(tf_prixAcheteur.getText()));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
					finaliserLavente(data.get(index).getAnnonce_id() ,Integer.parseInt(cb_Acheteur.getValue().trim().split("-")[0]), Float.parseFloat(tf_prixAcheteur.getText().trim()), sdf.format(new Date()) );
					initialize();
					tv_annonces.getSelectionModel().selectFirst();
					setAnnonceDetails();
				}
			} catch (Exception e) {
				Alert a = new Alert(AlertType.ERROR, "PROBLEME CHAMPS PRIX", ButtonType.OK);
				a.show();
			}		
		}
	
	private void finaliserLavente(int annance_id, int acheteur_id, float prix_achat, String date_vente){
		req_c.mettre_a_jour(annance_id, acheteur_id , prix_achat, date_vente);
	}
}
