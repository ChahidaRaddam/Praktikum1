package gui.StaedtischeEinrichtungen;

import business.BuergeraemterModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer{

	private StaedtischeEinrichtungenView stView;
	private BuergeraemterModel brModel;
	
	public StaedtischeEinrichtungenControl(Stage stage) {
		this.brModel = BuergeraemterModel.getInstance();
		this.stView = new StaedtischeEinrichtungenView(this, stage, brModel);
		brModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		stView.zeigeBuergeraemterAn();
	}
	
	
}
