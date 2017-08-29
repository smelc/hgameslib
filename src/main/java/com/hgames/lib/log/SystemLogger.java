package com.hgames.lib.log;

import java.io.PrintStream;

/**
 * An implementation of {@link ILogger} that is suitable for desktop
 * applications.
 * 
 * @author smelC
 */
public class SystemLogger implements ILogger {

	protected final boolean debug;
	protected final boolean info;
	protected final boolean warn;
	protected final boolean err;

	/** A logger that does nothing. */
	public static final SystemLogger NOP = new SystemLogger(false, false, false, false);

	/**
	 * @param debug
	 *            Whether debug logging is enabled.
	 * @param info
	 *            Whether info logging is enabled.
	 * @param warn
	 *            Whether warning logging is enabled.
	 * @param err
	 *            Whether error logging is enabled.
	 */
	public SystemLogger(boolean debug, boolean info, boolean warn, boolean err) {
		this.debug = debug;
		this.info = info;
		this.warn = warn;
		this.err = err;
	}

	@Override
	public void debugLog(String tag, String s) {
		if (debug)
			outLog(tag, s);
	}

	@Override
	public void infoLog(String tag, String s) {
		if (info)
			outLog(tag, s);
	}

	@Override
	public void warnLog(String tag, String s) {
		if (warn)
			outLog(tag, s);
	}

	@Override
	public void errLog(String tag, String s) {
		if (err)
			errLog0(tag, s, null);
	}

	@Override
	public void errLog(String tag, String s, Throwable t) {
		if (err)
			errLog0(tag, s, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return debug;
	}

	@Override
	public boolean isInfoEnabled() {
		return info;
	}

	@Override
	public boolean isWarnEnabled() {
		return warn;
	}

	@Override
	public boolean isErrEnabled() {
		return err;
	}

	protected void outLog(String tag, String s) {
		log(System.out, tag, s);
	}

	protected void errLog0(String tag, String s, /* @Nullable */ Throwable t) {
		log(System.err, tag, s);
		if (t != null)
			t.printStackTrace(System.err);
	}

	protected void log(PrintStream stream, String tag, String s) {
		stream.println(tag == null ? "" : (tag + ": ") + (s == null ? "null" : s));
	}

	@Override
	public String toString() {
		return "debug=" + debug + " info=" + info + " warn=" + warn + " err=" + err;
	}
}
