import java.util.*;
abstract class Destinatar{
    protected String nume;
    protected Destinatar(String nume)
    {
	this.nume=nume;
    }
    abstract void receptioneaza(Utilizator u,String mesaj);
    public boolean equals(Object o)
    {
	if(o==null)
	    return false;
	if(o instanceof Destinatar)
	    {
		return this.nume.equals(((Destinatar)o).nume);
	    }
	return false;
    }
}
class Utilizator extends Destinatar{
    private String jurnal;
    public Utilizator(String nume)
    {
	super(nume);
	this.jurnal="";
    }
    public void trimite(Destinatar d,String mesaj)
    {
	this.jurnal+="Trimis catre "+d.nume+" mesajul:"+mesaj+"\n";
	d.receptioneaza(this,mesaj);
    }
    public void receptioneaza(Utilizator u,String mesaj)
    {
	jurnal+="Primit de la "+u.nume+" mesajul:"+mesaj+"\n";
    }
    public String toString()
    {
	return this.nume+":\n"+jurnal;
    }
}
class DestinatarDublicat extends Exception{
    public DestinatarDublicat()
    {
	super("DESTINATAR DUBLICAT!\n");
    }
}
class Grup extends Destinatar{
    private List<Destinatar> list;
    public Grup(String nume)
    {
	super(nume);
	this.list=new ArrayList<Destinatar>();
    }
    public void inscrie(Destinatar d)throws DestinatarDublicat
    {
	Iterator<Destinatar> it=list.iterator();
	while(it.hasNext())
	    {
		if(it.next().equals(d))
		    throw new DestinatarDublicat();
	    }
	list.add(d);
    }
    public void receptioneaza(Utilizator u,String mesaj)
    {
	for(Destinatar d:list)
	    {
		if(d.equals(u)==false)
		    d.receptioneaza(u,mesaj);
	    }
    }
}
class Main{
    public static void main(String[] args)
    {
	Utilizator u1=new Utilizator("Dan");
	Utilizator u2=new Utilizator("Marius");
	Utilizator u3=new Utilizator("Alex");

	Grup g1=new Grup("Carnivorii");
	try{
	    g1.inscrie(u1);
	}catch(DestinatarDublicat e){
	    System.out.println(e.getMessage());
	}
	try{
	    g1.inscrie(u2);
	}catch(DestinatarDublicat e){
	    System.out.println(e.getMessage());
	}
	try{
	    g1.inscrie(u3);
	}catch(DestinatarDublicat e){
	    System.out.println(e.getMessage());
	}
	try{
	    g1.inscrie(u3);
	}catch(DestinatarDublicat e){
	    System.out.println(e.getMessage());
	}

	u3.trimite(g1,"Am deschis magazinul");
	u2.trimite(g1,"Vin acuma");

	System.out.println(u1);
	System.out.println(u2);
	System.out.println(u3);
    }
}
