import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.scene.layout.BorderPane;

public class guiTest4 extends Application{
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage) throws Exception{
		Label lb = new Label();
		
		ObservableList<String> ol = FXCollections.observableArrayList("one","two","three");
		
		ComboBox<String> cb = new ComboBox<>(ol);
		
		Button bt = new Button("ƒNƒŠƒbƒN");
		
		bt.setOnAction((ActionEvent)->{
			lb.setText(cb.getValue());
		});
		
		BorderPane bp = new BorderPane();
		bp.setTop(lb);
		bp.setCenter(cb);
		bp.setBottom(bt);
		
		Scene scene = new Scene(bp,320,120);
		
		stage.setScene(scene);
		stage.show();
	}
}