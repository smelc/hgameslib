package com.hgames.lib.sum;

import java.io.Serializable;

/**
 * An object containing an object of type T or an object of type T.
 * Intentionally not {@link Serializable}.
 * 
 * @author smelC
 * @param <T>
 *            The left type
 * @param <U>
 *            The righttype
 */
public class Sum<T, U> {

	/** Keeping a boolean instead of a Class<?> */
	protected final boolean isLeft;
	protected final Object delegate;

	private Sum(boolean left, Object o) {
		this.isLeft = left;
		this.delegate = o;
	}

	/**
	 * @param t
	 * @return A left sum.
	 */
	public static <T, U> Sum<T, U> createLeft(T t) {
		return new Sum<T, U>(true, t);
	}

	/**
	 * @param u
	 * @return A right sum.
	 */
	public static <T, U> Sum<T, U> createRight(U u) {
		return new Sum<T, U>(false, u);
	}

	/**
	 * @return true if it's a left sum.
	 */
	public boolean isLeft() {
		return isLeft;
	}

	/**
	 * @return true if it's a right sum.
	 */
	public boolean isRight() {
		return !isLeft;
	}

	/**
	 * @return The underlying object.
	 */
	@SuppressWarnings("unchecked")
	public T getLeft() {
		if (isLeft)
			return (T) delegate;
		else
			throw new IllegalStateException("Sum is right");
	}

	/**
	 * @return The underlying object.
	 */
	@SuppressWarnings("unchecked")
	public U getRight() {
		if (!isLeft)
			return (U) delegate;
		else
			throw new IllegalStateException("Sum is left");
	}

	@Override
	public String toString() {
		return delegate == null ? "null" : delegate.toString();
	}
}
