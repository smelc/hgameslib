package com.hgames.lib.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility methods pertaning to {@link Collection}.
 * 
 * @author smelC
 */
public class Collections {

	/**
	 * Clears {@code collection} if not null.
	 * 
	 * @param collection
	 *            A possible null collection.
	 */
	public static void clear(/* @Nullable */ Collection<?> collection) {
		if (collection != null)
			collection.clear();
	}

	/**
	 * @param collection
	 *            A possibly null collection.
	 * @param element
	 * @return Whether {@code collection} contains {@code element}.
	 */
	public static <T> boolean contains(Collection<T> collection, T element) {
		return collection != null && collection.contains(element);
	}

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
	public static <T> boolean equivalent(/* @Nullable */ Collection<T> c1, /* @Nullable */ Collection<T> c2) {
		if (c1 == null)
			return c2 == null || c2.isEmpty();
		if (c2 == null)
			return c1 == null || c1.isEmpty();
		return c1.size() == c2.size() && c1.containsAll(c2) && c2.containsAll(c1);
	}

	/**
	 * @param c
	 * @return {@code true} if {@code c} doesn't contain doublons.
	 */
	public static boolean isSet(Collection<?> c) {
		final Set<Object> set = new HashSet<Object>(c.size());
		for (Object o : c) {
			if (!set.add(o))
				return false;
		}
		return true;
	}

	/**
	 * @param collection
	 *            A possibly null collection.
	 * @param element
	 * @return Whether {@code collection} was modified.
	 */
	public static <T> boolean remove(Collection<T> collection, T element) {
		return collection != null && collection.remove(element);
	}

	/**
	 * @param collection
	 *            A possibly null collection.
	 * @return {@code collection}'s size
	 */
	public static int size(Collection<?> collection) {
		return collection == null ? 0 : collection.size();
	}

	/**
	 * @param small
	 * @param big
	 * @return Whether small is included in {@code big}.
	 */
	public static <T> boolean subset(/* @Nullable */ Collection<T> small, Collection<T> big) {
		return small == null || big.containsAll(small);
	}
}
