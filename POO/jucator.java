class Jucator{
    private String nume;
    private int nr;
    public Jucator (String nume,int nr)
    {
	this.nume=nume;
	this.nr=nr;
    }
    public String Nume()
    {
	return nume;
    }
    public int valueNr()
    {
	return nr;
    }
    public boolean equals(Object o)
    {
	if(o==null)
	    return false;
	if(o instanceof Jucator)
	    {
		Jucator tmp=(Jucator)o;
		return tmp.Nume().equals(this.nume) && tmp.valueNr()==this.nr;
	    }
	return  false;
	
    }
    public String toString()
    {
	return "("+nume+","+nr+")";
    }
}
class Echipa{
    private Jucator[] titulari,rezerve;
    private int sizet,sizer;
    public Echipa(Jucator[] t,Jucator[] r)
    {
	titulari=new Jucator[t.length];
	sizet=t.length;
	titulari=t;
	rezerve=new Jucator[r.length];
	sizer=r.length;
	rezerve=r;
    }
    public boolean efectueazaSchimbare(Jucator t,Jucator r)
    {
	int ok=0,i,j;
	for(i=0;i<sizet;i++)
	    if(titulari[i].equals(t))
		{
		    ok=1;
		    break;
		}
	if(ok==0)
	    return false;
	ok=0;
	for(j=0;j<sizer;j++)
	    if(rezerve[j].equals(r))
		{
		    ok=1;
		    break;
		}
	if(ok==0)
	    return false;
	titulari[i]=r;
	rezerve[j]=t;
	return true;
    }
    public String toString()
    {
	StringBuilder tmp=new StringBuilder("Titulari:\n");
	for(int i=0;i<sizet;i++)
	    tmp.append(titulari[i]).append("\n");
	tmp.append("\nRezerve:\n");
	for(int i=0;i<sizer;i++)
	    tmp.append(rezerve[i]).append("\n");
	return tmp.toString();
    }
    
    
}
class Main{
    public static void main(String[] args)
    {
	Jucator t[]={
	    new Jucator("Messi",10),
	    new Jucator("Ronaldo",7),
	    new Jucator("Neymar",11),
	    new Jucator("Sergio Ramos",4),
	    new Jucator("Buffon",1)
	};
	Jucator r[]={
	    new Jucator("Pique",3),
	    new Jucator("Kevin de Bruyne",17),
	    new Jucator("Busquets",5),
	    new Jucator("Kroos",8),
	    new Jucator("Alisson",13)
	};
	Echipa e=new Echipa(t,r);
	System.out.println(e);
	if(!e.efectueazaSchimbare(t[1],r[1])) System.out.println("Eroare schimbare");
	System.out.println(e);
    }
}
