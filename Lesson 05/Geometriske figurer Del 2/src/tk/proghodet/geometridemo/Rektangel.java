package tk.proghodet.geometridemo;

import javafx.scene.paint.Color;

public class Rektangel extends Figur {
	
	private int width;
	private int height;
	
	public Rektangel(Color farge, int x, int y, int width, int height) {
		super(farge, x, y);
		this.width = width;
		this.height = height;
	}


	@Override
	public boolean merketAv(Punkt p) {
		return (p.x>=x && p.x<=x+width && 
				p.y>=y && p.y<=y+height);
	}


	@Override
	public String toString() {
		return "Rektangel [" + super.toString() + "width=" + width + ", height=" + height + "]";
	}
	

}
