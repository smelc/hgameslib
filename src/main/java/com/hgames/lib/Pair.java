package com.hgames.lib;

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
	 * @param t
	 * @param u
	 * @return A fresh pair {@code (t, u)}.
	 */
	public static <T, U> Pair<T, U> of(T t, U u) {
		return new Pair<>(t, u);
	}

	@Override
	public String toString() {
		return "(" + fst + "," + snd + ")";
	}

}
