import java.io.FileInputStream;

class Try
{
	public static void main(String[] args)
	{
		try
			{
				FileInputStream fis = new FileInputStream("d:/abc.txt");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
				System.out.println("Hello World");
		}
}