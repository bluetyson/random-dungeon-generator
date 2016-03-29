package raele.dnd.randomdungeon.model;

import java.util.function.Supplier;

public class ReuseSupplier<T> implements Supplier<T> {
	
	private T t;
	
	public ReuseSupplier(T t) {
		this.t = t;
	}
	
	@Override
	public T get() {
		return this.t;
	}

}
