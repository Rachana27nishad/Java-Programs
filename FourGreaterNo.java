class FourGreaterNo
{
public static void main(String[] args)
{
int a=40, b=50, c=30 ,d=45;
if(a > b && a > c && a > d)
{
System.out.println("A is greater");
}
else if(b > a && b > c && b > d)
{
System.out.println(" B is greater");
}
else if(c > a && c > b && c > d)
{
System.out.println("C is greater");
}
else
{
	System.out.println("D is greater");
}
}
}