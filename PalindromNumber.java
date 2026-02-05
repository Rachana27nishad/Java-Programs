class PalindromNumber
{
	public static void main(String[] args)
	{
	
	int no=242;
	int temp=no;
	int rev=0 , rem;
	
	while(temp != 0)
	{
		
		rem=temp%10;
		rev=rev*10+rem;
		temp=temp/10;
		
		
	}
	
	if(no==rev)
	{
		System.out.println("palindrom number");
	}
	else
	{
		System.out.println("not palindrom number");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}