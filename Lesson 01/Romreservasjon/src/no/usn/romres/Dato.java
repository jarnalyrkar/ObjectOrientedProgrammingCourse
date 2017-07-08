package no.usn.romres;

/* 
 * Klasse for � representere datoer.
 *
 * Objekter kan lages p� to m�ter:
 *
 *   Dato d1 = new Dato(2, 12,1999);
 *   Dato d2 = new Dato("2:12:1999");
 *
 * Klassen inneholder ogs� metoder for � sammenligne datoer 
 * og for � konvertere en dato til tekstlig form.
 *
 */
public class Dato {

  private int dag;
  private int mnd;
  private int �r;

  /*
   * Konstrukt�r for � lage Dato-objekter fra heltall dag, m�ned og �r.
   */
  public Dato(int dag, int mnd, int �r) {
    this.dag = dag;
    this.mnd = mnd;
    this.�r = �r;
	sjekk();
  }

  /*
   * Konstrukt�r for � lage Dato-objekter fra tekstlig representasjon,
   * p� formen "dd.mm.����"
   */
  public Dato(String strDato) {
    try {
      String[] dagTab = strDato.split("\\.");
      dag = Integer.parseInt(dagTab[0]);
      mnd = Integer.parseInt(dagTab[1]);
      �r = Integer.parseInt(dagTab[2]);
	}
	catch (NumberFormatException e) {
	  throw new IllegalArgumentException("Dato " + strDato + " er ikke p� lovlig form dd.mm.����" );
	}
	sjekk();
  }

  /*
   * Sjekker om to datoer er like.
   */
  public boolean erLik(Dato d) {
    return �r==d.�r && mnd==d.mnd && dag==d.dag;
  }

  /*
   * Sjekker om en dato er f�r en annen.
   */
  public boolean f�r(Dato d) {
    boolean f�r = false;

    if (�r<d.�r)
      f�r = true;
    else if (�r==d.�r && mnd<d.mnd)
      f�r = true;
    else if (�r==d.�r && mnd==d.mnd && dag<d.dag)
      f�r = true;

    return f�r;
  }


  /*
   * Returnerer en tekstlig representasjon av datoen.
   */
  public String toString() {
    return (Integer.toString(dag) + "." +
            Integer.toString(mnd) + "." +
            Integer.toString(�r));
  }
  


  /* ------------ HJELPEMETODER ------------------- */


  /*
   *  Sjekk om denne datoen (this) er lovlig.
   */
  private void sjekk() throws IllegalArgumentException {
    boolean ok = true;

    if (mnd<1 || mnd>12 || dag<1 || dag>31)
      ok = false;
    else if ((mnd==4 || mnd==6 || mnd==9 || mnd==11) && dag>30)
      ok = false;
    else if (mnd==2 && dag>29)
      ok = false;
    else if (mnd==2 && dag==29 && !iSkudd�r())
      ok = false;

    if (!ok)
	  throw new IllegalArgumentException("Ulovlig dato: " + toString());
  }
  

  /*
   *  Sjekk om denne datoen (this) ligger i et skudd�r.
   */
  private boolean iSkudd�r() {
    return ((�r%4==0 && �r%100!=0) || (�r%400==0));
  }
}