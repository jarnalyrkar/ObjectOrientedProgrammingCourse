package tk.proghodet.klassehierarki;

import java.util.EmptyStackException;

public class Person {
	// Beskyttede objektvariabler for � ta vare p�
	// f�dselsnr (11 siffer), fornavn og etternavn.
	// S�rg for at disse objektvariablene er
	// tilgjengelig i subklasser, men ikke i andre klasser.
	protected String FNr;
	protected String Fornavn;
	protected String Etternavn;

	// Konstrukt�r som tar f�dselsnr, fornavn og
	// etternavn som parametre. Konstrukt�ren skal
	// kaste et unntak hvis f�dselsnr er ulovlig.
	public Person(String FNr, String Fornavn, String Etternavn) {
		this.FNr = FNr;
		this.Fornavn = Fornavn;
		this.Etternavn = Etternavn;
		
		if (FNr.length() < 11 || FNr.length() > 11)
			throw new EmptyStackException();
	}

	// Set- og get-metoder for fornavn og etternavn,
	// get-metode for f�dselsnr.
	public String getFNr() {
		return FNr;
	}

	public void setFornavn(String fornavn) {
		fornavn = Fornavn;
	}

	public String getEtternavn() {
		return Etternavn;
	}

	public void setEtternavn(String etternavn) {
		Etternavn = etternavn;
	}

	public String getFornavn() {
		return Fornavn;
	}

	// Parameterl�s char-metode kj�nn som returnerer
	// 'K' for kvinner og 'M' for menn.
	public char findSex() {
		String b = this.getFNr().substring(8, 9);
		int c = Integer.parseInt(b);
		if (c % 2 == 1)
			return 'M';
		else
			return 'F';
	}

	// Parameterl�s String-metode initialer som
	// returnerer f�rste bokstav i fornavn etterfulgt
	// av f�rste bokstav i etternavn.
	public String initialer() {
		String initialer = this.Fornavn.substring(0, 1) + this.Etternavn.substring(0, 1);
		return initialer;
	}

	// Metoder toString og equals (to Person-objekter
	// betraktes som like hvis de har samme f�dselsnr).
	@Override
	public String toString() {
		return "Person [FNr=" + FNr + ", Fornavn=" + Fornavn + ", Etternavn=" + Etternavn + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Etternavn == null) ? 0 : Etternavn.hashCode());
		result = prime * result + ((FNr == null) ? 0 : FNr.hashCode());
		result = prime * result + ((Fornavn == null) ? 0 : Fornavn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (Etternavn == null) {
			if (other.Etternavn != null)
				return false;
		} else if (!Etternavn.equals(other.Etternavn))
			return false;
		if (FNr == null) {
			if (other.FNr != null)
				return false;
		} else if (!FNr.equals(other.FNr))
			return false;
		if (Fornavn == null) {
			if (other.Fornavn != null)
				return false;
		} else if (!Fornavn.equals(other.Fornavn))
			return false;
		return true;
	}
	
	
}