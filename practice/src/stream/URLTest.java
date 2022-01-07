package stream;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	
	public static void main(String[] args) {
		String url = "http://www.java-school.net";
		String file = "index.html";
		InputStream in = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		
		try {
			in = (new URL(url)).openStream();
			br = new BufferedReader(new InputStreamReader(in));
			fos = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			String str = null;
			while((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
			}
		}
		catch (MalformedURLException mue) {
			mue.printStackTrace();
		}
		catch (IOException ie) {
			ie.printStackTrace();
		}
		finally {
			if(br != null) {
				try {
					br.close();
				}
				catch (IOException ie) {
					ie.printStackTrace();
				}
			}
			if(bw != null) {
				try {
					bw.close();
				}
				catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		}
	}
}
