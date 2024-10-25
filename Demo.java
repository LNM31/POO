import java.io.*;
import java.util.*;

class Curs{

    private String denumire;
    private int id, credite, cod;

    public Curs(String denumire, int id, int credite,int cod)
    {
	this.denumire=denumire;
	this.id=id;
	this.credite=credite;
	this.cod=cod;
    }

    public boolean equals(Object o)
    {
	if(o instanceof Curs)
	    {
		return this.cod==((Curs)o).cod;
	    }
	return false;
    }

    public int getId()
    {
	return id;
    }

    public int getCredite()
    {
	return this.credite;
    }

    public String toString()
    {
	return "Id: "+id+" Denumire: "+denumire+" Credite: "+credite;
    }
}

class Curicula{

    private Curs[] cursuri=new Curs[1];
    private int nrCursuri=0;
    
    public void add(Curs c)
    {
	if(nrCursuri==cursuri.length)
	    {
		Curs tmp[]=new Curs[2*cursuri.length];
		for(int i=0;i<cursuri.length;i++)
		    {
			tmp[i]=cursuri[i];
		    }
		cursuri=tmp;
	    }
	cursuri[nrCursuri++]=c;
    }

    
    public String toString()
    {
	// 2. -> ceva mai eficient
	// 2. StringBuilder tmp=new StringBUilder();

	String tmp="";
	for(int i=0;i<nrCursuri;i++)
	    {
		tmp+=cursuri[i]+"\n";

		// 2. tmp.append(cursuri[i]).append("\n");
	    }
	return tmp;
	
	/*1. versiune mai rapida, e mai naspa ca mere pana la null
	  1. return Arrays.toString(cursuri);*/
    }

    public Curs cauta(int id)
    {
	for(int i=0;i<nrCursuri;i++)
	    {
		if(id==cursuri[i].getId())
		    {
			return cursuri[i];
		    }
	    }
	return null;
    }

    public static Curicula load(String f)
    {
	Curicula c=new Curicula();
	try
	    {
		FileInputStream fis=new FileInputStream(f);
		Scanner s=new Scanner(fis);
		while(s.hasNext()) //mergem pana nu mai exista cuvinte
		    {
			int id,cod,credite;
			String denumire;
			if(s.hasNextInt())
			    {
				id=s.nextInt();
			    }
			else
			    {
				break;
			    }
			if(s.hasNext())
			    {
				denumire=s.next();
			    }
			else
			    {
				break;
			    }
			if(s.hasNextInt())
			    {
				cod=s.nextInt();
			    }
			else
			    {
				break;
			    }
			if(s.hasNextInt())
			    {
				credite=s.nextInt();
			    }
			else
			    {
				break;
			    }
			c.add(new Curs(denumire,id,credite,cod));
		    }
		s.close();
	    }
	catch(IOException e)
	    {
		System.err.println(e);
	    }
	return c;
    }
}

class Student{

    private String nume;
    private Curs[] cursuri=new Curs[10];
    private int[] note=new int[10];
    private int nrCursuri;
    
    public Student(String n)
    {
	nume=n;
    }

    public void inregistrareNota(Curs c,int n)
    {
	if(n >=5 && n<=10)
	    {
		for(int i=0;i<nrCursuri;i++)
		    {
			if(cursuri[i].equals(c))
			    {
				if(note[i]<n)
				    {
					note[i]=n;
				    }
				return;
			    }
		    }
		if(nrCursuri == cursuri.length)
		    {
			cursuri = Arrays.copyOf(cursuri,2*cursuri.length);
			note = Arrays.copyOf(note,2*note.length);
		    }
		cursuri[nrCursuri]=c;
		note[nrCursuri++]=n;
	    }
    }

    public int calculeazaCredite()
    {
	int suma=0;
	for(int i=0;i<nrCursuri;i++)
	    {
		suma+=cursuri[i].getCredite();
	    }
	return suma;
	
    }

    public double calculeazaMedie()
    {
	double suma=0;
	if(nrCursuri==0)
	    {
		return 0;
	    }
	for(int i=0;i<nrCursuri;i++)
	    {
		suma+=note[i];
	    }
	return suma/nrCursuri;
    }

    public String toString()
    {
	String res=nume+"\n";
	for(int i=0;i<nrCursuri;i++)
	    {
		res+=cursuri[i]+" - Nota: "+note[i]+"\n";
	    }
	res+="Media: "+this.calculeazaMedie()+"\n";
	res+="Credite: "+this.calculeazaCredite()+"\n";
	return res;
    }
}
/*
1 SDA 1 5
2 POO 2 5
3 OOP 2 5
*/
class Main{

    public static void main(String[] args)
    {
	
	Curicula c=Curicula.load("input.txt");
	System.out.println(c);

	Student s1=new Student("Alin");
	s1.inregistrareNota(c.cauta(1),10);
	s1.inregistrareNota(c.cauta(2),4);
	System.out.println(s1);
	s1.inregistrareNota(c.cauta(2),7);
	System.out.println(s1);

	Student s2=new Student("Alina");
	s2.inregistrareNota(c.cauta(1),7);
	s2.inregistrareNota(c.cauta(2),8);
	System.out.println(s2);
	s2.inregistrareNota(c.cauta(2),10);
	System.out.println(s2);
    }
	/*
	Id: 1 Denumire: SDA Credite: 5
        Id: 2 Denumire: POO Credite: 5
        Id: 3 Denumire: OOP Credite: 5

        Alin
        Id: 1 Denumire: SDA Credite: 5 - Nota: 10
	Media: 10.0
	Credite: 5

	Alin
	Id: 1 Denumire: SDA Credite: 5 - Nota: 10
	Id: 2 Denumire: POO Credite: 5 - Nota: 7
	Media: 8.5
	Credite: 10

	Alina
	Id: 1 Denumire: SDA Credite: 5 - Nota: 7
	Id: 2 Denumire: POO Credite: 5 - Nota: 8
	Media: 7.5
	Credite: 10

	Alina
	Id: 1 Denumire: SDA Credite: 5 - Nota: 7
	Id: 2 Denumire: POO Credite: 5 - Nota: 10
	Media: 8.5
	Credite: 10
	*/
}
