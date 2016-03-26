package raele.dnd.randomdungeon;

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

	private static class TrapBehindADoor extends Location {} // TODO
	
	private static final RollableTable<LocationCreator> TABLE_BEYOND_DOOR =
			new RollableTableBuilder<LocationCreator>(Dice.d20)
					.addEntry(1, 2, () -> new Corridor(10, new Corridor(10, null, null, new RandomBeyondPassage()), new Corridor(10, null, null, new RandomBeyondPassage()), null))
					.addEntry(3, 8, () -> new Corridor(20, null, null, new RandomBeyondPassage()))
					.addEntry(9, 18, () -> new RandomChamber())
					.addEntry(19, () -> new RandomStair())
					.addEntry(20, () -> new TrapBehindADoor())
					.build();
			
	
	private DoorType doorFeatures;
	private Location doorExit;
	
	public RandomDoor() {
		refresh();
	}

	public void refresh() {
		this.doorFeatures = TABLE_DOOR_TYPE.roll();
		this.doorExit = TABLE_BEYOND_DOOR.roll().create();
	}

	public DoorType getDoorFeatures() {
		return doorFeatures;
	}

	public void setDoorFeatures(DoorType doorFeatures) {
		this.doorFeatures = doorFeatures;
	}

	public Location getDoorExit() {
		return doorExit;
	}

	public void setDoorExit(Location doorExit) {
		this.doorExit = doorExit;
	}

}
