package tk.proghodet.klassehierarki;

public class Ansatt extends Person {
	  // Beskyttede objektvariabler for å ta vare på
	  // ansettelsesdato, stilling og lønn. Bruk
	  // hjelpeklassen Dato fra introduksjonsuken.
	    private Dato ansattDato;
		private String stilling;
		private double lønn;
		
	  // Konstruktør med passende parametre.
	   public Ansatt(String FNr, String Fornavn, String Etternavn, 
			   Dato ansattDato, String stilling, double lønn) {
		   super(FNr, Fornavn, Etternavn);
		   this.ansattDato = ansattDato;
		   this.stilling = stilling;
		   this.lønn = lønn;	   
	   }
	  
	   // Hensiktsmessige set- og get-metoder.
	public Dato getAnsattDato() {
		return ansattDato;
	}

	public void setAnsattDato(Dato ansattDato) {
		this.ansattDato = ansattDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public double getLønn() {
		return lønn;
	}

	public void setLønn(double lønn) {
		this.lønn = lønn;
	}
	
	// Overstyre noen metoder (toString og/eller equals)?
	@Override
	public String toString() {
		return "Ansatt [ansattDato=" + ansattDato + ", stilling=" + stilling + ", lønn=" + lønn + "]";
	}
	   
	   
	  
	}