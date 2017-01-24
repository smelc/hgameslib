package com.hgames.lib.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Utility methods about {@link List}.
 * 
 * @author smelC
 */
public class Lists {

	// FIXME CH Add 'useEgalEgal' parameter
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
	 * @param t
	 * @return An {@link ArrayList} containing solely {@code t}.
	 */
	public static <T> ArrayList<T> newSingletonArrayList(/* @Nullable */T t) {
		final ArrayList<T> result = new ArrayList<T>(1);
		result.add(t);
		return result;
	}

	public static <T> ArrayList<T> newArrayList(Iterator<? extends T> it) {
		final ArrayList<T> result = new ArrayList<T>();
		while (it.hasNext())
			result.add(it.next());
		return result;
	}

	/**
	 * @param list
	 * @return An {@link Iterator} that cycles indefinitely over {@code list}.
	 *         Do not loop on it!
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

	public static <T> ArrayList<T> toArrayList(Queue<T> q) {
		final ArrayList<T> result = new ArrayList<T>(q.size());
		while (!q.isEmpty())
			result.add(q.remove());
		return result;
	}

	public static <T> ArrayList<T> toArrayList(T[] q) {
		final ArrayList<T> result = new ArrayList<T>(q.length);
		for (int i = 0; i < q.length; i++)
			result.add(q[i]);
		return result;
	}

	public static int[] toArray(List<Integer> l) {
		final int[] result = new int[l.size()];
		int j = 0;
		for (int i : l)
			result[j++] = i;
		return result;
	}

	public static <E> ArrayList<E> uniformArrayList(E elem, int size) {
		final ArrayList<E> result = new ArrayList<E>(size);
		for (int i = 0; i < size; i++)
			result.add(elem);
		return result;
	}

}
