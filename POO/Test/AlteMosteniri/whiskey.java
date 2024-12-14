import java.util.*;
abstract class Bautura{
    protected String nume;
    protected Bautura(String nume)
    {
	this.nume=nume;
    }
    abstract public double getNrCalorii(double mili);
    abstract public double getConcentratieAlcool();
    public String toString()
    {
	return nume+" Concentratie alcool:"+this.getConcentratieAlcool()+"%, Calorii pe 100ml:"+this.getNrCalorii(100)+" kcal";
    }
}
abstract class WhiskeyUnit extends Bautura{
    protected double concentratie;
    protected WhiskeyUnit(String nume,double concentratie)
    {
	super(nume);
	this.concentratie=concentratie;
    }
    public double getConcentratieAlcool()
    {
	return concentratie;
    }
}
class ClassicWhiskey extends WhiskeyUnit{
    public ClassicWhiskey(String nume,double concentratie)
    {
	super(nume,concentratie);
    }
    public double getNrCalorii(double mili)
    {
	return concentratie*mili*5;
    }
}
class JackAndHoney extends WhiskeyUnit{
    private int indulcitor;
    public JackAndHoney(String nume,double concentratie,int indulcitor)
    {
	super(nume,concentratie);
	this.indulcitor=indulcitor;
    }
    public double getNrCalorii(double mili)
    {
	return concentratie*mili*5+indulcitor*mili*15;
    }
    public String toString()
    {
	return super.toString()+", Cantitate Indulcitor:"+indulcitor;
    }
}
class BlendedWhiskey extends Bautura{
    private List<Bautura> list;
    public BlendedWhiskey(String nume)
    {
	super(nume);
	list=new ArrayList<Bautura>();
    }
    public void adauga(Bautura b)
    {
	list.add(b);
    }
    public double getConcentratieAlcool()
    {
	double s=0.0;
	for(Bautura u:list)
	    {
		s+=u.getConcentratieAlcool();
	    }
	return (double)s/list.size();
    }
    public double getNrCalorii(double mili)
    {
	double s=0.0;
	Iterator<Bautura> it=list.iterator();
	while(it.hasNext())
	    {
		s+=it.next().getNrCalorii(mili);
	    }
	return (double)s/list.size();
    }
    public String toString()
    {
	String s=super.toString()+", Compozitie:\n ";
	for(Bautura b:list)
	    {
		s+=b.toString()+"\n ";
	    }
	return s;
    }
}
class Main{
    public static void main(String[] args)
    {
	ClassicWhiskey b1=new ClassicWhiskey("B1-ClassicWhiskey",30.0);
	JackAndHoney b2=new JackAndHoney("B2-JackAndHoney",20.0,3);
	System.out.println(b1);
	System.out.println(b2);

	ClassicWhiskey b3=new ClassicWhiskey("B3-ClassicWhiskey",31.0);
	ClassicWhiskey b4=new ClassicWhiskey("B4-ClassicWhiskey",29.0);
	BlendedWhiskey b5=new BlendedWhiskey("B5-BlendedWhiskey");
	b5.adauga(b3);
	b5.adauga(b4);
	System.out.println(b5+"\n");

	BlendedWhiskey b6=new BlendedWhiskey("B6-BlendedWhiskey");
	b6.adauga(b1);
	b6.adauga(b2);
	b6.adauga(b5);
	System.out.println(b6);
    }
}
