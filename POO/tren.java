class Function{
    public static int minim(int a,int b)
    {
	return a<b ? a:b;
    }
}
class Tren{
    private Vagon[] v=new Vagon[15];
    private int size;
    public Tren(Vagon va[])
    {
	this.v=va;
	size=va.length;
    }
    private int coleteVagon()
    {
	int s=0;
	for(int i=0;i<size;i++)
	    s+=v[i].Colete();
	return s;
    }
    public boolean equals(Object o)
    {
	if(o==null)
	    return false;
	if(o instanceof Tren)
	    {
		return this.coleteVagon()==((Tren)o).coleteVagon();
	    }
	return false;
    }
    public String toString()
    {
	StringBuilder tmp=new StringBuilder();
	for(int i=0;i<size;i++)
	    tmp.append(v[i]).append(" ");
	return tmp.toString();
    }
}
abstract class Vagon{
    protected int colete;
    public Vagon(int c)
    {
	colete=Function.minim(c,400);
    }
    public int Colete()
    {
	return colete;
    }  
}
class Marfa extends Vagon
{
    public Marfa(int c)
    {
	super(c);
    }
    public String toString()
    {
	return "Marfa";
    }
}
abstract class Calatori extends Vagon{
    protected int capacitate;
    public Calatori(int c,int co)
    {
	super(co);
	capacitate=Function.minim(50,c);
    }
    public void deschidere()
    {
	System.out.println(capacitate+" S au deshis usile");
    }
    public void inchidere()
    {
	System.out.println(capacitate+" S au inchis usile");
    }
    public int Capacitate()
    {
	return capacitate;
    }
}
class CalatoriA extends Calatori{
    public CalatoriA(int c,int co)
    {
	super(Function.minim(40,c),Function.minim(300,co));
    }
    public String toString()
    {
	return "CalatoriA";
    }
}
class CalatoriB extends Calatori{
    public CalatoriB(int c,int co)
    {
	super(c,co);
    }
    public void blocare()
    {
	System.out.println(capacitate+" S au blocat geamurile");
    }
    public String toString()
    {
	return "CalatoriB";
    }
}
class Main{
    public static void main(String[] args)
    {
	Vagon[] v1={
	    new CalatoriA(30,120),
	    new CalatoriB(45,140),
	    new Marfa(500),//400
	    new CalatoriB(60,100)
	};//760
	Vagon[] v2={
	    new Marfa(200),
	    new CalatoriB(10,110),
	    new Marfa(270),//400
	    new CalatoriA(30,180)
	};//710
	Tren t1=new Tren(v1);
	Tren t2=new Tren(v2);
	System.out.println(t1);
	System.out.println(t2);
	if(t1.equals(t2))
	    System.out.println("Sunt egale");
	else
	    System.out.println("Nu sunt egale");
    }
}
