package raele.dnd.randomdungeon.model;

import java.util.function.Supplier;

import raele.dnd.randomdungeon.model.Chamber.Shape;
import raele.dnd.randomdungeon.model.Chamber.Size;

public class RandomChamber extends Location {
	
	public enum ExitLocation {
		OPPOSITE_WALL,
		LEFT_WALL,
		RIGHT_WALL,
		SAME_WALL,
	}
	private enum ExitType implements Supplier<Location> {
	
		DOOR(() -> new RandomDoor()),
		CORRIDOR(() -> new Corridor(10, null, null, () -> new RandomBeyondPassage())),
		;
		private Supplier<Location> supplier;
		private ExitType(Supplier<Location> supplier) {
			this.supplier = supplier;
		}
		@Override
		public Location get() {
			return this.supplier.get();
		}
	}
	
	private static final RollableTable<Chamber> TABLE_CHAMBER =
			new RollableTableBuilder<Chamber>(Dice.d20)
					.addEntry(1, 2, new Chamber(20, 20, Shape.SQUARE, Size.NORMAL))
					.addEntry(3, 4, new Chamber(30, 30, Shape.SQUARE, Size.NORMAL))
					.addEntry(5, 6, new Chamber(40, 40, Shape.SQUARE, Size.NORMAL))
					.addEntry(7, 9, new Chamber(20, 30, Shape.RECTANGLE, Size.NORMAL))
					.addEntry(10, 12, new Chamber(30, 40, Shape.RECTANGLE, Size.NORMAL))
					.addEntry(13, 14, new Chamber(40, 50, Shape.RECTANGLE, Size.LARGE))
					.addEntry(15, new Chamber(50, 80, Shape.RECTANGLE, Size.LARGE))
					.addEntry(16, new Chamber(30, 30, Shape.CIRCLE, Size.NORMAL))
					.addEntry(17, new Chamber(50, 50, Shape.CIRCLE, Size.LARGE))
					.addEntry(18, new Chamber(40, 40, Shape.OCTAGON, Size.LARGE))
					.addEntry(19, new Chamber(60, 60, Shape.OCTAGON, Size.LARGE))
					.addEntry(20, new Chamber(40, 60, Shape.TRAPEZOID, Size.LARGE))
					.build();
	
	private static final RollableTable<NumberOfExits> TABLE_NUMBER_OF_EXITS =
			new RollableTableBuilder<NumberOfExits>(Dice.d20)
					.addEntry(1, 3, new NumberOfExits(0, 0))
					.addEntry(4, 5, new NumberOfExits(0, 1))
					.addEntry(6, 8, new NumberOfExits(1, 1))
					.addEntry(9, 11, new NumberOfExits(1, 2))
					.addEntry(12, 13, new NumberOfExits(2, 2))
					.addEntry(14, 15, new NumberOfExits(2, 3))
					.addEntry(16, 17, new NumberOfExits(3, 3))
					.addEntry(18, new NumberOfExits(3, 4))
					.addEntry(19, new NumberOfExits(4, 5))
					.addEntry(20, new NumberOfExits(4, 6))
					.build();
	
	private static final RollableTable<ExitLocation> TABLE_EXIT_LOCATION =
			new RollableTableBuilder<ExitLocation>(Dice.d20)
					.addEntry(1, 7, ExitLocation.OPPOSITE_WALL)
					.addEntry(8, 12, ExitLocation.LEFT_WALL)
					.addEntry(13, 17, ExitLocation.RIGHT_WALL)
					.addEntry(18, 20, ExitLocation.SAME_WALL)
					.build();
	
	private static final RollableTable<ExitType> TABLE_EXIT_TYPE =
			new RollableTableBuilder<ExitType>(Dice.d20)
					.addEntry(1, 10, ExitType.DOOR)
					.addEntry(11, 20, ExitType.CORRIDOR)
					.build();
	
