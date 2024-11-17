abstract class Greutate{
    protected int cap;
    public int capacitate()
    {
	return cap;
    }
}
class Simple extends Greutate{
    public Simple(int c)
    {
	cap=c;
    }
}
abstract class Complex extends Greutate{ //Complex-dubla sau multipla
    protected Greutate[] tab;
    protected int size;
    public Complex(Greutate g1,Greutate g2)
    {
	tab=new Greutate[2];
	tab[0]=g1;
	tab[1]=g2;
	size=2;
    }
    public Complex(Greutate g[])
    {
	tab=new Greutate[g.length];
	for(int i=0;i<g.length;i++)
	    this.tab[i]=g[i];
	size=g.length;
    }
    public int capacitate()
    {
	int s=0;
	for(int i=0;i<size;i++)
	    s+=tab[i].capacitate();
	return s;
    }
}
class Duble extends Complex{
    public Duble(Greutate g1,Greutate g2)
    {
        super(g1,g2);
    }
    public void setGreutate1(Greutate g)
    {
	tab[0]=g;
    }
    public void setGreutate2(Greutate g)
    {
	tab[1]=g;
    }
}
class Multiple extends Complex{
    public Multiple(Greutate g[])
    {
	super(g);
    }
}
class ColectieGreutati{
    private Greutate[] colectie;
    private int size;
    public ColectieGreutati()
    {
	colectie=new Greutate[20];
	size=0;
    }
    public void adauga(Greutate g)
    {
        if(size<colectie.length)
	    {
		colectie[size++]=g;
	    }
    }
    public double medie()
    {
	int s=0;
	for(int i=0;i<size;i++)
	    s+=colectie[i].capacitate();
	return (double)s/size;
    }
    public int fullCapacity()//nu face parte din problema,ii doar de debugging;
    {
	int s=0;
	for(int i=0;i<size;i++)
	    s+=colectie[i].capacitate();
	return s;
    }
}
class Main{
    public static void main(String[] args)
    {
	//exemplu basic
	ColectieGreutati c=new ColectieGreutati();
	Greutate g1=new Simple(20);
	Greutate g2=new Simple(30);
	Greutate g3=new Simple(35);
	Greutate g4=new Duble(g2,g3);
	Greutate[] g_aux={new Simple(5),new Simple(10),new Simple(15),new Simple(20)};
	Greutate g5=new Multiple(g_aux);

	c.adauga(g1);
	c.adauga(g4);
	c.adauga(g5);
	System.out.println("FullCapacity:"+c.fullCapacity()+"\n"+c.medie());


	//exemplu complex/for testing
	ColectieGreutati c2=new ColectieGreutati();
	Greutate a1=new Simple(20);//20 simpla

	
	Greutate a2=new Simple(30);
	Greutate a3=new Simple(35);
	Greutate a4=new Duble(a2,a3);

	Greutate a5=new Simple(5);
	Greutate a6=new Simple(10);
	Greutate a7=new Duble(a5,a6);

	Greutate a8=new Duble(a4,a7);//80 dubla formata din doua duble
	((Duble)a8).setGreutate1(a4);
	((Duble)a8).setGreutate2(a7);

	
	Greutate a9=new Simple(30);
	Greutate a10=new Simple(10);
	Greutate a11=new Duble(a9,a10);//40

	Greutate[] a_aux={new Simple(5),new Simple(10),new Simple(15),new Simple(20)};
	Greutate a12=new Multiple(g_aux);//50 multipla

	Greutate[] a2_aux={a11,a12,new Simple(10),new Simple(20)};//40+50+10+20=120
	Greutate a13=new Multiple(a2_aux);//120

	

	c2.adauga(a1);//20
	c2.adauga(a8);//80
	c2.adauga(a13);//120
	System.out.println("\n\nFullCapacity:"+c2.fullCapacity()+"\n"+c2.medie());
    }
}
