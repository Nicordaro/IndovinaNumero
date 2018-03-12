package it.polito.tdp.indonumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndoNumeroController {
	
	private int NMAX=100;
	private int TMAX=7;
	
	private int segreto; //numero da indovinare
	private int tentativi; //tentativi già fatti
	
	private boolean inGame = false; 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNuova;

    @FXML
    private TextField txtCurrent;

    @FXML
    private TextField txtMax;

    @FXML
    private HBox boxGioco;

    @FXML
    private TextField txtTentativo;

    @FXML
    private Button btnProva;

    @FXML
    private TextArea txtLog;

    @FXML
    void handleNuova(ActionEvent event) {
    	this.segreto = (int)(Math.random()*NMAX)+1;
    	
    	this.tentativi=0;
    	this.inGame = true;
    	
    	btnNuova.setDisable(true);
    	boxGioco.setDisable(false);
    	txtCurrent.setText(String.format("%d", this.tentativi));
    	txtMax.setText(String.format("%d", this.TMAX));
    }

    @FXML
    void handleProva(ActionEvent event) {
    	
    	String numS = txtTentativo.getText();
    	if(numS.length()==0) {
    		txtLog.appendText("Devi inserire un numero!\n");
    		return;
    	}
    	try {
    	int num = Integer.parseInt(numS);
    	// numero è effettivamente un intero
    	}
    	catch(NumberFormatException ex) {
    		txtLog.appendText("Il dato inserito non è numerico!\n");
    		return;
    	}
    	

    }

    @FXML
    void initialize() {
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtCurrent != null : "fx:id=\"txtCurrent\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtMax != null : "fx:id=\"txtMax\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert boxGioco != null : "fx:id=\"boxGioco\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtTentativo != null : "fx:id=\"txtTentativo\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'IndoNumero.fxml'.";

    }
}