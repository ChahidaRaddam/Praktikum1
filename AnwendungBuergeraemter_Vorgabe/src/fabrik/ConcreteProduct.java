package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.*;

public class ConcreteProduct extends Product{

	BufferedWriter writer;
	
	public ConcreteProduct() throws IOException {
		writer = new BufferedWriter(new FileWriter("buergeramt.csv"));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		Buergeramt bra = (Buergeramt) object;
		writer.write(bra.gibBuergeramtZurueck(','));
	}

	@Override
	public void schliesseDatei() throws IOException {
		writer.flush();
		writer.close();
	}

}
