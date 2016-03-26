package raele.dnd.randomdungeon;

public class Corridor extends Location {
	
	private int length;
	private Location right;
	private Location left;
	private Location forward;
	
	public Corridor() {
		
	}

	public Corridor(int length, Location right, Location left, Location forward) {
		super();
		this.length = length;
		this.right = right;
		this.left = left;
		this.forward = forward;
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Location getRight() {
		return right;
	}
	public void setRight(Location right) {
		this.right = right;
	}
	public Location getLeft() {
		return left;
	}
	public void setLeft(Location left) {
		this.left = left;
	}
	public Location getForward() {
		return forward;
	}
	public void setForward(Location forward) {
		this.forward = forward;
	}

}
