package raele.dnd.randomdungeon.model;

import java.util.function.Supplier;

public class RandomDoor extends Location {
	
	private static final RollableTable<DoorType> TABLE_DOOR_TYPE =
			new RollableTableBuilder<DoorType>(Dice.d20)
					.addEntry(1, 10, new DoorType(DoorType.Type.WOODEN, false))
					.addEntry(11, 12, new DoorType(DoorType.Type.WOODEN, true))
					.addEntry(13, new DoorType(DoorType.Type.STONE, false))
					.addEntry(14, new DoorType(DoorType.Type.STONE, true))
					.addEntry(15, new DoorType(DoorType.Type.IRON, false))
					.addEntry(16, new DoorType(DoorType.Type.IRON, true))
					.addEntry(17, new DoorType(DoorType.Type.PORTCULLIS, false))
					.addEntry(18, new DoorType(DoorType.Type.PORTCULLIS, true))
					.addEntry(19, new DoorType(DoorType.Type.SECRET, false))
					.addEntry(20, new DoorType(DoorType.Type.SECRET, true))
					.build();

	private static class TrapBehindADoor extends Location { // TODO
		@Override
		public Exit[] getExits() {
			return new Exit[] {};
		}
	}
	
	private static final RollableTable<Supplier<Location>> TABLE_BEYOND_DOOR =
			new RollableTableBuilder<Supplier<Location>>(Dice.d20)
					.addEntry(1, 2, () -> new Corridor(10, () -> new Corridor(10, null, null, () -> new RandomBeyondPassage()), () -> new Corridor(10, null, null, () -> new RandomBeyondPassage()), null))
					.addEntry(3, 8, () -> new Corridor(20, null, null, () -> new RandomBeyondPassage()))
					.addEntry(9, 18, () -> new RandomChamber())
					.addEntry(19, () -> new RandomStair())
					.addEntry(20, () -> new TrapBehindADoor())
					.build();
	
	private DoorType doorFeatures;
	private Exit doorExit;
	
	public RandomDoor() {
		refresh();
	}

	public void refresh() {
		this.doorFeatures = TABLE_DOOR_TYPE.roll();
		this.doorExit = new Exit(TABLE_BEYOND_DOOR.roll(), null);
	}

	public DoorType getDoorFeatures() {
		return doorFeatures;
	}

	public void setDoorFeatures(DoorType doorFeatures) {
		this.doorFeatures = doorFeatures;
	}

	public Exit getDoorExit() {
		return this.doorExit;
	}

	public void setDoorExit(Exit doorExit) {
		this.doorExit = doorExit;
	}
	
	@Override
	public String toString() {
		DoorType door = this.getDoorFeatures();
		
		return (door.isLocked() ? "locked " : "unlocked ") + door.getType().toString().toLowerCase() + " door";  
	}

	@Override
	public Exit[] getExits() {
		return new Exit[] {this.doorExit};
	}

}
