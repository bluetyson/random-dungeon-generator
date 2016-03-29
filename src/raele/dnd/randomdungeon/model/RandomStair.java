package raele.dnd.randomdungeon.model;

import java.util.function.Supplier;

public class RandomStair extends Location {
	
	// TODO No item 20, as duas saídas levam para o mesmo lugar? Ao invés de
	// receber um array de int e um Location, deveria haver um StairBuilder que
	// pudesse adicionar ilimitadas saídas com desníveis diferentes, assim como
	// na tabela RandomChamber.TABLE_DUNGEON_CHAMBER_CONTENTS; da forma como
	// está, é possível formar ilimitadas saídas, mas todas elas levam para o
	// mesmo local (para o mesmo objeto Location).
	private static final RollableTable<Stair> stairsTable =
			new RollableTableBuilder<Stair>(Dice.d20)
					.addEntry(1, 4, new Stair(new int[]{-1}, () -> new RandomChamber(), true))
					.addEntry(5, 8, new Stair(new int[]{-1}, () -> new Corridor(20, null, null, () -> new RandomBeyondPassage()), true))
					.addEntry(9, new Stair(new int[]{-2}, () -> new RandomChamber(), true))
					.addEntry(10, new Stair(new int[]{-2}, () -> new Corridor(20, null, null, () -> new RandomBeyondPassage()), true))
					.addEntry(11, new Stair(new int[]{-3}, () -> new RandomChamber(), true))
					.addEntry(12, new Stair(new int[]{-3}, () -> new Corridor(20, null, null, () -> new RandomBeyondPassage()), true))
					.addEntry(13, new Stair(new int[]{1}, () -> new RandomChamber(), true))
					.addEntry(14, new Stair(new int[]{1}, () -> new Corridor(20, null, null, () -> new RandomBeyondPassage()), true))
					.addEntry(15, new Stair(new int[]{1}, () -> new Corridor(0, null, null, null), true))
					.addEntry(16, new Stair(new int[]{-1}, () -> new Corridor(0, null, null, null), true))
					.addEntry(17, new Stair(new int[]{1}, () -> new Corridor(20, null, null, () -> new RandomBeyondPassage()), false))
					.addEntry(18, new Stair(new int[]{2}, () -> new Corridor(20, null, null, () -> new RandomBeyondPassage()), false))
					.addEntry(19, new Stair(new int[]{-1}, () -> new RandomChamber(), false))
					.addEntry(20, new Stair(new int[]{1, -1}, () -> new RandomChamber(), false))
					.build();
	
	private Stair stairFeatures;
	private Exit exit;
	
	public RandomStair() {
		refresh();
	}

	public void refresh() {
		this.stairFeatures = stairsTable.roll();
		this.exit = new Exit(this.stairFeatures.getExit(), null);
	}

	public Exit getExit() {
		return exit;
	}
	
	public void setExit(Exit exit) {
		this.exit = exit;
	}
	
	public Stair getStairFeatures() {
		return stairFeatures;
	}
	
	public void setStairFeatures(Stair stairFeatures) {
		this.stairFeatures = stairFeatures;
	}

	@Override
	public Exit[] getExits() {
		return new Exit[] {this.exit};
	}

}
