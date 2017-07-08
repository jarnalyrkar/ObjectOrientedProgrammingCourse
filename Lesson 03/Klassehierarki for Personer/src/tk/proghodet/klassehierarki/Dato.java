package tk.proghodet.klassehierarki;
public class Dato extends Object {
 
  private int dag;
  private int mnd;
  private int år;
 
  public Dato(int dag, int mnd, int år) {
    // Sjekk at datoen er lovlig, og
	// initier objektvariablene.
	if (dag < 32 && dag > 0) {
		this.dag = dag;
	}
	if (mnd < 13 && mnd > 0) {
		this.mnd = mnd;
	}
	if (år < 2050 && år > 1900) {
		this.år = år;
	}  
  }
  
  public Dato(String strDato) {
    // Sjekk at datoen er lovlig,
    // plukk ut dag, måned og år, og
    // initier objektvariablene.
	  
	  String helDato = strDato.replaceAll( "[^\\d]", "" );
	  int helDatoInt = Integer.parseInt(helDato);
	  int tempDag = (helDatoInt/100/100/10);
	  if (tempDag > 0 && tempDag < 32)
		  	this.dag = tempDag;
	  
	  int tempMnd = ((helDatoInt/100/100)%10);
	  if (tempMnd > 0 && tempMnd < 13)
	  		this.mnd = tempMnd;
	  		
	  int tempÅr = (helDatoInt%10000);
	  if (tempÅr > 1899 && tempÅr < 2051)
		  this.år = tempÅr;
	  
  }
  public boolean erLik(Dato d) {
	  // TODO: implement method
	  return (d.dag == this.dag && d.mnd == this.mnd && d.år == this.år);
  }
  public boolean før(Dato d) {
	// TODO: implement method
    // Sjekk at denne datoen (this)
    // er før datoen d.    
	  return (d.dag > this.dag || d.mnd > this.mnd || d.år > this.år );
  }
  public String toString() {
    // Returner denne datoen (this) på
    // tekstlig form.
	 String sb = dag + "." + mnd + "." + år;
	 return sb;
  }
 
  private boolean iSkuddår() {
	// Returner true hvis denne datoen (this)
	// befinner seg i et skuddår.
	  return (this.år%4 == 1);
	  
    
  }
}