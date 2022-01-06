package stream;

import java.io.FileReader;
import java.io.FileWriter;

public class reader {

	public static void main(String[] args) throws Exception {
		int n = 0;
		FileReader fr = new FileReader("./test.txt");
		FileWriter fw = new FileWriter("./testCopy.txt", false);
		
		while((n = fr.read()) != -1) {
			System.out.println(n);
			fw.write(n);
		}
		
		fr.close();
		fw.close();
	}

}
