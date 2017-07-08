package no.hit.kart;

public class Hendelse {
	private final String SEPERATOR = ";";
	private Dato dato;
	private Punkt punkt;
	private String beskrivelse;

	public Hendelse(Dato dato, String beskrivelse, Punkt punkt) {
		this.dato = dato;
		this.beskrivelse = beskrivelse;
		this.punkt = punkt;
	}

	public Hendelse(String rad) {
		String[] tab = rad.split(SEPERATOR);
		this.dato = new Dato(tab[0]);
		int x = Integer.parseInt(tab[1]);
		int y = Integer.parseInt(tab[2]);
		this.punkt = new Punkt(x, y);
		this.beskrivelse = tab[3];
	}

	@Override
	public String toString() {
		return this.dato.toString() + " (" + this.punkt.getX() + ", " + this.punkt.getY() + ") " + this.beskrivelse;
	}

	public Dato getDato() {
		return dato;
	}

	public void setDato(Dato dato) {
		this.dato = dato;
	}

	public Punkt getPunkt() {
		return punkt;
	}

	public void setPunkt(Punkt punkt) {
		this.punkt = punkt;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
}
