package com.hgames.lib;

/**
 * A reference to some object.
 * 
 * @author smelC
 * @param <T>
 */
/* Please do not make me Serializable, I REALLY shouldn't be */
public final class ByRef<T> {

	protected /* @Nullable */ T ref;

	/**
	 * A fresh instance.
	 * 
	 * @param t
	 */
	public ByRef(/* @Nullable */ T t) {
		this.ref = t;
	}

	/**
	 * @param t
	 * @return A reference to {@code t}.
	 */
	public static <T> ByRef<T> make(/* @Nullable */ T t) {
		return new ByRef<T>(t);
	}

	/**
	 * Sets the reference to {@code t}.
	 * 
	 * @param t
	 */
	public void set(/* @Nullable */ T t) {
		ref = t;
	}

	/**
	 * @return The value given at construction-time or at the last call to
	 *         {@link #set(Object)}.
	 */
	public T get() {
		return ref;
	}

	@Override
	public String toString() {
		return ref == null ? "null" : ref.toString();
	}
}
