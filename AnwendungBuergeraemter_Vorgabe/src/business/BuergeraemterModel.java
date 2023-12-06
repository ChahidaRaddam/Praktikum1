package business;

import java.io.*;
import ownUtil.*;
import fabrik.*;

import java.util.LinkedList;

public class BuergeraemterModel implements Observable{

	private Buergeramt buergeramt;
	
	LinkedList<Observer> liste = new LinkedList<Observer>();

	
	private static BuergeraemterModel instance = null;
	
	private BuergeraemterModel() {
		
	}
	
	public  static BuergeraemterModel getInstance() {
		if(instance == null) {
			instance = new BuergeraemterModel();
			}
		
		return instance;
		
	}

	public Buergeramt getBuergeramt() {
		return buergeramt;
	}


	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
		notifyObserver();
	}


	public void schreibeBuergeraemterInCsvDatei() throws IOException{
			//BufferedWriter aus = new BufferedWriter(new FileWriter("Buergeraemter.csv",true));
			//aus.write(this.getBuergeramt().gibBuergeramtZurueck(';'));
			//aus.close();
		
		Creator cr = new ConcreteCreator();
		Product writer = cr.factoryMethod();
	
		
		writer.fuegeInDateiHinzu(this.buergeramt);
		writer.schliesseDatei();
		
		}
	
	public void schreibeBuergeraemterInTxtDatei() throws IOException{
	Creator cr = new ConcreteTxtCreator();
	Product writer = cr.factoryMethod();

	
	writer.fuegeInDateiHinzu(this.buergeramt);
	writer.schliesseDatei();
	
}

	@Override
	public void addObserver(Observer obs) {
		liste.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		liste.remove(obs);
	}

	@Override
	public void notifyObserver() {
		for(Observer o:liste){
			o.update();
		}
	}
}
