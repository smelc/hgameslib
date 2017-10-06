package com.hgames.lib.choice;

/**
 * A common super type for priority cells containing 3 objects at once, to spare
 * allocations.
 * 
 * @author smelC
 * 
 * @param <T>
 *            The type of the first element
 * @param <U>
 *            The type of the second element
 * @param <V>
 *            The type of the third element
 * 
 * @see AbstractPriorityCell
 */
public abstract class AbstractPriorityCell3<T, U, V> {

	protected T o1;
	protected U o2;
	protected V o3;

	/**
	 * @return The current triple's first object, or null if none.
	 */
	public /* @Nullable */ T get1() {
		return o1;
	}

	/**
	 * @return The current triple's second object, or null if none.
	 */
	public /* @Nullable */ U get2() {
		return o2;
	}

	/**
	 * @return The current triple's third object, or null if none.
	 */
	public /* @Nullable */ V get3() {
		return o3;
	}

	/** Resets this cell. */
	public void clear() {
		o1 = null;
		o2 = null;
		o3 = null;
	}

}
