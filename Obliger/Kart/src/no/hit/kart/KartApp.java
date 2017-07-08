/*	KartApp, viser et kart med "points of interest", 
 * 	og lar bruker oppgi koordinater for å se info om punktene.
 * 
 */

package no.hit.kart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KartApp extends Application {

	private final double WIDTH = 736.0;
	private final double HEIGHT = 538.0;
	private final String IMG = "/img/kart.png";
	private final String TXT = "/txt/hendelser.txt";
	private final Color SPOT = Color.BLUE;
	private final Color X = Color.RED;
	private final Font FONT = new Font("Tahoma", 22.0);
	private final Color f = Color.GHOSTWHITE;
	public int x;
	public int y;
	private Hendelse[] eventTab;

	@Override
	public void start(Stage primaryStage) {

		StackPane layout = new StackPane();
		Scene scene = new Scene(layout, WIDTH, HEIGHT);

		Image bilde = new Image(IMG);
		ImageView bildenode = new ImageView();
		bildenode.setImage(bilde);
		layout.getChildren().add(bildenode);

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		layout.getChildren().add(canvas);

		primaryStage.setTitle("KartApp");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

		readEvents();
		showEvents(canvas);

		x = Integer.parseInt(no.hit.kart.Dialog.userInput(("Enter X-coordinate: ")));
		y = Integer.parseInt(no.hit.kart.Dialog.userInput(("Enter Y-coordinate: ")));
		Punkt finder = new Punkt(x, y);
		Hendelse proximity = eventFinder(finder);
		drawX(canvas, finder, this.X);

		// kun til test:
		// System.out.println(finder.toString());
		// System.out.println(proximity.getPunkt());
		// System.out.println(finder.distance(proximity.getPunkt()));
		// drawX(canvas, proximity.getPunkt(), this.X);

		if (finder.distance(proximity.getPunkt()) < 20) {
			drawSpot(canvas, proximity.getPunkt(), this.X);
			showEventTXT(canvas, proximity.getBeskrivelse() + "" + proximity.getDato());
		} else {
			showEventTXT(canvas, "You're way off!");
		}

	}

	// Leser fra fil
	private void readEvents() {
		try {
			InputStream in = getClass().getResourceAsStream(TXT);
			BufferedReader file = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String line = file.readLine();
			int qtyLine = Integer.parseInt(line);
			this.eventTab = new Hendelse[qtyLine];
			int pos = 0;
			line = file.readLine();
			while (line != null) {
				Hendelse newEvent = new Hendelse(line);
				this.eventTab[(pos++)] = newEvent;
				line = file.readLine();
			}
			file.close();
		} catch (IOException e) {
			System.err.println("Finner ikke fil");
		}
	}

	// Metode for å sjekke om input er lik punkt i eventTab
	private Hendelse eventFinder(Punkt punkt) {
		int pos = 0;
		int closest = Integer.MAX_VALUE;
		for (int i = 0; i < this.eventTab.length; i++) {
			Punkt p = this.eventTab[i].getPunkt();
			int distance = p.distance(punkt);
			if (distance < closest) {
				pos = i;
				closest = distance;
			}
		}
		return this.eventTab[pos];
	}

	// Skriver ut tekst fra tekstdokument til canvas
	private void showEventTXT(Canvas canvas, String txt) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(f);
		gc.setFont(FONT);
		gc.fillText(txt, this.x + 10.0, this.y + 5.0);
	}

	// tegner alle events til kartet
	private void showEvents(Canvas canvas) {
		for (Hendelse event : this.eventTab) {
			drawSpot(canvas, event.getPunkt(), this.SPOT);
		}
	}

	// metode for å tegne runding til canvas på et Punkt, med fargen Color.
	private void drawSpot(Canvas canvas, Punkt p, Color c) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(c);
		gc.fillOval(p.getX(), p.getY(), 13.0, 13.0);
	}

	// metode for å tegne kryss til canvas på et Punkt, med fargen Color.
	private void drawX(Canvas canvas, Punkt p, Color c) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(c);
		gc.setStroke(c);
		gc.setLineWidth(2.0);
		gc.strokeLine(p.getX() - 15, p.getY() - 15, p.getX() + 15, p.getY() + 15);
		gc.strokeLine(p.getX() - 15, p.getY() + 15, p.getX() + 15, p.getY() - 15);
	}

	// Kjører applikasjonen
	public static void main(String[] args) {
		launch(args);
	}
}