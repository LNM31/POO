class Fisier{
    private String nume,continut;
    private static int id_universal=0;
    private int id,nr_concat=0;
    private Fisier ant;
    public Fisier(String n,String c)
    {
	this.nume=n;
	this.continut=c;
	id_universal++;
	id=id_universal;
	ant=null;
    }
    private Fisier(String n,String c,Fisier f)
    {
	this(n,c);
	ant=f;
    }
    public void salveazaVersiune()
    {
	Fisier nou=new Fisier(this.nume+"bak",continut,ant);
	this.ant=nou;
    }
    public String seeContinut()
    {
	return continut;
    }
    public void concateneaza(Fisier f)
    {
	this.salveazaVersiune();
	this.continut+=f.seeContinut();
	nr_concat++;
    }
    public String toString()
    {
	if(ant !=null)
	  return "ID: "+id +" "+nume+ " "+continut +"ANT:"+ant;
	return "ID: "+id +" "+nume+ " "+continut;
    }
    public int numarConcatenari()
    {
	return nr_concat;
    }
    
}
class Main{
    public static void main(String[] args)
    {
	Fisier n1=new Fisier("F1","Asta e F1");
	Fisier n2=new Fisier("F2","Asta e F2");

	System.out.println(n1+"\n"+n2);
	System.out.println("nr_concat f1 "+n1.numarConcatenari());
	System.out.println("nr_concat f2 "+n2.numarConcatenari());
	n1.concateneaza(n2);

	System.out.println();
	System.out.println(n1+"\n"+n2);
	System.out.println("nr_concat f1 "+n1.numarConcatenari());
	System.out.println("nr_concat f2 "+n2.numarConcatenari());
	n1.concateneaza(n2);
    }
}
