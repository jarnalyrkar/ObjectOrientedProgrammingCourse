
public class DatoTest {
	public static void main(String[] args) {
		Dato d1 = new Dato(15, 9, 1989);
		Dato d2 = new Dato("15.9.1989");
		
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		System.out.println(d1.erLik(d2));
		System.out.println(d1.før(d2));
	}
}
