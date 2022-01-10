package networking;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 3000);
		InputStreamReader keyboard = new InputStreamReader(System.in);
		BufferedReader keyboardReader = new BufferedReader(keyboard);
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		
		while(true) {
			System.out.print("Message: ");
			String message = keyboardReader.readLine();
			pw.println(message);
			pw.flush();
			System.out.println("Your message is " + br.readLine());
		}
	}
}