package it.polito.tdp.Yelp;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Yelp.model.Business;
import it.polito.tdp.Yelp.model.Model;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnButton;

    @FXML
    private TableColumn<Business, String> colName; //il secondo paramentro è il tipo di dato che voglio visualizzare

    @FXML
    private TableColumn<Business, Double> colStars;

    @FXML
    private TableView<Business> tbBusiness;
    
    private Model model;

    @FXML
    void handleLoadData(ActionEvent event) {

    	//voglio popolare la TableView con i dati derivati dal database
    	tbBusiness.setItems(FXCollections.observableArrayList(model.getBusiness()));
    }

    @FXML
    void initialize() {
        assert btnButton != null : "fx:id=\"btnButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colStars != null : "fx:id=\"colStars\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tbBusiness != null : "fx:id=\"tbBusiness\" was not injected: check your FXML file 'Scene.fxml'.";
        
        colName.setCellValueFactory(new PropertyValueFactory<Business, String>("businessName")); //la String si chiama businessName
        colStars.setCellValueFactory(new PropertyValueFactory<Business, Double>("stars")); //il double si chiama stars nel database

    }
    
    public void setModel (Model model) {
    	this.model=model;
    }

}
