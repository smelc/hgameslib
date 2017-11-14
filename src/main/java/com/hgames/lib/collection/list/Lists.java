package com.hgames.lib.collection.list;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

import com.hgames.lib.GwtIncompatible;

/**
 * Utility methods about {@link List}.
 * 
 * @author smelC
 */
public class Lists {

	/**
	 * @param l
	 * @param elem
	 * @return {@code true} if {@code l} is empty or all its elements are equal to
	 *         {@code elem}all its elements are equal to {@code elem}..
	 */
	public static <T> boolean containsOnly(List<T> l, T elem) {
		final int sz = l.size();
		if (l instanceof LinkedList && 4 < sz) {
			final Iterator<T> it = l.iterator();
			while (it.hasNext()) {
				if (it.next() != elem)
					return false;
			}
		} else {
			for (int i = 0; i < sz; i++) {
				if (l.get(i) != elem)
					return false;
			}
		}
		return true;
	}

	/**
	 * Adds {@code t} {@code n} times into {@code list}.
	 * 
	 * @param list
	 *            The list to extend
	 * @param t
	 *            The element to add
	 * @param n
	 *            How many times to add {@code n}.
	 */
	public static <T> void multiAdd(List<T> list, T t, int n) {
		for (int i = 0; i < n; i++)
			list.add(t);
	}

	/**
	 * @return A fresh {@link ArrayList}.
	 */
	public static <T> ArrayList<T> newArrayList() {
		return new ArrayList<T>();
	}

	/**
	 * @param expectedSize
	 * @return A fresh {@link ArrayList}.
	 */
	public static <T> ArrayList<T> newArrayListWithExpectedSize(int expectedSize) {
		return new ArrayList<T>(expectedSize);
	}

	/**
	 * @param elems
	 * @return An {@link ArrayList} containing {@code elems}
	 */
	public static <T> ArrayList<T> newArrayList(Collection<? extends T> elems) {
		return new ArrayList<T>(elems);
	}

	/**
	 * @param it
	 * @return An {@link ArrayList} containing {@code it}'s elements.
	 */
	public static <T> ArrayList<T> newArrayList(Iterator<? extends T> it) {
		return Lists.newArrayList(it, -1);
	}

	/**
	 * @param it
	 * @param sz
	 *            The size with which to allocate the result, or anything negative
	 *            if unknown.
	 * @return An {@link ArrayList} containing {@code it}'s elements.
	 */
	public static <T> ArrayList<T> newArrayList(Iterator<? extends T> it, int sz) {
		final ArrayList<T> result = sz < 0 ? new ArrayList<T>() : new ArrayList<T>(sz);
		while (it.hasNext())
			result.add(it.next());
		return result;
	}

	/**
	 * @param t1
	 * @param t2
	 * @return The list [t1, t2].
	 */
	public static <T> ArrayList<T> newArrayList(T t1, T t2) {
		final ArrayList<T> result = new ArrayList<T>(2);
		result.add(t1);
		result.add(t2);
		return result;
	}

	/**
	 * @param t
	 * @return An {@link ArrayList} containing solely {@code t}.
	 */
	public static <T> ArrayList<T> newSingletonArrayList(/* @Nullable */T t) {
		final ArrayList<T> result = new ArrayList<T>(1);
		result.add(t);
		return result;
	}

	/**
	 * @param elem
	 * @param size
	 * @return The list {@code [elem, ... elem]} of size {@code size}.
	 */
	public static <E> ArrayList<E> newUniformArrayList(E elem, int size) {
		final ArrayList<E> result = new ArrayList<E>(size);
		for (int i = 0; i < size; i++)
			result.add(elem);
		return result;
	}

	/**
	 * @param list
	 * @return An {@link Iterator} that cycles indefinitely over {@code list}. Do
	 *         not loop on it!
	 */
	public static <T> Iterator<T> newCyclingIterator(final List<? extends T> list) {
		return new Iterator<T>() {

			int cur = 0;

			@Override
			public boolean hasNext() {
				return !list.isEmpty();
			}

			@Override
			public T next() {
				if (list.isEmpty())
					throw new NoSuchElementException();
				final T result = list.get(cur);
				cur++;
				if (cur == list.size())
					/* Reset */
					cur = 0;
				return result;
			}

			@Override
			public void remove() {
				list.remove(cur);
			}
		};
	}

	/**
	 * @param list
	 * @return true if {@code list} doesn't contain null.
	 */
	public static boolean noNull(List<?> list) {
		if (list == null)
			return true;
		final int sz = list.size();
		for (int i = 0; i < sz; i++) {
			if (list.get(i) == null)
				return false;
		}
		return true;
	}

	/**
	 * <b>Destroys {@code q}.</b>
	 * 
	 * @param q
	 * @return A copy of {@code q}.
	 */
	public static <T> ArrayList<T> toArrayList(Queue<T> q) {
		final ArrayList<T> result = new ArrayList<T>(q.size());
		while (!q.isEmpty())
			result.add(q.remove());
		return result;
	}

	/**
	 * @param q
	 * @return A copy of {@code q}.
	 */
	public static <T> ArrayList<T> toArrayList(T[] q) {
		final ArrayList<T> result = new ArrayList<T>(q.length);
		for (int i = 0; i < q.length; i++)
			result.add(q[i]);
		return result;
	}

	/**
	 * @param l
	 * @return A copy of {@code l}.
	 */
	public static int[] toArray(List<Integer> l) {
		final int[] result = new int[l.size()];
		int j = 0;
		for (int i : l)
			result[j++] = i;
		return result;
	}

	/**
	 * @param l
	 * @param toRemove
	 *            The indexes to remove in {@code l}.
	 * @return The number of elements removed.
	 */
	@GwtIncompatible // Replug main at the end when this annotation is removed
	public static int remove(List<?> l, /* @Nullable */ BitSet toRemove) {
		if (toRemove == null)
			return 0;
		int result = 0;
		for (int i = toRemove.nextSetBit(0); i >= 0; i = toRemove.nextSetBit(i + 1)) {
			l.remove(i - result);
			result++;
		}
		return result;
	}

	/**
	 * @param l
	 * @param toRemove
	 *            The indexes to remove in {@code l}.
	 * @return The number of elements removed.
	 */
	public static int removeByIndexes(List<?> l, /* @Nullable */ BitSet toRemove) {
		if (toRemove == null)
			return 0;
		int result = 0;
		for (int i = toRemove.nextSetBit(0); i >= 0; i = toRemove.nextSetBit(i + 1)) {
			l.remove(i - result);
			result++;
		}
		return result;
	}

	/**
	 * @param l
	 * @param toRemove
	 *            The indexes to remove in {@code l}.
	 * @return The number of elements removed.
	 */
	public static int removeByIndexes(List<?> l, /* @Nullable */ Collection<Integer> toRemove) {
		if (toRemove == null)
			return 0;
		int result = 0;
		for (Integer i : toRemove) {
			l.remove(i - result);
			result++;
		}
		return result;
	}
}
