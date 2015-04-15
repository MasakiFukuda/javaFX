import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class guiTest2 extends Application{
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage)throws Exception{
		Label lb = new Label("GUIのテスト");
		TextField field = new TextField();
		Button bt = new Button("クリック");
		
		//ラムダ式での記述
		bt.setOnAction((ActionEvent ae)->{
			String msg = "your typed:"+field.getText();
			lb.setText(msg);
		});
		
		/*
		bt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				String msg = "your typed:"+field.getText();
				lb.setText(msg);
			}
		});
		
		*/
		BorderPane bp = new BorderPane();
		bp.setTop(lb);
		bp.setCenter(field);
		bp.setBottom(bt);
		
		Scene scene = new Scene(bp,320,120);
		stage.setScene(scene);
		
		stage.show();
	}
}