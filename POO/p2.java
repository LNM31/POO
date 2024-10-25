class p2{
    public static void main(String[] args)
    {
	specificator spec=new specificator();
	spec.met_publica();
	//spec.met_private();
	System.out.println(spec.atr_public);
	//System.out.println(spec.atr_private);
    }
}
class specificator{
    public int atr_public;
    private int atr_private;
    public void met_publica()
    {
	atr_public=20;
	atr_private=met_private();
    }
    private int met_private()
    {
	return 10;
    }
    public void alta_metoda(specificator s)
    {
	atr_public=s.atr_private;
	atr_private=s.met_private();
	s.met_publica();
    }
}
