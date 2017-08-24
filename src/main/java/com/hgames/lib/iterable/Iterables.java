package com.hgames.lib.iterable;

import java.util.Iterator;

/**
 * Utility methods about {@link Iterable}.
 * 
 * @author smelC
 */
public class Iterables {

	/**
	 * @param it
	 * @return An iterable backed up by {@code it}.
	 */
	public static <T> Iterable<T> ofIterator(final Iterator<T> it) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return it;
			}
		};
	}

}
