package raele.dnd.randomdungeon;

public class NumberOfExits {
	
	private final int whenNormal;
	private final int whenLarge;
	
	public NumberOfExits(int whenNormal, int whenLarge) {
		super();
		this.whenNormal = whenNormal;
		this.whenLarge = whenLarge;
	}

	public int getWhenNormal() {
		return whenNormal;
	}

	public int getWhenLarge() {
		return whenLarge;
	}

}
