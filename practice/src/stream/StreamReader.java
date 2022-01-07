package stream;

import java.io.*;

public class StreamReader {
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input = br.readLine();
		System.out.println("Input : " + input);
		
		FileWriter fw = new FileWriter("./testCopy.txt", false);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(input);
//		fw.flush();
		bw.close();
		fw.close();
	}

}
