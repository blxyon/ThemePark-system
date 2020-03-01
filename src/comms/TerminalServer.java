package comms;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TerminalServer {
	private ThreadedServerSocket serverSocket = null;
	private int port;
	
	private boolean running;
	
	public TerminalServer(int port) {
		this.port = port;
		try {
			serverSocket = new ThreadedServerSocket(new ServerSocket(this.port));
		} catch (IOException e) {
			System.out.println("Could not open server socket");
			System.out.println(e);
			
		}
	}
	
	public ClientTerminal getClient() {
		Socket newSocket = serverSocket.getClient();
		if (newSocket == null) {
			return null;
		}
		ThreadedSocket newClient = new ThreadedSocket(newSocket);
		newClient.start();
		return new ClientTerminal(newClient);
	}
	
	public void start() {
		running = true;
		serverSocket.start();
	}
	
	public void stop() {
		if (running) {
			running = false;
			cleanup();
		}
	}
	
	private void cleanup() {
		serverSocket.stop();
	}
}
