package comms;

import java.io.IOException;
import java.util.LinkedList;

import mainMenu.swapManagament.Swap;

public class ClientTerminal {
	private String name;
	private ThreadedSocket socket = null;
	private LinkedList<String> currentUsers = null;
	private boolean running;
	
	private SwapParser swapParser;
	
	public ClientTerminal(ThreadedSocket socket) {
		this.socket = socket;
		currentUsers = new LinkedList<String>();
		swapParser = new SwapParser();
		
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
		if (!running)
			return null;
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
			message = socket.readMessage();
		}
		return remainingMessages;
	}
	
	public void sendSwap(Swap swap) {
		String swapString = swapParser.turnToString(swap);
		try {
			socket.writeMessage(swapString);
		} catch (IOException e) {
			System.out.println("Connection lost with terminal \"" + name + "\"");
			stop();
			return;
		}
	}
	
	public void sendAlert(String alert) {
		try {
			socket.writeMessage("alert," + alert);
		} catch (IOException e) {
			System.out.println("Connection lost with terminal \"" + name + "\"");
			stop();
			return;
		}
	}
	
	private void stop() {
		running = false;
		socket.stop();
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public String getName() {
		return name;
	}
}
