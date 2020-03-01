package comms;

import java.util.LinkedList;

public class ClientTerminal {
	private String name;
	private ThreadedSocket socket = null;
	private LinkedList<String> currentUsers = null;
	private boolean running;
	
	public ClientTerminal(ThreadedSocket socket) {
		this.socket = socket;
		currentUsers = new LinkedList<String>();
		
		if (!connectionHandshake()) {
			System.out.println("Failed connection handshake");
			return;
		}
		running = true;
	}
	
	private boolean connectionHandshake() {
		String message = socket.readMessage();
		if (message == null) {
			return false;
		}
		String[] elements = message.split(",");
		
		if (elements[0] != "terminal") {
			return false;
		}
		name = elements[1];
		return true;
	}
	
	public LinkedList<String> processMessages() {
		LinkedList<String> remainingMessages = new LinkedList<String>();
		String message = socket.readMessage();
		while (message != null) {
			String[] elements = message.split(",");
			if (elements[0] == "login" ) {
				currentUsers.add(elements[1]);
			} else if (elements[0] == "logout") {
				currentUsers.remove(elements[1]);
			} else {
				remainingMessages.add(message);
			}
		}
		return remainingMessages;
	}
}
