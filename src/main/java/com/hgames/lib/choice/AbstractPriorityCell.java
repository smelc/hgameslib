package com.hgames.lib.choice;

/**
 * A common super type for priority cells.
 * 
 * @author smelC
 * 
 * @param <T>
 *            The type of elements
 */
public abstract class AbstractPriorityCell<T> {

	protected T object;

	protected AbstractPriorityCell(/* @Nullable */ T object) {
		this.object = object;
	}

	/**
	 * @return The current object, or null if none.
	 */
	public /* @Nullable */ T get() {
		return object;
	}

	/**
	 * Resets this cell, i.e. sets {@link #object} to {@code null}.
	 */
	public void clear() {
		object = null;
	}

}
