package stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class stream {
	public static void main(String[] args) throws IOException{
		System.out.println(System.getProperty("user.dir"));
		int n = 0;
		FileInputStream fis = new FileInputStream("C:/Users/alee8/eclipse-workspace/practice/test.txt");
		FileOutputStream fos = new FileOutputStream("C:/Users/alee8/eclipse-workspace/practice/testCopy.txt", false);
		
		while((n = fis.available()) > 0) {
			byte[] b  = new byte[n];
			int result = fis.read(b);
			if(result == -1) {
				break;
			}
			fos.write(b);
		}
		fis.close();
		fos.close();
	}
}
