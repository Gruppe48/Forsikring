/**
 *
 * @author Dobbelmoral
 */

import java.text.NumberFormat;

public class ForsikringsKunde
{
  private String navn;
  private String fakturaAdresse;
  private int forsikringsNr;
  private static int nesteNr = 1;
  public static final int MAX = 3; //Maks antall forsikringer kunden kan ha.
  private Forsikring[] forsikringer;

  /*< Konstruktøren skal utføre nødvendig initialisering av datafeltene,
    og opprette arrayen. ForsikringsKunden skal tildeles et unikt forsikringsNr
    som blir generert automatisk. Kontruktøren skal ta i mot kundens navn og
    fakturaAdresse som parametere. >

  < get-metoder for navn og forsikringsNr. > */
  
  public ForsikringsKunde(String navn, String fakturaAdresse) {
    this.navn = navn;
    this.fakturaAdresse = fakturaAdresse;
    forsikringer = new Forsikring[MAX];
    forsikringsNr = nesteNr++; 
  }

  public boolean erForsikret(Forsikring f) {
    for(int i=0; i < forsikringer.length; i++) {
      if(forsikringer[i].getForsikringsType() == f.getForsikringsType()) {
        return true;
      }
    }  
    return false;
  }
  
  public String getNavn() {
    return navn;
  }
  
  public int getForsikringsNr() {
    return forsikringsNr;
  }
  
  public String tegnForsikring(Forsikring f)
  {
    if (!erForsikret(f)) {
      for(int i=0; i < forsikringer.length; i++) {
        if(forsikringer[i] == null) {
          forsikringer[i] = f;
          
          return "Ny forsikring er registert";
        }
      }
    }
    return "Forsikring ble ikke registert";
  }
    
    /*< Metoden skal opprette en ny forsikring på kunden, under forutsetning
      av at kunden ikke allerede har denne typen forsikring fra før.
      Returverdien skal inneholde en tekst med informasjon om utfallet av
      opprettelsen. > */
  

  public boolean totalkunde()
  {
    for (int i=0; i < forsikringer.length; i++) {
      if (forsikringer[i] == null) {
        return false;
      }
    }
    return true;
  }

    /*< Hvis en kunde har opprettet alle tre forsikringstyper, er kunden
      "totalkunde", og metoden skal returnere true. I motsatt fall skal
      metoden returnere false. > */
  

  public double premie()
  {
    double premie = 0;
    
    for(int i=0; i < forsikringer.length; i++) {
      if(forsikringer[i] != null) {
        premie += forsikringer[i].premie();
      }
    }
    if(totalkunde()) {
      premie = premie - ((premie/100) * Forsikring.TOTALKUNDERABATT);
    }
    return premie;
    /*< Metoden skal beregne, og returnere, det kunden skal betale for alle
      forsikringene til sammen. Hvis kunden er "totalkunde", dvs har både
      hus/innbo- , bil- og reiseforsikring, skal vedkommende få
      TOTALKUNDERABATT (Hint: Se klassen Forsikring). > */
  }


  @Override
  public String toString() {
    String utskrift = "";
    NumberFormat kroneformat = NumberFormat.getCurrencyInstance();
    
    for(int i=0; i < forsikringer.length; i++) {
      if(forsikringer[i] != null) {
        utskrift += forsikringer[i].premie();
      }
    }
                
    if(totalkunde()) {
      utskrift += "Forsikringstager er totalkunde i TRYGG FORSIKRING\n "
              + "og får dermed" + Forsikring.TOTALKUNDERABATT + "%\n\n";
    }
    
    utskrift += "SUM FORSIKRINGSPREMIER PR ÅR: kr " + kroneformat.format(premie())+"\n";
    
    return utskrift;
    /*< Metoden skal returnere en tekst som inneholder alle data som er lagret
      om kunden og vedkommendes forsikringer. Det skal skrives ut hva hver
      enkelt forsikring koster, og det årlige betløpet kunden må betale.
      Hvis kunden er "totalkunde", skal det gis informasjon om det og om
      hvor mye det er gitt i rabatt. > */
  }

} //end of class ForsikringsKunde