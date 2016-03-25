package raele.dnd.randomdungeon;

public class RandomStair extends Location {
	
	private static class StraightCorridor extends Location {} // TODO
	private static class DeadEnd extends Location {} // TODO
	
	private static final RollableTable<Stair> stairsTable =
			new RollableTableBuilder<Stair>(Dice.d20)
					.addEntry(1, 4, new Stair(new int[]{-1}, new RandomChamber(), true))
					.addEntry(5, 8, new Stair(new int[]{-1}, new StraightCorridor(), true))
					.addEntry(9, new Stair(new int[]{-2}, new RandomChamber(), true))
					.addEntry(10, new Stair(new int[]{-2}, new StraightCorridor(), true))
					.addEntry(11, new Stair(new int[]{-3}, new RandomChamber(), true))
					.addEntry(12, new Stair(new int[]{-3}, new StraightCorridor(), true))
					.addEntry(13, new Stair(new int[]{1}, new RandomChamber(), true))
					.addEntry(14, new Stair(new int[]{1}, new StraightCorridor(), true))
					.addEntry(15, new Stair(new int[]{1}, new DeadEnd(), true))
					.addEntry(16, new Stair(new int[]{-1}, new DeadEnd(), true))
					.addEntry(17, new Stair(new int[]{1}, new StraightCorridor(), false))
					.addEntry(18, new Stair(new int[]{2}, new StraightCorridor(), false))
					.addEntry(19, new Stair(new int[]{-1}, new RandomChamber(), false))
					.addEntry(20, new Stair(new int[]{1, -1}, new RandomChamber(), false))
					.build();
	
	private Stair stairFeatures;
	
	public RandomStair() {
		refresh();
	}

	public void refresh() {
		this.stairFeatures = stairsTable.roll();
	}

}
