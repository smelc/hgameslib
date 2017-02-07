package com.hgames.lib.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementations of {@link Union}.
 * 
 * @author smelC
 */
public class Unions {

	private static final Union<Object> EMPTY_UNION = new Union<Object>() {
		@Override
		public Iterator<Object> iterator() {
			return Collections.emptyList().iterator();
		}

		@Override
		public int size() {
			return 0;
		}

		@Override
		public int unionSize() {
			return 0;
		}

		@Override
		public boolean contains(Object t) {
			return false;
		}
	};

	/**
	 * @return An empty union of {@code T}s.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Union<T> getEmpty() {
		return (Union<T>) EMPTY_UNION;
	}

	/**
	 * @param collection
	 * @return A <b>view</b> of {@code collection} as an {@link Union}.
	 */
	public static <T> Union<T> ofOne(final Collection<T> collection) {
		return new Union<T>() {
			@Override
			public Iterator<T> iterator() {
				return collection.iterator();
			}

			@Override
			public int size() {
				return collection.size();
			}

			@Override
			public int unionSize() {
				return 1;
			}

			@Override
			public boolean contains(T t) {
				return collection.contains(t);
			}
		};
	}

	/**
	 * @param collections
	 * @return The union of {@code collections}.
	 */
	public static <T> Union<T> ofMany(final Collection<? extends Collection<T>> collections) {
		if (collections.size() == 1)
			return ofOne(collections.iterator().next());

		return new Union<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {

					private final Iterator<? extends Collection<T>> oit = collections.iterator();
					private Iterator<T> current = null;

					@Override
					public boolean hasNext() {
						while (true) {
							if (current != null && current.hasNext())
								return true;
							if (oit.hasNext())
								current = oit.next().iterator();
							else
								return false;
						}
					}

					@Override
					public T next() {
						while (true) {
							if (current != null && current.hasNext())
								return current.next();
							if (oit.hasNext())
								current = oit.next().iterator();
							else
								throw new NoSuchElementException();
						}
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}

			@Override
			public int size() {
				int result = 0;
				for (Collection<?> collection : collections)
					result += collection.size();
				return result;
			}

			@Override
			public int unionSize() {
				return collections.size();
			}

			@Override
			public boolean contains(T t) {
				for (Collection<?> collection : collections) {
					if (collection.contains(t))
						return true;
				}
				return false;
			}
		};
	}

	/**
	 * Use this method to save some allocations of iterators (instead of calling
	 * {@link #ofMany(Collection)}) when the outer list has a constant-time
	 * {@link List#get(int)} method.
	 * 
	 * @param collections
	 * @return The union of {@code collections}.
	 */
	public static <T> Union<T> ofLists(final List<? extends Collection<T>> collections) {
		if (collections.size() == 1)
			return ofOne(collections.get(0));

		return new Union<T>() {

			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {

					private final int usz = collections.size();
					private int i = 0;
					private Iterator<T> now = null;

					@Override
					public boolean hasNext() {
						if (now != null && now.hasNext())
							return true;
						if (now != null)
							i++;
						while (i < usz) {
							final Collection<T> collec = collections.get(i);
							if (!collec.isEmpty()) {
								now = collec.iterator();
								return true;
							}
							i++;
						}
						return false;
					}

					@Override
					public T next() {
						if (now != null && now.hasNext())
							return now.next();
						if (now != null)
							i++;
						while (i < usz) {
							now = collections.get(i).iterator();
							if (now.hasNext())
								return now.next();
							i++;
						}
						throw new NoSuchElementException();
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}

			@Override
			public int size() {
				final int usz = unionSize();
				int result = 0;
				for (int i = 0; i < usz; i++)
					result += collections.get(i).size();
				return result;
			}

			@Override
			public int unionSize() {
				return collections.size();
			}

			@Override
			public boolean contains(T t) {
				final int usz = unionSize();
				for (int i = 0; i < usz; i++) {
					if (collections.get(i).contains(t))
						return true;
				}
				return false;
			}
		};
	}

	/**
	 * Adds {@code u}'s elements to {@code c}.
	 * 
	 * @param u
	 * @param c
	 */
	public static <T> void pourInto(Union<T> u, Collection<T> c) {
		for (T t : u)
			c.add(t);
	}

	/**
	 * Adds {@code u}'s elements to {@code c}, exception {@code exception}.
	 * 
	 * @param u
	 * @param exception
	 * @param useEqualEqual
	 * @param c
	 */
	public static <T> void pourIntoExcept(Union<T> u, T exception, boolean useEqualEqual, Collection<T> c) {
		for (T t : u) {
			if (!com.hgames.lib.Objects.equals(t, exception, useEqualEqual))
				c.add(t);
		}
	}
}
