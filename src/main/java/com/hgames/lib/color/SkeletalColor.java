package com.hgames.lib.color;

/**
 * Skeletal implementation, for code sharing.
 * 
 * @author smelC
 */
public abstract class SkeletalColor implements IColor {

	private static final long serialVersionUID = -8789187762716680995L;

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append(getRed());
		result.append(',');
		result.append(getGreen());
		result.append(',');
		result.append(getBlue());
		if (255 != getAlpha()) {
			result.append(',');
			result.append(getAlpha());
		}
		return result.toString();
	}

}
