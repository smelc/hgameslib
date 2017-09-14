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

	/**
	 * @return A fresh empty cell.
	 */
	public static <T> DoublePriorityCell<T> createEmpty() {
		return new DoublePriorityCell<T>(null, 0);
	}

	/**
	 * @return A fresh empty cell whose priority is inverted, i.e. the best cell
	 *         will be the one whose priority is the biggest one.
	 */
	public static <T> DoublePriorityCell<T> createEmptyInverted() {
		return new DoublePriorityCell<T>(null, 0) {
			@Override
			protected boolean better(double p1, double p2) {
				return p2 < p1;
			}
		};
	}

	/**
	 * Sets {@code t} in {@code this} if {@code this} is uninitialized or if
	 * {@code p} is stricly smaller than the current object's priority.
	 * 
	 * @param t
	 * @param p
	 */
	public void union(T t, double p) {
		if (object == null || better(p, priority)) {
			object = t;
			priority = p;
		}
	}

	/**
	 * @param p1
	 * @param p2
	 * @return true if p1 is better than p2, which is usually implemented by
	 *         less than.
	 */
	protected boolean better(double p1, double p2) {
		return p1 < p2;
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
