package comms;

import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedServerSocket {
	private Thread t = null;
	private ThreadedServerSocketWrapper socket = null;
	
	public ThreadedServerSocket(ServerSocket socket) {
		this.socket = new ThreadedServerSocketWrapper(socket);
		t = new Thread(this.socket);
	}
	
	public void start() {
		t.start();
	}
	
	public void stop() {
		socket.stop();
	}
	
	public Socket getClient() {
		return socket.getClient();
	}
}
