package main;

import javafx.application.Application;
import javafx.stage.Stage;
import gui.BuergeraemetControl;
import gui.BuergeraemterView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemetControl(primaryStage);
		}

	public static void main(String[] args){
		launch(args);
		}
	}