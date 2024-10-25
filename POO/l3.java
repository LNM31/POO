class l3{
    public static void main(String[] args)
    {
	//5
	System.out.println("s1:"+Suma.suma(5,7)+" s2:"+Suma.suma(8,3,2)+" s3:"+Suma.suma(1,2,3,4));
	
	//4
	Piramida o=new Piramida(4);
	o.display();

	//3
	Patrat p1=new Patrat();
	p1.display();
	Patrat p2=new Patrat(5);
	p2.display();

	//2
	Carte c1=new Carte(133);
	Carte c2=new Carte(133);
        c1.comp(c2);
	
    }
}
class Carte{
    private int nr_pag;
    public Carte(int x)
    {
	nr_pag=x;
    }
    public int pag()
    {
	return nr_pag;
    }
    public void comp(Carte c)
    {
	if(nr_pag==c.pag())
	    System.out.println("Cartile sunt identice");
	else
	    System.out.println("Cartile nu sunt identice");
    }
}
class Patrat{
    private int l;
    public Patrat()
    {
	l=10;
    }
    public Patrat(int l)
    {
	this.l=l;
    }
    public void display()
    {
	System.out.println("Patrat "+l+" Aria "+l*l);
    }
}
class Piramida{
    private int n;
    public Piramida(int a)
    {
	this.n=a;
    }
    public void display()
    {
	int aux=1;
	for(int i=0;i<n;i++)
	    {
		for(int j=0;j<n-i;j++)
		    System.out.print(aux+" ");
		aux++;
		System.out.println();
	    }
    }
}
class Suma{

    public static int suma(int a,int b)
    {
	return a+b;
    }
    public static int suma(int a,int b,int c)
    {
	return a+b+c;
    }
    public static int suma(int a,int b,int c,int d)
    {
	return a+b+c+d;
    }
}

