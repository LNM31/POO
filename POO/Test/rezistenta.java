import java.util.*;
abstract class CircuitElectric{
    abstract public double rezistentaEchivalenta();
    public double curent(double tensiune)
    {
	return tensiune/this.rezistentaEchivalenta();
    }
    abstract boolean contineSubcircuit(CircuitElectric subcircuit);
}
class Rezistenta extends CircuitElectric{
    private double valoare;
    public Rezistenta(double valoare)
    {
	this.valoare=valoare;
    }
    public double rezistentaEchivalenta()
    {
	return valoare;
    }
    public boolean contineSubcircuit(CircuitElectric subcircuit)
    {
	return this==subcircuit;
    }
}
abstract class CircuitCompus extends CircuitElectric{
    protected List<CircuitElectric> list;
    protected CircuitCompus(ArrayList<CircuitElectric> list)
    {
	this.list=list;
    }
    public boolean contineSubcircuit(CircuitElectric subcircuit)
    {
	if(this==subcircuit)
	    return true;
	for(CircuitElectric c:list)
	    {
		if(c.contineSubcircuit(subcircuit)==true)
		    return true;
	    }
	return false;
    }
    abstract public double rezistentaEchivalenta();
}
class CircuitSerie extends CircuitCompus{
    public CircuitSerie(ArrayList<CircuitElectric> list)
    {
	super(list);
    }
    public double rezistentaEchivalenta()
    {
	double rez=0;
	for(CircuitElectric c:list)
	    {
		rez+=c.rezistentaEchivalenta();
	    }
	return rez;
    }   
}
class CircuitParalel extends CircuitCompus{
    public CircuitParalel(ArrayList<CircuitElectric> list)
    {
	super(list);
    }
    public double rezistentaEchivalenta()
    {
	double rez=0;
	for(CircuitElectric c:list)
	    {
		rez+=1/c.rezistentaEchivalenta();
	    }
	return 1/rez;
    }
}
class Main{
    public static void main(String[] args)
    {
	Rezistenta r1=new Rezistenta(2);
	Rezistenta r2=new Rezistenta(1);
	Rezistenta r3=new Rezistenta(4);
	Rezistenta r4=new Rezistenta(2);

	ArrayList<CircuitElectric> l1=new ArrayList<CircuitElectric>();
	l1.add(r1);
	l1.add(r2);
	CircuitSerie s1=new CircuitSerie(l1);

	ArrayList<CircuitElectric> l2=new ArrayList<CircuitElectric>();
	l2.add(r3);
	l2.add(r4);
	CircuitSerie s2=new CircuitSerie(l2);

	ArrayList<CircuitElectric> l3=new ArrayList<CircuitElectric>();
	l3.add(s1);
	l3.add(s2);
	CircuitParalel p1=new CircuitParalel(l3);
	System.out.println("Rezistenta echivalenta: "+p1.rezistentaEchivalenta()+" ohmi");
	System.out.println("Curentul: "+p1.curent(9.0));
	System.out.println(p1.contineSubcircuit(r1));
	
    }
}
