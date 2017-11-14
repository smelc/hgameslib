package com.hgames.lib.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Utility methods about {@link Iterable}.
 * 
 * @author smelC
 */
public class Iterables {

	/**
	 * @param src
	 * @return {@code src} flattened.
	 */
	public static <T> Iterable<T> flatten(final Iterable<? extends Iterable<? extends T>> src) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {

					private final Iterator<? extends Iterable<? extends T>> delegate = src.iterator();
					private Iterator<? extends T> current;

					@Override
					public boolean hasNext() {
						while (current == null || !current.hasNext()) {
							if (!delegate.hasNext())
								return false;
							current = delegate.next().iterator();
						}
						return true;
					}

					@Override
					public T next() {
						if (hasNext())
							return current.next();
						else
							throw new NoSuchElementException();
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}

	/**
	 * @param it
	 * @return An iterable backed up by {@code it}.
	 */
	public static <T> Iterable<T> ofIterator(final Iterator<T> it) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return it;
			}
		};
	}
}
