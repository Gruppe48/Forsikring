/* 
 * Innlevering 4 - 16/11-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA 
 */

import javax.swing.JTextArea;

public class ForsikringsRegister
{
  public static final int SIZE = 1000;
  public static final int UTVIDELSE = 10;
  private ForsikringsKunde[] kunderegister = new ForsikringsKunde[SIZE];
  
  /*Finner indeksen til ForsikringsKunde objektet med forsikringsNr
    som blir gitt med som parameter*/
  private int indeks(int nr) {
    
    for (int i = 0; i < kunderegister.length; i++) {
      ForsikringsKunde kunde = kunderegister[i];
      
      if (kunde.getForsikringsNr() == nr) {
        return i;
      }
      
    }
    return -1;
  }
  
  /*Metode som returnerer ForsikringsKunde objektet som har samme forsikringsNr 
    som parameteret */
  public ForsikringsKunde finnKunde(int nr) {
    int i = indeks(nr);
    
    if (i != -1) {
      return kunderegister[i];
    }
    return null;
  }
  
  //Utvidder registeret med så mange elementer som UTVIDELSE angir
  public void utvidRegister() {
    
    /* Lager en midlertidig array for å holde data, kopierer disse og opretter en
       ny utvidet array og kopierer innholdet tilbake*/
    ForsikringsKunde[] kr = new ForsikringsKunde[kunderegister.length];
    System.arraycopy(kunderegister, 0, kr, 0, kunderegister.length);
    kunderegister = new ForsikringsKunde[kr.length+UTVIDELSE];
    System.arraycopy(kr, 0, kunderegister, 0, kr.length);  
  }
  
  //GÅR Å LAGE EN BRUKER UTEN NAVN/ADRESSE. FIKS!!
  //Legger inn en ny kunde i registeret
  public boolean nyKunde(ForsikringsKunde k) {
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
    
    // Setter inn objektet.
    for (int i = 0; i < kunderegister.length; i++) {
      ForsikringsKunde kunde = kunderegister[i];
      if (kunde == null) {
        kunderegister[i] = k;
        return true;
      }
    }
    
    return false;
  }
  
  //Fjerner kunde med forsikringsNr som parameteret angir
  public ForsikringsKunde fjernKunde(int nr) {
    int i = indeks(nr);
    if (i != -1) {
      for (int j = 0; j < kunderegister.length; j++) {
        ForsikringsKunde forsikringsKunde = kunderegister[j];
        if(kunderegister[j].getForsikringsNr() == nr) {
          kunderegister[j] = null;
          return forsikringsKunde;
          }
      }
    }
    return null;
  }
  
  //Skriver ut informasjon om alle kundene i registeret og forsikringene deres
  public void visRegister(JTextArea a) {
    
    a.setText("Kunderegister:\n");
    for (int i = 0; i < kunderegister.length; i++) {
      ForsikringsKunde fk = kunderegister[i];
      if (fk != null ) {
        a.append(fk.toString());
        a.append("\n");
      }
      
    }
  }

} 