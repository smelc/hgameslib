package com.hgames.lib.color;

import java.io.Serializable;

/**
 * An interface for colors that know how to represent themselves in the 0
 * (inclusive) 256 (exclusive) range.
 * 
 * @author smelC
 */
public interface IColor extends Serializable {

	/**
	 * @return The red component.
	 */
	public int getRed();

	/**
	 * @return The green component.
	 */
	public int getGreen();

	/**
	 * @return The blue component.
	 */
	public int getBlue();

	/**
	 * @return The transparency component.
	 */
	public int getAlpha();

}
