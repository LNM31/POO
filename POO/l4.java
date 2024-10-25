import java.io.*;
class l4{
  public static void main(String[] args)
  {
    System.out.println("hello world");
  }
}
class ExempluIO{
    public static void main(String[] args)
    {
	int n,i,suma,temporar;
	try
	{
	    BufferedReader citire=new BufferedReader(new InputStreamReader(System.in));
	    PrintStream scriere=new PrintStream(new FileOutputStream("out.txt"));

	    System.out.print("Dati numarul de intregi:");
	    n=Integer.parseInt(citire.readLine());
	    suma=0;
           for(i = 1; i <= n; i++)
	       {
                  System.out.print("Dati numarul " + i + ":");
                  temporar = Integer.parseInt(citire.readLine());
                  suma+= temporar;
                  scriere.println(temporar);
	       }
	   scriere.println(suma);
           System.out.println("Suma este:" + suma);
           scriere.close();
	}catch (IOException e)
	    {
		System.out.println("Eroare la operatiile de intrare-iesire!");
                System.exit(1);
	    }
    }
}
class ex3{
    public static void main(String[] args)
    {
	String linie,nume_fis,l;
	int rez=0;
        try
	{
	    BufferedReader citire=new BufferedReader(new InputStreamReader(System.in));
	    linie=citire.readLine();
	    nume_fis=citire.readLine();
	    BufferedReader f=new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
	    while((l=f.readLine())!=null)
		{
		    if(l.equals(linie))
			rez++;
		}
	    System.out.println(rez);
	    citire.close();
	    f.close();
	    
	}catch(IOException e)
	    {
		System.out.println("eroare");
		System.exit(-1);
	    }
	
    }
}
class ex4{
    public static void main(String[] args)
    {
	int n,m,p,x;
	double z;
	Double[][] a,b,c;
	try{
	    BufferedReader citire=new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("n=");
	    n=Integer.parseInt(citire.readLine());
	    System.out.print("m=");
	    m=Integer.parseInt(citire.readLine());
	    System.out.print("p=");
	    p=Integer.parseInt(citire.readLine());
	    a=new Double[n][m];
	    b=new Double[m][p];
	    c=new Double[n][p];
	    for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		        {
			    System.out.print("Elementul ["+i+"]["+j+"]:");
			    a[i][j]=Double.valueOf(x=Integer.parseInt(citire.readLine()));
			}
		}
	    for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
			System.out.print(a[i][j]+" ");
		    System.out.println();
		}
	    for(int i=0;i<m;i++)
		{
		    for(int j=0;j<p;j++)
		        {
			    System.out.print("Elementul ["+i+"]["+j+"]:");
			    b[i][j]=Double.valueOf(x=Integer.parseInt(citire.readLine()));
			}
		}
	    for(int i=0;i<m;i++)
		{
		    for(int j=0;j<p;j++)
			System.out.print(b[i][j]+" ");
		    System.out.println();
		}
	    PrintStream scriere=new PrintStream(new FileOutputStream("ex4_out"));
	    for(int i=0;i<n;i++)
		{
		    for(int j=0;j<p;j++)
		        {
			    z=0;
			    for(int k=0;k<m;k++)
			      z+=a[i][k]*b[k][j];
			    c[i][j]=Double.valueOf(z);
			}
		}
	    for(int i=0;i<n;i++)
		{
		    for(int j=0;j<p;j++)
			scriere.print(c[i][j]+" ");
		    scriere.println();
		}
	    scriere.close();

	    
	}catch(IOException e)
	    {
		System.out.println("eroare");
		System.exit(-1);
	    }
    }
}
class Main
{
    public static void main(String[] args)
    {
	Tir tir=new Tir();
	Remorca r1=new Remorca("TM31JBL");

	if(!tir.adaugaRemorca(r1)) System.out.println("Nu mai e loc!");
	if(!tir.adaugaRemorca(4,"CJ82SOS")) System.out.println("Nu mai e loc!");
	Remorca r2=new Remorca("CT29LAV");
	if(!tir.adaugaRemorca(r2)) System.out.println("Nu mai e loc!");
	//if(!tir.adaugaRemorca(9,"MH64TIZ")) System.out.println("Nu mai e loc!");
	if(!tir.adaugaRemorca(2,"AB34FOG")) System.out.println("Nu mai e loc!");
	if(!tir.adaugaRemorca(7,"BV17BOS")) System.out.println("Nu mai e loc!");
	//if(!tir.adaugaRemorca(5,"BV17BOS")) System.out.println("Nu mai e loc!");
	System.out.println(tir);

	Remorca rem_stearsa=null;
	rem_stearsa=tir.stergeRemorca("CT29LAV");
	System.out.println("Remorca stearsa:"+rem_stearsa);
	System.out.println(tir);

        Tir tir2=new Tir();
	if(!tir2.adaugaRemorca(4,"CJ82SNS")) System.out.println("Nu mai e loc!");
	Remorca r3=new Remorca("CT27LAJ");
	if(!tir2.adaugaRemorca(r3)) System.out.println("Nu mai e loc!");
	if(!tir2.adaugaRemorca(9,"MH63TIZ")) System.out.println("Nu mai e loc!");
	if(!tir2.adaugaRemorca(2,"AB34KOG")) System.out.println("Nu mai e loc!");
	//if(!tir.adaugaRemorca(7,"BV17BOS")) System.out.println("Nu mai e loc!");
	if(!tir2.adaugaRemorca(3,"BV17BJS")) System.out.println("Nu mai e loc!");
        System.out.println(tir2);
	if(tir.equals(tir2))
	    System.out.println("Sunt egale");
	else
	    System.out.println("Nu sunt egale");
        
    }
}
class Remorca{
    private int cantitate;
    private String inmatriculare;
    private static int last=9;
    public Remorca(int c,String inm)
    {
	this.cantitate=c;
	last=c;
	this.inmatriculare=inm;
    }
    public Remorca(String inm)
    {
	this.cantitate=++last;
	this.inmatriculare=inm;
    }
    public String toString()
    {
	return "("+inmatriculare+","+cantitate+")";
    }
    public String nrInmat()
    {
	return inmatriculare;
    }
    public int valCantitate()
    {
	return cantitate;
    }
    public static int vLast()
    {
	return last;
    }
}
class Tir{
    private Remorca[] rem;
    private int nr_remorci;
    public Tir()
    {
	rem=new Remorca[5];
	nr_remorci=0;
    }
    public boolean adaugaRemorca(int c,String inm)
    {
	if(nr_remorci>=0 && nr_remorci<=4)
	    {
		rem[nr_remorci++]=new Remorca(c,inm);
		return true;
	    }
	return false;
    }
    public boolean adaugaRemorca(Remorca o)
    {
	if(nr_remorci>=0 && nr_remorci<=4)
	    {
		rem[nr_remorci++]=o;
		return true;
	    }
	return false;
    }
    public Remorca stergeRemorca(String nr_sters)
    {
	Remorca aux=null;
	for(int i=0;i<nr_remorci;i++)
	    {
		if(rem[i].nrInmat()==nr_sters)
		    {
			aux=rem[i];
			for(int j=i;j<nr_remorci-1;j++)
			  rem[j]=rem[j+1];
			nr_remorci--;
			return aux;
		    }
	    }
	return aux;
    }
    public int nrCutiiMarfa()
    {
	int suma=0;
	for(int i=0;i<nr_remorci;i++)
	    suma+=rem[i].valCantitate();
	return suma;
    }
    public boolean equals(Object o)
    {
	if(o==null)
	    return false;
	if(o instanceof Tir)
	    {
	        
		Tir e=(Tir) o;
		return e.nrCutiiMarfa()==this.nrCutiiMarfa();
		    //return true;
		    //return false;
	    }
	return false;
    }
    public String toString()
    {
	if(nr_remorci==0)
	    return "TIR GOL";
	int a=1;
	String str="T";
	while(a<=nr_remorci)
	    {
		str+="->R"+a+rem[a-1];
		a++;
	    }
	return str;
    }
}
