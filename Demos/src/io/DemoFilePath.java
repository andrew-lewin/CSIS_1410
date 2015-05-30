package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DemoFilePath {
	public static void main(String[] args) {
		File path = new File("/home/andrew/Dropbox/CSIS_1410/DEMO");
		
		if (path.isDirectory()){
			for (File el : path.listFiles()) {
				displayPath(el);
			}
		}
		
	}

	private static void displayPath(File path) {
		System.out.println(path);
		if (path.isDirectory()){
			for (File el : path.listFiles()){
				displayPath(el);
			}
		}
	}

}
