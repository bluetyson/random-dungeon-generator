package raele.dnd.randomdungeon;
import java.util.Map;

public class RollableTable<R> implements Rollable<R> {
	
	private Rollable<Integer> diceExpression;
	private Map<Integer, R> table;

	public RollableTable(Rollable<Integer> diceExpression, Map<Integer, R> table) {
		this.diceExpression = diceExpression;
		this.table = table;
	}

	@Override
	public R roll() {
		Integer diceResult = this.diceExpression.roll();
		R result = this.table.get(diceResult);
		if (result == null) {
			throw new RuntimeException("Rollable table rolled a null entry at diceResult " + diceResult + ".");
		}
		return result;
	}

}
