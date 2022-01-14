package rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RMIClientSocketFactory;

public class Server implements Hello {
	
	public Server() {}

	public String sayHello() {
		return "Hello from Server";
	}
	
	public static void main(String[] args) {
		
		String host = "192.168.1.166";
		Server obj = new Server();
		try {
			SocketServer ssf = new SocketServer();
			SocketClient csf = new SocketClient();	
			
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 3002);
			Registry registry = LocateRegistry.createRegistry(1099, csf, ssf);
			System.out.println(registry);
			registry.bind("//192.168.1.166:1099", stub);
			
			System.out.println("Server ready");
		}
		catch (Exception e) {
			System.out.println("Server exception: " + e.toString());
		}

	}

}
