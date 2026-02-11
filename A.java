class A
{
void showA()
{
System.out.println(" a class method");
}
}

class B extends A
{
void showB()
{
System.out.println("b class method");
}
public static void main(String[] args)
{
A ob = new A();
ob.showA();
//  ob.showB();   //  not call B

B ob1 = new B(); // Together Call
ob1.showA();
ob1.showB();
}
}