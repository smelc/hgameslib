package com.hgames.lib.color;

/**
 * A mutable implementation of {@link IColor}.
 * 
 * @author smelC
 * @see ImmutableIColor
 */
public class MutableIColor extends SkeletalColor {

	protected int red;
	protected int green;
	protected int blue;
	protected int alpha;

	private static final long serialVersionUID = 7824265553970930623L;

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 */
	public MutableIColor(int red, int green, int blue, int alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @return A fresh instance.
	 */
	public static MutableIColor create(int red, int green, int blue, int alpha) {
		return new MutableIColor(red, green, blue, alpha);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @return A fresh uniform color.
	 */
	public static MutableIColor createOpaque(int red, int green, int blue) {
		return new MutableIColor(red, green, blue, 255);
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

	/**
	 * Mutes {@code this} so that it becomes equal to {@code other}.
	 * 
	 * @param other
	 */
	public void copy(IColor other) {
		setRed(other.getRed());
		setGreen(other.getGreen());
		setBlue(other.getBlue());
		setAlpha(other.getAlpha());
	}

	/**
	 * @param red
	 */
	public void setRed(int red) {
		this.red = red;
	}

	/**
	 * @param green
	 */
	public void setGreen(int green) {
		this.green = green;
	}

	/**
	 * @param blue
	 */
	public void setBlue(int blue) {
		this.blue = blue;
	}

	/**
	 * @param alpha
	 */
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

}
