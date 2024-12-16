import java.util.*;
abstract class Statistica{
    protected String jurnal;
    protected Statistica()
    {
	jurnal="";
    }
    abstract public void calculeaza(ArrayList<String> secp);//secventa principala
    public String toString()
    {
	return jurnal;
    }
}
class StatisticaNumarAparitii extends Statistica{
    private ArrayList<String> secs;//secventa secundara;
    public StatisticaNumarAparitii(ArrayList<String> secs)
    {
	this.secs=secs;
    }
    public void calculeaza(ArrayList<String> secp)
    {
	int rez=0;
	for(String sp:secp)
	    {
		for(String ss:secs)
		    {
			if(ss.equals(sp))
			    {
				rez++;
				break;
			    }
		    }
	    }
	jurnal+="In secventa {";
	Iterator<String> it=secp.iterator();
	while(it.hasNext())
	    {
		jurnal+=it.next();
		if(it.hasNext())
		    {
			jurnal+=",";
		    }
	    }
	jurnal+="} apar "+rez+" siruri din secventa {";
	Iterator<String> it2=secs.iterator();
	while(it2.hasNext())
	    {
		jurnal+=it2.next();
		if(it2.hasNext())
		    {
			jurnal+=",";
		    }
	    }
	jurnal+="}\n";
    }
}
class StatisticaNumeraleNonReale extends Statistica{
    public void calculeaza(ArrayList<String> secp)
    {
	int rez=0;
	for(String sp:secp)
	    {
		try{
		    Double.parseDouble(sp);
		}catch(NumberFormatException e){
		    rez++;  
		}
	    }
	jurnal+="In secventa {";
	Iterator<String> it=secp.iterator();
	while(it.hasNext())
	    {
		jurnal+=it.next();
		if(it.hasNext())
		    {
			jurnal+=",";
		    }
	    }
	jurnal+="} avem "+rez+" siruri ce nu sunt numere reale\n";
    }
}
class Executor{
    private List<Statistica> list;
    public Executor(ArrayList<Statistica> list)
    {
	this.list=list;
    }
    public void executa(ArrayList<String> secp)
    {
	for(Statistica s:this.list)
	    {
		s.calculeaza(secp);
	    }
    }
    public String toString()
    {
	String tmp="";
	for(Statistica s:this.list)
	    {
		tmp+=s.toString();
	    }
	return tmp;
    }
}
class Main{
    public static void main(String[] args)
    {
	ArrayList<String> l1=new ArrayList<String>();
	l1.add("mere");
	l1.add("pere");
	l1.add("banane");
	StatisticaNumarAparitii sta1=new StatisticaNumarAparitii(l1);
	StatisticaNumeraleNonReale sta2=new StatisticaNumeraleNonReale();

	ArrayList<Statistica> l2=new ArrayList<Statistica>();
	l2.add(sta1);
	l2.add(sta2);

	Executor e=new Executor(l2);

	ArrayList<String> sec1=new ArrayList<String>();
	sec1.add("Ana");
	sec1.add("are");
	sec1.add("mere");
	ArrayList<String> sec2=new ArrayList<String>();
	sec2.add("Maria");
	sec2.add("are");
	sec2.add("2.124");

	e.executa(sec1);
	System.out.println(e);

	e.executa(sec2);
	System.out.println(e);
    }
}
