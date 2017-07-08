
// Modellen
public class Kalkulator {

	private int tall;
	private int forrige;
	private char oper;
	
	void siffer(int i) {
		forrige = tall;
		tall = i;
	}

	void oper(char c) {
		oper = c;
	}

	String erLik() {
		if (oper == '+') {
			tall = tall + forrige;
		} else if (oper == '-')
			tall = tall - forrige;
		return Integer.toString(tall);
	}

	
	
}
