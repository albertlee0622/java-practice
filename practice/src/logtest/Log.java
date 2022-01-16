package logtest;

import java.io.*;
import java.util.Date;

public class Log {
	public String logFile = "test1.log";
	private static final String LINE_SEPARATOR = System.lineSeparator();
	FileWriter fw = null;
	
	public Log() {
		try {
			fw = new FileWriter(logFile, true);
		} catch (IOException e) {}
	}
	
	public void close() {
		try {
			fw.close();
		} catch (IOException e) {}
	}
	
	public void debug(String msg) {
		try {
			fw.write(new Date() + " : ");
			fw.write(msg + LINE_SEPARATOR);
			fw.flush();
		} catch (IOException e) {
			System.err.println("IOException!");
		}
	}
}
