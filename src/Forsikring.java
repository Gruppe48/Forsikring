/* 
 * Innlevering 4 - 16/11-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA 
 */

// Interface for de forkjellige type forsikringer
public interface Forsikring {
  
    public static final int TOTALKUNDERABATT = 20;

    public static final int BIL = 1, HUS_INNBO = 2, REISE = 3;

    public abstract double premie ();
    
    @Override
    public abstract String toString();
    
    public abstract int getForsikringsType();
    

}