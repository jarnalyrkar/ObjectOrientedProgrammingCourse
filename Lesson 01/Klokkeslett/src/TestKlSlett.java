public class TestKlSlett {
	public static void main(String[] args) {
		KlSlett k1 = new KlSlett(8, 20); // 08:15
		KlSlett k2 = new KlSlett("23:30"); // Likt som tekst
		KlSlett k3 = new KlSlett("24:30"); // Med vilje feil
		
		String forhold = "";
		if ( k1.erLik(k3) ) {
		forhold = " er lik ";
		} 
		else if ( k1.erFør(k3) ) {
 		forhold = " er før ";
		}
		else {
  		forhold = " er etter ";
		}
		
	System.out.println(k1.toString() + forhold + k3.toString());
	}
}