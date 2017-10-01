package com.hgames.lib;

/**
 * @author smelC
 */
public class Ints {

	/**
	 * @param lowerBound
	 * @param i
	 * @param upperBound
	 * @return {@code i} clamped in {@code [lowerBound, upperBound]}.
	 */
	public static int clamp(int lowerBound, int i, int upperBound) {
		if (i < lowerBound)
			return lowerBound;
		if (upperBound < i)
			return upperBound;
		return i;
	}

	/**
	 * @param lowerBound
	 * @param i
	 * @param upperBound
	 * @return Whether {@code lowerBound <= i && i <= upperBound}.
	 */
	public static boolean inInterval(int lowerBound, int i, int upperBound) {
		return lowerBound <= i && i <= upperBound;
	}

	/**
	 * @param i
	 * @return Whether {@code i} is even.
	 */
	public static boolean isEven(int i) {
		return i % 2 == 0;
	}

	/**
	 * @param i
	 * @return Whether {@code i} is odd.
	 */
	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}

}
