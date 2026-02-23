class OverriSeqarg
{
void show()
{
System.out.println("3");
}
}

class B extends OverriNoarg
{
void show()
{
System.out.println("7");
}
public static void main(String[] args)
{
 OverriSeqarg ob1 = new  OverriSeqarg();
ob1.show();

B ob = new B();
ob.show();
}
}