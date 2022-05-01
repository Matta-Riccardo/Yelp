package it.polito.tdp.Yelp;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Yelp.model.Business;
import it.polito.tdp.Yelp.model.Model;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Business, String> colName;

    @FXML
    private TableColumn<Business, Double> colStars;

    @FXML
    private TableView<Business> tblBusiness;

    @FXML
    void handleLoadData(ActionEvent event) {

    	tblBusiness.setItems(FXCollections.observableArrayList(model.getBusinesses()));
    }
    
    public void setModel(Model m) {
    	this.model = m;
    }

    @FXML
    void initialize() {
        assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colStars != null : "fx:id=\"colStars\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tblBusiness != null : "fx:id=\"tblBusiness\" was not injected: check your FXML file 'Scene.fxml'.";

        //Devo istruire le colonne Nome su come comportarsi
        colName.setCellValueFactory(new PropertyValueFactory<Business,String>("businessName"));  //Devo creare una classe che implementi questa interfaccia e 
        																						 //abbia un metodo "col" da chiamare per fare questa traduzione (queste classi esistono già PropertyValueFactory). A questa classe passo il nome della proprietà da estrarrare dall'oggetto (specificato) e lui mi restituisce il valore  
        
        colStars.setCellValueFactory(new PropertyValueFactory<Business,Double>("stars"));  //Dico alla colonna : 'Tutte le volte che voi il contenuto del campo "stars" prendi l'oggetto che corrisponde alla riga e chiama il metodo getStars() che restituisce un Double è saranno i valori che usi per costruire il valore della cella'
    }

}
