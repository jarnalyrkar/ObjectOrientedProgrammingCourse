package pacman;
	
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PacMan extends Application {
	@Override
	public void start(Stage primaryStage) {
		
			Group root = new Group();
			Scene scene = new Scene(root,800,300);
			primaryStage.setTitle("PacMan");
			primaryStage.setScene(scene);
			
			Arc pacman = new Arc(100, 200, 50, 50, 30, 300);
			pacman.setStroke(Color.BLACK);
			pacman.setFill(Color.YELLOW);
			pacman.setType(ArcType.ROUND);
			root.getChildren().add(pacman);
			
			Path sti = new Path();
			sti.getElements().add(new MoveTo(100,200));
			sti.getElements().add(new LineTo(700,200));
			PathTransition flytt = new PathTransition();
			flytt.setPath(sti);
			flytt.setNode(pacman);
			flytt.setDuration(Duration.millis(2000));
			flytt.setAutoReverse(true);
			flytt.setCycleCount(Timeline.INDEFINITE);
			
			Timeline gaping = new Timeline();
			gaping.setAutoReverse(true);
			gaping.setCycleCount(Timeline.INDEFINITE);
			KeyValue vinkel = new KeyValue(pacman.startAngleProperty(), 0);
			KeyValue bue = new KeyValue(pacman.lengthProperty(), 360);
			KeyFrame kf = new KeyFrame(Duration.millis(500), vinkel, bue);
			gaping.getKeyFrames().add(kf);
			
			ParallelTransition animasjon = new ParallelTransition();
			animasjon.getChildren().addAll(flytt, gaping);
			
			primaryStage.show();
			animasjon.play();
			
		} 
	
	public static void main(String[] args) {
		launch(args);
	}
}
