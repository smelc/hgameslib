package com.hgames.lib.collection.multiset;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * A multiset, i.e. a collection that can have an element multiple time, and
 * keep track of its frequency in a smart manner. It is specialized for
 * enumerations.
 * 
 * <p>
 * This class can be used to represent stack of items. In
 * {@code Dungeon Mercenary}, this class is used to represent stacks of potions,
 * bombs, and runics: there is an instance of this class for potions (the enum
 * covering the kind of potions), an instance for bombs, etc.
 * </p>
 * 
 * @author smelC
 * 
 * @param <T>
 */
public class EnumMultiset<T extends Enum<T>> implements Collection<T>, Serializable {

	/** InvariantS: all values are non-null and greater than 0 */
	protected final EnumMap<T, Integer> map;
	/** The sum of {@link #map}'s values. Could be transient (TODO). */
	protected int size;

	private static final long serialVersionUID = -3597349071602560131L;

	/**
	 * An empty multiset.
	 * 
	 * @param clazz
	 *            {@code T}'s {@link Class} object.
	 */
	public EnumMultiset(Class<T> clazz) {
		this.map = new EnumMap<T, Integer>(clazz);
	}

	/**
	 * @param clazz
	 * @return A fresh empty instance.
	 */
	public static <T extends Enum<T>> EnumMultiset<T> noneOf(Class<T> clazz) {
		return new EnumMultiset<T>(clazz);
	}

	/**
	 * @param t
	 * @return The number of times {@code t} appears in {@code this}.
	 */
	public int count(T t) {
		final Integer value = map.get(t);
		return value == null ? 0 : value;
	}

	/**
	 * @return The elements whose {@link #count(Enum)} is greater than 0.
	 */
	public Set<T> keySet() {
		return map.keySet();
	}

	/**
	 * Adds {@code t} {@code count} times.
	 * 
	 * @param t
	 * @param count
	 */
	public void multiAdd(T t, int count) {
		for (int i = 0; i < count; i++)
			add(t);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		final Integer count = map.get(o);
		if (count == null)
			return false;
		assert 0 < count;
		return 0 < count;
	}

	@Override
	public Iterator<T> iterator() {
		final Iterator<T> base = map.keySet().iterator();
		return new Iterator<T>() {

			int curCount = -1;
			T current = null;

			@Override
			public boolean hasNext() {
				return current != null || base.hasNext();
			}

			@Override
			public T next() {
				if (current != null) {
					assert 0 < curCount;
					curCount--;
					final T result = current;
					if (curCount == 0)
						current = null;
					return result;
				} else {
					if (base.hasNext()) {
						current = base.next();
						final T result = current;
						curCount = count(result);
						assert 0 < curCount;
						curCount--;
						if (curCount == 0)
							current = null;
						return result;
					} else
						throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				// TODO Could be implemented..
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public Object[] toArray() {
		final Object[] result = new Object[size];
		int i = 0;
		for (T key : map.keySet()) {
			Integer count = map.get(key);
			assert count != null;
			if (count == null)
				continue;
			assert 0 < count;
			while (0 < count) {
				result[i++] = key;
				count--;
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <U> U[] toArray(U[] a) {
		final U[] filled;
		if (size <= a.length)
			filled = a;
		else
			// TODO Implement me in a GWT-compatible manner
			throw new UnsupportedOperationException();
		final Iterator<T> it = iterator();
		int i = 0;
		while (it.hasNext())
			filled[i++] = (U) it.next();
		while (i < size)
			filled[i++] = null;
		return filled;
	}

	@Override
	public boolean add(T e) {
		if (e == null)
			throw new NullPointerException();
		final Integer count = map.get(e);
		if (count == null)
			map.put(e, 1);
		else
			map.put(e, count + 1);
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		final Integer count = map.get(o);
		if (count == null)
			return false;
		if (count == 0)
			return false;
		final Integer less = count - 1;
		if (less == 0)
			map.remove(o);
		else
			map.put((T) o, less);
		size--;
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean result = false;
		for (T t : c)
			result |= add(t);
		return result;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean result = false;
		for (Object t : c)
			result |= remove(t);
		return result;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		final Iterator<T> it = map.keySet().iterator();
		boolean change = false;
		while (it.hasNext()) {
			final T next = it.next();
			Integer v = map.get(next);
			if (v == null)
				continue;
			assert 0 < v;
			if (0 == v)
				continue;
			map.remove(next);
			change |= true;
		}
		return change;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append("{");
		final Iterator<T> it = keySet().iterator();
		while (it.hasNext()) {
			final T next = it.next();
			final Integer count = count(next);
			assert count != null && 0 < count;
			if (count == null || 0 == count)
				continue;
			result.append(" ");
			result.append(next.toString());
			result.append("->");
			result.append(count);
		}
		result.append("}");
		return result.toString();
	}
}
