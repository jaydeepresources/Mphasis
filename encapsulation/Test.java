package encapsulation;

public class Test {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("john doe");
		e1.setSalary(12345.6f);
		
		e1.print();	
		
	}	
}
