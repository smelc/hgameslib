package com.hgames.lib.choice;

/**
 * A common super type for priority cells. The usual coding pattern:
 * 
 * <code>
 * PriorityCell&lt;T&gt; cell = PriorityCell.createEmpty();
 * while (iterator.hasNext()) {
 * 	final T next = iterator.next();
 * 	cell.union(next, priorityOf(next));
 * }
 * final T best = cell.get();
 * </code>
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
