class Angajat{
    private String name;
    private int salariu;
    public Angajat(String name,int salariu)
    {
	this.salariu=salariu;
	this.name=name;
    }
    public String toString()
    {
	return "("+name+","+salariu+")";
    }
    public int valSalariu()
    {
	return salariu;
    }
    
}
class Firma{
    private String nume;
    private int buget;
    private Angajat[] a;
    private int size;
    public Firma(String nume,int buget)
    {
	this.nume=nume;
	this.buget=buget;
	a=new Angajat[30];
	size=0;
    }
    public boolean adaugaAngajat(Angajat o)
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
	if(size==0)
	    return "Firma e goala!\n";
	StringBuilder tmp=new StringBuilder(nume+":\n");
	for(int i=0;i<size;i++)
	    tmp.append("Angajat"+i+a[i]+"\n");
	return tmp.toString();
    }
    public int platesteSalarii()
    {
	int sum=0,bugetul_ramas;
	for(int i=0;i<size;i++)
	    sum+=a[i].valSalariu();
	bugetul_ramas=buget-sum;
	return bugetul_ramas;
    }
}
class Main{
    public static void main(String[] args)
    {
	Firma nike=new Firma("Nike",100);
	Angajat a1=new Angajat("Tuispice",30);
	Angajat a2=new Angajat("Iolanda",20);
	Angajat a3=new Angajat("Pompiliu",70);

	if(nike.adaugaAngajat(a1)==false) System.out.println("Angajatul este deja angajat sau nu mai e loc");
	if(nike.adaugaAngajat(a2)==false) System.out.println("Angajatul este deja angajat sau nu mai e loc");
	if(nike.adaugaAngajat(a3)==false) System.out.println("Angajatul este deja angajat sau nu mai e loc");
	//if(nike.adaugaAngajat(a2)==false) System.out.println("Angajatul este deja angajat sau nu mai e loc");
	System.out.println(nike);
	System.out.println("Bugetul_ramas:"+nike.platesteSalarii()+" milioane euro");
    }
}    
