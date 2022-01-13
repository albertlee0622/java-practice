package rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {
	
	public Server() {}

	public String sayHello() {
		return "Hello from Server";
	}
	
	public static void main(String[] args) {
		
		Server obj = new Server();
		try {
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 1100);
			Registry registry = LocateRegistry.getRegistry(1099);
			System.out.println(registry);
			registry.bind("//192.168.1.166:1099", stub);
			
			System.out.println("Server ready");
		}
		catch (Exception e) {
			System.out.println("Server exception: " + e.toString());
		}

	}

}
