package guiStaetdtischeEinrichtungen;

import business.BuergeraemterModel;
import business.sporthalle.SporthalleModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer {

	private BuergeraemterModel buergeraemterModel;
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	
	private SporthalleModel sporthalleModel;
	
	public StaedtischeEinrichtungenControl(Stage primaryStage) {
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.sporthalleModel = sporthalleModel.getInstance();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(this,primaryStage, buergeraemterModel , sporthalleModel);
		buergeraemterModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();
	}
	

}
