package tk.proghodet.collectionklasser;

import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
//		ArrayList<Menneske> liste = new ArrayList<Menneske>();
//		HashSet<Menneske> liste = new HashSet<Menneske>();
		TreeSet<Menneske> liste = new TreeSet<Menneske>();
		
		Menneske m1 = new Menneske("Anne");
		Menneske m2 = new Menneske("Per");
		liste.add(m1);
		liste.add(m2);
		
		for (Menneske m : liste) {
			System.out.println(m.hilsen());
		}		
	}
}