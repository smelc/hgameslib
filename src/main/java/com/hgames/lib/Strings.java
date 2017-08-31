package com.hgames.lib;

import java.util.Collection;
import java.util.Iterator;

/**
 * Utility methods pertaining to {@link String}s.
 * 
 * @author smelC
 */
public class Strings {

	/**
	 * @param operands
	 * @param joiner
	 * @return {@code operands[0].toString() + joiner + ... + operands[operands.size() - 1].toString()}
	 */
	public static String join(Collection<?> operands, String joiner) {
		final int sz = operands.size();
		switch (sz) {
		case 0:
			return "";
		case 1:
			return operands.iterator().next().toString();
		default:
			final StringBuilder builder = new StringBuilder(sz * 8);
			final Iterator<?> it = operands.iterator();
			while (it.hasNext()) {
				builder.append(it.next().toString());
				if (it.hasNext())
					builder.append(joiner);
			}
			return builder.toString();
		}
	}

	/**
	 * @param c
	 * @return The plural suffix for an English noun
	 */
	public static String plural(int c) {
		return c == 1 ? "" : "s";
	}

}
