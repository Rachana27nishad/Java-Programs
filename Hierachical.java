class Hyraical
{
void showA()
{
System.out.println("A class");
}
}

class B extends Hyraical
{
void showB()
{
System.out.println("B class");
}
}


class C extends A 
{
void showC()
{
System.out.println("C class");
}
public static void main(String[] args)
{
	
A ob1 = new A();
ob1.showA();
//ob1.showB(); not call
//ob1.showC(); not call


B ob2 = new B();
ob2.showA();
ob2.showB();
//ob2.showC(); NOT CALL  only extends A
	
	
	
	
	
C ob = new C();
ob.showA();
//ob.showB();  not call, keyuki c extends only A not B
ob.showC();
}
}