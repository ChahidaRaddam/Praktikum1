package business;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

import ownUtil.*;
import fabrik.*;

public class BuergeraemterModel implements Observable{
	
	LinkedList<Observer> liste = new LinkedList<Observer>();
	ArrayList<Buergeramt> buergeramtList = new ArrayList<>();
	
	//private Buergeramt buergeramt;
	
	private static BuergeraemterModel instance = null;
	
	private BuergeraemterModel() {
		
	}

	public static BuergeraemterModel getInstance() {
		if(instance == null)
			instance = new BuergeraemterModel();
		return instance;
	}
	
	public ArrayList<Buergeramt> getBuergeramtList() {
		return this.buergeramtList;
	}


	public void addBuergeramt(Buergeramt buergeramt) {
		this.buergeramtList.add(buergeramt);
		notifyObservers();
	}


	public void schreibeBuergeraemterInCsvDatei() throws IOException{
		
		Creator cr = new ConcreteCreator();
		Product writer = cr.factoryMethod();
	
		for(Buergeramt ba : this.buergeramtList) {
		writer.fuegeInDateiHinzu(ba);
		}
		writer.schliesseDatei();
		
		}
	
	public void schreibeBuergeraemterInTxtDatei() throws IOException{
	Creator cr = new ConcreteTxtCreator();
	Product writer = cr.factoryMethod();

	for(Buergeramt ba : this.buergeramtList) {
	writer.fuegeInDateiHinzu(ba);
	}
	writer.schliesseDatei();
	
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
