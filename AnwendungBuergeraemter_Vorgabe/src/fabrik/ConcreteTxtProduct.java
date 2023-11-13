package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteTxtProduct extends Product {


	BufferedWriter writer;
	
	public ConcreteTxtProduct() throws IOException {
		writer = new BufferedWriter(new FileWriter("buergeramt.txt"));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {

		Buergeramt bra = (Buergeramt) object;
		String infoText = "Daten des Burgeramts\nName des Burgeramts: \t\t"+bra.getName()+
				"\nOffnungszeit des Burgeramts: \t"+bra.getGeoeffnetVon()+" - "+bra.getGeoeffnetBis()+
				"\nStrasse ind hausnummer des Burgeramts: "+bra.getStrasseHNr()+
				"\nDienstleistungen des Burgeramts:\t"+bra.getDienstleistungen();
		
		writer.write(infoText);
		
	}

	@Override
	public void schliesseDatei() throws IOException {

		writer.flush();
		writer.close();
	}

}
