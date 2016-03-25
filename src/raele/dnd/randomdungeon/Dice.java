package raele.dnd.randomdungeon;
import java.util.Random;

public class Dice implements Rollable<Integer> {
	
	public static final Dice d4 = new Dice(4);
	public static final Dice d6 = new Dice(6);
	public static final Dice d8 = new Dice(8);
	public static final Dice d10 = new Dice(10);
	public static final Dice d12 = new Dice(12);
	public static final Dice d20 = new Dice(20);
	public static final Dice d100 = new Dice(100);
	
	private static Random random = new Random();
	
	private final int maxValue;
	
	public Dice(int maxValue) {
		this.maxValue = maxValue;
	}
	
	public int getMaxValue() {
		return maxValue;
	}
	
	public Integer roll() {
		return random.nextInt(this.maxValue) + 1;
	}
	
	public Integer roll(int n) {
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			result += this.roll();
		}
		
		return result;
	}

}
