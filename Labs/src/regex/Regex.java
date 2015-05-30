package regex;

import java.util.Arrays;
import java.util.Scanner;

public class Regex {

    public static void main(String[] args) {
          String myRegex1 = "CSIS-\\d{4}";
          String upperCaseA = "A\\w*";
          String upperCaseVowel = "[AEIOU]\\w*";
          String upperCaseVowel2Char = "[AEIOU]\\w+";
          test(myRegex1);
          
          demoRegexAndStringSplit();
    }

    private static void demoRegexAndStringSplit() {
		String findCommaInSpaces = "\\s*,\\s*";
		String myString = "one,   two  ,  three   ,   four,  five   ,six,seven    ,    eight";
		System.out.println(myString);
		String[] myNewString = myString.split(findCommaInSpaces);
		System.out.println(Arrays.toString(myNewString));
	}

	private static void test(String regex) {
          String word;
          Scanner input = new Scanner(System.in);
          System.out.printf("Enter words to match the expression %s%n", regex);
          System.out.println("Enter DONE when you are finished");
          System.out.print("Word: ");
          word = input.nextLine();
          while (!word.equalsIgnoreCase("done")) {
                System.out.printf("%s %s%n", word, word.matches(regex) ? "matches"
                            : "does not match");
                System.out.print("Word: ");
                word = input.nextLine();
          }
          input.close();
    }
}