package a01;

import java.util.Scanner;
import java.util.ArrayList;

public class StudentApp {
	public static void main(String[] args) {
		
		boolean exit = false;
		int number;
		Scanner input = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<Student>();
			students.add(new Student("Bob", "McBobson", "PS", 3.5));
			students.add(new Student("Joe", "McJoeson", "CS", 3.9));
			students.add(new Student("Kate","McKateson", "GE", 4.0));
		
		do {
			System.out.println("\nEnter the option number to make a selection");
			System.out.println("1. Add a student");
			System.out.println("2. Find a student");
			System.out.println("3. Delete a student");
			System.out.println("4. Display all students");
			System.out.println("5. Display the total number of students");
			System.out.println("6. Exit");
			
		while (!input.hasNextInt()){
			System.out.println("Please enter one of the numbers from the option above.");
			input.next();
		}
			int option = input.nextInt();
			
			switch (option) {
				case 1: students.add(students.size(), new Student());
						System.out.print("\nEnter first name: ");
							students.get(students.size() - 1).setFirstName(input.next());
						System.out.print("Enter last name: ");
							students.get(students.size() - 1).setLastName(input.next());
						System.out.print("Enter major: ");
							students.get(students.size() - 1).setMajor(input.next());
						System.out.print("Enter GPA: ");
							while (!input.hasNextDouble()){
								System.out.println("Please enter a valid GPA number.");
								input.next();
							}
							students.get(students.size() - 1).setGpa(input.nextDouble());
						break;
				case 2: System.out.print("\nEnter the student number for the student you'd like to find: S");
						while (!input.hasNextInt()){
							System.out.println("Please enter a valid student number. The S is already filled in for you.");
							System.out.print("S");
							input.next();
						}
						number = input.nextInt();
						boolean isFound = false;
						for (Student student : students){
							if (student.getSNumber() == number){
								System.out.println(student);
								isFound = true;
							}
						}
						if (isFound == false){
							System.out.println("Sorry, no students match that student number.");
						}
						break;
				case 3: System.out.print("\nEnter the student number for the student you'd like to delete: S");
						while (!input.hasNextInt()){
							System.out.println("Please enter a valid student number. The S is already filled in for you.");
							System.out.print("S");
							input.next();
						}
						number = input.nextInt();
						int i = 0;
						boolean isDeleated = false;
						for (Student student : new ArrayList<Student>(students)){
							if (student.getSNumber() == number){
								System.out.println("\n" + students.get(i).getSNumber() + " " + students.get(i).getFirstName() + " " + students.get(i).getLastName() + " has been deleted.");
								students.remove(i);
								isDeleated = true;
							}
							i++;
						}
						if (isDeleated == false){
							System.out.println("No students matching that student number were found to delete.");
						}
						break;
				case 4: System.out.println("");
						for (Student student : students){
							System.out.println(student);
						}
						break;
				case 5: if(students.size() == 1) {
							System.out.println("\nThere is currently " + students.size() + " student in the system.");
						}
						else {
							System.out.println("\nThere are currently " + students.size() + " students in the system.");
						}
						break;
				case 6: System.out.println("\nGoodbye");
						exit = true; 
						break;
				default: System.out.println("\nInvalid input. Try again.");
			}
		} while (exit == false);
		
		input.close();
		System.exit(0);
	}

}
