abstract class Vehicle
{
abstract void start();
}
class Car extends Vehicel
{
	void start()
	{
		System.out.println("Car start");
	}
	
}

class Scooter extends Vehicle
{
	void start()
	{
		System.out.println("Scooter start");
	}
	public static void main(String[] args)
	{
		//Vehicle ob = new Vehicle();           // abstract class , can not used
		//ob.start();
		
		//Car c = new Car();// main method not found
		//c.start();
		
		Scooter s =new Scooter();
		s.start();
		
	}
}
