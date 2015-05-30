package pacman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * @authors Andrew Lewin & Joshua Hardesty
 */
public class Player {
	private String name;
	private int score = 0;
	private static int highScore = 0;
	
	public Player(String name) {
		this.name = name;
		getHighScoreFromFile();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public void addScore() {
		score += 10;
	}
	
	public void setHighScore() {
		if (score > getHighScore()) {
			highScore = score;
			// Write high score data to a text file
			try(PrintWriter writer = new PrintWriter(new File("/home/andrew/HighScore.txt"))) {
				writer.println(highScore);
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} 
	}
	
	
	public void getHighScoreFromFile() {
		try (Scanner reader = new Scanner(new File("/home/andrew/HighScore.txt"))){
			highScore = reader.nextInt();
			reader.close();
		} catch(NullPointerException | FileNotFoundException e) {
			highScore = 0;
		}
	}
	
	public int getHighScore() {
		return highScore;
	}
	
}

