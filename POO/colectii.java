import java.util.*;
abstract class Tip{
    abstract public String getTip();
    abstract public String toString();
}
class Intreg extends Tip{
    private int valoare;
    public Intreg(int v)
    {
	valoare=v;
    }
    public String getTip()
    {
	return "Tip: Intreg";
    }
    public String toString()
    {
	return ""+valoare;
    }
    public boolean equals(Object o)
    {
	if(o==null)
	    return false;
	if(o instanceof Intreg)
	    return this.valoare==((Intreg)o).valoare;
	return false;
    }
}
class Sir extends Tip{
    private String valoare;
    public Sir(String s)
    {
	valoare=s;
    }
    public String getTip()
    {
	return "Tip: Sir";
    }
    public String toString()
    {
	return valoare;
    }
    public boolean equals(Object o)
    {
	if(o==null)
	    return false;
	if(o instanceof Sir)
	    return this.valoare.equals(((Sir)o).valoare);
	return false;
    }
}
class Colectie extends Tip{
    private List<Tip> col=new ArrayList<Tip>();
    public void adauga(Tip elem)
    {
	col.add(elem);
    }
    public String getTip()
    {
	return "Tip: Colectie";
    }
    public String toString()
    {
	String s="(";
	Iterator<Tip> it=col.iterator();
	while(it.hasNext())
	    {
		s+=it.next().toString();
		if(it.hasNext())
		    {
			s+=",";
		    }
	    }
	s+=")";
	return s;
    }
    public boolean equals(Object o)
    {
	if(o==null)
	    return false;
	if(o instanceof Colectie)
	    {
		 Colectie c=(Colectie)o;
	         return this.col.equals(((Colectie)o).col);
	    }
	return false;
    }
}
class Main{
    
    public static void main(String[] args)
    {
	Colectie colectie=new Colectie();
	colectie.adauga(new Intreg(7));
	colectie.adauga(new Intreg(4));
	colectie.adauga(new Sir("Eu"));
	colectie.adauga(new Intreg(12));
	System.out.println("Colectie1:"+colectie);

	Colectie colectie2=new Colectie();
	colectie2.adauga(new Intreg(7));
	colectie2.adauga(new Intreg(4));
	colectie2.adauga(new Sir("Eu"));
	colectie2.adauga(new Intreg(12));
	System.out.println("Colectie2:"+colectie);

	System.out.println(colectie.equals(colectie2));

	Colectie c2=new Colectie();
	c2.adauga(new Intreg(2));
	c2.adauga(new Intreg(8));
	System.out.println(c2);

	colectie.adauga(c2);
	System.out.println(colectie);

	System.out.println(colectie.equals(colectie2));
    }
}