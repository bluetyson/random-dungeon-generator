package raele.dnd.randomdungeon;
import java.util.HashMap;


public class RollableTableBuilder<Result> {
	
	private Rollable<Integer> diceExpression;
	private HashMap<Integer, Result> map;
	
	public RollableTableBuilder(Rollable<Integer> exp) {
		this.diceExpression = exp;
		this.map = new HashMap<Integer, Result>();
	}
	
	public RollableTableBuilder<Result> addEntry(Integer roll, Result entry) {
		this.map.put(roll, entry);
		return this;
	}
	
	public RollableTableBuilder<Result> addEntry(Integer from, Integer to, Result entry) {
		for (int i = from; i <= to; i++) {
			this.addEntry(i, entry);
		}
		return this;
	}
	
	public RollableTable<Result> build() {
		return new RollableTable<Result>(this.diceExpression, this.map);
	}

}
