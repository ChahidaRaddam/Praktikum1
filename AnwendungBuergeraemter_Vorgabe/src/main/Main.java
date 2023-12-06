package main;

import gui.buergeramter.BuergeraemetControl;
import gui.buergeramter.BuergeraemterView;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemetControl(primaryStage);
		}

	public static void main(String[] args){
		launch(args);
		}
	}

