import java.text.NumberFormat;
public class HusInnboForsikring implements Forsikring{

	public String forsikringsadresse = "";

	public String boligtype = "";

	public double areal = -1;

	public double fullverdigrunnlag = -1;

	public double innbo = -1;

	public double løsøre = -1;

	public double sum = løsøre + innbo;

	public double premie = (fullverdigrunnlag + sum) * 0.002;

	public HusInnboForsikring(String adr, String type, double area, double verdi, double inn, double løs, double premie){
		forsikringsadresse = adr;
		boligtype = type;
		areal = area;
		fullverdigrunnlag = verdi;
		innbo = inn;
		løsøre = løs;
		premie = prem;
	}

	public double premie() {
		double fpremie = premie * 0.002;







