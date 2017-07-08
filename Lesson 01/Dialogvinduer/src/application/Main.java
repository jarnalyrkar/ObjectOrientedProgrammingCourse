package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private boolean fortsett = true;
	private Psykiater psykiater = new Psykiater();
	private String question;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		do {
			question = psykiater.userInput().get();
			if (question.length() == 0)
				fortsett = false;
			else psykiater.svarTekst(psykiater.answer(question));
		} while (fortsett);
	}	catch (RuntimeException ex) {
			System.out.println("exit code 1");
	}
	}

	public static void main(String[] args) {
		launch(args);
	}
}