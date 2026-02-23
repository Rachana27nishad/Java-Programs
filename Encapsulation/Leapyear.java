class Leapyear
{
public static void main(String[] args)
{
int year = 2018;
if(year % 4 == 0) 
{
System.out.println("leap year");
}
else if(year % 100 == 0)
{
System.out.println("not a leap year");
}
else if (year % 400 == 0)
{
System.out.println(" Leap year");
}
else
{
System.out.println("not  a leap year");
}
}

}