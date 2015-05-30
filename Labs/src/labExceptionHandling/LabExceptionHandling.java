package labExceptionHandling;

import java.util.Scanner;

public class LabExceptionHandling
{
	public static void main(String[] args)
	{
		try {
			int digit = numberFromUser();
			int result = sevenModulusN(digit);
			System.out.printf("7 %% %d = %d", digit, result);
		} catch (IllegalArgumentException e) {
			System.out.println("A problem occured: " + e.getMessage());
		}
		
	}

	private static int numberFromUser()
	{
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Number: ");
			if (input.hasNextInt()) {
				return input.nextInt();
			} else {
				input.nextLine();
				System.out.println("The number entered needs to be a whole number");
			}
		} while (true);
	}

	private static int sevenModulusN(int number)
	{
		if (number == 0) throw new IllegalArgumentException("Can't calculate 7 % 0");
		return 7 % number;
	}
}