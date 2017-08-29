package com.hgames.lib;

/**
 * A stopwatch. It doesn't use {@code System.nanoTime()} which isn't
 * GWT-compatible.
 * 
 * @author smelC
 */
public class Stopwatch {

	private long start;

	/**
	 * A fresh instance that starts now.
	 */
	public Stopwatch() {
		this.start = System.currentTimeMillis();
	}

	/**
	 * @return The duration since the creation or the last call to
	 *         {@link #reset()}.
	 */
	public long getDuration() {
		return System.currentTimeMillis() - start;
	}

	/**
	 * Resets this stopwatch's starting time.
	 */
	public void reset() {
		this.start = System.currentTimeMillis();
	}

	/**
	 * Prints this watch's duration to {@link System#out}.
	 */
	public void print() {
		System.out.println(System.currentTimeMillis() - start + "ms");
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " started at " + start;
	}
}
