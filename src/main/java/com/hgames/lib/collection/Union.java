package com.hgames.lib.collection;

import java.util.Collection;

/**
 * An interface representing an union of {@link Collection}s. Useful to to avoid
 * aggregating collections of collections into a single giant collection, which
 * is a waste of memory when you're only going to iterate over the collections.
 * 
 * @author smelC
 * @param <T>
 *            The type of elements.
 */
public interface Union<T> extends Iterable<T> {

	/**
	 * @return The sum of the sizes of underlying collections.
	 */
	public int size();

	/**
	 * @return The number of underlying collections.j
	 */
	public int unionSize();

	/**
	 * @param t
	 * @return Whether one of the underlying collection
	 *         {@link Collection#contains contains} {@code t}.
	 */
	public boolean contains(T t);

}
