import java.util.*;
abstract class Destinatar{
    protected String nume;
    public Destinatar(String nume)
    {
	this.nume=nume;
    }
    abstract public void receptioneaza(Utilizator u,String mesaj);
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
	jurnal="";
    }
    public void trimite(Destinatar d,String mesaj)
    {
	jurnal+="Trimis catre "+d.nume+" mesajul: "+mesaj+"\n";
	d.receptioneaza(this,mesaj);
    }
    public void receptioneaza(Utilizator u,String mesaj)
    {
	jurnal+="Primit de la "+u.nume+" mesajul: "+mesaj+"\n";
    }
    public String toString()
    {
	return this.nume+":\n"+jurnal;
    }
}
class DestinatarDublicat extends Exception{
    public DestinatarDublicat()
    {
	super("DESTINATAR_DUBLICAT!\n");
    }
}
class Grup extends Destinatar{
    private List<Destinatar> list;
    public Grup(String nume)
    {
	super(nume);
	list=new ArrayList<Destinatar>();
    }
    public void inscrie(Destinatar d)
    {
	Iterator<Destinatar> it=list.iterator();
	boolean ok=true;
	while(it.hasNext())
	    {
		try{
		    if(it.next().equals(d))
			throw new DestinatarDublicat();
		    
		}catch(DestinatarDublicat e){
		    ok=false;
		    System.out.println(e.getMessage());
		    break;
		}
	    }
	if(ok)
	    list.add(d);
    }
    public void receptioneaza(Utilizator u,String mesaj)
    {
	for(Destinatar dest:list)
	    {
		if(dest.equals(u)==false)
		    dest.receptioneaza(u,mesaj);
	    }
    }
    
}
class Main{
    public static void main(String[] args)
    {
	Utilizator d1=new Utilizator("Dan");
	Utilizator d2=new Utilizator("Marius");
	Utilizator d3=new Utilizator("Alex");

	Grup grup=new Grup("Carnivorii");
	grup.inscrie(d1);
	grup.inscrie(d2);
	grup.inscrie(d3);
	grup.inscrie(d3);

	d3.trimite(grup,"Am deschis magazinul");
	d2.trimite(grup,"Vin acuma");

	System.out.println(d1+"\n"+d2+"\n"+d3);
    }
}