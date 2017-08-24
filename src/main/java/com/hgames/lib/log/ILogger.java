package com.hgames.lib.log;

/**
 * An interface for logging.
 * 
 * @author smelC
 */
public interface ILogger {

	/**
	 * Logs a debug message.
	 * 
	 * @param tag
	 *            The message's category
	 * @param s
	 *            The message
	 */
	public void debugLog(String tag, String s);

	/**
	 * Logs an information message.
	 * 
	 * @param tag
	 *            The message's category
	 * @param s
	 */
	public void infoLog(String tag, String s);

	/**
	 * Logs a warning message.
	 * 
	 * @param tag
	 *            The message's category
	 * @param s
	 */
	public void warnLog(String tag, String s);

	/**
	 * Logs an error message.
	 * 
	 * @param tag
	 *            The message's category
	 * @param s
	 */
	public void errLog(String tag, String s);

	/**
	 * Logs an error message.
	 * 
	 * @param tag
	 *            The message's category
	 * @param s
	 * @param t
	 *            The cause of the error
	 */
	public void errLog(String tag, String s, /* @Nullable */ Throwable t);

}
