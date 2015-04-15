import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;

public class guiTest5 extends Application{
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage)throws Exception{
		Slider slider = new Slider(0,100,50);
		
		Label lb = new Label();
		Button bt = new Button("’l‚ðŽæ“¾");
		
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		
		slider.setSnapToTicks(false);
		
		bt.setOnAction((ActionEvent)->{
			lb.setText("Value : " + slider.getValue());
		});
		
		BorderPane bp = new BorderPane();
		bp.setTop(lb);
		bp.setCenter(slider);
		bp.setBottom(bt);
		
		Scene scene = new Scene(bp,320,160);
		
		stage.setScene(scene);
		stage.show();
	}
}