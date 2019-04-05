package controler;

import java.io.Serializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Acheteur_controler implements Serializable {
	@FXML
	private Button btn_1;
	
	 public void showConsolMessage() {
		 System.out.println("Hello word!");
	 }
}
