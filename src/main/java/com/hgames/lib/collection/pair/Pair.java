package com.hgames.lib.collection.pair;

import java.io.Serializable;

/**
 * A typed pair.
 * 
 * @author smelC
 * 
 * @param <T>
 * @param <U>
 */
public class Pair<T, U> implements Serializable {

	/** The pair's first member */
	public final T fst;
	/** The pair's second member */
	public final U snd;

	private static final long serialVersionUID = -52634301496734462L;

	/**
	 * A fresh pair {@code (t, u)}.
	 * 
	 * @param t
	 * @param u
	 */
	public Pair(T t, U u) {
		this.fst = t;
		this.snd = u;
	}

	/**
	 * @return The left (first) element.
	 */
	public T getFst() {
		return fst;
	}

	/**
	 * @return The right (second) element.
	 */
	public U getSnd() {
		return snd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fst == null) ? 0 : fst.hashCode());
		result = prime * result + ((snd == null) ? 0 : snd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Pair<?, ?> other = (Pair<?, ?>) obj;
		if (fst == null) {
			if (other.fst != null)
				return false;
		} else if (!fst.equals(other.fst))
			return false;
		if (snd == null) {
			if (other.snd != null)
				return false;
		} else if (!snd.equals(other.snd))
			return false;
		return true;
	}

	/**
	 * @param t
	 * @param u
	 * @return A fresh pair {@code (t, u)}.
	 */
	public static <T, U> Pair<T, U> of(T t, U u) {
		return new Pair<T, U>(t, u);
	}

	@Override
	public String toString() {
		return "(" + fst + "," + snd + ")";
	}

}
