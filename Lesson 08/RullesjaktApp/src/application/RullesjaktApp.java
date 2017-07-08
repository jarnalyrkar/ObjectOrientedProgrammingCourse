package application;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RullesjaktApp extends Application {
	
	@Override
	public void start(Stage primaryStage) {
	
		Text t = new Text(50, 50, "Hei verden!");
		ScrollBar sjakt = new ScrollBar();
		sjakt.setOrientation(Orientation.VERTICAL);
		
		Pane innhold = new Pane();
		innhold.getChildren().add(t);
		
		BorderPane root = new BorderPane();
		root.setCenter(innhold);
		root.setRight(sjakt);
		
		// Teknikk 1:
//		sjakt.valueProperty().addListener(e -> {
//			t.setY(sjakt.getValue() * innhold.getHeight() / sjakt.getMax());
//			});
		
		// Teknikk 2:
		t.yProperty().bind(sjakt.valueProperty()
					 		.multiply(innhold.heightProperty())
					 		.divide(sjakt.getMax()));
		
		Scene scene = new Scene(root, 300, 250);
		
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
