package com.hgames.lib.color;

/**
 * Utility methods about {@link IColor}.
 * 
 * @author smelC
 */
public class Colors {

	/** The black color */
	public static final IColor BLACK = new ImmutableIColor(0, 0, 0);
	/** The white color */
	public static final IColor WHITE = new ImmutableIColor(255, 255, 255);

	/** The red color */
	public static final IColor RED = new ImmutableIColor(255, 0, 0);
	/** The green color */
	public static final IColor GREEN = new ImmutableIColor(0, 255, 0);
	/** The blue color */
	public static final IColor BLUE = new ImmutableIColor(0, 0, 255);

	/**
	 * @param i
	 * @return {@code i} clamped to [0, 255].
	 */
	public static int clampComponent(int i) {
		if (i < 0)
			return 0;
		else if (255 < i)
			return 255;
		else
			return i;
	}

}
