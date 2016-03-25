package raele.dnd.randomdungeon;

public class Stair extends Location {
	
	private int[] levelChangeOptions;
	private Location exit;
	private boolean hasSteps;
	
	public Stair(int[] levelChangeOptions, Location exit, boolean hasSteps) {
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
	public Location getExit() {
		return exit;
	}
	public void setExit(Location exit) {
		this.exit = exit;
	}
	public boolean isHasSteps() {
		return hasSteps;
	}
	public void setHasSteps(boolean hasSteps) {
		this.hasSteps = hasSteps;
	}

}
