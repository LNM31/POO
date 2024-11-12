abstract class Avion {
    private String planeID;
    private int totalEnginePower;
    public Avion(String p,int t)
    {
	this.planeID=p;
	this.totalEnginePower=t;
    }
    public String getPlaneID()
    {
	return planeID;
    }
    public int getTotalEnginePower()
    {
	return totalEnginePower;
    }
    public void takeOff()
    {
	    System.out.println(planeID+" - Initiating takeoff procedure - Starting engines - Accelerating down the runway - Taking off- Retracting gear - Takeoff complete");
    }
    public void land()
    {	
	System.out.println(planeID+"- Initiating landing procedure - Enabling airbrakes -Lowering gear - Contacting runway - Decelerating - Stopping engines - Landingcomplete");	
    }
    public void fly()
    {
	    System.out.println(planeID+" - Flying");
    }
}

class Calatori extends Avion{
    private int maxPassengers;
    public Calatori(String p,int t,int m)
    {
	super(p,t);
	this.maxPassengers=m;
    }
    public int getMaxPassengers()
    {
	return maxPassengers;
    }
}
class Concorde extends Calatori{
    public Concorde(String p,int t,int m)
    {
	super(p,t,m);
    }
    public void goSuperSonic()
    {
	    System.out.println(getPlaneID()+" - Supersonic mode activated");
    }
    public void goSubSonic()
    {
	    System.out.println(getPlaneID()+" - Supersonic mode deactivated");
    }
}
class Boeing extends Calatori{
    public Boeing(String p,int t,int m)
    {
	super(p,t,m);
    }
    
}
class Lupta extends Avion{
    public Lupta(String p,int t)
    {
	super(p,t);
    }
    public void launchMissile()
    {
	    System.out.println(getPlaneID()+" - Initiating missile launch procedure - Acquiring target -Launching missile - Break-ing away - Missile launch complete");
    }
}
class Mig extends Lupta{
    public Mig(String p,int t)
    {
	super(p,t);
    }
    public void highSpeedGeometry()
    {
	    System.out.println(getPlaneID()+" - High speed geometry selected");
    }
    public void normalGeometry()
    {
	    System.out.println(getPlaneID()+" - Normal geometry selected");
    }
}
class TomCat extends Lupta{
    public TomCat(String p,int t)
    {
	super(p,t);
    }
    public void refuel()
    {
	    System.out.println(getPlaneID()+" - Initiating refueling procedure - Locating refueller - Catching up-Refueling- Refueling complete");
    }
}
class Main{
    public static void main(String args[])
    {
	Avion a1=new Calatori("A1",3000,90);
	Avion a2=new Concorde("A2",3500,70);
	Avion a3=new Boeing("A3",2700,65);
	Avion a4=new Lupta("A4",6000);
	Avion a5=new Mig("A5",7000);
	Avion a6=new TomCat("A6",6550);

	a1.takeOff();
	a1.fly();
	a1.land();
	if(a1 instanceof Calatori)
	  System.out.println("Locuri maxime:"+((Calatori)a1).getMaxPassengers()+"\n");
	if(a2 instanceof Concorde)
	    {
		Concorde tmp=(Concorde)a2;
		tmp.goSuperSonic();
		tmp.goSubSonic();
		System.out.println();
	    }
	if(a3 instanceof Boeing)
	    {
		Boeing tmp=(Boeing)a3;
		tmp.takeOff();
		tmp.fly();
		tmp.land();
		System.out.println();
	    }
	if(a4 instanceof Lupta)
	    {
		Lupta t=(Lupta) a4;
		t.launchMissile();
		System.out.println();
	    }
	if(a5 instanceof Mig)
	    {
		Mig t=(Mig) a5;
		t.launchMissile();
		t.highSpeedGeometry();
		t.normalGeometry();
		System.out.println();
	    }
        if(a6 instanceof TomCat)
	    {
		TomCat t=(TomCat) a6;
		t.launchMissile();
		t.refuel();
		System.out.println();
	    }
    }
}
