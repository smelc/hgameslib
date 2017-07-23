package com.hgames.lib;

/**
 * @author smelC
 */
public class Ints {

	/**
	 * @param lowerBound
	 * @param i
	 * @param upperBound
	 * @return Whether {@code lowerBound <= i && i <= upperBound}.
	 */
	public static boolean inInterval(int lowerBound, int i, int upperBound) {
		return lowerBound <= i && i <= upperBound;
	}

}
