class FourSmallestNo
{
public static void main(String[] args)
{
int a=40, b=60 , c=50, d=55;
if(a < b && a < c && a < d )
{
System.out.println("A is smallest");
}
else if(b < a && b < c && b < d)
{
System.out.println("B is smallest");
}
else if(c < a && c < b && c < d)
{
System.out.println("C is smallest");
}
else 
{
System.out.println("D is smallest");
}
}
}