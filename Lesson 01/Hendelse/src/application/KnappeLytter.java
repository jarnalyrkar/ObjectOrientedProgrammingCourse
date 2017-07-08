package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

class KnappeLytter implements EventHandler<ActionEvent> {

	public KnappeLytter() {
		
	}
	 
	@Override
	public void handle(ActionEvent event) {
		System.out.println("Knapp 1");
	}

}
