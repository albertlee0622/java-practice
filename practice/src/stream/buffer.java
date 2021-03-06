package stream;

import java.io.BufferedReader; //buffer is a temporary repository in memory
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffer {
	
	public static void main (String[] args) throws IOException {
		FileReader fr = new FileReader("./test.txt");
		FileWriter fw = new FileWriter("./testCopy.txt", false);
		
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String s = null;
		
		while((s = br.readLine()) != null) {
			bw.write(s);
			bw.newLine();
		}
		
		br.close();
		bw.close();
		fr.close();
		fw.close();
	}

}
