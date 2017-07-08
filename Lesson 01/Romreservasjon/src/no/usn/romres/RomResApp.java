package no.usn.romres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.stage.Stage;

public class RomResApp extends Application {

	// Deklarer tabell resTab for å ta vare på
	// et antall reservasjoner.
	public Reservasjon[] resTab = new Reservasjon[100]; // TODO-5 må byttes med
														// antLinjer i txtfil
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start (Stage primaryStage) {
		// Les inn reservasjoner fra fil til tabell resTab.
		lesFraFil();
		// Les inn ny reservasjon r fra bruker.
		Reservasjon k = lesFraBruker();
		// Legg reservasjonen r inn i tabellen resTab.
		leggInn(k);
		// Skriv reservasjonene i resTab til fil.
		skrivTilFil();
	}

	private void lesFraFil() {
		try {
			BufferedReader innfil = new BufferedReader(new FileReader("resources/txt/reservasjoner.txt"));
			String linje = innfil.readLine();
			int antall = Integer.parseInt(linje);
			resTab = new Reservasjon[antall + 1];
			int pos = 0;
			linje = innfil.readLine();
			while (linje != null) {
				Reservasjon ny = new Reservasjon(linje);
				resTab[pos++] = ny;
				linje = innfil.readLine();
			}
			innfil.close();
		} catch (IOException e) {
			System.exit(-1);
		}
	}

	private void skrivTilFil() {
		// Skriv alle reservasjoner i resTab til tekstfil (alltid samme fil).
		PrintWriter utfil = null;
		try {
			utfil = new PrintWriter(new FileWriter("resources/txt/reservasjoner.txt", false));
			utfil.println(resTab.length);
			for (int i = 0; i < resTab.length; i++) {
				utfil.println(resTab[i].toString());
			}
		} catch (IOException e) {
			System.err.println("Feil ved skriving");
			System.exit(-1);
		} finally {
			utfil.close();
		}

	}

	private Reservasjon lesFraBruker() {
		// Les inn ny reservasjon fra bruker (ved hjelp av dialogvinduer), og
		// returner denne reservasjonen.
		Reservasjon r = new Reservasjon();
		r.setRomkode(new String(Dialog.userInput("Oppgi et rom: ")));
		r.setDato(new Dato(Dialog.userInput("Oppgi en dato: ")));
		r.setStart(new KlSlett(Dialog.userInput("Fra kl: ")));
		r.setSlutt(new KlSlett(Dialog.userInput("Til kl: ")));
		r.setKontakt(new String(Dialog.userInput("Oppgi kontaktperson: ")));
		return r;
	}

	private void leggInn(Reservasjon r) {
		// Sjekk at r ikke kolliderer med eksisterende reservasjoner, og
		// sett inn r på ledig plass (bakerst) i tabellen resTab.
		boolean kollisjon = false;
		for (Reservasjon resTab1 : resTab) {
			if (resTab1 != null) {
				if (r.kolliderer(resTab1)) {
					kollisjon = true;
					String msg = "Reservasjonen kolliderer med: " + resTab1.toString();
					Dialog.displayTxt(msg);
				}
			}
		}
		if (!kollisjon && resTab[resTab.length - 1] == null) {
			resTab[resTab.length - 1] = r;
		}

	}


}