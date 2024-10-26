class Figura{
    private double arie;
    public Figura(double arie)
    {
	this.arie=arie;
    }
    public double valArie()
    {
	return arie;
    }
    public String toString()
    {
	return ""+arie;
    }
}
class Desen{
    private String titlu;
    private Figura[] a;
    private int size;
    public Desen(String titlu)
    {
	this.titlu=titlu;
	a=new Figura[1024];
	this.size=0;
    }
    public boolean adaugaFigura(Figura o)
    {
	for(int i=0;i<size;i++)
	    if(a[i]==o)
		return false;
	if(size<a.length)
	    {
		a[size++]=o;
		return true;
	    }
	return false;
    }
    public String toString()
    {
	StringBuilder tmp=new StringBuilder(titlu+" ");
	for(int i=0;i<size;i++)
	    {
		tmp.append("fig"+(i+1)+":"+a[i]+" ");
	    }
	return tmp.toString();
    }
    public double medieArie()
    {
	if(size==0)
	    return 0;
	double s=0.0;
	for(int i=0;i<size;i++)
	    {
		s+=a[i].valArie();
	    }
	return (double)s/size;
    }
}
class Main{
    public static void main(String args[])
    {
	Desen d=new Desen("D10");
	Figura f1=new Figura(3.529);
	Figura f2=new Figura(6.171);
	Figura f3=new Figura(7.834);
	if(!d.adaugaFigura(f1)) System.out.println("err");
	if(!d.adaugaFigura(f2)) System.out.println("err");
	if(!d.adaugaFigura(f3)) System.out.println("err");
	//if(!d.adaugaFigura(f2)) System.out.println("err");
	System.out.println(d);
	System.out.println("Media ariilor:"+d.medieArie());
    }
}
