package raele.dnd.randomdungeon;

public class DoorType {
	
	public enum Type {
		WOODEN,
		STONE,
		IRON,
		PORTCULLIS,
		SECRET,
	}
	
	private final Type type;
	private final boolean locked;
	
	public DoorType(Type type, boolean locked) {
		super();
		this.type = type;
		this.locked = locked;
	}
	
	public Type getType() {
		return type;
	}
	public boolean isLocked() {
		return locked;
	}
	
}
