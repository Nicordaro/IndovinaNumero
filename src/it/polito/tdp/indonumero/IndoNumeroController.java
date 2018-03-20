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
	
	private Model model;

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
	    model.newGame();
	    
	    	btnNuova.setDisable(true);
	    	boxGioco.setDisable(false);
	    	txtCurrent.setText(String.format("%d", model.getTentativi()));
	    	txtMax.setText(String.format("%d", model.getTMAX()));
	    	txtLog.clear();
	    	txtTentativo.clear();
	    	
	    	txtLog.setText(String.format("Indovina un numero tra %d e %d\n", 1, model.getNMAX()));
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
    	// il numero è effettivamente un intero
 		// numero era effettivamente un intero
    	if(!model.valoreValido(num)) {
    		txtLog.appendText("Valore fuori dall'intervallo consentito\n");
    		return;
    	}
    		
    		int risultato = model.tentativo(num);
    	 	txtCurrent.setText(String.format("%d", model.getTentativi()));
    		
    		if (risultato == 0) {
    			// ha indovinato
    			txtLog.appendText("Hai vinto!\n");
    		} else if (risultato<0) {
    			txtLog.appendText("Troppo basso!\n");
    		} else {
    			txtLog.appendText("Troppo alto!\n");
    		}
    	
    		if(!model.isInGame()) {
    			// la partita è finita (vittoria o sconfitta)
    			if(risultato!=0) {
    				txtLog.appendText("Hai perso!\n");
    				txtLog.appendText(String.format("Il numero segreto era: %d\n",
    						model.getSegreto()));
    				}
    				btnNuova.setDisable(false);
        			boxGioco.setDisable(true);
    			
    		}
//    		
//    		
//   		if(num==this.segreto) {
//  			// ha indovinato
//    			txtLog.appendText("Hai vinto!\n");
//    			
//    			// "chiudi" la partita
//    			btnNuova.setDisable(false);
//    			boxGioco.setDisable(true);
//    			this.inGame = false ;
//    		} else {
//    			// tentativo errato
//    			this.tentativi++ ;
//    	    	txtCurrent.setText(String.format("%d", this.tentativi));
//    	    	
//    	    	if (this.tentativi==this.TMAX) {
//    	    		// ha perso
//    	    		txtLog.appendText(
//    	    				String.format("Hai perso! Il numero era: %d\n",
//    	    						this.segreto));
//        			// "chiudi" la partita
//        			btnNuova.setDisable(false);
//        			boxGioco.setDisable(true);
//        			this.inGame = false ;
//    	    	} else {
//    	    		// sono ancora in gioco
//    	    		if(num<segreto) {
//    	    			// troppo basso
//    	    			txtLog.appendText("Troppo basso\n");
//    	    		} else {
//						// troppo alto
//    	    			txtLog.appendText("Troppo alto\n");
//    	    		}
//    	    	}
//    		}
//    	
//    	
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
    
    public void setModel(Model model) {
		this.model = model;
	}
}