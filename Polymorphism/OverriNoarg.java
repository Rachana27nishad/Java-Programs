class OverriNoarg
{
void show()
{
System.out.println("2");
}
}

class B extends OverriNoarg
{
void show()
{
System.out.println("3");
}
public static void main(String[] args)
{
OverriNoarg ob1 = new OverriNoarg();
ob1.show();

  
B ob = new B();
ob.show();
}
}
