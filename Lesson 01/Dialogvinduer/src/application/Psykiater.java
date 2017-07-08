package application;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

public class Psykiater {
	// Hjelpemetoder

	// Bestemmer svar
	public String answer(String question) {
		question = question.toLowerCase();
		String answer = "";
		if (!question.isEmpty()) {
			if (question.contains("ingen"))
				answer = "Ingen? Det var da negativt. Kan du utdype?";
			else if (question.contains("umulig"))
				answer = "Umulig? Det var da negativt. Kan du utdype?";
			else if (question.contains("jeg"))
				answer = question.replace("jeg", "du") + " - hvorfor?";
			else if (question.contains("meg"))
				answer = question.replace("meg", "deg") + " - hvorfor?";
			else if (question.contains("min"))
				answer = question.replace("min", "din") + " - hvorfor?";
			else
				answer = "Jeg forstår ikke, kan du utdype?";
		}
		return answer;
	}

	// Viser dialogvindu, og henter string fra bruker
	public Optional<String> userInput() {
		TextInputDialog dialog;
		Optional<String> result;
		dialog = new TextInputDialog("");
		dialog.setTitle("Eliza, Computer Therapist");
		dialog.setHeaderText("Fortell hva du har på hjertet");
		dialog.setContentText("Spørsmål: ");
		result = dialog.showAndWait();
		return result;
	}

	// Viser dialogvindu med svar
	public void svarTekst(String svar) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Eliza, Computer Therapist");
		alert.setHeaderText("Eliza svarer: ");
		alert.setContentText(svar);
		alert.showAndWait();
	}
}
