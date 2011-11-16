/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kristoffer Berdal <web@flexd.net>
 * @studnr 180212
 * @date Nov 14, 2011
 */
import javax.swing.JTextArea;

public class ForsikringsRegister
{
  public static final int SIZE = 1000;
  public static final int UTVIDELSE = 10;
  private ForsikringsKunde[] kunderegister = new ForsikringsKunde[SIZE];

  private int indeks(int nr) {
    /* Metoden skal returnere indeksen til det ForsikringsKunde-objektet
      som har samme forsikringsNr som parameteren nr angir. Hvis et slikt
      objekt ikke finnes i kunderegisteret, skal metoden returnere -1. >*/
    
    for (int i = 0; i < kunderegister.length; i++) {
      ForsikringsKunde kunde = kunderegister[i];
      
      if (kunde.getForsikringsNr() == nr) {
        return i;
      }
      
    }
    return -1;
  }

  public ForsikringsKunde finnKunde(int nr) {
    /* Metoden skal returnere det ForsikringsKunde-objektet som har samme
      forsikringsNr som parameteren nr angir. Hvis et slikt objekt ikke
      finnes i kunderegisteret, skal metoden returnere null.
      Krav: Du SKAL bruke indeks-metoden når du programmerer denne. >*/
    int i = indeks(nr);
    
    if (i != -1) {
      return kunderegister[i];
    }
    return null;
  }

  public void utvidRegister() {
    /* < Metoden skal utvide arrayen kunderegister med så mange elementer som
      UTVIDELSE angir. >*/
    // Lage midlertidig array for å holde data.
    ForsikringsKunde[] kr = new ForsikringsKunde[kunderegister.length];
    // Kopiere ut data
    System.arraycopy(kunderegister, 0, kr, 0, kunderegister.length);
    // Lage nytt utvidet array
    kunderegister = new ForsikringsKunde[kr.length+UTVIDELSE];
    // Kopiere dataene tilbake
    System.arraycopy(kr, 0, kunderegister, 0, kr.length);
    // Success?
  }

  public boolean nyKunde(ForsikringsKunde k) {
    /*< Metoden skal sette parameteren k inn i kunderegisteret, under forutsetning
      av at denne kunden ikke er registrert der fra før. Hvis kunderegisteret er
      fullt, skal det utvides med det antall elementer som UTVIDELSE angir, og
      deretter skal k settes inn. Returverdien skal angi om innsettingen var
      vellykket eller ikke. >*/
    for (int i = 0; i < kunderegister.length; i++) {
      ForsikringsKunde kunde = kunderegister[i];
      
      if (kunde != null) {
        if (kunde.getNavn().equals(k.getNavn())) {
          return false;
        }
      }
    }
    
    // Kommer vi hit finnes ikke kunden.
    
    if (kunderegister.length == SIZE) {
      utvidRegister();
    }
    
    // sett inn objektet.
    for (int i = 0; i < kunderegister.length; i++) {
      ForsikringsKunde kunde = kunderegister[i];
      if (kunde == null) {
        kunderegister[i] = k;
        return true;
      }
    }
    
    return false;
  }

  public ForsikringsKunde fjernKunde(int nr) {
    /*< Hvis det i kunderegisteret finnes et ForsikringsKunde-objekt med samme
      forsikringsNr som parameteren nr angir, skal dette fjernes fra
      kunderegisteret. Det fjernede objektet skal deretter returneres fra
      metoden. Hvis det ikke finnes et slikt objekt, skal metoden returnere
      null. >*/
    int i = indeks(nr);
    if (i != -1) {
      for (int j = 0; j < kunderegister.length; j++) {
        ForsikringsKunde forsikringsKunde = kunderegister[j];
        kunderegister[j] = null;
        return forsikringsKunde;
      }
    }
    return null;
  }

  public void visRegister(JTextArea a) {
    /*< Metoden skal i tekstområdet som parameteren a angir plassere all
      informasjon som er lagret i kunderegisteret om forsikringskundene
      og deres forsikringer >*/
    
    /* private String navn;
       private String fakturaAdresse;
       private int forsikringsNr;
       private static int nesteNr = 1;
       public static final int MAX = 3; //Maks antall forsikringer kunden kan ha.
       private Forsikring[] forsikringer;
     *
     */
    a.setText("Kunderegister:\n");
    for (int i = 0; i < kunderegister.length; i++) {
      ForsikringsKunde fk = kunderegister[i];
      if (fk != null ) {
        a.append(fk.toString());
        a.append("\n");
      }
      
    }
  }

} //end of class ForsikringsRegister