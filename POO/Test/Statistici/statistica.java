import java.util.*;
interface Statistica {
    void calculeaza(String[] secp);//secp->secventa principala
}
class StatisticaNumarAparitii implements Statistica{
    private String[] secs;//secs->secventa secundara
    private String jurnal;
    public StatisticaNumarAparitii(String[] secs)
    {
	this.secs=secs;
	jurnal="";
    }
    private String display_secs()
    {
	String ss="{";
	for(int i=0;i<this.secs.length;i++)
	    {
		ss+=this.secs[i]+" ";
	    }
	ss+="}";
	return ss;
    }
    public void calculeaza(String[] secp)
    {
	int rez=0;
	String sp="{";
	for(int i=0;i<secp.length;i++)
	    {
		sp+=secp[i]+" ";
		for(int j=0;j<this.secs.length;j++)
		    if(secp[i].equals(secs[j]))
		    rez++;
	    }
	sp+="}";
	jurnal+="In secventa "+sp+" apar "+rez+" siruri din secventa "+this.display_secs()+"\n";
    }
    public String toString()
    {
	return jurnal;
    }
}
class StatisticaNumeraleNonReale implements Statistica{
    private String jurnal;
    public StatisticaNumeraleNonReale()
    {
	jurnal="";
    }
    public void calculeaza(String[] secp)
    {
	String sp="{";
	double d;
	int rez=0;
	for(int i=0;i<secp.length;i++)
	    {
		sp+=secp[i]+" ";
		try{
		    d=Double.parseDouble(secp[i]);
		}catch(NumberFormatException e){
		    rez++;
		}
	    }
	sp+="}";
	jurnal+="In secventa "+sp+" avem "+rez+" siruri ce nu sunt numere reale\n";
    }
    public String toString()
    {
	return jurnal;
    }
}
class Executor{
    private Statistica[] sta; 
    public Executor(Statistica[] sta)
    {
	this.sta=sta;
    }
    public void executa(String[] secp)
    {
	for(int i=0;i<sta.length;i++)
	    {
		sta[i].calculeaza(secp);
		System.out.print(sta[i]);
	    }
	System.out.println();
    }
}
class Main{
    public static void main(String[] args)
    {
	Statistica[] sta=new Statistica[2];
	String[] s={new String("mere"),new String("pere"),new String("banane")};

	sta[0]=new StatisticaNumarAparitii(s);
	sta[1]=new StatisticaNumeraleNonReale();

        String[] p1={new String("Maria"),new String("are"),new String("mere")};
	String[] p2={new String("Maria"),new String("are"),new String("pere")};
	
	Executor e=new Executor(sta);
	e.executa(p1);
	e.executa(p2);
    }
}
