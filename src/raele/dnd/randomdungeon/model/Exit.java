package raele.dnd.randomdungeon.model;

import java.util.function.Supplier;

public class Exit {
	
	private Supplier<Location> beyond;
	private Object position;
	
	public Exit(Supplier<Location> beyond, Object position) {
		super();
		this.beyond = beyond;
		this.position = position;
	}
	
	public Location getBeyond() {
		if (this.beyond != null && !ReuseSupplier.class.equals(this.beyond.getClass())) {
			this.beyond = new ReuseSupplier<Location>(this.beyond.get());
		}
		return this.beyond.get();
	}

	public void setBeyond(Supplier<Location> beyond) {
		this.beyond = beyond;
	}

	public Object getPosition() {
		return position;
	}

	public void setPosition(Object position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Exit at " + this.position.toString().replace("_", " ").toLowerCase();
	}

}
