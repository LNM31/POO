class p1{
    public static void main(String[] args)
    {
        System.out.println("Visca Barca!");
	Ceas c1;
	c1=new Ceas(21,50,5);
	//c1.set_timp(16,20,30);
	c1.display();
    }
}
class Ceas{
    private int hour,minute,sec;
    public Ceas(int h,int m,int s)
    {
	this.hour=(h>=0 && h<=24) ? h:0;
	this.minute=(m>=0 && m<=60) ? m:0;
	this.sec=(s>=0 && s<=60) ? s:0;
    }
    public void set_timp(int h,int m,int s)
    {
	this.hour=((h>=0 && h<=24) ? h:0);
	this.minute=((m>=0 && m<=60) ? m:0);
	this.sec=((s>=0 && s<=60) ? s:0);
    }
    public void display()
    {
	System.out.println("Ora:"+hour+" Minutul:"+minute+" Secunda:"+sec );
    }
}
