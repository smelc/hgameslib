package com.hgames.lib.collection.array;

/**
 * An interface for clients of arrays that cannot build them (for example
 * because the type is UI while the client isn't).
 * 
 * <b>Never implement me with something stateful, i.e. do not reuse another
 * object for convenience.</b>
 * 
 * @author smelC
 * @param <T>
 */
public interface ArrayBuilder<T> {

	/**
	 * @param length
	 * @return An array of length {@code length}.
	 */
	public T[] build(int length);

	/**
	 * @param width
	 * @param height
	 * @param shallow
	 *            true to avoid allocating the sub arrays.
	 * @return A 2D array of size {@code width x height}.
	 */
	public T[][] build(int width, int height, boolean shallow);

}
