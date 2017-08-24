package com.hgames.lib.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Utility methods about {@link Iterator}s.
 * 
 * @author smelC
 */
public class Iterators {

	/**
	 * @param it
	 * @return The number of elements in {@code it}.
	 */
	public static int size(Iterator<?> it) {
		int result = 0;
		while (it.hasNext()) {
			it.next();
			result++;
		}
		return result;
	}

	/**
	 * @param it
	 * @param expectedSize
	 *            The expected size of the result or something negative if
	 *            unknown.
	 * @return {@code it}'s elements as an {@link ArrayList}.
	 */
	public static <T> ArrayList<T> toList(Iterator<T> it, int expectedSize) {
		final ArrayList<T> result = expectedSize < 0 ? new ArrayList<T>() : new ArrayList<T>(expectedSize);
		while (it.hasNext())
			result.add(it.next());
		return result;
	}

	/**
	 * @param it
	 * @param expectedSize
	 *            The expected size of the result or something negative if
	 *            unknown.
	 * @return {@code it}'s elements as a {@link Set}.
	 */
	public static <T> HashSet<T> toSet(Iterator<T> it, int expectedSize) {
		final HashSet<T> result = expectedSize < 0 ? new HashSet<T>() : new HashSet<T>(expectedSize);
		while (it.hasNext())
			result.add(it.next());
		return result;
	}
}
