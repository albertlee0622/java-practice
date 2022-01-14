import java.io.*;

public class Memo {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			isr.close();
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
