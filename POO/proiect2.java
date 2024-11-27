interface Risky{
    double getRisk();
}
abstract class Project implements Risky{
    protected Manager manager;
    protected Member[] membrii;
    protected int size;
    protected String titlu,obiectiv;
    protected long fonduri;
    abstract public void addMember(Member m);
    protected Project(Manager m,String t,String o,long f)
    {
	manager=m;
	titlu=t;
	o=obiectiv;
	fonduri=f;
	membrii=new Member[15];
	size=0;
    }
    public String toString()
    {
	return titlu;
    }
}
abstract class ComercialeMilitare extends Project{
    protected String deadline;
    protected ComercialeMilitare(Manager m,String t,String o,long f,String d)
    {
	super(m,t,o,f);
	deadline=d;
    }
    public void addMember(Member m)
    {
	if(size<membrii.length)
	    membrii[size++]=m;
    }
}
class Militare extends ComercialeMilitare{
    private String parola;
    public Militare(Manager m,String t,String o,long f,String d,String p)
    {
	super(m,t,o,f,d);
	parola=p;
    }
    public double getRisk()
    {
	if(parola.length()==0 || fonduri==0)
	    return 0;
	return ((double)size)/parola.length()/fonduri;
    }
}
class Comerciale extends ComercialeMilitare{
    private long fonduri_marketing;
    private int nr_echipe;
    public Comerciale(Manager m,String t,String o,long f,String d)
    {
	super(m,t,o,f,d);
        fonduri_marketing=fonduri/2;
    }
    public void setNrEchipe(int x)
    {
	nr_echipe=x;
    }
    public double getRisk()
    {
	if(size==0 || fonduri==0)
	    return 0;
	return (double)3.0*nr_echipe/size/fonduri- fonduri_marketing;
    }
}
class OpenSource extends Project{
    private String mailinglist;
    public OpenSource(Manager m,String t,String o,long f,String mailinglist)
    {
	super(m,t,o,f);
	this.mailinglist=mailinglist;
    }
    public void addMember(Member m)
    {
	if(size==membrii.length)
	    {
		Member[] tmp=new Member[2*membrii.length];
		for(int i=0;i<size;i++)
		    {
			tmp[i]=membrii[i];
		    }
		membrii=tmp;
	    }
	membrii[size++]=m;
    }
    public double getRisk()
    {
	if(this.fonduri==0)
	    return 0;
	return ((double)size)/fonduri;
    }
}
class InvestmentCompany{
    private Project[] tab=new Project[1];
    private int size;
    public InvestmentCompany()
    {
	this.size=0;
    }
    public void addProject(Project p)
    {
	if(size==tab.length)
	    {
		Project[] tmp=new Project[2*tab.length];
		for(int i=0;i<size;i++)
		    {
			tmp[i]=tab[i];
		    }
		tab=tmp;
	    }
	tab[size++]=p;
    }
    public Project getBestInvestment()
    {
	if(size==0)
	    return null;
	Project aux=tab[0];
	for(int i=0;i<size;i++)
	    {
		if(tab[i].getRisk()<aux.getRisk())
		    {
			aux=tab[i];
		    }
	    }
	return aux;
    }
    public static void main(String[] args)
    {
	Militare p1=new Militare(new Manager(22,"Bercea"),"P1","O1",100,"D1","P1");
	p1.addMember(new Programator(7,"n1"));
	p1.addMember(new Programator(76,"n2"));
	p1.addMember(new Programator(35,"n3"));
	p1.addMember(new Programator(38,"n4"));
	p1.addMember(new Programator(21,"n5"));
	p1.addMember(new Programator(27,"n6"));

	Comerciale p2=new Comerciale(new Manager(30,"Sefu'"),"P2","O2",200,"D2");
	p2.addMember(new Programator(7,"n7"));
	p2.addMember(new Programator(76,"n8"));
	p2.addMember(new Programator(35,"n9"));
	p2.addMember(new Programator(38,"n10"));
	p2.addMember(new Programator(21,"n11"));
	p2.addMember(new Programator(27,"n12"));

	OpenSource p3=new OpenSource(new Manager(25,"Sefu' 2"),"P3","O3",250,"Mailinglist1");
	p2.addMember(new Programator(7,"n13"));
	p2.addMember(new Programator(76,"n14"));
	p2.addMember(new Programator(35,"n15"));
	p2.addMember(new Programator(38,"n16"));
	p2.addMember(new Programator(21,"n17"));
	p2.addMember(new Programator(27,"n18"));

	InvestmentCompany y=new InvestmentCompany();
	y.addProject(p1);
	y.addProject(p2);
	y.addProject(p3);
	Project p_final=y.getBestInvestment();
	System.out.println(p_final);
    }
}
interface  Member {
    
}
class Programator implements Member{
    protected int varsta;
    protected String nume;
    public Programator(int v,String n)
    {
	varsta=v;
	nume=n;
    }
    public int getVarsta()
    {
	return varsta;
    }
    public String getNume()
    {
	return nume;
    }
}
class Manager extends Programer{
    public Manager(int v,String n)
    {
	super(v,n);
    }
}

