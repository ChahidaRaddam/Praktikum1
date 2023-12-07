package guiStaetdtischeEinrichtungen;

import business.BuergeraemterModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer {

	private BuergeraemterModel buergeraemterModel;
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	
	public StaedtischeEinrichtungenControl(Stage primaryStage) {
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(this,primaryStage, buergeraemterModel );
		buergeraemterModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();
	}
	

}
