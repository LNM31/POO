import java.io.*;
import java.util.*;
import java.util.Random;
class Telefon{
    private String nume;
    private String[] tab=new String[100];
    private int size;
    public Telefon(String nume)
    {
	this.nume=nume;
	this.size=0;
    }
    public boolean apeleaza(Telefon o)
    {
	if(o.size<o.tab.length)
	    {
		o.tab[o.size++]=this.nume;
		return true;
	    }
	return false;
    }
    public Integer numarDeApeluri(String e)
    {
	Integer c;
	int count=0;
	for(int i=0;i<this.size;i++)
	    {
		if(tab[i].equals(e))
		    count++;
	    }
	c=Integer.valueOf(count);
	return c;
    }
    public String toString()
    {
	int ok=0;
	String tmp="Nume prop:"+this.nume+" Apelanti:";
	for(int i=0;i<this.size;i++)
	    {
		tmp+=tab[i]+" ";
		ok=1;
	    }
	if(ok==0)
	    tmp+="0 ";
	return tmp;	
    }
    /*
    public String toString1()
    {
        StringBuilder tmp = new StringBuilder("Nume prop: " + this.nume + "\n");
        for (int i = 0; i < this.size; i++) {
            tmp.append(tab[i]).append("\n");
        }
        tmp.append("\n");
        return tmp.toString();
    }*/
    
}
class Main{
    public static void main(String args[])
    {
	int n=0,A=0,x,y;
	Telefon[] a=null;
	String prop=null;
	Random rand=new Random();
	try
	    {
		Scanner s=new Scanner(System.in);
		//System.out.print("Nr telefoane:");
		if(s.hasNextInt())
		    {
			n=s.nextInt();
		    }
		a=new Telefon[n];
		//System.out.print("Nume prop:");
		for(int i=0;i<n;i++)
		    {
			if(s.hasNext())
			    {
				a[i]=new Telefon(s.next());
			    }
			else
			    break;
		    }
		//System.out.print("Convorbiri:");
		if(s.hasNextInt())
		    {
			A=s.nextInt();
		    }
		//System.out.print("Proprietar:");
		if(s.hasNext())
		    {
			prop=s.next();
		    }
		s.close();
	    }catch(InputMismatchException e)
	    {
		System.out.println(e);
	    }
        for(int i=0;i<A;i++)
	    {
		x=rand.nextInt(n);
		y=rand.nextInt(n);
		a[x].apeleaza(a[y]);
		System.out.println("x:"+x+" y:"+y);
		
	    }
	for(int i=0;i<n;i++)
	    System.out.println(a[i]+" A fost apelat/apelata de "+prop+" de "+a[i].numarDeApeluri(prop)+" ori");
    }
}
