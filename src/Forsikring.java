public interface Forsikring {
  
    public static final int TOTALKUNDERABATT = 20;

    public static final int BIL = 1, HUS_INNBO = 2, REISE = 3;

     
    public abstract double premie ();
    
    @Override
    public abstract String toString();
    
    public abstract int getForsikringsType();
    

}