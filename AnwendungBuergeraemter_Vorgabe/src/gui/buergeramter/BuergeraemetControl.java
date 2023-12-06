package gui.buergeramter;

import java.io.IOException;

import business.BuergeraemterModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BuergeraemetControl implements Observer {
	
	private BuergeraemterView buergeraemterView;
	private BuergeraemterModel buergeraemterModel;

 
    public BuergeraemetControl(Stage primaryStage){
    	this.buergeraemterModel = BuergeraemterModel.getInstance();
    	this.buergeraemterView = new BuergeraemterView(this, primaryStage,buergeraemterModel);
		buergeraemterModel.addObserver(this); 

    	}
	
	public void schreibeBuergeraemterInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				buergeraemterModel.schreibeBuergeraemterInCsvDatei();
				buergeraemterView.zeigeInformationsfensterAn("Die B�rger�mter wurden gespeichert!");
			}
			else if("txt".equals(typ)) {
				buergeraemterModel.schreibeBuergeraemterInTxtDatei();
				buergeraemterView.zeigeInformationsfensterAn("Die B�rger�mter wurden gespeichert!");
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

	@Override
	public void update() {
		buergeraemterView.zeigeBuergeraemterAn();
	}

}
