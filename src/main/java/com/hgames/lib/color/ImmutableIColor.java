package com.hgames.lib.color;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * An immutable implementation of {@link IColor}.
 * 
 * @author smelC
 * @see MutableIColor
 */
public final class ImmutableIColor extends SkeletalColor {

	protected final int red;
	protected final int green;
	protected final int blue;
	protected final int alpha;

	private static final long serialVersionUID = 6831015499731312699L;

	/**
	 * An opaque color.
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 */
	public ImmutableIColor(int red, int green, int blue) {
		this(red, green, blue, 255);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 */
	public ImmutableIColor(int red, int green, int blue, int alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	/**
	 * @param other
	 */
	public ImmutableIColor(IColor other) {
		this(other.getRed(), other.getGreen(), other.getBlue(), other.getAlpha());
	}

	/**
	 * @param r
	 * @param g
	 * @param b
	 * @return A fresh opaque color.
	 */
	public static IColor newOpaque(int r, int g, int b) {
		return new ImmutableIColor(r, g, b, 255);
	}

	/**
	 * @param i
	 * @return A fresh uniform opaque color.
	 */
	public static IColor newUniformOpaque(int i) {
		return new ImmutableIColor(i, i, i, 255);
	}

	/**
	 * @param c
	 * @param alpha
	 * @return A copy of {@code c} where alpha was set to {@code alpha}.
	 */
	public static IColor setAlpha(IColor c, int alpha) {
		return new ImmutableIColor(c.getRed(), c.getGreen(), c.getBlue(), alpha);
	}

	/**
	 * @param c
	 * @param alpha
	 * @return A copy of {@code c} where alpha was modified by {@code alpha}.
	 */
	public static IColor addAlpha(IColor c, int alpha) {
		return new ImmutableIColor(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha() + alpha);
	}

	/**
	 * @param color
	 * @param amount
	 * @return A variant of {@code color} moved towards black by {@code amount}.
	 */
	public static/* @Nullable */IColor blackify(/* @Nullable */ IColor color, int amount) {
		if (color == null)
			return null;
		else {
			int decrease = amount;
			final int r = color.getRed();
			final int g = color.getGreen();
			final int b = color.getBlue();
			decrease = r == 0 ? decrease : Math.min(decrease, r);
			decrease = g == 0 ? decrease : Math.min(decrease, g);
			decrease = b == 0 ? decrease : Math.min(decrease, b);
			return new ImmutableIColor(r - decrease, g - decrease, b - decrease, color.getAlpha());
		}
	}

	/**
	 * @param color
	 * @param amount
	 * @return A variant of {@code color} moved towards white by {@code amount}.
	 */
	public static IColor whiteify(IColor color, int amount) {
		if (color == null)
			return null;
		else {
			int increase = amount;
			final int r = color.getRed();
			final int g = color.getGreen();
			final int b = color.getBlue();
			increase = Math.min(255 - r, amount);
			increase = Math.min(increase, Math.min(255 - g, amount));
			increase = Math.min(increase, Math.min(255 - b, amount));
			assert r + increase < 256;
			assert g + increase < 256;
			assert b + increase < 256;
			return new ImmutableIColor(r + increase, g + increase, b + increase);
		}
	}

	/**
	 * @param cs
	 * @param amount
	 * @return The iteration of {@link #whiteify(IColor, int)} to {@code cs}.
	 */
	public static ArrayList<IColor> whiteify(Collection<? extends IColor> cs, int amount) {
		final ArrayList<IColor> result = new ArrayList<IColor>(cs.size());
		for (IColor c : cs)
			result.add(whiteify(c, amount));
		return result;
	}

	/**
	 * @param cs
	 * @return The mean of {@code cs}.
	 */
	public static/* @Nullable */IColor mean(/* @Nullable */ IColor... cs) {
		if (cs == null)
			return null;

		int nb = 0;

		int rs = 0;
		int gs = 0;
		int bs = 0;
		int as = 0;

		for (IColor c : cs) {
			if (c != null) {
				rs += c.getRed();
				gs += c.getGreen();
				bs += c.getBlue();
				as += c.getAlpha();
				nb++;
			}
		}

		return nb == 0 ? null : new ImmutableIColor(rs / nb, gs / nb, bs / nb, as / nb);
	}

	/**
	 * @param colors
	 * @return The mean of {@code colors}.
	 */
	public static/* @Nullable */IColor mean(/* @Nullable */ List<? extends IColor> colors) {
		if (colors == null)
			return null;

		int nb = 0;

		int rs = 0;
		int gs = 0;
		int bs = 0;
		int as = 0;

		final int bound = colors.size();
		for (int i = 0; i < bound; i++) {
			final IColor c = colors.get(i);
			if (c != null) {
				rs += c.getRed();
				gs += c.getGreen();
				bs += c.getBlue();
				as += c.getAlpha();
				nb++;
			}
		}

		return nb == 0 ? null : new ImmutableIColor(rs / nb, gs / nb, bs / nb, as / nb);
	}

	/**
	 * @param l
	 * @param lweight
	 *            The weight of {@code l} in the mean.
	 * @param r
	 * @param rweight
	 *            The weight of {@code r} in the mean.
	 * @return The weighted mean of {@code l} and {@code r}.
	 */
	public static IColor weightedMean(/* @Nullable */ IColor l, int lweight, /* @Nullable */ IColor r,
			int rweight) {
		if (l == null)
			return r;
		if (r == null)
			return l;
		final int sum = lweight + rweight;
		final int red = ((l.getRed() * lweight) + (r.getRed() * rweight)) / sum;
		final int green = ((l.getGreen() * lweight) + (r.getGreen() * rweight)) / sum;
		final int blue = ((l.getBlue() * lweight) + (r.getBlue() * rweight)) / sum;
		final int alpha = ((l.getAlpha() * lweight) + (r.getAlpha() * rweight)) / sum;
		return new ImmutableIColor(red, green, blue, alpha);
	}

	/**
	 * @param c
	 * @param r
	 * @param g
	 * @param b
	 * @param alpha
	 * @return The color {@code c} to which r, g, b, and alpha were pointwise
	 *         added.
	 */
	public static IColor clampedAddition(IColor c, int r, int g, int b, int alpha) {
		return new ImmutableIColor(Colors.clampComponent(c.getRed() + r),
				Colors.clampComponent(c.getGreen() + g), Colors.clampComponent(c.getBlue() + b),
				Colors.clampComponent(c.getAlpha() + alpha));
	}

	/**
	 * @param start
	 * @param end
	 * @param nb
	 *            The desired gradient's size.
	 * @return The gradient from {@code start} to {@code end}.
	 */
	public static IColor[] gradient(IColor start, IColor end, int nb) {
		final IColor[] result = new IColor[nb];
		result[0] = start;
		final int rdiff = (end.getRed() - start.getRed()) / (nb - 2);
		final int gdiff = (end.getGreen() - start.getGreen()) / (nb - 2);
		final int bdiff = (end.getBlue() - start.getBlue()) / (nb - 2);
		final int adiff = (end.getAlpha() - start.getAlpha()) / (nb - 2);
		for (int i = 1; i < nb - 1; i++)
			result[i] = clampedAddition(result[i - 1], rdiff, gdiff, bdiff, adiff);
		result[nb - 1] = end;
		return result;
	}

	@Override
	public int getRed() {
		return red;
	}

	@Override
	public int getGreen() {
		return green;
	}

	@Override
	public int getBlue() {
		return blue;
	}

	@Override
	public int getAlpha() {
		return alpha;
	}

}