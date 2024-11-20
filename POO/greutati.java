abstract class Greutate{
    abstract public int capacitate();
}
class Simple extends Greutate{
    private int cap;
    public Simple(int c)
    {
	cap=c;
    }
    public int capacitate()
    {
	return cap;
    }
}
abstract class Complex extends Greutate{//duble sau multiple
    protected Greutate[] tab;
    public int capacitate()
    {
	int s=0;
	for(int i=0;i<tab.length;i++)
	    {
		s+=tab[i].capacitate();
	    }
	return s;
    }
}
class Duble extends Complex{
    public Duble(Greutate g1,Greutate g2)
    {
        tab=new Greutate[2];
	tab[0]=g1;
	tab[1]=g2;
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
    public Multiple(Greutate[] g)
    {
	tab=g;
    }
}
class ColectieGreutati{
    private Greutate[] colectie;
    private int size;
    public ColectieGreutati()
    {
	colectie=new Greutate[30];
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
	    {
		s+=colectie[i].capacitate();
	    }
	return (double)s/size;
    }
    public int fullCapacity()
    {
	int s=0;
	for(int i=0;i<size;i++)
	    {
		s+=colectie[i].capacitate();
	    }
	return s;
    }
}
class Main{
    public static void main(String[] args)
    {
	Greutate g1=new Simple(20);
	Greutate g2=new Simple(30);
	Greutate g3=new Simple(35);

	Greutate g4=new Duble(g2,g3);
	Greutate[] g_aux={new Simple(5),new Simple(10),new Simple(15),new Simple(20)};
	Greutate g5=new Multiple(g_aux);

	ColectieGreutati c=new ColectieGreutati();
	c.adauga(g1);
	c.adauga(g4);
	c.adauga(g5);
	System.out.println("FullCapacity: "+c.fullCapacity()+" Medie: "+c.medie());
    }
}