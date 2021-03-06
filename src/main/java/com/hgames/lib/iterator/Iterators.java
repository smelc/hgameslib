package com.hgames.lib.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import com.hgames.lib.Predicate;

/**
 * Utility methods about {@link Iterator}s.
 * 
 * @author smelC
 */
public class Iterators {

	/**
	 * @param it
	 *            An iterator that shouldn't return null.
	 * @param filter
	 * @return {@code it} filtered by {@code filter}.
	 */
	public static <T> Iterator<T> filter(final Iterator<T> it, final Predicate<T> filter) {
		return new Iterator<T>() {

			private T next;

			@Override
			public boolean hasNext() {
				while (it.hasNext()) {
					next = it.next();
					if (filter.apply(next))
						return true;
				}
				return false;
			}

			@Override
			public T next() {
				if (next == null) {
					while (it.hasNext()) {
						next = it.next();
						if (filter.apply(next)) {
							next = null;
							return next;
						}
					}
					throw new NoSuchElementException();
				} else {
					final T result = next;
					next = null;
					return result;
				}
			}

			@Override
			public void remove() {
				it.remove();
			}
		};
	}

	/**
	 * @param array
	 * @return An iterator over {@code array}.
	 */
	public static <T> Iterator<T> of(final T[] array) {
		return new Iterator<T>() {

			int next = 0;

			@Override
			public boolean hasNext() {
				return next < array.length;
			}

			@Override
			public T next() {
				if (hasNext()) {
					final T result = array[next];
					next++;
					return result;
				} else
					throw new NoSuchElementException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * Adds at most {@code nb} elements from {@code it} into {@code acc}.
	 * 
	 * @param it
	 *            The iterator to consume
	 * @param acc
	 *            Where to add
	 * @param nb
	 *            The maximum number of elements to add
	 * @return The number of elements poured. Less or equal than {@code nb}.
	 */
	public static <T> int pourInto(Iterator<T> it, Collection<T> acc, int nb) {
		int result = 0;
		while (it.hasNext() && result < nb) {
			acc.add(it.next());
			result++;
		}
		return result;
	}

	/**
	 * @param it
	 * @return The number of elements in {@code it}.
	 */
	public static int size(Iterator<?> it) {
		int result = 0;
		while (it.hasNext()) {
			it.next();
			result++;
		}
		return result;
	}

	/**
	 * @param it
	 * @param expectedSize
	 *            The expected size of the result or something negative if unknown.
	 * @return {@code it}'s elements as an {@link ArrayList}.
	 */
	public static <T> ArrayList<T> toList(Iterator<T> it, int expectedSize) {
		final ArrayList<T> result = expectedSize < 0 ? new ArrayList<T>() : new ArrayList<T>(expectedSize);
		while (it.hasNext())
			result.add(it.next());
		return result;
	}

	/**
	 * @param it
	 * @param expectedSize
	 *            The expected size of the result or something negative if unknown.
	 * @return {@code it}'s elements as a {@link Set}.
	 */
	public static <T> HashSet<T> toSet(Iterator<T> it, int expectedSize) {
		final HashSet<T> result = expectedSize < 0 ? new HashSet<T>() : new HashSet<T>(expectedSize);
		while (it.hasNext())
			result.add(it.next());
		return result;
	}
}
