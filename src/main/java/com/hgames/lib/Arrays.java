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

}
