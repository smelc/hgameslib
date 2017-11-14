package com.hgames.lib.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Utility method concerning {@link Set}.
 * 
 * @author smelC
 */
public class Sets {

	/**
	 * @return A fresh set.
	 */
	public static <T> HashSet<T> newHashSet() {
		return new HashSet<T>();
	}

	/**
	 * @param iterator
	 * @param size
	 *            {@code iterator}'s size if known, otherwise anything negative.
	 * @return A copy of {@code iterator}.
	 */
	public static <T> HashSet<T> newHashSet(Iterator<T> iterator, int size) {
		final HashSet<T> result = size < 0 ? new HashSet<T>() : new HashSet<T>(size);
		while (iterator.hasNext())
			result.add(iterator.next());
		return result;
	}

	/**
	 * @param iterator
	 * @param size
	 *            {@code iterator}'s size if known, otherwise anything negative.
	 * @return A copy of {@code iterator}.
	 */
	public static <T> LinkedHashSet<T> newLinkedHashSet(Iterator<T> iterator, int size) {
		final LinkedHashSet<T> result = size < 0 ? new LinkedHashSet<T>() : new LinkedHashSet<T>(size);
		while (iterator.hasNext())
			result.add(iterator.next());
		return result;
	}

}
