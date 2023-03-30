/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscrittiCorso"
    private Button btnCercaIscrittiCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCompleta"
    private Button btnCompleta; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="choiseCorso"
    private ComboBox<String> choiseCorso; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	try {
	    	int matricola = Integer.parseInt(this.txtMatricola.getText());
	    	
	    	if(this.model.cercaStudente(matricola) == false) {
	    		txtRisultato.setText("Matricola non presente nel database!");
	    		return;
	    	}
	    	
	    	String nomeIns = this.choiseCorso.getValue();
	    	
	    	if(nomeIns == "" || nomeIns == null) {
	    	
		    	List<Corso> corsi = this.model.getCorsiFromStudente(matricola);
		    	
		    	for(Corso c:corsi) {
		    		this.txtRisultato.appendText(c.toString()+"\n");
		    	}
	    	}
	    	else {
	    		boolean iscritto = false;
	    		List<Corso> corsi = this.model.getCorsiFromStudente(matricola);
	    		
	    		for(Corso c:corsi) {
	    			if(c.getNome().compareTo(nomeIns)==0) {
	    				this.txtRisultato.setText("Studente iscritto al corso "+c.getNome());
	    				iscritto = true;
	    			}
	    		}
	    		if(!iscritto)
	    			this.txtRisultato.setText("Studente non iscritto al corso selezionato!");
	    	}
    	
    	}catch (NumberFormatException nfe){
    		this.txtRisultato.setText("Inserire una matricola nel formato corretto.");
    	}catch (RuntimeException re) {
    		txtRisultato.setText("ERRORE DI CONNESSIONE AL DATABASE!");
    	}
   
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
    	String nomeIns = this.choiseCorso.getValue();
    	
    	if(nomeIns == "" || nomeIns == null) {
    		this.txtRisultato.setText("Selezionare un corso dal menù!");
    		return;
    	}
    	Corso cTemp = null;
    	
    	for(Corso c:model.getTuttiICorsi()) {
    		if(c.getNome().compareTo(nomeIns)==0)
    			cTemp = c;
    	}
    	if(cTemp == null) {
    		this.txtRisultato.setText("Errore, corso non presente nel database!");
    		return;
    	}
    	
    	List<Integer> matricole = this.model.getStudentiIscrittiAlCorso(cTemp);
    	this.txtRisultato.appendText("Elenco iscritti al corso "+nomeIns+" ("+cTemp.getCodins()+"):\n\n");
    	
    	for(Integer i:matricole) {
    		String [] info = this.model.getInfoStudente(i);
    		this.txtRisultato.appendText(""+i+" "+info[0]+" "+info[1]+"\n");
    	}

    }

    @FXML
    void doCompleta(ActionEvent event) {
    	
    	try {
    	int matricola = Integer.parseInt(txtMatricola.getText());
    	if(this.model.cercaStudente(matricola) == false) {
    		txtRisultato.setText("Matricola non presente nel database!");
    		return;
    	}
    	
    	String [] ris = this.model.getInfoStudente(matricola);
    	
    	this.txtNome.setText(ris[0]);
    	this.txtCognome.setText(ris[1]);
    	}catch (NumberFormatException nfe) {
    		this.txtRisultato.setText("Inserire una matricola nel formato corretto.");
    	}catch (RuntimeException re) {
    		txtRisultato.setText("ERRORE DI CONNESSIONE AL DATABASE!");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	// cancello il contenuto di tutti i campi
    	this.txtMatricola.clear();
    	this.txtNome.clear();
    	this.txtCognome.clear();
    	this.txtRisultato.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCompleta != null : "fx:id=\"btnCompleta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert choiseCorso != null : "fx:id=\"choiceCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        
        }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.choiseCorso.getItems().add("");
    	
    	List<Corso> corsi = model.getTuttiICorsi(); //inizializzo la comboBox
    	for(Corso c:corsi)
    		this.choiseCorso.getItems().add(c.getNome());
    }

}
