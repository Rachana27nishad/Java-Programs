class OverloaTypeargu
{
	
void show(int a, int b )
{
System.out.println("2");
}
void show(String a)
{
System.out.println("Abc");
}
public static void main(String[] args) 
{
OverloaTypeargu ob = new OverloaTypeargu();
ob.show(1,2);
ob.show("abc");
}
}