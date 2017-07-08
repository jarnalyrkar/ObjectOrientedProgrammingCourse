package tk.proghodet.klassehierarki;

public class Ansatt extends Person {
	  // Beskyttede objektvariabler for � ta vare p�
	  // ansettelsesdato, stilling og l�nn. Bruk
	  // hjelpeklassen Dato fra introduksjonsuken.
	    private Dato ansattDato;
		private String stilling;
		private double l�nn;
		
	  // Konstrukt�r med passende parametre.
	   public Ansatt(String FNr, String Fornavn, String Etternavn, 
			   Dato ansattDato, String stilling, double l�nn) {
		   super(FNr, Fornavn, Etternavn);
		   this.ansattDato = ansattDato;
		   this.stilling = stilling;
		   this.l�nn = l�nn;	   
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

	public double getL�nn() {
		return l�nn;
	}

	public void setL�nn(double l�nn) {
		this.l�nn = l�nn;
	}
	
	// Overstyre noen metoder (toString og/eller equals)?
	@Override
	public String toString() {
		return "Ansatt [ansattDato=" + ansattDato + ", stilling=" + stilling + ", l�nn=" + l�nn + "]";
	}
	   
	   
	  
	}