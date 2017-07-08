package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class HendelseDemo extends Application implements EventHandler<ActionEvent> {
	
	
	@Override
	public void start(Stage primaryStage) {
			FlowPane root = new FlowPane();
			
			// med egen lytteklasse
			Button btnHilsen1 = new Button("Knapp 1");
			// oppretting uten objektvariabel
			btnHilsen1.setOnAction(new KnappeLytter());
			
			// med indre lytteklasse
			Button btnHilsen2 = new Button("Knapp 2");
			// to-stegs oppretting
			IndreKnappeLytter lytter2 = new IndreKnappeLytter();
			btnHilsen2.setOnAction(lytter2);
			
			// La GUI-klasse selv lytte
			Button btnHilsen3 = new Button("Knapp 3");
			btnHilsen3.setOnAction(this);
			
			// Med anonym indre lytteklasse
			Button btnHilsen4 = new Button("Knapp 4");
			btnHilsen4.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("Knapp 4");
				}
				
			});
			
			// Med lambda-uttrykk
			Button btnHilsen5 = new Button("Knapp 5");
			btnHilsen5.setOnAction(event -> {
				root.getChildren().add(btnHilsen4);
			});
			
			Button btnHilsen6 = new Button("Knapp 6");
			btnHilsen6.setOnAction(event -> {
				System.out.println("Knapp 6");
			});
			
			Scene scene = new Scene(root,300,250);
			Canvas c = new Canvas(300,250);
			
			
			root.getChildren().add(c);
			Rectangle r = new Rectangle();
			
			Color black = new Color(0,0,0,0);
			r.setFill(black);
			
			root.getChildren().add(r);
			root.getChildren().addAll(btnHilsen1, btnHilsen2, 
					btnHilsen3, btnHilsen5, btnHilsen6);
			
			primaryStage.setTitle("Hello World!");
			primaryStage.setScene(scene);
			primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void handle(ActionEvent event) {
		System.out.println("Knapp 3");
	}
	
class IndreKnappeLytter implements EventHandler<ActionEvent> {

		public IndreKnappeLytter() {
			
		}
		 
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Knapp 2");
		}

	}




}
