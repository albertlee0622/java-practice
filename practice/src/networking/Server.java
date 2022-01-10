package networking;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private ArrayList<Echo> echos;
	
	public Server() {
		super();
		echos = new ArrayList<Echo>();
	}

	private class Echo extends Thread {
		private Socket socket;
		private InputStream is;
		private InputStreamReader isr;
		private BufferedReader br;
		private OutputStream os;
		private PrintWriter pw;
		
		public Echo(Socket socket) {
			super();
			this.socket = socket;
			try {
				is = socket.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				
				os = socket.getOutputStream();
				pw = new PrintWriter(os);
			}
			catch (IOException e) {
				close();
				e.printStackTrace();
			}
		}
		
		private void close() {
			try {
				br.close();
				isr.close();
				is.close();
				pw.close();
				os.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					String s = br.readLine();
					if(s != null) {
						pw.println(s);
						pw.flush();
					}
				}
				catch (IOException e) {
					close();
					e.printStackTrace();
				}
			}
		}
	}
	
	private void startServer(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port, 5, InetAddress.getByName("localhost"));
			while(true) {
				System.out.println("Listening...");
				Socket socket = serverSocket.accept();
				System.out.println("Connected with " + socket.getPort());
				Echo echo = new Echo(socket);
				echo.start();
				echos.add(echo);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.startServer(3000);
	}
}
