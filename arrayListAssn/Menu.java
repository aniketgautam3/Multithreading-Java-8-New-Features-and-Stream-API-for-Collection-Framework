package arrayListAssn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public final class Menu {
	
	static final class Employee {
		String id;
		String name;
		double salary;
		
		
		public Employee(String id, String name, double salary) {
			this.id = id;
			this.name = name;
			this.salary = salary;
		}
		
		public Employee() {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter the ID of the employee: ");
			this.id = sc.next();
			System.out.print("Enter the salary of the employee: ");
			this.salary = sc.nextDouble();
			System.out.print("Enter the name of the employee: ");
			this.name = sc.next();
		}
		
		
		public final String getId() {
			return id;
		}
		public final void setId(String id) {
			this.id = id;
		}
		public final String getName() {
			return name;
		}
		public final void setName(String name) {
			this.name = name;
		}
		public final double getSalary() {
			return salary;
		}
		public final void setSalary(double salary) {
			this.salary = salary;
		}
		
		public final void display() {
			System.out.println("\nID: " + this.id);
			System.out.println("\tSalary: " + this.salary);
			System.out.println("\tName: " + this.name);
		}
		
	}

	public static void main(String[] args) {
		ArrayList<Employee> arr = new ArrayList<Employee>();
		
		
		
		int choice = 2;
		
		while (choice != 0) {
			System.out.println("\n\n0 -> Exit");
			System.out.println("1 -> Insert");
			System.out.println("2 -> Display");
			System.out.println("3 -> Search");
			System.out.println("4 -> Delete");
			System.out.println("5 -> Update");
			
			System.out.print("Enter your choice: ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			if (choice == 1) {
				Employee temp = new Employee();
				arr.add(temp);
			} else if (choice == 2) {
				System.out.print("ArrayList contains: ");
				Iterator<Employee> iter = arr.iterator();
				while (iter.hasNext()) {
					iter.next().display();
				}
			} else if (choice == 3) {
				System.out.print("Enter the employeeID to be checked: ");
				String query = sc.next();
				Iterator<Employee> iter = arr.iterator();
				boolean found = false;
				while (iter.hasNext()) {
					Employee curr = iter.next();
					if (curr.getId().equals(query)) {
						System.out.println("Found");
						curr.display();
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("Not found");
				}
			} else if (choice == 4) {
				System.out.print("Enter the employeeID to be deleted: ");
				String query = sc.next();
				Iterator<Employee> iter = arr.iterator();
				boolean found = false;
				while (iter.hasNext()) {
					Employee curr = iter.next();
					
					if (curr.getId().equals(query)) {
						arr.remove(curr);
						System.out.println("Removed");
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("Not found");
				}	
			} else if (choice == 5) {
				System.out.print("Enter the employeeID to be updated: ");
				String query = sc.next();
				Iterator<Employee> iter = arr.iterator();
				boolean found = false;
				Employee curr = new Employee("0", "0", 0);
				while (iter.hasNext()) {
					curr = iter.next();
					if (curr.getId().equals(query)) {
						System.out.println("Found");
						curr.display();
						found = true;
						break;
					}
				}
				if (found == false) {
					System.out.println("The ArrayList does not contain this employeeID");
				} else {
					arr.set(arr.indexOf(curr), new Employee());
				}
			} else {
				break;
			}
		}
		
		
	}

}
