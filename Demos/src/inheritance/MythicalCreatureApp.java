package inheritance;

import java.util.ArrayList;

public class MythicalCreatureApp {
	
	public static void main(String[] args) {
		ArrayList<String> powers = new ArrayList<>();
		powers.add("Punch");
		powers.add("Glare");
		powers.add("BlowBubbles");
		powers.add("Telepathy");
		
		MythicalCreature goldFish = new MythicalCreature(powers, Rarity.LEGENDARY);
		System.out.println(goldFish);
		goldFish.victoryDance();
		System.out.println();
		
		ArrayList<String> wdPowers = new ArrayList<>();
		wdPowers.add("Evolve");
		wdPowers.add("WaterCannon");
		wdPowers.add("Surf");
		WaterDemon squirtle = new WaterDemon(wdPowers, Rarity.COMMON, 12.5);
		System.out.println(squirtle);
		squirtle.victoryDance();
		squirtle.blowBubbles();
		
	}

}
