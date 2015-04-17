import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;


public class guiTest extends Application{
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage)throws Exception{
		Label label = new Label("This is javaFX");
		Label label2 = new Label("GUIのテスト");
		
		FlowPane fp = new FlowPane();
		
		fp.getChildren().add(label);
		fp.getChildren().add(label2);
		
		Scene scene = new Scene(fp,320,240);
		stage.setScene(scene);
		
		stage.show();
	}
}

//テステス