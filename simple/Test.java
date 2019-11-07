package simple;

public class Test {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		e1.id = 1;
		e1.name = "john doe";
		e1.salary = 12345.6f;
		
		e1.print();	
		
		Employee e2 = new Employee(2,"jane doe",12345.6f);
		e2.print();
		
	}	
}
