package com.hgames.lib.log;

import java.io.PrintStream;

/**
 * An implementation of {@link ILogger} that is suitable for desktop
 * applications.
 * 
 * @author smelC
 */
public class SystemLogger implements ILogger {

	@Override
	public void debugLog(String tag, String s) {
		outLog(tag, s);
	}

	@Override
	public void infoLog(String tag, String s) {
		outLog(tag, s);
	}

	@Override
	public void warnLog(String tag, String s) {
		outLog(tag, s);
	}

	@Override
	public void errLog(String tag, String s) {
		errLog0(tag, s, null);
	}

	@Override
	public void errLog(String tag, String s, Throwable t) {
		errLog0(tag, s, t);
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
}
