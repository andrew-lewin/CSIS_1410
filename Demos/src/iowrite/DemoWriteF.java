package iowrite;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DemoWriteF {
	public static void main(String[] args) {
		Set<String> words = new HashSet<>(Arrays.asList(args));
		
		try(PrintWriter writer = new PrintWriter("src/iowrite/MyFirstOutput.txt")) {
			for (String word : words) {
				writer.println(word + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		
		System.out.println("done");

	}

}
