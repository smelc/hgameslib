package com.hgames.lib;

/**
 * Utilities regarding exceptions.
 * 
 * @author smelC
 */
public class Exceptions {

	/**
	 * @param e
	 * @return An exception stating that {@code e} is unmatched.
	 */
	public static IllegalStateException newUnmatchedISE(Enum<?> e) {
		return new IllegalStateException("Unmatched value: " + e);
	}

}
