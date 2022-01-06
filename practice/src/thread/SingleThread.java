package thread;

public class SingleThread {
	int n = 10;
	int[] numbers;
	char[] letters;
	
	public SingleThread() {
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
		}
	}
	
	public void doB() {
		for(int i = 0; i < letters.length; i++) {
			System.out.print(letters[i] + ", ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleThread st = new SingleThread();
		st.doA();
		st.doB();
		System.out.println(Character.toChars(97));
	}

}
