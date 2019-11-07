package arrays;

import java.util.Scanner;

public class TestEmployee {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter number of Employees");

		Employee[] employees = new Employee[scan.nextInt()];

		for (int i = 0; i < employees.length; i++) {
			System.out.println("Enter id, name and salary for employee " + (i + 1));
			employees[i] = new Employee(scan.nextInt(), scan.next(), scan.nextFloat());
		}

		for (int i = 0; i < employees.length; i++) {
			employees[i].print();
		}
		
		for (Employee employee : employees) {
			employee.print();
		}

	}
}
