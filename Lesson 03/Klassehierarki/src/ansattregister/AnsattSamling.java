package ansattregister;

public class AnsattSamling {

	private Ansatt[] tabell;
	private int nesteLedige;
	
	public AnsattSamling(int lengde) {
		tabell = new Ansatt[lengde];
		nesteLedige = 0;
	}

	@Override
	public String toString() {
		String ut = "";
		for (int i=0; i<nesteLedige;i++)
			ut += tabell[i]+"\n";
			
		return ut;
	}

	public void nyAnsatt(Ansatt a) {
		if (nesteLedige < tabell.length) {
			tabell[nesteLedige] = a;
			nesteLedige++;
		}
		
	}

//	private int finnPos(int ansNr) {
//		boolean funnet = false;
//		int pos = 0;
//		while (pos < nesteLedige && !funnet) {
//			if (tabell[pos].getAnsNr() == ansNr)
//				funnet = true;
//			else
//				pos++;
//		}
//		if (funnet)
//			return pos;
//		else
//			return -1;
//	}

}
