
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileNotFoundException;



public class WordOccurencFX extends Application {
	public static void main(String[] args) {
		launch(args);
		
	}
	
	@Override
	public void start(Stage window) throws Exception {
		// TODO Auto-generated method stub
		Button btn = new Button("Please Click to see Top Twenty Words");
		Label lbl1 = new Label();
		Text txt1 = new Text();
		Label lbl = new Label();
		
		window.setTitle("Edgar Allen Poe");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				WordOccurence w = new WordOccurence();
				 Map<String, Integer> words = new HashMap<String, Integer>();
			        try {
						w.countEachWords("eap.txt", words);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        //System.out.println("\n" + words + "\n");
			        lbl1.setText("Top Twenty Words");
			        
			        lbl.setText("\n" +  w.getMaxTwenty(words) + "\n");
			        
			
				//System.out.println("hello");
			}
			
		});
		
		

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		root.getChildren().add(lbl1);
		root.getChildren().add(txt1);
		root.getChildren().add(lbl);
		
		btn.setTranslateX(20);
		lbl1.setTextAlignment(TextAlignment.CENTER);
		lbl1.setPadding(new Insets(10,10,300,10));

		//txt1.setTextAlignment(TextAlignment.LEFT);
		//lbl.relocate(70,70);
		lbl.setContentDisplay(ContentDisplay.BOTTOM);
		btn.setPadding(new Insets(10, 10, 10, 10));
		lbl.setPadding(new Insets(80,10,10,10));
		Scene scene = new Scene(root,1000,700);
		window.setScene(scene);
		window.show();
	
		
	}
	

}
