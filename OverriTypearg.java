class  OverriTypearg
{
	void show(String a)
	{
		System.out.println("5");
	}
}

class B extends  OverriTypearg
{
	void show(String a)
	{
		System.out.println("4");
	}
	public static void main(String[] args)
	{
		// OverriTypearg ob = new  OverriTypearg();
		 //ob.show();
		 
		 B ob1 = new B();
		 ob1.show();
		 
		
	}
	
}
