package business;

import java.io.*;

import fabrik.*;

public class BuergeraemterModel{

	private Buergeramt buergeramt;
	
	
	public Buergeramt getBuergeramt() {
		return buergeramt;
	}


	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
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
}
