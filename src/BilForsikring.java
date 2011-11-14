
import java.text.NumberFormat;

/**
 *
 * @author Kristoffer Berdal <web@flexd.net>
 * @studnr 180212
 * @date Nov 14, 2011
 */
public class BilForsikring implements Forsikring {

  public static final double PRIS_PER_KM = 1.5;
  public String biltype = "";
  
  public int registreringsår = -1;
  
  public String registeringsnummer = "";
  
  public int kjørelengde = -1;
  
  public double bonus = 0;

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
    return "BIL - Forsikring\nBiltype: " + biltype + "\nregistreringsår: " + registreringsår + "\n kjørelengde: " + kjørelengde + "km\nbonus: " + (int)bonus + "\n Årlig premie: " + kroneformat.format(premie());  
  }
}
