package itinerary;

import java.util.ArrayList;
import java.util.Scanner;

public class Itinerary {
	public static void main(String[] args){
		ArrayList<String> itinerary = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		String destination;
		boolean repeat = true;
		StringBuilder sb = new StringBuilder();
		String travelRoute;
		
		while (repeat == true){
			System.out.print("Destination: ");
			destination = input.next().toLowerCase();
			if (destination.equals("done")){
				repeat = false;
			}
			else{
				itinerary.add(destination);
			}
		}
		
		for (int i = 0; i < itinerary.size(); i++){
			sb.append(itinerary.get(i).toUpperCase() + " to ");
		}
		sb.delete(sb.length() - 4, sb.length());
		travelRoute = sb.toString();
		System.out.println("Your travel route is:");
		System.out.println(travelRoute);
		
		input.close();
	}
}
