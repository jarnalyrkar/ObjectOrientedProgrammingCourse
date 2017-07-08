package tk.proghodet.klassehierarki;
public class Dato extends Object {
 
  private int dag;
  private int mnd;
  private int �r;
 
  public Dato(int dag, int mnd, int �r) {
    // Sjekk at datoen er lovlig, og
	// initier objektvariablene.
	if (dag < 32 && dag > 0) {
		this.dag = dag;
	}
	if (mnd < 13 && mnd > 0) {
		this.mnd = mnd;
	}
	if (�r < 2050 && �r > 1900) {
		this.�r = �r;
	}  
  }
  
  public Dato(String strDato) {
    // Sjekk at datoen er lovlig,
    // plukk ut dag, m�ned og �r, og
    // initier objektvariablene.
	  
	  String helDato = strDato.replaceAll( "[^\\d]", "" );
	  int helDatoInt = Integer.parseInt(helDato);
	  int tempDag = (helDatoInt/100/100/10);
	  if (tempDag > 0 && tempDag < 32)
		  	this.dag = tempDag;
	  
	  int tempMnd = ((helDatoInt/100/100)%10);
	  if (tempMnd > 0 && tempMnd < 13)
	  		this.mnd = tempMnd;
	  		
	  int temp�r = (helDatoInt%10000);
	  if (temp�r > 1899 && temp�r < 2051)
		  this.�r = temp�r;
	  
  }
  public boolean erLik(Dato d) {
	  // TODO: implement method
	  return (d.dag == this.dag && d.mnd == this.mnd && d.�r == this.�r);
  }
  public boolean f�r(Dato d) {
	// TODO: implement method
    // Sjekk at denne datoen (this)
    // er f�r datoen d.    
	  return (d.dag > this.dag || d.mnd > this.mnd || d.�r > this.�r );
  }
  public String toString() {
    // Returner denne datoen (this) p�
    // tekstlig form.
	 String sb = dag + "." + mnd + "." + �r;
	 return sb;
  }
 
  private boolean iSkudd�r() {
	// Returner true hvis denne datoen (this)
	// befinner seg i et skudd�r.
	  return (this.�r%4 == 1);
	  
    
  }
}