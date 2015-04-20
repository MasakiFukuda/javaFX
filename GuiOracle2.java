import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class GuiOracle2 extends Application{
	Connection con;
	Statement st;
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage)throws Exception{
		TextField field = new TextField();
		Label lb = new Label("�ڑ�����Ă��܂���");
		Button bt1 = new Button("Oracle�ɐڑ�");
		Button bt2 = new Button("DML�����s");
		Button bt3 = new Button("Commit");
		Button bt4 = new Button("RollBack");
		Button bt5 = new Button("Oracle����ؒf");
		
		bt1.setOnAction((ActionEvent)->{
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				
				lb.setText("�ڑ�����");
			}catch(ClassNotFoundException e){
			}catch(SQLException e){}
			
		});
		
		bt2.setOnAction((ActionEvent)->{
			try{
				st = con.createStatement();
				int count = st.executeUpdate(field.getText());
				lb.setText(count+"���������܂���");
			}catch(SQLException e){}
		});
		
		bt3.setOnAction((ActionEvent)->{
			try{
				con.commit();
				lb.setText("�R�~�b�g���܂���");
			}catch(SQLException e){}
		});
		
		bt4.setOnAction((ActionEvent)->{
			try{
				con.rollback();
				lb.setText("���[���o�b�N���܂���");
			}catch(SQLException e){}
		});
		
		bt5.setOnAction((ActionEvent)->{
			try{
				st.close();
				con.close();
				lb.setText("Oracle����ؒf���܂���");
			}catch(SQLException e){}
		});
		
		FlowPane fp1 = new FlowPane();
		fp1.getChildren().add(field);
		fp1.getChildren().add(bt2);
		
		FlowPane fp2 = new FlowPane();
		fp2.getChildren().add(bt3);
		fp2.getChildren().add(bt4);
		fp2.getChildren().add(bt1);
		fp2.getChildren().add(bt5);
		
		BorderPane bp = new BorderPane();
		
		bp.setTop(lb);
		bp.setCenter(fp1);
		bp.setBottom(fp2);
		
		Scene sc = new Scene(bp,500,200);
		
		stage.setScene(sc);
		
		stage.show();
	}
}
