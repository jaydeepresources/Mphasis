package bounded;

public class TestBounded {

	public static void main(String[] args) {
		
		ServiceCenter<Car> sc1 = new ServiceCenter<>(new Car());
		sc1.printServiceCenter();
		
		ServiceCenter<Bike> sc2 = new ServiceCenter<>(new Bike());
		sc2.printServiceCenter();
		
	}

}
