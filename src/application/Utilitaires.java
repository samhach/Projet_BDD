package application;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public  class Utilitaires {

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static TableColumn buildTableCol(String nom) {
		
		TableColumn col = new TableColumn(nom.toUpperCase());
		col.setCellValueFactory(new PropertyValueFactory(nom.toLowerCase()));
		return col;
	}
}
