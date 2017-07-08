package tk.proghodet.collectionklasser;

public class Menneske implements Hilsen, Comparable<Menneske> {

	private String navn;

	public Menneske(String navn) {
		this.navn = navn;
	}

	@Override
	public String hilsen() {
			return "God dag, jeg heter " + navn + ".";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((navn == null) ? 0 : navn.hashCode());
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
		Menneske other = (Menneske) obj;
		if (navn == null) {
			if (other.navn != null)
				return false;
		} else if (!navn.equals(other.navn))
			return false;
		return true;
	}

	@Override
	public int compareTo(Menneske o) {
		return this.navn.compareTo(o.navn);
	}
	
}
