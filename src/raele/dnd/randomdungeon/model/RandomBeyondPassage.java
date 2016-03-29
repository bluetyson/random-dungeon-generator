package raele.dnd.randomdungeon.model;

import java.util.function.Supplier;

public class RandomBeyondPassage extends Location {
	
	private static class SecretDoor extends RandomDoor {}

	private static final RollableTable<Supplier<Location>> TABLE_PASSAGE =
			new RollableTableBuilder<Supplier<Location>>(Dice.d20)
					.addEntry(1, 2, () -> new Corridor(30, null, null, () -> new RandomBeyondPassage()))
					.addEntry(3, () -> new Corridor(20, () -> new RandomDoor(), null, () -> new Corridor(10, null, null, () -> new RandomBeyondPassage())))
					.addEntry(4, () -> new Corridor(20, null, () -> new RandomDoor(), () -> new Corridor(10, null, null, () -> new RandomBeyondPassage())))
					.addEntry(5, () -> new Corridor(20, null, null, () -> new RandomDoor()))
					.addEntry(6, 7, () -> new Corridor(20, () -> new RandomBeyondPassage(), null, () -> new Corridor(10, null, null, () -> new RandomBeyondPassage())))
					.addEntry(8, 9, () -> new Corridor(20, null, () -> new RandomBeyondPassage(), () -> new Corridor(10, null, null, () -> new RandomBeyondPassage())))
					.addEntry(10, () -> new Corridor(10, null, null, () -> Dice.d100.roll() <= 10 ? new SecretDoor() : null ))
					.addEntry(11, 12, () -> new Corridor(20, null, () -> new Corridor(10, null, null, () -> new RandomBeyondPassage()), null))
					.addEntry(13, 14, () -> new Corridor(20, () -> new Corridor(10, null, null, () -> new RandomBeyondPassage()), null, null))
					.addEntry(15, 19, () -> new RandomChamber())
					.addEntry(20, () -> new RandomStair())
					.build();
	
	private Location location;
	
	public RandomBeyondPassage() {
		super();
		refresh();
	}
	
	public void refresh() {
		this.location = TABLE_PASSAGE.roll().get();
	}

	@Override
	public Exit[] getExits() {
		return this.location.getExits();
	}
	
	@Override
	public String toString() {
		return ""+this.location;
	}

}
