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

}
