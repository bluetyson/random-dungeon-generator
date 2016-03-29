package raele.dnd.randomdungeon.consoleui;

import java.util.Scanner;

import raele.dnd.randomdungeon.model.Exit;
import raele.dnd.randomdungeon.model.Location;
import raele.dnd.randomdungeon.model.RandomChamber;
import raele.util.Utils;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		RandomChamber initialRoom = new RandomChamber();
		explore(initialRoom);
	}
	
	public static void explore(Location location) {
		boolean exploring = true;
		
		while (exploring) {
			System.out.println("You came into a(n) " + location);
			
			Exit[] exits = location.getExits();
			
			for (int i = 0; i < exits.length; i++) {
				Object position = exits[i].getPosition();
				String positionString = (""+position).toLowerCase().replace("_", " ");
				System.out.println("\t" + (i + 1) + ". Exit at " + positionString + ".");
			}
			
			System.out.println("\nWhere do you want to go? (0 to return)");
			int way = scanner.nextInt() - 1;
			if (way == -1) {
				exploring = false;
			} else {
				explore(exits[way].getBeyond());
			}
		}
	}

}
