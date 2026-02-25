import java.io.FileInputStream;
class Try1
{
public static void main(String[] args)
{
//int a=100 , b=0, c;
//c=a/b;
//System.out.println(c);
//System.out.println("hello"); 
//}
//}


// Exception in thread "main" java.lang.ArithmeticException: / by zero
        // at Try1.main(Try1.java:7)


// Abnormal terminate.


try{
int a=100 , b=0, c;
c=a/b;
System.out.println(c);
}
catch (ArthmeticException e)
{
System.out.println(e);
// System.out.println("You cannot divide by zero");
}

System.out.println("hello");
}
}