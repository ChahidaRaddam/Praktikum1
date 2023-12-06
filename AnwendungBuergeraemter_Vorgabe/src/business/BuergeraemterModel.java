package business;

import java.io.*;
import ownUtil.*;
import fabrik.*;

import java.util.LinkedList;

public class BuergeraemterModel{

	private Buergeramt buergeramt;
	

	public Buergeramt getBuergeramt() {
		return buergeramt;
	}


	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
	}


	public void schreibeBuergeraemterInCsvDatei() throws IOException{
		
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

}
