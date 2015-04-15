import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;

public class guiTest3 extends Application{
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage) throws Exception{
		Label lb = new Label("Test");
		
		RadioButton radio1 = new RadioButton("Aのテキスト");
		RadioButton radio2 = new RadioButton("Bのテキスト");
		
		ToggleGroup group1 = new ToggleGroup();
		
		radio1.setToggleGroup(group1);
		radio2.setToggleGroup(group1);
		
		Button bt = new Button("クリック");
		
		bt.setOnAction((ActionEvent)->{
			if(radio1.isSelected()){
				lb.setText("select :"+radio1.getText());
			}else if(radio2.isSelected()){
				lb.setText("select :"+radio2.getText());
			}else{
				lb.setText("Test");
			}
		});
		
		FlowPane fp = new FlowPane();
		
		fp.getChildren().add(radio1);
		fp.getChildren().add(radio2);
		
		BorderPane bp = new BorderPane();
		bp.setTop(lb);
		bp.setCenter(fp);
		bp.setBottom(bt);
		
		Scene scene = new Scene(bp,320,180);
		
		stage.setScene(scene);
		stage.show();
	}
}