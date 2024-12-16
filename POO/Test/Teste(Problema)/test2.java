import java.util.*;
class WQIE extends RuntimeException{
    public WQIE()
    {
	super("WrongQualityIndicatorException!\n");
    }
}
class WCCIE extends Exception{
    public WCCIE()
    {
	super("a aparut o exceptie!\n");
    }
}
abstract class Test{
    abstract public int getNumarTeste();
    abstract public String toString();
}
abstract class TestBaza extends Test{
    protected String nume;
    protected int indicator;
    protected TestBaza(String nume,int indicator)throws WQIE
    {
	if(indicator>=1 && indicator<=10)
	    this.indicator=indicator;
	else throw new WQIE();
	this.nume=nume;
    }
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
    protected int complexitate;
    public ComponentTest(String nume,int indicator,int com)throws WQIE,WCCIE
    {
	super(nume,indicator);
	if(com>0)
	    this.complexitate=com;
	else throw new WCCIE();
    }
    public String toString()
    {
	return "ComponentTest(name="+nume+" , quality indicator="+indicator+" , component complexity indicator="+complexitate+")";
    }
}
class TestSuite extends Test{
    private ArrayList<Test> list;
    public TestSuite(ArrayList<Test> list)
    {
	this.list=list;
    }
    public int getNumarTeste()
    {
	int rez=0;
	for(Test t:list)
	    {
		rez+=t.getNumarTeste();
	    }
	return rez;
    }
    public boolean addNewIntegration(String nume,int indicator)
    {
	IntegrationTest t;
	try{
	    t=new IntegrationTest(nume,indicator);
	}catch(WQIE e){
	    return false;
	}
	list.add(t);
	return true;
    }
    public boolean addNewComponentTest(String nume,int indicator,int com)throws WCCIE
    {
	ComponentTest t;
	try{
	    t=new ComponentTest(nume,indicator,com);
	}catch(WQIE e){
	    return false;
	}
	list.add(t);
	return true;
    }
    public String toString()
    {
	String tmp="TestSuite:\n";
	Iterator<Test> it=list.iterator();
	while(it.hasNext())
	    {
		tmp+=it.next().toString();
		if(it.hasNext())
		    {
			tmp+=" , ";
		    }
	    }
	return tmp+=")";
    }
}
class Main{
    public static void main(String[] args)
    {
	TestSuite t1=new TestSuite(new ArrayList<Test>());
	t1.addNewIntegration("I1",6);
	t1.addNewIntegration("I2",11);
	try{
	    t1.addNewComponentTest("C1",1,33);
	}catch(WCCIE e){
	    System.out.println(e.getMessage());
	}

	try{
	    t1.addNewComponentTest("C2",3,-2);
	}catch(WCCIE e){
	    System.out.println(e.getMessage());
	}
	System.out.println(t1);
    }
}
