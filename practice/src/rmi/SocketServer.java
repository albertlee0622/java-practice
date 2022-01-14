package rmi;

import java.rmi.server.RMIServerSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class SocketServer implements RMIServerSocketFactory {
	public ServerSocket createServerSocket(int port) throws IOException {
		InetAddress ia = InetAddress.getByName("192.168.1.166");
		return new ServerSocket(port, 5, ia);
	}
}
