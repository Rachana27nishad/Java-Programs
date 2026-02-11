class OverloadingNoArgu
{
	void show(int a)
	{
		System.out.println("1");
	}
	
	void show(int a, int b )
	{
		System.out.println("2");
	}
	public static void main (String[] args)
	{
		OverloadingNoArgu ob = new OverloadingNoArgu();
		ob.show(10,20);
		ob.show(10);
	}
}
