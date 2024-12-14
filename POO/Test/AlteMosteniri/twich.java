import java.util.*;
abstract class Utilizator{
    protected String nume;
    protected Utilizator(String nume)
    {
	this.nume=nume;
    }
    abstract public double calculeazaVenit(int minute);
}

class Subscriber extends Utilizator{
    private int nivel;
    public Subscriber(String n,int niv)
    {
	super(n);
	this.nivel=niv;
    }
    public double calculeazaVenit(int minute)
    {
	return minute*1.5*nivel;
    }
    public String toString()
    {
	return "("+nume+" - subscriber - "+nivel+")";
    }
}
class Creator extends Utilizator{
    private List<Subscriber> list;
    public Creator(String n)
    {
	super(n);
	list=new ArrayList<Subscriber>();
    }
    public void adaugaSubscriber(Subscriber s)
    {
	list.add(s);
    }
    public double calculeazaVenit(int minute)
    {
	double d=0.0;
	for(Subscriber s:list)
	    {
		d+=s.calculeazaVenit(minute);
	    }
	return d;
    }
    public String toString()
    {
	Iterator<Subscriber> it=list.iterator();
	String s=nume+" - creator ->\n";
	while(it.hasNext())
	    {
		s+=it.next().toString()+"\n";
	    }
	return s;
    }
}
class Platforma{
    private Utilizator[] tab;
    private int size;
    public Platforma()
    {
	tab=new Utilizator[1000];
	size=0;
    }
    public boolean adaugaUtilizator(Utilizator u)
    {
	if(size<tab.length)
	    {
		tab[size++]=u;
		return true;
	    }
	return false;
    }
    public Utilizator determinaVIP(int minute)
    {
	double maxim=0,aux;
	Utilizator u=null;
	for(int i=0;i<size;i++)
	    {
		aux=tab[i].calculeazaVenit(minute);
		if(aux>=maxim)
		    {
			maxim=aux;
			u=tab[i];
		    }
	    }
	return u;
    }
}
class Main{
    public static void main(String[] args)
    {
	Platforma p=new Platforma();
	
	Subscriber s1=new Subscriber("S1",5);
	Subscriber s2=new Subscriber("S2",10);
	Creator c1=new Creator("C1");
	c1.adaugaSubscriber(s1);
	c1.adaugaSubscriber(s2);
	//System.out.println(c1);

	Subscriber s3=new Subscriber("S3",4);
	Subscriber s4=new Subscriber("S4",8);
	Subscriber s5=new Subscriber("S5",7);
	Creator c2=new Creator("C2");
	c2.adaugaSubscriber(s3);
	c2.adaugaSubscriber(s4);
	c2.adaugaSubscriber(s5);
	//System.out.println(c2);

	Subscriber s6=new Subscriber("S6",5);
	//System.out.println(s6);
	
	p.adaugaUtilizator(c1);
	p.adaugaUtilizator(c2);
	p.adaugaUtilizator(s6);

	Utilizator u=p.determinaVIP(30);
	System.out.println(u);
    }
}
