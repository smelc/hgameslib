package com.hgames.lib;

/**
 * @author smelC
 * @param <T>
 */
public interface Predicate<T> {

	/**
	 * @param t
	 * @return true if the predicate holds on {@code t}
	 */
	public boolean apply(T t);

}
