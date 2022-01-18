package util;

	import java.io.*;
	import java.util.Date;
	
public class Log {
	public String logFile = "connection-pool.log";
	FileWriter fw = null;
	public static final String LINE_SEPARATOR = System.lineSeparator();
	
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
	
	public void close(FileWriter fw) {
		try {
			fw.close();
		} catch (IOException e) {}
	}
	
	public void debug(String msg) {
		try {
			fw.write(new java.util.Date() + " : ");
			fw.write(msg + LINE_SEPARATOR);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void out(String msg) {
		System.out.println(new Date() + ": " + msg);
	}
	
	public static void err(Throwable e, String msg) {
		System.err.println(new Date() + ": " + msg);
		e.printStackTrace(System.out);
	}
}
