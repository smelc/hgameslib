package com.hgames.lib.choice;

/**
 * A cell to store a triple with the associated priority, when iterating over
 * such objects; but only one of these triples will ultimately be kept. It is a
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
 *            The type of the first element
 * @param <U>
 *            The type of the second element
 * @param <V>
 *            The type of the third element
 * @see PriorityCell
 */
public final class PriorityCell3<T, U, V> extends AbstractPriorityCell3<T, U, V> {

	/** The priority of {@link #o1}, {@link #o2}, and {@link #o3}. */
	protected int priority;

	/**
	 * @return A fresh empty cell.
	 */
	public static <T, U, V> PriorityCell3<T, U, V> createEmpty() {
		return new PriorityCell3<T, U, V>();
	}

	/**
	 * Sets {@code t} in {@code this} if {@code this} is uninitialized or if
	 * {@code p} is stricly smaller than the current object's priority.
	 * 
	 * @param t
	 *            The triple's first object.
	 * @param u
	 *            The triple's second object.
	 * @param v
	 *            The triple's third object.
	 * @param p
	 */
	public void union(T t, U u, V v, int p) {
		checkPriority(p);

		if ((o1 == null && o2 == null && o3 == null) || p < priority) {
			o1 = t;
			o2 = u;
			o3 = v;
			priority = p;
		}
	}

	/** @return The current priority. */
	public int getPriority() {
		return priority;
	}

	protected final void checkPriority(int p) {
		if (p < 0)
			throw new IllegalStateException("Priority must be >= 0 but received " + p);
	}

}
