import java.util.*;
abstract class Autovehicul{
    protected String inmat;
    protected double greutate;
    protected Autovehicul(String inmat,double greutate)
    {
	this.inmat=inmat;
	this.greutate=greutate;
    }
    abstract public double calculeazaGreutateTotala();
    public String toString()
    {
	return "Numar inmatriculare:"+inmat+" ,Greutate autovehicul:"+greutate;
    }
}

class Autoturism extends Autovehicul{
    private double g_pasageri;
    public Autoturism(String inmat,double greutate,double g_pasageri)
    {
	super(inmat,greutate);
	this.g_pasageri=g_pasageri;
    }
    public double calculeazaGreutateTotala()
    {
	return greutate+g_pasageri;
    }
    public String toString()
    {
	return super.toString() + " ,Greutatate pasageri:" +g_pasageri;
    }
}

class Camion extends Autovehicul{
    private List<Autoturism> list;
    public Camion(String nume,double greutate)
    {
	super(nume,greutate);
	list=new ArrayList<Autoturism>();
    }
    public void adaugaAutoturism(Autoturism a)
    {
	list.add(a);
    }
    public double calculeazaGreutateTotala()
    {
	double s=0.0;
	for(Autoturism a:list)
	    {
		s+=a.calculeazaGreutateTotala();
	    }
	return s+this.greutate;
    }
    public String toString()
    {
	String s=",(";
	Iterator<Autoturism> it=list.iterator();
	while(it.hasNext())
	    {
		s+=it.next().toString();
		if(it.hasNext())
		    s+=",";
	    }
	return super.toString()+s+")";
    }
}
class Bac{
    private double gmax;
    private List<Autovehicul> list;
    public Bac(double gmax)
    {
	this.gmax=gmax;
	list=new ArrayList<Autovehicul>();
    }
    private double calculeazaGreutateTotala()
    {
	double s=0.0;
	for(Autovehicul a:list)
	    {
		s+=a.calculeazaGreutateTotala();
	    }
	return s;
    }
    public boolean adaugaAutovehicul(Autovehicul a)
    {
	if(a.calculeazaGreutateTotala()+this.calculeazaGreutateTotala() <= gmax)
	    {
		list.add(a);
		return true;
	    }
	return false;
    }
    public String toString()
    {
	String s="Greutate maxima:"+gmax+",(";
	Iterator<Autovehicul> it=list.iterator();
	while(it.hasNext())
	    {
		s+=it.next().toString();
		if(it.hasNext())
		    {
			s+=",";
		    }
	    }
	return s+")";
    }
}
class Main{
    public static void main(String[] args)
    {
	Autoturism a1=new Autoturism("A1",4,0.3);
	Autoturism a2=new Autoturism("A2",5,0.25);
	Autoturism a3=new Autoturism("A3",4.5,0.15);

	Camion c1=new Camion("C1",10);
	c1.adaugaAutoturism(a1);
	c1.adaugaAutoturism(a2);

	Bac b1=new Bac(20);
	b1.adaugaAutovehicul(c1);
	b1.adaugaAutovehicul(a3);
	System.out.println(b1);
    }
}
