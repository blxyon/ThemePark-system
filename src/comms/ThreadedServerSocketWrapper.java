package comms;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadedServerSocketWrapper implements Runnable{
	private ServerSocket socket;
	
	private BlockingQueue<Socket> sockets = null;
	
	private boolean running;
	
	public ThreadedServerSocketWrapper(ServerSocket socket) {
		this.socket = socket;
		
		sockets = new LinkedBlockingQueue<Socket>();
	}
	
	public void run() {
		running = true;
		while (running) {
			acceptClient();
		}
	}
	
	private void acceptClient() {
		try {
			Socket newClient = socket.accept();
			sockets.add(newClient);
		} catch (IOException e) {
			System.out.println("Error accepting a new client");
			System.out.println(e);
		}
	}
	
	public Socket getClient() {
		if (sockets.isEmpty()) {
			return null;
		}
		return sockets.remove();
	}
	
	public void stop() {
		running = false;
		cleanup();
	}
	
	public boolean isRunning() {
		return running;
	}
	
	private void cleanup() {
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("Error closing server socket");
			System.out.println(e);
		}
	}
}
