package gui;

import java.io.IOException;

import business.BuergeraemterModel;
import javafx.stage.Stage;

public class BuergeraemetControl {
	
	private BuergeraemterView buergeraemterView;
	private BuergeraemterModel buergeraemterModel;

 
    public BuergeraemetControl(Stage primaryStage){
    	this.buergeraemterModel = new BuergeraemterModel();
    	this.buergeraemterView = new BuergeraemterView(this, primaryStage,buergeraemterModel);
    	}
	
	public void schreibeBuergeraemterInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				buergeraemterModel.schreibeBuergeraemterInCsvDatei();
				buergeraemterView.zeigeInformationsfensterAn("Die Bürgerämter wurden gespeichert!");
			}
			else if("txt".equals(typ)) {
				buergeraemterModel.schreibeBuergeraemterInTxtDatei();
				buergeraemterView.zeigeInformationsfensterAn("Die Bürgerämter wurden gespeichert!");
			}
			else {
				buergeraemterView.zeigeInformationsfensterAn("Noch nicht implementiert!)");
			}
		}
		catch(IOException exc) {
			buergeraemterView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
			
		}
		catch(Exception exc) {
			buergeraemterView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

}
