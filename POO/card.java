class Card{
    private String numar;
    private int sold;
    public Card(String numar,int sold)
    {
	this.numar=numar;
	this.sold=sold;
    }
    public String Numar()
    {
	return numar;
    }
    public int Sold()
    {
	return sold;
    }
    public String toString()
    {
	return "("+numar+"-"+sold+")";
    }
}
class Portofel{
    private String nume;
    private Card[] c=new Card[6];
    private int size;
    public Portofel(String nume)
    {
	size=0;
	this.nume=nume;
    }
    public boolean adaugaCard(String n,int s)
    {
	if(size<c.length)
	    {
		for(int i=0;i<size;i++)
		    if(n.equals(c[i].Numar()))
			return false;
		Card tmp=new Card(n,s);
		c[size++]=tmp;
		return true;
	    }
	return false;
    }
    public String toString()
    {
	StringBuilder tmp=new StringBuilder(nume).append(":");
	for(int i=0;i<size;i++)
	    tmp.append(c[i]).append(" ");
	return tmp.toString();
    }
    public int calculeazaSold()
    {
	int s=0;
	for(int i=0;i<size;i++)
	    {
		s+=c[i].Sold();
	    }
	return s;
    }
    
}
class Main{
    public static void main(String[] args)
    {
	Portofel p=new Portofel("Portofel");
	if(!p.adaugaCard("RZBR1",30)) System.out.println("Err");
	if(!p.adaugaCard("RZBR2",40)) System.out.println("Err");
	if(!p.adaugaCard("RZBR1",80)) System.out.println("Err");
	if(!p.adaugaCard("RZBR3",100)) System.out.println("Err");
	System.out.println(p+"\n"+p.calculeazaSold());
	
    }
}
