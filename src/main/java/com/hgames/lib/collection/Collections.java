package com.hgames.lib.collection;

import java.util.Collection;

/**
 * Utility methods pertaning to {@link Collection}.
 * 
 * @author smelC
 */
public class Collections {

	/**
	 * @param collection
	 * @param searched
	 * @return true if {@code collection} contains a member of {@code searched}.
	 */
	public static <T> boolean containsAny(Collection<T> collection, Collection<T> searched) {
		for (T t : searched) {
			if (collection.contains(t))
				return true;
		}
		return false;
	}

	/**
	 * @param c1
	 * @param c2
	 * @return true if {@code c1} and {@code c2} are equivalent according to
	 *         {@link Collection#containsAll(Collection)}.
	 */
	public static <T> boolean equivalent(Collection<T> c1, Collection<T> c2) {
		return c1.containsAll(c2) && c2.containsAll(c1);
	}

}
