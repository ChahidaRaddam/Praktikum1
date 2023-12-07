package main;

import gui.buergeramter.BuergeraemetControl;
import gui.buergeramter.BuergeraemterView;
import guiStaetdtischeEinrichtungen.StaedtischeEinrichtungenControl;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemetControl(primaryStage);
		Stage fensterStaedtischeEinrichtungen = new Stage();
		new StaedtischeEinrichtungenControl(fensterStaedtischeEinrichtungen);
		}

	public static void main(String[] args){
		launch(args);
		}
	}

