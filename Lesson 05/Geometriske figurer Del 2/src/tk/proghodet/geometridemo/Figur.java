package tk.proghodet.geometridemo;

import javafx.scene.paint.Color;

/**
 * 
 * Abstrakt superklasse for geometriobjekter
 * 
 * @author Proghodet
 * @version 0.9
 * 
 */

public abstract class Figur {
	protected Color farge;
	protected int x;
	protected int y;

	/**
	 * Oppretter Figur
	 * 
	 * @param farge fargen
	 * @param x x-koordinatet
	 * @param y y-koordinatet
	 */
	
	public Figur(Color farge, int x, int y) {
		this.farge = farge;
		this.x = x;
		this.y = y;
	}

	public Color getFarge() {
		return farge;
	}

	public void setFarge(Color farge) {
		this.farge = farge;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Figur [farge=" + farge + ", x=" + x + ", y=" + y + "]";
	}
	
	public abstract boolean merketAv(Punkt p);

}
