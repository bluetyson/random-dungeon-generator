package raele.dnd.randomdungeon;

public class Chamber {

	public enum Shape {
		SQUARE("Square, %d x %d ft."),
		RECTANGLE("Rectangule, %d x %d ft."),
		CIRCLE("Circle, %d ft. diameter"),
		OCTAGON("Octagon, %d x %d ft."),
		TRAPEZOID("Trapezoid, roughly %d x %d ft."),
		;
		private final String readableString;
		private Shape(String str) {
			this.readableString = str;
		}
		public String getReadableString() {
			return readableString;
		}
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
		return "Chamber (" + String.format(this.shape.readableString, this.length, this.width) + ", " + this.size + ")";
	}
	
}