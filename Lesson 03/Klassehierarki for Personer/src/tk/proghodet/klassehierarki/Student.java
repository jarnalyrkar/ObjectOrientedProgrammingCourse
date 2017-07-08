package tk.proghodet.klassehierarki;

public class Student extends Person {
	private String studium;
	private Dato opptaks≈r;
	private int studiePoeng;

	public Student (String FNr, String Fornavn, String Etternavn, String studium) {
		super(FNr, Fornavn, Etternavn);
		this.studium = studium;
		this.opptaks≈r = opptaks≈r;
		this.studiePoeng = studiePoeng;
		
}
}
