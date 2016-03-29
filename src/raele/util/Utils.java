package raele.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Utils {
	
	private Utils() {}
	
	public static String capitalize(final String line) {
	   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
	
	/**
	 * Divide all items (toStrings) by commas, using the "andExpression" as
	 * divider for the last item, or another comma if null.
	 * Example:
	 * The following code
	 * <code>formatReadableList(new String[] {"apple", "banana", "melon", "strawberry"}, "and")</code>
	 * would produce the following string
	 * <code>apple, banana, melon and strawberry</code>
	 */
	public static String formatReadableList(Object[] items, String andExpression) {
		return formatReadableList(Arrays.asList(items), andExpression);
	}
	
	public static String formatReadableList(Collection<Object> items, String andExpression) {
		StringBuilder builder = new StringBuilder();
		int size = items.size();
		
		if (size > 0) {
			Iterator<Object> iter = items.iterator();
			String firstItem = iter.next().toString();
			builder.append(firstItem);
			
			for (int i = 2; i < size; i++) {
				String item = iter.next().toString();
				builder.append(", ").append(item);
			}
			
			if (size > 1) {
				String lastItem = iter.next().toString();
				builder.append(" ").append(andExpression).append(" ").append(lastItem);
			}
		}
		
		return builder.toString();
	}

}