	private static final RollableTable<String> TABLE_GENERAL_CHAMBER_PURPOSE =
			new RollableTableBuilder<String>(Dice.d100)
					.addEntry(1, "Antechamber")
					.addEntry(2, 3, "Armory")
					.addEntry(4, "Audience chamber")
					.addEntry(5, "Aviary")
					.addEntry(6, 7, "Banquet room")
					.addEntry(8, 10, "Barracks")
					.addEntry(11, "Bath or latrine")
					.addEntry(12, "Bedroom")
					.addEntry(13, "Bestiary")
					.addEntry(14, 16, "Cell")
					.addEntry(17, "Chantry")
					.addEntry(18, "Chapel")
					.addEntry(19, 20, "Cistern")
					.addEntry(21, "Classroom")
					.addEntry(22, "Closet")
					.addEntry(23, 24, "Conjuring room")
					.addEntry(25, 26, "Court")
					.addEntry(27, 29, "Crypt")
					.addEntry(30, 31, "Dining room")
					.addEntry(32, 33, "Divination room")
					.addEntry(34, "Dormitory")
					.addEntry(35, "Dressing room")
					.addEntry(36, "Entry room or vestibule")
					.addEntry(37, 38, "Gallery")
					.addEntry(39, 40, "Game room")
					.addEntry(41, 43, "Guardroom")
					.addEntry(44, 45, "Hall")
					.addEntry(46, 47, "Hall, great")
					.addEntry(48, 49, "Hallway")
					.addEntry(50, "Kennel")
					.addEntry(51, 52, "Kitchem")
					.addEntry(53, 54, "Laboratory")
					.addEntry(55, 57, "Library")
					.addEntry(58, 59, "Lounge")
					.addEntry(60, "Meditation chamber")
					.addEntry(61, "Observatory")
					.addEntry(62, "Office")
					.addEntry(63, 64, "Pantry")
					.addEntry(65, 66, "Pen or prison")
					.addEntry(67, 68, "Reception room")
					.addEntry(69, 70, "Refectory")
					.addEntry(71, "Robing room")
					.addEntry(72, "Salon")
					.addEntry(73, 74, "Shrine")
					.addEntry(75, 76, "Sitting room")
					.addEntry(77, 78, "Smithy")
					.addEntry(79, "Stable")
					.addEntry(80, 81, "Storage room")
					.addEntry(82, 83, "Strong room or vault")
					.addEntry(84, 85, "Study")
					.addEntry(86, 88, "Temple")
					.addEntry(89, 90, "Throne room")
					.addEntry(91, "Torture chamber")
					.addEntry(92, 93, "Training or exercise room")
					.addEntry(94, 95, "Trophy room or museum")
					.addEntry(96, "Waiting room")
					.addEntry(97, "Nursery or schoolroom")
					.addEntry(98, "Well")
					.addEntry(99, 100, "Workshop")
					.build();
	
	private static final RollableTable<String> TABLE_CURRENT_CHAMBER_STATE =
			new RollableTableBuilder<String>(Dice.d20)
					.addEntry(1, 3, "Rubble, ceiling partially collapsed")
					.addEntry(4, 5, "Holes, floor partially collapsed")
					.addEntry(6, 7, "Ashes, contents mostly burned")
					.addEntry(8, 9, "Used as a campsite")
					.addEntry(10, 11, "Pool of water; chamber's original contents are water damaged")
					.addEntry(12, 16, "Furniture wrecked but still present")
					.addEntry(17, 18, "Converted to some other use (roll on General Dungeon Chambers table)")
					.addEntry(19, "Stripped bare")
					.addEntry(20, "Pristine and in original state")
					.build();
	
