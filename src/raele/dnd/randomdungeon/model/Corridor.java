package raele.dnd.randomdungeon.model;

import java.util.ArrayList;
import java.util.function.Supplier;

import raele.util.Utils;

public class Corridor extends Location {
	
	public enum ExitLocation {
		RIGHT,
		LEFT,
		FORWARD,
	}
	
	private int length;
	private Exit[] exits;

	public Corridor(int length, Supplier<Location> right, Supplier<Location> left, Supplier<Location> forward) {
		super();
		ArrayList<Exit> exits = new ArrayList<Exit>(3);
		
		if (right != null) {
			exits.add(new Exit(right, ExitLocation.RIGHT));
		}
		
		if (left != null) {
			exits.add(new Exit(left, ExitLocation.LEFT));
		}
		
		if (forward != null) {
			exits.add(new Exit(forward, ExitLocation.FORWARD));
		}
		
		this.length = length;
		this.exits = exits.toArray(new Exit[exits.size()]);
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public Exit[] getExits() {
		return this.exits;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append(this.length)
				.append("-foot long corridor with ")
				.append(this.exits.length)
				.append(" exits: ")
				.append(Utils.formatReadableList(this.exits, "and").toLowerCase());
		return builder.toString();
	}
}
