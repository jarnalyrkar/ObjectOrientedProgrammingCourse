package ansattregister;

public class Ansatt {
	private int ansNr;
	private String fornavn;
	
	
	public Ansatt(int ansNr, String fornavn) {
		this.ansNr = ansNr;
		this.fornavn = fornavn;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ansNr;
		result = prime * result + ((fornavn == null) ? 0 : fornavn.hashCode());
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
		Ansatt other = (Ansatt) obj;
		if (ansNr != other.ansNr)
			return false;
		if (fornavn == null) {
			if (other.fornavn != null)
				return false;
		} else if (!fornavn.equals(other.fornavn))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Ansatt [ansNr=" + ansNr + ", fornavn=" + fornavn + "]";
	}


	public int getAnsNr() {
		return ansNr;
	}


	public void setAnsNr(int ansNr) {
		this.ansNr = ansNr;
	}


	public String getFornavn() {
		return fornavn;
	}


	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
}