	private static final RandomTreasure.Tier DEFAULT_TIER = RandomTreasure.Tier.UNDEFINED;
	private static final RollableTable<Supplier<Encounter>> TABLE_DUNGEON_CHAMBER_CONTENTS =
			new RollableTableBuilder<Supplier<Encounter>>(Dice.d100)
					.addEntry(1, 8, () -> new Encounter.Builder().addRandomMonster().build())
					.addEntry(9, 15, () -> new Encounter.Builder().addRandomMonster().setupRandomTreasure(DEFAULT_TIER).build())
					.addEntry(16, 27, () -> new Encounter.Builder().addRandomMonster().build())
					.addEntry(28, 33, () -> new Encounter.Builder().addRandomMonster().setupRandomTreasure(DEFAULT_TIER).build())
					.addEntry(34, 42, () -> new Encounter.Builder().addRandomMonster().build())
					.addEntry(43, 50, () -> new Encounter.Builder().addRandomMonster().setupRandomTreasure(DEFAULT_TIER).build())
					.addEntry(51, 58, () -> new Encounter.Builder().addRandomHazard().setupRandomTreasure(DEFAULT_TIER).build())
					.addEntry(59, 63, () -> new Encounter.Builder().addRandomObstacle().build())
					.addEntry(64, 73, () -> new Encounter.Builder().addRandomTrap().build())
					.addEntry(74, 76, () -> new Encounter.Builder().addRandomTrap().setupRandomTreasure(DEFAULT_TIER).build())
					.addEntry(77, 80, () -> new Encounter.Builder().addRandomTrick().build())
					.addEntry(81, 88, () -> new Encounter.Builder().build())
					.addEntry(89, 94, () -> new Encounter.Builder().addRandomHazard().build())
					.addEntry(95, 100, () -> new Encounter.Builder().setupRandomTreasure(DEFAULT_TIER).build())
					.build();
	
	private Chamber chamberFeatures;
	private Exit[] chamberExits; // TODO Definir não somente as saidas, mas também suas localizações
	private String chamberPurpose;
	private String chamberState;
	private Encounter chamberContents;
	
	public RandomChamber() {
		refresh();
	}
	
	public void refresh() {
		this.chamberFeatures = TABLE_CHAMBER.roll();
		
		int numberOfExits = this.chamberFeatures.getSize().getNumberOfExits(TABLE_NUMBER_OF_EXITS.roll());
		this.chamberExits = new Exit[numberOfExits];
		for (int i = 0; i < numberOfExits; i++) {
			ExitLocation exitLocation = TABLE_EXIT_LOCATION.roll();
			Supplier<Location> beyondExit = TABLE_EXIT_TYPE.roll();
			this.chamberExits[i] = new Exit(beyondExit, exitLocation);
		}
		
		this.chamberPurpose = TABLE_GENERAL_CHAMBER_PURPOSE.roll();
		
		this.chamberState = TABLE_CURRENT_CHAMBER_STATE.roll();
		this.chamberContents = TABLE_DUNGEON_CHAMBER_CONTENTS.roll().get();
	}
	
	@Override
	public Exit[] getExits() {
		return this.chamberExits;
	}
	
	public Chamber getChamberFeatures() {
		return chamberFeatures;
	}

	public String getChamberPurpose() {
		return chamberPurpose;
	}

	public String getChamberState() {
		return chamberState;
	}

	public Encounter getChamberContents() {
		return chamberContents;
	}
	
	public void setChamberContents(Encounter chamberContents) {
		this.chamberContents = chamberContents;
	}

	public void setChamberFeatures(Chamber chamberFeatures) {
		this.chamberFeatures = chamberFeatures;
	}

	public void setChamberPurpose(String chamberPurpose) {
		this.chamberPurpose = chamberPurpose;
	}

	public void setChamberState(String chamberState) {
		this.chamberState = chamberState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append(this.getChamberFeatures().getLength())
				.append("x")
				.append(this.getChamberFeatures().getWidth())
				.append(" feets wide ")
				.append(this.getChamberFeatures().getShape().toString().toLowerCase())
				.append(" ")
				.append(this.getChamberPurpose().toLowerCase())
				.append(", currently on/with ")
				.append(this.getChamberState().toLowerCase());
		
		Exit[] exits = this.getExits();
		
		if (exits.length == 0) {
			builder.append(", without exits.");
		} else {
			builder.append(", with ")
					.append(exits.length)
					.append(" exits.");
		}
		
		return builder.toString();
	}

}
