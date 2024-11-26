interface Risky{
    double getRisk();
}
abstract class Project implements Risky{
    protected Member manager;
    protected Member[] membrii;
    protected int size;//nr membrii
    protected String titlu,obiectiv;
    protected long[] fonduri=new long[10];
    protected int size_fonduri;
    protected Project(Member m,String t,String o,long[] f)
    {
	manager=m;
	titlu=t;
	obiectiv=o;
	fonduri=f;
	membrii=new Member[15];
	size=0;
	size_fonduri=f.length;
    }
    abstract public void addMember(Member m);
    protected long getFonduri()
    {
	long s=0;
	for(int i=0;i<size_fonduri;i++)
	    s+=fonduri[i];
	return s;
    }
    public String toString()
    {
	return titlu;
    }
}
abstract class ComercialeMilitare extends Project{
    protected String deadline;
    protected ComercialeMilitare(Member m,String t,String o,long[] f,String d)
    {
	super(m,t,o,f);
	deadline=d;
    }
    public void addMember(Member m)
    {
	if(size<membrii.length)
	    {
		membrii[size++]=m;
	    }
    }   
}
class Militare extends ComercialeMilitare{
    private String parola;
    public Militare(Member m,String t,String o,long[] f,String d,String p)
    {
	super(m,t,o,f,d);
	parola=p;
    }
    public double getRisk()
    {
	if(parola.length()==0 || this.getFonduri()==0)
	    return 0;
	return (double)size/parola.length()/this.getFonduri();
    }
}
class Comerciale extends ComercialeMilitare{
    private long[] fonduri_marketing=new long[fonduri.length];
    private int nr_echipe;
    public Comerciale(Member m,String t,String o,long[] f,String d)
    {
	super(m,t,o,f,d);
	for(int i=0;i<size_fonduri;i++)
	    fonduri_marketing[i]=fonduri[i]/2;
    }
    private long getFonduriMarketing()
    {
	return this.getFonduri()/2;
    }
    public double getRisk()
    {
	if(size==0 || this.getFonduri()==0)
	    return 0;
	return (double)3*nr_echipe/size/this.getFonduri()-this.getFonduriMarketing();
    }
    public void setNrEchipe(int n)
    {
	nr_echipe=Function.minim(n,size);
    }
}
class OpenSource extends Project{
    private String mailinglist;
    public OpenSource(Member m,String t,String o,long[] f,String mailinglist)
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
		    tmp[i]=membrii[i];
		membrii=tmp;
	    }
	membrii[size++]=m;
    }
   public double getRisk()
    {
	if(this.getFonduri()==0)
	    return 0;
	return (double)size/this.getFonduri();
    }
}
class Member{
    private int varsta;
    private String nume;
    public Member(int v,String n)
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
class InvestmentCompany{
    private Project tab[]=new Project[1];
    private int size;
    public InvestmentCompany()
    {
	size=0;
    }
    public void addProject(Project p)
    {
	if(size==tab.length)
	    {
		Project[] tmp=new Project[2*tab.length];
		for(int i=0;i<size;i++)
		    tmp[i]=tab[i];
		tab=tmp;
	    }
	tab[size++]=p;
    }
    public Project getBestInvestment()
    {
	if(size==0)
	    return null;
	Project aux=tab[0];
	double mini=tab[0].getRisk();
	for(int i=1;i<size;i++)
	    {
	    if(tab[i].getRisk()<mini)
		{
		    mini=tab[i].getRisk();
		    aux=tab[i];
		    
		}
	    }
	return aux;
    }
    public static void main(String[] args)
    {
        long[] l1={1,2};
	Project p1=new Militare(new Member(22,"Bercea"),"P1","Succes",l1,"23:04:2026","Pa");
	p1.addMember(new Member(7,"Patrocle"));
	p1.addMember(new Member(76,"Talpel"));
	p1.addMember(new Member(35,"Vempu"));
	p1.addMember(new Member(38,"Matei"));
	p1.addMember(new Member(21,"Iulian"));
	p1.addMember(new Member(27,"Mercioi"));
	
	long[] l2={1};
	Project p2=new Comerciale(new Member(27,"Sefu'"),"P2","Sa faca bani",l2,"11.03.2025");
	p2.addMember(new Member(19,"Tuispice"));
	p2.addMember(new Member(32,"Iolanda"));
	p2.addMember(new Member(29,"Pompiliu"));
	p2.addMember(new Member(45,"Ionut"));
	((Comerciale)p2).setNrEchipe(4);

	

	long[] l3={1,1,1};
	Project p3=new OpenSource(new Member(20,"Miokel"),"P3","Succes mai mare",l3,"Mailing -List");
	p3.addMember(new Member(33,"Florin"));
	p3.addMember(new Member(44,"Bob"));
	p3.addMember(new Member(18,"Rohandru"));
	p3.addMember(new Member(93,"Jakampta"));
	p3.addMember(new Member(23,"Merdin"));
	p3.addMember(new Member(30,"Zariana"));

	InvestmentCompany y=new InvestmentCompany();
	y.addProject(p1);
	y.addProject(p2);
	y.addProject(p3);
	Project p_final=y.getBestInvestment();
	System.out.println(p_final);
    }
}
class Function{
    public static int minim(int a,int b)
    {
	return a<b ? a:b;
    }
}
