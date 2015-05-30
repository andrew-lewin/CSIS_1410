package inheritance;

import java.util.ArrayList;

public class WaterDemon extends MythicalCreature {
	
	private double swimSpeed;

	public WaterDemon(ArrayList<String> powers, Rarity rarity, double swimSpeed) {
		super(powers, rarity);
		this.swimSpeed = swimSpeed;
	}
	
	public void blowBubbles(){
		System.out.println("Splash splash glub glub");
	}
	@Override
	public String toString() {
		return super.toString() + " swimspeed=" + swimSpeed;
	}
	
}
