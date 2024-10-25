class fis{
    public static void main(String[] args)
    {
	System.out.println("Hello world");
	Fisier n1=new Fisier("F1","Asta e F1");
	Fisier n2=new Fisier("F2","Asta e F2");
	
	System.out.println(n1);
	System.out.println(n2);
        System.out.println("NR_CONCAT F1:"+n1.nr_concat());
        System.out.println("NR_CONCAT F2:"+n2.nr_concat());
	
	System.out.println();
	n1.concat(n2);
	System.out.println(n1);
	System.out.println(n2);
	System.out.println("NR_CONCAT F1:"+n1.nr_concat());
        System.out.println("NR_CONCAT F2:"+n2.nr_concat());
    }
}
class Fisier{
    private String nume,continut;
    private static int id;
    private int id_cur,nr_concat;
    private Fisier ant;
    public Fisier(String n,String con)
    {
	this.nume=n;
	this.continut=con;
	id++;
	id_cur=id;
	ant=null;
    }
    private Fisier(String n,String con,Fisier a)
    {
	this(n,con);
        this.ant=a;
    }
    public void salveazaVersiune()
    {
	Fisier nou=new Fisier(nume+"bak",continut,ant);
	ant=nou;
    }
    public void concat(Fisier o)
    {
	salveazaVersiune();
	continut=continut + o.continut;
	nr_concat++;
    }
    public String  toString()
    {
	if(ant==null)
	    return "ID:"+id_cur+" NUME:"+nume+" CONTINUT:"+continut;
	else
	    return "ID:"+id_cur+" NUME:"+nume+" CONTINUT:"+continut+" "+ant;
    }
    public int nr_concat()
    {
	return nr_concat;
    }
}
