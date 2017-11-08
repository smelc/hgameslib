package com.hgames.lib;

/**
 * Utility methods pertaining to arrays.
 * 
 * @author smelC
 */
public class Arrays {

	/**
	 * @param ts
	 * @param searched
	 * @return Whether {@code ts} contains {@code searched}.
	 */
	public static boolean contains(/* @Nullable */ char[] ts, char searched) {
		if (ts == null)
			return false;
		for (char c : ts) {
			if (c == searched)
				return true;
		}
		return false;
	}

	/**
	 * @param ts
	 * @param t
	 * @param useEqualEqual
	 * @return true if {@code ts} contains {@code t}.
	 */
	public static <T> boolean contains(/* @Nullable */ T[] ts, /* @Nullable */ T t, boolean useEqualEqual) {
		if (ts == null)
			return false;
		for (T in : ts) {
			if (Objects.equals(in, t, useEqualEqual))
				return true;
		}
		return false;
	}

	/**
	 * @param array
	 * @param x
	 * @param y
	 * @return The value at {@code array[x][y]} if valid, or null.
	 */
	public static <T> /* @Nullable */ T getIfValid(/* @Nullable */ T[][] array, int x, int y) {
		if (array == null)
			return null;
		if (array.length <= x)
			return null;
		final T[] ts = array[x];
		if (ts == null)
			return null;
		if (ts.length <= y)
			return null;
		return ts[y];
	}

	/**
	 * Substitutes every occurrence of {@code inThere} by {@code novel} in
	 * {@code array}.
	 * 
	 * @param array
	 * @param inThere
	 * @param novel
	 * @param useEqualEqual
	 * @return The number of replacements made.
	 */
	public static <T> int replaceAll(/* @Nullable */ T[] array, T inThere, T novel, boolean useEqualEqual) {
		if (array == null)
			return 0;
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (Objects.equals(array[i], inThere, useEqualEqual)) {
				array[i] = novel;
				result++;
			}
		}
		return result;
	}

}
