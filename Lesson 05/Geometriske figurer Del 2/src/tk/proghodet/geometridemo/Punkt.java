package tk.proghodet.geometridemo;

import javafx.scene.paint.Color;

class Punkt extends Figur {

	public Punkt(Color farge, int x, int y) {
		super(farge, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean merketAv(Punkt p) {
			return p.x == this.x && p.y == this.y;
	}

	@Override
	public String toString() {
		return "Punkt []" + super.toString();
	}
	
	
	
}