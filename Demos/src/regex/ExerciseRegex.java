package regex;

public class ExerciseRegex {
	public static void main(String[] args) {
		String text = "What colour? Any colour - as long as it is black";
		System.out.println("original:  " + text);
		System.out.println("fixColour: " + fixColour(text));
		System.out.println("xxxColour: " + replaceWords(text));
		String newtext = "John        , Smith         ,   23,Seattle,        98103";
		System.out.println(newtext);
		System.out.println(fixCsvLine(newtext));
	}

	private static String fixCsvLine(String text) {
		return text.replaceAll("\\s*,\\s*", ",");
	}

	private static String replaceWords(String text) {
		return text.replaceAll("\\w+", "xxx");
	}

	private static String fixColour(String text) {
		return text.replaceAll("colour", "color");
	}

}
