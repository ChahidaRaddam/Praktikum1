package main;

import gui.StaedtischeEinrichtungen.StaedtischeEinrichtungenControl;
import gui.buergeramter.BuergeraemetControl;
import gui.buergeramter.BuergeraemterView;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemetControl(primaryStage);
		Stage stEinrichtungStage = new Stage();
		new StaedtischeEinrichtungenControl(stEinrichtungStage);
		//kommentar 
		}

	public static void main(String[] args){
		launch(args);
		}
	}

