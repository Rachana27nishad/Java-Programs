interface MultipleIn
{
void show();
}
interface I2
{
	void display();
}
class Test implements MultipleIn,I2
{
	public void show()
	{
		System.out.println("1");
	}
	public void display()
	{
		System.out.println("2");
	}
	public static void main(String[] args)
	{
		//MultipleIn i = new MultipleIn(); // error
		
		Test t = new Test();
		t.show();
		t.display();
		
	}
}



// ambiguity
// useing interface through