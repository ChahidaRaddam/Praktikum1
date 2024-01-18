package guiStaetdtischeEinrichtungen;
import java.io.IOException;

import business.BuergeraemterModel;
import business.Buergeramt;
import business.sporthalle.Sporthalle;
import business.sporthalle.SporthalleModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {

	// Hier ergaenzen
	private StaedtischeEinrichtungenControl stControl;
	private BuergeraemterModel buergeraemterModel;
	
	private SporthalleModel sporthalleModel;
	
	//---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new  Pane();
	private Label lblAnzeigeBuergeraemter    = new Label("Anzeige Bürgerämter");
	private TextArea txtAnzeigeBuergeraemter  = new TextArea();
	private Button btnAnzeigeBuergeraemter = new Button("Anzeige");
	//-------Ende Attribute der grafischen Oberflaeche-------

	private Label lblAnzeigeSporthalle    = new Label("Anzeige Sporthalle");
	private TextArea txtAnzeigeSporthalle  = new TextArea();
	private Button btnAnzeigeSporthalle = new Button("csv-Import und Anzeige");
	
	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl stControl, Stage primaryStage, BuergeraemterModel buergeraemterModel, SporthalleModel sporthalleModel ){
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von städtischen " + "Einrichtungen");
		primaryStage.show();
		// Hier ergaenzen
		this.stControl = stControl;
		this.buergeraemterModel = buergeraemterModel;
		this.sporthalleModel = sporthalleModel;
		
	this.initKomponenten();
	this.initKomponentenSporthalle();
	this.initListener();
	this.initListenerSporthalle();

	}

	private void initKomponenten(){
		// Label
		Font font = new Font("Arial", 20);
     	lblAnzeigeBuergeraemter.setLayoutX(310);
		lblAnzeigeBuergeraemter.setLayoutY(40);
		lblAnzeigeBuergeraemter.setFont(font);
		lblAnzeigeBuergeraemter.setStyle("-fx-font-weight: bold;"); 
   	    pane.getChildren().add(lblAnzeigeBuergeraemter);    

//Textbereich	
    	txtAnzeigeBuergeraemter.setEditable(false);
 		txtAnzeigeBuergeraemter.setLayoutX(310);
		txtAnzeigeBuergeraemter.setLayoutY(90);
 		txtAnzeigeBuergeraemter.setPrefWidth(220);
		txtAnzeigeBuergeraemter.setPrefHeight(185);
   	pane.getChildren().add(txtAnzeigeBuergeraemter);        	
    	// Button
      	btnAnzeigeBuergeraemter.setLayoutX(310);
    	btnAnzeigeBuergeraemter.setLayoutY(290);
    	pane.getChildren().add(btnAnzeigeBuergeraemter); 
}
	private void initKomponentenSporthalle() {
		Font font = new Font("Arial", 20);
	   	lblAnzeigeSporthalle.setLayoutX(10);
			lblAnzeigeSporthalle.setLayoutY(40);
			lblAnzeigeSporthalle.setFont(font);
			lblAnzeigeSporthalle.setStyle("-fx-font-weight: bold;"); 
	   	pane.getChildren().add(lblAnzeigeSporthalle);    

	//Textbereich	
	    	txtAnzeigeSporthalle.setEditable(false);
	 		txtAnzeigeSporthalle.setLayoutX(10);
			txtAnzeigeSporthalle.setLayoutY(90);
	 		txtAnzeigeSporthalle.setPrefWidth(220);
			txtAnzeigeSporthalle.setPrefHeight(185);
	   	pane.getChildren().add(txtAnzeigeSporthalle);        	
	    	// Button
	      	btnAnzeigeSporthalle.setLayoutX(10);
	    	btnAnzeigeSporthalle.setLayoutY(290);
	    	pane.getChildren().add(btnAnzeigeSporthalle); 
	}

private void initListener() {
    btnAnzeigeBuergeraemter.setOnAction(
			new EventHandler<ActionEvent>() {
    		@Override
        	public void handle(ActionEvent e) {
            	zeigeBuergeraemterAn();
        	} 
	    });
}

private void initListenerSporthalle() {
	btnAnzeigeSporthalle.setOnAction(
				new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeSporthalleAn();
	        	} 
		    });
}

public void zeigeBuergeraemterAn(){
		if(buergeraemterModel.getBuergeramtList().size() > 0){
			   StringBuffer text = new StringBuffer();
				for (Buergeramt buergeramt : buergeraemterModel.getBuergeramtList()) {
			        text.append(buergeramt.gibBuergeramtZurueck(' ')).append("\n");
			}
			   this.txtAnzeigeBuergeraemter.setText(text.toString());
		   }
		else{
			zeigeInformationsfensterAn(
				"Bisher wurde kein Bürgeramt aufgenommen!");
		}
}	
	
public void zeigeSporthalleAn() {
	
	try {
		sporthalleModel.leseSporthallenAusCsvDatei();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if (sporthalleModel.getsporthallenList().size()>0) {
	StringBuffer text = new StringBuffer();

	for (Sporthalle sporthalle : sporthalleModel.getsporthallenList()) {
	text.append(sporthalle.gibSporthallenZurueck(' ')).append("\n");
	}
	this.txtAnzeigeSporthalle.setText(text.toString());
	} else {
	zeigeInformationsfensterAn("Bisher wurde kein Sporthallen aufgenommen!");
	}
	
}


private void zeigeInformationsfensterAn(String meldung){
	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
}	

}
