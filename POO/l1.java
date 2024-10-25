
class Complex{
    private double x,y;
    public static int nr_afis=0;
    public Complex(double a,double b)
    {
	this.x=a;
	this.y=b;
    }
    public double modul()
    {
	return Math.sqrt(x*x+y*y);
    }
    public void display()
    {
	System.out.println(x+" "+y+"*i");
	nr_afis++;
    }
    public Complex suma(Complex m)
    {
	Complex s;
	s=new Complex(0.0,0.0);
	s.x=x+m.x;
	s.y=y+m.y;
	return s;
    }
    public static int frecv()
    {
	return nr_afis;
    }
    
}
class Main
{
    public static void main(String[] args)
    {
	Complex n1,n2;
        n1=new Complex(1.23,5.32);
        n2=new Complex(3.14,6.91);
	System.out.println(n1.modul());
	n1.display();
	n1.suma(n2).display();
	System.out.println(Complex.nr_afis);
    }
}
