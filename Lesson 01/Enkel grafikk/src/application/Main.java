package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Main extends Application {
	
	private final int WIDTH = 50;
	private int yaxis = 200;
	private int xaxis = 20;
	private final Font TAHOMA = new Font("Tahoma", 12);
	
	private int[] array = {100, 50, 70, 30, 90};
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Title");
			Group root = new Group();
			Canvas canvas = new Canvas(400, 400);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			drawDiagram(gc, array);
			drawNumbers(gc, array);
			root.getChildren().add(canvas);
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void drawDiagram(GraphicsContext gc, int[] tallserie) {
		int x = xaxis;
		int y = yaxis;
		for (int i = 0; i < tallserie.length; i++) {
			gc.setFill(Color.LIGHTSALMON);
			gc.fillRect(x, y - tallserie[i], WIDTH, tallserie[i]);
			x += 80;
		}
	}
	
	public void drawNumbers(GraphicsContext gc, int[] tallserie) {
		gc.setFill(Color.BLACK);
		gc.setFont(TAHOMA);
		String[] array = new String[tallserie.length];
		
		for (int i = 0; i<tallserie.length; i++)
			array[i] = "    " + tallserie[i];
		
		int y = yaxis+20;
		int x = xaxis;
		
		for (int i = 0; i < tallserie.length; i++){
			gc.fillText(array[i], x, y);
			x+=80;
		}	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
