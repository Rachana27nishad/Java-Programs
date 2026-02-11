class  OverriTypearg
{
	void show()
	{
		System.out.println("5");
	}
}

class B extends  OverriTypearg
{
	void show()
	{
		System.out.println("4");
	}
	public static void main(String[] args)
	{
		B ob =  new  OverriTypearg();
		ob.show();
		
	}
	
}
