package tk.proghodet.grensesnitt;

public class Main {

	public static void main(String[] args) {
		Hilsen h = new Hund();
		System.out.println(h.hilsen());
		
		h = new Menneske();
		System.out.println(h.hilsen());
	}

}
