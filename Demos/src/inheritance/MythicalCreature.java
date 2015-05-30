package inheritance;

import java.util.ArrayList;

public class MythicalCreature {

	private ArrayList<String> powers;
	private Rarity rarity;
	
	public MythicalCreature(ArrayList<String> powers, Rarity rarity) {
		this.powers = powers;
		this.rarity = rarity;
	}
	
	public void victoryDance(){
		System.out.println("I'm dancing now. . . ");
	}
	
	public ArrayList<String> getPowers(){
		return powers;
	}
	
	public Rarity getRarity(){
		return rarity;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " powers=" + powers + ", rarity=" + rarity;
	}
	
}
