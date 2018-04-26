package com.hgames.lib.choice;

/**
 * A cell to store some object with its associated priority, when iterating over
 * such objects; but only one object will ultimately be kept. It is a
 * degenerated priority queue.
 * 
 * <p>
 * Recall that a smaller priority corresponds to a "better" element. Priorities
 * must be greater or equal to 0.
 * </p>
 * 
 * @author smelC
 * 
 * @param <T>
 *            The type of elements
 */
public final class PriorityCell<T> extends AbstractPriorityCell<T> {

	/**
	 * The priority of {@link #object} if the latter is non-null. Irrelevant
	 * otherwise.
	 */
	protected int priority;

	/**
	 * @param object
	 *            The contained object.
	 * @param priority
	 *            {@code object}'s priority. Must be {@code >= 0}.
	 */
	public PriorityCell(/* @Nullable */ T object, int priority) {
		super(object);
		checkPriority(priority);
		this.priority = priority;
	}

	/**
	 * @return A fresh empty cell.
	 */
	public static <T> PriorityCell<T> createEmpty() {
		return new PriorityCell<T>(null, 0);
	}

	/**
	 * Sets {@code t} in {@code this} if {@code this} is uninitialized or if
	 * {@code p} is stricly smaller than the current object's priority.
	 * 
	 * @param t
	 * @param p
	 */
	public void union(T t, int p) {
		checkPriority(p);

		if (object == null || p < priority) {
			object = t;
			priority = p;
		}
	}

	/**
	 * @return The priority of {@link #get()}}.
	 */
	public int getPriority() {
		return priority;
	}

	protected final void checkPriority(int p) {
		if (p < 0)
			throw new IllegalStateException("Priority must be >= 0 but received " + p);
	}

}
