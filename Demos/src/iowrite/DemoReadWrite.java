package iowrite;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DemoReadWrite {
	public static void main(String[] args) {
		try(Scanner reader = 
			new Scanner(DemoReadWrite.class.getResourceAsStream("/iowrite/MyFirstOutput.txt"));
			PrintWriter writer = new PrintWriter("src/iowrite/MyFirstOutputWithLineNumbers.txt")) {
				int lineNumber = 1;
				while (reader.hasNextLine()){
					writer.printf("%02d %s%n", lineNumber++, reader.nextLine());
				}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}