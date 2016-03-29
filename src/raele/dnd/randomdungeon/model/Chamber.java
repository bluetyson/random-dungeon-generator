package raele.dnd.randomdungeon.model;

public class Chamber {

	public enum Shape {
		SQUARE,
		RECTANGLE,
		CIRCLE,
		OCTAGON,
		TRAPEZOID,
	}
	
	public enum Size{
		NORMAL(new NumberOfExitsHandler() {
			@Override
			public int getNumberOfExits(NumberOfExits exits) {
				return exits.getWhenNormal();
			}}),
		LARGE(new NumberOfExitsHandler() {
			@Override
			public int getNumberOfExits(NumberOfExits exits) {
				return exits.getWhenLarge();
			}}),
		;
		private interface NumberOfExitsHandler {
			int getNumberOfExits(NumberOfExits exits);
		}
		
		private NumberOfExitsHandler handler;
		
		private Size(NumberOfExitsHandler handler) {
			this.handler = handler;
		}
		
		int getNumberOfExits(NumberOfExits exits) {
			return handler.getNumberOfExits(exits);
		}
	}
	
	private int length;
	private int width;
	private Shape shape;
	private Size size;
	
	public Chamber(int length, int width, Shape shape, Size size) {
		super();
		this.length = length;
		this.width = width;
		this.shape = shape;
		this.size = size;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Chamber (" + this.shape + ", " + this.length + " x " + this.width + "ft., " + this.size + ")";
	}
	
}