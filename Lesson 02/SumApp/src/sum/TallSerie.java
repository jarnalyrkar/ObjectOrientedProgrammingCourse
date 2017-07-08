package sum;

public class TallSerie {
	
	// Objektvariabel for � ta vare p�
	// serien med heltall.
	private int[] tall;
	private int nesteLedige;

	// Du vil ogs� trenge en variabel for �
	// skille mellom fysisk og logisk tabell.

	public TallSerie(int max) {
	// Opprett tabell med plass til max verdier.
		tall = new int[max];
		nesteLedige = 0;
		
	}

	public void nyVerdi(int verdi) {
		// Legg inn en ny verdi i listen (hvis mulig).
		if (nesteLedige < tall.length) {
			tall[nesteLedige] = verdi;
			nesteLedige++;
		}
	}

	public int antallVerdier() {
	// Returnerer antall verdier i listen.
		int antall = 0;
		for (int i=0; i<nesteLedige;i++)
			antall++;
	// TODO: Dummy-kode
		return antall;
	}

	public int sum() {
	// Returnerer summen av verdiene i listen.
		int sum = 0;
		for (int i=0; i<nesteLedige;i++){
			sum += tall[i];
		}
	// TODO: Dummy-kode
		return sum;
	}

	public void angre() {
	// Angrer sist registrerte verdi fra listen.
		if (nesteLedige > 0)
			nesteLedige--;
	}
}