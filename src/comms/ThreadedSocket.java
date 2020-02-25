package comms;

import java.io.IOException;
import java.net.Socket;

public class ThreadedSocket {
	private Thread t = null;
	private ThreadedSocketWrapper socket = null;
	
	public ThreadedSocket(Socket socket) {
		this.socket = new ThreadedSocketWrapper(socket);
		t = new Thread(this.socket);
	}
	
	public void start() {
		t.start();
	}
	
	public void stop() {
		socket.stop();
	}
	
	public void writeMessage(String message) throws IOException {
		socket.writeMessage(message);
	}
	
	public String readMessage() {
		return socket.readMessage();
	}
}
