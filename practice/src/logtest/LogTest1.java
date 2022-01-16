package logtest;

public class LogTest1 {
	
	public void xxx() {
		Log log = new Log();
		log.debug("로그 테스트!");
		
		log.close();
	}
	
	public static void main(String[] args) {
		LogTest1 test = new LogTest1();
		test.xxx();
	}
}
