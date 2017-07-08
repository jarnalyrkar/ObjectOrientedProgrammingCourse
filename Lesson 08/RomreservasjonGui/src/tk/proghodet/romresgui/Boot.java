package tk.proghodet.romresgui;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Boot extends Application {



	private TextField txtRomkode;
	private TextField txtDato;
	private TextField txtFra;
	private TextField txtTil;
	private TextField txtKontakt;
	private Button btnNy;
	
	
	// Etter hvert
	//private ArrayList<Reservasjon> resListe = new ArrayList<>();
	
	
	@Override
	public void start(Stage primaryStage) {
		// lesFraFil();
		
		GridPane pane = new GridPane();
		
		// Lager GUI-komponenter
			
			txtRomkode = new TextField();
			txtDato = new TextField();
			txtFra = new TextField();
			txtTil = new TextField();
			txtKontakt = new TextField();
			btnNy = new Button("Ny reservasjon");
			
			pane.setAlignment(Pos.CENTER);
			pane.setHgap(5.5);
			pane.setVgap(5.5);
			pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	
		// Legger til gui-komponenter i vinduet
			pane.add(new Label("Romkode"), 0, 0);
			pane.add(txtRomkode, 1, 0);
			pane.add(new Label("Dato"), 0, 1);
			pane.add(txtDato, 1, 1);
			pane.add(new Label("Fra"), 0, 2);
			pane.add(txtFra, 1, 2);
			pane.add(new Label("Til"), 0, 3);
			pane.add(txtTil, 1, 3);
			pane.add(new Label("Kontakt"), 0, 4);
			pane.add(txtKontakt, 1, 4);
			pane.add(btnNy, 0, 5);
			
			// Lytte på GUI-komponenter
			KnappeLytter lytter = new KnappeLytter();
			btnNy.setOnAction(lytter);
			
			GridPane.setHalignment(btnNy, HPos.RIGHT);
			
			//	Viser frem vinduet
			Scene scene = new Scene(pane);
			primaryStage.setTitle("Hello World");	
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	class KnappeLytter implements EventHandler<ActionEvent>{
		public KnappeLytter() {
			
		}

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Ny reservasjon legges inn...");
		}
	}
	
}
