
public class EnkelKalkDemo {
	
	private Kalkulator K = new Kalkulator();
	
	public EnkelKalkDemo() {
		K.siffer(2);
		K.oper('+');
		K.siffer(3);
		System.out.println(K.erLik());			
	}
	
	public static void main(String[] args) {
		EnkelKalkDemo demo = new EnkelKalkDemo();
	}

}
