class MultiLevel
{
void show A(){
System.out.println("A class");
}
}

class B extends MultiLevel
{
void showB()
{
System.out.println("B class");
}
}

class C extends B
{
void showC()
{
System.out.println("C class");
}
public static void main(String[] args)
{

MultiLevel ob = new MultiLevel();
ob.show A(); 



B ob1 = new B();
ob1.showA();
ob1.showB();
//ob1.showC();



C ob2 = new C();
ob2.showA();
ob2.showB();
ob2.showC();

}
}