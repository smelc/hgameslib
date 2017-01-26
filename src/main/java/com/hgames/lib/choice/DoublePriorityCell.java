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
 * 
 * @see PriorityCell
 */
public class DoublePriorityCell<T> extends AbstractPriorityCell<T> {

	/**
	 * The priority of {@link #object} if the latter is non-null. Irrelevant
	 * otherwise.
	 */
	protected double priority;

	/**
	 * @param object
	 *            The contained object.
	 * @param priority
	 *            {@code object}'s priority. Must be >= 0.
	 */
	public DoublePriorityCell(/* @Nullable */ T object, double priority) {
		super(object);
		checkPriority(priority);
		this.priority = priority;
	}

	public static <T> DoublePriorityCell<T> createEmpty() {
		return new DoublePriorityCell<T>(null, 0);
	}

	/**
	 * Sets {@code t} in {@code this} if {@code this} is uninitialized or if
	 * {@code p} is stricly smaller than the current object's priority.
	 * 
	 * @param t
	 * @param p
	 */
	public void union(T t, double p) {
		checkPriority(p);

		if (object == null || p < priority) {
			object = t;
			priority = p;
		}
	}

	/**
	 * @return The priority of {@link #get()}}.
	 */
	public double getPriority() {
		return priority;
	}

	protected final void checkPriority(double p) {
		if (p < 0)
			throw new IllegalStateException("Priority must be >= 0 but received " + p);
	}

}
