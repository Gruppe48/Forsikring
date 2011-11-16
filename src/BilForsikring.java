/* 
 * Innlevering 4 - 16/11-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA 
 */

//Klasse for å konstruere Bilforsikrings objekter
import java.text.NumberFormat;

public class BilForsikring implements Forsikring {

  public static final double PRIS_PER_KM = 1.5;
  private String biltype = "";
  private int registreringsår = -1;
  private String registeringsnummer = "";
  private int kjørelengde = -1;
  private double bonus = 0;

  public BilForsikring(String b, int year, String reg, int lengde, double bon) {
    biltype = b;
    registreringsår = year;
    registeringsnummer = reg;
    kjørelengde = lengde;
    bonus = bon;
  }
 
  @Override
  public double premie() {
    double sum = PRIS_PER_KM * kjørelengde;
    double bon = (sum/100) * bonus;
    
    return sum -= bon;
  }

  @Override
  public int getForsikringsType() {
    return BIL;
  }
  
  @Override
  public String toString() {
    NumberFormat kroneformat = NumberFormat.getCurrencyInstance();
    return "BIL - Forsikring\nBiltype: " + biltype + "\nRegistreringsår: " + 
            registreringsår + "\nRegistreringsnr: " + registeringsnummer + 
            "\nKjørelengde: " + kjørelengde + "km\nBonus: " + 
            (int)bonus + "\nÅrlig premie: " + kroneformat.format(premie());  
  }
}
