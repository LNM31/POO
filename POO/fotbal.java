import java.util.Random;
import java.util.Date;

class Out extends Exception{
    public Out()
    {
	super("Out");
    }
}
class Gol extends Exception{
    public Gol(){
	super("Gol");
    }
}
class Corner extends Exception{
    public Corner(){
	super("Corner");
    }
}
class Minge{
    private double x,y;
    
    public Minge(double x,double y)
    {
	this.x=x;
	this.y=y;
    }
    public double getX()
    {
	return x;
    }
    public double getY()
    {
	return y;
    }
    public void suteaza(double x_new,double y_new) throws Out,Gol,Corner
    {
	x=x_new;
	y=y_new;
	if(y==0 || y==50) throw new Out();
	if(x==0 || x==100)
	    {
		if(y>=20 && y<=30) throw new Gol();
	        throw new Corner();
	    }
    }
    
}
class Joc{
    private String e1,e2;
    private int e1_goluri,e2_goluri;
    private static int outuri=0,cornere=0;

    public Joc(String e1,String e2)
    {
	this.e1=e1;
	this.e2=e2;
	e1_goluri=0;
	e2_goluri=0;
    }
    public String toString()
    {
	return e1+" "+e1_goluri+" - "+e2_goluri+" "+e2+"\nOut-uri: "+outuri+"\nCornere: "+cornere;
    }
    private void display(double x,double y)
    {
	System.out.println(e1+" - "+e2+" : Ball position : ("+x+","+y+")");
    }
    public void simuleaza()
    {
	Minge ball=new Minge(50.0,25.0);
	this.display(ball.getX(),ball.getY());
	CoordinateGenerator c=new CoordinateGenerator();
	for(int i=0;i<1000;i++)
	    {
		try{
		    ball.suteaza(c.generateX(),c.generateY());
		    this.display(ball.getX(),ball.getY());
		    
		}catch(Gol g){
		    this.display(ball.getX(),ball.getY());
		    if(ball.getX()==0)
			e2_goluri++;
		    else
			e1_goluri++;
		    ball=new Minge(50.0,25.0);
		    System.out.println("GOOOOOOL\n\n");
		    System.out.println(this);		    
		    this.display(ball.getX(),ball.getY());
		    
		}catch(Out o){
		    this.display(ball.getX(),ball.getY());
		    ball=new Minge(ball.getX(),ball.getY());
		    System.out.println("Out\n\n");
		    outuri++;
		    System.out.println(this);
		    this.display(ball.getX(),ball.getY());
		    
		}catch(Corner cor){
		    this.display(ball.getX(),ball.getY());
		    if(ball.getY()<20)
			ball=new Minge(ball.getX(),0.0);
		    else
			ball=new Minge(ball.getX(),50.0);
		    System.out.println("Corner\n\n");
		    cornere++;
		    System.out.println(this);
		    this.display(ball.getX(),ball.getY());
		}	    
	    }
    }
}
class Main{
    public static void main(String[] args)
    {
	Joc ElClassico=new Joc("Barcelona","Real Madrid");
	ElClassico.simuleaza();
	System.out.println(ElClassico);
	Joc DerKlassiker=new Joc("Bayern Munchen","Borussia Dordmund");
	DerKlassiker.simuleaza();
	System.out.println(DerKlassiker);
    }
}

class CoordinateGenerator{
    private Random rand;
    
    public CoordinateGenerator(){
	Date now=new Date();
	long sec=now.getTime();
	rand=new Random(sec);
    }
    public int generateX()
    {
	int x=rand.nextInt(101);
	if(x<5)
	    {
		x=0;
	    }
	else if(x>95)
	    {
		x=100;
	    }
	else
	    {
		x=rand.nextInt(99)+1;
	    }
	return x;
    }
    public int generateY()
    {
	int y=rand.nextInt(101);
	if(y<5)
	    {
		y=0;
	    }
	else if(y>95)
	    {
		y=50;
	    }
	else
	    {
		y=rand.nextInt(49)+1;
	    }
	return y;
    }
}

