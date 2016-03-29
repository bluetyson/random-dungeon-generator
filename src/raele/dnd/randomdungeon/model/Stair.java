package raele.dnd.randomdungeon.model;

import java.util.function.Supplier;

public class Stair {
	
	private int[] levelChangeOptions;
	private Supplier<Location> exit;
	private boolean hasSteps;
	
	public Stair(int[] levelChangeOptions, Supplier<Location> exit, boolean hasSteps) {
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
	public Supplier<Location> getExit() {
		return exit;
	}
	public void setExit(Supplier<Location> exit) {
		this.exit = exit;
	}
	public boolean isHasSteps() {
		return hasSteps;
	}
	public void setHasSteps(boolean hasSteps) {
		this.hasSteps = hasSteps;
	}

}
