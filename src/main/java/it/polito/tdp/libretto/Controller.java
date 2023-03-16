package it.polito.tdp.libretto;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

public class Controller {
	private Libretto model;
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<Integer> cmbPunti;

	    @FXML
	    private DatePicker selData;

	    @FXML
	    private TextField txtCorso;

	    @FXML
	    private TextArea txtRisultati;

	    @FXML
	    void handleInserisci(ActionEvent event) {
	    	String corso = txtCorso.getText();
	    	int punti = this.cmbPunti.getValue();
	    	LocalDate data = selData.getValue();
	    	Voto v = new Voto(corso, punti, data);
	    	
	    	this.model.add(v);
	    	this.txtRisultati.setText(this.model.toString());
	    }

	    @FXML
	    void initialize() {
	        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'main.fxml'.";
	        assert selData != null : "fx:id=\"selData\" was not injected: check your FXML file 'main.fxml'.";
	        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
	        assert txtRisultati != null : "fx:id=\"txtRisultati\" was not injected: check your FXML file 'main.fxml'.";

	        //popolare la tendina: nel metodo initialize!!!
	        for(int p=18; p<=30; p++) {
	        	cmbPunti.getItems().add(p);
	        }
	        
	    }


	public void setModel(Libretto model) {
		this.model = model;
	}

}
