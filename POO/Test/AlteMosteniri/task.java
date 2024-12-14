import java.util.*;
abstract class Task {
    protected String nume;
    protected Task(String nume)
    {
	this.nume=nume;
    }
    abstract public boolean execute(double sec);
    public String toString()
    {
	return "Name:"+nume;
    }
}
class SimpleTask extends Task{
    private double timp;//timp necesar
    public SimpleTask(String nume,double timp)
    {
	super(nume);
	this.timp=timp;
    }
    public boolean execute(double sec)
    {
	if(timp>0)
	    {
		timp=timp-sec;
	    }
	if(timp>0)
	    return false;
	return true;
    }
    public String toString()
    {
	return "("+super.toString()+", Time:"+timp+" s)";
    }
}
class ComposedTask extends Task{
    private List<SimpleTask> list;
    public ComposedTask(String nume,ArrayList<SimpleTask> list)
    {
	super(nume);
	this.list=list;
    }
    public boolean execute(double sec)
    {
	int contor=0;
	for(SimpleTask s : list)
	    {
		if(s.execute(sec/list.size())==true)
		    {
			contor++;
		    }
	    }
	if(contor==list.size())
	    return true;
	return false;
    }
    public String toString()
    {
	String s=super.toString()+" Content:(";
	Iterator<SimpleTask> it=list.iterator();
	while(it.hasNext())
	    {
		s+=it.next().toString();
		if(it.hasNext())
		    {
			s+=",";
		    }
	    }
	return s + ")";
    }
}
class Procesor{
    private List<Task> list;
    public Procesor(ArrayList<Task> list)
    {
	this.list=list;
    }
    public void finishAllTasks()
    {
	int contor=0;
	while(contor!=this.list.size())
	    {
		contor=0;
		for(Task t:list)
		    {
			if(t.execute(5)==true)
			    contor++;
		    }
	    }
    }
    public String toString()
    {
	String s="Procesor:\n";
	for(Task t:list)
	    {
		s+=t.toString()+"\n";
	    }
	return s;
    }
}
class Main{
    public static void main(String[] args)
    {
	ArrayList<SimpleTask> l1=new ArrayList<SimpleTask>();
	l1.add(new SimpleTask("S1",5.0));
	l1.add(new SimpleTask("S2",10.0));
	ComposedTask c1=new ComposedTask("C1",l1);

	ArrayList<Task> l2=new ArrayList<Task>();
	l2.add(c1);

	Procesor p=new Procesor(l2);
	System.out.println(p);
	p.finishAllTasks();
	System.out.println(p);
    }
}
