package a08;

/**
 * Andrew Lewin
 * CSIS 1410
 * Assignment 8
 */

import javax.swing.ImageIcon;

public enum RockPaperScissors {
	ROCK    (new ImageIcon(RockPaperScissors.class.getResource("images/rock.png"))), 
	PAPER   (new ImageIcon(RockPaperScissors.class.getResource("images/paper.png"))), 
	SCISSORS(new ImageIcon(RockPaperScissors.class.getResource("images/scissors.png"))), 
	LIZARD  (new ImageIcon(RockPaperScissors.class.getResource("images/lizard.png"))), 
	SPOCK   (new ImageIcon(RockPaperScissors.class.getResource("images/spock.png")));
	
	private final ImageIcon icon; 
	private DidWin didWin;
	
	private RockPaperScissors(ImageIcon icon) {
		this.icon = icon;
	}
	
	public ImageIcon getIcon() {
		return this.icon;
	}
	
	public DidWin didWin() {
		return didWin;
	}
	
	public String evaluate(RockPaperScissors opponant) {
		switch(this) {
			case ROCK: 
				switch (opponant) {
					case ROCK: didWin = DidWin.TIE;
						return "Tie!";
					case PAPER: didWin = DidWin.LOSE;
						return "Paper covers rock.";
					case SCISSORS: didWin = DidWin.WIN;
						return "Rock crushes scissors.";
					case LIZARD: didWin = DidWin.WIN;
						return "Rock crushes lizard.";
					case SPOCK: didWin = DidWin.LOSE;
						return "Spock vaporizes rock.";
				}
			case PAPER: 
				switch (opponant) {
					case ROCK: didWin = DidWin.WIN;
						return "Paper covers rock.";
					case PAPER: didWin = DidWin.TIE;
						return "Tie!";
					case SCISSORS: didWin = DidWin.LOSE;
						return "Scissors cuts paper.";
					case LIZARD: didWin = DidWin.LOSE;
						return "Lizard eats paper.";
					case SPOCK: didWin = DidWin.WIN;
						return "Paper disproves spock.";
				}
			case SCISSORS: 
				switch (opponant) {
					case ROCK: didWin = DidWin.LOSE;
						return "Rock crushes scissors.";
					case PAPER: didWin = DidWin.WIN;
						return "Scissors cuts paper.";
					case SCISSORS: didWin = DidWin.TIE;
						return "Tie!";
					case LIZARD: didWin = DidWin.WIN;
						return "Scissors decapitates lizard.";
					case SPOCK: didWin = DidWin.LOSE;
						return "Spock smashes scissors.";
				}
			case LIZARD: 
				switch (opponant) {
					case ROCK: didWin = DidWin.LOSE;
						return "Rock crushes lizard.";
					case PAPER: didWin = DidWin.WIN;
						return "Lizard eats paper.";
					case SCISSORS: didWin = DidWin.LOSE;
						return "Scissors decapitates lizard.";
					case LIZARD: didWin = DidWin.TIE;
						return "Tie!";
					case SPOCK: didWin = DidWin.WIN;
						return "Lizard poisons spock.";
				}
			case SPOCK: 
				switch (opponant) {
					case ROCK: didWin = DidWin.WIN;
						return "Spock vaporizes rock.";
					case PAPER: didWin = DidWin.LOSE;
						return "Paper disproves spock.";
					case SCISSORS: didWin = DidWin.WIN;
						return "Spock smashes scissors.";
					case LIZARD: didWin = DidWin.LOSE;
						return "Lizard poisons spock.";
					case SPOCK: didWin = DidWin.TIE;
						return "Tie!";
				}
		}
		return "Invalid entry";
	}
	
}