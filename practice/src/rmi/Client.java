package rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
	
	public static void main(String[] args) {
		
		String host = (args.length < 1) ? null : args[0];
		System.out.println("Connecting " + host);
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			System.out.println("Connected to" + host);
			System.out.println(registry);
			Hello stub = (Hello) registry.lookup("Hello");
			String response = stub.sayHello();
			System.err.println("response: " + response);
		}
		catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
		}
		
	}
}
