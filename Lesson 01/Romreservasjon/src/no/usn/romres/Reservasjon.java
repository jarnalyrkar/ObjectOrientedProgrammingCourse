package no.usn.romres;

public class Reservasjon {
	String romkode;
	Dato dato;
	KlSlett start;
	KlSlett slutt;
	String kontakt;

	public Reservasjon(String romkode, Dato dato, KlSlett start, KlSlett slutt, String kontakt) {
		this.romkode = romkode;
		this.dato = dato;
		this.start = start;
		this.slutt = slutt;
		this.kontakt = kontakt;
	}

	public Reservasjon(String rad) {
		String[] tab = rad.split(";");
		this.romkode = tab[0];
		this.dato = new Dato(tab[1]);
		this.start = new KlSlett(tab[2]);
		this.slutt = new KlSlett(tab[3]);
		this.kontakt = tab[4];
	}

	public Reservasjon() {
		this.romkode = null;
		this.dato = null;
		this.start = null;
		this.slutt = null;
		this.kontakt = null;
	}

	public boolean kolliderer(Reservasjon r) {
		boolean kolliderer = true;
		if ((!dato.erLik(r.dato))
				|| (!romkode.equals(r.romkode))
				|| (!slutt.før(r.start) || r.slutt.før(start))) {
					kolliderer = false;
				}
				
			return kolliderer;
	}

	public String getRomkode() {
		return romkode;
	}

	public void setRomkode(String romkode) {
		this.romkode = romkode;
	}

	public Dato getDato() {
		return dato;
	}

	public void setDato(Dato dato) {
		this.dato = dato;
	}

	public KlSlett getStart() {
		return start;
	}

	public void setStart(KlSlett start) {
		this.start = start;
	}

	public KlSlett getSlutt() {
		return slutt;
	}

	public void setSlutt(KlSlett slutt) {
		this.slutt = slutt;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dato == null) ? 0 : dato.hashCode());
		result = prime * result + ((kontakt == null) ? 0 : kontakt.hashCode());
		result = prime * result + ((romkode == null) ? 0 : romkode.hashCode());
		result = prime * result + ((slutt == null) ? 0 : slutt.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Reservasjon other = (Reservasjon) obj;
		if (dato == null) {
			if (other.dato != null)
				return false;
		} else if (!dato.equals(other.dato))
			return false;
		if (kontakt == null) {
			if (other.kontakt != null)
				return false;
		} else if (!kontakt.equals(other.kontakt))
			return false;
		if (romkode == null) {
			if (other.romkode != null)
				return false;
		} else if (!romkode.equals(other.romkode))
			return false;
		if (slutt == null) {
			if (other.slutt != null)
				return false;
		} else if (!slutt.equals(other.slutt))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return (romkode + ";" + dato.toString() + ";" + start.toString() + ";" + slutt.toString() + ";"
				+ kontakt);
	}

}