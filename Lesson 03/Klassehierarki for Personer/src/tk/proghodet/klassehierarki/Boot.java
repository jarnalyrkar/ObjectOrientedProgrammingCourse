package tk.proghodet.klassehierarki;

public class Boot {
	
	public static void main(String[] args) {
		Dato d = new Dato("19.01.1993");
		System.out.println(d.toString());
		
		Person p = new Person("01019233945", "Per", "Tønne");
		Person p2 = new Person("01019233935", "Per", "Lønne");
				
		System.out.println("Kjønn: " + p.findSex());
		System.out.println("Initialer: " + p.initialer());
		System.out.println("Lik? " + p.equals(p2));
		
		Ansatt a = new Ansatt("25021332334", "Kari", "Vikestad", d, "Foreleser", 300000.00);
		Student s = new Student("12069637983", "Lise", "Karlsnes", "IT");
		
		Person[] tab = new Person[4];
		tab[0] = p; tab[1] = a; tab[2] = s; tab[3] = p2; 
		
		for (int i = 0; i<tab.length; i++)
			System.out.println(tab[i].toString());
		
		
	}

}
