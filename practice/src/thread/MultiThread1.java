package thread;

public class MultiThread1 extends Thread {
	int n = 10;
	int[] numbers;
	char[] letters;
	
	public MultiThread1() {
		super();
		numbers = new int[n];
		letters = new char[n];
		
		for(int i = 97, j = 0; j < n; i++, j++) {
			numbers[j] = j;
			letters[j] = (char)i;
		}
	}

	public void doA() {
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doB() {
		for(int i = 0; i < letters.length; i++) {
			System.out.print(letters[i] + ", ");
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		doA();
	}
	
	public static void main(String[] args) {
		MultiThread1 mt1 = new MultiThread1();
		mt1.start();
		mt1.doB();

	}

}
