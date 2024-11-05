class FelDeMancare{
    private String nume;
    private int calorii;
    public FelDeMancare(String nume,int calorii)
    {
	this.nume=nume;
	this.calorii=calorii;
    }
    public String Nume()
    {
	return nume;
    }
    public int Calorii()
    {
	return calorii;
    }
    public boolean equals(Object o)
    {
	if(o==null)
	    return false;
	if(o instanceof FelDeMancare)
	    {
		return ((FelDeMancare)o).calorii==this.calorii;
	    }
	return false;
    }
    public String toString()
    {
	return "("+nume+","+calorii+")";
    }
}
class Meniu{
    private int maxcal;
    private FelDeMancare[] a;
    private int size;
    public Meniu(int maxcal)
    {
	this.maxcal=maxcal;
	a=new FelDeMancare[10];
	this.size=0;
    }
    public boolean adaugaFelDeMancare(FelDeMancare o)
    {
	if(size<a.length)
	    {
		if(o.Calorii()<maxcal)
		    {
			a[size++]=o;
			return true;
		    }
		return false;
	    }
	return false;
    }
    public String toString()
    {
	StringBuilder tmp=new StringBuilder(""+maxcal).append(" ");
	for(int i=0;i<size;i++)
	    tmp.append(a[i]).append(" ");
	return tmp.toString();
    }
    public boolean schimbaFelDeMancare(FelDeMancare o)
    {
	for(int i=0;i<size;i++)
	    {
		if(a[i].equals(o))
		    {
			a[i]=o;
			return true;
		    }
	    }
	return false;
    }
    public int getterCalorii()
    {
	int s=0;
	for(int i=0;i<size;i++)
	    s+=a[i].Calorii();
	return s;
    }
}
class Main
{
    public static void main(String[] args)
    {
	Meniu m=new Meniu(430);
	FelDeMancare f1=new FelDeMancare("Mamaliga cu branza",320);
	FelDeMancare f2=new FelDeMancare("Musaca",290);
	FelDeMancare f3=new FelDeMancare("Shaorma",510);
	FelDeMancare f4=new FelDeMancare("Salata",60);
	FelDeMancare f5=new FelDeMancare("Mujdei",290);

	if(!m.adaugaFelDeMancare(f1)) System.out.println("Prea multe calorii!");
	if(!m.adaugaFelDeMancare(f2)) System.out.println("Prea multe calorii!");
	if(!m.adaugaFelDeMancare(f3)) System.out.println("Prea multe calorii!");
	if(!m.adaugaFelDeMancare(f4)) System.out.println("Prea multe calorii!");
	System.out.println(m);

	if(!m.schimbaFelDeMancare(f5)) System.out.println("error");
	System.out.println(m);
	System.out.println(m.getterCalorii());
    }
}
