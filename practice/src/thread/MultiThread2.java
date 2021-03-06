package thread;

public class MultiThread2 implements Runnable {
	/**
	 * 클래스가 이미 다른 클래스를 상속하고 있을 때 주로 사용
	 */
	int n = 10;
	int[] numbers;
	char[] letters;
	
	public MultiThread2() {
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
		MultiThread2 mt2 = new MultiThread2();
		Thread t = new Thread(mt2);
		t.start();
		mt2.doB();

	}

}
