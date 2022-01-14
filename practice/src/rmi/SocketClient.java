package rmi;

import java.rmi.server.RMIClientSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient implements RMIClientSocketFactory {
	public Socket createSocket(String host, int port) throws IOException {
		return new Socket(host, port);
	}
}
