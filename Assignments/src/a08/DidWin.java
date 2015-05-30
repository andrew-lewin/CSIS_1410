package a08;

/**
 * Andrew Lewin
 * CSIS 1410
 * Assignment 8
 */

public enum DidWin {
	WIN(1), LOSE(0), TIE(0);
	
	private int score;
	
	private DidWin(int score){
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		switch(this) {
			case WIN: return " You win!";
			case LOSE: return " You lose!";
			case TIE: return "";
		}
		return "Invalid input";
	}
}