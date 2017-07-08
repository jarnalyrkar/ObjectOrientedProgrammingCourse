package no.usn.romres;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

public class Dialog {

	public static String userInput(String i) {
		String input = "";
		TextInputDialog d = new TextInputDialog();
		d.setTitle("Input");
		d.setHeaderText(i);
		Optional<String> result = d.showAndWait();
		input = (String) result.get();
		return input;
	}

	public static void displayTxt(String t) {
		Alert a = new Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
		a.setTitle("Melding");
		a.setContentText(t);
		a.showAndWait();

	}
}