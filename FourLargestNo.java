class FourLargestNo
{
public static void main(String[] args)
{
int a=250, b=380 ,c=400 ,d=200;

if(a > b && a > c  && a > d  )
{
System.out.println("a is largest");
}
else if(b > a && b > c && b >  d )
{
System.out.println("b is  smallest");
}
else if(c > a && c > b  && c > d)
{
System.out.println("c is largest");
}
else{
	System.out.println("d is largest");
}

}
}