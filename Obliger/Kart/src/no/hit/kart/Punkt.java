package no.hit.kart;

public class Punkt {

	private int x;
	private int y;

	public Punkt(int x, int y) {
		this.x = x;
		this.y = y;
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
		return "Punkt [x=" + x + ", y=" + y + "]";
	}

	public int distance(Punkt p) {
		return (int) Math.sqrt((this.x - p.x) * (this.x - p.x) + 
				(this.y - p.y) * (this.y - p.y));
	}

	/* Testing av distance-metoden:
	 * public static void main (String[] args) { 
	 * Punkt p1 = new Punkt(400, 120);
	 * Punkt p2 = new Punkt(400, 101);
	 * System.out.println(p1.distance(p2));
	 * }
	 */
}
