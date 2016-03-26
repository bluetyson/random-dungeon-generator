package raele.dnd.randomdungeon;

public class Stair extends Location {
	
	private int[] levelChangeOptions;
	private LocationCreator exit;
	private boolean hasSteps;
	
	public Stair(int[] levelChangeOptions, LocationCreator exit, boolean hasSteps) {
		super();
		this.levelChangeOptions = levelChangeOptions;
		this.exit = exit;
		this.hasSteps = hasSteps;
	}
	
	public int[] getLevelChangeOptions() {
		return levelChangeOptions;
	}
	public void setLevelChangeOptions(int[] levelChangeOptions) {
		this.levelChangeOptions = levelChangeOptions;
	}
	public LocationCreator getExit() {
		return exit;
	}
	public void setExit(LocationCreator exit) {
		this.exit = exit;
	}
	public boolean isHasSteps() {
		return hasSteps;
	}
	public void setHasSteps(boolean hasSteps) {
		this.hasSteps = hasSteps;
	}

}
