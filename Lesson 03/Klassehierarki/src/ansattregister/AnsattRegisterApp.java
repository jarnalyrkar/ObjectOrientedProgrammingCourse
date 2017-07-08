package ansattregister;

public class AnsattRegisterApp {

	public static void main(String[] args) {
		AnsattSamling ansatte = new AnsattSamling(10);
		
		Ansatt a = new Ansatt(1, "Per");
		ansatte.nyAnsatt(a);
		a = new Ansatt(2, "Kari");
		ansatte.nyAnsatt(a);
		System.out.println(ansatte.toString());
	}

}
