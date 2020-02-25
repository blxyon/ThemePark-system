package comms;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TerminalClient {
	private ThreadedSocket socket = null;
	
	public TerminalClient() {
		
	}
	
	public void connect(String host, int port) throws UnknownHostException, IOException {
		socket = new ThreadedSocket(new Socket(host, port));
		socket.start();
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
