package business.sporthalle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import business.BuergeraemterModel;
import business.Buergeramt;
import fabrik.ConcreteCreator;
import fabrik.ConcreteTxtCreator;
import fabrik.Creator;
import fabrik.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class SporthalleModel implements Observable{

	LinkedList<Observer> liste = new LinkedList<Observer>();
	ArrayList<Sporthalle> sporthallenList = new ArrayList<>();
	
	//private Buergeramt buergeramt;
	
	private static SporthalleModel instance = null;
	
	private SporthalleModel() {
	}

	public static SporthalleModel getInstance() {
		if(instance == null)
			instance = new SporthalleModel();
		return instance;
	}
	
	public ArrayList<Sporthalle> getsporthallenList() {
		return this.sporthallenList;
	}


	public void addSporthalle(Sporthalle sporthalle) {
		this.sporthallenList.add(sporthalle);
		notifyObservers();
	}


//	public void schreibeBuergeraemterInCsvDatei() throws IOException{
//		
//		Creator cr = new ConcreteCreator();
//		Product writer = cr.factoryMethod();
//	
//		for(Sporthalle ba : this.sporthallenList) {
//		writer.fuegeInDateiHinzu(ba);
//		}
//		writer.schliesseDatei();
//		
//		}
//	
//	public void schreibeBuergeraemterInTxtDatei() throws IOException{
//		
//	Creator cr = new ConcreteTxtCreator();
//	Product writer = cr.factoryMethod();
//
//	for(Sporthalle ba : this.sporthallenList) {
//	writer.fuegeInDateiHinzu(ba);
//	}
//	writer.schliesseDatei();
//	
//    }
	
	public void leseSporthallenAusCsvDatei() 
		throws IOException{
			BufferedReader ein = new BufferedReader( new FileReader("sporthalle.csv"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>();
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
				ergebnis.add(new Sporthalle(zeile[0],Integer.parseInt(zeile[1]),zeile[2]));
				zeileStr = ein.readLine();
		}
			ein.close();
			this.sporthallenList = ergebnis;
	}

	@Override
	public void addObserver( Observer obs) {
		liste.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		liste.remove(obs);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer o:liste) {
			o.update();
		}
	}

	
}
