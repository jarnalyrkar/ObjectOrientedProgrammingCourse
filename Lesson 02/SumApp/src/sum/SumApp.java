package sum;

public class SumApp {
	private static final int MAX = 100;
	
	public static void main(String[] args) {
		TallSerie tallserie = new TallSerie(MAX);
		tallserie.nyVerdi(17);
		tallserie.nyVerdi(5);
		tallserie.angre();
		tallserie.nyVerdi(3);
		System.out.println("Sum: " + tallserie.sum());
		System.out.println("Antall: " + tallserie.antallVerdier());
	}

}
