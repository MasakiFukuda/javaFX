import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class GuiOracle extends Application{
	Connection con;
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage)throws Exception{
		
		Label lb = new Label("ê⁄ë±Ç≥ÇÍÇƒÇ¢Ç‹ÇπÇÒ");
		Button bt1 = new Button("OracleÇ…ê⁄ë±");
		Button bt2 = new Button("OracleÇ©ÇÁêÿíf");
		
		
		
		bt1.setOnAction((ActionEvent)->{
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				lb.setText("ê⁄ë±íÜ");
			}catch(ClassNotFoundException e){
			}catch(SQLException e){}
		});
		
		bt2.setOnAction((ActionEvent)->{
			try{
				con.close();
				lb.setText("êÿífÇµÇ‹ÇµÇΩ");
			}catch(SQLException e){}
		});
		
		FlowPane fp = new FlowPane();
		fp.getChildren().add(bt1);
		fp.getChildren().add(bt2);
		
		BorderPane bp = new BorderPane();
		bp.setTop(lb);
		bp.setCenter(fp);
		
		Scene sc = new Scene(bp,320,80);
		stage.setScene(sc);
		stage.show();
	}
}
