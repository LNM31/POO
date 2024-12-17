import java.util.*;
abstract class Memorie{
    protected byte[] tab;
    protected int size;
    protected Memorie(int size)throws IllegalArgumentException
    {
	if(size<=0)
	    throw new IllegalArgumentException();
	this.size=size;
    }
    public byte[] read(int start,int end)
    {
	if(start<0 || end<0 || start>end || start>=(size-1) || end>=(size-1))
	    throw new IllegalArgumentException();
	byte[] aux=new byte[end-start+1];
	for(int i=start;i<=end;i++)
	    aux[i]=tab[i];
	return aux;
    }
}
class PROM extends Memorie{
    public PROM(final byte[] t,int size)throws IllegalArgumentException
    {
	super(size);
	this.tab=t;
    }
}
class RandomROM extends Memorie{
    public RandomROM(int size)throws IllegalArgumentException
    {
	super(size);
	for(int i=0;i<size;i++)
	    {
		if(Math.random()<0.5)
		    tab[i]=0;
		else
		    tab[i]=1;
	    }
	
    }
}
class RAM extends Memorie{
    public RAM(int size)throws IllegalArgumentException
    {
	super(size);
    }
    public void write(int start,byte[] t)throws IllegalArgumentException
    {
	if((start+t.length)>=size || start<=0)
	    throw new IllegalArgumentException();
	for(int i=0;i<t.length;i++)
	    tab[start+i]=t[i];
    }
    protected int dim_list()
    {
	return this.size;
    }
}
class RedundantRAM extends RAM{
    private List<RAM> list;
    public RedundantRAM(int size)throws IllegalArgumentException
    {
	super(size);
	list=new ArrayList<RAM>();
    }
    void addWritableMemory(RAM m)throws IllegalArgumentException
    {
	if(m.size<this.size)
	    throw new IllegalArgumentException();
	list.add(m);
    }
    public void write(int start,byte[] t)throws IllegalArgumentException
    {
	super.write(start,t);
	for(RAM r:list)
	    {
		r.write(start,t);
	    }
    }
    public byte[] read(int start,int end)throws IllegalArgumentException
    {
	byte[] t=super.read(start,end);
	byte[] z;
	int rez=0;
	for(RAM r:list)
	    {
		z=r.read(start,end);
		for(int i=0;i<z.length;i++)
		    {
			if(t[i]!=z[i])
			    throw new IllegalArgumentException();
		    }
	    }
	return t;
    }
    protected int dim_list()
    {
	int rez=0;
	for(RAM r:list)
	    {
		rez+=r.dim_list();
	    }
	return rez;
    }
    public double grad()
    {
	return (double)this.dim_list()/this.size;
    }
}
