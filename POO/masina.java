class Masina{
    private String inmat;
    private int cantitate;
    public Masina(String i,int c)
    {
	this.inmat=i;
	this.cantitate=c;
    }
    public String nrInmat()
    {
	return inmat;
    }
    public int valueCant()
    {
	return cantitate;
    }
    public String toString()
    {
	return "("+inmat+","+cantitate+" litri)";
    }
}
class Benzinarie{
    private int cantitate_benz;
    private Masina[] m;
    private int size;
    public Benzinarie(int c)
    {
	this.cantitate_benz=c;
	m=new Masina[10];
	size=0;
    }
    public boolean alimenteazaMasina(Masina o)
    {
	if(o.valueCant()<=this.cantitate_benz)
	    {
		this.cantitate_benz=this.cantitate_benz-o.valueCant();
		return true;
	    }
	else if(size<m.length)
	    {
		m[size++]=o;
		return true;
	    }
	return false;
    }
    public String toString()
    {
	StringBuilder tmp=new StringBuilder("Coada Benzinarie:");
	if(size==0)
	    {
		tmp.append("0\n");
		return tmp.toString();
	    }
	for(int i=0;i<size;i++)
	    {
		tmp.append(" Masina"+(i+1)+":"+m[i]);
	    }
	tmp.append("\n");
	return tmp.toString();
    }
    public void alimenteazaBenzinarie(int rezerva)
    {
	cantitate_benz+=rezerva;
	int masini_umplute=0;
	for(int i=0;i<size;i++)
	    {
		if(m[i].valueCant()<=cantitate_benz)
		    {
			cantitate_benz=cantitate_benz-m[i].valueCant();
			masini_umplute++;
		    }
		else
		    break;
	    }
	for(int i=0;i<size-masini_umplute;i++)
	    {
		m[i]=m[i+masini_umplute];
	    }
	for(int i=1;i<=masini_umplute;i++)
	    {
		m[size-i]=null;
	    }
	size=size-masini_umplute;
    }
}
class Main{
    public static void main (String[] args)
    {
	/*
	Benzinarie b=new Benzinarie(25);
	Masina m1=new Masina("CS72KAD",5);
	Masina m2=new Masina("TM19YAM",10);
	Masina m3=new Masina("CJ66TRE",15);

	if(!b.alimenteazaMasina(m1)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m2)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m3)) System.out.println("NU MAI E LOC LA COADA!");

	System.out.println(b);
	b.alimenteazaBenzinarie(30);
	System.out.println(b);
	*/

	Benzinarie b=new Benzinarie(200);
	Masina m1=new Masina("CS72KAD",30);
	Masina m2=new Masina("TM19YAM",40);
	Masina m3=new Masina("CJ66TRE",70);
	Masina m4=new Masina("BV06GAV",50);
	Masina m5=new Masina("MH90NEG",30);
	Masina m6=new Masina("AB20OLM",25);
	Masina m7=new Masina("TG46BEN",40);
	Masina m8=new Masina("AD15VAL",25);

	if(!b.alimenteazaMasina(m1)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m2)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m3)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m4)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m5)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m6)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m7)) System.out.println("NU MAI E LOC LA COADA!");
	if(!b.alimenteazaMasina(m8)) System.out.println("NU MAI E LOC LA COADA!");
        

	System.out.println(b);
	b.alimenteazaBenzinarie(60);
	System.out.println(b);
    }
}
