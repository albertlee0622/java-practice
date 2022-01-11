package networking;

import java.io.*;
import java.util.ArrayList;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread {
	Socket socket;
	
	InputStream is;
	InputStreamReader isr;
	BufferedReader br;
	
	InputStreamReader keyboard;
	BufferedReader keyboardReader;
	
	OutputStream os;
	PrintWriter pw;
	
	public Client() {
		super();
		try {
			socket = new Socket("127.0.0.1", 3000);
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			keyboard = new InputStreamReader(System.in);
			keyboardReader = new BufferedReader(keyboard);
			
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
		}
		catch (IOException e) {
			e.printStackTrace();
			close();
		}
	}
	
	private void close() {
		try {
			br.close();
			isr.close();
			is.close();
			socket.close();
			keyboardReader.close();
			keyboard.close();
			pw.close();
			os.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			close();
		}
	}
	
	private void receiveMessage() {
		while(true) {
			try {
				String s = br.readLine();
				if(s != null) {
					System.out.println(s);
				}
			}
			catch (IOException e) {
				e.printStackTrace();
				close();
				break;
			}
		}
	}
	
	private void sendMessage() {
		while(true) {
			try {
				String s = null;
				if((s = keyboardReader.readLine()) != null) {
					pw.println(s);
					pw.flush();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
				close();
				break;
			}
		}
	}

	@Override
	public void run() {
		receiveMessage();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.start();
		client.sendMessage();
	}
}