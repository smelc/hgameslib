package com.hgames.lib;

/**
 * Utility methods about {@link Object}s.
 * 
 * @author smelC
 */
public class Objects {

	/**
	 * @param obj
	 * @return {@code obj} if not null.
	 * @throws NullPointerException
	 *             If {@code obj} is null.
	 */
	public static <T> T checkNotNull(T obj) {
		if (obj == null)
			throw new NullPointerException();
		return obj;
	}

	/**
	 * @param o1
	 * @param o2
	 * @param useEqualEqual
	 * @return Whether {@code o1 == o2} or {@code o1.equals(o2)}.
	 */
	public static boolean equals(Object o1, Object o2, boolean useEqualEqual) {
		if (useEqualEqual)
			return o1 == o2;
		else if (o1 == null)
			return o2 == null;
		else
			return o1.equals(o2);
	}

}
