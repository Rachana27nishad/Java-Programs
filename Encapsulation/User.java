import java.util.Scanner;
class User
{
public static void main(String[] args)
{
Scanner s = new Scanner(System.in);

System.out.println("Enter  your name");
String name = s.next();

System.out.println("Enter Gender");
char gender = s.next().charAt(0);

System.out.println("Enter age");
int age = s.nextInt();

System.out.println("Enter your mobile no");
long phono =s.nextLong();

System.out.print("Name : "+ name); 
System.out.println("Gender : "+ gender );
System.out.println("Age : "+ age);
System.out.println("phone no : "+ phono);

}
}