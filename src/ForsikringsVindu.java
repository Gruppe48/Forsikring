import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForsikringsVindu extends JFrame
{

  private JTextField kundefelt, fakturafelt, nrfelt;
  private JTextField adressefelt,boligtypefelt, arealfelt,
	                   verdifelt, sumfelt;
  private JTextField biltypefelt,reg�rfelt, regnrfelt,
	                   lengdefelt, bonusfelt;
  private JTextField reisesumfelt;

  private JTextArea utskrift;

  private JButton regKunde, visKunde, slettKunde, regBil,
          regHusInnbo, regReise, visAlle;

  ForsikringsRegister kunderegisteret = new ForsikringsRegister();;

  public ForsikringsVindu()
  {
	super("TRYGG FORSIKRING");

	Lytter lytter = new Lytter();

	Container c = getContentPane();


    JPanel vestpanel = new JPanel();
    vestpanel.setLayout(new GridLayout(23,1));

    vestpanel.add(new JLabel("REGISTRER KUNDE "));

    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(1,2));
	kundefelt = new JTextField(20);
	kundefelt.addActionListener(lytter);
	p1.add(new JLabel("Kundens navn: "));
	p1.add(kundefelt);
	vestpanel.add(p1);

    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(1,2));
	fakturafelt = new JTextField(20);
	fakturafelt.addActionListener(lytter);
	p2.add(new JLabel("Fakturaadresse: "));
	p2.add(fakturafelt);
	vestpanel.add(p2);

	JPanel p = new JPanel();
	p.setLayout(new GridLayout(1,2));
	nrfelt = new JTextField(20);
    p.add(new JLabel("Kundenr: "));
	p.add(nrfelt);
	vestpanel.add(p);

    JPanel knappepanel = new JPanel();
	knappepanel.setLayout(new GridLayout(1,4));
	regKunde = new JButton("Ny kunde");
	regKunde.addActionListener(lytter);
	visKunde = new JButton("Vis kunde");
	visKunde.addActionListener(lytter);
	slettKunde = new JButton("Slett kunde");
	slettKunde.addActionListener(lytter);
	visAlle = new JButton("Kunderegister");
	visAlle.addActionListener(lytter);

    knappepanel.add(regKunde);
	knappepanel.add(visKunde);
	knappepanel.add(slettKunde);
	knappepanel.add(visAlle);

	vestpanel.add(knappepanel);


    vestpanel.add(new JLabel("HUS OG INNBO-FORSIKRING "));

    JPanel p3 = new JPanel();
    p3.setLayout(new GridLayout(1,2));
	adressefelt = new JTextField(20);
	adressefelt.addActionListener(lytter);
	p3.add(new JLabel("Forsikringsadresse: "));
	p3.add(adressefelt);
    vestpanel.add(p3);

    JPanel p4 = new JPanel();
    p4.setLayout(new GridLayout(1,2));
    boligtypefelt = new JTextField(20);
	boligtypefelt.addActionListener(lytter);
	p4.add(new JLabel("Boligtype "));
	p4.add(boligtypefelt);
	vestpanel.add(p4);

    JPanel p5 = new JPanel();
    p5.setLayout(new GridLayout(1,2));
    arealfelt = new JTextField(20);
	arealfelt.addActionListener(lytter);
	p5.add(new JLabel("Areal "));
	p5.add(arealfelt);
	vestpanel.add(p5);

    JPanel p6 = new JPanel();
    p6.setLayout(new GridLayout(1,2));
	verdifelt = new JTextField(20);
	verdifelt.addActionListener(lytter);
	p6.add(new JLabel("Boligens fullverdigrunnlag "));
	p6.add(verdifelt);
    vestpanel.add(p6);

    JPanel p7 = new JPanel();
    p7.setLayout(new GridLayout(1,2));
	sumfelt = new JTextField(20);
	sumfelt.addActionListener(lytter);
	p7.add(new JLabel("Sum innbo og l�s�re "));
	p7.add(sumfelt);
    vestpanel.add(p7);

	regHusInnbo = new JButton("Tegn hus og innboforsikring");
	regHusInnbo.addActionListener(lytter);
	vestpanel.add(regHusInnbo);


    vestpanel.add(new JLabel("BIL-FORSIKRING "));

    JPanel p8 = new JPanel();
    p8.setLayout(new GridLayout(1,2));
    biltypefelt = new JTextField(20);
	biltypefelt.addActionListener(lytter);
	p8.add(new JLabel("Biltype "));
	p8.add(biltypefelt);
    vestpanel.add(p8);

    JPanel p9 = new JPanel();
    p9.setLayout(new GridLayout(1,2));
    reg�rfelt = new JTextField(20);
	reg�rfelt.addActionListener(lytter);
	p9.add(new JLabel("Registrerings�r "));
	p9.add(reg�rfelt);
    vestpanel.add(p9);

    JPanel p10 = new JPanel();
    p10.setLayout(new GridLayout(1,2));
    regnrfelt = new JTextField(20);
	regnrfelt.addActionListener(lytter);
	p10.add(new JLabel("Registringsnummer "));
	p10.add(regnrfelt);
	vestpanel.add(p10);

    JPanel p11 = new JPanel();
    p11.setLayout(new GridLayout(1,2));
    lengdefelt = new JTextField(20);
	lengdefelt.addActionListener(lytter);
	p11.add(new JLabel("�rlig kj�relengde "));
	p11.add(lengdefelt);
	vestpanel.add(p11);

    JPanel p12 = new JPanel();
    p12.setLayout(new GridLayout(1,2));
    bonusfelt = new JTextField(20);
	bonusfelt.addActionListener(lytter);
	p12.add(new JLabel("Bonus "));
	p12.add(bonusfelt);
	vestpanel.add(p12);

	regBil = new JButton("Tegn bilforsikring");
	regBil.addActionListener(lytter);
	vestpanel.add(regBil);

	vestpanel.add(new JLabel("REISE-FORSIKRING "));

    JPanel p13 = new JPanel();
    p13.setLayout(new GridLayout(1,2));
    reisesumfelt = new JTextField(20);
	reisesumfelt.addActionListener(lytter);
	p13.add(new JLabel("Reiseforsikringssum "));
	p13.add(reisesumfelt);
    vestpanel.add(p13);


	regReise = new JButton("Tegn reiseforsikring");
	regReise.addActionListener(lytter);
	vestpanel.add(regReise);

    JPanel utskriftspanel = new JPanel();

	utskrift = new JTextArea(36,30);
	utskriftspanel.add(new JScrollPane(utskrift));

	JPanel registreringspanel = new JPanel();

    registreringspanel.add(vestpanel);
	c.add(registreringspanel,BorderLayout.WEST);


	c.add(utskriftspanel,BorderLayout.EAST);
	setSize(810, 630);
	setVisible(true);
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }


		public void slettKundeFelt()
		{
			kundefelt.setText("");
			fakturafelt.setText("");
			nrfelt.setText("");
		}

		public void slettBilFelt()
		{
			biltypefelt.setText("");
			reg�rfelt.setText("");
			regnrfelt.setText("");
			lengdefelt.setText("");
			bonusfelt.setText("");
		}

		public void slettHusFelt()
		{
			adressefelt.setText("");
			boligtypefelt.setText("");
			arealfelt.setText("");
			verdifelt.setText("");
			sumfelt.setText("");
		}

		public void slettReiseFelt()
		{
			reisesumfelt.setText("");
	  }

    public void registrerNyKunde()
    {
      < Metoden registrerer en ny kunde, under forutsetning av at kunden
        ikke allerede er registrert i selskapet. I tekstomr�det utskrift
        gis det beskjed om utfallet av registreringen.
        Merk! Denne metoden skal du IKKE programmere! >
    }

    public void visKunde()
    {
      < Metoden skriver i tekstomr�det utskrift all informasjon som er
        lagret om en kunde ut fra vedkommendes kundenummer. Hvis kunden med
        et slikt kundenummer ikke er registrert, gis det i tekstomr�det
        utskrift beskjed  om det.
        Merk! Denne metoden skal du IKKE programmere! >
    }

    public void slettKunde()
    {
      < Metoden sletter en kunde utfra vedkommendes kundenummer, under
        forutsetning av at det finnes en kunde med et slikt kundenummer.
        I tekstomr�det utskrift gis det beskjed om utfallet av slettingen.
        Merk! Denne metoden skal du IKKE programmere!>
    }

    public void visKunderegister()
    {
      < Metoden  viser i tekstomr�det utskrift all informasjon som er lagret
        i kunderegisteret om forsikringskundene og deres forsikringer.
        Merk! Denne metoden skal du IKKE programmere! >
    }

    public void tegnBilForsikring( ForsikringsKunde k )
    {
      < Metoden skal lese inn n�dvendig informasjon for � opprette
        bilforsikring for den kunden som parameteren k angir, under
        forutsetning av at vedkommende ikke har bilforsikring i selskapet
        fra f�r. I tekstomr�det utskrift skal det gis melding om utfallet
        av opprettelsen. >
    }

    public void tegnHusInnboForsikring( ForsikringsKunde k )
    {
      < Metoden leser inn n�dvendig informasjon for og oppretter
        hus- og innboforsikring for den kunden som parameteren k angir,
        under forutsetning av at vedkommende ikke har hus- og innboforsikring
        fra f�r. I tekstomr�det utskrift gis det melding om utfallet
        av opprettelsen.
        Merk! Denne metoden skal du IKKE programmere! >
    }

    public void tegnReiseForsikring( ForsikringsKunde k )
    {
      < Metoden leser inn n�dvendig informasjon for � opprette
        reiseforsikring for den kunden som parameteren k angir, under
        forutsetning av at vedkommende ikke har reiseforsikring fra
        f�r. I tekstomr�det utskrift gis det melding om utfallet
        av opprettelsen.
        Merk! Denne metoden skal du IKKE programmere! >
    }

    public void tegnForsikrning( int type )
    {
      < Metoden skal opprette forsikring av den typen som parameteren
        type angir, (Hint: Se klassen Forsikring), for kunden med det
        kundenummer som brukeren av programmet har skrevet inn, under
        forutsetning av at det finnes en slik kunde i kunderegisteret.
        Hvis det ikke finnes en slik kunde, skal det i tekstomr�det
        utskrift gis medling om det. >
    }

    < private lytte-klasse Lytter >

  } //end of class ForsikringsVindu