import java.util.Random;
import java.util.Date;

class Out extends Exception{
    public Out()
    {
	super("Out\n\n");
    }
}
class Gol extends Exception{
    public Gol()
    {
	super("GOOOOOOOOOL\n\n");
    }
}
class Corner extends Exception{
    public Corner()
    {
	super("Corner\n\n");
    }
}
class Minge{
    private double x,y;
    private static CoordinateGenerator c=new CoordinateGenerator();
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
    public void suteaza()throws Out,Gol,Corner
    {
	x=c.generateX();
	y=c.generateY();
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
    private int outuri=0,cornere=0;
    
    public Joc(String e1,String e2)
    {
	this.e1=e1;
	this.e2=e2;
	e1_goluri=0;
	e2_goluri=0;
    }
    private void display(double x,double y)
    {
	System.out.println(e1+" - "+e2+": Ball position:("+x+" , "+y+")");
    }
    public String toString()
    {
	return e1+" "+e1_goluri+" - "+e2_goluri+" "+e2+"\nOuturi: "+outuri+"\nCornere: "+cornere;
    }
    public void simuleaza()
    {
	System.out.println(this);
	Minge ball=new Minge(50.0,25.0);
	this.display(ball.getX(),ball.getY());
	for(int i=0;i<1000;i++)
	    {
		try{
		    ball.suteaza();
		    this.display(ball.getX(),ball.getY());
		}catch(Gol g){
		    this.display(ball.getX(),ball.getY());
		    System.out.println(g.getMessage());
		    if(ball.getX()==0)
			e2_goluri++;
		    else
			e1_goluri++;
		    System.out.println(this);
		    ball=new Minge(50.0,25.0);
		    this.display(ball.getX(),ball.getY());
		    
		}catch(Out o){
		    this.display(ball.getX(),ball.getY());
		    System.out.println(o.getMessage());
		    outuri++;
		    System.out.println(this);
		    ball=new Minge(ball.getX(),ball.getY());
		    this.display(ball.getX(),ball.getY());
		    
		}catch(Corner corn){
		    this.display(ball.getX(),ball.getY());
		    System.out.println(corn.getMessage());
		    cornere++;
		    System.out.println(this);
		    if(ball.getY()<20)
			ball=new Minge(ball.getX(),0.0);
		    else
			ball=new Minge(ball.getX(),50.0);
		    this.display(ball.getX(),ball.getY());
		}finally{
		    //this.display(ball.getX(),ball.getY());
		}
		
	    }
    }
    
}
class Main{
    public static void main(String[] args)
    {
	Joc ElClassico=new Joc("Real Madrid","Barcelona");
	Joc DerKlassiker=new Joc("Bayern Munich","Borussia Dortmund");

	ElClassico.simuleaza();
	//DerKlassiker.simuleaza();
	System.out.println(ElClassico);  
	//System.out.println(DerKlassiker);
    }
}
class CoordinateGenerator {
  private Random randomGenerator;
    
  public CoordinateGenerator() {
    Date now = new Date();
    long sec = now.getTime();
    randomGenerator = new Random(sec);
  }
  public int generateX() {
    int x = randomGenerator.nextInt(101);
    if(x < 5) {
      x = 0;
    } else if(x > 95) {
      x = 100;
    } else {
      x = randomGenerator.nextInt(99) + 1;
    }
    return x;
}
  public int generateY() {
  int y = randomGenerator.nextInt(101);
  if(y < 5) {
    y = 0;
  } else if(y > 95) {
    y = 50;
  } else {
    y = randomGenerator.nextInt(49) + 1;
  }
    return y;
  }
}