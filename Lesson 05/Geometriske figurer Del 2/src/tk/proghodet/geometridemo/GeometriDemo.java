/*
 * 
 */

package tk.proghodet.geometridemo;

import javafx.scene.paint.Color;

/**
 * 
 * @author Proghodet
 *
 */

public class GeometriDemo {
	/**
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		Figur[] figurTab = new Figur[2];
		figurTab[0] = new Punkt(Color.BEIGE, 170, 140);
		figurTab[1] = new Rektangel(Color.BLUE, 50, 120, 40, 30);
		
		Punkt klikk = new Punkt(Color.BLACK, 170, 140);
		
		for (Figur f : figurTab) {
			if (f.merketAv(klikk))
				System.out.println("Traff: " + f.toString());
		}
		
//		if (p.merketAv(klikk)) {
//			System.out.println("Traff p");
//		}
//		
//		if (r.merketAv(klikk)) {
//			System.out.println("Traff r");
//		}
	}
}