import java.util.*;
class WQIE extends RuntimeException{//WQIE->WrongQualityIndicatorException
    public WQIE()
    {
        super("WrongQualityIndicatorException!\n");
    }
}
class WCCIE extends RuntimeException{//WCCIE->WrongComponentComplexityIndicatorException
    public WCCIE()
    {
        super("a aparut o exceptie!");
    }
}
//  ^ ^ ^
//  | | |
//Exceptions

interface Test{
    int getNumarTeste();
}
abstract class TestBaza implements Test{
    protected String nume;
    protected int indicator;//indicator de calitate
    protected TestBaza(String nume,int indicator)throws WQIE
        {            
            if(indicator>=1 && indicator<=10)
                this.indicator=indicator;
            else throw new WQIE();
	    this.nume=nume;
        }
    abstract public String toString();
    public int getNumarTeste()
    {
	return 1;
    }
}

class IntegrationTest extends TestBaza{
    public IntegrationTest(String nume,int indicator)throws WQIE
    {
        super(nume,indicator);
    }
    public String toString()
    {
        return "IntegrationTest(name="+nume+" , quality indicator="+indicator+")";
    }
}
class ComponentTest extends TestBaza{
    private int complexitate;
    public ComponentTest(String n,int i,int c)throws WQIE,WCCIE
    {
        super(n,i);
        if(c<=0) throw new WCCIE();
	complexitate=c;
    }
    public String toString()
    {
        return "ComponentTest(name="+nume+" , quality indicator="+indicator+" , component complexity indicator="+complexitate+")";
    }
}
class TestSuite implements Test{
    private List<Test> list;
    public TestSuite()
    {
	list=new ArrayList<Test>();
    }
    public TestSuite(ArrayList<Test> list)
    {
	this.list=list;
    }
    public int getNumarTeste()
    {
	int rez=0;
	for(Test i:list)
	    {
		rez+=i.getNumarTeste();
	    }
	return rez;
    }
    public boolean addNewIntegrationTest(String name,int indicator)
    {
	IntegrationTest t;
	try{
	    t=new IntegrationTest(name,indicator);
	    list.add(t);
	    return true;
	}catch(WQIE e){
	    return false;
	}
    }
    public boolean addNewComponentTest(String name,int indicator,int complexity)throws WCCIE
    {
	ComponentTest t;
	try{
	    t=new ComponentTest(name,indicator,complexity);
	    list.add(t);
	    return true;
	}catch(WQIE e){
	    return false;
	}
    }
    public String toString()
    {
	String s="(";
	Iterator<Test> it=list.iterator();
	while(it.hasNext())
	    {
		s+=it.next().toString();
		if(it.hasNext())
		    {
			s+=" , ";
		    }
	    }
	s+=")";
	return s;
    }
}
class Main{
    public static void main(String[] args)
    {
	TestSuite t=new TestSuite();
	try{
	    t.addNewIntegrationTest("Ion",7);
	    t.addNewIntegrationTest("Ana",11);
	    t.addNewComponentTest("Kevin",4,3);
	    t.addNewComponentTest("Horatiu",8,-2);
	}catch(WCCIE e){
	    System.out.println(e.getMessage());
	}
	System.out.println(t+"\n"+t.getNumarTeste());
    }
}
