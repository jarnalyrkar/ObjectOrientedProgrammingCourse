public class KlSlett {

	private int time;
	private int minutt;

	// KlSlett k1 = new KlSlett(8, 15);
	public KlSlett (int time, int minutt) {
		if (time <= 12 && time > 0 && minutt > 0 && minutt <= 59) {
			this.time = time;
			this.minutt = minutt;
		}
		else System.out.println("Wrong values");
	}
	
	// KlSlett k2 = new KlSlett("08:15")
	public KlSlett (String tid) {
		tid = tid.replaceAll( "[^\\d]", "" );
		int alltid = Integer.parseInt(tid);
		if ( alltid/100 > 23 || alltid/100 < 0 ||
			 alltid%100 > 59 || alltid%100 < 0 ) {
			System.out.println("Wrong values");
			time = 99;
			minutt = 99;
		} else {
			time = alltid/100;
			minutt = alltid%100; 
		}
		
	}

	public boolean erLik(KlSlett k) {
		return (this.time == k.time && this.minutt == k.minutt);
	}

	public boolean erFør(KlSlett k) {
		return (this.time <= k.time && this.minutt <= k.minutt);
	}

	public String toString() {
		return time + ":" + minutt;
	}
	
}
